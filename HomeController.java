package controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import view.Palco;



public class HomeController implements Initializable {
    
    
    @FXML
    void cadastrar() {
        Palco.cadastroScene();
    }

    @FXML
    void pesquisar() {
        Palco.pesquisaScene();
    }

    
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
