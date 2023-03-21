package Utils;

import POJO.Product;
import POJO.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static  final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.config.xml");
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(User.class);
        //ServiceRegistry lớp trừ tượng
        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }

    public static HibernateUtils getInstance() {
        return new HibernateUtils();
    }
}
