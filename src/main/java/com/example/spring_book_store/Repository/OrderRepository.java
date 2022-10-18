package com.example.spring_book_store.Repository;

import com.example.spring_book_store.Entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, Integer>
{
    @Query("select u from OrderData u where u.cancel =:c")
    List<OrderData> getActiveUsers(@Param("c") Boolean isActive);
}