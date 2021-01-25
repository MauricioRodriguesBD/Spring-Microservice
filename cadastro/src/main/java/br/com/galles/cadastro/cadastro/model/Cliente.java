package br.com.galles.cadastro.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.galles.cadastro.cadastro.dto.ClienteDto;
import lombok.Data;

@Entity
@Table(name =  "tb_cliente")
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String nome;
	
	private String sobrenome;
	
	private String rg;
	
	private String cpf;
	
	private String password;
	
	public static Cliente create(ClienteDto clienteDto) {
		return new ModelMapper().map(clienteDto,Cliente.class);
	}
}
