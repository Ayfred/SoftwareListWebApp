package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Application;
import model.Software;

class ApplicationTest {
	Application application1;
	Application application2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		application1 = Application.getInstance();
		application2 = Application.getInstance();
		application1.clear();
		application2.clear();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testSingleton() {
		assertNotNull(application1);
	}
	
	@Test
	void testSameApplication() {
		assertEquals(application1, application2);
	}
	
	@Test
	void testListSoftwareNotNull() {
		assertNotNull(application1.getListSoftware());
	}
	
	@Test
	void testFindSoftware() {
		application1.addSoftware("Soft", "1.0", "API limited");
		assertEquals(application1.getSoftware("Soft").getName(), "Soft");
	}
	
	@Test
	void testSameSize() {
		System.out.println("same size");

		application1.addSoftware("Soft", "1.0", "API limited");
		application1.addSoftware("Soft", "1.0", "API limited");

		assertEquals(application1.getListSoftware().size(), 1);
	}
	
	@Test
	void testLastSoftware() {
		application1.addSoftware("Soft", "1.0", "API limited");
		application1.addSoftware("Ware", "1.0", "Free to use");
		assertEquals(new Software("Ware", "1.0", "Free to use"), application1.getListSoftware().get(1));
	}
	
	@Test
	void testDeleteSoftware() {
		application1.addSoftware("Soft", "1.0", "API limited");
		application1.deleteSoftware("Soft");
		assertFalse(application1.getListSoftware().contains(new Software("Soft", "1.0", "API limited")));
	}

	@Test
	void testGetSoftware() {
		application1.addSoftware("Soft", "1.0", "API limited");
		assertEquals(application1.getSoftware("Soft"), new Software("Soft", "1.0", "API limited"));	}

	@Test
	void testUpdateSoftware() {
		application1.addSoftware("Soft", "1.0", "API limited");
		application1.updateSoftware("Soft", "1.1", "Free to use");
		assertEquals(application1.getSoftware("Soft"), new Software("Soft", "1.1", "Free to use"));	}

	

}
