package modelo;

import java.util.ArrayList;

public interface IPessoaDAO {
	public boolean inserir(Pessoa p);

	public boolean alterar(Pessoa p, Long cpf);

	public boolean excluir(Long cpf);

	public ArrayList<Pessoa> listarPessoas();
	
	public Pessoa buscarPessoaPorCpf(Long cpf);

}
