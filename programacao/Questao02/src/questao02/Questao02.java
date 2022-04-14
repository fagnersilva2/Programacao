/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao02;

import Conexoes.ConexaoSQLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Fagner Silva
 */
public class Questao02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("Imforme o numero");
        int num = input.nextInt();
        String tst = null;

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(conexaoSQLite);
        criarBancoSQLite.criarTabelaNumero();

        ResultSet resultSet = null;
        Statement statement = null;

        conexaoSQLite.conectar();

        String query = "SELECT * FROM tbl_numero; ";
        statement = conexaoSQLite.criarStatement();

        try {

            resultSet = statement.executeQuery(query);
            int teste = 0;
            int controle = 0;

            while (resultSet.next()) {

                teste++;
                if (resultSet.getInt("id") == num) {
                    System.out.println("id = " + resultSet.getInt("id"));
                    System.out.println("Numero = " + resultSet.getInt("numero"));
                    System.out.println("Fatorial = " + (resultSet.getString((("fatorial")))));

                } else {
                }

                tst = new String(resultSet.getString((("fatorial"))));
            }

            if ((teste == 0)) {
                tst = "1";
                teste = 0;
                Fatorial fat = new Fatorial();
                fat.fatorial(num, teste, tst);

            } else if ((teste < num) && (controle == 0)) {
                Fatorial fat = new Fatorial();
                fat.fatorial(num, teste, tst);

            } else {
            }
        } catch (SQLException e) {
            System.out.println("ERRO ");

        } finally {
            try {
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();

            } catch (SQLException ex) {

            }
        }
    }
    
    
}

