package cs1302.calc;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import java.lang.Math;

/**
 * provides functionality for BitLabels so that they will change when they 
 * are clicked on and so that the result number changes as well.
 **/
public class BitHandler implements EventHandler<MouseEvent>{

    BitLabel bit;
    Label resultLabel;

    public BitHandler(BitLabel bit, Label resultLabel){

	super();
	this.bit = bit;
	this.resultLabel = resultLabel;
    }//BitHandler

    public void handle(MouseEvent event){

	int currentResult = Integer.parseInt(resultLabel.getText());
	int factor;
	int exp = bit.i;

	BasicMath math = new BasicMath();
	factor = math.pow(2, exp);

	//here we determine by how much to change the result number
	if(bit.getText().compareTo("0") == 0){

	    bit.setText("1");

	    currentResult += factor;
	} else{
	    bit.setText("0");

	    currentResult -= factor;
	}//if number

	resultLabel.setText("" + currentResult);
    }//BitHandler
}//BitHandler