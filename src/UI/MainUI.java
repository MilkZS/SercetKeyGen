package UI;

import RSA.RSAGenSercet;
import RSA.RSAbean;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MainUI extends Application {
    @FXML
    public Button bt_start;
    @FXML
    public TextField priTextField;
    @FXML
    public TextField pubTextField;
    public ChoiceBox choseMode;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("密钥生成器");
        primaryStage.show();
    }

    @FXML
    protected void startToGenSecret(){
        RSAbean rsAbean = new RSAbean();
        RSAGenSercet.exportKey(rsAbean,RSAGenSercet.BASE64);
        priTextField.setText(rsAbean.getPriKey());
        pubTextField.setText(rsAbean.getPubKey());
    }

}
