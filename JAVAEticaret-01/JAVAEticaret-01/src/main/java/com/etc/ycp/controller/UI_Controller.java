package com.etc.ycp.controller;

import com.etc.ycp.dao.CommentDaoImp;
import com.etc.ycp.dao.ProductsDaoImp;
import com.etc.ycp.dao.ProductsDetDaoImp;
import com.modals.CommentEntity;
import com.modals.ProductDetailsEntity;
import com.modals.ProductsEntity;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mithat on 30.07.2017.
 */

@Controller
@RequestMapping(value = "/UI")
public class UI_Controller {


    @Autowired
    private ProductsDetDaoImp proDetDaoImpl;
    @Autowired
    private ProductsDaoImp proDaoImpl;
    @Autowired
    private CommentDaoImp comDaoImpl;

    @RequestMapping(value = "/index")
    public ModelAndView pagelogin() {

        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }
    @RequestMapping(value = "/register")
    public ModelAndView pageregister() {

        ModelAndView mav = new ModelAndView("/register");
        return mav;
    }


    @RequestMapping(value = "/cart")
    public ModelAndView pagecart() {

        ModelAndView mav = new ModelAndView("/cart");
        return mav;
    }


    @RequestMapping(value = "/cehck")
    public ModelAndView pagecheck() {

        ModelAndView mav = new ModelAndView("/checkout");
        return mav;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView pagecontact() {

        ModelAndView mav = new ModelAndView("/contact");
        return mav;
    }

//    @RequestMapping(value = "/products")
//    public ModelAndView pageproductsLit() {
//
//        ModelAndView mav = new ModelAndView("/products");
//
//        List<ProductsEntity> productsList= proDaoImpl.getall();
//        mav.addObject("productslist",productsList);
//
//        return mav;
//    }


    @RequestMapping(value = "/productslist")
    public ModelAndView pageproductsDetLit() {

        ModelAndView mav = new ModelAndView("/products");

        List<ProductDetailsEntity> productsList= proDetDaoImpl.getall();
        mav.addObject("productslist",productsList);

        return mav;
    }


    @RequestMapping(value = "/productsfilter",method = RequestMethod.GET)
    public ModelAndView productsfilterLit(@RequestParam(value = "Renk", required = false) String Renk,
                                          @RequestParam(value = "Beden", required = false) String Beden,
                                          @RequestParam(value = "Fiyat", required = false) String Fiyat
                                          ) {

        String A=Renk;
        ModelAndView mav = new ModelAndView("/productsFilter");

        List<ProductDetailsEntity> productsList= proDaoImpl.getfilter(Renk,Beden,Fiyat);
        mav.addObject("productslist",productsList);

        return mav;
    }



    @Transactional
    @RequestMapping(value = "/productsDet/{id}")
    public ModelAndView pageproductsDet(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("/product_detail");
        ProductDetailsEntity product = proDetDaoImpl.get(id);
        mav.addObject("productdetail",product);
        List list = new ArrayList(product.getProductsByProductId().getCommentsByProductId());

        mav.addObject("commentList",list);

        return mav;
    }




}
