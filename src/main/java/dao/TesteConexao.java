/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Duda
 */
public class TesteConexao {

    public static void main(String[] args) {
        System.out.println("Testando conexão com PostgreSQL...");

        try {
            // Carrega o driver
            Class.forName("org.postgresql.Driver");
            System.out.println("✅ Driver carregado");

            // Tenta conexão - ATUALIZEI PARA SEU NOVO BANCO!
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/DevWebDB", // MUDEI PARA DevWebDB
                    "postgres",
                    "postgres"
            );
            System.out.println("✅ CONEXÃO BEM-SUCEDIDA com DevWebDB!");
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver não encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ ERRO na conexão: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
