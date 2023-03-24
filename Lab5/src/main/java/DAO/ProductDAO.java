package DAO;

import Interface.IProduct;
import POJO.Product;
import POJO.User;
import Utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDAO extends GenericDAO<Product> implements IProduct{
    private SessionFactory session = HibernateUtils.getFactory();

    public static ProductDAO getInstance() {
        return new ProductDAO(Product.class);
    }
    protected ProductDAO(Class<Product> clazz) {
        super(clazz);
    }

    @Override
    public List<Product> getAll() {
        Session session =  this.session.openSession();
        Criteria cr = session.createCriteria(Product.class);
        List results = cr.list();
        return results;
    }
}
