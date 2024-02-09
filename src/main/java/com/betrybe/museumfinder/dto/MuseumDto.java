package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Dto usado para converter da model, camada de persistência,
 * para a camada de apresenta~ao/controller.
 *
 * @param id Long
 * @param name String
 * @param description String
 * @param address String
 * @param collectionType String
 * @param subject String
 * @param url String
 * @param coordinate Coordinate
 */
public record MuseumDto(
    Long id,
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {}