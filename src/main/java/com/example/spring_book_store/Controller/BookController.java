package com.example.spring_book_store.Controller;

import com.example.spring_book_store.Dto.BookDTO;
import com.example.spring_book_store.Dto.ResponseDTO;
import com.example.spring_book_store.Dto.UserDTO;
import com.example.spring_book_store.Entity.BookData;
import com.example.spring_book_store.Entity.UserData;
import com.example.spring_book_store.Service.IBookService;
import com.example.spring_book_store.Service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/book")
@RestController
@Slf4j
public class BookController
{
    @Autowired
    IBookService iBookService ;

    //Welcome Message Api

    @GetMapping("/Welcome")
    public String welcomeMessage()
    {
        return "Welcome to Book Application !!!";
    }

//    Add Book Data API

    @PostMapping("/addBook")
    public ResponseEntity<ResponseDTO> createEmployees(@Valid @RequestBody BookDTO bookDTO)
    {
        BookData BookData1 = new BookData(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book Add  Successfully", iBookService.addBook(BookData1));
        log.info("-----------Book Add  Successfully ------------");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

//    Give All Detials Of Book

    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAllDetiles()
    {
        ResponseDTO responseDTO = new ResponseDTO("Book  List Received Successfully", iBookService.getAllDetiles());
        log.info("Get All Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    Give Book Details By Book Id

    @GetMapping("get/{id}")
    public ResponseEntity<ResponseDTO> getByID(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Book  Received Successfully", iBookService.getById(id));
        log.info("Get Book Id : "+id+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    Delete Details By Book Id

    @DeleteMapping("deleteBookDetils/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Book Deleted Successfully", iBookService.deleteById(id));
        log.info("Get Book Id : "+id+"  Data Delete Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Update Details By Book Id
    @PutMapping("updateBookDetils/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@Valid @RequestBody BookDTO bookDTO, @PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Get Book Id : "+id+"  Data Update Successfully.......", iBookService.editEmployee(bookDTO, id));
        log.info("Get Book Id : "+id+"  Data Update Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    Get Detilas By Book Name
    @GetMapping("/getByBook/{bookName}")
    public ResponseEntity<ResponseDTO> getByBookName(@PathVariable String bookName)
    {
        ResponseDTO responseDTO = new ResponseDTO(bookName+" Book All Data Successfully.......", iBookService.getByBookName(bookName));
        log.info("Get Employee Id : "+bookName+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    Give Book Detilas Sort By High To Low

    @GetMapping("/getByPriceHighToLow")
    public ResponseEntity<ResponseDTO> getByBookPrice()
    {
        ResponseDTO responseDTO = new ResponseDTO("Book All Data Successfully.......", iBookService.getByBookPrice());
        log.info("Get Employee Id : Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //    Give Book Detilas Sort By Low To High
    @GetMapping("/getByPriceLowToHigh")
    public ResponseEntity<ResponseDTO> getByBookPriceLowToHigh()
    {
        ResponseDTO responseDTO = new ResponseDTO("Book All Data Successfully.......", iBookService.getByBookPriceLowToHigh());
        log.info("Get Employee Id : Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
