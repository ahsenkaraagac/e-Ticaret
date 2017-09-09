package com.modals;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "Products", schema = "dbo", catalog = "ETicaret01")

public class ProductsEntity {
    private int productId;
    private int categoryId;
    private String productName;
    private int productImageId;
    private Collection<CommentEntity> commentsByProductId;
    private Collection<OrderDetailsEntity> orderDetailsByProductId;
    private Collection<ProductDetailsEntity> productDetailsByProductId;
    private CategoriesEntity categoriesByCategoryId;
    private ProductImagesEntity productImagesByProductImageId;

    @Id
    @Column(name = "ProductID", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "CategoryID", nullable = false,insertable = false,updatable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "ProductName", nullable = false, length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "ProductImageID", nullable = false,insertable = false,updatable = false)
    public int getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(int productImageId) {
        this.productImageId = productImageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (productId != that.productId) return false;
        if (categoryId != that.categoryId) return false;
        if (productImageId != that.productImageId) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;

        return true;

    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + categoryId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + productImageId;
        return result;
    }





    @OneToMany(mappedBy = "productsByProductId",fetch = FetchType.EAGER)
    public Collection<CommentEntity> getCommentsByProductId() {
        return commentsByProductId;
    }

    public void setCommentsByProductId(Collection<CommentEntity> commentsByProductId) {
        this.commentsByProductId = commentsByProductId;
    }

    @OneToMany(mappedBy = "productsByProductId")
  //  @Fetch(FetchMode.SUBSELECT)
    public Collection<OrderDetailsEntity> getOrderDetailsByProductId() {
        return orderDetailsByProductId;
    }

    public void setOrderDetailsByProductId(Collection<OrderDetailsEntity> orderDetailsByProductId) {
        this.orderDetailsByProductId = orderDetailsByProductId;
    }

    @OneToMany(mappedBy = "productsByProductId")
    public Collection<ProductDetailsEntity> getProductDetailsByProductId() {
        return productDetailsByProductId;
    }

    public void setProductDetailsByProductId(Collection<ProductDetailsEntity> productDetailsByProductId) {
        this.productDetailsByProductId = productDetailsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID", nullable = false)
    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "ProductImageID", referencedColumnName = "ProductImageID", nullable = false)
    public ProductImagesEntity getProductImagesByProductImageId() {
        return productImagesByProductImageId;
    }

    public void setProductImagesByProductImageId(ProductImagesEntity productImagesByProductImageId) {
        this.productImagesByProductImageId = productImagesByProductImageId;
    }
}
