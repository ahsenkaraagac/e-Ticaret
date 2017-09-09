package com.etc.ycp.dao;

import com.modals.ProductsEntity;

import java.util.List;

/**
 * Created by Mithat on 31.07.2017.
 */
public interface ProductsDao {


    public ProductsEntity get(Integer id);
    public List<ProductsEntity> getall();
    public List<ProductsEntity> getfilter(String color,String size,String price);

}
