package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MuseumService implements MuseumServiceInterface {

  private MuseumFakeDatabase museumFakeDatabase;

  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    Boolean isValid = CoordinateUtil.isCoordinateValid(coordinate);

    if (!isValid) {
      throw new InvalidCoordinateException();
    }

    Optional<Museum> museum = museumFakeDatabase.getClosestMuseum(coordinate, maxDistance);

    if (museum.isEmpty()) {
      throw new MuseumNotFoundException();
    }

    return museum.get();
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Boolean isValid = CoordinateUtil.isCoordinateValid(museum.getCoordinate());

    if (!isValid) {
      throw new InvalidCoordinateException();
    }

    return museumFakeDatabase.saveMuseum(museum);
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
