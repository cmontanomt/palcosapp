package com.usa.palcosapp.repository.crudRepository;

import com.usa.palcosapp.model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel,Integer>{
}
