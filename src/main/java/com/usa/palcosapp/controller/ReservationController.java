package com.usa.palcosapp.controller;

import com.usa.palcosapp.model.ClientReport;
import com.usa.palcosapp.model.MessageModel;
import com.usa.palcosapp.model.ReservationModel;
import com.usa.palcosapp.model.ReservationReport;
import com.usa.palcosapp.service.MessageService;
import com.usa.palcosapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> getAll(){
        return reservationService.getAll();
    }
    @GetMapping("/{idReservation}")
    public Optional<ReservationModel> getById (@PathVariable("idReservation") Integer id){
        return reservationService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel save(@RequestBody ReservationModel reservationModel){
        return reservationService.save(reservationModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel update(@RequestBody ReservationModel reservationModel){
        return reservationService.update(reservationModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return reservationService.delete(id);
    }

    @GetMapping("/report-status")
    public ReservationReport getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<ReservationModel> getReservationReportDates(@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ClientReport> getReportClients(){
        return reservationService.getTopClients();
    }
}
