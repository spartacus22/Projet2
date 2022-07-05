package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class FavoriteNeighbourEvent {

    /**
     * Neighbour to view in details
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public FavoriteNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

}
