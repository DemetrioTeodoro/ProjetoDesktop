package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class FrmMenuCadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuCadastro frame = new FrmMenuCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMenuCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnUsuario = new JButton("Usuário");
		btnUsuario.setFont(new Font("Calibri", Font.BOLD, 17));
		btnUsuario.setBounds(196, 164, 142, 37);
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmUsuario usuario = new FrmUsuario();
				usuario.setVisible(true);
				dispose();
						
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnUsuario);
		
		JLabel lblDrMuquirana = new JLabel("Menu Cadastro");
		lblDrMuquirana.setForeground(Color.BLUE);
		lblDrMuquirana.setFont(new Font("Calibri", Font.BOLD, 30));
		lblDrMuquirana.setBounds(168, 25, 208, 37);
		contentPane.add(lblDrMuquirana);
		
		JButton btnDespesa = new JButton("Despesa");
		btnDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmDespesa().setVisible(true);
				dispose();
			}
		});
		btnDespesa.setFont(new Font("Calibri", Font.BOLD, 17));
		btnDespesa.setBounds(196, 242, 142, 37);
		contentPane.add(btnDespesa);
		
		JButton btnSair = new JButton("Receita");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmReceita().setVisible(true);
				dispose();
				
			}
		});
		btnSair.setFont(new Font("Calibri", Font.BOLD, 17));
		btnSair.setBounds(196, 323, 142, 37);
		contentPane.add(btnSair);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrmMenuInterface menu = new FrmMenuInterface();
				menu.show();
				
				
				
			}
		});
		btnVoltar.setFont(new Font("Calibri", Font.BOLD, 17));
		btnVoltar.setBounds(55, 429, 142, 37);
		contentPane.add(btnVoltar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Calibri", Font.BOLD, 17));
		btnFechar.setBounds(340, 429, 142, 37);
		contentPane.add(btnFechar);
	}
}
