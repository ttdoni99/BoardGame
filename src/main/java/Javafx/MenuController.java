package Javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable  {

        @FXML
        private Button startButton1;

        @FXML
        private void startButtonAction(ActionEvent event) throws Exception {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/game.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("BoardGame");
            stage.setResizable(false);
            stage.show();
        }

        @FXML
        private void exitButtonAction(ActionEvent event) {
            Platform.exit();
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }

    }

