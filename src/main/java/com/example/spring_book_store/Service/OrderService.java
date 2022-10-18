package com.example.spring_book_store.Service;

import com.example.spring_book_store.Dto.CartDTO;
import com.example.spring_book_store.Dto.OrderDTO;
import com.example.spring_book_store.Dto.ResponseDTO;
import com.example.spring_book_store.Dto.UserDTO;
import com.example.spring_book_store.Entity.BookData;
import com.example.spring_book_store.Entity.CartData;
import com.example.spring_book_store.Entity.OrderData;
import com.example.spring_book_store.Entity.UserData;
import com.example.spring_book_store.Exception.CustomException;
import com.example.spring_book_store.Repository.CartRepository;
import com.example.spring_book_store.Repository.OrderRepository;
import com.example.spring_book_store.Repository.UserRegistrationRepository;
import com.example.spring_book_store.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class OrderService implements IOrderService
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ICartService iCartService;



    @Override
    public OrderData placeOrder(OrderDTO orderDTO)
    {
        Optional<CartData> cartData = iCartService.getCartDetailsById(orderDTO.getCartId());


        if (cartData.isEmpty())
        {
            throw new CustomException(cartData +" Cart Id Does Not Exist");
        } else
        {

            int totalPrice = cartData.get().getPrice();
            OrderData orderData = new OrderData(cartData.get(), orderDTO);
            orderData.setTotalPrice(totalPrice);
            return orderRepository.save(orderData);
        }
    }



    @Override
    public List<OrderData> getAllOrders()
    {

        if (orderRepository.findAll().isEmpty())
        {
            log.info("-----------No Order Present In Database.------------");
            throw new CustomException("-----------No Order Present In Database.------------");

        } else return orderRepository.findAll();

    }

    @Override
    public OrderData getOrderById(int orderId)
    {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new CustomException("Order with id " + orderId + " not found"));
    }


    @Override
    public OrderData cancelOrder(int orderId)
    {
        OrderData orderData = this.getOrderById(orderId);
        orderData.setCancel(true);
        return orderRepository.save(orderData);
    }



    public List<OrderData> getActiveUsers(Boolean cancel)
    {
        if (orderRepository.getActiveUsers(cancel).isEmpty())
        {

            log.info("----------- No Orders  Present In Database.------------");
            throw new CustomException("No Orders  Present In Database.");

        } else return orderRepository.getActiveUsers(cancel);

    }

    public String deleteOrderPerment(int id)
    {
        if (orderRepository.findById(id).isPresent())
        {
            orderRepository.deleteById(id);
            log.info("--------- Order Id :- " + id + " Delete Successfully -----------");
            return "Order with ID: " + id + " is Deleted Successfully!!";
        } else throw new CustomException("No User matches with the given ID");
    }

}