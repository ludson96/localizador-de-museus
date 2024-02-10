package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Classe do tipo record usado como dto de request da pessoa usuária.
 *
 * @param name String
 * @param description String
 * @param address String
 * @param collectionType String
 * @param subject String
 * @param url String
 * @param coordinate String
 */
public record MuseumCreationDto(
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {}