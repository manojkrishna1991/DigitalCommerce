package com.headless.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.domain.CatalogAttributes;
import com.headless.ecommerce.exception.productcatalog.CatalogNotFoundException;
import com.headless.ecommerce.repository.CatalogRepository;

@ExtendWith(MockitoExtension.class)
public class CatalogServiceTest {

	@Mock
	private CatalogRepository catalogRepository;
	@Mock
	private CatalogService catalogService;

	@Test
	public void deleteCatalog() {
		catalogService.deleteCatalog(12345L);
		when(catalogService.findCatalog(12345L)).thenThrow(new CatalogNotFoundException());
		CatalogNotFoundException exception = assertThrows(CatalogNotFoundException.class, () -> {
			catalogService.findCatalog(12345L);
		});
	    assertEquals("catalog not found exception", exception.getMessage());

	}

	@Test
	public void testSaveCatalog() {
		List<CatalogAttributes> catalogAttributes = new ArrayList<>();
		Catalog catalog = new Catalog();
		catalog.setId(12345L);
		catalog.setName("test");
		catalog.setCatalogAttributes(catalogAttributes);
		when(catalogService.saveCatalog(catalog)).thenReturn(catalog);
		Catalog outputCatalog = catalogService.saveCatalog(catalog);

		assertEquals(outputCatalog.getName(), "test");
		assertEquals(outputCatalog.getId(), 12345L);
	}
}
