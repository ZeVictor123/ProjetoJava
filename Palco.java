package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Palco extends Application {

    public static Stage palco;
    
    public static Scene home;
    public static Scene cadastro;
    public static Scene pesquisa;
    public static Scene login;
    
    @Override
    public void start(Stage stage) throws IOException {

        palco = stage;

        Parent rootHome = FXMLLoader.load(getClass().getResource("Homee.fxml"));
        home = new Scene(rootHome, 776, 590);

        Parent rootCadastro = FXMLLoader.load(getClass().getResource("Cadastros.fxml"));
        cadastro = new Scene(rootCadastro, 776, 590);

        Parent rootPesquisa = FXMLLoader.load(getClass().getResource("Pesquisas.fxml"));
        pesquisa = new Scene(rootPesquisa, 776, 590);

        Parent rootLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        login = new Scene(rootLogin, 776, 590);

        stage.setTitle("Biblioteca");
        stage.setResizable(false);
        stage.setScene(login);
        stage.show();

            
    }
    
    public static void homeScene(){
        palco.setScene(home);
    }
    
    public static void cadastroScene(){
        palco.setScene(cadastro);
    }
    
    public static void pesquisaScene(){
        palco.setScene(pesquisa);
    }
    
    public static void loginScene(){
        palco.setScene(login);
    }

    public static void main(String[] args) {
        launch(args);
    }


   
    
}
