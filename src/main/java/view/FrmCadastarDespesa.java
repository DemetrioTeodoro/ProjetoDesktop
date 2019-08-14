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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class FrmCadastarDespesa extends JFrame {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private JPanel contentPane;
	private JTextField txtIdUsuario;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtDtaVencimento;
	private JTextField txtDtaPagamento;
	private JComboBox cbxCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastarDespesa frame = new FrmCadastarDespesa();
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
	public FrmCadastarDespesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarDespesa = new JLabel("Cadastrar Despesa");
		lblCadastrarDespesa.setForeground(Color.BLUE);
		lblCadastrarDespesa.setFont(new Font("Calibri", Font.BOLD, 30));
		lblCadastrarDespesa.setBounds(144, 34, 239, 37);
		contentPane.add(lblCadastrarDespesa);
		
		JLabel lblNewLabel = new JLabel("Código Usuário ");
		lblNewLabel.setBounds(34, 128, 90, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(64, 156, 56, 16);
		contentPane.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(87, 185, 46, 16);
		contentPane.add(lblValor);
		
		JLabel lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setBounds(25, 214, 108, 16);
		contentPane.add(lblDataVencimento);
		
		JLabel lblDataPagamento = new JLabel("Data Pagamento");
		lblDataPagamento.setBounds(25, 246, 108, 16);
		contentPane.add(lblDataPagamento);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(64, 278, 56, 16);
		contentPane.add(lblCategoria);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setBounds(132, 125, 56, 22);
		contentPane.add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(132, 156, 239, 22);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(132, 182, 152, 22);
		contentPane.add(txtValor);
		
		txtDtaVencimento = new JTextField();
		txtDtaVencimento.setColumns(10);
		txtDtaVencimento.setBounds(132, 211, 152, 22);
		contentPane.add(txtDtaVencimento);
		
		txtDtaPagamento = new JTextField();
		txtDtaPagamento.setColumns(10);
		txtDtaPagamento.setBounds(132, 243, 152, 22);
		contentPane.add(txtDtaPagamento);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.addItem("Selecionar");
		cbxCategoria.addItem("Alimentação");
		cbxCategoria.addItem("Saúde");
		cbxCategoria.addItem("Aguá");
		cbxCategoria.addItem("Luz");
		cbxCategoria.addItem("Impostos");
		cbxCategoria.setBounds(132, 275, 152, 22);
		contentPane.add(cbxCategoria);
		
		
		
		
		JButton btnCadastar = new JButton("Cadastar");
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarDespesa();
			}
		});
		btnCadastar.setBounds(34, 411, 97, 25);
		contentPane.add(btnCadastar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(156, 411, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmDespesa().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(274, 411, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(393, 411, 97, 25);
		contentPane.add(btnSair);
	}
	
	private void cadastrarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		despesaVO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
		
		despesaVO.setDescricao(txtDescricao.getText());
		
		despesaVO.setValor(Double.parseDouble(txtValor.getText()));
		
		despesaVO.setDataVencimento(LocalDate.parse(txtDtaVencimento.getText(), formataDate));
		
		despesaVO.setDataPagamento(LocalDate.parse(txtDtaPagamento.getText(), formataDate));
		
		
		despesaVO.setCategoria(cbxCategoria.getSelectedItem().toString());
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.cadastrarDespesaController(despesaVO);
		
	}
}
