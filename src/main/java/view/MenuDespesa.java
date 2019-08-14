package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraDespesa;

import model.vo.DespesaVO;




public class MenuDespesa {
	
Scanner teclado = new Scanner(System.in);
DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CADASTRAR_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_DESPESA = 3;
	private static final int OPCAO_MENU_EXCLUIR_DESPESA = 4;
	private static final int OPCAO_MENU_DESPESA_SAIR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_DESPESAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_DESPESA = 2;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA_SAIR = 3;
	
	
	public void apresentarMenuDespesa() {
		
			int opcao = this. apresentarOpcoesMenu();
			while (opcao != OPCAO_MENU_DESPESA_SAIR) {
				switch(opcao) {
				case OPCAO_MENU_CADASTRAR_DESPESA: {
					this.cadastrarDespesa();
					break;
				}
				case OPCAO_MENU_CONSULTAR_DESPESA: {
					this.consultarDespesa();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_DESPESA: {
					this.atualizarDespesa();
					break;
				}
				case OPCAO_MENU_EXCLUIR_DESPESA: {
					this.excluirDespesa();
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
			System.out.println("\nDr. Muquirana - Controle de Gastos \n-------- Menu Cadastro Despesas --------");
			System.out.println("\nOpções: ");
			System.out.println(OPCAO_MENU_CADASTRAR_DESPESA + " - Cadastrar Despesa");
			System.out.println(OPCAO_MENU_CONSULTAR_DESPESA + " - Consultar Despesa");
			System.out.println(OPCAO_MENU_ATUALIZAR_DESPESA + " - Atualizar Despesa");
			System.out.println(OPCAO_MENU_EXCLUIR_DESPESA + " - Excluir Despesa");
			System.out.println(OPCAO_MENU_DESPESA_SAIR + " - Voltar");
			System.out.print("\nDigite a opção: ");
			return Integer.parseInt(teclado.nextLine());
			
		}
		
		private void excluirDespesa() {
			DespesaVO despesaVO = new DespesaVO();
			System.out.print("\nDigite o código da despesa: ");
			despesaVO.setId(Integer.parseInt(teclado.nextLine()));		
			ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
			controladoraDespesa.excluirDespesaController(despesaVO);
			
		}

		private void atualizarDespesa() {
			DespesaVO despesaVO = new DespesaVO();
			System.out.print("\nDigite o Id da despesa: ");
			despesaVO.setId(Integer.parseInt(teclado.nextLine()));
			
			System.out.print("\nDigite o Id do usuário: ");
			despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
			
			System.out.print("\nDigite a descrição da despesa: ");
			despesaVO.setDescricao(teclado.nextLine());
			
			System.out.print("\nDigite o valor da despesa: ");
			despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
			
			System.out.print("\nDigite a data de vencimento da despesa:  ");
			despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), formataDate));
			
			System.out.print("\nDigite a data de pagamento da despesa:  ");
			despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), formataDate));
			
			System.out.print("\nDigite a categoria da despesa: ");
			despesaVO.setCategoria(teclado.nextLine());
			
			ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
			controladoraDespesa.atualizarDespesaController(despesaVO);
			
		}

		private void consultarDespesa() {
			ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
			int opcao = this.apresentarOpcoesConsulta();
			while (opcao != OPCAO_MENU_CONSULTAR_DESPESA_SAIR) {
				switch(opcao) {
				case OPCAO_MENU_CONSULTAR_TODAS_DESPESAS: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
					DespesaVO despesaVO = new DespesaVO();
					System.out.print("\nDigite o código do usuário: ");
					despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
					ArrayList<DespesaVO> listaDespesasVO = controladoraDespesa.consultarTodasDespesasController(despesaVO.getIdUsuario()); 
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n %10s %-10s  %-20s  %-10s  %-15s %-15 %-15 \n", "IDDESPESA", "IDUSUÁRIO", "DESCRIÇÃO", "VALOR",
							"DATAVENCIMENTO", "DATAPAGAMENTO","CATEGORIA");
					for (int i = 0; i < listaDespesasVO.size(); i++) {
						listaDespesasVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UMA_DESPESA: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
					DespesaVO despesaVO = new DespesaVO();
					System.out.print("\nDigite o código da despesa: ");
					despesaVO.setId(Integer.parseInt(teclado.nextLine()));
					DespesaVO despesa = controladoraDespesa.consultarDespesaController(despesaVO);
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n %10s %-10s  %-20s  %-10s  %-15s %-15 %-15 \n", "IDDESPESA", "IDUSUÁRIO", "DESCRIÇÃO", "VALOR",
							"DATA VENCIMENTO", "DATA PAGAMENTO","CATEGORIA");
					despesa.imprimir();
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
			System.out.println(OPCAO_MENU_CONSULTAR_TODAS_DESPESAS + " - Consultar todos as despesas do usúario. ");
			System.out.println(OPCAO_MENU_CONSULTAR_UMA_DESPESA + " - Consultar uma despesa especifica. ");
			System.out.println(OPCAO_MENU_CONSULTAR_DESPESA_SAIR + " - Voltar");
			System.out.print("\nDigite a opção: ");
			return Integer.parseInt(teclado.nextLine());
			
		}

		private void cadastrarDespesa() {
			DespesaVO despesaVO = new DespesaVO();
			System.out.print("\nDigite o Id do usuário: ");
			despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
			
			System.out.print("\nDigite a descrição da despesa: ");
			despesaVO.setDescricao(teclado.nextLine());
			
			System.out.print("\nDigite o valor da despesa: ");
			despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
			
			System.out.print("\nDigite a data de vencimento da despesa:  ");
			despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), formataDate));
			
			System.out.print("\nDigite a data de pagamento da despesa:  ");
			despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), formataDate));
			
			System.out.print("\nDigite a categoria da despesa: ");
			despesaVO.setCategoria(teclado.nextLine());
			
			ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
			controladoraDespesa.cadastrarDespesaController(despesaVO);
			
		}
		
}
