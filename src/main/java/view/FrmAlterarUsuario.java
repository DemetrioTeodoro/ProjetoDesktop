package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmAlterarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
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
					FrmAlterarUsuario frame = new FrmAlterarUsuario();
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
	public FrmAlterarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarUsurio = new JLabel("Alterar Usuário");
		lblAlterarUsurio.setForeground(Color.BLUE);
		lblAlterarUsurio.setFont(new Font("Calibri", Font.BOLD, 30));
		lblAlterarUsurio.setBounds(151, 35, 205, 37);
		contentPane.add(lblAlterarUsurio);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(24, 142, 56, 16);
		contentPane.add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 171, 56, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(24, 205, 56, 16);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(24, 234, 56, 16);
		contentPane.add(lblTelefone);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(24, 263, 56, 16);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 292, 56, 16);
		contentPane.add(lblSenha);
		
		txtID = new JTextField();
		txtID.setBounds(92, 139, 56, 22);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(91, 168, 399, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setEnabled(false);
		txtCpf.setBounds(92, 202, 221, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setEnabled(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(92, 231, 221, 22);
		contentPane.add(txtTelefone);
		
		txtLogin = new JTextField();
		txtLogin.setEnabled(false);
		txtLogin.setColumns(10);
		txtLogin.setBounds(92, 260, 221, 22);
		contentPane.add(txtLogin);
		
		txtSenha = new JPasswordField();
		txtSenha.setEnabled(false);
		txtSenha.setBounds(92, 292, 221, 22);
		contentPane.add(txtSenha);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarUsuario();
				txtNome.setEnabled(true);
				txtCpf.setEnabled(true);
				txtTelefone.setEnabled(true);
				txtLogin.setEnabled(true);
				txtSenha.setEnabled(true);
			}
		});
		btnConsultar.setBounds(160, 138, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarUsuario();
			}
		});
		btnAlterar.setBounds(24, 394, 97, 25);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtNome.setText("");
				txtCpf.setText("");
				txtTelefone.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
			}
		});
		btnLimpar.setBounds(148, 394, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmUsuario().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(272, 394, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(393, 394, 97, 25);
		contentPane.add(btnFechar);
	}
	
	private void consultarUsuario() {
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		
				UsuarioVO usuarioVO = new UsuarioVO();
				
				usuarioVO.setIdUsuario(Integer.parseInt(txtID.getText()));
				UsuarioVO usuario = controladoraUsuario.consultarUsuarioController(usuarioVO);
				txtNome.setText(usuario.getNome());
				txtCpf.setText(usuario.getCpf());
				txtTelefone.setText(usuario.getTelefone());
				txtLogin.setText(usuario.getLogin());
				txtSenha.setText(usuario.getSenha());
				
			}
			
	private void atualizarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();

		usuarioVO.setIdUsuario(Integer.parseInt(txtID.getText()));	
		usuarioVO.setNome(txtNome.getText());
		
		usuarioVO.setCpf(txtCpf.getText());
		
		usuarioVO.setTelefone(txtTelefone.getText());
		
		usuarioVO.setLogin(txtLogin.getText());
		
		usuarioVO.setSenha(txtSenha.getText());
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.atualizarUsuarioController(usuarioVO);
		
	}

	
}
