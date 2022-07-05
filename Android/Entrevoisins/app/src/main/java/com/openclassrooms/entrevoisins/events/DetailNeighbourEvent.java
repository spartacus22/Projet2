package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class DetailNeighbourEvent {

    /**
     * Neighbour to view in details
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public DetailNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

}
