package com.turchenkov.Spring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Report")
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Date")
    private String date;

    @Column(name = "The_number_of_the_sales_receipt")
    private int number;

    @Column(name = "Cost")
    private int cost;

    @Column(name = "Prepayment")
    private int prepayment;

    @Column(name = "Payment")
    private int payment;

    @Column(name = "Consumption")
    private int consumption;

    @Column(name = "Description")
    private String description;
}
