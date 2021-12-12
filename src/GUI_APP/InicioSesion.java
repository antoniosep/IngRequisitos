package GUI_APP;

import Modelo.Clientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InicioSesion implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JTextField usuario;
    private JPasswordField password;
    private JLabel ok;

    static final String BD_SERVER = "jdbc:mysql://eburyrequisitos.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    static final String BD_NAME = "grupo07DB";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String USER = "grupo07";
    static final String PASS = "FjLWM6DNk6TJDzfV";

    private static Connection conn;


    public static void main(String[] args) {
        try {
            // create connection for database called DBB_SCHEMA in a server installed in
            // DB_URL, with a user USER with password PASS
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(BD_SERVER + "/" + BD_NAME, USER, PASS);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InicioSesion window = new InicioSesion();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InicioSesion(){
        frame = new JFrame();
        frame.setBounds(100, 100, 786, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        initialize();
    }

    private void initialize() {
        setPanel();
    }

    public void setPanel(){
        panel = new JPanel();
        panel.setBounds(0, 0, 786, 500);
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        //Crearemos las dos cajas para introducir datos
        usuario = new JTextField();
        usuario.setBounds(50, 100, 600, 50);

        password = new JPasswordField();
        password.setBounds(50, 200, 600, 50);

        panel.add(usuario);
        panel.add(password);

        //Crearemos el botón para acceder a la cuenta
        JButton b1 = new JButton();
        b1.setText("LOGIN");
        b1.setBounds(50, 300, 100, 80);

        b1.addActionListener(this);

        panel.add(b1);

        ok=new JLabel();
        ok.setBounds(200, 300, 20, 20);
        ok.setVisible(false);
        panel.add(ok);

        //Haremos visible el panel

        panel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pass="";
        for(Character c : this.password.getPassword()){
            pass = pass + c;
        }
    /*
        if (this.usuario.getText().compareTo(this.prueba1)==0 && pass.compareTo(this.prueba2)==0){
            ok.setText("SI");
            panel.setVisible(false);
            frame.getContentPane().remove(panel);
            InterfazAlemania alemania = new InterfazAlemania(this);
        }else{
            ok.setText("NO");
        }

        ok.setVisible(true);
        */
        if (inicioSesion(this.usuario.getText(),pass)!=null){
            ok.setText("SI");
            panel.setVisible(false);
            frame.getContentPane().remove(panel);
            InterfazAlemania alemania = new InterfazAlemania(this);
        }else{
            ok.setText("NO");
        }

        ok.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public Clientes inicioSesion(String usr, String psw) {

        String selectQueryBody = "SELECT * FROM cliente WHERE id=?";
        Clientes res = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, usr);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs.getRow());
            if (rs.isBeforeFirst()) {
                if (rs.next()) {
                    res = new Clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
                    System.out.println(res.getPsw());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (res.getPsw().equals(psw)) ? res : null;
    }
}
