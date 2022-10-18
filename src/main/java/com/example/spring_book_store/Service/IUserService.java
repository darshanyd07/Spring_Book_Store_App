package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.LoginDto;
import com.example.spring_book_store.Dto.UserDTO;
import com.example.spring_book_store.Entity.UserData;

import java.util.List;
import java.util.Optional;

public interface IUserService
{
    UserData Registration(UserData User);
    List<UserData> getAllDetiles();

    Optional<UserData> getById(int id);

    String deleteById(int id);

    String editEmployee(UserDTO userDTO, int id);
    List<UserData> getUsersByFirstName(String firstName);

    UserData loginUser(LoginDto loginDto);
}
