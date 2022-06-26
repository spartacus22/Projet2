package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private static List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

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
        List<Neighbour> neighboursFavorite = neighbours;
        for (int i = 0; i < neighboursFavorite.size();i++) {
            if (!neighboursFavorite.get(i).getFavori()) {
                neighboursFavorite.remove(i);
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
