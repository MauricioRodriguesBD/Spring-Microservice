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

import br.com.galles.cadastro.cadastro.dto.FuncionarioDto;
import br.com.galles.cadastro.cadastro.model.Funcionario;
import br.com.galles.cadastro.cadastro.service.FuncionarioService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService service;
	
	@Autowired
	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}
	
	@PostMapping("/cria")
	public ResponseEntity criaFuncionario(@RequestBody FuncionarioDto funcionarioDto) {
		
		try {
			return ResponseEntity.ok(service.criaFuncionario(Funcionario.create(funcionarioDto)));
		}
		catch(Exception e) {
			ResponseEntity.badRequest().body(e);
			}
		return ResponseEntity.ok().build();
	}
	@PutMapping("/atualiza/{id}")
	public ResponseEntity updateFuncionario(@PathVariable ("id") int id, @RequestBody FuncionarioDto funcionarioDto) {
		Funcionario funcionario = Funcionario.create(funcionarioDto);
		funcionario.setId(id);
		
		Funcionario updatedFuncionario = service.updateFuncionario(funcionario);
		
		return Objects.nonNull(updatedFuncionario) ?
				ResponseEntity.ok(updatedFuncionario) :
				ResponseEntity.notFound().build();
	}
	@DeleteMapping("/delete/{id}")
		public ResponseEntity deletaFuncionario(@PathVariable("id") int id) {
		return service.deleteFuncionario(id) ?
				ResponseEntity.ok().build() :
				ResponseEntity.notFound().build();
	}
	@GetMapping("find/{id}")
		public ResponseEntity findById(@PathVariable("id") int id) {
		Optional<Funcionario> funcionario = service.findByid(id);
		
		return funcionario.isPresent() ?
				ResponseEntity.ok(funcionario.get()) :
				ResponseEntity.notFound().build();
	}
	
}