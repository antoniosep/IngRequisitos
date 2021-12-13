package GUI_APP;

import Modelo.DBaccess;
import Modelo.Persona;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
            this.frame=new JFrame();
            this.frame.setBounds(100, 100, 900, 600);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.getContentPane().setLayout(null);
            this.frame.setVisible(true);
        }else {
            login = inicio;
            this.frame = login.getFrame();
        }

    }

    public static void main(String[] args) {
        InterfazHolanda holanda = new InterfazHolanda(null);
        holanda.frame.setContentPane(holanda.mainPanel);
    }

    public List<Persona>  listaPersonas(){
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
