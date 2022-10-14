package com.usa.palcosapp.service;

import com.usa.palcosapp.model.BoxModel;
import com.usa.palcosapp.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    public List<BoxModel> getAll(){
        return boxRepository.getAll();
    }
    public Optional<BoxModel> getById(Integer id){
        return boxRepository.getById(id);
    }
    public BoxModel save(BoxModel boxModel){
        if(boxModel.getId()==null){
            return boxRepository.save(boxModel);
        }else{
            Optional<BoxModel> optionalBoxModel = boxRepository.getById(boxModel.getId());
            if(optionalBoxModel.isEmpty()){
                return boxRepository.save(boxModel);
            }else{
                return boxModel;
            }
        }
    }
    public BoxModel update(BoxModel boxModel){
        if(boxModel.getId()!=null){
            Optional<BoxModel> optionalBoxModel = boxRepository.getById(boxModel.getId());
            if(!optionalBoxModel.isEmpty()) {
                if (boxModel.getName()!=null){
                    optionalBoxModel.get().setName(boxModel.getName());
                }
                if (boxModel.getCapacity()!=null){
                    optionalBoxModel.get().setCapacity(boxModel.getCapacity());
                }
                if (boxModel.getLocation()!=null){
                    optionalBoxModel.get().setLocation(boxModel.getLocation());
                }
                if (boxModel.getDescription()!=null){
                    optionalBoxModel.get().setDescription(boxModel.getDescription());
                }
                if (boxModel.getCategory()!=null){
                    optionalBoxModel.get().setCategory(boxModel.getCategory());
                }
                boxRepository.save(optionalBoxModel.get());
                return optionalBoxModel.get();
            }else{
                return boxModel;
            }
        }else{
            return boxModel;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoleean = getById(id).map(boxModel -> {
            boxRepository.delete(boxModel);
            return true;
        }).orElse(false);
        return aBoleean;
    }
}
