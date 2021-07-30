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

		System.out.println("Bem vind@, por favor, escolha uma das opções, ao digitar o número correspondente à ela:");
		menu();
		escolha = ler.nextInt();
		while (escolha != 7) {
			switch (escolha) {
			case 1:
				System.out.println("Você selecionou o Cadastro de um Novo Cliente");
				numClientes = (primeiraOp(ler, clientesCad, numClientes));
				break;
			case 2:
				System.out.println("Você selecionou a Busca por Cliente");
				segundaOp(numClientes, ler, clientesCad);
				break;
			case 3:
				System.out.println("Você selecionou o Cadastro de um novo Produto");
				numProdutos = terceiraOp(ler, numProdutos, produtos);
				break;
			case 4:
				System.out.println("Você selecionou a Busca por Produto");
				quartaOp(ler, numProdutos, produtos);
				break;
			case 5:
				System.out.println("Você selecionou o Cadastro de Venda");
				quintaOp(ler, numClientes, clientesCad, numProdutos, produtos);
				break;
			case 6:
				System.out.println("Você selecionou a Amostragem de produtos em estoque");
				sextaOp(ler, numProdutos, produtos);
				break;
			default:
				System.out.println("Você não selecionou nenhuma das opções");

			}
			System.out.println("\n\nPor favor, escolha uma das opções, ao digitar o número correspondente à ela:");
			menu();
			escolha = ler.nextInt();
		}
		System.out.print("Obrigado!");

	}

	// Menu
	public static void menu() {
		System.out.println("\t Escolhas \t");
		System.out.println("1º) Cadastro de novo Cliente");
		System.out.println("2º) Busca por Cliente");
		System.out.println("3º) Cadastro de novo Produto");
		System.out.println("4º) Busca por Produto");
		System.out.println("5º) Cadastro de Venda");
		System.out.println("6º) Mostrar Produtos em Estoque");
		System.out.println("7º) Sair");

	}

	// primeira opção
	public static int primeiraOp(Scanner ler, Cliente[] clientesCad, int numClientes) {
		int num = 0;
		int i;
		System.out.println("Insira a quantidade de clientes a serem cadastrados");
		num = ler.nextInt();
		ler.nextLine();
		if (num <= 0) {
			System.out.print("Quantidade inválida!");
			num = 0;
		} else {
			for (i = numClientes; i < (num + numClientes); i++) {
				clientesCad[i] = new Cliente();
				System.out.println("Digite o nome do " + (i + 1) + "º cliente: ");
				clientesCad[i].setNome(ler.nextLine());

				System.out.println("Digite o endereço do " + (i + 1) + "º cliente: ");
				clientesCad[i].setEndereço(ler.nextLine());

				System.out.println("Digite o telefone do " + (i + 1) + "º cliente: ");
				clientesCad[i].setTelefone(ler.nextLine());
			}
		}
		num = num + numClientes;
		return num;
	}

	// segunda opção
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
			System.out.println("Endereço: " + clientesCad[localArray].getEndereço());
			System.out.println("Você deseja alterar os dados do usuário encontrado?");
			System.out.println("Se sim, digite a tecla '8', caso contrário, digite qualquer outra tecla numérica");
			mudar = ler.nextInt();
			ler.nextLine();
			if (mudar == 8) {
				System.out.println("Digite o novo Nome do " + (localArray + 1) + "º cliente: ");
				clientesCad[localArray].setNome(ler.nextLine());
				System.out.println("Digite o novo Endereço do " + (localArray + 1) + "º cliente: ");
				clientesCad[localArray].setEndereço(ler.nextLine());
				System.out.println("Digite o novo Telefone do " + (localArray + 1) + "º cliente: ");
				clientesCad[localArray].setTelefone(ler.nextLine());
				System.out.println("Seguem os novos dados do cliente: ");
				System.out.println("Nome: " + clientesCad[localArray].getNome());
				System.out.println("Endereço: " + clientesCad[localArray].getEndereço());
				System.out.println("Telefone: " + clientesCad[localArray].getTelefone());
			}

		} else {
			System.out.println("Cliente não Encontrado!");
		}

	}

	// terceira opção
	public static int terceiraOp(Scanner ler, int numProdutos, Products[] produtos) {
		int num = 0;
		int i;
		System.out.println("Insira a quantidade de produtos a serem cadastrados");
		num = ler.nextInt();
		ler.nextLine();
		if (num <= 0) {
			System.out.print("Quantidade inválida!");
			num = 0;
		} else {
			for (i = numProdutos; i < (num + numProdutos); i++) {
				produtos[i] = new Products();
				System.out.println("Digite o nome do " + (i + 1) + "º produto: ");
				produtos[i].setNome(ler.nextLine());
				System.out.println("Digite o valor da compra do " + (i + 1) + "º produto: ");
				produtos[i].setValorCompra(ler.nextDouble());
				System.out.println("Digite a descrição do " + (i + 1) + "º produto: ");
				produtos[i].setDescrição(ler.nextLine());
				ler.nextLine();
				System.out.println("Digite a porcentagem de lucro do " + (i + 1) + "º produto: ");
				produtos[i].setLucro(ler.nextFloat());
				System.out.println("Digite a quantidade presente no estoque " + (i + 1) + "º produto: ");
				produtos[i].setQuantEstoque(ler.nextInt());
				ler.nextLine();
			}
		}
		num = num + numProdutos;
		return num;
	}

	// quarta opção
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
			System.out.println("Descrição: " + produtos[localArray].getDescrição());
			System.out.println("Margem de lucro: " + produtos[localArray].getlucro());
			System.out.println("Quantidade em estoque: " + produtos[localArray].getQuantEstoque());
			System.out.println("Você deseja alterar os dados do produto encontrado?");
			System.out.println("Se sim, digite a tecla '8', caso contrário, digite qualquer outra tecla numérica");
			mudar = ler.nextInt();
			ler.nextLine();
			if (mudar == 8) {
				System.out.println("Digite o novo Nome do Produto: ");
				produtos[localArray].setNome(ler.nextLine());
				System.out.println("Digite o novo valor de compra do Produto: ");
				produtos[localArray].setValorCompra(ler.nextDouble());
				System.out.println("Digite o nova descrição do Produto: ");
				produtos[localArray].setDescrição(ler.nextLine());
				System.out.println("Digite a nova porcentagem de lucro do Produto: ");
				produtos[localArray].setLucro(ler.nextFloat());
				System.out.println("Digite a nova quantidade em estoque do Produto: ");
				produtos[localArray].setQuantEstoque(ler.nextInt());

			} else {
				System.out.println("Produto não Encontrado!");
			}
		}
	}

	// quinta opção
	public static void quintaOp(Scanner ler, int numClientes, Cliente[] clientesCad, int numProdutos, Products[] produtos) {
		int j;
		int k;
		int t;
		String a;
		for (int i = 0; i < numClientes; i++) {
			System.out.println((i + 1) + "º Cliente: " + clientesCad[i].getNome());

		}
		System.out.println("Essa é uma lista com o nome de todos os clientes cadastrados, para escolher um, digite o número correspondente à ele.");
		j = ler.nextInt();
		if (j > numClientes || j <= 0) {
			System.out.println("Quantidade inválida!");
		} else {
			j = j - 1;
			do {
				for (int i = 0; i < numProdutos; i++) {
					System.out.println((i + 1) + "º Produto: " + produtos[i].getNome());
				}
				System.out.println("Essa é uma lista com o nome de todos os produtos cadastrados, para escolher um, digite o número correspondente à ele.");
				k = ler.nextInt();
				while (k > numProdutos || k <= 0) {
					System.out.println("Quantidade inválida, digite novamente");
					k = ler.nextInt();
				}
				k = k - 1;
				System.out.println("Digite a quantidade do produto selecionado que foi vendida para o cliente em questão.");
				t = ler.nextInt();
				while (t > produtos[k].getQuantEstoque() || t <= 0) {
					System.out.println("Quantidade inválida, digite novamente.");
					t = ler.nextInt();
				}
				ler.nextLine();
				produtos[k].setQuantEstoque((produtos[k].getQuantEstoque())-t);
				System.out.println("Você deseja cadastrar mais uma venda para esse cliente?");
				System.out.println("\nSe a resposta for sim, escreva sim, caso contrário, digite outra tecla.");
				a = ler.nextLine();
			} while (a.equalsIgnoreCase("sim"));
				System.out.println("Cadastro de venda realizado com sucesso :)");
		}			
	}
	//sexta opção
	public static void sextaOp(Scanner ler, int numProdutos, Products[] produtos ) {
		for (int i = 0; i < numProdutos; i++) {
			System.out.println((i + 1) + "º Produto: " + produtos[i].getNome()+ " -- Quantidade em estoque: "+ produtos[i].getQuantEstoque());
		}
	}
	//cliente pré - cadastrados
	public static void preCliCad (Cliente[] clientesCad) {
		for (int i=0; i<10; i++) {
			clientesCad[i] = new Cliente();
			
		}
		clientesCad[0].setNome("João Pedro");
		clientesCad[0].setTelefone("61 99876-4458");
		clientesCad[0].setEndereço("Águas Claras");
		clientesCad[1].setNome("Henrique Mengão");
		clientesCad[1].setTelefone("244 931 926 016");
		clientesCad[1].setEndereço("Rua Ceni Lote 5 Casa 6");
		clientesCad[2].setNome("Toger");
		clientesCad[2].setTelefone("61 99984-5550");
		clientesCad[2].setEndereço("Vicente Pires Rua 8");
		clientesCad[3].setNome("Theo");
		clientesCad[3].setTelefone("61 98147-6693");
		clientesCad[3].setEndereço("Águas Claras Rua 22 Norte");
		clientesCad[4].setNome("Benitez");
		clientesCad[4].setTelefone("61 98155-1750");
		clientesCad[4].setEndereço("São Paulo, Capital");
		clientesCad[5].setNome("Kheyze");
		clientesCad[5].setTelefone("61 98182-0403");
		clientesCad[5].setEndereço("Sobradinho");
		clientesCad[6].setNome("Lucigol");
		clientesCad[6].setTelefone("61 98212-4562");
		clientesCad[6].setEndereço("Vicente Pires, Rua 10");
		clientesCad[7].setNome("Heitoba");
		clientesCad[7].setTelefone("61 98330-9513");
		clientesCad[7].setEndereço("Gama");
		clientesCad[8].setNome("Rigoni");
		clientesCad[8].setTelefone("61 99398-7470");
		clientesCad[8].setEndereço("Asa Sul");
		clientesCad[9].setNome("Thiago Volpi");
		clientesCad[9].setTelefone("61 99333-3162");
		clientesCad[9].setEndereço("Jardim Botânico");
		
	}
	//produtos pré - cadastrados
	public static void preProCad (Products[] produtos) {
		for (int i=0; i<10; i++) {
			produtos[i] = new Products();
		}
		produtos[0].setNome("Pão de Forma");
		produtos[0].setValorCompra(3);
		produtos[0].setDescrição("Alimento");
		produtos[0].setLucro(30);
		produtos[0].setQuantEstoque(100);
		produtos[1].setNome("Saco de Arroz");
		produtos[1].setValorCompra(11);
		produtos[1].setDescrição("Alimento");
		produtos[1].setLucro(20);
		produtos[1].setQuantEstoque(150);
		produtos[2].setNome("Desodorante");
		produtos[2].setValorCompra(13);
		produtos[2].setDescrição("Higiene Pessoal");
		produtos[2].setLucro(20);
		produtos[2].setQuantEstoque(110);
		produtos[3].setNome("Sabonete");
		produtos[3].setValorCompra(5);
		produtos[3].setDescrição("Higiene Pessoal");
		produtos[3].setLucro(10);
		produtos[3].setQuantEstoque(50);
		produtos[4].setNome("Iorgute");
		produtos[4].setValorCompra(3.90);
		produtos[4].setDescrição("Alimento");
		produtos[4].setLucro(25);
		produtos[4].setQuantEstoque(170);
		produtos[5].setNome("Picanha");
		produtos[5].setValorCompra(65.50);
		produtos[5].setDescrição("Alimento");
		produtos[5].setLucro(60);
		produtos[5].setQuantEstoque(30);
		produtos[6].setNome("Papel Higiênico");
		produtos[6].setValorCompra(11.50);
		produtos[6].setDescrição("Higiene");
		produtos[6].setLucro(34);
		produtos[6].setQuantEstoque(132);
		produtos[7].setNome("Papel Toalha");
		produtos[7].setValorCompra(9.50);
		produtos[7].setDescrição("Limpeza");
		produtos[7].setLucro(40);
		produtos[7].setQuantEstoque(120);
		produtos[8].setNome("Vassouras");
		produtos[8].setValorCompra(23.90);
		produtos[8].setDescrição("Limpeza");
		produtos[8].setLucro(7);
		produtos[8].setQuantEstoque(85);
		produtos[9].setNome("QiBoa");
		produtos[9].setValorCompra(6.50);
		produtos[9].setDescrição("Limpeza");
		produtos[9].setLucro(39);
		produtos[9].setQuantEstoque(210);
		
	}
	
}
