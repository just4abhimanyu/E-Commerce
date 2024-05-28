package com.av.prod.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prod_services")
@NoArgsConstructor
@Setter
@Getter
public class ProductServiceModel {

    @Id
    @GeneratedValue
    private long id;
    @Column(length = 5)
    private String productName;
    private String productType;
    private long productPrice;

}
