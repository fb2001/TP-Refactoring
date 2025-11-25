package hai702.tp4.demo.main;

import hai702.tp4.demo.model.Customer;

public class Main {
    public static void main(String[] args) {

        Customer c = new Customer("Fadel Benomar", "fadel@example.com");

        System.out.println("---- Test du programme refactoré (Middle Man supprimé) ----");

        System.out.println("Nom du client : " + c.getName());

        System.out.println("Détails avant modification : " + c.getDetails());

        c.updateEmail("fadel.benomar@newmail.com");

        System.out.println("Détails après modification : " + c.getDetails());

        System.out.println("\nLa classe CustomerService a été supprimée : plus de code smell Middle Man !");
    }
}
