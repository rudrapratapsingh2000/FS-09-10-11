package com.Ecommerce.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_table")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    @Email
    private String userEmail;
    private String userPassword;
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Invalid phone number format")
    @Size(min = 12, max = 12, message = "Phone number length should be 12 digits")
    private String userPhoneNumber;
}
