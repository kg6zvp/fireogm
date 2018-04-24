package eisiges.fireogm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.hibernate.ogm.model.spi.TupleSnapshot;

/**
 *
 * @author smccollum
 */
public class FirestoreTupleSnapshot implements TupleSnapshot {
	Map<String, Object> data;

	public FirestoreTupleSnapshot(Map<String, Object> data){
		this.data = data;
	}
	public FirestoreTupleSnapshot(){
		this(new HashMap<String, Object>());
	}

	@Override
	public Object get(String column) {
		return data.get(column);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Set<String> getColumnNames() {
		return data.keySet();
	}
}
