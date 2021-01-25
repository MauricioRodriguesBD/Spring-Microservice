package br.com.galles.cadastro.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.galles.cadastro.cadastro.dto.FuncionarioDto;
import lombok.Data;

@Entity
@Table (name = "tb_funcionario")
@Data
public class Funcionario {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private int id;

	private String nome;
	
	private String sobrenome;
	
	private String rg;
	
	private String cpf;
	
	private String password;
	
	public static Funcionario create(FuncionarioDto funcionaDto) {
		return new ModelMapper().map(funcionaDto,Funcionario.class);
	}
	
}
