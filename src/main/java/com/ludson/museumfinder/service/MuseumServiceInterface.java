package com.ludson.museumfinder.service;

import com.ludson.museumfinder.model.Coordinate;
import com.ludson.museumfinder.model.Museum;

/**
 * Interface for Museum service class.
 */
public interface MuseumServiceInterface {

  Museum getClosestMuseum(Coordinate coordinate, Double maxDistance);

  Museum createMuseum(Museum museum);

  Museum getMuseum(Long id);
}
