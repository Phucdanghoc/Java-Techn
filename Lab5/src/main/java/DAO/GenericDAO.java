package DAO;

import Interface.Generic;
import Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class GenericDAO<T> implements Generic<T> {

    private SessionFactory session = HibernateUtils.getFactory();

    private Class<T> clazz;
    protected GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }
    public abstract List<T> getAll();

    public boolean add(T p) {
        Session session = this.session.openSession();
        try {
            session.getTransaction().begin();
            session.save(p);
            session.getTransaction().commit();
            return true;
        }catch (Exception x){
            session.close();
        }
        return false;
    }

    public T get(int id) {
        Session session = this.session.openSession();
        try {
            session.getTransaction().begin();
            T object =  session.get(clazz, id);
            return object;
        }catch (Exception x){
            x.printStackTrace();
            session.close();
        }
        return null;
    }
    public boolean remove(int ID) {
        Session session = this.session.openSession();
        try {
            session.getTransaction().begin();
            session.delete(this.get(ID));
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.close();
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(T p) {
        Session session = this.session.openSession();
        try {
            session.getTransaction().begin();
            session.update(p);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.close();
            e.printStackTrace();
        }
        return false;
    }
}
