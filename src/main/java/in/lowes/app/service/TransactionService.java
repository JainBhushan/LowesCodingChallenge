package in.lowes.app.service;

import in.lowes.app.beans.TransactionAggregateRecords;
import in.lowes.app.beans.TransactionData;
import in.lowes.app.exceptions.TransactionServiceException;

/**
 * The TransactionService interface
 * 
 * @author bhujain
 *
 */
public interface TransactionService {

	int saveTransactionData(TransactionData transactionData) throws TransactionServiceException ;

	TransactionAggregateRecords getAggregateTransactionData() throws TransactionServiceException ;

}
