package com.usa.palcosapp.service;

import com.usa.palcosapp.model.MessageModel;
import com.usa.palcosapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAll(){
        return messageRepository.getAll();
    }
    public Optional<MessageModel> getById(Integer id){
        return messageRepository.getById(id);
    }
    public MessageModel save(MessageModel messageModel){
        if(messageModel.getIdMessage()==null){
            return messageRepository.save(messageModel);
        }else{
            Optional<MessageModel> optionalMessageModel = messageRepository.getById(messageModel.getIdMessage());
            if(optionalMessageModel.isEmpty()){
                return messageRepository.save(messageModel);
            }else{
                return messageModel;
            }
        }
    }
    public MessageModel update(MessageModel messageModel){
        if(messageModel.getIdMessage()!=null){
            Optional<MessageModel> optionalMessageModel = messageRepository.getById(messageModel.getIdMessage());
            if(!optionalMessageModel.isEmpty()) {
                if (messageModel.getMessageText()!=null){
                    optionalMessageModel.get().setMessageText(messageModel.getMessageText());
                    optionalMessageModel.get().setClient(messageModel.getClient());
                    optionalMessageModel.get().setBox(messageModel.getBox());
                }
                messageRepository.save(optionalMessageModel.get());
                return optionalMessageModel.get();
            }else{
                return messageModel;
            }
        }else{
            return messageModel;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoleean = getById(id).map(messageModel -> {
            messageRepository.delete(messageModel);
            return true;
        }).orElse(false);
        return aBoleean;
    }
}
