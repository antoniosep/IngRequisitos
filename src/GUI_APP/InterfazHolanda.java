package GUI_APP;

import Modelo.DBaccess;
import Modelo.GuardarInforme;
import Modelo.Persona;
import Modelo.Transaccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
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

        healthCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBaccess bd = new DBaccess();
                boolean control=false;

                JFrame f = new JFrame();
                f.setBounds(650, 300, 300, 180);
                f.setResizable(false);
                f.setVisible(true);
                f.setLayout(null);
                f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


                JPanel panel = new JPanel();
                panel.setBounds(650, 300, 300, 180);
                panel.setLayout(null);
                f.setContentPane(panel);

                JLabel texto = new JLabel();
                texto.setBounds(20, 60, 150, 20);
                texto.setText("CONEXIÓN:");
                texto.setVisible(true);
                panel.add(texto);

                JButton ok = new JButton();
                ok.setText("OK");
                ok.setBounds(200, 60, 60, 20);
                ok.setVisible(true);
                panel.add(ok);

                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                    }
                });

                control=bd.HealthCheck();

                if(control==true){
                    System.out.println("Conexión establecida");
                    texto.setText("CONEXIÓN: ESTABLECIDA");
                    //Esbrir gui cnoexion guay

                }else{
                    System.out.println("Error de conexión");
                    texto.setText("CONEXIÓN: SIN CONEXIÓN");
                    //Escribir gui mala conex

                }
                panel.setVisible(true);
            }
        });

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
            if(textCodPos.getText().equals(acceso.buscarClientes("numeroIdentificacion",p.getDni()).get(0).getDireccion().getCpostal())){
                res.add(p);
                continue;
            }if(!textCodPos.getText().isEmpty())continue;
            if(textStreet.getText().equals(acceso.buscarClientes("numeroIdentificacion",p.getDni()).get(0).getDireccion().getCalle())){
                res.add(p);
                continue;
            }if(!textStreet.getText().isEmpty())continue;
            if(textNumero.getText().equals(acceso.buscarClientes("numeroIdentificacion",p.getDni()).get(0).getDireccion().getNumero())){
                res.add(p);
                continue;
            }if(!textNumero.getText().isEmpty())continue;
            if(textCity.getText().equals(acceso.buscarClientes("numeroIdentificacion",p.getDni()).get(0).getDireccion().getCiudad())){
                res.add(p);
                continue;
            }if(!textCity.getText().isEmpty())continue;
            res.add(p);
        }
        return res;
    }

    public String toString() {
        String res = "";
        List<Persona> aux = listaPersonas();
        for(Persona p : aux){
            res += p.getNombre();
            res += " ";
            res += p.getSegundoNombre();
            res += " ";
            res += p.getApellido();
            res += "\n";
            res += p.getSegundoApellido();
            res += "\n";
            res += p.getFechanaciMiento().toString();
            res += "\n";
            res += p.getDni();
            res += "\n";
        }
        System.out.println(res);
        return res;
    }

}
