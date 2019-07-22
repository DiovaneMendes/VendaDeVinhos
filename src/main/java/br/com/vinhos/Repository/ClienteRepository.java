package br.com.vinhos.Repository;

import br.com.vinhos.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
