/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cundi.callcentermysql.formulario;
import edu.cundi.callcentermysql.conexion.ConexionMYSQL;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author diego
 */
public class Crud implements ITiposDeQuery {

    private ConexionMYSQL conectar;
    private String query;
    private int confirmar;
    private String confirmarResultado;

    // Funcion para insertar en La base de datos
    @Override
    public String insertar(String nombre, String cedula, String tipo, String descripcion) {
        conectar = new ConexionMYSQL();
        query = "INSERT INTO pqrs (nombreUsuario, cedula, tipoPQRS, descripcionPQRS)"
                + "VALUES('" + nombre + "','"
                + cedula + "','"
                + tipo + "','"
                + descripcion + "')";
        try {
            Connection conectionDriver = conectar.getConexion();
            Statement statement = conectionDriver.createStatement();
            // se ejecuta  la consulta por medio del statement y se almacena el resultado en un resultset (conjunto de resultados)        
            confirmar = statement.executeUpdate(query);
            conectar.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (confirmar == 1) {
            System.out.println("Insertado con Exito!");
            confirmarResultado = "Insertado con Exito!";
        } else {
            System.out.println("No se inserto ha fallado en digitar algun campo");
            confirmarResultado = "No se inserto ha fallado en digitar algun campo";
        }
        return confirmarResultado;
    }

    // Función para modificar los datos de la base de datos
    @Override
    public String modificar(String nombre, String cedula, String tipo, String descripcion) {
        int ID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del pqrs que desea modificar"));
        conectar = new ConexionMYSQL();
        try {
            query = "UPDATE pqrs SET nombreUsuario= '" + nombre + "'"
                    + ",cedula = '" + cedula + "'"
                    + ",tipoPQRS = '" + tipo + "'"
                    + ",descripcionPQRS = '" + descripcion + "'"
                    + "WHERE  idPQRS = " + ID;
            Connection conectionDriver = conectar.getConexion();
            Statement statement = conectionDriver.createStatement();
            // se ejecuta  la consulta por medio del statement y se almacena el resultado en un resultset (conjunto de resultados)        
            confirmar = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (confirmar == 1) {
            System.out.println("Modificado con exito!");
            confirmarResultado = "Modificado con Exito!";
        } else {
            System.out.println("No se modifico nada!");
            confirmarResultado = "No se modifico nada!";
        }
        return confirmarResultado;
    }

    // Función para consultar los datos de la base de datos
    @Override
    public String consultar(String tipoPQRS) {
        conectar = new ConexionMYSQL();
        String BDcompleta = "";
        if (tipoPQRS.equalsIgnoreCase("P")
                || tipoPQRS.equalsIgnoreCase("Q")
                || tipoPQRS.equalsIgnoreCase("R")
                || tipoPQRS.equalsIgnoreCase("S")) {
            query = "SELECT * FROM pqrs where tipoPQRS = " + "'" + tipoPQRS.toUpperCase() + "'";
            try {
                Connection conectionDriver = conectar.getConexion();
                Statement statement = conectionDriver.createStatement();
                // para recorrer el resultset usualmente se utiliza un ciclo while
                // se ejecuta  la consulta por medio del statement y se almacena el resultado en un resultset (conjunto de resultados)
                ResultSet rs = statement.executeQuery(query);
                // para recorrer el resultset usualmente se utiliza un ciclo while
                while (rs.next()) {
                    BDcompleta += rs.getInt(1) + ", " + rs.getString(2)
                            + ", " + rs.getString(3) + ", " + rs.getString(4)
                            + ", " + rs.getString(5) + "\n";
                }

                conectar.cerrarConexion();
            } catch (SQLException e) {
                System.out.println(e);
            }
            if (BDcompleta.isEmpty()) {
                confirmarResultado = "CALL CENTER PQRS TIPO (" + tipoPQRS + ") esta vacia ingrese datos\n";
            } else {
                confirmarResultado = "CALL CENTER PQRS TIPO (" + tipoPQRS + ")\n" + BDcompleta;
            }
        } else {
            confirmarResultado = "No existe ese tipo en la base de datos";
        }
        return confirmarResultado;
    }
/**
 * 
 * @param id párametro 
 * @return retorna 
 */
    @Override
    public String eliminar(int id) {
        conectar = new ConexionMYSQL();
        query = "DELETE FROM pqrs where idPQRS = " + "" + id + "";
        try {
            Connection conectionDriver = conectar.getConexion();
            Statement statement = conectionDriver.createStatement();
            // se ejecuta  la consulta por medio del statement y se almacena el resultado en un resultset (conjunto de resultados)        
            confirmar = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (confirmar == 1) {
            System.out.println("¡Eliminado con exito!");
            confirmarResultado = "¡Eliminado con Exito!";
        } else {
            System.out.println("¡No existe ese ID!");
            confirmarResultado = "¡No existe ese ID!";
        }
        return confirmarResultado;
    }
}
