package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladoraDespesa;
import model.vo.DespesaVO;

import java.awt.Font;
import java.awt.Color;

public class FrmConsultarDespesa extends JFrame {

	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private JPanel contentPane;
	private JTextField txtIdDespesa;
	private JTextField txtIdUsuario;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtDtaVencimento;
	private JTextField txtDtaPagamento;
	private JTextField txtCategoria;
	private JLabel lblNewLabel;
	private JButton btnConsultar;
	private JButton btnVoltar;
	private JButton btnFechar;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultarDespesa frame = new FrmConsultarDespesa();
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
	public FrmConsultarDespesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		
		txtCategoria = new JTextField();
		txtCategoria.setEnabled(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(149, 304, 104, 22);
		contentPane.add(txtCategoria);
		
		lblNewLabel = new JLabel("Consultar Despesa");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(148, 25, 241, 37);
		contentPane.add(lblNewLabel);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarDespesa();
			}
		});
		btnConsultar.setBounds(216, 117, 97, 25);
		contentPane.add(btnConsultar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmDespesa().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(47, 395, 97, 25);
		contentPane.add(btnVoltar);
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(329, 395, 97, 25);
		contentPane.add(btnFechar);
		
		btnLimpar = new JButton("Limpar");
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
		btnLimpar.setBounds(193, 395, 97, 25);
		contentPane.add(btnLimpar);
		
		
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

}
