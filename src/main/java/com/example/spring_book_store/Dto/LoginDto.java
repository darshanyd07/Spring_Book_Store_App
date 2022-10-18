package com.example.spring_book_store.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto
{


    public String Email;
    public String Password;

//    public LoginDto(String Email, String Password)
//    {
//        this.Email = Email;
//        this.Password = Password;
//    }

}