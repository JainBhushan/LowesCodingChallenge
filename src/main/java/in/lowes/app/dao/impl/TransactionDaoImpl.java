package in.lowes.app.dao.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.lowes.app.beans.TransactionAggregateRecords;
import in.lowes.app.beans.TransactionData;
import in.lowes.app.dao.TransactionCustomDao;
import in.lowes.app.exceptions.TransactionDBException;
import in.lowes.app.utility.LoggerUtil;

/**
 * The implementation of TransactionCustomDao
 * 
 * @author bhujain
 *
 */
@Repository
@Transactional
public class TransactionDaoImpl implements TransactionCustomDao {

	/**
	 * The entityManagerFactory
	 */
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	/** The Logger */
	private static final Logger logger = LoggerFactory.getLogger(TransactionDaoImpl.class);

	/**
	 * The lockObject
	 */
	private static Object lockObject = new Object();

	@Override
	public int saveTransactionData(TransactionData transactionData) throws TransactionDBException {
		synchronized (lockObject) {
			int rowInserted = 0;
			String query = "insert into tbl_transaction_records(ammount, transaction_time) values(?,?)";
			try {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				Query objQuery = entityManager.createNativeQuery(query);
				objQuery.setParameter(1, transactionData.getAmmount());
				objQuery.setParameter(2, transactionData.getTimestamp());
				rowInserted = objQuery.executeUpdate();
				entityManager.getTransaction().commit();
			} catch (Exception exception) {
				LoggerUtil.error(logger, TransactionDaoImpl.class, "saveTransactionData()",
						exception.getLocalizedMessage(), exception);
				throw new TransactionDBException("Exception occured in DB query for saveTransactionData", exception);
			}
			return rowInserted;
		}
	}

	@Override
	public TransactionAggregateRecords getAggregateTransactionData(final long unixTime) throws TransactionDBException {
		synchronized (lockObject) {
			TransactionAggregateRecords objTransactionAggregateRecord = null;
			try {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				String query = "select sum(ammount) as sumAmt, avg(ammount) as avgAmt, max(ammount) as maxAmt, min(ammount) as minAmt, count(ammount) as countAmt from tbl_transaction_records where transaction_time >=?";
				entityManager.getTransaction().begin();
				Query objQuery = entityManager.createNativeQuery(query);
				objQuery.setParameter(1, unixTime);
				Object aggregateTransactionObject[] = (Object[]) objQuery.getSingleResult();
				entityManager.getTransaction().commit();
				if (aggregateTransactionObject != null && aggregateTransactionObject.length > 4) {
					objTransactionAggregateRecord = new TransactionAggregateRecords();
					objTransactionAggregateRecord.setSumAmt((Double) aggregateTransactionObject[0]);
					objTransactionAggregateRecord.setAvgAmt((Double) aggregateTransactionObject[1]);
					objTransactionAggregateRecord.setMaxAmt((Double) aggregateTransactionObject[2]);
					objTransactionAggregateRecord.setMinAmt((Double) aggregateTransactionObject[3]);
					objTransactionAggregateRecord.setTotalNoOfTransaction(((BigInteger) aggregateTransactionObject[4]).longValue());
				}
			} catch (Exception exception) {
				LoggerUtil.error(logger, TransactionDaoImpl.class, "getAggregateTransactionData()",
						exception.getLocalizedMessage(), exception);
				throw new TransactionDBException("Exception occured in DB query for getAggregateTransactionData",
						exception);
			}
			return objTransactionAggregateRecord;
		}
	}

}
