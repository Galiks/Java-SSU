package com.turchenkov.Spring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "sellers")
@Entity
@Table(name = "Report")
@Data
@EqualsAndHashCode(exclude = "sellers")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NaturalId
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

    @ManyToMany(mappedBy = "reports")
    private Set<Seller> sellers = new HashSet<>();

    public Report() {
    }

    public Report(String date, int number, int cost, int prepayment, int payment, int consumption, String description) {
        this.date = date;
        this.number = number;
        this.cost = cost;
        this.prepayment = prepayment;
        this.payment = payment;
        this.consumption = consumption;
        this.description = description;
    }
}
