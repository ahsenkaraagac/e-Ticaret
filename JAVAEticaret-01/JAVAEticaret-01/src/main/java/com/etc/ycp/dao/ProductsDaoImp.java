package com.etc.ycp.dao;

import com.modals.CommentEntity;
import com.modals.ProductDetailsEntity;
import com.modals.ProductsEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mithat on 31.07.2017.
 */
public class ProductsDaoImp {




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





    public List<ProductsEntity> getall() {
        List<ProductsEntity> products_list = null;


        try {
            getSession().beginTransaction();

           // String hql = "FROM ProductsEntity p ORDER BY p.productId";
          //  products_list = getSession().createQuery(hql).list();

           products_list = getSession().createCriteria(ProductsEntity.class).list();
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
            Criteria criteria =getSession().createCriteria(ProductDetailsEntity.class);

            if(color==""){
                color=null;
            }
            if(size==""){
                size=null;
            }
            if(price!=""){
                int price_final=Integer.parseInt(price);
                criteria.add(Restrictions.le("productPrice",price_final));
            }

            addRestrictionIfNotNull(criteria,"productColor",color);
            addRestrictionIfNotNull(criteria,"productSize",size);
            products_list=criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            criteria.setMaxResults(100);


//            Criteria c = getSession().createCriteria(ProductDetailsEntity.class);
//            //c.add(Restrictions.eq("productColor", color));
//            c.add(Restrictions.eq("productSize", size));
//            c.add(color== null ? Restrictions.isNull("productColor") : Restrictions.eq("productcolor",color));
//
//            products_list = c.list();


            //  products_list=getSession().createQuery("SELECT sc from ProductDetailsEntity sc where productColor = :color and productSize=:size and productPrice<=:price").setParameter("color" ,color).setParameter("size",size).setParameter("price",price).list();




            //  products_list= getSession().createSQLQuery(sql).list();

            //products_list = getSession().createCriteria(ProductsEntity.class).list();
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return products_list;
    }

    public void addRestrictionIfNotNull(Criteria criteria, String propertyName, Object value) {
        if (value != null) {
            criteria.add(Restrictions.eq(propertyName, value));
        }
    }


    public Object EqOrNull(String property, Object value) {
        if (value == null)
            return Restrictions.isNull(property);
        return Restrictions.eq(property, value);
    }










    public ProductsEntity get(Integer id) {
        ProductsEntity b = null;
        try {
            getSession().beginTransaction();
            b = (ProductsEntity) getSession().get(ProductsEntity.class, id);
            getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }


}
