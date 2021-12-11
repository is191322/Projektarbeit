package at.ac.fhstp.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TestTimeline {

	@Mock
	PupdateRepository pupdateRepository;

	@Mock
	SnifferRepository snifferRepository;

	@Mock
	FollowerService followerService;

	@InjectMocks
	PupdateService pupdateService;

	@Test
	public void testTimeline() {

		// Mocking Pupdate Repository:
		List<PupdateEntity> pupdatesToSniffer1 = new ArrayList<PupdateEntity>();

		pupdatesToSniffer1.add(new PupdateEntity(0, 0, 0, 1, new Date(), 5,
				"Junu, mein Hund frisst die Nachbarskatze", "is191325.jpg", 800, 600));

		pupdatesToSniffer1
				.add(new PupdateEntity(0, 0, 0, 1, new Date(), 5, "Die Nachbarskatze hat meinen Hund gefressen!",
						"is191325.jpg", 800, 600));

		List<PupdateEntity> pupdatesToSniffer3 = new ArrayList<PupdateEntity>();
		pupdatesToSniffer3
				.add(new PupdateEntity(0, 0, 0, 3, new Date(), 5, "Mein Hund hat Flöhe", "Fiffy.jpg", 800, 600));
		pupdatesToSniffer3
				.add(new PupdateEntity(0, 0, 0, 3, new Date(), 5, "Waschen hilft nicht, er hat immer noch Flöhe",
						"cool.jpg", 800, 600));

		Mockito.when(pupdateRepository.findPupdatesbySniffer(1)).thenReturn(pupdatesToSniffer1);

		Mockito.when(pupdateRepository.findPupdatesbySniffer(3)).thenReturn(pupdatesToSniffer3);

		// Moock Sniffers
		List<SnifferEntity> sniffers = new ArrayList<>();

		sniffers.add(new SnifferEntity(0, "is191325", "Philipp Zöchbauer"));
		sniffers.add(new SnifferEntity(0, "is191322", "Christopher Fritz"));

		sniffers.add(new SnifferEntity(0, "Fiffy1", "Fiffy"));
		sniffers.add(new SnifferEntity(0, "Balu1", "Balu"));
		sniffers.add(new SnifferEntity(0, "Hasso1", "Hasso"));
		sniffers.add(new SnifferEntity(0, "Rocky1", "Rocky"));

		// Mocking Follower Service:

		List<FollowerEntity> followers = new ArrayList<FollowerEntity>();

		followers.add(new FollowerEntity(0, 1, 3, new Date()));

		Mockito.when(followerService.getFollowers(1)).thenReturn(followers);

		List<PupdateEntity> timeline = pupdateService.fetchTimeline(1);

		System.out.print(timeline.toString());

		assertThat(timeline, hasSize(4));
		assertThat(timeline, isInDescendingOrdering());

	}

	private Matcher<? super List<PupdateEntity>> isInDescendingOrdering() {
		return new TypeSafeMatcher<List<PupdateEntity>>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("Absteigende Sortierung nach Datum erwartet!");
			}

			@Override
			protected boolean matchesSafely(List<PupdateEntity> item) {
				for (int i = 0; i < item.size() - 1; i++) {
					if (item.get(i).getDate().after(item.get(i + 1).getDate()))
						return false;

				}
				return true;
			}
		};
	}

}
