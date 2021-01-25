package br.com.galles.cadastro.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galles.cadastro.cadastro.model.Funcionario;
import br.com.galles.cadastro.cadastro.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
 
	private final FuncionarioRepository repository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public Funcionario criaFuncionario(Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
	public Funcionario updateFuncionario(Funcionario funcionario) {
		Optional<Funcionario> newFuncionario = repository.findById(funcionario.getId());
		if(newFuncionario.isPresent()) {
			return repository.save(funcionario);
		}
		else {
			return null;
		}
	}
	public boolean deleteFuncionario(int id) {
		Optional<Funcionario> funcionario = repository.findById(id);
		if(funcionario.isPresent()) {
			repository.delete(funcionario.get());
			return true;
		}
		else {
			return false;
		}
	}
	public Optional<Funcionario> findByid(int id){
		return repository.findById(id);
	}
}
