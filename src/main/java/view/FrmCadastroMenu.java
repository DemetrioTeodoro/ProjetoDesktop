package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCadastroMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmCadastroMenu dialog = new FrmCadastroMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmCadastroMenu() {
		setBounds(100, 100, 585, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMenuCadastro = new JLabel("Menu Cadastro");
			lblMenuCadastro.setForeground(Color.BLUE);
			lblMenuCadastro.setFont(new Font("Calibri", Font.BOLD, 30));
			lblMenuCadastro.setBounds(173, 31, 204, 37);
			contentPanel.add(lblMenuCadastro);
		}
		{
			JButton btnUsurio = new JButton("usuário");
			btnUsurio.setBounds(209, 126, 97, 25);
			contentPanel.add(btnUsurio);
		}
		{
			JButton btnReceita = new JButton("Receita");
			btnReceita.setBounds(209, 196, 97, 25);
			contentPanel.add(btnReceita);
		}
		{
			JButton btnDespesa = new JButton("Despesa");
			btnDespesa.setBounds(209, 267, 97, 25);
			contentPanel.add(btnDespesa);
		}
		{
			final JButton btnVoltar = new JButton("Voltar");
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				  btnVoltar.setVisible(false);
				  
				}
			});
			btnVoltar.setBounds(209, 344, 97, 25);
			contentPanel.add(btnVoltar);
		}
	}

}
