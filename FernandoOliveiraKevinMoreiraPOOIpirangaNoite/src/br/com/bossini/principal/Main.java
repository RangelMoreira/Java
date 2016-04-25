package br.com.bossini.principal;

import java.util.Scanner;

import br.com.bossini.modelo.Conta;
import br.com.bossini.modelo.Usuario;
import br.com.bossini.persistencia.ContaDAO;
import br.com.bossini.persistencia.MetaDAO;
import br.com.bossini.persistencia.MovimentacaoDAO;
import br.com.bossini.persistencia.UsuarioDAO;



public class Main {

	public static void main(String[] args)throws Exception {
		
		int op;
		UsuarioDAO dao = new UsuarioDAO();
		ContaDAO cdao = new ContaDAO();
		MetaDAO medao = new MetaDAO();
		Scanner s = new Scanner (System.in);
		//menu principal da aplicação
		do {
			System.out.println("Faça sua escolha ");
			System.out.println("1-Inserir usuário");
			System.out.println("2-Inserir conta");
			System.out.println("3-Listar Movimentações (Crédito) ");
			System.out.println("4-Exibir movimentações de uma empresa");
			System.out.println("5-Exibir metas que estão em vigência para a data atual");
			System.out.println("-1-Para sair");
			op = s.nextInt();
			switch (op){
				case 1:
					//aqui deve ser feita a inserção de um usuário cujos dados serão capturados via Scanner
					try {
						s.nextLine();
						System.out.println("Digite o nome sem espacos");
						String nome = s.next();
						s.nextLine();
						System.out.println("Digite o usuário sem espacos");
						String login = s.next();
						s.nextLine();
						System.out.println("Digite a senha sem espacos");
						String senha = s.next();
						Usuario us = new Usuario(login,senha,nome);
						dao.inserir(us);
						System.out.println("Dados inseridos com sucesso");
						
						break;
						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Impossível inserir "+e.getMessage());
					}
					break;
				case 2: //aqui deve ser feita a inserção de uma conta (para um usuário já cadastrado) cujos dados o usuário vai digitar
					try{
						s.nextLine();
						System.out.println("Digite o nome de usuario");
						String nome = s.next();
						s.nextLine();
						System.out.println("Digite o Login");
						String login = s.next();
						s.nextLine();
						System.out.println("Digite a senha");
						String senha = s.next();
						
						Usuario us = new Usuario(login,senha,nome);
						if (dao.verificarSeUsuarioExiste(us)==true){
						
							s.nextLine();
							System.out.println("Digite o nome da conta");
							String nomeConta = s.next();
							s.nextLine();
							System.out.println("Digite o tipo da conta");
							String tipoConta = s.next();
							s.nextLine();
							System.out.println("Digite a descricao da conta");
							String descricaoConta = s.next();
							s.nextLine();
							System.out.println("Digite o saldo de segurança(separados por virgula, se necessario)");
							double saldoSeguranca = s.nextDouble();
							Conta co = new Conta(nomeConta,tipoConta,descricaoConta,saldoSeguranca,login);
							cdao.Inserir(co);
							System.out.println("Conta inserida com sucesso!");
						}
						else{
							System.out.println("Usuario não existente.");						
						}

					}
					catch(Exception e){
						System.out.println("Impossível inserir "+e.getMessage());
					}					
					break;
				case 3:	//aqui deve ser feita a listagem de movimentações (somente crédito) de um usuário
					try{
						System.out.println("Insira o numero da sua conta");						
						int nConta= s.nextInt();
						
						if (cdao.verificarSeContaExiste(nConta)){
							MovimentacaoDAO mdao = new MovimentacaoDAO();
							System.out.println(mdao.listarMovimentacao(nConta).toString());							
						}
						else{
							System.out.println("Conta inexistente");
						}
					}
					catch(Exception e){
						System.out.println("Não foi possivel trazer as movimentaçoes: " + e.getMessage());
					}
					
					break;
				case 4: //aqui devem ser exibidas as movimentações de uma dada empresa
					try {
						s.nextLine();
						System.out.println("Entre com o nome da empresa");
						String empresa = s.next();
						s.nextLine();
						System.out.println("Entre com o numero de sua conta");
						int numConta = s.nextInt();
						
						if (cdao.verificarSeContaExiste(numConta)){
							MovimentacaoDAO mdao = new MovimentacaoDAO();
							System.out.println("movimentações: " + mdao.listarMovimentacaoEmpresa(numConta, empresa).toString());							
						}
						else{
							System.out.println("Conta inexistente");
						}
						
					} catch (Exception e) {
						// TODO: handle exception
					}										
					break;
				case 5: 	//mostrar para um usuário os dados das contas e das metas estabelecidas no período vigente, ou seja, 
							//metas que estão em vigência para a data atual.
					try{
						System.out.println("Insira seu login");
						String login = s.next();
						System.out.println(medao.obterMetasVigentes(login).toString());
					}
					catch(Exception e){
						System.out.println("Erro: " + e.getMessage());
					}					
					break;
					
					default:
						System.out.println("Opção inválida.");
						break;
					case -1:
						System.out.println("Até mais.");
						break;
			}
		} while (op != -1);
		s.close();
	}

}