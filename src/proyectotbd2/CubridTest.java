package proyectotbd2;

import cubrid.jdbc.driver.CUBRIDConnection;
import java.sql.*;
import java.lang.*;
import java.util.Scanner;

public class CubridTest {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese usuarioDB: ");
        String usuarioDB = sc.next();
        System.out.println("Ingrese password DB: ");
        String passwordDBUsr = sc.next();
        
        CUBRIDConnection conn = ConnectionDB.getCUBRIDConnection("testing01","30000",usuarioDB,passwordDBUsr);
        
        System.out.println("Ingrese id: ");
        int id_usuario = sc.nextInt();
        
        System.out.println("Ingrese nombre");
        String nombre = sc.next();
        
        System.out.println("Ingrese apellido");
        String apellido = sc.next();
        
        try{
            String sql="INSERT INTO usuarios(id_usuario, nombre, apellido) VALUES (?, ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, id_usuario);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            
            pstmt.executeUpdate();
            
            System.out.println("Usuario ingresado con exito");
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}