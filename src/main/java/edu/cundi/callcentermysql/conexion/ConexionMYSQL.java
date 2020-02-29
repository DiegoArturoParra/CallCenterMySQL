/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cundi.callcentermysql.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
/**
 *
 * @author diego
 */

public class ConexionMYSQL {
    private Connection conexion;
    private String servidor = "localhost";
    private String dataBase = "callcenter";
    private String usuario = "root";
    private String password = "";
    private String url = "";
    String driver = "com.mysql.cj.jdbc.Driver";
/**
 * Constructor por defecto
 */
    public ConexionMYSQL() {

        try {
            Class.forName(driver);
            url = "jdbc:mysql://" + this.servidor + "/" + this.dataBase + "?serverTimezone=" + TimeZone.getDefault().getID();
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos " + dataBase + " . . . . .Ok");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
            System.out.println(ex.getMessage());
        }
    }
/**
 * 
 * @return get conexion
 */
    public Connection getConexion() {
        return conexion;
    }

  
/**
 * 
 * @return cierra la conexion
 */
    public Connection cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Cerrando conexion a " + dataBase + " . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion = null;
        return conexion;
    }

}