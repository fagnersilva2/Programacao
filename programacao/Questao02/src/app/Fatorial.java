package app;

import Conexoes.ConexaoSQLite;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Fagner Silva
 */
public class Fatorial {
    
   public static BigInteger fatorial(int numero, int nn, String n3) {
        int i;

        BigInteger resultado = BigInteger.ONE;
        resultado = new BigInteger(n3);
        for (i = nn +1; i <= numero; i++) {

            resultado = resultado.multiply(BigInteger.valueOf(i));

            Numero n = new Numero();
            n.setId(i);
            n.setNumero(i);
            n.setFatorial(String.valueOf(resultado));

            ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
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
                preparedStatement.setString(3, n.getFatorial());

                int resultad = preparedStatement.executeUpdate();

            } catch (SQLException e) {

            } finally {
                if (preparedStatement != null) {

                    conexaoSQLite.desconectar();
                }

            }

        }
        i = i - 1;
        System.out.println("O fatorial de  " +i + " é = " + resultado);
        return resultado;
    }
}
