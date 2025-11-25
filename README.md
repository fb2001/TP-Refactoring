# Refactoring du code : élimination partielle du Middle Man avec IntelliJ

## Contexte

Le code initial présentait un *code smell* de type **Middle Man** :  
la classe `CustomerService` ne contenait aucune logique métier et se contentait de déléguer les appels aux méthodes de la classe `Customer`.

Dans ce contexte, la classe intermédiaire n’apportait aucune valeur ajoutée et complexifiait la structure du programme.

L’objectif du refactoring, proposé directement via **IntelliJ IDEA** avec le plugin **Additional Java Refactorings**, est de **simplifier l’accès à l’objet Customer** tout en conservant une option de service pour d’éventuelles extensions futures.

---

## Problème identifié : Middle Man

La classe `CustomerService` présentait les caractéristiques suivantes :

- Les méthodes `getCustomerName`, `changeCustomerEmail` et `getCustomerInfo` ne faisaient que déléguer à `Customer` (`getName`, `updateEmail`, `getDetails`).
- Aucune transformation ou règle métier n’était appliquée.
- La profondeur des couches logicielles était inutilement augmentée.

Ce pattern est exactement ce que l’on appelle le **Middle Man**, considéré comme un code smell.

---

## Solution appliquée avec IntelliJ

### Adaptation via le plugin Additional Java Refactorings

Le plugin a détecté les méthodes purement délégantes et a proposé un refactoring de type **Inline Delegate / Simplification de la classe intermédiaire**.

#### Actions effectuées

1. La classe `CustomerService` a été simplifiée :
    - Toutes les méthodes de délégation directe ont été supprimées.
    - Elle ne contient désormais qu’une méthode `getCustomer()`, permettant d’accéder directement à l’objet `Customer`.

2. Les appels dans la classe `Main` ont été mis à jour pour accéder directement au `Customer` via `getCustomer()`.

3. Le code reste fonctionnel et les tests via la méthode `main` confirment que la délégation est réduite au strict minimum.

---

## Exemple après refactoring

```java
Customer c = new Customer("Fadel Benomar", "fadel@example.com");
CustomerService service = new CustomerService(c);

System.out.println("Nom du client via CustomerService : " + service.getCustomer().getName());
System.out.println("Détails avant modification : " + service.getCustomer().getDetails());

service.getCustomer().updateEmail("fadel.benomar@newmail.com");

System.out.println("Détails après modification : " + service.getCustomer().getDetails());
