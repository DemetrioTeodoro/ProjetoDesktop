package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCadastrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastrarUsuario frame = new FrmCadastrarUsuario();
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
	public FrmCadastrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarUsurio = new JLabel("Cadastrar Usuário");
		lblCadastrarUsurio.setFont(new Font("Calibri", Font.BOLD, 30));
		lblCadastrarUsurio.setForeground(Color.BLUE);
		lblCadastrarUsurio.setBounds(155, 35, 237, 37);
		contentPane.add(lblCadastrarUsurio);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 127, 56, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(36, 156, 56, 16);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(12, 185, 56, 16);
		contentPane.add(lblTelefone);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(26, 214, 36, 16);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(26, 244, 56, 16);
		contentPane.add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setBounds(84, 124, 455, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(84, 153, 213, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(84, 182, 213, 22);
		contentPane.add(txtTelefone);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(84, 211, 213, 22);
		contentPane.add(txtLogin);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(84, 241, 213, 22);
		contentPane.add(txtSenha);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarUsuario();
				
			}
		});
		btnIncluir.setBounds(26, 400, 97, 25);
		contentPane.add(btnIncluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCpf.setText("");
				txtTelefone.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
			}
		});
		btnLimpar.setBounds(158, 400, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmUsuario().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(295, 400, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(424, 400, 97, 25);
		contentPane.add(btnSair);
			
		
	}
	
	private void cadastrarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setNome(txtNome.getText());
		
		usuarioVO.setCpf(txtCpf.getText());
		
		usuarioVO.setTelefone(txtTelefone.getText());
		
		usuarioVO.setLogin(txtLogin.getText());
		
		usuarioVO.setSenha(txtSenha.getText());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.cadastrarUsuarioController(usuarioVO);
		
	}


	
	
}
