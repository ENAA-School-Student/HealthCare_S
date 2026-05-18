
HealthCare+ API REST

HealthCare+ est une application backend développée dans le cadre de la transformation numérique d’un système médical.
Le projet a pour objectif de concevoir une API REST complète permettant de gérer efficacement les patients, les médecins, les rendez-vous ainsi que les dossiers médicaux.

L’application offre une architecture claire et professionnelle basée sur les technologies modernes de l’écosystème Spring Boot afin de garantir la maintenabilité, la performance et la sécurité des données médicales.

Grâce à cette solution, les établissements de santé peuvent :

organiser le suivi des patients ;
gérer les informations des médecins ;
planifier et suivre les rendez-vous ;
centraliser les dossiers médicaux et les diagnostics.

Le projet suit une architecture MVC et utilise les bonnes pratiques du développement backend moderne telles que :

Spring Data JPA & Hibernate ;
DTO et MapStruct ;
requêtes SQL/JPQL ;
documentation Swagger ;
tests unitaires avec JUnit ;
conteneurisation avec Docker.

Cette API REST constitue une solution réaliste et évolutive adaptée aux besoins d’un système de gestion médicale moderne.
diagramme de classe
<img width="5838" height="7128" alt="UseCaseDiagram1" src="https://github.com/user-attachments/assets/5f37f5cd-13ae-4de1-b788-58f2d2475e63" />
diagramme de cas d'utilisation
<img width="5928" height="4200" alt="diagramme_de_sequence1" src="https://github.com/user-attachments/assets/848a108b-5968-47f2-9a48-58216d479b85" />
Diagramme de séquence
<img width="5928" height="4200" alt="Créer rendez-vous_diagrammedesequence" src="https://github.com/user-attachments/assets/e83f7ca2-3f73-4bec-8708-869d93400b49" />
Partie 2 : Sécurisation et Authentification de l’API

Cette deuxième partie du projet consiste à sécuriser l’API REST de gestion médicale en mettant en place un système complet d’authentification avec JWT (JSON Web Token) grâce à Spring Security.
L’objectif principal est de protéger les endpoints sensibles de l’application afin que seuls les utilisateurs authentifiés puissent accéder aux ressources médicales telles que les patients, médecins, rendez-vous et dossiers médicaux.

Les fonctionnalités implémentées incluent :

Inscription et connexion des utilisateurs
Génération et validation des tokens JWT
Gestion de l’expiration des tokens
Sécurisation des endpoints REST
Cryptage des mots de passe avec BCrypt
Mise en place d’un filtre JWT personnalisé
Gestion globale des exceptions et validation des données

Cette partie repose sur plusieurs concepts essentiels de Spring Security :

AuthenticationManager
SecurityFilterChain
UserDetailsService
PasswordEncoder
BCryptPasswordEncoder
JWT Filter

L’architecture de sécurité adoptée permet de garantir une authentification stateless et une meilleure protection des données échangées via l’API REST
