package service;

import entity.Customer;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;
import repository.CustomerRepository;

@ManagedBean
public class CustomerService {
    @Inject
    private CustomerRepository repository;

    private boolean isAdded;

    public void addCustomer() {
//        repository.addCustomer(name, surname, email, zipcode);
//        isAdded = true;
    }

    public void deleteCustomer() {
//        this.customer = repository.getCustomerById(id);
//        repository.deleteCustomer(id);
    }

    public Customer getCustomerById(Long id) {
        System.out.println(id);
        return repository.getCustomerById(id);
    }

    public void editCustomer() {
//        Customer customer1 = repository.getCustomerById(id);
//        if (customer1 != null) {
//            customer = new Customer(id, name, surname, zipcode, email);
//            repository.editCustomer(customer);
//        }
    }
}
