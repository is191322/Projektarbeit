package at.ac.fhstp.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DemoApplicationTests {

	@Mock
	PupdateEntity pupdate;
	@Mock
	PupdateRepository pupdateRepository;

	@InjectMocks
	PupdateService pupdateService;

	@Test
	void contextLoads() {
	}

	@Test
	public void TestFetchPupdates(){
		assertNotNull(pupdate);
		List<PupdateEntity> pupdates =pupdateRepository.findPupdatesbySniffer(1);
		assertNotNull(pupdates);
	}
	@Test	
	public void testSaveSniffers() {
		assertNotNull(pupdate);

		List<PupdateEntity> pupdates = pupdateRepository.findPupdatesbySniffer(1);
		assertNotNull(pupdates);

	}

	@Test
	public void testPostPupdate() {
		/*
		 * Mockito.when(pupdate.getOriginUserID()).thenReturn(0);
		 * Mockito.when(pupdate.getOriginUserID()).thenReturn(5);
		 * 
		 * pupdateService.savePupdate(pupdate);
		 * 
		 * List<PupdateEntity> pupdates = pupdateRepository.findPupdatesbySniffer(1);
		 * assertNotNull(pupdates);
		 */
	}

	// Testfälle:

	// 1 Erstelle einen Post

	// 2 Prüfe ob Repository den Post mit jeweiligen Paramentern enthält

	@Test
	public void testPupdateFetchPupdates() {

		// Mocking:
		List<PupdateEntity> pupdates = new ArrayList<PupdateEntity>();
		PupdateEntity p1 = new PupdateEntity(0, 0, 0, 1, new Date(), 5,
				"Junu, mein Hund frisst die Nachbarskatze", "is191325.jpg", 800, 600);
		pupdates.add(p1);

		Mockito.when(pupdateRepository.findAll()).thenReturn(pupdates);

		// PupdateService test = new PupdateService(pupdateRepository);

		List<PupdateEntity> FoundPupdates = pupdateService.fetchPupdates();

		// assertNotNull(FoundPupdates);

		assertThat(FoundPupdates, hasSize(1));
		assertThat(FoundPupdates, hasItems(p1));

	}

}
 