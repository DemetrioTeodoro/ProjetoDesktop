package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladoraReceita;
import model.vo.ReceitaVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class FrmCadastarReceita extends JFrame {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private JPanel contentPane;
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
					FrmCadastarReceita frame = new FrmCadastarReceita();
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
	public FrmCadastarReceita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadatarReceita = new JLabel("Cadatar Receita");
		lblCadatarReceita.setForeground(Color.BLUE);
		lblCadatarReceita.setFont(new Font("Calibri", Font.BOLD, 30));
		lblCadatarReceita.setBounds(169, 38, 202, 37);
		contentPane.add(lblCadatarReceita);
		
		JLabel lblCdigoUsurio = new JLabel("Código Usuário");
		lblCdigoUsurio.setBounds(33, 135, 86, 16);
		contentPane.add(lblCdigoUsurio);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(63, 164, 56, 16);
		contentPane.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(80, 193, 39, 16);
		contentPane.add(lblValor);
		
		JLabel lblDataReceita = new JLabel("Data Receita");
		lblDataReceita.setBounds(40, 222, 79, 16);
		contentPane.add(lblDataReceita);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setBounds(135, 132, 56, 22);
		contentPane.add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(135, 161, 309, 22);
		contentPane.add(txtDescricao);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(135, 190, 116, 22);
		contentPane.add(txtValor);
		
		txtDtaReceita = new JTextField();
		txtDtaReceita.setColumns(10);
		txtDtaReceita.setBounds(135, 222, 116, 22);
		contentPane.add(txtDtaReceita);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarReceita();
			}
		});
		btnCadastrar.setBounds(33, 412, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdUsuario.setText("");
				txtDescricao.setText("");
				txtValor.setText("");
				txtDtaReceita.setText("");
			}
		});
		btnLimpar.setBounds(155, 412, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmReceita().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(285, 412, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(407, 412, 97, 25);
		contentPane.add(btnSair);
	}
	
	private void cadastrarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		receitaVO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
		
		receitaVO.setDescricao(txtDescricao.getText());
		
		receitaVO.setValor(Double.parseDouble(txtValor.getText()));
		
		receitaVO.setDataReceita(LocalDate.parse(txtDtaReceita.getText(), formataDate));
				
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.cadastrarReceitaController(receitaVO);
		
	}

}
