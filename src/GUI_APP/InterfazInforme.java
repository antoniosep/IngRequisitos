package GUI_APP;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class InterfazInforme {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInforme window = new InterfazInforme();
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
	public InterfazInforme() {
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
		
		JButton btnCerrarSesin = new JButton("Atr\u00E1s");
		btnCerrarSesin.setBounds(53, 23, 109, 25);
		panel_1.add(btnCerrarSesin);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(53, 58, 349, 311);
		panel_1.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(425, 175, 165, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(".csv");
		lblNewLabel.setBounds(600, 175, 52, 19);
		panel_1.add(lblNewLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(425, 229, 123, 31);
		panel_1.add(btnGuardar);
	}
}
