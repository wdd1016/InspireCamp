package com.camp.catalogservice.service;

import com.camp.catalogservice.jpa.CatalogEntity;
import com.camp.catalogservice.jpa.CatalogRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {
    CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public CatalogEntity getCatalogByProductId(String productId) {
        return catalogRepository.findByProductId(productId);
    }
}
