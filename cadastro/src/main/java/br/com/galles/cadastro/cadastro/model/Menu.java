package br.com.galles.cadastro.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.galles.cadastro.cadastro.dto.MenuDto;
import lombok.Data;

 

@Entity
@Table (name = "tb_menu")


@Data
public class Menu {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String name;
	private String preco;
	
	public static Menu create(MenuDto pedidoDto) {
		return new ModelMapper().map(pedidoDto,Menu.class);
	}
}
