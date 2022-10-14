package com.usa.palcosapp.repository.crudRepository;

import com.usa.palcosapp.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel,Integer> {
}
