package com.example.spring_book_store.Controller;

import com.example.spring_book_store.Dto.OrderDTO;
import com.example.spring_book_store.Dto.ResponseDTO;
import com.example.spring_book_store.Entity.OrderData;
import com.example.spring_book_store.Service.IOrderService;
import com.example.spring_book_store.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private TokenUtil tokenUtil;

    @PostMapping("/place_order")
    public ResponseEntity<ResponseDTO> placeOrder(@RequestBody OrderDTO orderDTO)
    {
        OrderData orderData = iOrderService.placeOrder(orderDTO);
        ResponseDTO responseDTO = new ResponseDTO("Order placed successfully", orderData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllOrderList")
    public ResponseEntity<ResponseDTO> getAllOrders()
    {
        List<OrderData> orderDataList = iOrderService.getAllOrders();
        ResponseDTO responseDTO = new ResponseDTO("Getting All Orders", orderDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get_by_id/{OrderId}")
    public ResponseEntity<ResponseDTO> getOrderById(@PathVariable Integer OrderId)
    {
        OrderData orderData = iOrderService.getOrderById(OrderId);
        ResponseDTO responseDTO = new ResponseDTO("Get order for id", orderData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    //Order Make InActive
    @PutMapping("/order_Inactive/{OrderId}")
    public ResponseEntity<ResponseDTO> cancelOrder(@PathVariable Integer OrderId)
    {
        ResponseDTO responseDTO = new ResponseDTO("OrderId " + OrderId + " deleted", iOrderService.cancelOrder(OrderId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Get All Active Orders
    @GetMapping("/getActivePerson/{isActive}")
    public ResponseEntity<ResponseDTO> getActiveUsers(@PathVariable Boolean isActive)
    {
        ResponseDTO responseDTO = new ResponseDTO(" All Active Person  Data Successfully.......", iOrderService.getActiveUsers(isActive));
        log.info("Get Person Id : "+isActive+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Delete Order Perment
    @DeleteMapping("cancel_order/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("User Deleted Successfully", iOrderService.deleteOrderPerment(id));
        log.info("Get User Id : "+id+"  Data Delete Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}