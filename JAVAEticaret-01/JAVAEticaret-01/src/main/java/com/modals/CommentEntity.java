package com.modals;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "Comment", schema = "dbo", catalog = "ETicaret01")
public class CommentEntity {
    private int commentId;
    private int id;
    private String comment;
    private int productId;
    private MembersEntity membersById;
    private ProductsEntity productsByProductId;

    @Id
    @Column(name = "CommentID", nullable = false)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "id", nullable = false ,insertable = false,updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Comment", nullable = false, length = 50)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "ProductID", nullable = false,insertable = false,updatable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentId != that.commentId) return false;
        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + id;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + productId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public MembersEntity getMembersById() {
        return membersById;
    }

    public void setMembersById(MembersEntity membersById) {
        this.membersById = membersById;
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
