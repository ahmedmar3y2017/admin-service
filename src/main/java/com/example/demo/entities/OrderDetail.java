package com.example.demo.entities;

// default package
// Generated Nov 23, 2017 7:42:03 PM by Hibernate Tools 5.2.3.Final

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OrderDetail generated by hbm2java
 */
@Entity
@Table(name = "order_detail")
// to dynamic insert and update
@DynamicInsert
@DynamicUpdate
public class OrderDetail implements java.io.Serializable {

    private OrderDetailId id;
    private Orders orders;
    private Product product;
    private Integer orderNumber;
    private Double price;
    private Double quantity;
    private Double discount;
    private Double total;
    private Date billDate;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailId id, Orders orders, Product product) {
        this.id = id;
        this.orders = orders;
        this.product = product;
    }

    public OrderDetail(OrderDetailId id, Orders orders, Product product, Integer orderNumber, Double price,
                       Double quantity, Double discount, Double total, Date billDate) {
        this.id = id;
        this.orders = orders;
        this.product = product;
        this.orderNumber = orderNumber;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.total = total;
        this.billDate = billDate;
    }

    @EmbeddedId

    @AttributeOverrides({
            @AttributeOverride(name = "productid", column = @Column(name = "productid", nullable = false)),
            @AttributeOverride(name = "ordersid", column = @Column(name = "ordersid", nullable = false))})
    public OrderDetailId getId() {
        return this.id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordersid", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "orderNumber")
    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Column(name = "price", precision = 22, scale = 0)
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Column(name = "total", precision = 22, scale = 0)
    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "billDate", length = 0)
    public Date getBillDate() {
        return this.billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

}
