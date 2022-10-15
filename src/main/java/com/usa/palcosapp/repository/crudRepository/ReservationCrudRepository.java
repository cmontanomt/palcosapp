package com.usa.palcosapp.repository.crudRepository;

import com.usa.palcosapp.model.ReservationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel,Integer> {
    public List<ReservationModel> findAllByStatus(String status);

    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    @Query("SELECT c.client, COUNT(c.client) FROM ReservationModel AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();

}
