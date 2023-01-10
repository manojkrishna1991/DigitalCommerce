package com.headless.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.headless.ecommerce.mapper.CatalogAttributesMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.domain.CatalogAttributes;
import com.headless.ecommerce.dto.CatalogAttributesDto;
import com.headless.ecommerce.exception.productcatalog.CatalogNotFoundException;
import com.headless.ecommerce.repository.CatalogAttributeRepository;
import com.headless.ecommerce.repository.CatalogRepository;

@ExtendWith(MockitoExtension.class)
public class CatalogServiceTest {

	@Mock
	private CatalogRepository catalogRepository;
	@Mock
	private CatalogService catalogService;
	@Mock
	private CatalogAttributeRepository catalogAttributeRepository;

	@Mock
	private CatalogAttributesMapper catalogAttributeMapper;
	private Catalog catalog;

	@BeforeEach
	public void setUp() {
		this.catalogService = new CatalogService(catalogRepository, catalogAttributeRepository, catalogAttributeMapper);
		List<CatalogAttributes> catalogAttributes = new ArrayList<>();
		Catalog catalog = new Catalog();
		catalog.setId(12345L);
		catalog.setName("test");
		catalog.setCatalogAttributes(catalogAttributes);
		this.catalog = catalog;
	}

	@Test
	public void deleteCatalog() {
		CatalogNotFoundException exception = assertThrows(CatalogNotFoundException.class, () -> catalogService.findCatalog(12345L));
		assertEquals("catalog not found exception", exception.getMessage());

	}

	@Test
	public void testSaveCatalog() {
		when(catalogService.saveCatalog(catalog)).thenReturn(catalog);
		Catalog outputCatalog = catalogService.saveCatalog(catalog);
		assertEquals(outputCatalog.getName(), "test");
		assertEquals(outputCatalog.getId(), 12345L);
	}

	@Test
	public void testFindCatalog() {
		when(catalogRepository.findById(12345L)).thenReturn(Optional.of(catalog));
		Catalog outputCatalog = catalogService.findCatalog(12345L);
		assertEquals(outputCatalog.getId(), 12345L);
		assertEquals(outputCatalog.getName(), "test");
	}

	@Test
	public void testSaveCatalogAttributes() {
		when(catalogRepository.findById(12345L)).thenReturn(Optional.of(catalog));
		List<CatalogAttributesDto> listOfCatalogAttributes = new ArrayList<>();
		CatalogAttributesDto catalogAttributes1 = new CatalogAttributesDto();
		catalogAttributes1.setId(12345L);
		catalogAttributes1.setKey("desc");
		catalogAttributes1.setValue("root catalog");
		listOfCatalogAttributes.add(catalogAttributes1);
		List<CatalogAttributes> catalogAttributes = new ArrayList<>();
		CatalogAttributes catalogAttributes2 = new CatalogAttributes();
		catalogAttributes2.setId(12345L);
		catalogAttributes2.setKey("desc");
		catalogAttributes2.setValue("root catalog");
		catalogAttributes.add(catalogAttributes2);
		when(catalogAttributeRepository.findByCatalog(any())).thenReturn(catalogAttributes);
		when(catalogAttributeMapper.catalogAttributesToCatalogAttributesDto(catalogAttributes2)).thenReturn(catalogAttributes1);
		List<CatalogAttributesDto> catalogAttributesDtos = catalogService.saveCatalogAttributes(listOfCatalogAttributes,
				12345L);
		assertEquals(catalogAttributesDtos.get(0).getId(), 12345L);
		assertEquals(catalogAttributesDtos.get(0).getKey(), "desc");
		assertEquals(catalogAttributesDtos.get(0).getValue(), "root catalog");
	}
}
