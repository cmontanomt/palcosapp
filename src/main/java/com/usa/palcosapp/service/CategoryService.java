package com.usa.palcosapp.service;

import com.usa.palcosapp.model.CategoryModel;
import com.usa.palcosapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<CategoryModel> getById(Integer id){
        return categoryRepository.getById(id);
    }
    public CategoryModel save(CategoryModel categoryModel){
        if(categoryModel.getId()==null){
            return categoryRepository.save(categoryModel);
        }else{
            Optional<CategoryModel> optionalCategoryModel = categoryRepository.getById(categoryModel.getId());
            if(optionalCategoryModel.isEmpty()){
                return categoryRepository.save(categoryModel);
            }else{
                return categoryModel;
            }
        }
    }
    public CategoryModel update(CategoryModel categoryModel){
        if(categoryModel.getId()!=null){
            Optional<CategoryModel> optionalCategoryModel = categoryRepository.getById(categoryModel.getId());
            if(!optionalCategoryModel.isEmpty()) {
                if (categoryModel.getName()!=null){
                    optionalCategoryModel.get().setName(categoryModel.getName());
                }
                if (categoryModel.getDescription()!=null){
                    optionalCategoryModel.get().setDescription(categoryModel.getDescription());
                }
                categoryRepository.save(optionalCategoryModel.get());
                return optionalCategoryModel.get();
            }else{
                return categoryModel;
            }
        }else{
            return categoryModel;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoleean = getById(id).map(categoryModel -> {
            categoryRepository.delete(categoryModel);
            return true;
        }).orElse(false);
        return aBoleean;
    }
}
