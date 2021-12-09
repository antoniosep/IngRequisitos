package GUI_APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion implements ActionListener{
    private JFrame frame;
    private String prueba1="Antonio", prueba2="1234";
    private JTextField usuario;
    private JPasswordField password;
    private JLabel ok;

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
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
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

        //Haremos visible la ventana

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pass="";
        for(Character c : this.password.getPassword()){pass = pass + c;}

        if (this.usuario.getText().compareTo(this.prueba1)==0 && pass.compareTo(this.prueba2)==0){
            ok.setText("SI");
        }else{
            ok.setText("NO");
        }

        ok.setVisible(true);
    }
}
