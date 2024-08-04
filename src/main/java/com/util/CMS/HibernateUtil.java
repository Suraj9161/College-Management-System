package com.util.CMS;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("college_management");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        getEntityManagerFactory().close();
    }
}




