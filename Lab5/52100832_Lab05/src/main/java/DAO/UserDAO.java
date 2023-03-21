package DAO;

import Interface.IUser;
import POJO.User;
import Utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDAO extends GenericDAO<User> implements IUser {
    private SessionFactory session = HibernateUtils.getFactory();

    public static UserDAO getInstance() {
        return new UserDAO(User.class);
    }
    protected UserDAO(Class<User> clazz) {
        super(clazz);
    }

    @Override
    public boolean CheckLogin(String username, String password) {
        Session session = this.session.openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.and(Restrictions.eq("Username",username),Restrictions.eq("Password",password)));
        List result = cr.list();
        return  result.isEmpty() ? true : false;
    }

    @Override
    public List<User> getAll() {
        Session session =  this.session.openSession();
        Criteria cr = session.createCriteria(User.class);
        List results = cr.list();
        return results;
    }
}
