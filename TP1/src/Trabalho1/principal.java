package Trabalho1;

import java.util.Scanner;

public class principal {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Cliente[] clientesCad = new Cliente[50];
		Products[] produtos = new Products[50];
		int numClientes = 10;
		int numProdutos = 10;
		preCliCad(clientesCad);
		preProCad(produtos);
		
		int escolha;

		System.out.println("Bem vind@, por favor, escolha uma das op��es, ao digitar o n�mero correspondente � ela:");
		menu();
		escolha = ler.nextInt();
		while (escolha != 7) {
			switch (escolha) {
			case 1:
				System.out.println("Voc� selecionou o Cadastro de um Novo Cliente");
				numClientes = (primeiraOp(ler, clientesCad, numClientes));
				break;
			case 2:
				System.out.println("Voc� selecionou a Busca por Cliente");
				segundaOp(numClientes, ler, clientesCad);
				break;
			case 3:
				System.out.println("Voc� selecionou o Cadastro de um novo Produto");
				numProdutos = terceiraOp(ler, numProdutos, produtos);
				break;
			case 4:
				System.out.println("Voc� selecionou a Busca por Produto");
				quartaOp(ler, numProdutos, produtos);
				break;
			case 5:
				System.out.println("Voc� selecionou o Cadastro de Venda");
				quintaOp(ler, numClientes, clientesCad, numProdutos, produtos);
				break;
			case 6:
				System.out.println("Voc� selecionou a Amostragem de produtos em estoque");
				sextaOp(ler, numProdutos, produtos);
				break;
			default:
				System.out.println("Voc� n�o selecionou nenhuma das op��es");

			}
			System.out.println("\n\nPor favor, escolha uma das op��es, ao digitar o n�mero correspondente � ela:");
			menu();
			escolha = ler.nextInt();
		}
		System.out.print("Obrigado!");

	}

	// Menu
	public static void menu() {
		System.out.println("\t Escolhas \t");
		System.out.println("1�) Cadastro de novo Cliente");
		System.out.println("2�) Busca por Cliente");
		System.out.println("3�) Cadastro de novo Produto");
		System.out.println("4�) Busca por Produto");
		System.out.println("5�) Cadastro de Venda");
		System.out.println("6�) Mostrar Produtos em Estoque");
		System.out.println("7�) Sair");

	}

	// primeira op��o
	public static int primeiraOp(Scanner ler, Cliente[] clientesCad, int numClientes) {
		int num = 0;
		int i;
		System.out.println("Insira a quantidade de clientes a serem cadastrados");
		num = ler.nextInt();
		ler.nextLine();
		if (num <= 0) {
			System.out.print("Quantidade inv�lida!");
			num = 0;
		} else {
			for (i = numClientes; i < (num + numClientes); i++) {
				clientesCad[i] = new Cliente();
				System.out.println("Digite o nome do " + (i + 1) + "� cliente: ");
				clientesCad[i].setNome(ler.nextLine());

				System.out.println("Digite o endere�o do " + (i + 1) + "� cliente: ");
				clientesCad[i].setEndere�o(ler.nextLine());

				System.out.println("Digite o telefone do " + (i + 1) + "� cliente: ");
				clientesCad[i].setTelefone(ler.nextLine());
			}
		}
		num = num + numClientes;
		return num;
	}

	// segunda op��o
	public static void segundaOp(int numClientes, Scanner ler, Cliente[] clientesCad) {
		int localArray = 0;
		int mudar;
		String procuraNome;
		boolean clienteEncontrado = false;
		ler.nextLine();
		System.out.println("Coloque o nome a ser pesquisado: ");
		procuraNome = ler.nextLine();
		for (int j = 0; j < numClientes; j++) {
			if (clientesCad[j].getNome().equalsIgnoreCase(procuraNome)) {
				clienteEncontrado = true;
				localArray = j;
				break;
			}
		}
		if (clienteEncontrado == true) {
			System.out.println("Cliente Encontrado!");
			System.out.println("Nome: " + clientesCad[localArray].getNome());
			System.out.println("Telefone: " + clientesCad[localArray].getTelefone());
			System.out.println("Endere�o: " + clientesCad[localArray].getEndere�o());
			System.out.println("Voc� deseja alterar os dados do usu�rio encontrado?");
			System.out.println("Se sim, digite a tecla '8', caso contr�rio, digite qualquer outra tecla num�rica");
			mudar = ler.nextInt();
			ler.nextLine();
			if (mudar == 8) {
				System.out.println("Digite o novo Nome do " + (localArray + 1) + "� cliente: ");
				clientesCad[localArray].setNome(ler.nextLine());
				System.out.println("Digite o novo Endere�o do " + (localArray + 1) + "� cliente: ");
				clientesCad[localArray].setEndere�o(ler.nextLine());
				System.out.println("Digite o novo Telefone do " + (localArray + 1) + "� cliente: ");
				clientesCad[localArray].setTelefone(ler.nextLine());
				System.out.println("Seguem os novos dados do cliente: ");
				System.out.println("Nome: " + clientesCad[localArray].getNome());
				System.out.println("Endere�o: " + clientesCad[localArray].getEndere�o());
				System.out.println("Telefone: " + clientesCad[localArray].getTelefone());
			}

		} else {
			System.out.println("Cliente n�o Encontrado!");
		}

	}

	// terceira op��o
	public static int terceiraOp(Scanner ler, int numProdutos, Products[] produtos) {
		int num = 0;
		int i;
		System.out.println("Insira a quantidade de produtos a serem cadastrados");
		num = ler.nextInt();
		ler.nextLine();
		if (num <= 0) {
			System.out.print("Quantidade inv�lida!");
			num = 0;
		} else {
			for (i = numProdutos; i < (num + numProdutos); i++) {
				produtos[i] = new Products();
				System.out.println("Digite o nome do " + (i + 1) + "� produto: ");
				produtos[i].setNome(ler.nextLine());
				System.out.println("Digite o valor da compra do " + (i + 1) + "� produto: ");
				produtos[i].setValorCompra(ler.nextDouble());
				System.out.println("Digite a descri��o do " + (i + 1) + "� produto: ");
				produtos[i].setDescri��o(ler.nextLine());
				ler.nextLine();
				System.out.println("Digite a porcentagem de lucro do " + (i + 1) + "� produto: ");
				produtos[i].setLucro(ler.nextFloat());
				System.out.println("Digite a quantidade presente no estoque " + (i + 1) + "� produto: ");
				produtos[i].setQuantEstoque(ler.nextInt());
				ler.nextLine();
			}
		}
		num = num + numProdutos;
		return num;
	}

	// quarta op��o
	public static void quartaOp(Scanner ler, int numProdutos, Products[] produtos) {
		int localArray = 0;
		int mudar;
		String procuraNome;
		boolean produtoEncontrado = false;
		ler.nextLine();
		System.out.println("Coloque o nome do produto a ser pesquisado: ");
		procuraNome = ler.nextLine();
		for (int j = 0; j < numProdutos; j++) {
			if (produtos[j].getNome().equalsIgnoreCase(procuraNome)) {
				produtoEncontrado = true;
				localArray = j;
				break;
			}
		}
		if (produtoEncontrado == true) {
			System.out.println("Produto Encontrado!");
			System.out.println("Nome: " + produtos[localArray].getNome());
			System.out.println("Valor de Compra: " + produtos[localArray].getValorCompra());
			System.out.println("Descri��o: " + produtos[localArray].getDescri��o());
			System.out.println("Margem de lucro: " + produtos[localArray].getlucro());
			System.out.println("Quantidade em estoque: " + produtos[localArray].getQuantEstoque());
			System.out.println("Voc� deseja alterar os dados do produto encontrado?");
			System.out.println("Se sim, digite a tecla '8', caso contr�rio, digite qualquer outra tecla num�rica");
			mudar = ler.nextInt();
			ler.nextLine();
			if (mudar == 8) {
				System.out.println("Digite o novo Nome do Produto: ");
				produtos[localArray].setNome(ler.nextLine());
				System.out.println("Digite o novo valor de compra do Produto: ");
				produtos[localArray].setValorCompra(ler.nextDouble());
				System.out.println("Digite o nova descri��o do Produto: ");
				produtos[localArray].setDescri��o(ler.nextLine());
				System.out.println("Digite a nova porcentagem de lucro do Produto: ");
				produtos[localArray].setLucro(ler.nextFloat());
				System.out.println("Digite a nova quantidade em estoque do Produto: ");
				produtos[localArray].setQuantEstoque(ler.nextInt());

			} else {
				System.out.println("Produto n�o Encontrado!");
			}
		}
	}

	// quinta op��o
	public static void quintaOp(Scanner ler, int numClientes, Cliente[] clientesCad, int numProdutos, Products[] produtos) {
		int j;
		int k;
		int t;
		String a;
		for (int i = 0; i < numClientes; i++) {
			System.out.println((i + 1) + "� Cliente: " + clientesCad[i].getNome());

		}
		System.out.println("Essa � uma lista com o nome de todos os clientes cadastrados, para escolher um, digite o n�mero correspondente � ele.");
		j = ler.nextInt();
		if (j > numClientes || j <= 0) {
			System.out.println("Quantidade inv�lida!");
		} else {
			j = j - 1;
			do {
				for (int i = 0; i < numProdutos; i++) {
					System.out.println((i + 1) + "� Produto: " + produtos[i].getNome());
				}
				System.out.println("Essa � uma lista com o nome de todos os produtos cadastrados, para escolher um, digite o n�mero correspondente � ele.");
				k = ler.nextInt();
				while (k > numProdutos || k <= 0) {
					System.out.println("Quantidade inv�lida, digite novamente");
					k = ler.nextInt();
				}
				k = k - 1;
				System.out.println("Digite a quantidade do produto selecionado que foi vendida para o cliente em quest�o.");
				t = ler.nextInt();
				while (t > produtos[k].getQuantEstoque() || t <= 0) {
					System.out.println("Quantidade inv�lida, digite novamente.");
					t = ler.nextInt();
				}
				ler.nextLine();
				produtos[k].setQuantEstoque((produtos[k].getQuantEstoque())-t);
				System.out.println("Voc� deseja cadastrar mais uma venda para esse cliente?");
				System.out.println("\nSe a resposta for sim, escreva sim, caso contr�rio, digite outra tecla.");
				a = ler.nextLine();
			} while (a.equalsIgnoreCase("sim"));
				System.out.println("Cadastro de venda realizado com sucesso :)");
		}			
	}
	//sexta op��o
	public static void sextaOp(Scanner ler, int numProdutos, Products[] produtos ) {
		for (int i = 0; i < numProdutos; i++) {
			System.out.println((i + 1) + "� Produto: " + produtos[i].getNome()+ " -- Quantidade em estoque: "+ produtos[i].getQuantEstoque());
		}
	}
	//cliente pr� - cadastrados
	public static void preCliCad (Cliente[] clientesCad) {
		for (int i=0; i<10; i++) {
			clientesCad[i] = new Cliente();
			
		}
		clientesCad[0].setNome("Jo�o Pedro");
		clientesCad[0].setTelefone("61 99876-4458");
		clientesCad[0].setEndere�o("�guas Claras");
		clientesCad[1].setNome("Henrique Meng�o");
		clientesCad[1].setTelefone("244 931 926 016");
		clientesCad[1].setEndere�o("Rua Ceni Lote 5 Casa 6");
		clientesCad[2].setNome("Toger");
		clientesCad[2].setTelefone("61 99984-5550");
		clientesCad[2].setEndere�o("Vicente Pires Rua 8");
		clientesCad[3].setNome("Theo");
		clientesCad[3].setTelefone("61 98147-6693");
		clientesCad[3].setEndere�o("�guas Claras Rua 22 Norte");
		clientesCad[4].setNome("Benitez");
		clientesCad[4].setTelefone("61 98155-1750");
		clientesCad[4].setEndere�o("S�o Paulo, Capital");
		clientesCad[5].setNome("Kheyze");
		clientesCad[5].setTelefone("61 98182-0403");
		clientesCad[5].setEndere�o("Sobradinho");
		clientesCad[6].setNome("Lucigol");
		clientesCad[6].setTelefone("61 98212-4562");
		clientesCad[6].setEndere�o("Vicente Pires, Rua 10");
		clientesCad[7].setNome("Heitoba");
		clientesCad[7].setTelefone("61 98330-9513");
		clientesCad[7].setEndere�o("Gama");
		clientesCad[8].setNome("Rigoni");
		clientesCad[8].setTelefone("61 99398-7470");
		clientesCad[8].setEndere�o("Asa Sul");
		clientesCad[9].setNome("Thiago Volpi");
		clientesCad[9].setTelefone("61 99333-3162");
		clientesCad[9].setEndere�o("Jardim Bot�nico");
		
	}
	//produtos pr� - cadastrados
	public static void preProCad (Products[] produtos) {
		for (int i=0; i<10; i++) {
			produtos[i] = new Products();
		}
		produtos[0].setNome("P�o de Forma");
		produtos[0].setValorCompra(3);
		produtos[0].setDescri��o("Alimento");
		produtos[0].setLucro(30);
		produtos[0].setQuantEstoque(100);
		produtos[1].setNome("Saco de Arroz");
		produtos[1].setValorCompra(11);
		produtos[1].setDescri��o("Alimento");
		produtos[1].setLucro(20);
		produtos[1].setQuantEstoque(150);
		produtos[2].setNome("Desodorante");
		produtos[2].setValorCompra(13);
		produtos[2].setDescri��o("Higiene Pessoal");
		produtos[2].setLucro(20);
		produtos[2].setQuantEstoque(110);
		produtos[3].setNome("Sabonete");
		produtos[3].setValorCompra(5);
		produtos[3].setDescri��o("Higiene Pessoal");
		produtos[3].setLucro(10);
		produtos[3].setQuantEstoque(50);
		produtos[4].setNome("Iorgute");
		produtos[4].setValorCompra(3.90);
		produtos[4].setDescri��o("Alimento");
		produtos[4].setLucro(25);
		produtos[4].setQuantEstoque(170);
		produtos[5].setNome("Picanha");
		produtos[5].setValorCompra(65.50);
		produtos[5].setDescri��o("Alimento");
		produtos[5].setLucro(60);
		produtos[5].setQuantEstoque(30);
		produtos[6].setNome("Papel Higi�nico");
		produtos[6].setValorCompra(11.50);
		produtos[6].setDescri��o("Higiene");
		produtos[6].setLucro(34);
		produtos[6].setQuantEstoque(132);
		produtos[7].setNome("Papel Toalha");
		produtos[7].setValorCompra(9.50);
		produtos[7].setDescri��o("Limpeza");
		produtos[7].setLucro(40);
		produtos[7].setQuantEstoque(120);
		produtos[8].setNome("Vassouras");
		produtos[8].setValorCompra(23.90);
		produtos[8].setDescri��o("Limpeza");
		produtos[8].setLucro(7);
		produtos[8].setQuantEstoque(85);
		produtos[9].setNome("QiBoa");
		produtos[9].setValorCompra(6.50);
		produtos[9].setDescri��o("Limpeza");
		produtos[9].setLucro(39);
		produtos[9].setQuantEstoque(210);
		
	}
	
}
