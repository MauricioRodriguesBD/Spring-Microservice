package br.com.galles.cadastro.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galles.cadastro.cadastro.model.Cliente;
import br.com.galles.cadastro.cadastro.repository.ClienteRepository;


@Service
public class ClienteService {

	private final ClienteRepository repository;
	
	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public Cliente criaCliente(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente updateCliente(Cliente cliente) {
		Optional<Cliente> newCliente = repository.findById(cliente.getId());
		if(newCliente.isPresent()) {
			return repository.save(cliente);
		}
		else {
			return null;	
		}
	}
	public boolean deleteCliente (int id){
		Optional<Cliente> cliente = repository.findById(id);
		if(cliente.isPresent()) {
			repository.delete(cliente.get());
			return true;
		}
		else {
			return false;
		}
	}
	public Optional<Cliente> findById(int id){
		return repository.findById(id);
	}
	
}