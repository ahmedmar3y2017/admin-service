package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Orders generated by hbm2java
 */
@Where(clause = "available =1")

@Entity
@Table(name = "orders", catalog = "businessin")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate
public class Orders implements java.io.Serializable {

    private Integer id;
    private Customers customers;
    private Payment payment;
    private Shippers shippers;
    private Double quantity;
    private Double discount;
    private Date orderDate;
    private Integer paid;
    private Date paymentDate;
    private Double salesTax;

    @Column(name = "available", columnDefinition = "boolean default true")
    private boolean available;
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

    public Orders() {
    }

    public Orders(Customers customers, Payment payment, Shippers shippers) {
        this.customers = customers;
        this.payment = payment;
        this.shippers = shippers;
    }


    public Orders(Integer id, Customers customers, Payment payment, Shippers shippers, Double quantity, Double discount, Date orderDate, Integer paid, Date paymentDate, Double salesTax, boolean available) {
        this.id = id;
        this.customers = customers;
        this.payment = payment;
        this.shippers = shippers;
        this.quantity = quantity;
        this.discount = discount;
        this.orderDate = orderDate;
        this.paid = paid;
        this.paymentDate = paymentDate;
        this.salesTax = salesTax;
        this.available = available;
    }

    public Orders(Customers customers, Payment payment, Shippers shippers, Double quantity, Double discount,
                  Date orderDate, Integer paid, Date paymentDate, Double salesTax,
                  Set<OrderDetail> orderDetails) {
        this.customers = customers;
        this.payment = payment;
        this.shippers = shippers;
        this.quantity = quantity;
        this.discount = discount;
        this.orderDate = orderDate;
        this.paid = paid;
        this.paymentDate = paymentDate;
        this.salesTax = salesTax;
        this.orderDetails = orderDetails;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customersid", nullable = false, updatable = false)
    @JsonIgnore
    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentid", nullable = false, updatable = false)
    @JsonIgnore

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shippersid", nullable = false, updatable = false)
    @JsonIgnore
    public Shippers getShippers() {
        return this.shippers;
    }

    public void setShippers(Shippers shippers) {
        this.shippers = shippers;
    }

    @Column(name = "quantity", precision = 22, scale = 0)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Column(name = "discount", precision = 22, scale = 0)
    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "orderDate", length = 0)
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "paid")
    public Integer getPaid() {
        return this.paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "paymentDate", length = 0)
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "salesTax", precision = 22, scale = 0)
    public Double getSalesTax() {
        return this.salesTax;
    }

    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
