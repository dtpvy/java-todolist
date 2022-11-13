package DAL;

import BLL.Item;
import UTIL.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAO {
    private static List<Item> itemList;

    public static List<Item> getItemList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Item i ORDER BY i.id ASC";
            Query query = session.createQuery(hql);
            itemList = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return itemList;
    }

    public static Item addItem(Item item) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            System.out.println("New item id: " + item.getId());
            return item;
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public static Item getItemByID(int id) {
        Item item = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            item = (Item) session.get(Item.class, id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return item;
    }

    public static boolean removeItem(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Item item = getItemByID(id);
        if (item == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(item);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean updateItem(Item item) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
