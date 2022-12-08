package controle;

import java.util.ArrayList;
import modelo.IPessoaDAO;
import modelo.Pessoa;

public class PessoaDAO implements IPessoaDAO {

	private static ArrayList<Pessoa> tabelapessoas;
	private static PessoaDAO instancia;

	private PessoaDAO() {

	}

	public static PessoaDAO getInstancia() {
		if (instancia == null) {
			instancia = new PessoaDAO();
			tabelapessoas = new ArrayList<>();
		}
		return instancia;
	}

	public boolean inserir(Pessoa p) {
		if (p != null) {
			tabelapessoas.add(p);
			return true;
		}
		return false;
	}

	public boolean alterar(Pessoa p, Long cpf) {
		for (Pessoa pessoa : tabelapessoas) {
			if (pessoa.getCpf() == cpf) {
				pessoa.setNome(p.getNome());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean excluir(Long cpf) {
		for (Pessoa pessoa : tabelapessoas) {
			if (pessoa.getCpf() == cpf) {
				tabelapessoas.remove(pessoa);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Pessoa> listarPessoas() {
		return tabelapessoas;
	}

	@Override
	public Pessoa buscarPessoaPorCpf(Long cpf) {
		for (Pessoa pessoa : tabelapessoas) {
			if (pessoa.getCpf() == cpf) {
				return pessoa;
			}
		}
		return null;
	}

}
