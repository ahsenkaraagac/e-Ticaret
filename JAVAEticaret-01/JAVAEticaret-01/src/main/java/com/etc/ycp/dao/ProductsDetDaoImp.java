package com.etc.ycp.dao;

import com.modals.ProductDetailsEntity;
import com.modals.ProductsEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by Mithat on 2.08.2017.
 */
public class ProductsDetDaoImp {



    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }



    public List<ProductDetailsEntity> getall() {
        List<ProductDetailsEntity> products_list = null;

        try {
            getSession().beginTransaction();

            // String hql = "FROM ProductsEntity p ORDER BY p.productId";
            //  products_list = getSession().createQuery(hql).list();
            Criteria criteria =getSession().createCriteria(ProductDetailsEntity.class);
           // products_list= criteria.setProjection(Projections.distinct(Projections.property("productDetailId"))).list();
           // products_list = getSession().createCriteria(ProductDetailsEntity.class).list();
            products_list= criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return products_list;
    }

    public List<ProductDetailsEntity> getfilter(String color, String size, String price) {
        List<ProductDetailsEntity> products_list = null;


        try {
            getSession().beginTransaction();

            //    String hql = "FROM ProductsEntity p WHERE p.productDetailsByProductDetailId=:color and ";
            //   String hql1=
            //  products_list = getSession().createQuery(hql).list();

            products_list = getSession().createCriteria(ProductDetailsEntity.class).list();
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return products_list;
    }






    public ProductDetailsEntity get(Integer id) {
        ProductDetailsEntity b = null;
        try {
            getSession().beginTransaction();
            b = (ProductDetailsEntity) getSession().get(ProductDetailsEntity.class, id);
            getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }


}
