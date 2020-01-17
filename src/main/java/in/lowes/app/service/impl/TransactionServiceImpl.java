package in.lowes.app.service.impl;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.lowes.app.beans.TransactionAggregateRecords;
import in.lowes.app.beans.TransactionData;
import in.lowes.app.dao.TransactionDao;
import in.lowes.app.exceptions.TransactionDBException;
import in.lowes.app.exceptions.TransactionServiceException;
import in.lowes.app.service.TransactionService;
import in.lowes.app.utility.LoggerUtil;

/**
 * Implementation of TransactionService
 * 
 * @author bhujain
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	/**
	 * The objTransactionDao
	 */
	@Autowired
	private TransactionDao objTransactionDao;

	/** The Logger */
	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.lowes.app.service.TransactionService#saveTransactionData(in.lowes.app.
	 * beans.TransactionData)
	 */
	@Override
	public int saveTransactionData(TransactionData transactionData) throws TransactionServiceException {
		int rowsInserted = 0;
		try {
			rowsInserted = objTransactionDao.saveTransactionData(transactionData);
		} catch (TransactionDBException transactionDBException) {
			LoggerUtil.error(logger, TransactionServiceImpl.class, "saveTransactionData()",
					transactionDBException.getLocalizedMessage(), transactionDBException);
			throw new TransactionServiceException("Exception occured in transaction service saveTransactionData",
					transactionDBException);
		}
		return rowsInserted;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.lowes.app.service.TransactionService#getAggregateTransactionData()
	 */
	@Override
	public TransactionAggregateRecords getAggregateTransactionData() throws TransactionServiceException {
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.MILLISECOND, -60000);
		final long unixTime = objCalendar.getTimeInMillis();
		TransactionAggregateRecords transactionAggregateRecords = null;
		try {
			transactionAggregateRecords = objTransactionDao.getAggregateTransactionData(unixTime);
		} catch (TransactionDBException transactionDBException) {
			LoggerUtil.error(logger, TransactionServiceImpl.class, "getAggregateTransactionData()",
					transactionDBException.getLocalizedMessage(), transactionDBException);
			throw new TransactionServiceException(
					"Exception occured in transaction service getAggregateTransactionData", transactionDBException);
		}
		return transactionAggregateRecords;
	}

}
