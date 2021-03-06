package GUI_APP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;

/*
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
 */

public class InterfazAlemania{

	private JFrame frame;
	private JLabel label;
	private JPanel panel;
	private InicioSesion inicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAlemania window = new InterfazAlemania(null);
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
	public InterfazAlemania(InicioSesion login)
	{
		this.inicio=login;

		frame=new JFrame();
		frame.setBounds(100, 100, 786, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setPanel();
	}

	public void setPanel(){
		panel = new JPanel();
		panel.setBounds(10, 10, 752, 413);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 732, 393);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 81, 700, 270);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JButton btnGenerarInformeInicial = new JButton("Generar informe inicial");
		btnGenerarInformeInicial.setBounds(176, 74, 338, 43);

		btnGenerarInformeInicial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				frame.getContentPane().remove(panel);
				InterfazInforme informe = new InterfazInforme(InterfazAlemania.this, 0);

			}
		});

		panel_2.add(btnGenerarInformeInicial);

		JButton btnGenerarInformeSemanal = new JButton("Generar informe semanal");
		btnGenerarInformeSemanal.setBounds(176, 149, 338, 43);

		btnGenerarInformeSemanal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				frame.getContentPane().remove(panel);
				InterfazInforme informe = new InterfazInforme(InterfazAlemania.this, 1);
			}
		});

		panel_2.add(btnGenerarInformeSemanal);

		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(10, 24, 137, 31);

		btnCerrarSesin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				inicio.alternateVisible();
			}
		});

		panel_1.add(btnCerrarSesin);

		/*JButton button = new JButton("?");
		button.setBounds(655, 18, 43, 42);
		panel_1.add(button);
*/
		panel.setVisible(true);
	}

	public void setVisible(boolean valor){
		frame.setVisible(valor);
	}

	public JFrame getFrame() {
		return frame;
	}
}