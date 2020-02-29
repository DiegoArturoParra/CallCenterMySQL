/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cundi.callcentermysql.formulario;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author diego
 */
public class Formulario extends JFrame implements ActionListener {

    private Crud crud = new Crud();
    private JLabel labelId = new JLabel("ID:");
    private JLabel labelNombre = new JLabel("Nombre del usuario:");
    private JLabel labelCedula = new JLabel("Cedula del usuario:");
    private JLabel labelTipo = new JLabel("Escoja el tipo de PQRS:");
    private JLabel labelDescripcion = new JLabel("Descripción:");
    private JTextField inputID = new JTextField();
    private JTextField inputNombre = new JTextField();
    private JTextField inputCedula = new JTextField();
    private JTextField inputDescripcion = new JTextField();
    private JComboBox listaPQRS = new JComboBox();
    private JButton btnConsultar, btnActualizar, btnInsertar, btnEliminar;

    /**
     * Create the frame.
     */
    public Formulario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Formulario Para QUERY");
        this.setSize(400, 370);
        this.setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 7, 10, 5));
        btnInsertar = new JButton("Insertar");
        btnConsultar = new JButton("Consultar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        listaPQRS.addItem("P");
        listaPQRS.addItem("Q");
        listaPQRS.addItem("R");
        listaPQRS.addItem("S");
        btnInsertar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        add(labelId);
        add(inputID);
        add(labelNombre);
        add(inputNombre);
        add(labelCedula);
        add(inputCedula);
        add(labelTipo);
        add(listaPQRS);
        add(labelDescripcion);
        add(inputDescripcion);
        add(btnInsertar);
        add(btnConsultar);
        add(btnActualizar);
        add(btnEliminar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsertar) {
            JOptionPane.showMessageDialog(rootPane, crud.insertar(inputNombre.getText(),
                    inputCedula.getText(),
                    (String) listaPQRS.getSelectedItem(),
                    inputDescripcion.getText()));
            limpiarCajas();

        } else if (e.getSource() == btnActualizar) {
            JOptionPane.showMessageDialog(rootPane, crud.modificar(inputNombre.getText(),
                    inputCedula.getText(),
                    (String) listaPQRS.getSelectedItem(),
                    inputDescripcion.getText()));
            limpiarCajas();

        } else if (e.getSource() == btnConsultar) {
            JOptionPane.showMessageDialog(rootPane, crud.consultar((String) listaPQRS.getSelectedItem()));
            limpiarCajas();

        } else if (e.getSource() == btnEliminar) {
            JOptionPane.showMessageDialog(rootPane, crud.eliminar(Integer.parseInt(inputID.getText())));
        } else {
            JOptionPane.showMessageDialog(null, "No sirve el boton que esta oprimiendo.");
        }
    }

    public void limpiarCajas() // metodo para limpiar todas las cajas que desee dentro de un panel.
    {
        inputID.setText("");
        inputNombre.setText("");
        inputCedula.setText("");
        inputDescripcion.setText("");
    }
}
