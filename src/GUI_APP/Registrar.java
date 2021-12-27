package GUI_APP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrar {


    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel city;
    private JLabel street;
    private JLabel CP;
    private JTextField textFirstName;
    private JTextField textLastName;
    private JTextField textCity;
    private JTextField textStreet;
    private JTextField textNumero;
    private JTextField textCodPos;
    private JLabel number;
    private JTextField textNumeroProducto;
    private JLabel numeroProductoLabel;
    private JButton bRegistrar;
    private JCheckBox clienteCheckBox;
    private JCheckBox cuentaCheckBox;
    private JPanel panel1;
    private JPanel panel2;
    private JButton bAtras;
    private JFrame frame;
    private InicioSesion inicio;

    public Registrar(InicioSesion inicioSesion){

        frame=new JFrame();
        frame.setBounds(100, 100, 600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setContentPane(panel1);
        frame.setResizable(false);
        this.inicio=inicioSesion;

        textNumeroProducto.setEnabled(false);
        textFirstName.setEnabled(false);
        textLastName.setEnabled(false);
        textCity.setEnabled(false);
        textCodPos.setEnabled(false);
        textStreet.setEnabled(false);
        textNumero.setEnabled(false);

        bRegistrar.setEnabled(false);

        cuentaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cuentaCheckBox.isSelected()){
                    clienteCheckBox.setEnabled(false);

                    textNumeroProducto.setEnabled(true);
                    textFirstName.setEnabled(false);
                    textLastName.setEnabled(false);
                    textCity.setEnabled(false);
                    textCodPos.setEnabled(false);
                    textStreet.setEnabled(false);
                    textNumero.setEnabled(false);

                    bRegistrar.setEnabled(true);
                    bAtras.setEnabled(true);

                }else{
                    clienteCheckBox.setEnabled(true);


                    textNumeroProducto.setEnabled(false);
                    textFirstName.setEnabled(false);
                    textLastName.setEnabled(false);
                    textCity.setEnabled(false);
                    textCodPos.setEnabled(false);
                    textStreet.setEnabled(false);
                    textNumero.setEnabled(false);

                    bRegistrar.setEnabled(false);
                    bAtras.setEnabled(true);
                }
            }
        });

        bAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InicioSesion inicio = new InicioSesion();
                alternateVisible();
            }
        });

        clienteCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clienteCheckBox.isSelected()){
                    cuentaCheckBox.setEnabled(false);

                    textNumeroProducto.setEnabled(false);
                    textFirstName.setEnabled(true);
                    textLastName.setEnabled(true);
                    textCity.setEnabled(true);
                    textCodPos.setEnabled(true);
                    textStreet.setEnabled(true);
                    textNumero.setEnabled(true);

                    bRegistrar.setEnabled(true);
                    bAtras.setEnabled(true);

                }else{
                    cuentaCheckBox.setEnabled(true);

                    textNumeroProducto.setEnabled(false);
                    textFirstName.setEnabled(false);
                    textLastName.setEnabled(false);
                    textCity.setEnabled(false);
                    textCodPos.setEnabled(false);
                    textStreet.setEnabled(false);
                    textNumero.setEnabled(false);

                    bRegistrar.setEnabled(false);
                    bAtras.setEnabled(true);
                }
            }
        });

    }



    public static void main(String[] args) {
        Registrar r = new Registrar(null);
        r.frame.setContentPane(r.panel1);
        r.frame.setVisible(true);

}

    public void alternateVisible(){
        if(frame.isVisible()) frame.setVisible(false);
        else frame.setVisible(true);
    }

}
