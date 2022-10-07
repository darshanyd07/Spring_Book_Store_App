package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.UserDTO;
import com.example.spring_book_store.Entity.UserData;
import com.example.spring_book_store.Exception.CustomException;
import com.example.spring_book_store.Repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements IUserService
{
    @Autowired
    UserRegistrationRepository userRepository;

    public UserData  Registration(UserData User)
    {
        log.info("-----------User Data Register Successfully ------------");
        return userRepository.save(User);

    }

    public List<UserData> getAllDetiles()
    {
        if (userRepository.findAll().isEmpty())
        {
            log.info("-----------No User In Database.------------");
            throw new CustomException("No User In Database.");

        } else return userRepository.findAll();
    }

    public Optional<UserData> getById(int id)
    {
        if (userRepository.findById(id).isPresent())
        {
            log.info("--------- User Id :- " + id + " Show Successfully -----------");
            return userRepository.findById(id);

        } else throw new CustomException("No User matches with the given ID");
    }

    public String deleteById(int id)
    {
        if (userRepository.findById(id).isPresent())
        {
            userRepository.deleteById(id);
            log.info("--------- User Id :- " + id + " Delete Successfully -----------");
            return "User with ID: " + id + " is Deleted Successfully!!";
        } else throw new CustomException("No User matches with the given ID");
    }

    public String editEmployee(UserDTO userDTO, int id)
    {
        if (userRepository.findById(id).isPresent())
        {
            UserData user1 = new UserData(id, userDTO);
            UserData alpha = userRepository.save(user1);
            log.info("----------- User Id " + id + " Data Update Successfully ------------");
            return "This is the result" + alpha;
        } else throw new CustomException("No User matches with the given ID");
    }

    public List<UserData> getUsersByFirstName(String firstName)
    {
        if (userRepository.getUsersByFirstName(firstName).isEmpty())
        {

            log.info("----------- No First Name Present In Database.------------");
            throw new CustomException("No First Name Present In Database.");

        } else return userRepository.getUsersByFirstName(firstName);
    }
}

