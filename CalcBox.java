package cs1302.calc;

import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.text.Font;

/**
 * creates all of the buttons on the calculator and defines their behavior
 **/
public class CalcBox extends FlowPane{

    Label userLabel;
    Label resultLabel; 
    boolean usingBinary;
    boolean isRecursive;

    public CalcBox(Driver d){

	super(5, 5);

	setMaxSize(600, 350);
	setPadding(new Insets(20, 0, 0, 10));

	userLabel = d.userLabel;

	resultLabel = d.resultLabel;

	isRecursive = false;
	usingBinary = true;

	Button num0 = new Button("0");
	num0.setOnAction(event -> userLabel.setText(userLabel.getText() + "0"));
	num0.setPrefSize(75, 75);
	num0.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num1 = new Button("1");
	num1.setOnAction(event -> userLabel.setText(userLabel.getText() + "1"));
	num1.setPrefSize(75, 75);
	num1.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num2 = new Button("2");
	num2.setOnAction(event -> userLabel.setText(userLabel.getText() + "2"));
	num2.setPrefSize(75, 75);
	num2.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num3 = new Button("3");
	num3.setOnAction(event -> userLabel.setText(userLabel.getText() + "3"));
	num3.setPrefSize(75, 75);
	num3.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");
		
	Button num4 = new Button("4");
	num4.setOnAction(event -> userLabel.setText(userLabel.getText() + "4"));
	num4.setPrefSize(75, 75);
	num4.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num5 = new Button("5");
	num5.setOnAction(event -> userLabel.setText(userLabel.getText() + "5"));
	num5.setPrefSize(75, 75);
	num5.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num6 = new Button("6");
	num6.setOnAction(event -> userLabel.setText(userLabel.getText() + "6"));
	num6.setPrefSize(75, 75);
	num6.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num7 = new Button("7");
	num7.setOnAction(event -> userLabel.setText(userLabel.getText() + "7"));
	num7.setPrefSize(75, 75);
	num7.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num8 = new Button("8");
	num8.setOnAction(event -> userLabel.setText(userLabel.getText() + "8"));
	num8.setPrefSize(75, 75);
	num8.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button num9 = new Button("9");
	num9.setOnAction(event -> userLabel.setText(userLabel.getText() + "9"));
	num9.setPrefSize(75, 75);
	num9.setStyle("-fx-font: 24 arial; -fx-base: burlywood;");

	Button equals = new Button("=");
	equals.setPrefSize(155, 75);
	equals.setStyle("-fx-font: 24 arial; -fx-base: green;");

	Stage errorStage = new Stage(StageStyle.UTILITY);
	errorStage.initModality(Modality.APPLICATION_MODAL);

	FlowPane errorRoot = new FlowPane(10, 10);
	Label errorLabel = new Label("Error!\nPlease enter a valid mathematical expression.");
	errorLabel.setFont(new Font(24));
	errorLabel.setStyle("-fx-font: 24 arial; -fx-background-colour: white; -fx-text-fill: red");
	errorRoot.getChildren().addAll(errorLabel);
	errorStage.setScene(new Scene(errorRoot));
	errorStage.setWidth(600);
	errorStage.setHeight(100);
	errorRoot.setPadding(new Insets(10));
	errorStage.setResizable(false);

	/*determines the result of user input using ReversePolishNotation and updates
	 *the binary appropriately
	 */
	equals.setOnAction(event -> {

		String expression = userLabel.getText();
		//String[] infix = String.split(expression);
		String [] infix = expression.split(" ");

		try{
		    String[] postfix = ReversePolishNotation.infixToPostfix(infix);

		    Math newMath;
		 
		    if(isRecursive){

			newMath = new RecursiveMath();
		    } else{

			newMath = new IterativeMath();
		    }//if isRecursive

		    int result = ReversePolishNotation.evaluate(newMath, postfix);
		    resultLabel.setText("" + result);

		    d.binPane.update(result);
		} catch(Exception e){

		    errorStage.show();
		}//try eval
	    });

	Button add = new Button("+");
	add.setOnAction(event -> userLabel.setText(userLabel.getText() + " + "));
	add.setPrefSize(75, 75);
	add.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button subtract = new Button("-");
	subtract.setOnAction(event -> userLabel.setText(userLabel.getText() + " - "));
	subtract.setPrefSize(75, 75);
	subtract.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button multiply = new Button("*");
	multiply.setOnAction(event -> userLabel.setText(userLabel.getText() + " * "));
	multiply.setPrefSize(75, 75);
	multiply.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button divide = new Button("/");
	divide.setOnAction(event -> userLabel.setText(userLabel.getText() + " / "));
	divide.setPrefSize(75, 75);
	divide.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button factorial = new Button("!");
	factorial.setOnAction(event -> userLabel.setText(userLabel.getText() + " ! "));
	factorial.setPrefSize(75, 75);
	factorial.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button exponent = new Button("^");
	exponent.setOnAction(event -> userLabel.setText(userLabel.getText() + " ^ "));
	exponent.setPrefSize(75, 75);
        exponent.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button back = new Button("<");
	back.setPrefSize(75, 75);
	back.setStyle("-fx-font: 24 arial; -fx-base: orange;");
	back.setOnAction(event -> {
		String text = userLabel.getText();
		
		if(text.length() > 0){
		    char c = text.charAt(text.length()-1);
		    if(Character.isWhitespace(c)){
			userLabel.setText(text.substring(0, text.length()-3));
		    } else{
			userLabel.setText(text.substring(0, text.length()-1));
		    }//if
		}//if isn't empty
	    });

	Button clear = new Button("X");
	clear.setStyle("-fx-font: 24 arial; -fx-base: red;");
	clear.setOnAction(event -> {
		userLabel.setText("");
		resultLabel.setText("");
		    });
	clear.setPrefSize(75, 75);

	Button lShift = new Button("<<");
	lShift.setOnAction(event -> userLabel.setText(userLabel.getText() + " << "));
	lShift.setPrefSize(75, 75);
	lShift.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button rShift = new Button(">>");
	rShift.setOnAction(event -> userLabel.setText(userLabel.getText() + " >> "));
	rShift.setPrefSize(75, 75);
	rShift.setStyle("-fx-font: 24 arial; -fx-base: lightseagreen;");

	Button recursion = new Button("Use Recursion");
	recursion.setStyle("-fx-font: 24 arial; -fx-base: yellow;");
	recursion.setPrefSize(235, 75);
	recursion.setOnAction(event -> {
		if(isRecursive){

		    isRecursive = false;
		    recursion.setText("Use Recursion");
		} else{

		    isRecursive = true;
		    recursion.setText("Use Iteration");
		}//if isRecursive
	    });

	Button binary = new Button("Hide Binary");	
	binary.setStyle("-fx-font: 24 arial; -fx-base: yellow;");
	binary.setPrefSize(235, 75);
	binary.setOnAction(event -> {

		if(usingBinary){

		    d.binPane.setVisible(false);
		    usingBinary = false;
		    binary.setText("Show Binary");
		} else{

		    d.binPane.setVisible(true);
		    usingBinary = true;
		    binary.setText("Hide Binary");
		}//if usingBinary
	    });

	getChildren().addAll(num7, num8, num9, divide, factorial, back, clear, 
			     num4, num5, num6, multiply, exponent, lShift, rShift, 
			     num1, num2, num3, subtract, recursion,
			     num0, equals, add, binary);
    }//CalcBox

}//CalcBox