package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.BookDTO;
import com.example.spring_book_store.Dto.UserDTO;
import com.example.spring_book_store.Entity.BookData;
import com.example.spring_book_store.Entity.UserData;
import com.example.spring_book_store.Exception.CustomException;
import com.example.spring_book_store.Repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookService implements IBookService
{
    @Autowired
    BookRepository bookRepository;

    public BookData addBook(BookData book)
    {
        log.info("-----------User Data Register Successfully ------------");
        return bookRepository.save(book);

    }

    public List<BookData> getAllDetiles()
    {
        if (bookRepository.findAll().isEmpty())
        {
            log.info("-----------No User In Database.------------");
            throw new CustomException("No User In Database.");

        } else return bookRepository.findAll();
    }

    public Optional<BookData> getById(int id)
    {
        if (bookRepository.findById(id).isPresent())
        {
            log.info("--------- User Id :- " + id + " Show Successfully -----------");
            return bookRepository.findById(id);

        } else throw new CustomException("No User matches with the given ID");
    }

    public String deleteById(int id)
    {
        if (bookRepository.findById(id).isPresent())
        {
            bookRepository.deleteById(id);
            log.info("--------- Book Id :- " + id + " Delete Successfully -----------");
            return "Book Id " + id + " is Deleted Successfully!!";
        } else throw new CustomException("No User matches with the given ID");
    }

    public String editEmployee(BookDTO bookDTO, int id)
    {
        if (bookRepository.findById(id).isPresent())
        {
            BookData BookData1 = new BookData(id, bookDTO);
            BookData alpha = bookRepository.save(BookData1);
            log.info("----------- User Id " + id + " Data Update Successfully ------------");
            return "This is the result" + alpha;
        } else throw new CustomException("No User matches with the given ID");
    }

    public List<BookData> getByBookName(String bookName)
    {
        if (bookRepository.getByBookName(bookName).isEmpty())
        {

            log.info("----------- No First Name Present In Database.------------");
            throw new CustomException("No First Name Present In Database.");

        } else return bookRepository.getByBookName(bookName);
    }

    public List<BookData>getByBookPrice()
    {            log.info("--------- Book price High To Low -----------");
        return bookRepository.getByBookPrice();

    }

    public List<BookData> getByBookPriceLowToHigh()
    {
        if (bookRepository.findAll().isEmpty())
        {
            log.info("--------- Book price Low To High Not Display Show Error -----------");
            throw new CustomException("--------- Book price Low To High Not Display Show Error -----------");

        } else return bookRepository.getByBookPriceLowToHigh();

    }

}
