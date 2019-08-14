package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladoraDespesa;
import model.vo.DespesaVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAlterarDespesa extends JFrame {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private JPanel contentPane;
	private JTextField txtIdDespesa;
	private JTextField txtIdUsuario;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtDtaVencimento;
	private JTextField txtDtaPagamento;
	private JTextField txtCategoria;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlterarDespesa frame = new FrmAlterarDespesa();
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
	public FrmAlterarDespesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarDespesa = new JLabel("Alterar Despesa");
		lblAlterarDespesa.setForeground(Color.BLUE);
		lblAlterarDespesa.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAlterarDespesa.setBounds(168, 37, 217, 37);
		contentPane.add(lblAlterarDespesa);
		
		JLabel lblCdigoDespesa = new JLabel("Código Despesa");
		lblCdigoDespesa.setBounds(47, 121, 99, 16);
		contentPane.add(lblCdigoDespesa);
		
		JLabel lblCdigoUsurio = new JLabel("Código Usuário");
		lblCdigoUsurio.setBounds(55, 155, 91, 16);
		contentPane.add(lblCdigoUsurio);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(81, 188, 56, 16);
		contentPane.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(102, 217, 35, 16);
		contentPane.add(lblValor);
		
		JLabel lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setBounds(42, 246, 104, 16);
		contentPane.add(lblDataVencimento);
		
		JLabel lblDataPagamento = new JLabel("Data Pagamento");
		lblDataPagamento.setBounds(47, 275, 104, 16);
		contentPane.add(lblDataPagamento);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(81, 304, 56, 16);
		contentPane.add(lblCategoria);
		
		txtIdDespesa = new JTextField();
		txtIdDespesa.setBounds(148, 118, 56, 22);
		contentPane.add(txtIdDespesa);
		txtIdDespesa.setColumns(10);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setEnabled(false);
		txtIdUsuario.setColumns(10);
		txtIdUsuario.setBounds(148, 150, 56, 22);
		contentPane.add(txtIdUsuario);
		
		txtDescricao = new JTextField();
		txtDescricao.setEnabled(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(149, 185, 207, 22);
		contentPane.add(txtDescricao);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setColumns(10);
		txtValor.setBounds(149, 214, 104, 22);
		contentPane.add(txtValor);
		
		txtDtaVencimento = new JTextField();
		txtDtaVencimento.setEnabled(false);
		txtDtaVencimento.setColumns(10);
		txtDtaVencimento.setBounds(149, 243, 104, 22);
		contentPane.add(txtDtaVencimento);
		
		txtDtaPagamento = new JTextField();
		txtDtaPagamento.setEnabled(false);
		txtDtaPagamento.setColumns(10);
		txtDtaPagamento.setBounds(149, 272, 104, 22);
		contentPane.add(txtDtaPagamento);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarDespesa();
				txtIdUsuario.setEnabled(true);
				txtDescricao.setEnabled(true);
				txtValor.setEnabled(true);
				txtDtaVencimento.setEnabled(true);
				txtDtaPagamento.setEnabled(true);
				txtCategoria.setEnabled(true);
				
			}
		});
		btnConsultar.setBounds(216, 117, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarDespesa();
			}
		});
		btnAlterar.setBounds(47, 386, 97, 25);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdDespesa.setText("");
				txtIdUsuario.setText("");
				txtDescricao.setText("");
				txtValor.setText("");
				txtDtaVencimento.setText("");
				txtDtaPagamento.setText("");
				txtCategoria.setText("");
				
			}
		});
		btnLimpar.setBounds(172, 386, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmDespesa().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(303, 386, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(423, 386, 97, 25);
		contentPane.add(btnSair);	
		
		txtCategoria = new JTextField();
		txtCategoria.setEnabled(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(149, 304, 146, 22);
		contentPane.add(txtCategoria);
	}
	
	private void consultarDespesa() {
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		
				DespesaVO despesaVO = new DespesaVO();			
				despesaVO.setId(Integer.parseInt(txtIdDespesa.getText()));
				DespesaVO despesa = controladoraDespesa.consultarDespesaController(despesaVO);
				
				txtIdUsuario.setText(String.valueOf(despesa.getIdUsuario()));
				txtDescricao.setText(despesa.getDescricao());
				txtValor.setText(String.valueOf(despesa.getValor()));
				txtDtaVencimento.setText(String.valueOf(despesa.getDataVencimento().format(formataDate)));
				txtDtaPagamento.setText(String.valueOf(despesa.getDataPagamento().format(formataDate)));
				txtCategoria.setText(despesa.getCategoria());
				
	}
	
	private void atualizarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		
		despesaVO.setId(Integer.parseInt(txtIdDespesa.getText()));
		
		despesaVO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
		
		despesaVO.setDescricao(txtDescricao.getText());
		
		despesaVO.setValor(Double.parseDouble(txtValor.getText()));
		
		despesaVO.setDataVencimento(LocalDate.parse(txtDtaVencimento.getText(), formataDate));
		
		despesaVO.setDataPagamento(LocalDate.parse(txtDtaPagamento.getText(), formataDate));
		
		despesaVO.setCategoria(txtCategoria.getText());
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.atualizarDespesaController(despesaVO);
		
	}
}
