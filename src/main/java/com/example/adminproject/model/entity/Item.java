package com.example.adminproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderDetailList","partner"})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;


    //Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetailList;

    //Item N : 1 Partner
    @ManyToOne
    private Partner partner;

    /*//1: N
    //Lazy= Select * from item where id= ?
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetailList;*/
}