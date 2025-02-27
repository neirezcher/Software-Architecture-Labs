# Software-Architecture-Labs
## DIP : Dependecy Inversion Principle
### 📌 Analyse du code initial
Le code initial viole le principe de l'Inversion des Dépendances (DIP) du SOLID, car :

* **EncodingModule** dépend directement des classes concrètes (**MyDatabase, FileReader, FileWriter, BufferedReader, BufferedWriter, URL**).
* **EncodingModule** crée lui-même ses dépendances, ce qui le couple fortement à des implémentations spécifiques.
* Cette approche rend difficile la modification et l’extension du code sans impacter d’autres parties du programme.  

🔴 Problème principal : Le code dépend des détails (implémentations concrètes) au lieu de dépendre d’abstractions.

<br><br>
![Avant DIP](SOLID\DIP\src\com\directi\training\dip\exercise\Diagramme_de_classe.png)

### ✅ Solution proposée
#### Séparation des responsabilités avec des interfaces
Deux interfaces ont été créées pour représenter les opérations de lecture et d’écriture :
* IReader : définit une abstraction pour la lecture de données.  
* IWriter : définit une abstraction pour l’écriture de données.  
Grâce à ces interfaces, **EncodingModule** ne connaît plus les détails des implémentations, ce qui réduit le couplage et facilite l’extension du code.
#### Implémentations concrètes des interfaces
Différentes classes implémentent ces interfaces, permettant plusieurs sources de lecture **(FileReaderModule, NetworkReaderModule)** et de stockage des données **(FileWriterModule, MyDatabase)**.
#### Intégration avec EncodingModule
EncodingModule est conçu pour recevoir dynamiquement un IReader et un IWriter via son constructeur.
Ainsi, il n’a plus besoin de connaître les classes concrètes : il peut travailler avec n’importe quelle implémentation des interfaces.
#### Injection des dépendances
Dans le programme principal **(EncodingModuleClient)**, les dépendances sont injectées dynamiquement.
Par exemple :
* On peut lire un fichier et stocker les données encodées dans un autre fichier.  
* On peut récupérer des données depuis un réseau et les enregistrer dans une base de données.  
* Les combinaisons sont infinies, et aucune modification de EncodingModule n’est requise pour en ajouter de nouvelles.  

<br><br>
![Après DIP](SOLID\DIP\src\com\directi\training\dip\ProposedSolution\Dip_Class_Diagram.png)

### 📌 Conclusion
L’application du DIP dans cette solution garantit :  
✔ Un code modulaire et facilement extensible.  
✔ Une indépendance totale entre EncodingModule et les classes concrètes.  
✔ Une meilleure testabilité, car les dépendances peuvent être remplacées par des mocks.  
✔ Un code plus propre et maintenable, conforme aux principes SOLID.


## ISP : Interface Segregation Principle 
### Contexte Initial : Avant ISP

Dans l’implémentation actuelle, les classes **SensingDoor** et **TimedDoor** doivent implémenter toutes les méthodes de l’interface **Door**, même celles dont elles n’ont pas besoin :

- **SensingDoor** doit implémenter la méthode `timeOutCallback()`, qui ne lui est d’aucune utilité.
- **TimedDoor** doit implémenter la méthode `proximityCallback()`, qui n’a aucun sens pour elle non plus.

Cela entraîne une violation du principe de **Ségrégation des Interfaces** (ISP), qui stipule que "les clients ne doivent pas être contraints de dépendre d’interfaces qu’ils n’utilisent pas".
<br><br>
![Avant ISP](SOLID\ISP\src\com\directi\training\isp\exercise\avant_ISP.png)

---

### Après l’application de l’ISP

Après l'application du principe de **Ségrégation des Interfaces** (ISP), le code est désormais mieux structuré et respecte ce principe fondamental :

- **L'interface Door** contient uniquement les méthodes essentielles nécessaires à toutes les portes (lock, unlock, open, close).
- Deux nouvelles interfaces spécifiques ont été créées :
    - **ISensingDoor**, qui ajoute la méthode `proximityCallback()`.
    - **ITimedDoor**, qui ajoute la méthode `timeOutCallback()`.

### Changements apportés :

- **SensingDoor** implémente désormais uniquement l'interface **ISensingDoor** et ne dépend plus de la méthode `timeOutCallback()`, qui n'était pas pertinente pour cette classe.
- **TimedDoor** implémente uniquement l'interface **ITimedDoor** et ne dépend plus de la méthode `proximityCallback()`, qui ne lui était pas utile.

  <br><br>
![Après ISP](SOLID\ISP\src\com\directi\training\isp\ProposedSolution\apres_ISP.png)

---

### Bénéfice :

Maintenant, chaque classe dépend uniquement des méthodes qu'elle utilise réellement, ce qui permet de respecter le principe **ISP** 


## LSP: Liskov Substitution Principle

Dans le code initial, la classe ElectronicDuck étend la classe Duck mais lance des exceptions lorsque le canard est éteint, ce qui viole le principe de Substitution de Liskov. 
La classe ElectronicDuck ne peut pas être utilisée de manière interchangeable avec la classe Duck sans provoquer de comportement inattendu.

<br><br>
<br><br>
![Avant LSP](SOLID\LSP\src\com\directi\training\lsp\exercise\UML_class.png)

=> Pour implémenter le principe LSP, on a introduit une interface IDuck qui définit les méthodes quack() et swim(). 
Les classes RealDuck et ElectronicDuck implémentent cette interface. La classe ElectronicDuck fournit maintenant un comportement par défaut lorsqu'elle est éteinte, garantissant qu'elle peut être utilisée de manière interchangeable avec RealDuck.

<br><br>
![Après LSP](SOLID\LSP\src\com\directi\training\lsp\proposed_solution\UML_class.png)

## OCP: Open/Close Principle
Dans le code initial de la classe ResourceAllocator, l'allocation et la libération des ressources étaient gérées à l'aide d'une instruction switch basée sur l'énumération ResourceType.
Cette approche viole le principe de l'Ouverture/Fermeture car l'ajout d'un nouveau type de ressource nécessite de modifier toutes les méthodes de la classe ResourceAllocator, ainsi que l'ajout d'une autre enumeration dans ResourceType.

![Avant OCP](SOLID\OCP\src\com\directi\training\ocp\exercise\UML_class.png)

=> Pour implémenter le principe Open/Close, on a refactorisé le code en ajoutant une interface IResourceType qui définit les méthodes pour l'allocation et la libération des ressources. 
Chaque type de ressource implémente cette interface. 
La classe ResourceAllocator fonctionne maintenant avec l'interface IResourceType, ce qui la rend "Open" à l'extension mais "Closed" à la modification.

![Après OCP](SOLID\OCP\src\com\directi\training\ocp\solution_exercice\UML_class.png)

## SRP: 

![Avant SRP](out\SOLID\SRP\src\com\directi\training\srp\exercise\InitialSolution\Initial_Solution.png)

![Après SRP](out\SOLID\SRP\src\com\directi\training\srp\proposed_solution\Proposed_Solution\Proposed_Solution.png)