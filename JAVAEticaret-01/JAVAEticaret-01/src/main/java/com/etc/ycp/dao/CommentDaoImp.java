package com.etc.ycp.dao;

import com.modals.CommentEntity;
import com.modals.ProductDetailsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Mithat on 3.08.2017.
 */
public class CommentDaoImp {






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



    public List<CommentEntity> getall() {
        List<CommentEntity> comment_list = null;

        try {
            getSession().beginTransaction();

            // String hql = "FROM ProductsEntity p ORDER BY p.productId";
            //  products_list = getSession().createQuery(hql).list();

            comment_list = getSession().createCriteria(CommentEntity.class).list();
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return comment_list;
    }


    public List<CommentEntity> getfilter(int productid) {
        List<CommentEntity> comment_list = null;


        try {
            getSession().beginTransaction();

            //    String hql = "FROM ProductsEntity p WHERE p.productDetailsByProductDetailId=:color and ";
            //   String hql1=
            //  products_list = getSession().createQuery(hql).list();
            //  String sql="SELECT * FROM  ETicaret01.dbo.ProductDetails pd ,ETicaret01.dbo.Products p WHERE pd.ProductID=p.ProductID AND pd.ProductColor ='Red' AND pd.ProductSize='L'";

        //    comment_list=getSession().createQuery("SELECT sc from CommentEntity sc where productsByProductId.productId=: and productSize=:size").setParameter("color" ,color).setParameter("size",size).list();

            //  products_list= getSession().createSQLQuery(sql).list();

            //products_list = getSession().createCriteria(ProductsEntity.class).list();
            getSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return comment_list;
    }


}
