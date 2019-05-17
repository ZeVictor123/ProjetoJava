package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.Palco;

public class LoginController implements Initializable {

        @FXML
    private PasswordField passSenha;

    @FXML
    private TextField txtUsuario;
    
    @FXML 
    public void enviar(){
        if ("12345678".equals(passSenha.getText()) && "Victor".equals(txtUsuario.getText())) {
            Palco.homeScene();
            passSenha.setText("");
            txtUsuario.setText("");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
