package music.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import music.business.Product;

public class ProductDB {

    public static Product selectProduct(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p " +
                "WHERE p.code = :code";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("code", code);
        Product result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return (Product)result;
    }
    
    public static long selectProductID(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p.productId FROM Product p " +
                "WHERE p.code = :code";
        TypedQuery<Long> q = em.createQuery(qString, Long.class);
        q.setParameter("code", product.getCode());
        Long result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return -1;
        } finally {
            em.close();
        }
        
        return result;
    }
    
    public static Product selectProduct(long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        return em.find(Product.class, productId);
    }
    
    public static boolean exists(String productCode) {
        Product p = selectProduct(productCode);
        if (p != null) return true;
        else return false;
    }    
    
    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Product p";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        List<Product> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }
    
    public static void insertProduct(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
       
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.err.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateProduct(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Product p = selectProduct(product.getCode());
            product.setId(p.getId());
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.err.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void deleteProduct(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Product p = em.merge(product);
            em.remove(p);
            trans.commit();
        } catch (Exception e) {
            System.err.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}