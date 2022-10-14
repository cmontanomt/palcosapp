package com.usa.palcosapp.repository;

import com.usa.palcosapp.model.ReservationModel;
import com.usa.palcosapp.repository.crudRepository.ReservationCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAll(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }
    public Optional<ReservationModel> getById(Integer id){
        return reservationCrudRepository.findById(id);
    }
    public ReservationModel save(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }
    public void delete(ReservationModel reservationModel){
        reservationCrudRepository.delete(reservationModel);
    }
}
