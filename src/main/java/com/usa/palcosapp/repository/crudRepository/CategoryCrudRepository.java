package com.usa.palcosapp.repository.crudRepository;

import com.usa.palcosapp.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryModel,Integer> {
}
