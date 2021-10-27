
package Grafico;

import Conexion.Conexion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ventana1 extends JFrame{
    Conexion base = new Conexion();
    Connection verificar = base.getConnection();
    JPanel contentPane, Panel1, Panel2, Panel3, Panel4;
    JButton Login;
    JLabel titulo;
    JTextField usuario;
    JPasswordField pass;
    public Ventana1(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(626, 626);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Login Parcial");
        IniciarComponentes();
        TextPrompt us = new TextPrompt("Username", usuario);
        TextPrompt pa = new TextPrompt("**********", pass);
    }
    public void ingresarDatos(){
        String insertar = "INSERT INTO infoparcial(NombreUsuario, Password) VALUES (?, ?)";
        String RecuperarPass = String.valueOf(pass.getPassword());
        try{
            PreparedStatement listo = verificar.prepareStatement(insertar);
            listo.setString(1, usuario.getText());
            listo.setString(2, RecuperarPass);
            listo.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ingreso correcto");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Registro incorrecto: "+e.getMessage());
        }
    }
    private void IniciarComponentes(){
        insertarPaneles();
        insertarEtiquetas();
        insertarBoton();
        insertarCamposdetexto();
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Accionar(e);
            }
        });
    }
    private void insertarPaneles(){
        contentPane = new JPanel();
        contentPane.setBackground(new Color(117, 153, 179));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
             
        Panel3 = new JPanel();
        Panel3.setLayout(null);
        Panel3.setBounds(90, 385, 450, 70);
        Panel3.setBackground(new Color(56, 84, 123));
        contentPane.add(Panel3);
        
        Panel4 = new JPanel();
        Panel4.setLayout(null);
        Panel4.setBounds(120, 455, 390, 45);
        Panel4.setBackground(Color.white);
        contentPane.add(Panel4);
    }
    private void insertarEtiquetas(){
        titulo = new JLabel("CUSTOMER LOGIN");
        titulo.setBounds(180, 165, 265, 34);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Arial", 0, 28));
        contentPane.add(titulo);
        
        Panel1 = new JPanel();
        Panel1.setLayout(null);
        Panel1.setBounds(120, 135, 390, 90);
        Panel1.setBackground(new Color(56, 84, 123));
        contentPane.add(Panel1);
    }
    private void insertarBoton(){
        Login = new JButton("LOGIN");
        Login.setBounds(238, 407, 150, 34);
        Login.setBorder(null);
        Login.setFocusPainted(false);
        Login.setBackground(new Color(56, 84, 123));
        Login.setFont(new Font("Arial", 0, 28));
        Login.setForeground(Color.white);
        contentPane.add(Login);
    }
    private void insertarCamposdetexto(){
        usuario = new JTextField();
        usuario.setBorder(null);
        usuario.setBounds(195, 260, 275, 30);
        usuario.setForeground(new Color(161, 166, 198));
        usuario.setFont(new Font("Arial", 0, 20));
        contentPane.add(usuario);
        
        JLabel imgUsuario = new JLabel(new ImageIcon("usuario.png"));
        imgUsuario.setBounds(140, 260, 32, 32);
        contentPane.add(imgUsuario);
        
        pass = new JPasswordField();
        pass.setBounds(195, 325, 275, 30);
        pass.setBorder(null);
        pass.setForeground(new Color(161, 166, 198));
        pass.setFont(new Font("Arial", 0, 20));
        contentPane.add(pass);
        
        JLabel imgPass = new JLabel(new ImageIcon("pass.png"));
        imgPass.setBounds(140, 325, 32, 32);
        contentPane.add(imgPass);
        
        Panel2 = new JPanel();
        Panel2.setLayout(null);
        Panel2.setBounds(120, 225, 390, 160);
        Panel2.setBackground(Color.white);
        contentPane.add(Panel2);
    }
    private void Accionar(java.awt.event.ActionEvent e){
        ingresarDatos();
        Ventana2 v2 = new Ventana2();
        v2.setVisible(true);
        this.setVisible(false);
        dispose();
    }
    
    @Override
    public void paint (Graphics g){
        super.paintComponents(g);
        g.setColor(new Color(56, 84, 123));
        Polygon T = new Polygon();
        T.addPoint(100, 485);
        T.addPoint(127, 485);
        T.addPoint(127, 500);
        g.drawPolygon(T);
        g.fillPolygon(T);
        Polygon Q = new Polygon();
        Q.addPoint(518, 485);
        Q.addPoint(545, 485);
        Q.addPoint(518, 500);
        g.drawPolygon(Q);
        g.fillPolygon(Q);
        
        Graphics2D linea = (Graphics2D)g;
        BasicStroke grosor = new BasicStroke (1);
        linea.setStroke(grosor);
        linea.setColor(new Color(161, 166, 198));
        linea.drawLine(170, 340, 475, 340);
        
    }
    
    
}
