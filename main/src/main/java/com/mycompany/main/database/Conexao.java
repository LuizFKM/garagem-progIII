/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Conexao {
    private static final String URL = "\"jdbc:mysql://localhost:3306/db_garagem\"";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String  DRIVER = "com.mysql.jdbc.Driver";
    private static Connection con = null;
    
    public static Connection getConexao(){
    
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco bem sucedida!");
            return con;
        }catch (ClassNotFoundException e){
            System.out.println("ERRO driver --> " + e);
        }catch(SQLException e){
            System.out.println("ERRO SQL -> " + e);
        }
        
        return con;
    }
    
}
