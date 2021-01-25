package br.com.galles.cadastro.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.galles.cadastro.cadastro.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>{

}
