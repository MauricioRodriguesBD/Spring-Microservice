package br.com.galles.cadastro.cadastro.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.galles.cadastro.cadastro.dto.ClienteDto;
import br.com.galles.cadastro.cadastro.model.Cliente;
import br.com.galles.cadastro.cadastro.service.ClienteService;



@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private final ClienteService service;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.service = clienteService;
	}
	
	@PostMapping("/cria")
	public ResponseEntity criaCliente (@RequestBody ClienteDto clienteDto) {
		
		try {
			return ResponseEntity.ok(service.criaCliente(Cliente.create(clienteDto)));
		}
		catch(Exception e) {
			ResponseEntity.badRequest().body(e);
		}
		return ResponseEntity.ok().build();
	}
	@PutMapping("/atualiza/{id}")
	public ResponseEntity updateCliente(@PathVariable("id")int id, @RequestBody ClienteDto clienteDto){
		Cliente cliente = Cliente.create(clienteDto);
		cliente.setId(id);
		
		Cliente updatedCliente = service.updateCliente(cliente);
		
		return Objects.nonNull(updatedCliente) ?
				ResponseEntity.ok(updatedCliente) :
				ResponseEntity.notFound().build();
		
	}
	@DeleteMapping("/deleta/{id}")
	 public ResponseEntity deletaCliente (@PathVariable("id") int id) {
		return service.deleteCliente(id) ?
				ResponseEntity.ok().build() :
				ResponseEntity.notFound().build();
	}
	@GetMapping("/find/{id}")
	public ResponseEntity findById(@PathVariable ("id") int id) {
		Optional<Cliente> cliente = service.findById(id);
		return cliente.isPresent() ?
				ResponseEntity.ok(cliente.get()) : 
					ResponseEntity.notFound().build();
	}
}


