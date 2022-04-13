/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Conexoes.ConexaoSQLite;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Fagner Silva
 */
public class CriarBancoSQLite {
     private final ConexaoSQLite conexaoSQLite;
    
    public CriarBancoSQLite(ConexaoSQLite pConexaoSQLite){
        this.conexaoSQLite = pConexaoSQLite;
    }
    
    public void criarTabelaNumero() throws SQLException{
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_numero"
                + "("
                + "id integer PRIMARY KEY,"
                + "numero int NOT NULL,"
                + "fatorial text"
                + ");";
        //executando o sql de criar tabelas
        boolean conectou = false;
        
        try{
           conectou = this.conexaoSQLite.conectar();
           
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
           // System.out.println("Tabela numero Criada!!!");
            
        }catch(SQLException e){
            
        }finally {
            if(conectou ){
                this.conexaoSQLite.desconectar();
            }
        }
    }
}
