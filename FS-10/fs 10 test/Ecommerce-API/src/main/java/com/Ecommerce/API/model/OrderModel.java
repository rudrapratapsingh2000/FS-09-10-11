package com.Ecommerce.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_table")
public class OrderModel {
    @Id
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_user_id")
    private UserModel userModel;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_order_id")
    private List<ProductModel> productModel;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "fk_order_address_table",joinColumns = @JoinColumn(name = "fk_order_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_address_id"))
    private List<AddressModel> addressModel;
    private Integer productQuantity;
}
