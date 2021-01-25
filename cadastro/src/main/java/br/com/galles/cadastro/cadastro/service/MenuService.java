package br.com.galles.cadastro.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galles.cadastro.cadastro.model.Menu;
import br.com.galles.cadastro.cadastro.repository.MenuRepository;



@Service
public class MenuService {

	private final MenuRepository repository;

	@Autowired
	public MenuService(MenuRepository pedidoRepository) {
		this.repository = pedidoRepository;
	}

	public Menu insertPedido(Menu pedido) {
		return repository.save(pedido);
	}

	public Menu updatePedido(Menu pedido) {

		Optional<Menu> newPedido = repository.findById(pedido.getId());
		if (newPedido.isPresent()) {
			return repository.save(pedido);
		} else {
			return null;
		}
	}

	public boolean deletePedido(int id) {
		Optional<Menu> pedido = repository.findById(id);
		if (pedido.isPresent()) {
			repository.delete(pedido.get());
			return true;

		} else {
			return false;
		}
	}
	
	public Optional <Menu> findById(int id) {
		return repository.findById(id);
	}

}