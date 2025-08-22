☕ Coffee Machine Kata (Architecture Hexagonale)
======

🎯 Objectifs pédagogiques
-----------
- Apprendre à séparer métier et infrastructure.
- Montrer l’intérêt des ports et adapters.
- Concevoir un domaine testable et extensible.
- Introduire la notion de dépendances vers l’intérieur (domaine au centre).

📖 Énoncé de départ
-----------
Vous devez concevoir le logiciel qui pilote une machine à café.
L’utilisateur peut demander une boisson (expresso, thé…).
La machine doit encaisser un paiement et délivrer la boisson si le montant est suffisant.
Sinon, afficher un message d’erreur.

🔄 Itérations
-----------
# Itération 1 : Boisson simple

Une boisson coûte 1€.

L’utilisateur insère une pièce et choisit sa boisson.

Si l’argent est suffisant → délivrer la boisson.

Sinon → afficher "Montant insuffisant".

💡 But : coder une logique métier propre, testable sans dépendre de la console, de la DB ou du hardware.

# Itération 2 : Prix et options
Ajouter plusieurs boissons avec prix différents :

Expresso : 1€

Cappuccino : 1.5€

Thé : 1€

Possibilité de choisir sucre (0.1€ de plus).

💡 But : introduire une logique métier plus riche → montrer l’intérêt d’objets métier (Boisson, Option, etc.)

# Itération 3 : Moyens de paiement
La machine doit accepter cash et carte.
Les règles métier ne changent pas, seul le moyen de paiement varie.
💡 But : introduire des ports (PaymentPort) et adapters (CashAdapter, CardAdapter).

# Itération 4 : Extension / Simulation
Ajouter un port secondaire :
un MessagePort (console, GUI, logs).
un DrinkDispenserPort (simulation hardware).
Ajouter une règle métier : "si le paiement échoue, afficher un message mais ne pas distribuer la boisson".

💡 But : montrer l’indépendance du domaine → on peut brancher de nouveaux adapters sans toucher au cœur.
