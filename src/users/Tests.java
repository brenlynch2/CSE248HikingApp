package users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	public void test() {
		User testUser = new User("brenden", "1234567890");
		TreeMapUserStorageContainer testContainer = new TreeMapUserStorageContainer();
		testContainer.addUser(testUser);
		assertEquals(testContainer.authenticateUser("brenden", "1234567890"), testUser);
		assertEquals(testContainer.authenticateUser("this is a wrong username" , "this is a wrong password"), null);
	}

}
