package eisiges.fireogm;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author smccollum
 */
public class FirestoreSnapshotFactory {
	/**
	 * Flatten an object coming from Firestore (which is nested maps) into a map without hierarchy like so:
	 * 
	 * Sample input:
	 * {
	 * 	"id": 1,
	 * 	"lastName": "Hawk",
	 * 	"firstName": "Mike",
	 * 	"account": {
	 * 		"number": 23571113171923,
	 * 		"name": "institutional"
	 * 	}
	 * }
	 * Sample output:
	 * {
	 * 	"id": 1,
	 * 	"lastName": "Hawk",
	 * 	"firstName": "Mike",
	 * 	"account.number": 23571113171923,
	 * 	"account.name": "institutional"
	 * }
	 * @param firestoreEntity: format as returned from Firestore database
	 * @return a hibernate-ogm-flattened Map<String, Object>
	 */
	public static Map<String, Object> firestoreToTuple(Map<String, Object> firestoreEntity){
		return firestoreEntity.entrySet().stream()
			.flatMap((Map.Entry<String, Object> objectField) -> {
				return flattenObject("", objectField);
			}).collect(Collectors.toMap((Map.Entry<String, Object> e) -> e.getKey(), (Map.Entry<String, Object> e) -> e.getValue()));
	}
	private static Stream<Map.Entry<String, Object>> flattenObject(String prefix, Map.Entry<String, Object> documentField){
		if(Map.class.isAssignableFrom(documentField.getValue().getClass())){ //if it's a map, do recursive call
			return ((Map<String, Object>) documentField.getValue())
					.entrySet()
					.stream()
					.flatMap((Map.Entry<String, Object> i) -> flattenObject(prefix + documentField.getKey() + ".", i));
		}else{
			return Stream.of(documentField).map(f -> new AbstractMap.SimpleEntry<>(prefix + f.getKey(), f.getValue()));
		}
	}
}
