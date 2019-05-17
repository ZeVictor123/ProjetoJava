package model;

import dao.AlunoDAO;
import java.sql.SQLException;

public class Aluno {
    private String nome;
    private char sexo;
    private int numero;
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public char getSexo(){
        return sexo;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void addAluno(Aluno a) throws SQLException{
        AlunoDAO dao = new AlunoDAO();
        dao.addBanco(a);
    }
}
