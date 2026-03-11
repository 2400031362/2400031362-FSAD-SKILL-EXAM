package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        Supplier s=new Supplier("ABC Supplier","Electronics",new Date(),"Active");

        session.save(s);

        tx.commit();

        System.out.println("Supplier Inserted");

        session.close();
        sf.close();
    }
}