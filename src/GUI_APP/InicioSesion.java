package GUI_APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.DBaccess;

public class InicioSesion implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JTextField usuario;
    private JPasswordField password;
    private JLabel ok;

    private static DBaccess acceso = null;


    public static void main(String[] args) {

        acceso = new DBaccess();
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
        frame.setResizable(false);
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

        JButton b1 = new JButton();
        b1.setText("LOGIN");
        b1.setBounds(50, 300, 100, 80);

        b1.addActionListener(this);

        panel.add(b1);

        ok=new JLabel();
        ok.setBounds(200, 300, 20, 20);
        ok.setVisible(false);
        panel.add(ok);

        panel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pass="";
        for(Character c : this.password.getPassword()){
            pass = pass + c;
        }

        if (acceso.inicioSesion(this.usuario.getText(),pass)!=null){
            ok.setText("SI");
            panel.setVisible(false);
            frame.getContentPane().remove(panel);

            InterfazAlemania alemania = new InterfazAlemania(this);

            //InterfazHolanda holanda = new InterfazHolanda(this);

        }else{
            ok.setText("NO");
        }

        ok.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }


}
