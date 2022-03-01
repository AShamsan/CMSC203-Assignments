


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author AShamsan
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a text field
	Button bHello;
	Button bHowdy;
	Button bChinese;
	Button bGerman;
	Button bClear;
	Button bExit;
	Label lFeedback;
	TextField tField;
	//  declare two HBoxes
	HBox hBox1;
	HBox hBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dM;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and text field
		//  instantiate the HBoxes
		hBox1 = new HBox();
		hBox2 = new HBox();
		
		bHello = new Button("Hello");
		bHowdy = new Button("Howdy");
		bChinese = new Button("Chinese");
		bGerman = new Button("German");
		bClear = new Button("Clear");
		bExit = new Button("Exit");
		lFeedback = new Label("Feedback");
		tField = new TextField();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dM = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(bHello, new Insets(5));
	    HBox.setMargin(bHowdy, new Insets(5));
	    HBox.setMargin(bChinese, new Insets(5));
	    HBox.setMargin(bGerman, new Insets(5));
	    HBox.setMargin(bClear, new Insets(5));
	    HBox.setMargin(bExit, new Insets(5));
	    
	    
	    hBox1.setAlignment(Pos.CENTER);
	    hBox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and text field to one of the HBoxes
	    hBox1.getChildren().addAll(bHello, bHowdy, bChinese, bGerman, bClear, bExit);
	    
	    //  add the buttons to the other HBox
	    hBox2.getChildren().addAll(lFeedback, tField);
	    
	    //  add the HBoxes to this FXMainPanel (a VBox)
	    getChildren().addAll(hBox1,hBox2);
	    
	    bHello.setOnAction(new ButtonHandler());
	    bHowdy.setOnAction(new ButtonHandler());
	    bChinese.setOnAction(new ButtonHandler());
	    bGerman.setOnAction(new ButtonHandler());
	    bClear.setOnAction(new ButtonHandler());
	    bExit.setOnAction(new ButtonHandler());
	    
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{
	
	public void handle(ActionEvent event)
	{
		if (event.getTarget() == bHello)
		{
			tField.setText(dM.getHello());
		} 
		
		else if (event.getTarget() == bHowdy) 
		{
			tField.setText(dM.getHowdy());
		} 
		
		else if (event.getTarget() == bChinese) 
		{
			tField.setText(dM.getChinese());
		} 
		
		else if (event.getTarget() == bGerman) 
		{
			tField.setText(dM.getGerman());
		} 
		
		else if(event.getTarget() == bClear) 
		{
			tField.setText("");
		} 
		
		else if (event.getTarget() == bExit) 
		{
			Platform.exit();
			System.exit(0);
		}
	}
	}
}
