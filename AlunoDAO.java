package dao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Aluno;

public class AlunoDAO {
    
    public static void addBanco(Aluno aluno) throws SQLException{
        Connection con = abrir();
        
        String sql = "insert into alunos(numero, nome, sexo) values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, aluno.getNumero());
        ps.setString(2, aluno.getNome());
        ps.setString(3, String.valueOf(aluno.getSexo()));
        ps.execute();
        
        fechar(con);
    }
    
    public static ArrayList<Aluno> pesquisarAll() throws SQLException{
        Connection con = abrir();
        
        String sql = "select * from alunos";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet r = ps.executeQuery();
        
        ArrayList<Aluno> list = new ArrayList<>();
        
        while(r.next()){
            Aluno a = new Aluno();
            a.setNome(r.getString("nome"));
            a.setNumero(r.getInt("numero"));
            a.setSexo(r.getString("sexo").charAt(0));
            list.add(a);
        }
        
        fechar(con);
        
        return list;
    }
    
    public static void pesquisarOne(int num) throws SQLException{
        Connection con = abrir();
        
        String sql = "select * from alunos where numero = " + num;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet r = ps.executeQuery();
        
        fechar(con);
    }
    
    
    
    public static void deletar(int num) throws SQLException{
        Connection con = abrir();
        
        String sql = "delete from alunos where numero = " + num;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        
        fechar(con);
    }
    
    public static void atualizar(int num, String nom) throws SQLException{
        Connection con = abrir();
        
        String sql = "update alunos set nome = ? where numero = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nom);
        ps.setInt(2, num);
        ps.executeUpdate();
        
        fechar(con);
    }
    
    public static Connection abrir(){
        try {
            Connection con = (Connection) Conexao.abrirConexao();
            return con;
        }catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
    public static void fechar(Connection con){
        try {
            Conexao.fecharConecxao(con);
        } catch (SQLException ex) {}
    }
    
    
    
    
}
