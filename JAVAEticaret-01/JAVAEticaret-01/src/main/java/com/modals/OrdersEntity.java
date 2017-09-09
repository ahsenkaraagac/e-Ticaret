package com.modals;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "Orders", schema = "dbo", catalog = "ETicaret01")
public class OrdersEntity {
    private int orderId;
    private int memberId;
    private int orderStatId;
    private Collection<OrderDetailsEntity> orderDetailsByOrderId;
    private MembersEntity membersByMemberId;
    private OrderStatsEntity orderStatsByOrderStatId;

    @Id
    @Column(name = "OrderID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "MemberID", nullable = false,insertable = false,updatable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "OrderStatID", nullable = false,insertable = false,updatable = false)
    public int getOrderStatId() {
        return orderStatId;
    }

    public void setOrderStatId(int orderStatId) {
        this.orderStatId = orderStatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderId != that.orderId) return false;
        if (memberId != that.memberId) return false;
        if (orderStatId != that.orderStatId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + memberId;
        result = 31 * result + orderStatId;
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<OrderDetailsEntity> getOrderDetailsByOrderId() {
        return orderDetailsByOrderId;
    }

    public void setOrderDetailsByOrderId(Collection<OrderDetailsEntity> orderDetailsByOrderId) {
        this.orderDetailsByOrderId = orderDetailsByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "MemberID", referencedColumnName = "id", nullable = false)
    public MembersEntity getMembersByMemberId() {
        return membersByMemberId;
    }

    public void setMembersByMemberId(MembersEntity membersByMemberId) {
        this.membersByMemberId = membersByMemberId;
    }

    @ManyToOne
    @JoinColumn(name = "OrderStatID", referencedColumnName = "OrderStatID", nullable = false)
    public OrderStatsEntity getOrderStatsByOrderStatId() {
        return orderStatsByOrderStatId;
    }

    public void setOrderStatsByOrderStatId(OrderStatsEntity orderStatsByOrderStatId) {
        this.orderStatsByOrderStatId = orderStatsByOrderStatId;
    }
}
