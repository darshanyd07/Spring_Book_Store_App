package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.CartDTO;
import com.example.spring_book_store.Entity.CartData;

import java.util.List;
import java.util.Optional;

public interface ICartService
{
    CartData insertItem(CartDTO cartDto);

    List<CartData> listAll();

    Optional<CartData> getCartDetailsById(Integer cartId);

    Optional<CartData> deleteCartItemById(Integer cartId);

    CartData updateRecordById(Integer cartId, CartDTO cartDTO);

    CartData updateQuantity(Integer id, Integer quantity);
}