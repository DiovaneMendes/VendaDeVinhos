package br.com.vinhos.Repository;

import br.com.vinhos.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findAll();
}
