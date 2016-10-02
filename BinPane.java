package cs1302.calc;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

/** 
 * creates 62 bitLabels and puts them in one pane. Also marks the bits at 
 * certain points for the user's ease. 
 **/
public class BinPane extends FlowPane{

    int index = 63;
    BitLabel[] bitArray = new BitLabel[63];
    Label resultLabel;

    public BinPane(Driver d){

	super(10, 10);

	resultLabel = d.resultLabel;

	for(int i = 0; i < 63; i++){

	    bitArray[i] = new BitLabel(i, resultLabel);
	}//for BitLabels

	Label l63 = new Label("63   ");
	l63.setStyle("-fx-text-fill: blue");
	Label l31 = new Label("31   ");
	l31.setStyle("-fx-text-fill: blue");
	Label l47 = new Label("47   ");
	l47.setStyle("-fx-text-fill: blue");
	Label l15 = new Label("15   ");
	l15.setStyle("-fx-text-fill: blue");
	Label l32 = new Label("            32");
	l32.setStyle("-fx-text-fill: blue");
	Label l0 = new Label("             0");
	l0.setStyle("-fx-text-fill: blue");

	VBox vb6360 = new VBox();
	HBox hb6360 = new HBox();
	hb6360.getChildren().addAll(new Label("  "), bitArray[62], bitArray[61], bitArray[60]);
	HBox hb3128 = new HBox();
	hb3128.getChildren().addAll(bitArray[31], bitArray[30], bitArray[29], bitArray[28]);
	vb6360.getChildren().addAll(hb6360, l63, hb3128, l31);

	VBox vb5956 = new VBox();
	HBox hb5956 = new HBox();
	hb5956.getChildren().addAll(bitArray[59], bitArray[58], bitArray[57], bitArray[56]);
	HBox hb2724 = new HBox();
	hb2724.getChildren().addAll(bitArray[27], bitArray[26], bitArray[25], bitArray[24]);
	vb5956.getChildren().addAll(hb5956, new Label("    "), hb2724, new Label("    "));

	VBox vb5552 = new VBox();
	HBox hb5552 = new HBox();
	hb5552.getChildren().addAll(bitArray[55], bitArray[54], bitArray[53], bitArray[52]);
	HBox hb2320 = new HBox();
	hb2320.getChildren().addAll(bitArray[23], bitArray[22], bitArray[21], bitArray[20]);
	vb5552.getChildren().addAll(hb5552, new Label("    "), hb2320, new Label("    "));

	VBox vb5148 = new VBox();
	HBox hb5148 = new HBox();
	hb5148.getChildren().addAll(bitArray[51], bitArray[50], bitArray[49], bitArray[48]);
	HBox hb1916 = new HBox();
	hb1916.getChildren().addAll(bitArray[19], bitArray[18], bitArray[17], bitArray[16]);
	vb5148.getChildren().addAll(hb5148, new Label("    "), hb1916, new Label("    "));

	VBox vb4744 = new VBox();
	HBox hb4744 = new HBox();
	hb4744.getChildren().addAll(bitArray[47], bitArray[46], bitArray[45], bitArray[44]);
	HBox hb1512 = new HBox();
	hb1512.getChildren().addAll(bitArray[15], bitArray[14], bitArray[13], bitArray[12]);
	vb4744.getChildren().addAll(hb4744, l47, hb1512, l15);

	VBox vb4340 = new VBox();
	HBox hb4340 = new HBox();
	hb4340.getChildren().addAll(bitArray[43], bitArray[42], bitArray[41], bitArray[40]);
	HBox hb1108 = new HBox();
	hb1108.getChildren().addAll(bitArray[11], bitArray[10], bitArray[9], bitArray[8]);
	vb4340.getChildren().addAll(hb4340, new Label("    "), hb1108, new Label("    "));

	VBox vb3936 = new VBox();
	HBox hb3936 = new HBox();
	hb3936.getChildren().addAll(bitArray[39], bitArray[38], bitArray[37], bitArray[36]);
	HBox hb0704 = new HBox();
	hb0704.getChildren().addAll(bitArray[7], bitArray[6], bitArray[5], bitArray[4]);
	vb3936.getChildren().addAll(hb3936, new Label("    "), hb0704, new Label("     "));

	VBox vb3532 = new VBox();
	HBox hb3532 = new HBox();
	hb3532.getChildren().addAll(bitArray[35], bitArray[34], bitArray[33], bitArray[32]);
	HBox hb0300 = new HBox();
	hb0300.getChildren().addAll(bitArray[3], bitArray[2], bitArray[1], bitArray[0]);
	vb3532.getChildren().addAll(hb3532, l32, hb0300, l0);

	getChildren().addAll(vb6360, vb5956, vb5552, vb5148, vb4744, vb4340, vb3936, vb3532);
    }//BinPane

    /**
     * changes the bitLabels according to new results from user input
     **/
    public void update(int result){
	String s = Integer.toBinaryString(result);

	for(int i = s.length()-1, j = 0; i >= 0; i--, j++){

	    bitArray[j].setText("" + s.charAt(i));
	}//for

	if(s.length() < 63){
	    for(int i = s.length(); i < 63; i++){

		bitArray[i].setText("0");
	    }//for
	}//if 
    }//update
}//BinPane