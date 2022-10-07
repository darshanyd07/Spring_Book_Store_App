package com.example.spring_book_store.Repository;

import com.example.spring_book_store.Entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRegistrationRepository  extends JpaRepository<UserData, Integer>
{
    @Query("select u from UserData u where u.firstName =:c")
    List<UserData> getUsersByFirstName(@Param("c") String firstName);
}
