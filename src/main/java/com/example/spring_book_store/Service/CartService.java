package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.CartDTO;
import com.example.spring_book_store.Entity.BookData;
import com.example.spring_book_store.Entity.CartData;
import com.example.spring_book_store.Entity.UserData;
import com.example.spring_book_store.Exception.CustomException;
import com.example.spring_book_store.Repository.BookRepository;
import com.example.spring_book_store.Repository.CartRepository;
import com.example.spring_book_store.Repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class CartService implements ICartService
{
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRegistrationRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public CartData insertItem(CartDTO cartDto)
    {
        Optional<BookData> bookStore = bookRepository.findById(cartDto.getBookId());
        Optional<UserData> userDetail = userRepository.findById(cartDto.getUserId());
        if (bookStore.isPresent() && userDetail.isPresent())
        {
            if (cartDto.getQuantity() <= bookStore.get().getQuantity())
            {
                int quantity = bookStore.get().getQuantity() - cartDto.getQuantity();
//                bookStore.get().setQuantity(quantity);
                bookRepository.save(bookStore.get());
                CartData cart = new CartData(userDetail.get(),bookStore.get(), cartDto.getQuantity(),bookStore.get().getPrice()* cartDto.quantity);
                cartRepository.save(cart);
                log.info("Book Add Sussefully In Cart........");
                return cart;

            }
            else
            {
                log.info("Book Out Of Stock ........");
                throw new CustomException("book out of stock ");
            }
        }
        else
        {
            log.info("Book Or User Not Present........");
            throw new CustomException("Book Or User Not Present");
        }
    }


    public List<CartData> listAll ()
    {
        if (cartRepository.findAll().isEmpty())
        {
            throw new CustomException("No value present");

        }
        else
            return cartRepository.findAll();
    }


    @Override
    public Optional<CartData> getCartDetailsById(Integer cartId)
    {
        Optional<CartData> getCartData = cartRepository.findById(cartId);
        if (getCartData.isPresent())
        {
            return getCartData;
        }
        else
        {
            log.info(cartId+" Id Was Not Found");
            throw new CustomException(cartId+" Id Was Not Found");
        }
    }

    @Override
    public Optional<CartData> deleteCartItemById(Integer cartId)
    {
        Optional<CartData> cartItem = cartRepository.findById(cartId);
        if (cartItem.isPresent())
        {
            cartRepository.deleteById(cartId);
            return cartItem;
        } else
        {
            throw new CustomException(cartId+" Id Was Not Found ");
        }
    }

    @Override
    public CartData updateRecordById(Integer cartId, CartDTO cartDTO)
    {
        Optional<CartData> cart = cartRepository.findById(cartId);
        Optional<BookData> book = bookRepository.findById(cartDTO.getBookId());
        Optional<UserData> user = userRepository.findById(cartDTO.getUserId());
        if (cart.isEmpty())
        {
            throw new CustomException(cartId+" Cart Does Not Exist");
        } else
        {
            if (book.isPresent() && user.isPresent())
            {
                CartData cart1 = new CartData( user.get(),book.get(), cartDTO.getQuantity(),cartDTO.price);
                cart1.setCartId(cartId);
                cartRepository.save(cart1);
                return cart1;
            } else
            {
                throw new CustomException("Book Or User Doesn't Exists");
            }
        }
    }


    @Override
    public CartData updateQuantity(Integer cartId, Integer quantity)
    {
        Optional<CartData> cart = cartRepository.findById(cartId);
        if (cart.isPresent())
        {
            Optional<BookData> bookStore = bookRepository.findById(cart.get().getBookStore().getBookID());

            if ((bookStore.get().getQuantity()) >=quantity)
            {
                bookStore.get().setQuantity(bookStore.get().getQuantity());
                cart.get().setQuantity(quantity);
                int priceI = cart.get().getQuantity() * bookStore.get().getPrice();
                cart.get().setPrice(priceI);
                cartRepository.save(cart.get());
                bookRepository.save(bookStore.get());
                return cart.get();
            }
            else
            {
                throw new CustomException("Book Not In Stock");
            }
        }
        else
        {
            throw new CustomException("Book Or User Not Present");
        }
    }
}