package hai702.tp4.demo.service;

import hai702.tp4.demo.model.Customer;

/*
 * Classe CustomerService : Middle Man
 *
 * Cette classe n'apporte aucune logique métier.
 * Elle expose seulement des méthodes qui renvoient à Customer.
 * Elle représente donc parfaitement le code smell "Middle Man".
 */
public class CustomerService {
    private Customer customer;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customer.getName();  // simple délégation
    }

    public void changeCustomerEmail(String email) {
        customer.updateEmail(email);  // simple délégation
    }

    public String getCustomerInfo() {
        return customer.getDetails();  // simple délégation
    }
}
