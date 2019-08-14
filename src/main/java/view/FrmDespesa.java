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

public class FrmDespesa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDespesa frame = new FrmDespesa();
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
	public FrmDespesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuDespesa = new JLabel("Menu Despesa");
		lblMenuDespesa.setForeground(Color.BLUE);
		lblMenuDespesa.setFont(new Font("Calibri", Font.BOLD, 30));
		lblMenuDespesa.setBounds(158, 32, 198, 37);
		contentPane.add(lblMenuDespesa);
		
		JButton btnCadastar = new JButton("Cadastar");
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmCadastarDespesa().setVisible(true);
				dispose();
			}
		});
		btnCadastar.setBounds(201, 148, 97, 25);
		contentPane.add(btnCadastar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmAlterarDespesa().setVisible(true);
				dispose();
			}
		});
		btnAlterar.setBounds(201, 196, 97, 25);
		contentPane.add(btnAlterar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmConsultarDespesa().setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(201, 245, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmExcluirDespesa().setVisible(true);
				dispose();
			}
		});
		btnExcluir.setBounds(201, 292, 97, 25);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmMenuCadastro().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(59, 372, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(305, 372, 97, 25);
		contentPane.add(btnFechar);
	}

}
