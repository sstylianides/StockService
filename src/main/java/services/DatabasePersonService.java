package services;

import models.Person;
import models.PersonStock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;

public class DatabasePersonService implements PersonService {


    /**
     * Get a list of all people
     *
     * @return a list of models.Person instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPeople() throws StockServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not get models.Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getStocks(Person person) throws StockServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<String> stocks = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonStock.class);
            criteria.add(Restrictions.eq("person", person));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            List<PersonStock> list = criteria.list();
            for (PersonStock personStock : list) {
                stocks.add(personStock.getStock());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not get Stocks data. " + e.getMessage(), e);

        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        return stocks;
    }

    /**
     * Add a new person or update an existing models.Person's data
     *
     * @param person a person object to either update or create
     */
    @Override
    public void addOrUpdatePerson(Person person) throws StockServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not save or update person data. " + e.getMessage(), e);

        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

    }



    @Override
    public void addStockToPerson(String symbol, Person person) throws StockServiceException {

        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersonStock personStock = new PersonStock();
            personStock.setStock(symbol);
            personStock.setPerson(person);
            session.saveOrUpdate(personStock);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not add stock to person. " + e.getMessage(), e);

        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

    }
}
