package com.example.spring_book_store.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@Table(name = "cart_table")
    public class CartData
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "cart_id")
        public int CartId;

        @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        public UserData userDetail;

        @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "book_id")
        public BookData bookStore;

        @Column(name = "quantity")
        public int quantity;
        @Column(name = "price")
        public int price;

        public CartData( UserData userDetail,BookData bookStore, int quantity,int price) {

                this.userDetail = userDetail;
                this.bookStore = bookStore;
                this.quantity = quantity;
                this.price=price;

        }

        public CartData()
        {
        }
}
