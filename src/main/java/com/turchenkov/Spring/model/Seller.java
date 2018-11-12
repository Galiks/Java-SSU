package com.turchenkov.Spring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "reports")
@Entity
@Table(name = "Seller")
@Data
@EqualsAndHashCode(exclude = "reports")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "Seller_Report",
            joinColumns = @JoinColumn(name = "seller_id"),
            inverseJoinColumns = @JoinColumn(name = "report_id"))
    private Set<Report> reports = new HashSet<>();

    public Seller(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Seller() {
    }
    //    public void addReport(Report report){
//        reports.add(report);
//        report.getSellers().add(this);
//    }
//
//    public void removeReport(Report report){
//        reports.remove(report);
//        report.getSellers().remove(this);
//    }
}
