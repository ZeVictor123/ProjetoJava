package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Aluno;
import view.Palco;


public class CadastroController implements Initializable {

    @FXML private TextField textNome;
    @FXML private TextField textNumero;
    @FXML private RadioButton rbM;
    @FXML private RadioButton rbF;
    @FXML private RadioButton rbI;
    @FXML private Label infor;
    
    @FXML
    public void salvar(){
        Aluno a = new Aluno();
        try{
            a.setNome(textNome.getText());
            if(!a.getNome().isEmpty()){
                a.setNumero(Integer.parseInt(textNumero.getText()));
                if(rbM.isSelected()){
                    a.setSexo('M');
                }else if(rbF.isSelected()){
                    a.setSexo('F');
                }else if(rbI.isSelected()){
                    a.setSexo('I');
                }
                try {
                    a.addAluno(a);
                    limpar();
                    infor.setText("Cadastrado com Sucesso");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao Cadastrar-se\n-Número pode já está Cadastrado\n-Nome inválido\n-Sexo não Selecionado");
                }
            }else{
                JOptionPane.showMessageDialog(null, "O Nome não pode estar vazio");
            }
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Erro em algum(uns) dos Campos");
        }
        
    }
    
    @FXML
    public void volta(){
        infor.setText("");
    }
    
    public void limpar(){
        textNome.setText("");
        textNumero.setText("");
        rbF.setSelected(false);
        rbM.setSelected(false);
        rbI.setSelected(false);
    }
    
        @FXML
    void home() {
        Palco.homeScene();
    }

    @FXML
    void pesquisar() {
        Palco.pesquisaScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
}
