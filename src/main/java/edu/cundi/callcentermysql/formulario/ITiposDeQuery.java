/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cundi.callcentermysql.formulario;

/**
 *
 * @author diego
 */

public interface ITiposDeQuery {

    public String insertar(String nombre, String cedula, String tipo, String descripcion);

    public String modificar(String nombre, String cedula, String tipo, String descripcion);

    public String consultar(String tipoPQRS);

    public String eliminar(int id);
}
