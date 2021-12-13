package GUI_APP;

import Modelo.DBaccess;
import Modelo.GuardarInforme;
import Modelo.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class InterfazHolanda {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton healthCheck;
    private JCheckBox checkCuenta;
    private JCheckBox checkCliente;
    private JComboBox comboBox1;
    private JTextField textCity;
    private JTextField textCodPos;
    private JTextField textStreet;
    private JTextField textLastName;
    private JTextField textNumero;
    private JTextField textFirstName;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel city;
    private JLabel street;
    private JLabel number;
    private JLabel CP;
    private JTextPane textPane1;
    private JTextField textNumeroProducto;
    private JButton bAplicarFiltro;
    private JButton bLimpiar;
    private JLabel numeroProductoLabel;
    private InicioSesion login;

    public InterfazHolanda(InicioSesion inicio){
        if(inicio==null){
            frame=new JFrame();
            frame.setBounds(100, 100, 900, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);
            frame.setVisible(true);
        }else {
            login = inicio;
            this.frame = login.getFrame();
        }

        String[] tiposCuenta = {"","Todas", "Activas", "Inactivas"};
        for(String tipo : tiposCuenta){
            comboBox1.addItem(tipo);
        }
        comboBox1.setEnabled(false);
        textNumeroProducto.setEnabled(false);

        textFirstName.setEnabled(false);
        textLastName.setEnabled(false);
        textCity.setEnabled(false);
        textCodPos.setEnabled(false);
        textStreet.setEnabled(false);
        textNumero.setEnabled(false);

        bAplicarFiltro.setEnabled(false);
        bLimpiar.setEnabled(false);

        frame.setContentPane(mainPanel);

        /*
        healthCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBaccess bd = new DBaccess();
                boolean control;
                control=bd.HealthCheck();
                if(control==true){

                }else{

                }
            }
        });
        */
        checkCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkCuenta.isSelected()){
                    checkCliente.setEnabled(false);

                    comboBox1.setEnabled(true);
                    textNumeroProducto.setEnabled(true);

                    bAplicarFiltro.setEnabled(true);
                    bLimpiar.setEnabled(true);

                }else{
                    checkCliente.setEnabled(true);

                    comboBox1.setSelectedIndex(-1);

                    comboBox1.setEnabled(false);
                    textNumeroProducto.setEnabled(false);

                    bAplicarFiltro.setEnabled(false);
                    bLimpiar.setEnabled(false);
                }
            }
        });

        checkCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkCliente.isSelected()){
                    checkCuenta.setEnabled(false);

                    textFirstName.setEnabled(true);
                    textLastName.setEnabled(true);
                    textCity.setEnabled(true);
                    textCodPos.setEnabled(true);
                    textStreet.setEnabled(true);
                    textNumero.setEnabled(true);

                    bAplicarFiltro.setEnabled(true);
                    bLimpiar.setEnabled(true);

                }else{
                    checkCuenta.setEnabled(true);

                    textFirstName.setEnabled(false);
                    textLastName.setEnabled(false);
                    textCity.setEnabled(false);
                    textCodPos.setEnabled(false);
                    textStreet.setEnabled(false);
                    textNumero.setEnabled(false);

                    bAplicarFiltro.setEnabled(false);
                    bLimpiar.setEnabled(false);
                }
            }
        });
        bAplicarFiltro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO_DO
                if(checkCuenta.isEnabled()){
                    int indexTipo;
                    String numeroProducto, tipoCuenta;
                    indexTipo=comboBox1.getSelectedIndex();

                    tipoCuenta=(String) comboBox1.getItemAt(indexTipo);
                    numeroProducto=textNumeroProducto.getText();

                    textFirstName.setText(tipoCuenta);
                    textLastName.setText(numeroProducto);

                    //mostrarFiltradoCuenta();

                }else{
                    String nombre1, nombre2, ciudad, calle, numero, codPos;
                    nombre1=textFirstName.getText();
                    nombre2=textLastName.getText();
                    ciudad=textCity.getText();
                    calle=textStreet.getText();
                    numero=textNumero.getText();
                    codPos=textCodPos.getText();

                    //mostrarFiltradoCliente();
                }

            }
        });
        bLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void limpiarCampos() {
        comboBox1.setSelectedIndex(-1);
        textNumeroProducto.setText("");

        textFirstName.setText("");
        textLastName.setText("");
        textCity.setText("");
        textCodPos.setText("");
        textStreet.setText("");
        textNumero.setText("");
    }

    public static void main(String[] args) {
        InterfazHolanda holanda = new InterfazHolanda(null);
        holanda.frame.setContentPane(holanda.mainPanel);
    }

    public List<Persona> listaPersonas(){
        DBaccess acceso = new DBaccess();
        List<Persona> res = acceso.buscarPersonas();
        for (Persona p : res) {

            if(firstNameLabel.getText().equals(p.getNombre())){
                res.add(p);
                continue;
            }if(!firstNameLabel.getText().isEmpty())continue;
            if(textLastName.getText().equals(p.getApellido())){
                res.add(p);
                continue;
            }if(!textLastName.getText().isEmpty())continue;
            res.add(p);
        }
        return res;
    }


}
