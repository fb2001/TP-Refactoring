package hai702.tp4.demo.model;
/*
 * Auteur : Benomar Fadel
 *
 * Code Smell illustré : Middle Man
 *
 * Description du défaut :
 * -----------------------
 * La classe CustomerService agit uniquement comme intermédiaire pour accéder
 * aux méthodes de la classe Customer. Elle ne fait qu'exposer des méthodes
 * qui délèguent directement à Customer sans ajouter de logique métier.
 *
 * C’est exactement le code smell "Middle Man" : une classe dont les méthodes
 * ne font que forwarder la requête vers une autre classe.
 *
 * Correction visée :
 * ------------------
 * Le refactoring attendu est en général :
 *   - soit supprimer la classe intermédiaire,
 *   - soit déplacer la logique métier dans cette classe pour qu’elle ait une vraie utilité.
 *
 * Comment le programme a été produit :
 * ------------------------------------
 * Le programme a été généré avec l’aide d’un LLM (ChatGPT).
 * Ensuite, quelques ajustements mineurs ont été faits :
 *   - ajout d'une méthode main plus exhaustive,
 *   - ajout de commentaires détaillés pour le TP,
 *   - simplification de certaines méthodes.
 */

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name  = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getDetails() {
        return "Customer{name='" + name + "', email='" + email + "'}";
    }
}