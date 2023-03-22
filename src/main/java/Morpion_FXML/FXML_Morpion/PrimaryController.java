package Morpion_FXML.FXML_Morpion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryController implements Initializable {

	@FXML
    private void btnEntity() throws IOException {
    	System.out.println("PvE");
    }
	
	@FXML
    private void btnPlayer() throws IOException {
    	System.out.println("PvP");
    }
	
	@FXML
    private void btnSave() throws IOException {
    	System.out.println("Save succeed.");
    }
	
	 @FXML
	 private Button button1;

	 @FXML
	 private Button button2;

	 @FXML
	 private Button button3;
	 
	 @FXML
	 private Button button4;
	 
	 @FXML
	 private Button button5;
	 
	 @FXML
	 private Button button6;
	 
	 @FXML
	 private Button button7;
	 
	 @FXML
	 private Button button8;
	 
	 @FXML
	 private Button button9;

	 @FXML
	 private Label winnerText;

	 private int playerTurn = 0;

	 ArrayList<Button> buttons;

	 
	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
	     buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

	     buttons.forEach(button ->{
	         setupButton(button);
	         button.setFocusTraversable(false);
	     });
	 }

	 @FXML
	 void restartGame(ActionEvent event) {
	     buttons.forEach(this::resetButton);
	     winnerText.setText("Morpion");
	 }

	 public void resetButton(Button button){
	     button.setDisable(false);
	     button.setText("");
	 }

	 private void setupButton(Button button) {
	     button.setOnMouseClicked(mouseEvent -> {
	         setPlayerSymbol(button);
	         button.setDisable(true);
	         checkIfGameIsOver();
	     });
	 }
	 
	 public void setPlayerSymbol(Button button){
	     if(playerTurn % 2 == 0){
	         button.setText("X");
	         playerTurn = 1;
	     } else {
	         button.setText("O");
	         playerTurn = 0;
	     }
	 }
	 
	 public void checkIfGameIsOver(){
	        for (int a = 0; a < 8; a++) {
	        	String result;
	            String line = switch (a) {
	                case 0 -> result = button1.getText() + button2.getText() + button3.getText();
	                	
	                case 1 ->
	                	result = button4.getText() + button5.getText() + button6.getText();
	                	
	                case 2 ->
	                	result = button7.getText() + button8.getText() + button9.getText();
	                	
	                case 3 ->
	                	result = button1.getText() + button5.getText() + button9.getText();
	                	
	                case 4 ->
	                	result = button3.getText() + button5.getText() + button7.getText();
	                	
	                case 5 ->
	                	result = button1.getText() + button4.getText() + button7.getText();
	                	
	                case 6 ->
	                	result = button2.getText() + button5.getText() + button8.getText();
	                	
	                case 7 ->
	                	result = button3.getText() + button6.getText() + button9.getText();
	                	
	                default ->
	                	result = null;
	                	
	            };
	            
		      if (line.equals("XXX")) {
		          winnerText.setText("X Gagne !");
		      }

		      else if (line.equals("OOO")) {
		          winnerText.setText("O Gagne !");
		      }
		      
		  }
	 }            
}          
