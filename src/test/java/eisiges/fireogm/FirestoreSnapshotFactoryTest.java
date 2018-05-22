package eisiges.fireogm;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author smccollum
 */
@RunWith(JUnitPlatform.class)
public class FirestoreSnapshotFactoryTest {
	@Test
	public static void testFlatten(){
		Map<String, Object> userProfile = new HashMap<String, Object>();
		userProfile.put("id", 1L);
		userProfile.put("lastName", "Hawk");
		userProfile.put("firstName", "Mike");
		Map<String, Object> bankAcct = new HashMap<String, Object>();
		bankAcct.put("accountNumber", 2357L);
		bankAcct.put("nickname", "money bags");
		userProfile.put("bankAccount", bankAcct);

		Map<String, Object> tupleSnapshot = FirestoreSnapshotFactory.firestoreToTuple(userProfile);
		assertEquals(5, tupleSnapshot.size());
		assertTrue(tupleSnapshot.containsKey("id"));
		assertEquals(1L, tupleSnapshot.get("id"));
		assertTrue(tupleSnapshot.containsKey("lastName"));
		assertEquals("Hawk", tupleSnapshot.get("lastName"));
		assertTrue(tupleSnapshot.containsKey("firstName"));
		assertEquals("Mike", tupleSnapshot.get("firstName"));
		assertTrue(tupleSnapshot.containsKey("bankAccount.accountNumber"));
		assertEquals(2357L, tupleSnapshot.get("bankAccount.accountNumber"));
		assertTrue(tupleSnapshot.containsKey("bankAccount.nickname"));
		assertEquals("money bags", tupleSnapshot.containsKey("bankAccount.nickname"));
	}
}
