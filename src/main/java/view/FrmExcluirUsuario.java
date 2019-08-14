package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmExcluirUsuario extends JFrame {

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
					FrmExcluirUsuario frame = new FrmExcluirUsuario();
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
	public FrmExcluirUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExcluirUsurio = new JLabel("Excluir Usuário");
		lblExcluirUsurio.setForeground(Color.BLUE);
		lblExcluirUsurio.setFont(new Font("Calibri", Font.BOLD, 30));
		lblExcluirUsurio.setBounds(164, 35, 200, 37);
		contentPane.add(lblExcluirUsurio);
		
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
			}
		});
		btnConsultar.setBounds(158, 138, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setBounds(24, 395, 97, 25);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(158, 395, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmUsuario().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(288, 395, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(414, 395, 97, 25);
		contentPane.add(btnSair);
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
	
	private void excluirUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setIdUsuario(Integer.parseInt(txtID.getText()));		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.excluirUsuarioController(usuarioVO);
		
	}
}
