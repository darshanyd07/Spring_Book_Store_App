package com.example.spring_book_store.Entity;

import com.example.spring_book_store.Dto.OrderDTO;
import com.example.spring_book_store.Dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_table")
public class OrderData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private CartData cartId;

    @Column(name = "address")
    private String address;

    @Column(name = "order_date")
    private LocalDate orderDate = LocalDate.now();

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "cancel")
    private boolean cancel;

    public OrderData(CartData cartId, OrderDTO orderDTO)
    {
        this.cartId = cartId;
        orderData(orderDTO);
    }


    public void orderData(OrderDTO orderDTO)
    {
        this.address = orderDTO.address;
        this.orderDate = getOrderDate();
        this.totalPrice = getTotalPrice();
    }


}