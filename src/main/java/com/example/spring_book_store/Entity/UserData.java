package com.example.spring_book_store.Entity;

import com.example.spring_book_store.Dto.UserDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserData
{
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
