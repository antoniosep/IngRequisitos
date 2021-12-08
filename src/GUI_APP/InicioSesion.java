package GUI_APP;

import javax.swing.*;
import java.awt.*;

public class InicioSesion extends JFrame{
    private JFrame frame;

    public static void main(String[] args) {
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
        initialize();
    }

    private void initialize() {
        //Creamos el frame
        frame = new JFrame();
        frame.setBounds(100, 100, 786, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crearemos las dos cajas para introducir datos
        JTextField usuario = new JTextField();
        usuario.setBounds(50, 100, 600, 50);

        JPasswordField password = new JPasswordField();
        password.setBounds(50, 200, 600, 50);

        frame.add(usuario);
        frame.add(password);

        //Crearemos el botón para acceder a la cuenta
        JButton b1 = new JButton();
        b1.setText("LOGIN");
        b1.setBounds(50, 300, 100, 80);

        frame.add(b1);

        //Haremos visible la ventana
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
