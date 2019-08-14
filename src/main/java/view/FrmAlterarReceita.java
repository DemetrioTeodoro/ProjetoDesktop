package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladoraDespesa;
import controller.ControladoraReceita;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmAlterarReceita extends JFrame {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtIdUsuario;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtDtaReceita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlterarReceita frame = new FrmAlterarReceita();
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
	public FrmAlterarReceita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltererReceita = new JLabel("Alterar Receita");
		lblAltererReceita.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAltererReceita.setForeground(Color.BLUE);
		lblAltererReceita.setBounds(199, 31, 186, 37);
		contentPane.add(lblAltererReceita);
		
		JLabel lblCdigoReceita = new JLabel("Código Receita");
		lblCdigoReceita.setBounds(35, 114, 85, 16);
		contentPane.add(lblCdigoReceita);
		
		JLabel lblCdigoUsurio = new JLabel("Código Usuário");
		lblCdigoUsurio.setBounds(35, 143, 92, 16);
		contentPane.add(lblCdigoUsurio);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(64, 172, 56, 16);
		contentPane.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(74, 209, 39, 16);
		contentPane.add(lblValor);
		
		JLabel lblDataReceita = new JLabel("Data Receita");
		lblDataReceita.setBounds(43, 239, 77, 16);
		contentPane.add(lblDataReceita);
		
		txtId = new JTextField();
		txtId.setBounds(132, 111, 56, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setEnabled(false);
		txtIdUsuario.setColumns(10);
		txtIdUsuario.setBounds(132, 140, 56, 22);
		contentPane.add(txtIdUsuario);
		
		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(132, 172, 253, 22);
		contentPane.add(txtDescricao);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setColumns(10);
		txtValor.setBounds(132, 206, 108, 22);
		contentPane.add(txtValor);
		
		txtDtaReceita = new JTextField();
		txtDtaReceita.setEnabled(false);
		txtDtaReceita.setColumns(10);
		txtDtaReceita.setBounds(132, 236, 108, 22);
		contentPane.add(txtDtaReceita);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarReceita();
				txtIdUsuario.setEnabled(true);
				txtDescricao.setEnabled(true);
				txtValor.setEnabled(true);
				txtDtaReceita.setEnabled(true);
			}
		});
		btnConsultar.setBounds(204, 110, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarReceita();			
			}
		});
		btnAlterar.setBounds(35, 369, 97, 25);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtIdUsuario.setText("");
				txtDescricao.setText("");
				txtValor.setText("");
				txtDtaReceita.setText("");
			}
		});
		btnLimpar.setBounds(161, 369, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmReceita().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(288, 369, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(418, 369, 97, 25);
		contentPane.add(btnSair);
	}
	
	private void consultarReceita() {
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		
		ReceitaVO receitaVO = new ReceitaVO();			
		receitaVO.setId(Integer.parseInt(txtId.getText()));
		ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
		
		txtIdUsuario.setText(String.valueOf(receita.getIdUsuario()));
		txtDescricao.setText(receita.getDescricao());
		txtValor.setText(String.valueOf(receita.getValor()));
		txtDtaReceita.setText(String.valueOf(receita.getDataReceita().format(formataDate)));		

	}
	
	private void atualizarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		
		receitaVO.setId(Integer.parseInt(txtId.getText()));
		
		receitaVO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
		
		receitaVO.setDescricao(txtDescricao.getText());
		
		receitaVO.setValor(Double.parseDouble(txtValor.getText()));
		
		receitaVO.setDataReceita(LocalDate.parse(txtDtaReceita.getText(), formataDate));
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.atualizarReceitaController(receitaVO);
		
	}
	
	
}