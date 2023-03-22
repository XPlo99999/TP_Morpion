package Morpion_FXML.FXML_Morpion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Morpion extends Application {
    private static final int GRID_SIZE = 3;
    private static final int BUTTON_SIZE = 100;
    private static final String PLAYER_1 = "X";
    private static final String PLAYER_2 = "O";

    private String currentPlayer = PLAYER_1;
    private Button[][] buttons = new Button[GRID_SIZE][GRID_SIZE];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int i = 0; i < GRID_SIZE; i++) {
        	
            for (int j = 0; j < GRID_SIZE; j++) {
            	
                Button button = new Button();
                button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                
                button.setOnAction(e -> {
                	
                    if (button.getText().isEmpty()) {
                        button.setText(currentPlayer);
                        if (checkWin()) {
                            showAlert(currentPlayer + " a gagné !");
                            reset();
                        } else if (checkTie()) {
                            showAlert("Match nul !");
                            reset();
                        } else {
                            currentPlayer = currentPlayer.equals(PLAYER_1) ? PLAYER_2 : PLAYER_1;
                        }
                    }
                    
                });
                
                buttons[i][j] = button;
                gridPane.add(button, i, j);
            }
        }

        Scene scene = new Scene(gridPane, GRID_SIZE * BUTTON_SIZE, GRID_SIZE * BUTTON_SIZE);
        primaryStage.setTitle("Jeu du Morpion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    private boolean checkWin() {

        for (int i = 0; i < GRID_SIZE; i++) {
            if (buttons[i][0].getText().equals(currentPlayer) &&
                buttons[i][1].getText().equals(currentPlayer) &&
                buttons[i][2].getText().equals(currentPlayer)) {
                return true;
            }
        }

        for (int j = 0; j < GRID_SIZE; j++) {
            if (buttons[0][j].getText().equals(currentPlayer) &&
                buttons[1][j].getText().equals(currentPlayer) &&
                buttons[2][j].getText().equals(currentPlayer)) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(currentPlayer) &&
            buttons[1][1].getText().equals(currentPlayer) &&
            buttons[2][2].getText().equals(currentPlayer)) {
            return true;
        }
        
        if (buttons[0][2].getText().equals(currentPlayer) &&
            buttons[1][1].getText().equals(currentPlayer) &&
            buttons[2][0].getText().equals(currentPlayer)) {
            return true;
        }

        return false;
    }
    

    private boolean checkTie() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
        }
    }
            
    return true;
    
        }
        
		return false;
    }
    

    private void reset() {
    	currentPlayer = PLAYER_1;
    	for (int i = 0; i < GRID_SIZE; i++) {
    		for (int j = 0; j < GRID_SIZE; j++) {
    			buttons[i][j].setText("");
    		}
    	}
    }

    
    private void showAlert(String message) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information");
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.showAndWait();
		}
	}

