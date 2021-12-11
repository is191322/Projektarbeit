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
class TestTimeline {

	@Mock
	PupdateRepository pupdateRepository;

	@Mock
	FollowerService followerService;

	
	@InjectMocks
	PupdateService pupdateService;

	@Test
	public void testTimeline() {

		// Mocking Pupdate Repository:
		List<PupdateEntity> pupdates = new ArrayList<PupdateEntity>();
		pupdates.add(new PupdateEntity(0, 0, 0, 1, new Date(), 5,
				"Junu, mein Hund frisst die Nachbarskatze", "is191325.jpg", 800, 600));

		pupdates.add(new PupdateEntity(0, 0, 0, 3, new Date(), 5, "Mein Hund hat Flöhe", "Fiffy.jpg", 800, 600));
		pupdates.add(new PupdateEntity(0, 1, 1, 2, new Date(), 5, "Junu, mein Hund frisst die Nachbarskatze",
				"is191325.jpg", 800, 600));
		pupdates.add(new PupdateEntity(0, 0, 0, 1, new Date(), 5, "Die Nachbarskatze hat meinen Hund gefressen!",
				"is191325.jpg", 800, 600));
		pupdates.add(new PupdateEntity(0, 0, 0, 3, new Date(), 5, "Waschen hilft nicht, er hat immer noch Flöhe",
				"cool.jpg", 800, 600));

		Mockito.when(pupdateRepository.findAll()).thenReturn(pupdates);

		// Mocking Follower Service:

		List<FollowerEntity> followers = new ArrayList<FollowerEntity>();

		followers.add(new FollowerEntity(0, 1, 3, new Date()));
		

		Mockito.when(followerService.getFollowers(1)).thenReturn(followers);

		List<PupdateEntity> timeline = new ArrayList<>();
		// getPupdatesBySniffer
		timeline.addAll(pupdateRepository.findPupdatesbySniffer(1));
		// PupdateService test = new PupdateService(pupdateRepository);

		List<PupdateEntity> FoundPupdates = pupdateService.fetchTimeline(1);

		assertThat(timeline, hasSize(3));

	}

}
