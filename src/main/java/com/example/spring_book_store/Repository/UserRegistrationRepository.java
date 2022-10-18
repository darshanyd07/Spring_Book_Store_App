package com.example.spring_book_store.Repository;

import com.example.spring_book_store.Entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRegistrationRepository  extends JpaRepository<UserData, Integer>
{
    @Query("select u from UserData u where u.firstName =:c")
    List<UserData> getUsersByFirstName(@Param("c") String firstName);


    @Query(value = "SELECT * FROM user_data where email=:mail", nativeQuery = true)
    Optional<UserData> findByEmailId(String mail);





}
