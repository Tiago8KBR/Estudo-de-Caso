package visao;

import java.util.ArrayList;
import java.util.Scanner;
import controle.PessoaDAO;
import modelo.IPessoaDAO;
import modelo.Pessoa;

public class MainExemplo {

	public static void main(String[] args) {

		Integer opcaoseleciona = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		PessoaDAO bancopessoa = PessoaDAO.getInstancia();
		while (opcaoseleciona != 0) {

			System.out.println("Esse é o menu inicial");
			System.out.println("Selecione uma das opções a seguir");
			System.out.println("0 SAIR");
			System.out.println("1 CADASTRAR");
			System.out.println("2 ALTERAR");
			System.out.println("3 EXCLUIR");
			System.out.println("4 LISTAR");

			opcaoseleciona = Integer.valueOf(leitura.nextLine());

			switch (opcaoseleciona) {

			case 0: {
				break;
			}
			case 1: {
				Pessoa p = new Pessoa();
				System.out.println("Qual o nome");
				String nome = leitura.nextLine();
				System.out.println("O nome é " + nome);
				System.out.println("Qual o CPF");
				String cpf = leitura.nextLine();
				System.out.println("O CPF é " + cpf);

				if (!nome.isEmpty()) {
					p.setNome(nome);
				} else {
					System.out.println("Preencha o nome");
				}

				if (!cpf.isEmpty()) {
					p.setCpf(Long.valueOf(cpf));
				} else {
					System.out.println("Preencha o cpf");
				}

				boolean valida = bancopessoa.inserir(p);
				if (valida == true) {
					System.out.println("pessoa cadastrada");
				} else {
					System.out.println("Pessoa não cadastrada");
				}
			}
			case 2: {
				System.out.println("Insira o cpf para fazer alteração");
				String cpf = leitura.nextLine();

				Pessoa p = bancopessoa.buscarPessoaPorCpf(Long.valueOf(cpf));

				System.out.println("Digite o novo nome:");
				String nomeNovo = leitura.nextLine();
				p.setNome(nomeNovo);

				boolean valida = bancopessoa.alterar(p, p.getCpf());
				if (valida == true) {
					System.out.println("Pessoa cadastrado");
				} else {
					System.out.println("Usuario não cadastrado");
				}
			}
			case 3: {
				System.out.println("Insira o cpf para fazer exclusão");
				String excluir = leitura.nextLine();
				String cpf = String.valueOf(excluir);

				boolean valida = bancopessoa.excluir(Long.valueOf(cpf));
				if (valida == true) {
					System.out.println("O CPF foi excluido");
				} else {
					System.out.println("O CPF não foi excluido");
				}
			}
			case 4: {
				ArrayList<Pessoa> lista = bancopessoa.listarPessoas();
				for (Pessoa pessoa : lista) {
					System.out.println("Cpf: " + pessoa.getCpf());
					System.out.println("Nome: " + pessoa.getNome());
				}
			}
			}
		}
		leitura.close();
	}

}
