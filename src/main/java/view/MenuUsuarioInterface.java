package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuUsuarioInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuarioInterface window = new MenuUsuarioInterface();
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
	public MenuUsuarioInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTituloMenuUsuario = new JLabel("Menu Cadastro Usuários");
		lblTituloMenuUsuario.setForeground(Color.BLUE);
		lblTituloMenuUsuario.setFont(new Font("Calibri", Font.BOLD, 30));
		lblTituloMenuUsuario.setBounds(117, 39, 323, 37);
		frame.getContentPane().add(lblTituloMenuUsuario);
		
		JButton btnCadastrarUsurio = new JButton("Cadastrar Usuário");
		btnCadastrarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrarUsurio.setFont(new Font("Calibri", Font.BOLD, 17));
		btnCadastrarUsurio.setBounds(162, 149, 213, 37);
		frame.getContentPane().add(btnCadastrarUsurio);
	}

}
