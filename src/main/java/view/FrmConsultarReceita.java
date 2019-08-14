package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladoraReceita;
import model.vo.ReceitaVO;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class FrmConsultarReceita extends JFrame {
	
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
					FrmConsultarReceita frame = new FrmConsultarReceita();
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
	public FrmConsultarReceita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultarReceita = new JLabel("Consultar Receita");
		lblConsultarReceita.setFont(new Font("Calibri", Font.BOLD, 30));
		lblConsultarReceita.setForeground(Color.BLUE);
		lblConsultarReceita.setBounds(194, 32, 218, 37);
		contentPane.add(lblConsultarReceita);
		
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
			}
		});
		btnConsultar.setBounds(203, 110, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnConsultarTodos = new JButton("Consultar Todos");
		btnConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultarTodos.setBounds(48, 416, 125, 25);
		contentPane.add(btnConsultarTodos);
		
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
		btnLimpar.setBounds(203, 416, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmReceita().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(326, 416, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnFachar = new JButton("Fechar");
		btnFachar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFachar.setBounds(450, 416, 97, 25);
		contentPane.add(btnFachar);
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
}
