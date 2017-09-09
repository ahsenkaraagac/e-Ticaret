package com.modals;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mithat on 3.08.2017.
 */
@Entity
@Table(name = "Categories", schema = "dbo", catalog = "ETicaret01")
public class CategoriesEntity {
    private int categoryId;
    private Integer parentCategoryId;
    private String categoryName;
    private CategoriesEntity categoriesByParentCategoryId;
    private Collection<CategoriesEntity> categoriesByCategoryId;
    private Collection<ProductsEntity> productsByCategoryId;

    @Id
    @Column(name = "CategoryID", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "ParentCategoryID", nullable = true,insertable = false,updatable = false)
    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    @Basic
    @Column(name = "CategoryName", nullable = false, length = 50)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesEntity that = (CategoriesEntity) o;

        if (categoryId != that.categoryId) return false;
        if (parentCategoryId != null ? !parentCategoryId.equals(that.parentCategoryId) : that.parentCategoryId != null)
            return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (parentCategoryId != null ? parentCategoryId.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ParentCategoryID", referencedColumnName = "CategoryID")
    public CategoriesEntity getCategoriesByParentCategoryId() {
        return categoriesByParentCategoryId;
    }

    public void setCategoriesByParentCategoryId(CategoriesEntity categoriesByParentCategoryId) {
        this.categoriesByParentCategoryId = categoriesByParentCategoryId;
    }

    @OneToMany(mappedBy = "categoriesByParentCategoryId")
    public Collection<CategoriesEntity> getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Collection<CategoriesEntity> categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @OneToMany(mappedBy = "categoriesByCategoryId")
    public Collection<ProductsEntity> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Collection<ProductsEntity> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }
}
