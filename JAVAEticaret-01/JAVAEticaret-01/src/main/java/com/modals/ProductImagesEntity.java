package com.modals;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "ProductImages", schema = "dbo", catalog = "ETicaret01")
public class ProductImagesEntity {
    private int productImageId;
    private String productImage;
    private Collection<ProductsEntity> productsByProductImageId;

    @Id
    @Column(name = "ProductImageID", nullable = false)
    public int getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(int productImageId) {
        this.productImageId = productImageId;
    }

    @Basic
    @Column(name = "ProductImage", nullable = true, length = 50)
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductImagesEntity that = (ProductImagesEntity) o;

        if (productImageId != that.productImageId) return false;
        if (productImage != null ? !productImage.equals(that.productImage) : that.productImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productImageId;
        result = 31 * result + (productImage != null ? productImage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productImagesByProductImageId")
    public Collection<ProductsEntity> getProductsByProductImageId() {
        return productsByProductImageId;
    }

    public void setProductsByProductImageId(Collection<ProductsEntity> productsByProductImageId) {
        this.productsByProductImageId = productsByProductImageId;
    }
}
