
# Refactoring du code : élimination du Middle Man

## Contexte

Le code initial présentait un *code smell* de type **Middle Man**.  
La classe `CustomerService` ne contenait aucune logique supplémentaire : elle se contentait de déléguer les appels aux méthodes de la classe `Customer`.  
Dans ce contexte, cette classe intermédiaire était inutile et compliquait la structure globale du programme.

L’objectif du refactoring est de supprimer cette classe superflue et de simplifier le code en accédant directement à l’objet `Customer`.

Ce refactoring a été proposé par un LLM (ChatGPT) en réponse au prompt suivant :
``fais moi un refactoring de ce code. Le problème de ce code est qu'il présente un middle man au niveau du service. corriger et améliorer le code :``

## Problème identifié : Middle Man

La classe `CustomerService` n'apportait aucune valeur ajoutée :

- les méthodes `getCustomerName`, `changeCustomerEmail` et `getCustomerInfo` ne faisaient qu'appeler respectivement `getName`, `updateEmail` et `getDetails` de `Customer`,
- aucune logique métier, transformation de données ou règle métier n'était appliquée.

Une telle classe est considérée comme du code inutile et entraîne une complexité artificielle.

## Solution appliquée

### Suppression de la classe `CustomerService`

La classe intermédiaire a été entièrement supprimée.

### Mise à jour de la classe `Main`

Les appels sont effectués directement sur l’instance de `Customer`, ce qui rend le code plus clair et réduit la profondeur des couches logicielles.

Exemple après refactoring :

```java
Customer c = new Customer("Fadel Benomar", "fadel@example.com");

System.out.println(c.getName());
System.out.println(c.getDetails());

c.updateEmail("fadel.benomar@newmail.com");

System.out.println(c.getDetails());
