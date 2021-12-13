package GUI_APP;
import Modelo.GenerarInforme;
import Modelo.GuardarInforme;
import Modelo.Transaccion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.swing.*;

public class InterfazInforme {

	private JFrame frame;
	private JTextField textField;
	private InterfazAlemania alemania;
	private Integer periodo; //0 inicial, 1 semanal
	Properties prop = new Properties();

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

		if(alemania==null){
			this.frame=new JFrame();
			this.frame.setBounds(100, 100, 786, 470);
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.frame.getContentPane().setLayout(null);
			this.frame.setVisible(true);
			this.frame.setResizable(true);
		}else{
			this.frame= alemania.getFrame();
			this.frame.setResizable(true);
		}

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setPanel();
	}

	public void setPanel(){
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 752, 413);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 732, 393);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		panel_1.setAutoscrolls(true);

		JButton atras = new JButton("Atr\u00E1s");
		atras.setBounds(53, 23, 109, 25);
		atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				frame.remove(panel);

				frame.setResizable(false);
				alemania.setPanel();
			}
		});
		panel_1.add(atras);

		List<Transaccion> lista = new LinkedList<>();
		GenerarInforme g= null;

		String txt;
		if(periodo==0) {//inicial

			lista=g.informeInicial();
			txt=lista.toString();
			JLabel textPane = new JLabel(lista.toString());
			textPane.setBounds(53, 58, 349, 311);
			panel_1.add(textPane);
		}else{//semanal
			lista=g.informeSemanal();
			txt=lista.toString();
			JLabel textPane = new JLabel(lista.toString());
			textPane.setBounds(53, 58, 349, 311);
			panel_1.add(textPane);
			}
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

		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name=textField.getText();
					GuardarInforme gu=new GuardarInforme(txt,name);
					gu.ejecutar(txt,name);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});


		panel.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}
}
