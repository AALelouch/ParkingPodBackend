package com.proyectobackend.parking.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
public class VehicleParking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idCheck;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH,optional = false)
    @JoinColumn(name = "vehicle_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Vehicle vehicle;

    @OneToOne(fetch = FetchType.EAGER,  cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "parking_id_slot")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Parking parking;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime entryDate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveDate;

    private Long hours;
    private double price;

    public VehicleParking() {
    }
}