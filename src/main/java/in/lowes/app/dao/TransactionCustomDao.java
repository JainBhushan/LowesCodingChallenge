package in.lowes.app.dao;

import in.lowes.app.beans.TransactionAggregateRecords;
import in.lowes.app.beans.TransactionData;
import in.lowes.app.exceptions.TransactionDBException;

/**
 * The Custom TransactionCustom
 * 
 * @author bhujain
 *
 */
public interface TransactionCustomDao {

	int saveTransactionData(TransactionData transactionData) throws TransactionDBException;

	TransactionAggregateRecords getAggregateTransactionData(final long unixTime) throws TransactionDBException;

}
