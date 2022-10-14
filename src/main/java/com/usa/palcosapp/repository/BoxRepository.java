package com.usa.palcosapp.repository;

import com.usa.palcosapp.model.BoxModel;
import com.usa.palcosapp.repository.crudRepository.BoxCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoxRepository {
    @Autowired
    private BoxCrudRepository boxCrudRepository;

    public List<BoxModel> getAll(){
        return (List<BoxModel>) boxCrudRepository.findAll();
    }
    public Optional<BoxModel> getById(Integer id){
        return boxCrudRepository.findById(id);
    }
    public BoxModel save(BoxModel boxModel){
        return boxCrudRepository.save(boxModel);
    }
    public void delete(BoxModel boxModel){
        boxCrudRepository.delete(boxModel);
    }
}
