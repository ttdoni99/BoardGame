package Javafx;

import Game.Player;
import Game.Puppet;
import Game.World;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {


    private boolean player1;
    private boolean player2;
    private World world;
    private Button[][] buttons;

    @FXML
    private GridPane gridPane;


    public  void click(ActionEvent actionEvent){
        World world;
        int xSelection = GridPane.getRowIndex((Node) actionEvent.getSource());
        int ySelection = GridPane.getColumnIndex((Node) actionEvent.getSource());
        System.out.println(xSelection+" "+ySelection);

        world = new World(4, 10);
        initButtons();


    }

    private void initButtons() {
        for (int i = 0; i < world.fields.length; i++) {
            for (int j = 0; j < world.fields[0].length; j++) {
                buttons[i][j] = (Button)gridPane.getChildren().get(i + (j * world.fields.length - 1));
            }
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void forwardButtonPress(ActionEvent actionEvent) {
    }

    public void leftButtonPress(ActionEvent actionEvent) {
    }

    public void rightButtonPress(ActionEvent actionEvent) {
    }
}
