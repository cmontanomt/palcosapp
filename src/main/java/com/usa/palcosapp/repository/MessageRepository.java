package com.usa.palcosapp.repository;

import com.usa.palcosapp.model.MessageModel;
import com.usa.palcosapp.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAll(){
        return (List<MessageModel>) messageCrudRepository.findAll();
    }
    public Optional<MessageModel> getById(Integer id){
        return messageCrudRepository.findById(id);
    }
    public MessageModel save(MessageModel messageModel){
        return messageCrudRepository.save(messageModel);
    }
    public void delete(MessageModel messageModel){
        messageCrudRepository.delete(messageModel);
    }
}
