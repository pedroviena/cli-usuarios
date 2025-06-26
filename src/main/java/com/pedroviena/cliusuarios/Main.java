package com.pedroviena.cliusuarios;

import java.util.List;
import java.util.Scanner; 

import com.pedroviena.cliusuarios.dao.UserDao;
import com.pedroviena.cliusuarios.model.user;
import com.pedroviena.cliusuarios.service.UserService;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final UserDao userDao = new UserDao();
    private static final UserService userService = new UserService(userDao);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n--- Menu Gerenciador de Usuários ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Buscar Usuário por ID");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Excluir Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine(); 

    
            switch (option) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    excluir(); 
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 0);
        
        scanner.close();
    }

    private static void cadastrar() {
        System.out.print("Digite o nome do usuário: ");
        String name = scanner.nextLine();
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();

        
        user newUser = new user(0, name, email);
        userService.cadastrarUsuario(newUser);
    }

    private static void listar() {
        System.out.println("\n--- Lista de Usuários ---");
        List<user> users = userService.listarUsuarios();

        if (users.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (user u : users) {
                System.out.println("ID: " + u.getId() + ", Nome: " + u.getName() + ", Email: " + u.getEmail());
            }
        }
    }

    private static void buscar() {
        System.out.print("Digite o ID do usuário a ser buscado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        user foundUser = userService.buscarUsuario(id);

        if (foundUser != null) {
            System.out.println("Usuário encontrado: ID: " + foundUser.getId() + ", Nome: " + foundUser.getName() + ", Email: " + foundUser.getEmail());
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }

    private static void atualizar() {
        System.out.print("Digite o ID do usuário a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        user existingUser = userService.buscarUsuario(id);

        if (existingUser != null) {
            System.out.print("Digite o novo nome do usuário (atual: " + existingUser.getName() + "): ");
            String newName = scanner.nextLine();
            System.out.print("Digite o novo email do usuário (atual: " + existingUser.getEmail() + "): ");
            String newEmail = scanner.nextLine();

            existingUser.setName(newName);
            existingUser.setEmail(newEmail);

            userService.atualizarUsuario(existingUser);
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }

    private static void excluir() {
        System.out.print("Digite o ID do usuário a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        userService.excluirUsuario(id);
    }
}