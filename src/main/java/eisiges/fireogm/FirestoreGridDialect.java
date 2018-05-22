package eisiges.fireogm;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Set;
import org.hibernate.ogm.dialect.identity.spi.IdentityColumnAwareGridDialect;
import org.hibernate.ogm.dialect.spi.AssociationContext;
import org.hibernate.ogm.dialect.spi.AssociationTypeContext;
import org.hibernate.ogm.dialect.spi.BaseGridDialect;
import org.hibernate.ogm.dialect.spi.ModelConsumer;
import org.hibernate.ogm.dialect.spi.NextValueRequest;
import org.hibernate.ogm.dialect.spi.OperationContext;
import org.hibernate.ogm.dialect.spi.TupleAlreadyExistsException;
import org.hibernate.ogm.dialect.spi.TupleContext;
import org.hibernate.ogm.dialect.spi.TupleTypeContext;
import org.hibernate.ogm.entityentry.impl.TuplePointer;
import org.hibernate.ogm.model.key.spi.AssociationKey;
import org.hibernate.ogm.model.key.spi.AssociationKeyMetadata;
import org.hibernate.ogm.model.key.spi.EntityKey;
import org.hibernate.ogm.model.key.spi.EntityKeyMetadata;
import org.hibernate.ogm.model.spi.Association;
import org.hibernate.ogm.model.spi.Tuple;
import org.hibernate.ogm.model.spi.TupleSnapshot;

/**
 *
 * @author smccollum
 */
public class FirestoreGridDialect extends BaseGridDialect implements IdentityColumnAwareGridDialect {
	FirestoreAccessor fsa;

	public FirestoreGridDialect() {
		fsa = new FirestoreAccessor();
	}

	@Override
	public Tuple getTuple(EntityKey ek, OperationContext oc) {
		TupleSnapshot snap = fsa.getById(ek.getTable(), ek.getColumnValues()[0].toString()); //I think this is wrong, but I'm putting it in anyway
		Tuple t = new Tuple(snap, Tuple.SnapshotType.UNKNOWN); //we don't understand snapshots, hakz
		return t;
	}

	@Override
	public Tuple createTuple(EntityKey ek, OperationContext oc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void insertOrUpdateTuple(EntityKey ek, TuplePointer tp, TupleContext tc) throws TupleAlreadyExistsException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void removeTuple(EntityKey ek, TupleContext tc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Association getAssociation(AssociationKey ak, AssociationContext ac) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Association createAssociation(AssociationKey ak, AssociationContext ac) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void insertOrUpdateAssociation(AssociationKey ak, Association asctn, AssociationContext ac) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void removeAssociation(AssociationKey ak, AssociationContext ac) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean isStoredInEntityStructure(AssociationKeyMetadata akm, AssociationTypeContext atc) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Number nextValue(NextValueRequest nvr) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void forEachTuple(ModelConsumer mc, TupleTypeContext ttc, EntityKeyMetadata ekm) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Tuple createTuple(EntityKeyMetadata entityKeyMetadata, OperationContext operationContext) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void insertTuple(EntityKeyMetadata entityKeyMetadata, Tuple tuple, TupleContext tupleContext) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
