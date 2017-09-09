package com.modals;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "ProductDetails", schema = "dbo", catalog = "ETicaret01")
public class ProductDetailsEntity {
    private int productDetailId;
    private String productColor;
    private String productSize;
    private int productPrice;
    private int productId;
    private ProductsEntity productsByProductId;

    @Id
    @Column(name = "ProductDetailID", nullable = false)
    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    @Basic
    @Column(name = "ProductColor", nullable = false, length = 30)
    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    @Basic
    @Column(name = "ProductSize", nullable = false, length = 30)
    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    @Basic
    @Column(name = "ProductPrice", nullable = false)
    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
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

        ProductDetailsEntity that = (ProductDetailsEntity) o;

        if (productDetailId != that.productDetailId) return false;
        if (productPrice != that.productPrice) return false;
        if (productId != that.productId) return false;
        if (productColor != null ? !productColor.equals(that.productColor) : that.productColor != null) return false;
        if (productSize != null ? !productSize.equals(that.productSize) : that.productSize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productDetailId;
        result = 31 * result + (productColor != null ? productColor.hashCode() : 0);
        result = 31 * result + (productSize != null ? productSize.hashCode() : 0);
        result = 31 * result + productPrice;
        result = 31 * result + productId;
        return result;
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
