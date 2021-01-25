package br.com.galles.cadastro.cadastro.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDto {

	private String nome;
	
	private String sobrenome;
	
	private String rg;
	
	private String cpf;
	
	private String password;
}
