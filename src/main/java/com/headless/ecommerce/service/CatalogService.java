package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.domain.CatalogAttributes;
import com.headless.ecommerce.dto.CatalogAttributesDto;
import com.headless.ecommerce.exception.productcatalog.CatalogNotFoundException;
import com.headless.ecommerce.mapper.CatalogAttributesMapper;
import com.headless.ecommerce.repository.CatalogAttributeRepository;
import com.headless.ecommerce.repository.CatalogRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogService {
	private final CatalogRepository catalogRepository;
	private final CatalogAttributeRepository catalogAttributeRepository;
	private final CatalogAttributesMapper catalogAttributesMapper;

	public CatalogService(CatalogRepository catalogRepository, CatalogAttributeRepository catalogAttributeRepository,
			CatalogAttributesMapper catalogAttributesMapper) {
		this.catalogRepository = catalogRepository;
		this.catalogAttributeRepository = catalogAttributeRepository;
		this.catalogAttributesMapper = catalogAttributesMapper;
	}

	@Transactional
	public Catalog saveCatalog(Catalog catalog) {
		return catalogRepository.save(catalog);
	}

	public void deleteCatalog(Long catalogId) {
		catalogRepository.deleteById(catalogId);
	}

	public void deleteCatalogAll() {
		catalogRepository.deleteAll();
	}

	public Catalog findCatalog(@NonNull Long id) {
		final Optional<Catalog> catalog = catalogRepository.findById(id);
		if (!catalog.isPresent()) {
			throw new CatalogNotFoundException();
		}
		return catalog.get();
	}

	public List<CatalogAttributesDto> saveCatalogAttributes(List<CatalogAttributesDto> sourceCatalogAttributes,
			@NonNull Long catalogID) {
		Catalog catalog = findCatalog(catalogID);
		sourceCatalogAttributes.forEach(attributes -> {
			CatalogAttributes catalogAttributes = new CatalogAttributes();
			catalogAttributes.setId(attributes.getId());
			catalogAttributes.setKey(attributes.getKey());
			catalogAttributes.setValue(attributes.getValue());
			catalogAttributes.setCatalog(catalog);
			catalogAttributeRepository.save(catalogAttributes);
		});
		return catalogAttributeRepository.findByCatalog(catalog).stream().map(catalogAttributesMapper::catalogAttributesToCatalogAttributesDto).collect(Collectors.toList());
	}

	public List<CatalogAttributesDto> getCatalogAttributes(@NonNull Long catalogID) {
		Catalog catalog = findCatalog(catalogID);
		return catalogAttributeRepository.findByCatalog(catalog).stream().map(
						catalogAttributesMapper::catalogAttributesToCatalogAttributesDto)
				.collect(Collectors.toList());
	}
}
