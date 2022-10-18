package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.CartDTO;
import com.example.spring_book_store.Dto.OrderDTO;
import com.example.spring_book_store.Entity.CartData;
import com.example.spring_book_store.Entity.OrderData;

import java.util.List;

public interface IOrderService
{
    OrderData placeOrder(OrderDTO orderDTO);

    List<OrderData> getAllOrders();

    OrderData getOrderById(int orderId);

    OrderData cancelOrder(int orderId);

    List<OrderData> getActiveUsers(Boolean cancel);
    String deleteOrderPerment(int id);
}