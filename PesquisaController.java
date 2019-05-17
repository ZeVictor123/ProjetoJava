
package controller;

import dao.AlunoDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Aluno;
import view.Palco;
import static view.Palco.pesquisa;


public class PesquisaController implements Initializable {
    
    
    @FXML
    private TableView<Aluno> tabela;

    @FXML
    private TableColumn<Aluno, Character> csexo;

    @FXML
    private TableColumn<Aluno, String> cnome;

    @FXML
    private TableColumn<Aluno, Integer> cnumero;

    @FXML
    void home() {
        Palco.homeScene();
    }

    @FXML
    void cadastrar(){
        Palco.cadastroScene();
    }
    
    @FXML
    void atualizar() {
        initTable();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
    }
    
    protected void initTable(){
        try {
            csexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
            cnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            cnumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
            
            ArrayList<Aluno> a = AlunoDAO.pesquisarAll();//Exeção
            
            tabela.setItems(FXCollections.observableArrayList(a));
        } catch (SQLException ex) {}
        
    }
    
   
}
