package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection abrirConexao() throws ClassNotFoundException, SQLException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/informatica_2";
        con = DriverManager.getConnection(url, "root", "");
        return con;
    }
    public static void fecharConecxao(Connection con) throws SQLException{
        con.close();
    }
}
