/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.dao;

import com.mycompany.main.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class UsuarioDAO {
    private boolean usuarioLogado = false;
    private Connection con;
    private int id = 0;
    
    
    public boolean checarUsuario(String email, String senha) throws SQLException{
        con = Conexao.getConexao();
        
        String sql = "SELECT id, nome, email, senha FROM tb_usuarios WHERE email = ? AND senha = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                usuarioLogado = true;
            }
        } catch (SQLException e) {
            
            System.out.println("ERRO, não encontrei a tabela -> "+ e);
        } finally{
            con.close();
            System.out.println("Encerrando conexão");
        }
        
        return usuarioLogado;
    }
    
    public int retornaID(String email, String senha) throws SQLException{
        con = Conexao.getConexao();
        
        String sql = "SELECT id FROM tb_usuarios WHERE email = ? AND senha = ?";
        
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("id");
            }
        } catch (SQLException e){
            System.out.println("ERRO ao retornar id -> " + e);
        } finally {
            con.close();
            System.out.println("Conexão fechada. (Busca id usuário)");
        }
        return id;
    }
}
