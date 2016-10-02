package cs1302.calc;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;

public class Driver extends Application {

    Label userLabel = new Label("");
    Label resultLabel = new Label("");

    BinPane binPane = new BinPane(this);
    CalcBox calcBox = new CalcBox(this);
   
    boolean isRecursive = false;

    public static void main(String[] args) {
        launch(args);
    } // main
    
    @Override
    public void start(Stage primaryStage) {

	primaryStage.setResizable(false);

	userLabel.setPrefSize(600, 100);
	userLabel.setStyle("-fx-border-color: white; -fx-background-color: white;");
	userLabel.setTextAlignment(TextAlignment.RIGHT);
	userLabel.setFont(new Font(24));
	userLabel.setPadding(new Insets(0, 10, 0, 10));

	resultLabel.setPrefSize(600, 100);
	resultLabel.setStyle("-fx-border-color: white; -fx-background-color: white;");
	resultLabel.setTextAlignment(TextAlignment.RIGHT);
	resultLabel.setFont(new Font(48));


	VBox root = new VBox();
	root.setPadding(new Insets(10));

	/*	try {
	    root = FXMLLoader.load(getClass().getResource("/calc.fxml"));
	} catch (IOException e) {
	    System.out.println(e);
	    System.exit(1);
	    } // try */


	VBox textBox = new VBox();
	textBox.getChildren().addAll(userLabel, resultLabel);

	//	calcBox.

        primaryStage.setTitle("Calculator FX!");
	primaryStage.setScene(new Scene(root, 610, 600));
	primaryStage.sizeToScene();

	root.getChildren().addAll(textBox, binPane, calcBox);

        primaryStage.show();

    } // start

} // Driver


