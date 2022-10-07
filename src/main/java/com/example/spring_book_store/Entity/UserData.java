package com.example.spring_book_store.Entity;

import com.example.spring_book_store.Dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String firstName;
    public String lastName;
    public String address;

    public String Email;
    public String Password;

    public UserData()
    {
    }

    public UserData(int id, UserDTO userDTO)
    {
        this.id = id;
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.address = userDTO.address;
        this.Email = userDTO.Email;
        this.Password = userDTO.Password;
    }

    public UserData(UserDTO userDTO)
    {

        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.address = userDTO.address;
        this.Email = userDTO.Email;
        this.Password = userDTO.Password;
    }
}
