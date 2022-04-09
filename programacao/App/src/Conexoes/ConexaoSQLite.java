
package Conexoes;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fagner Silva
 */
public class ConexaoSQLite {

    private Connection conexao;

    public boolean conectar() {

        try {

            String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db";

            this.conexao = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("conectou");
        return true;
    }

    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("desconectou");
        return true;
    }

    public Statement criarStatement() {
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }

    public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }
 
}
