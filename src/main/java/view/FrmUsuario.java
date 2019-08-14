package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuario frame = new FrmUsuario();
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
	public FrmUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuUsurio = new JLabel("Menu Usuário");
		lblMenuUsurio.setFont(new Font("Calibri", Font.BOLD, 30));
		lblMenuUsurio.setForeground(Color.BLUE);
		lblMenuUsurio.setBounds(189, 36, 188, 54);
		contentPane.add(lblMenuUsurio);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastrarUsuario().setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(221, 152, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmAlterarUsuario().setVisible(true);
				dispose();
			}
		});
		btnAlterar.setBounds(221, 214, 97, 25);
		contentPane.add(btnAlterar);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmExibirUsuario().setVisible(true);
				dispose();
			}
		});
		btnExibir.setBounds(221, 284, 97, 25);
		contentPane.add(btnExibir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmExcluirUsuario().setVisible(true);
				dispose();
			}
		});
		btnExcluir.setBounds(221, 348, 97, 25);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FrmMenuCadastro menuCadastro = new FrmMenuCadastro();
				menuCadastro.setVisible(true);
			}
		});
		btnVoltar.setBounds(57, 448, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(390, 448, 97, 25);
		contentPane.add(btnFechar);
	}

}
