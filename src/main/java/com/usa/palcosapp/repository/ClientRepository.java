package com.usa.palcosapp.repository;

import com.usa.palcosapp.model.ClientModel;
import com.usa.palcosapp.repository.crudRepository.ClientCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAll(){
        return (List<ClientModel>) clientCrudRepository.findAll();
    }
    public Optional<ClientModel> getById(Integer id){
        return clientCrudRepository.findById(id);
    }
    public ClientModel save(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }
    public void delete(ClientModel clientModel){
        clientCrudRepository.delete(clientModel);
    }
}
