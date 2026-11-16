Actions supplémentaires à faire pour le TP :

# TDD
Implémenter les nouvelles fonctionnalités ci-dessous en TDD:
1. Valider les horaires des visites.

Visit contient une heure de début et une heure de fin, mais rien n'empêche les horaires null, une durée nulle ou une fin antérieure au début. Ecrivez des tests pour ces cas, puis implémentez la règle. Conservez le comportement actuel des visites sans chevauchement.

2. Éviter les spécialités en double.

Vet.addSpecialty peut actuellement ajouter plusieurs spécialités portant le même nom. Écrivez des tests pour vérifier qu'une spécialité déjà présente - éventuellement avec une différence de casse, comme "Dentisterie» et "dentisterie» - n'est pas ajoutée une seconde fois.

3. Ajouter la suppression d'une spécialité.

Vet permet d'ajouter ou de tout effacer, mais pas de retirer une seule spécialité. Testez la suppression d'une spécialité existante, la conservation des autres et le comportement lorsqu'on demande de supprimer une spécialité absente.

4. Empêcher le chevauchement des rendez-vous d'un vétérinaire.

Visit est actuellement associée à un animal, mais pas à un vétérinaire. Ajoutez cette association et testez qu'un vétérinaire ne peut pas avoir deux visites qui se chevauchent, que des rendez-vous consécutifs sont autorisés et que deux vétérinaires différents peuvent recevoir des animaux différent au même moment.

5. Vérifier la disponibilité d'un vétérinaire avant l'affectation.

Si une visite est associée à un vétérinaire, ajoutez une règle pour empêcher de lui attribuer une visite en dehors de ses horaires de travail, puis pendant ses congés. Les tests peuvent couvrir une visite autorisée, une visite hors disponibilité et une visite qui chevauche une période d'indisponibilité.

# Architecture

1. Ajouter de la persistance à l'application.

Vous pouvez utiliser un fichier JSON pour stocker les données, ou une base de données relationnelle. L'objectif est de pouvoir sauvegarder et restaurer l'état des données. L'implémentation de la persistance doit être interchangeable pour permettre de facilement changer de solution de stockage.
En bonus : proposer une implémentation qui stocke en mémoire utilisable que pour les tests de l'application, sans que cette implémentation ne soit utilisée en production.

2. Ajouter un service de notification.
Implémentez un service de notification qui envoie un message lorsqu'une visite est créée, modifiée ou supprimée. Vous pouvez utiliser un simple logger pour simuler l'envoi de notifications