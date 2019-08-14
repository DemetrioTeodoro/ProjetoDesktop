package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrmMenuRelatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuRelatorio frame = new FrmMenuRelatorio();
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
	public FrmMenuRelatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuRelatorio = new JLabel("Menu Relatório");
		lblMenuRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuRelatorio.setForeground(Color.BLUE);
		lblMenuRelatorio.setFont(new Font("Calibri", Font.BOLD, 30));
		lblMenuRelatorio.setBounds(47, 27, 501, 27);
		contentPane.add(lblMenuRelatorio);
		
		JButton btnReceitas = new JButton("Relatório Receitas");
		btnReceitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReceitas.setFont(new Font("Calibri", Font.BOLD, 17));
		btnReceitas.setBounds(205, 89, 261, 42);
		contentPane.add(btnReceitas);
		
		JButton btnReceitasPeriodo = new JButton("Relatório Receitas por Período");
		btnReceitasPeriodo.setFont(new Font("Calibri", Font.BOLD, 17));
		btnReceitasPeriodo.setBounds(205, 142, 261, 42);
		contentPane.add(btnReceitasPeriodo);
		
		JButton btnDespesasAbertas = new JButton("Relatório Despesas Abertas");
		btnDespesasAbertas.setFont(new Font("Calibri", Font.BOLD, 17));
		btnDespesasAbertas.setBounds(205, 248, 261, 42);
		contentPane.add(btnDespesasAbertas);
		
		JButton btnDespesas = new JButton("Relatório Despesas");
		btnDespesas.setFont(new Font("Calibri", Font.BOLD, 17));
		btnDespesas.setBounds(205, 195, 261, 42);
		contentPane.add(btnDespesas);
		
		JButton btnDespesasPeriodo = new JButton("Relatório Despesas por Período");
		btnDespesasPeriodo.setFont(new Font("Calibri", Font.BOLD, 17));
		btnDespesasPeriodo.setBounds(205, 301, 261, 42);
		contentPane.add(btnDespesasPeriodo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Calibri", Font.BOLD, 17));
		btnSair.setBounds(259, 402, 140, 42);
		contentPane.add(btnSair);
	}
}
