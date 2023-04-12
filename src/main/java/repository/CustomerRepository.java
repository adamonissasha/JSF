package repository;

import entity.Customer;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@Singleton
public class CustomerRepository {
    private final EntityManagerFactory entityManagerFactory;

    public CustomerRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Customer> customers = em.createQuery("select new entity.Customer(a.id, a.name, a.surname, a.zipCode, a.email)  from Customer a order by a.id", Customer.class).getResultList();
        em.close();
        System.out.println(customers);
        return customers;
    }

    public Customer getCustomerById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();
        return customer;
    }

    public void editCustomer(Customer newCustomer) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, newCustomer.getId());
        customer.setName(newCustomer.getName());
        customer.setSurname(newCustomer.getSurname());
        customer.setEmail(newCustomer.getEmail());
        customer.setZipCode(newCustomer.getZipCode());
        em.merge(customer);
        em.getTransaction().commit();
    }

    public void addCustomer(String name, String surname, String email, String zipcode) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Customer(null, name, surname, zipcode, email));
        em.getTransaction().commit();
        em.close();
    }

    public void deleteCustomer(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            em.remove(customer);
        }
        em.getTransaction().commit();
        em.close();
    }
}
