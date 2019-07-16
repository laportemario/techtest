# Application de calcul de densité de la population

L'objectif de cette application est de calculer la densité de population. 

À partir d'un fichier d'entrée (fichier au format TSV contenant des points d'intérêts (POIs) caractérisés par: id, lat, lon), le programme peut calculer le nombre de POIs d'une zone et trouver les N zones les plus denses (ie. les zones contenant le plus de POIs).



## Installation

Placez vous à la racine du projet et utilisez le script [mvnw](https://www.baeldung.com/maven-wrapper) pour installer le projet.

```bash
./mvnw install
```

## Lancement

Pour executer le programme, placez-vous dans le répertoire **target** qui vient d'être généré et utilisez l'une des commandes suivantes :

```bash
java [-options] -jar techtest-0.0.1.jar [args...]
```
#### Exemple
```bash
java -jar techtest-0.0.1.jar --nbpoi='{"minlat": 6.5, "minlon": -7}'
                               ou
java -jar techtest-0.0.1.jar --densest='{"n": 2}'
```
