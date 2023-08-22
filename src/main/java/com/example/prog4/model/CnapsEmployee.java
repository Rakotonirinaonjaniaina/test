package com.example.prog4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CnapsEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;


    @OneToMany(mappedBy = "cnapsEmployee")
    private List<InternalEmployee> internalEmployees;

}

