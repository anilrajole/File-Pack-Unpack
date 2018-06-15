package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Created by Anil on 15/06/2018
 */
public class Pack {
    @FXML
    private Button pack, cancel,dname;
    @FXML
    private Label sname, warning;
    @FXML
    private TextField tname;



    @FXML
    private void initialize()
    {
        dname.setOnAction(event -> {
            warning.setText("");
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Select Directory to Pack");
            Stage stage = new Stage();
            File file = directoryChooser.showDialog(stage);
            if(file == null)
            {
            }
            else {
                sname.setText(file.getAbsolutePath());
            }
        });
        cancel.setOnAction(event -> {
            Parent root = null;
            try {
                root= FXMLLoader.load(Home.class.getResource("home.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage=new Stage();
            stage.setTitle("File Pack Unpack");
            stage.setScene(new Scene(root,550,350));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        });
        pack.setOnAction(event -> {
            if(sname.getText().equals(""))
            {
                warning.setText("Please select Directory..!!!");
            }
            else if(tname.getText().equals(""))
            {
                warning.setText("Please enter Target name..!!!");
            }
            else
            {
                warning.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("File Pack Successful");
                alert.setHeaderText(null);
                alert.setContentText("File Pack Successful\n Location :"+sname.getText()+"\\"+tname.getText());
                alert.showAndWait();
            }
        });
    }
}
