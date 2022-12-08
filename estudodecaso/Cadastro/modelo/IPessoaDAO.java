package modelo;

import java.util.ArrayList;

public interface IPessoaDAO {
	public boolean inserir(Pessoa p);

	public boolean alterar(Pessoa p, long cpf);

	public boolean excluir(long cpf);

	public ArrayList<Pessoa> listarPessoas();

	boolean excluir(String cpf);
}
