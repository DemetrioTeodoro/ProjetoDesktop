package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraDespesa;
import controller.ControladoraReceita;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;

public class MenuReceita {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_RECEITA_SAIR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_RECEITAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_RECEITA = 2;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA_SAIR = 3;
	
	public void apresentarMenuReceita() {
		int opcao = this. apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_RECEITA_SAIR) {
			switch(opcao) {
			case OPCAO_MENU_CADASTRAR_RECEITA: {
				this.cadastrarReceita();
				break;
			}
			case OPCAO_MENU_CONSULTAR_RECEITA: {
				this.consultarReceita();
				break;
			}
			case OPCAO_MENU_ATUALIZAR_RECEITA: {
				this.atualizarReceita();
				break;
			}
			case OPCAO_MENU_EXCLUIR_RECEITA: {
				this.excluirReceita();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
			}
			
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}


	private int apresentarOpcoesMenu() {
		System.out.println("\nDr. Muquirana - Controle de Gastos \n-------- Menu Cadastro Receita --------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_CADASTRAR_RECEITA + " - Cadastrar Receita");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA + " - Consultar Receita");
		System.out.println(OPCAO_MENU_ATUALIZAR_RECEITA + " - Atualizar Receita");
		System.out.println(OPCAO_MENU_EXCLUIR_RECEITA + " - Excluir Receita");
		System.out.println(OPCAO_MENU_RECEITA_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
		
	}
	
	private void excluirReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nDigite o código da receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.excluirReceitaController(receitaVO);
		
	}

	private void atualizarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nDigite o Id da receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
		
		System.out.print("\nDigite o Id do usuário: ");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		System.out.print("\nDigite a descrição da receita: ");
		receitaVO.setDescricao(teclado.nextLine());
		
		System.out.print("\nDigite o valor da receita: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		
		System.out.print("\nDigite a data da receita:  ");
		receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), formataDate));
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.atualizarReceitaController(receitaVO);
		
	}

	private void consultarReceita() {
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		int opcao = this.apresentarOpcoesConsulta();
		while (opcao != OPCAO_MENU_CONSULTAR_RECEITA_SAIR) {
			switch(opcao) {
			case OPCAO_MENU_CONSULTAR_TODAS_RECEITAS: {
				opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
				ReceitaVO receitaVO = new ReceitaVO();
				System.out.print("\nDigite o código do usuário: ");
				receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				ArrayList<ReceitaVO> listaReceitaVO = controladoraReceita.consultarTodasReceitasController(receitaVO.getIdUsuario()); 
				System.out.println("\n-------- RESULTADO DA CONSULTA --------");
				System.out.printf("\n %10s %-10s  %-20s  %-10s  %-15s \n", "IDRECEITA", "IDUSUÁRIO", "DESCRIÇÃO", "VALOR",
						"DATARECEITA");
				for (int i = 0; i < listaReceitaVO.size(); i++) {
					listaReceitaVO.get(i).imprimir();
				}
				break;
			}
			case OPCAO_MENU_CONSULTAR_UMA_RECEITA: {
				opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
				ReceitaVO receitaVO = new ReceitaVO();
				System.out.print("\nDigite o código da receita: ");
				receitaVO.setId(Integer.parseInt(teclado.nextLine()));
				ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
				System.out.println("\n-------- RESULTADO DA CONSULTA --------");
				System.out.printf("\n %10s %-10  %-20s  %-10s  %-15s \n", "IDRECEITA", "IDUSUÁRIO", "DESCRIÇÃO", "VALOR",
						"DATARECEITA");
				receita.imprimir();
				break;
			}
			default: {
				System.out.println("\nOpção Inválida");
				opcao = this.apresentarOpcoesConsulta();
			}
			
			}
			
		}
		
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada.");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_RECEITAS + " - Consultar todos as receitas do usúario. ");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_RECEITA + " - Consultar uma receita especifica. ");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
		
	}

	private void cadastrarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nDigite o Id do usuário: ");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		System.out.print("\nDigite a descrição da receita: ");
		receitaVO.setDescricao(teclado.nextLine());
		
		System.out.print("\nDigite o valor da receita: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		
		System.out.print("\nDigite a data da receita:  ");
		receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), formataDate));
		
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.cadastrarReceitaController(receitaVO);
		
	}
		
	
}