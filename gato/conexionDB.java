/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato1;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Cristiam
 */
public class conexionDB {

    public Connection Conexion;
    protected Connection cn;
    protected Statement st;

    public conexionDB() {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Registrado");
            cn = DriverManager.getConnection("Gato", "sa", "Cessna123");
            System.out.println("Conexion Establecida");
            st = cn.createStatement();

        } catch (SQLException e1) {
            System.out.println("ERROR SQL:" + e1.getMessage());
        } catch (ClassNotFoundException e2) {
            System.out.println("ERROR DRIVER:" + e2.getMessage());
        }
    }

    

   
}
