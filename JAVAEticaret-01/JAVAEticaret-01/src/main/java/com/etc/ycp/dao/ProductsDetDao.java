package com.etc.ycp.dao;

import com.modals.ProductDetailsEntity;
import com.modals.ProductsEntity;

import java.util.List;

/**
 * Created by Mithat on 2.08.2017.
 */
public interface ProductsDetDao {

    public ProductDetailsEntity get(Integer id);
    public List<ProductDetailsEntity> getall();


}
