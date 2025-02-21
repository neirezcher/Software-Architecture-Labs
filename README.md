# Software-Architecture-Labs

## OCP: Open/Close Principle
Dans le code initial de la classe ResourceAllocator, l'allocation et la libération des ressources étaient gérées à l'aide d'une instruction switch basée sur l'énumération ResourceType.
Cette approche viole le principe de l'Ouverture/Fermeture car l'ajout d'un nouveau type de ressource nécessite de modifier toutes les méthodes de la classe ResourceAllocator, ainsi que l'ajout d'une autre enumeration dans ResourceType.

=> Pour implémenter le principe Open/Close, on a refactorisé le code en ajoutant une interface IResourceType qui définit les méthodes pour l'allocation et la libération des ressources. 
Chaque type de ressource implémente cette interface. 
La classe ResourceAllocator fonctionne maintenant avec l'interface IResourceType, ce qui la rend "Open" à l'extension mais "Closed" à la modification.

## LSP: Liskov Substitution Principle

Dans le code initial, la classe ElectronicDuck étend la classe Duck mais lance des exceptions lorsque le canard est éteint, ce qui viole le principe de Substitution de Liskov. 
La classe ElectronicDuck ne peut pas être utilisée de manière interchangeable avec la classe Duck sans provoquer de comportement inattendu.

=> Pour implémenter le principe LSP, on a introduit une interface IDuck qui définit les méthodes quack() et swim(). 
Les classes RealDuck et ElectronicDuck implémentent cette interface. La classe ElectronicDuck fournit maintenant un comportement par défaut lorsqu'elle est éteinte, garantissant qu'elle peut être utilisée de manière interchangeable avec RealDuck.
