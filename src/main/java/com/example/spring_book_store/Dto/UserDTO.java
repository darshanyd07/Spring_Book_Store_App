package com.example.spring_book_store.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO
{

        @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee First Name is Invalid")
        public String firstName;

        @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee Last Name is Invalid")
        public String lastName;

        @NotEmpty(message = "Address Can Not Empty")
        public String address;



        @NotBlank(message = "Email Can Not Empty")
        public String Email;

        @NotBlank(message = "Password Can Not Empty")
        public String Password;

}
