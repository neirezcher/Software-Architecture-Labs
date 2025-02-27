# Contexte Initial : Avant ISP

Dans l’implémentation actuelle, les classes **SensingDoor** et **TimedDoor** doivent implémenter toutes les méthodes de l’interface **Door**, même celles dont elles n’ont pas besoin :

- **SensingDoor** doit implémenter la méthode `timeOutCallback()`, qui ne lui est d’aucune utilité.
- **TimedDoor** doit implémenter la méthode `proximityCallback()`, qui n’a aucun sens pour elle non plus.

Cela entraîne une violation du principe de **Ségrégation des Interfaces** (ISP), qui stipule que "les clients ne doivent pas être contraints de dépendre d’interfaces qu’ils n’utilisent pas".
<br><br>
![Avant ISP](exercise\avant_ISP.png)

---

# Après l’application de l’ISP

Après l'application du principe de **Ségrégation des Interfaces** (ISP), le code est désormais mieux structuré et respecte ce principe fondamental :

- **L'interface Door** contient uniquement les méthodes essentielles nécessaires à toutes les portes (lock, unlock, open, close).
- Deux nouvelles interfaces spécifiques ont été créées :
    - **ISensingDoor**, qui ajoute la méthode `proximityCallback()`.
    - **ITimedDoor**, qui ajoute la méthode `timeOutCallback()`.

### Changements apportés :

- **SensingDoor** implémente désormais uniquement l'interface **ISensingDoor** et ne dépend plus de la méthode `timeOutCallback()`, qui n'était pas pertinente pour cette classe.
- **TimedDoor** implémente uniquement l'interface **ITimedDoor** et ne dépend plus de la méthode `proximityCallback()`, qui ne lui était pas utile.
  <br><br>
  ![Apres ISP](ProposedSolution\apres_ISP.png)

---

# Bénéfice :

Maintenant, chaque classe dépend uniquement des méthodes qu'elle utilise réellement, ce qui permet de respecter le principe **ISP** 
