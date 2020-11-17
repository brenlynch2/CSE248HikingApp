package trails;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	public void test() {
		PointOfInterest testPoint = new PointOfInterest("Test Identifiers", 1, 99.99, 99.99);
		PointOfInterestStorageContainer testContainer = new PointOfInterestStorageContainer();
		Trail testTrail = new Trail("Test Trail");
		TrailStorageContainer testTrailContainer = new TrailStorageContainer();
		LinkedList<Trail> testSearchResultsList = new LinkedList<Trail>();
		testSearchResultsList.add(testTrail);
		assertEquals(testTrailContainer.addTrail(testTrail), true);
		assertEquals(testTrailContainer.getTrail(0), testTrail);
		assertEquals(testTrailContainer.searchTrailList("Test Trail"), testSearchResultsList);
		assertEquals(testTrailContainer.deleteTrail(testTrail), true);
		assertEquals(testContainer.addPointOfInterest(testPoint), true);
		assertEquals(testContainer.getPointOfInterest(0), testPoint);
		assertEquals(testContainer.deletePointOfInterest(testPoint), true);
	}

}
