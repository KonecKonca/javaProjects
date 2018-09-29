package Hiber;

import Hiber.lib.HibernateUtil;
import org.hibernate.SessionFactory;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
    }
}
