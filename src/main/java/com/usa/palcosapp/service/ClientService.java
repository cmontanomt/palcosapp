package com.usa.palcosapp.service;

import com.usa.palcosapp.model.ClientModel;
import com.usa.palcosapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAll(){
        return clientRepository.getAll();
    }
    public Optional<ClientModel> getById(Integer id){
        return clientRepository.getById(id);
    }
    public ClientModel save(ClientModel clientModel){
        if(clientModel.getIdClient()==null){
            return clientRepository.save(clientModel);
        }else{
            Optional<ClientModel> optionalClientModel = clientRepository.getById(clientModel.getIdClient());
            if(optionalClientModel.isEmpty()){
                return clientRepository.save(clientModel);
            }else{
                return clientModel;
            }
        }
    }
    public ClientModel update(ClientModel clientModel){
        if(clientModel.getIdClient()!=null){
            Optional<ClientModel> optionalClientModel = clientRepository.getById(clientModel.getIdClient());
            if(!optionalClientModel.isEmpty()) {
                if (clientModel.getName()!=null){
                    optionalClientModel.get().setName(clientModel.getName());
                }
                if (clientModel.getAge()!=null){
                    optionalClientModel.get().setAge(clientModel.getAge());
                }
                if (clientModel.getEmail()!=null){
                    optionalClientModel.get().setEmail(clientModel.getEmail());
                }
                if (clientModel.getPassword()!=null){
                    optionalClientModel.get().setPassword(clientModel.getPassword());
                }
                clientRepository.save(optionalClientModel.get());
                return optionalClientModel.get();
            }else{
                return clientModel;
            }
        }else{
            return clientModel;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoleean = getById(id).map(clientModel -> {
            clientRepository.delete(clientModel);
            return true;
        }).orElse(false);
        return aBoleean;
    }
}
