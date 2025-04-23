package com.store.car.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "owner_post")
@Data
@NoArgsConstructor
public class OwnerPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "owner_type")
    private String type;

    @Column(name = "owner_contact_number")
    private String contactNumber;

}
