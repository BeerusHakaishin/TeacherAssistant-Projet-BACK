<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
<!--   <a href="https://github.com/WildCodeSchool/P3-clutchrayn-back-javangular-2021">
    <img src="src/main/resources/static/assets/img/logo.png" alt="Logo" width="80" height="80"> -->
  </a>

<h3 align="center">My Teacher Assistant</h3>

  <p align="center">
    My Teacher Assistant for progress
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table du guide (cliquez)</summary>
  <ol>
    <li>
      <a href="#a-propos-du-projet">A propos du projet</a>
      <ul>
        <li><a href="#crée-avec">Crée avec</a></li>
      </ul>
    </li>
    <li>
      <a href="#bien-débuter">Bien débuter</a>
      <ul>
        <li><a href="#prerequis">Prerequis</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a>
    <ul>
        <li><a href="#rôles">Rôles & Privilèges</a></li>
    </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## A propos du projet

Ce projet a été réalisé parce que j'en ai envie . 
<br>
L'objectif est de continuer à faire ce dont j'ai envie.
 
<p align="right">(<a href="#top">back to top</a>)</p>



### Crée avec 

* [Spring](https://spring.io/)
* [Maven](https://maven.apache.org/)
* [Hibernate](https://hibernate.org/)


<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Bien débuter

Pour mettre en place une copie locale et la faire fonctionner, suivez les étapes simples ci-dessous.

### Prerequis

Vous devrez au préalable vous assurer d'avoir un IDE ([Eclipse](https://www.eclipse.org/ide/) conseillé) ainsi qu'un logiciel de gestion et d'administration de bases de données relationnels ([PG Admin](https://www.pgadmin.org/download/) conseillé) sur votre machine.


### Installation

Ouvrez un terminal à l'endroit où vous désirez installer le projet puis suivez les commandes suivantes.

1. Cloner le projet
   ```sh
   git clone git@github.com:WildCodeSchool/P3-clutchrayn-back-javangular-2021.git
   ```
2. Dans le projet, Entrer les clés nécessaires dans `application.properties` <br> *(utilisez le user ___postgres___ sur PGAdmin ou créez en un)*
   ```js
    spring.datasource.url=jdbc:postgresql://localhost:5432/[ENTRER LE NOM DE VOTRE BDD]?serverTimezone=GMT
    spring.datasource.username=[ENTRER VOTRE NOM UTILISATEUR]
    spring.datasource.password=[ENTRER VOTRE MOT DE PASSE]
   ```
3. Lancer le projet 
   ```sh
   Dans la liste de l'aperçu du projet:
   
   - Choisissez le dossier du projet de l'application (P3-clutchrayn-back-javangular-2021).
   - Faites un clic droit dessus pour ouvrir le menu contextuel.
   - Choisissez "Run as -> Spring Boot App".
   ```

<p align="right">(<a href="#top">back to top</a>)</p>

### Rôles 
* Admin
    * Peut réaliser les opérations _créer/modifier/supprimer_ sur les contenus administrable du site 
    * Peut __créer__ des __Admins__ ainsi que des __Moderateur__ , __User__
* Modérateur
    * Ne sers qu'à moderer les commentaires , il as le droit de les supprimer , c'est le seul à pouvoir le faire avec l'admin
* User
    * Est là pour créer des tutos , les soumettres à la validation des admins et rester bien sage en attendant !
<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Le dev :
- [@Ismael Meziani](https://github.com/BeerusHakaishin) -


<p align="right">(<a href="#top">back to top</a>)</p>
