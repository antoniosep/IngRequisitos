package GUI_APP;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

public class Holanda {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Holanda window = new Holanda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Holanda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 752, 413);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 732, 393);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 69, 701, 289);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(715, 69, 17, 289);
		panel_1.add(scrollBar);
		
		JButton btnNewButton = new JButton("Health Check");
		btnNewButton.setBounds(520, 10, 130, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Conexi\u00F3n:");
		lblNewLabel.setBounds(520, 41, 56, 13);
		panel_1.add(lblNewLabel);
		
		JLabel lblEstable = new JLabel("Estable");
		lblEstable.setBounds(573, 41, 46, 13);
		panel_1.add(lblEstable);
		
		JLabel lblNewLabel_1 = new JLabel("Error de conexi\u00F3n");
		lblNewLabel_1.setBounds(573, 41, 46, 13);
		panel_1.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("S\u00F3lo clientes");
		chckbxNewCheckBox.setBounds(243, 42, 95, 21);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("S\u00F3lo cuentas Ebury");
		chckbxNewCheckBox_1.setBounds(340, 42, 130, 21);
		panel_1.add(chckbxNewCheckBox_1);
		
		JButton btnFiltros = new JButton("Filtros");
		btnFiltros.setBounds(10, 37, 130, 21);
		panel_1.add(btnFiltros);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 55, 309, 289);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(21, 26, 108, 13);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("N\u00BAcuenta");
		lblNewLabel_2_1.setBounds(21, 82, 108, 13);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setBounds(21, 134, 108, 18);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblFechaInicio = new JLabel("Fecha Apertura");
		lblFechaInicio.setBounds(21, 186, 108, 18);
		panel_3.add(lblFechaInicio);
		
		textField = new JTextField();
		textField.setBounds(139, 23, 96, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 79, 96, 19);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 134, 96, 19);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 186, 96, 19);
		panel_3.add(textField_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(10, 49, 268, 293);
		panel_3.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID");
		lblNewLabel_2_2.setBounds(21, 26, 108, 13);
		panel_3_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("N\u00BAIdentificaci\u00F3n");
		lblNewLabel_2_1_1.setBounds(21, 82, 108, 13);
		panel_3_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Estado");
		lblNewLabel_3_1.setBounds(21, 134, 108, 18);
		panel_3_1.add(lblNewLabel_3_1);
		
		JLabel lblFechaInicio_1 = new JLabel("Fecha Inicio");
		lblFechaInicio_1.setBounds(21, 186, 108, 18);
		panel_3_1.add(lblFechaInicio_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(139, 23, 96, 19);
		panel_3_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(139, 79, 96, 19);
		panel_3_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(139, 134, 96, 19);
		panel_3_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(139, 186, 96, 19);
		panel_3_1.add(textField_7);
		
		JLabel lblFechaCierre = new JLabel("Fecha Cierre");
		lblFechaCierre.setBounds(21, 228, 108, 18);
		panel_3_1.add(lblFechaCierre);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(139, 228, 96, 19);
		panel_3_1.add(textField_8);
		
		JLabel lblEntidadEbury = new JLabel("Entidad Ebury");
		lblEntidadEbury.setBounds(21, 265, 108, 18);
		panel_3_1.add(lblEntidadEbury);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(139, 265, 96, 19);
		panel_3_1.add(textField_9);
	}
}
