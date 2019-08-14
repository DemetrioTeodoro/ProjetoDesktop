package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

public class FrmExibirUsuario extends JFrame {

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
					FrmExibirUsuario frame = new FrmExibirUsuario();
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
	public FrmExibirUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExibirUsuario = new JLabel("Exibir Usuário");
		lblExibirUsuario.setForeground(Color.BLUE);
		lblExibirUsuario.setFont(new Font("Calibri", Font.BOLD, 30));
		lblExibirUsuario.setBounds(151, 35, 205, 37);
		contentPane.add(lblExibirUsuario);
		
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
			
		btnConsultar.setBounds(161, 138, 97, 25);
		contentPane.add(btnConsultar);
		
		JButton btnExibirTodos = new JButton("Exibir Todos");
		btnExibirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmExibirTodosUsuarios().setVisible(true);
				dispose();
			}
		});
		btnExibirTodos.setBounds(25, 395, 106, 25);
		contentPane.add(btnExibirTodos);
		
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
		btnLimpar.setBounds(151, 395, 106, 25);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmUsuario().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(279, 395, 106, 25);
		contentPane.add(btnVoltar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(412, 395, 106, 25);
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

}
