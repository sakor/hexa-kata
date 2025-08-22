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
Sinon, le résultat est "Montant insuffisant".

💡 But : coder une logique métier propre. On test avec les points d'entrée de l'application

## Itération 2 : Options

Possibilité de choisir sucre (0.1€ de plus)

💡 But : introduire une logique métier plus riche → montrer l’intérêt d’objets métier (Boisson, Option, etc.)

## Itération 3 : On refait la même chose en hexa

💡 But : introduire des ports (PaymentPort) et adapters (CashAdapter, CardAdapter).

## Itération 4 : Ajout d'un message

Ajouter un envoi de message (console) quand une boisson est demandée

💡 But : montrer l’indépendance du domaine → on peut brancher de nouveaux adapters sans toucher au cœur.

## Itération 5 : Moyens de paiement

La machine doit accepter cash et carte.

Les règles métier ne changent pas sur la commande de boisson.
Si on a un paiement par carte, alors on doit controller que la carte à suffisament d'argent.
Utilisez pour ça le bean :
- Pour l'archi en couche :
- Pour l'archi en hexa :

💡 But : introduire des ports (PaymentPort) et adapters (CashAdapter, CardAdapter).




🔍 Comparaison avec l’hexagonale
-----------
Architecture en couches :
- Facile à lire pour des juniors.
- Mais le domaine est fortement lié à la technique (DAO, dev.kata.hexa.couche.controller).
- Difficile d’ajouter un autre mode d’interaction (GUI, API REST, hardware) sans dupliquer.

Architecture hexagonale :
- Domaine indépendant, testable sans infrastructure.
- Ports/adapters facilitent l’évolution (ajouter carte bancaire, un écran tactile, etc.).
- Demande un peu plus de maturité et de discipline.
