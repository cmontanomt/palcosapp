package com.usa.palcosapp.repository.crudRepository;

import com.usa.palcosapp.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel,Integer> {
}
