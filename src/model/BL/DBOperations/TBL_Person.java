package model.BL.DBOperations;

import model.BL.hibernateUtil.HibernateClassicUtil;
import model.BL.ORM.PersonTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class TBL_Person
{
    Session session;
    Transaction transaction;

    public void insert (String name , String family)
    {

        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();
        // mikham yek transaction anjam bedam mesle insert , update , delete

        PersonTO pTO = new PersonTO();
        pTO.setName(name);
        pTO.setFamily(family);

        session.save(pTO); // yani insert
        transaction.commit();
        session.close();

    }




    public void update (String name , String family)
    {

        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();
        // mikham yek transaction anjam bedam mesle insert , update , delete

        PersonTO pTO = new PersonTO();
        pTO.setName("aliiiiiiiiiiiiiiii");
        pTO.setId(3);

        session.update(pTO); // yani insert
        transaction.commit();
        session.close();

    }

    public void updateJustName (String name , long id)
    {

        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();

        PersonTO pTO = (PersonTO) session.get(PersonTO.class,id);
        pTO.setName(name);

        session.update(pTO);
        transaction.commit();
        session.close();

    }


    public void saveOrUpdate (String name , String family)
    {
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();

        PersonTO pTO = new PersonTO();
        pTO.setName("ali");
       // pTO.setFamily("test");
        pTO.setId(2);

        session.saveOrUpdate(pTO); // yani update
        transaction.commit();
        session.close();

    }

    public void delete (int id){
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();
        // mikham yek transaction anjam bedam mesle insert , update , delete

        PersonTO pTO = new PersonTO();
        pTO.setId(id);
        session.delete(pTO);
        transaction.commit();
        session.close();

    }

    public void deleteWithoutId (long id){
        session = HibernateClassicUtil.getSession();

        session.beginTransaction();
       // transaction = session.beginTransaction();

        PersonTO pTO = (PersonTO) session.get(PersonTO.class, id);

        session.delete(pTO);

        session.getTransaction().commit();
       // transaction.commit();
        session.close();

    }


    public void select(String name , String family)
    {
        session = HibernateClassicUtil.getSession();
         Iterator<PersonTO> i = session.createQuery("from PersonTO").iterate(); // bedoone where
         List<PersonTO> ii = session.createQuery("from PersonTO").list();

        // Iterator<PersonTO> i = session.createQuery("from PersonTO p where p.id=2").iterate();
       // Iterator<PersonTO> i = session.createQuery("from PersonTO p where p.name= :a").setParameter("a",name).iterate();
       // Iterator<PersonTO> i = session.createQuery("from PersonTO p where p.name= :a and p.family= :bb").setParameter("a",name).setParameter("bb",family).iterate();

        while (i.hasNext())
        {
            PersonTO pTO  = i.next();
            System.out.println(pTO.getId());
            System.out.println(pTO.getName());
            System.out.println(pTO.getFamily());
            System.out.println("***********************");
        }
    }

}




