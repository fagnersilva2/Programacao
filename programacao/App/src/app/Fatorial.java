package app;

import Conexoes.ConexaoSQLite;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fagner Silva
 */
public class Fatorial {
    
    public static BigInteger fatorial(int numero) {
        
        BigInteger resultado = BigInteger.ONE;
        for (int i = 1; i <= numero; i++) {
            
            resultado = resultado.multiply(BigInteger.valueOf(i));
            
            System.out.println("Numero inserido " + i);
            System.out.println("O fatorial de  " + i + " é = " + resultado);
            
            Numero n = new Numero();
            n.setId(i);
            n.setNumero(i);
            n.setFatorial(resultado);
            
            ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
            CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(conexaoSQLite);
            
            try {
                criarBancoSQLite.criarTabelaNumero();
            } catch (SQLException ex) {
                Logger.getLogger(Fatorial.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conexaoSQLite.conectar();
            
            String sqlInsert = "INSERT INTO tbl_numero("
                    + "id,"
                    + "numero,"
                    + "fatorial"
                    + ")VALUES(?,?,?)"
                    + ";";
            PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
            
            try {
                preparedStatement.setInt(1, n.getId());
                preparedStatement.setInt(2, n.getNumero());
                preparedStatement.setObject(3, n.getFatorial());
                
                int resultad = preparedStatement.executeUpdate();
                
                if (resultad == 1) {
                    System.out.println("Numero inserido!! ");
                } else {
                    System.out.println("Numero nao inserido!! ");
                }
                
            } catch (SQLException e) {
                System.out.println("Numero nao inserido!! ");

            } finally {
                if (preparedStatement != null) {
                    
                    conexaoSQLite.desconectar();
                }
                
            }
        } return resultado;
    }
}
