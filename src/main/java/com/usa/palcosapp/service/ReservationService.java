package com.usa.palcosapp.service;

import com.usa.palcosapp.model.ReservationModel;
import com.usa.palcosapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<ReservationModel> getById(Integer id){
        return reservationRepository.getById(id);
    }
    public ReservationModel save(ReservationModel reservationModel){
        if(reservationModel.getIdReservation()==null){
            return reservationRepository.save(reservationModel);
        }else{
            Optional<ReservationModel> optionalReservationModel = reservationRepository.getById(reservationModel.getIdReservation());
            if(optionalReservationModel.isEmpty()){
                return reservationRepository.save(reservationModel);
            }else{
                return reservationModel;
            }
        }
    }
    public ReservationModel update(ReservationModel reservationModel){
        if(reservationModel.getIdReservation()!=null){
            Optional<ReservationModel> optionalReservationModel = reservationRepository.getById(reservationModel.getIdReservation());
            if(!optionalReservationModel.isEmpty()) {
                if (reservationModel.getStartDate()!=null){
                    optionalReservationModel.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate()!=null){
                    optionalReservationModel.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus()!=null){
                    optionalReservationModel.get().setStatus(reservationModel.getStatus());
                }
                reservationRepository.save(optionalReservationModel.get());
                return optionalReservationModel.get();
            }else{
                return reservationModel;
            }
        }else{
            return reservationModel;
        }
    }
    public boolean delete(Integer id){
        Boolean aBoleean = getById(id).map(reservationModel -> {
            reservationRepository.delete(reservationModel);
            return true;
        }).orElse(false);
        return aBoleean;
    }
}
