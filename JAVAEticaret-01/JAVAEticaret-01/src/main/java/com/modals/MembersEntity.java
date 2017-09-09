package com.modals;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "Members", schema = "dbo", catalog = "ETicaret01")
public class MembersEntity {
    private int id;
    private String memberName;
    private String memberSecName;
    private String memberPassword;
    private Integer memberPhone;
    private String memberAddress;
    private int memberRole;
    private Collection<CommentEntity> commentsById;
    private Collection<OrdersEntity> ordersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MemberName", nullable = false, length = 30)
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Basic
    @Column(name = "MemberSecName", nullable = false, length = 30)
    public String getMemberSecName() {
        return memberSecName;
    }

    public void setMemberSecName(String memberSecName) {
        this.memberSecName = memberSecName;
    }

    @Basic
    @Column(name = "MemberPassword", nullable = false, length = 30)
    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    @Basic
    @Column(name = "MemberPhone", nullable = true)
    public Integer getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(Integer memberPhone) {
        this.memberPhone = memberPhone;
    }

    @Basic
    @Column(name = "MemberAddress", nullable = true, length = 70)
    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    @Basic
    @Column(name = "MemberRole", nullable = false)
    public int getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(int memberRole) {
        this.memberRole = memberRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembersEntity that = (MembersEntity) o;

        if (id != that.id) return false;
        if (memberRole != that.memberRole) return false;
        if (memberName != null ? !memberName.equals(that.memberName) : that.memberName != null) return false;
        if (memberSecName != null ? !memberSecName.equals(that.memberSecName) : that.memberSecName != null)
            return false;
        if (memberPassword != null ? !memberPassword.equals(that.memberPassword) : that.memberPassword != null)
            return false;
        if (memberPhone != null ? !memberPhone.equals(that.memberPhone) : that.memberPhone != null) return false;
        if (memberAddress != null ? !memberAddress.equals(that.memberAddress) : that.memberAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (memberName != null ? memberName.hashCode() : 0);
        result = 31 * result + (memberSecName != null ? memberSecName.hashCode() : 0);
        result = 31 * result + (memberPassword != null ? memberPassword.hashCode() : 0);
        result = 31 * result + (memberPhone != null ? memberPhone.hashCode() : 0);
        result = 31 * result + (memberAddress != null ? memberAddress.hashCode() : 0);
        result = 31 * result + memberRole;
        return result;
    }

    @OneToMany(mappedBy = "membersById")
    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "membersByMemberId")
    public Collection<OrdersEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrdersEntity> ordersById) {
        this.ordersById = ordersById;
    }
}
