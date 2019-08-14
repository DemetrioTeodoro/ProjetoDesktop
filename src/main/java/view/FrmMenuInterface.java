package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMenuInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuInterface window = new FrmMenuInterface();
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
	public FrmMenuInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Dr. Muquirana - Controle de Gastos");
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 30));
		lblTitulo.setBounds(48, 27, 501, 27);
		frame.getContentPane().add(lblTitulo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmMenuCadastro frmMenuCadastro = new FrmMenuCadastro();
				frmMenuCadastro.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnCadastrar.setFont(new Font("Calibri", Font.BOLD, 17));
		btnCadastrar.setBounds(231, 154, 140, 42);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnRelatrios = new JButton("Relatórios");
		btnRelatrios.setFont(new Font("Calibri", Font.BOLD, 17));
		btnRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmMenuRelatorio menuRelatorio = new FrmMenuRelatorio();
				menuRelatorio.setVisible(true);
				frame.dispose();
			}
		});
		btnRelatrios.setBounds(231, 243, 140, 42);
		frame.getContentPane().add(btnRelatrios);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			
		});
		btnSair.setFont(new Font("Calibri", Font.BOLD, 17));
		btnSair.setBounds(231, 334, 140, 42);
		frame.getContentPane().add(btnSair);
	}

	public void show() {
		FrmMenuInterface window = new FrmMenuInterface();
		window.frame.setVisible(true);	
		
	}
}
