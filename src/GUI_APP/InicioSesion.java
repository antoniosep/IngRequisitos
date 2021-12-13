package GUI_APP;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Modelo.DBaccess;

public class InicioSesion implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JTextField usuario;
    private JPasswordField password;
    private JLabel user, pass, loginIcon;
    private JButton entrar;

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
        frame.setBounds(650, 300, 500, 300);
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
        panel.setBounds(0, 0, 500, 300);
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        usuario = new JTextField();
        usuario.setBounds(120, 170, 300, 30);

        password = new JPasswordField();
        password.setBounds(120, 210, 300, 30);

        panel.add(usuario);
        panel.add(password);

        JButton b1 = new JButton();
        b1.setText("LOGIN");
        b1.setBounds(50, 300, 100, 80);

        b1.addActionListener(this);

        panel.add(b1);

        user=new JLabel();
        user.setText("USER:");
        user.setBounds(20, 170, 60, 30);
        panel.add(user);

        pass=new JLabel();
        pass.setText("PASSWORD:");
        pass.setBounds(20, 210, 90, 30);
        panel.add(pass);

        loginIcon=new JLabel();
        loginIcon.setBounds(200, 20, 130, 130);

        ImageIcon imagenReducidaLogin =
                new ImageIcon(new ImageIcon("src/IMG/img_337531.png").getImage().getScaledInstance(loginIcon.getWidth(), loginIcon.getHeight(), Image.SCALE_DEFAULT));

        loginIcon.setIcon(imagenReducidaLogin);
        panel.add(loginIcon);

        ImageIcon imagenReducidaEntrar =
                new ImageIcon(new ImageIcon("src/IMG/1390645.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        entrar=new JButton();
        entrar.setIcon(imagenReducidaEntrar);
        entrar.setBounds(430, 180, 50, 50);
        entrar.addActionListener(this);
        entrar.setEnabled(true);
        panel.add(entrar);

        panel.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String pass="";
        for(Character c : this.password.getPassword()){
            pass = pass + c;
        }

        if (acceso.inicioSesion(this.usuario.getText(),pass)!=null){
            InterfazAlemania alemania = new InterfazAlemania(this);
            alternateVisible();

            //InterfazHolanda holanda = new InterfazHolanda(this);

        }

    }

    public JFrame getFrame() {
        return frame;
    }

    public void alternateVisible(){
        if(frame.isVisible()) frame.setVisible(false);
        else frame.setVisible(true);
    }

}
