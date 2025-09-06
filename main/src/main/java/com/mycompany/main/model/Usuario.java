/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;

/**
 *
 * @author User
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    
    public Usuario(){
    }
    
    public Usuario(int ID, String nome, String email, String senha){
        this.id = id;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }
    
    
    
    
        
        
}
