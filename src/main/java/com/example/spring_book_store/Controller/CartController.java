package com.example.spring_book_store.Controller;


import com.example.spring_book_store.Dto.CartDTO;
import com.example.spring_book_store.Dto.ResponseDTO;
import com.example.spring_book_store.Entity.CartData;
import com.example.spring_book_store.Service.ICartService;
import com.example.spring_book_store.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/cart")
    public class CartController
{
    @Autowired
    ICartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<ResponseDTO> insertItem(@RequestBody CartDTO cartDto)
    {
        ResponseDTO responseDTO = new ResponseDTO("user added", cartService.insertItem(cartDto));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCartData")
    public ResponseEntity<ResponseDTO> getAllCartDetails()
    {
        ResponseDTO responseDTO = new ResponseDTO("list", cartService.listAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getByCartId/{cartId}")
    public ResponseEntity<ResponseDTO> getCartDetailsById(@PathVariable Integer cartId) {
        ResponseDTO responseDTO = new ResponseDTO("cart details retrieved successfully", cartService.getCartDetailsById(cartId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCartItem/{cartId}")
    public ResponseEntity<ResponseDTO> deleteCartById(@PathVariable Integer cartId) {
        ResponseDTO responseDTO = new ResponseDTO("cart id " + cartId + " deleted", cartService.deleteCartItemById(cartId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/updateByCartId/{cartId}")
    public ResponseEntity<ResponseDTO> updateCartById(@PathVariable Integer cartId, @RequestBody CartDTO cartDTO)
    {
        CartData updateRecord = cartService.updateRecordById(cartId, cartDTO);
        ResponseDTO dto = new ResponseDTO(" cart Record updated successfully by Id", updateRecord);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/updateCartQuantity/{id}")
    public ResponseEntity<ResponseDTO> updateQuantity(@PathVariable Integer id, @RequestParam Integer quantity)
    {
        CartData newCart = cartService.updateQuantity(id, quantity);
        ResponseDTO dto = new ResponseDTO("Quantity for book record updated successfully !", newCart);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}
