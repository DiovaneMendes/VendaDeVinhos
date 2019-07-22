package br.com.vinhos.Repository;

import br.com.vinhos.Entity.Historico;
import org.springframework.data.repository.CrudRepository;

public interface HistoricoRepository  extends CrudRepository<Historico, Long> {
}
