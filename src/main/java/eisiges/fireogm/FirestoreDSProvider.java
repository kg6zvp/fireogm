package eisiges.fireogm;

import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.hibernate.ogm.datastore.spi.BaseDatastoreProvider;
import org.hibernate.ogm.dialect.spi.GridDialect;
import org.hibernate.service.spi.Startable;

/**
 *
 * @author smccollum
 */
public class FirestoreDSProvider extends BaseDatastoreProvider implements Startable {
	private static final AtomicBoolean initialized = new AtomicBoolean(false);

	@Override
	public Class<? extends GridDialect> getDefaultDialect() {
		return FirestoreGridDialect.class;
	}

	@Override
	public void start() {
		if(!initialized.get()){
			//initialize firebase
			//FirebaseApp.initializeApp();
			initialized.set(true);
		}
	}
}
