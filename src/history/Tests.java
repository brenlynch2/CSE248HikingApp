package history;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import trails.Trail;

class Tests {

	@Test
	public void test() {
		Trail testTrail = new Trail("Test Trail");
		HikingHistoryEntry testEntry = new HikingHistoryEntry(testTrail, "01:02:03", 99.99,"1 hour", new LinkedList<String>(), 19.19);
		HikingHistoryStorageContainer testContainer = new HikingHistoryStorageContainer();
		assertEquals(testContainer.addHistoryEntry(testEntry), true);
		assertEquals(testContainer.getEntry(0), testEntry);
		assertEquals(testContainer.deleteHistoryEntry(testEntry),true);
		assertEquals(testEntry.getTrailHiked(), testTrail);
	}

}
