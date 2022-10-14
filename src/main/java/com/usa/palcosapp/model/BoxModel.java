package com.usa.palcosapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "box")
@NoArgsConstructor
@Getter
@Setter
public class BoxModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String location;
    private Integer capacity;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name="idCategory")
    @JsonIgnoreProperties("boxes")
    private CategoryModel category;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "box")
    @JsonIgnoreProperties({"box","client"})
    private List<MessageModel> messages;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "box")
    @JsonIgnoreProperties({"box","client"})
    private List<ReservationModel> reservations;
}
