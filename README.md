


1. Description fonctionnel :

Le nouvel écran apparait lorsque l'utilisateur clique sur un élement (voisin) de l'écran principal.
L'écran détaillé qui apparaît reprends alors les principales caractéristiques du voisin sélectionné (nom, adresse, téléphone...). Il permet également d'ajouter le voison à une liste de favori en cliquant sur un bouton dédié (graphique en forme d'étoile).

2. Description technique : 

L'ajout de cette fonctionnalité a nécessité : 

- La création d'une nouvelle activité (DetailNeighbourActivity) et de son layout (activity_detail_neighbour),
- L'ajout d'un event listener (click) sur les élèments de la vue groupée (RecyclerView) de l'écran principal qui déclenche l'émission d'un event sur le bus évènementiel (event bus),
- L'ajout de la méthode onDetailNeighbour() dans la classe NeighbouFragment pour traiter l'évènement précédent et déclencher l'ouverture de l'écran détaillé à l'aide d'un intent()


3. Tests instrumentalisés : 

- myNeighboursList_shouldNotBeEmpty() : Vérifie l'affichage de la liste des voisins dans l'onglet « My Neighbour » de l'écran principal

- openNeighbourDetailWithRightName() : Vérifie qu'en cliquant sur l'élement n°1 ("Jack") de l'écran principal sa fiche détaillée s'ouvre correctement.

- myNeighboursList_deleteAction_shouldRemoveItem() : Supprime l'élément n°2 de l'écran principal puis vérifie que le nombre d'objets de la liste des voisins a bien diminué d'une unité.

- myNeighboursFavoriteList_onlyFavorites() : ajoute un favori à partir du nouvel écran puis vérifie qu'il est présent dans l'onglet "My favorite" de l'écran principal.

4. Tests unitaires : 

- getNeighboursWithSuccess(): vérifie le fonctionnement de la méthode getNeighbours()  de l'API qui récupère la liste de tous les voisins existants,
- deleteNeighbourWithSuccess() : teste la methode deleteNeighbour() en vérfiant l'absence d'un voisin dans la liste des voisins existants après l'avoir supprimé
- addNeighbourWithSuccess() : teste la méthode createNeighbour() en vérifiant la présence d'un voisin dans la liste après l'avoir créé.
- addFavoriteWithSuccess() : modifie l'attribut isFavori d'un voisin et vérifie sa présence dans la liste des favoris

5. Complication / Execution

La compilation du projet 'Entrevoisins' sous Android Studio s'effectue en allant dans le menu Build/Make Project après avoir ouvert le projet.

Pour lancer/exécuter l'application sur un émulateur, il faut :
	-  créer un équipement virtuel à l'aide du Virtual Device Manager. Cette fenêtre est accessible par le menu Tools/Device Manager. Un équipement virtuel correspond à l'association d'un type d'équipement (la partie matérielle) avec une version d'Android (la partie logicielle). Dans le cas le projet a été construit un Pixel 4a API30 sous Android 11.0.
	- sélectionner l'équipement virtuel créé dans la barre de l'IDE
	- cliquer sur l’icone vert en forme de play dans la barre de l'IDE (ou menu run/run 'app')
