package GUI_APP;

import javax.swing.*;

public class InterfazHolanda {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton healthCheck;
    private JCheckBox checkCuenta;
    private JCheckBox checkCliente;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField1;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel city;
    private JLabel street;
    private JLabel number;
    private JLabel CP;
    private JTextPane textPane1;
    private InicioSesion login;

    public InterfazHolanda(InicioSesion inicio){
        if(inicio==null){
            this.frame=new JFrame();
            this.frame.setBounds(100, 100, 786, 470);
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
}
