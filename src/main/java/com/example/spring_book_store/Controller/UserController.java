package com.example.spring_book_store.Controller;

import com.example.spring_book_store.Dto.ResponseDTO;
import com.example.spring_book_store.Dto.UserDTO;
import com.example.spring_book_store.Entity.UserData;
import com.example.spring_book_store.Service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j
@RequestMapping("/bookstore")
@RestController
public class UserController
{
    @Autowired
    IUserService iUserService;

    @GetMapping("/Welcome")
    public String welcomeMessage()
    {
        return "Welcome to Book Store Application !!!";
    }

    @PostMapping("/Register")
    public ResponseEntity<ResponseDTO> createEmployees(@Valid @RequestBody UserDTO userDTO)
    {
        UserData userData1 = new UserData(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Register  Successfully", iUserService.Registration(userData1));
        log.info("-----------User Register  Successfully ------------");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAllDetiles()
    {
        ResponseDTO responseDTO = new ResponseDTO("User List Received Successfully", iUserService.getAllDetiles());
        log.info("Get All Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ResponseDTO> getByID(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("User Received Successfully", iUserService.getById(id));
        log.info("Get User Id : "+id+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("deleteUserDetils/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("User Deleted Successfully", iUserService.deleteById(id));
        log.info("Get User Id : "+id+"  Data Delete Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PutMapping("updateUserDetils/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@Valid @RequestBody UserDTO userDTO, @PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Get User Id : "+id+"  Data Update Successfully.......", iUserService.editEmployee(userDTO, id));
        log.info("Get User Id : "+id+"  Data Update Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getByUsername/{firstName}")
    public ResponseEntity<ResponseDTO> getUsersByFirstName(@PathVariable String firstName)
    {
        ResponseDTO responseDTO = new ResponseDTO(firstName+" Employee All Data Successfully.......", iUserService.getUsersByFirstName(firstName));
        log.info("Get Employee Id : "+firstName+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
