package com.modals;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "OrderStats", schema = "dbo", catalog = "ETicaret01")
public class OrderStatsEntity {
    private int orderStatId;
    private String orderStatus;
    private Collection<OrdersEntity> ordersByOrderStatId;

    @Id
    @Column(name = "OrderStatID", nullable = false)
    public int getOrderStatId() {
        return orderStatId;
    }

    public void setOrderStatId(int orderStatId) {
        this.orderStatId = orderStatId;
    }

    @Basic
    @Column(name = "OrderStatus", nullable = false, length = 50)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStatsEntity that = (OrderStatsEntity) o;

        if (orderStatId != that.orderStatId) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderStatId;
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "orderStatsByOrderStatId")
    public Collection<OrdersEntity> getOrdersByOrderStatId() {
        return ordersByOrderStatId;
    }

    public void setOrdersByOrderStatId(Collection<OrdersEntity> ordersByOrderStatId) {
        this.ordersByOrderStatId = ordersByOrderStatId;
    }
}
