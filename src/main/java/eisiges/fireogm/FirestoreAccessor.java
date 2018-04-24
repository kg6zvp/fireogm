package eisiges.fireogm;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author smccollum
 */
public class FirestoreAccessor {
	/**
	 * Retrieve a tuple in a given collection by key
	 * @param collection
	 * @param key
	 * @return 
	 */
	public FirestoreTupleSnapshot getById(String collection, String key){
		Map<String, Object> data = null;
		try{
			data = FirestoreClient.getFirestore()
				.collection(collection) //narrow the scope by table
				.document(key) //narrow the scope to an entity with the given key
				.get() //get ApiFuture to access it
				.get() //wait to synchronously retrieve the future
				.getData(); //get the Map<String, Object> of the data
		}catch(Exception ee){
			throw new RuntimeException(ee);
		}
		return new FirestoreTupleSnapshot(
			FirestoreSnapshotFactory.firestoreToTuple(data)
		);
	}
}
