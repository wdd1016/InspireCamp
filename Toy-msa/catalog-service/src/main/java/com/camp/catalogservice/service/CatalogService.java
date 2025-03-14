package com.camp.catalogservice.service;

import com.camp.catalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();

    CatalogEntity getCatalogByProductId(String productId);
}
