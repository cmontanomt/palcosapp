package com.usa.palcosapp.controller;

import com.usa.palcosapp.model.CategoryModel;
import com.usa.palcosapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryModel> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{idCategory}")
    public Optional<CategoryModel> getById (@PathVariable("idCategory") Integer id){
        return categoryService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel save(@RequestBody CategoryModel categoryModel){
        return categoryService.save(categoryModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel update(@RequestBody CategoryModel categoryModel){
        return categoryService.update(categoryModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return categoryService.delete(id);
    }
}
