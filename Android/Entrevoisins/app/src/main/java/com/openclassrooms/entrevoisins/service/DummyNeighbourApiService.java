package com.openclassrooms.entrevoisins.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighboursFavorite() {
        List<Neighbour> neighboursFavorite = new ArrayList<Neighbour>();
        for (Neighbour n : neighbours){
            if (n.getFavori()) {
                neighboursFavorite.add(n);
            }
        }
        return neighboursFavorite;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void setFavoriteNeighbour (Neighbour neighbour, Boolean flag){
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).getId()==neighbour.getId()) {
                neighbours.get(i).setFavori(flag);
            }
        }
    }
}
