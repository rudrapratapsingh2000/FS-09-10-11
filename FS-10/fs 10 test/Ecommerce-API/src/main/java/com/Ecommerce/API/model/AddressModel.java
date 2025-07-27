package com.Ecommerce.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address_table")
public class AddressModel {
    @Id
    private Integer address_id;
    private String name;
    private String landmark;
    private String phoneNumber;
    private String zipcode;
    private String state;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_user_Id")
    private UserModel userModel;
}
