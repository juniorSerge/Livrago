# Livrago

Livrago est une application mobile de livraison de colis et de marchandises, développée pour simplifier et sécuriser le transport de biens pour les particuliers et les entreprises. L'application permet aux utilisateurs de rechercher des livreurs disponibles, de choisir celui qui leur convient, de suivre la livraison en temps réel, et de payer en ligne ou en espèces.

## Fonctionnalités Principales

- **Inscription et Connexion** : Inscription via email et numéro de téléphone, validation par email ou SMS, et récupération de mot de passe.
- **Profil Utilisateur** : Affichage et modification des informations du profil, historique des livraisons, et gestion des moyens de paiement.
- **Recherche et Sélection de Livreurs** : Recherche des livreurs disponibles, affichage des évaluations, des prix et des temps estimés d'arrivée.
- **Calcul du Prix de Livraison** : Calcul automatique du prix en fonction de la distance et du poids du colis, avec affichage avant confirmation.
- **Suivi de Livraison** : Suivi en temps réel du livreur sur une carte, notifications push pour les mises à jour de statut.
- **Paiement** : Options de paiement par carte bancaire, mobile money ou en espèces, avec traitement sécurisé des paiements.
- **Évaluations et Avis** : Les utilisateurs peuvent évaluer et laisser des avis sur les livreurs après chaque livraison.

## Technologies Utilisées

- **Frontend** : Développement sous Android Studio avec Jetpack Compose (Kotlin)
- **Backend** : API REST développée avec Ktor
- **Base de Données** : Firestore pour la gestion des données en temps réel
- **Géolocalisation** : Google Maps API pour le suivi en temps réel et le calcul des distances
- **Notifications** : Firebase Cloud Messaging pour les notifications push
- **Authentification** : Firebase Authentication pour la gestion des utilisateurs

## Installation

### Prérequis

- [Android Studio](https://developer.android.com/studio)
- Compte Firebase avec un projet configuré

### Étapes

1. **Clonez le dépôt**

   ```bash
   git clone https://github.com/orlandngandeu/Livrago.git
   cd Livrago
