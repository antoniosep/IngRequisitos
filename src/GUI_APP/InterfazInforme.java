package GUI_APP;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class InterfazInforme {

	private JFrame frame;
	private JTextField textField;
	private InterfazAlemania alemania;
	private Integer periodo; //0 inicial, 1 semanal

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInforme window = new InterfazInforme(null, 0);
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
	public InterfazInforme(InterfazAlemania alemania, int periodo) {
		this.alemania=alemania;
		this.periodo=periodo;
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
		
		JButton atras = new JButton("Atr\u00E1s");
		atras.setBounds(53, 23, 109, 25);
		atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				alemania.setVisible(true);
			}
		});
		panel_1.add(atras);
		
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

		frame.setVisible(true);
	}
}
