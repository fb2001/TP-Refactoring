package hai702.tp4.demo.main;

import hai702.tp4.demo.model.Customer;
import hai702.tp4.demo.service.CustomerService;

public class Main {
    public static void main(String[] args) {
        // Création du customer
        Customer c = new Customer("Fadel Benomar", "fadel@example.com");

        // La classe CustomerService n'apporte aucune valeur ajoutée
        CustomerService service = new CustomerService(c);

        System.out.println("---- Test du programme présentant le code smell Middle Man ----");

        System.out.println("Nom du client via CustomerService : " + service.getCustomerName());

        System.out.println("Détails avant modification : " + service.getCustomerInfo());

        // Modification via CustomerService
        service.changeCustomerEmail("fadel.benomar@newmail.com");

        System.out.println("Détails après modification : " + service.getCustomerInfo());

        System.out.println("\nComme on le voit, la classe CustomerService ne fait que forwarder les appels.");
    }
}