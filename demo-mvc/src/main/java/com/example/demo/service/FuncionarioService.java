package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Endereco;
import com.example.demo.models.Funcionario;
import com.example.demo.repositorys.EnderecoRepository;
import com.example.demo.repositorys.FuncionarioRepository;
import com.example.demo.service.utils.Utils;

@Service
public class FuncionarioService implements GenericService<Funcionario, String> {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Funcionario save(Funcionario funcionario) {
		Endereco endereco = saveEndereco(funcionario.getEndereco());
		funcionario.setId(Utils.UUID());
		funcionario.setEndereco(endereco);
		funcionarioRepository.save(funcionario);
		return funcionario;
	}

	private Endereco saveEndereco(Endereco endereco) {
		endereco.setId(Utils.UUID());
		return enderecoRepository.save(endereco);
	}

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();

	}

	@Override
	public Funcionario findById(String id) {
		return funcionarioRepository.findById(id).get();
	}

	public Funcionario update(Funcionario entity) {

		Funcionario funcionario = funcionarioRepository
				.findById(entity.getId().substring(0, entity.getId().length() - 1)).get();
		funcionario.setEndereco(updateEndereco(funcionario.getEndereco()));
		funcionario.setNome(entity.getNome());
		funcionario.setCargo(entity.getCargo());
		funcionario.setSalario(entity.getSalario());
		funcionario.setDataAdmissao(entity.getDataAdmissao());
		funcionario.setDataDesligamento(entity.getDataDesligamento());
		return funcionarioRepository.save(funcionario);

	}

	private Endereco updateEndereco(Endereco entity) {
		Endereco endereco = enderecoRepository.findById(entity.getId()).get();
		endereco.setBairro(entity.getBairro());
		endereco.setCep(entity.getCep());
		endereco.setCidade(entity.getCidade());
		endereco.setComplemento(entity.getComplemento());
		endereco.setLogradouro(entity.getLogradouro());
		endereco.setNumero(entity.getNumero());
		endereco.setUf(entity.getUf());

		return enderecoRepository.save(endereco);
	}

	public void delete(String id) {
		Funcionario funcionario = findById(id);
		funcionarioRepository.deleteById(id);
		enderecoRepository.delete(funcionario.getEndereco());
	}

	public List<Funcionario> buscaPorNome(String nome) {
		return funcionarioRepository.buscaPorNome(nome);
	}

}
