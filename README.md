☕ Coffee Machine Kata (Architecture Hexagonale)
======

<img width="828" height="466" alt="image" src="https://github.com/user-attachments/assets/7cab05c5-fd12-440d-8555-f96a500e155e" />

# 🎯 Objectifs pédagogiques

-----------
- Apprendre à séparer métier et infrastructure.
- Montrer l’intérêt des ports et adapters.
- Concevoir un domaine testable et extensible.
- Introduire la notion de dépendances vers l’intérieur (domaine au centre).

# 📖 Énoncé de départ

-----------
Vous devez concevoir le logiciel qui pilote une machine à café.

L’utilisateur peut demander une boisson (expresso, thé…).

La machine doit encaisser un paiement et délivrer la boisson si le montant est suffisant.

Sinon, afficher un message d’erreur.

# 🔄 Itérations

-----------

## Itération 1 : Boissons simples

Trois boissons
- Expresso : 1€
- Cappuccino : 1.5€
- Thé : 1€

L’utilisateur insère une montant et choisit sa boisson (Utilisation de l'API)

Si l’argent est suffisant → délivrer la boisson.
Sinon, le résultat est "Montant insuffisant (Prix : X.X€)" avec le vrai montant de la boissson
Si la boisson est inconnue alors on affiche "Boisson inconnue"

💡 But : coder une logique métier propre. On test avec les points d'entrée de l'application

Pour vous aider, vous avez :
- [generated-requests.http](generated-requests.http) pour simuler un app REST avec votre application démarrée
- [CoffeeMachineControllerTest.java](src/test/java/dev/kata/hexa/couche/CoffeeMachineControllerTest.java) : Test comme un TA
- [BoissonDAO.java](src/main/java/dev/kata/hexa/couche/dao/BoissonDAO.java) Qui fera rôle DAO et de base de données

En cible:
- Implémenter les règles métier et faire passer les tests
- Ajouter des tests sur ce qu'on identifie comme métier uniquement

## Itération 2 : Options

Possibilité de choisir sucre (0.1€ de plus)
Si le personne ne précise rien, alors on ne lui ajoute pas de sucre

💡 But : introduire une logique métier un peu plus riche

En cible:
- Implémenter les règles métier et faire passer les tests
- Ajouter des tests sur ce qu'on identifie comme métier uniquement


## Itération 3 : On refait la même chose en hexagonal

Objectif est de dupliquer le code de l'application couche pour la refaire en hexa.
Les deux morceaux, couche et hexa, vont co habituer dans la même application

La machine à café en hexa aura dans son API /hexa pour la distinguer de celle en couche

Pour vous aider, vous avez :
- [generated-requests.http](generated-requests.http) pour simuler un app REST avec votre application démarrée
- [CoffeeMachineControllerTest.java](src/test/java/dev/kata/hexa/couche/CoffeeMachineControllerTest.java) : Test comme un TA la partie couche
- [MachineACafePortControllerTest.java](src/test/java/dev/kata/hexa/heaxagonal/MachineACafePortControllerTest.java) : Test comme un TA la partie heaxagonal

💡 But : introduire des ports, des adapters, une application avec la structure cible de l'hexagonal

## Itération 4 : Ajout des gardes fous

Ajouter des annotations JMolecule dans le but de valider que votre proposition d'organisation respecte les standards de l'architecture hexagonal

💡 But : Valider son architecture et avoir un feedback en cas d'echec

Pour vous aider, vous avez :
- [HexagonalArchitectureTest.java](src/test/java/dev/kata/hexa/heaxagonal/HexagonalArchitectureTest.java) : Test que votre architecture est correct
- https://ersantana.com/software-architecture/jmolecules/jmolecules-hexagonal-architecture-guide La documentation

## Itération 5 : Ajout d'un message

Ajouter un envoi de message (console) quand une boisson est recherchées
Le but est de simuler l'envoie d'un message

💡 But : montrer l’indépendance du domaine → on peut brancher de nouveaux adapters sans toucher au cœur.

Pour vous aider, vous avez :
- [MessagerEnCouche.java](src/test/java/dev/kata/hexa/couche/message/MessagerEnCouche.java) : Pour envoyer un message dans l'architecture en couche
- [MessagerEnHexagonal.java](src/test/java/dev/kata/hexa/hexagonal/infrastructure/secondary/message/MessagerEnHexagonal.java) : Pour envoyer un message dans l'architecture en heaxagonal
