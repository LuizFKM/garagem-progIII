/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.dao;

import com.mycompany.main.database.Conexao;
import com.mycompany.main.model.Garagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GaragemDAO {
     private Connection con;
    
    public ArrayList<Garagem> retornaListaDeGaragens() throws SQLException{
        con = Conexao.getConexao();
        
        String sql = "SELECT * FROM tb_garagens";
        
        ArrayList<Garagem> listaDeGaragens = new ArrayList<>();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Garagem g = new Garagem();
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setCidade(rs.getString("cidade"));
                g.setCep(rs.getString("cep"));
                g.setBairro(rs.getString("bairro"));
                g.setEstado(rs.getString("estado"));
                g.setNumero(rs.getString("numero"));
                g.setPais(rs.getString("pais"));
                g.setRua(rs.getString("rua"));
                System.out.println("Nome garagem: " + g.getNome() + " - " + "cidade: " + g.getCidade());
   
                listaDeGaragens.add(g);
            }
        }catch(SQLException e){
            System.out.println("ERRO ao listar garagens -> " + e);
        } finally {
            con.close();
            System.out.println("Conexão fechada");
        }
        
        return listaDeGaragens;
    }
    
    public void salvarGaragem(Garagem g) throws SQLException{
        con = Conexao.getConexao();
        
        String sql = "INSERT INTO tb_garagens (nome, pais, estado, cidade, bairro, rua, numero, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, g.getNome());
            ps.setString(2, g.getPais());
            ps.setString(3, g.getEstado());
            ps.setString(4, g.getCidade());
            ps.setString(5, g.getBairro());
            ps.setString(6, g.getRua());
            ps.setString(7, g.getNumero());
            ps.setString(8, g.getCep());
            
            ps.executeUpdate();  
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
            g.setId(rs.getInt(1));
        }
            
        }catch (SQLException e){
            System.out.println("ERRO, não foi possível salvar no banco -> " + e);
         
        }finally{
            con.close();
            System.out.println("Conexão fechada (Cadastrar garagem");
        }
    }
}
