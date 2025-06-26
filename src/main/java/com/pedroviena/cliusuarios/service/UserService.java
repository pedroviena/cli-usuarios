package com.pedroviena.cliusuarios.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.pedroviena.cliusuarios.dao.UserDao;
import com.pedroviena.cliusuarios.model.user;

public class UserService {
    private final UserDao userDao; 

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void cadastrarUsuario(user user) {
        try {
           
            userDao.insert(user);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            
            System.err.println("Erro de banco de dados ao tentar cadastrar usuário: " + e.getMessage());
        }
    }

    public List<user> listarUsuarios() {
        try {
            return userDao.findAll();
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao listar usuários: " + e.getMessage());
            
            return Collections.emptyList();
        }
    }

    public user buscarUsuario(int id) {
        try {
            return userDao.findById(id);
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao buscar usuário: " + e.getMessage());
            return null; 
        }
    }

    public void atualizarUsuario(user user) {
        try {
            userDao.update(user);
            System.out.println("Usuário atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao atualizar usuário: " + e.getMessage());
        }
    }

    public void excluirUsuario(int id) {
        try {
            userDao.delete(id);
            System.out.println("Usuário excluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados ao excluir usuário: " + e.getMessage());
        }
    }
}