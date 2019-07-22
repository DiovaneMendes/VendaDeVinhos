package br.com.vinhos.Repository;

import br.com.vinhos.Entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
