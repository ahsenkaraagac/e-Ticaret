package com.modals;

import javax.persistence.*;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "OrderDetails", schema = "dbo", catalog = "ETicaret01")
public class OrderDetailsEntity {
    private int orderDetailId;
    private int orderId;
    private int productId;
    private int priceId;
    private String orderName;
    private OrdersEntity ordersByOrderId;
    private ProductsEntity productsByProductId;

    @Id
    @Column(name = "OrderDetailID", nullable = false)
    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    @Basic
    @Column(name = "OrderID", nullable = false,insertable = false,updatable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "ProductID", nullable = false,insertable = false,updatable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PriceID", nullable = false)
    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Basic
    @Column(name = "OrderName", nullable = false, length = 50)
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsEntity that = (OrderDetailsEntity) o;

        if (orderDetailId != that.orderDetailId) return false;
        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;
        if (priceId != that.priceId) return false;
        if (orderName != null ? !orderName.equals(that.orderName) : that.orderName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderDetailId;
        result = 31 * result + orderId;
        result = 31 * result + productId;
        result = 31 * result + priceId;
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", nullable = false)
    public OrdersEntity getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(OrdersEntity ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
