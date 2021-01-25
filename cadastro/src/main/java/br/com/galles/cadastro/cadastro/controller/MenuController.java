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

import br.com.galles.cadastro.cadastro.dto.MenuDto;
import br.com.galles.cadastro.cadastro.model.Menu;
import br.com.galles.cadastro.cadastro.service.MenuService;



@RestController
@RequestMapping("/menu")
public class MenuController {

	private final MenuService service;

	@Autowired
	public MenuController(MenuService pedidoService) {
		this.service = pedidoService;
	}

	@PostMapping("/insere")
	public ResponseEntity insereProduto(@RequestBody MenuDto pedidoDto) {

		try {
			return ResponseEntity.ok(service.insertPedido(Menu.create(pedidoDto)));
		} catch (Exception e) {
			ResponseEntity.badRequest().body(e);
		}
		return ResponseEntity.ok().build();

	}

	@PutMapping("/atualiza/{id}")
	public ResponseEntity updatePedido(@PathVariable("id") int id, @RequestBody MenuDto pedidodto) {

		Menu pedido = Menu.create(pedidodto);
		pedido.setId(id);

		Menu updatedPedido = service.updatePedido(pedido);

		return Objects.nonNull(updatedPedido) ? ResponseEntity.ok(updatedPedido) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deletePedido(@PathVariable("id") int id) {

		return service.deletePedido(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
	@GetMapping("/find/{id}")
	public ResponseEntity findByid(@PathVariable("id") int id) {
		Optional<Menu> pedido = service.findById(id);
		return pedido.isPresent() ?
				ResponseEntity.ok(pedido.get()) :
					ResponseEntity.notFound().build();
	}

}
