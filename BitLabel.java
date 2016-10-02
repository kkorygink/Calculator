package cs1302.calc;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * creates a label to represent one bit and assigns it an appropriate EventHandler
 **/
public class BitLabel extends Label{

    int i;
    Label resultLabel;
   
    public BitLabel(int pos, Label resultLabel){

	super("0");

	setFont(new Font(24));
	i = pos;
	this.resultLabel = resultLabel;

	this.setOnMouseClicked(new BitHandler(this, resultLabel));
    }//BitLabel

}//Label