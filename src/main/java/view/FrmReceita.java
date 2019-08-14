package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmReceita extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReceita frame = new FrmReceita();
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
	public FrmReceita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuReceita = new JLabel("Menu Receita");
		lblMenuReceita.setForeground(Color.BLUE);
		lblMenuReceita.setFont(new Font("Calibri", Font.BOLD, 30));
		lblMenuReceita.setBounds(177, 36, 194, 37);
		contentPane.add(lblMenuReceita);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastarReceita().setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(224, 148, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmAlterarReceita().setVisible(true);
				dispose();
			}
		});
		btnAlterar.setBounds(224, 192, 97, 25);
		contentPane.add(btnAlterar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmConsultarReceita().setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(224, 242, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmExcluirReceita().setVisible(true);
				dispose();
			}
		});
		btnExcluir.setBounds(224, 294, 97, 25);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrmMenuCadastro menuCadastro = new FrmMenuCadastro();
				menuCadastro.setVisible(true);
			}
		});
		btnVoltar.setBounds(79, 408, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(368, 408, 97, 25);
		contentPane.add(btnSair);
	}

}
