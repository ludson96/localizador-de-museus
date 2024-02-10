package com.betrybe.museumfinder.solution.Utils;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;

public class TestHelpers {

  public static Museum createMockMuseum(Long id) {
    Museum museum = new Museum();
    museum.setId(id);
    museum.setName("museum name");
    museum.setCoordinate(new Coordinate(12.345, -54.321));

    return museum;
  }

}
