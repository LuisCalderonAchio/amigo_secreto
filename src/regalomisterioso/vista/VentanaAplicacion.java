/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regalomisterioso.vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import regalomisterioso.control.ControlAplicacion;

/**
 *
 * @author luis
 */
public class VentanaAplicacion extends JFrame {

    public VentanaAplicacion(ControlAplicacion g) {
        super("Amigo secreto");
        this.gestorPrincipal = g;
        configurar();
    }

    public void configurar() {
        setSize(800, 600);
        setMinimumSize(getSize());
        setResizable(true);
        ajustarComponentes(getContentPane());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void ajustarComponentes(Container c) {
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(2, 2, 2, 2);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        c.add(etqNombre = new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(campoNombre = new JTextField(), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        c.add(btnAgregar = new JButton("Agregar"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        c.add(btnAsignar = new JButton("Asignar regalos"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        c.add(new JScrollPane(tabla = new JTable(gestorPrincipal.getDatos()), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), gbc);
        tabla.setRowSelectionAllowed(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(etqConsultar = new JLabel("Consultar a la persona que se le debe de entregar el regalo"), gbc);
        etqConsultar.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        c.add(etqNombreConsulta = new JLabel("Nombre a consultar:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.1;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(campoConsulta = new JTextField(), gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        c.add(btnConsultar = new JButton("Consultar"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        c.add(btnGuardar = new JButton("Guardar en archivos"), gbc);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                agregar();
            }
        });

        btnAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                asignarRegalos();
            }
        });

        campoConsulta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                campoConsulta.selectAll();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                consultar();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                guardar();
            }
        });

        campoNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
                    agregar();
                }
            }
        });
        
        campoConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
                    consultar();
                }
            }
        });
    }

    public void init() {
        setVisible(true);
    }

    public void agregar() {
        String nombre = campoNombre.getText();
        try {
            if (!nombre.equals("")) {
                gestorPrincipal.agregar(nombre);
                campoNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "El campo con el nombre está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ya existe alguien agregado con el mismo nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void asignarRegalos() {
        try {
            gestorPrincipal.asignarRegalos();
        } catch (IllegalStateException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultar() {
        String nom = campoConsulta.getText();
        try {
            if (nom.equals("")) {
                JOptionPane.showMessageDialog(null, "El campo con el nombre a consultar está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String msg = nom + " le debe entregar el regalo a " + gestorPrincipal.consultar(nom);
                JOptionPane.showMessageDialog(null, msg, "Tu amigo secreto :3", WIDTH);
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardar() {
        try {
            gestorPrincipal.guardar();
            JOptionPane.showMessageDialog(null, "Se ha guardado los archivos con las personas a las que se le deben entregar los regalos", "Se ha guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalStateException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ControlAplicacion gestorPrincipal;

    private JLabel etqNombre;
    private JTextField campoNombre;
    private JButton btnAgregar;
    private JButton btnAsignar;

    private JTable tabla;

    private JLabel etqConsultar;

    private JLabel etqNombreConsulta;
    private JTextField campoConsulta;
    private JButton btnConsultar;
    private JButton btnGuardar;
}
