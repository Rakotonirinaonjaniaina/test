package com.example.prog4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InternalEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;


    @ManyToOne
    @JoinColumn(name = "cnaps_employee_id")
    private CnapsEmployee cnapsEmployee;


}


