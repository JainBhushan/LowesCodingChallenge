package in.lowes.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.lowes.app.beans.APIResponse;
import in.lowes.app.beans.TransactionAggregateRecords;
import in.lowes.app.beans.TransactionData;
import in.lowes.app.constants.URLConstants;
import in.lowes.app.exceptions.TransactionServiceException;
import in.lowes.app.service.TransactionService;
import in.lowes.app.utility.LoggerUtil;

/**
 * This class represent Transaction controller
 * 
 * @author bhujain
 *
 */
@RestController
@RequestMapping("/transaction-management")
public class TransactionController extends BaseController {

	/**
	 * The objTransactionService
	 */
	@Autowired
	private TransactionService objTransactionService;

	/** The Logger */
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	/**
	 * This method is used to save transaction data
	 * 
	 * @param objTransactionData
	 * @return the APIResponse
	 */
	@PostMapping(value = URLConstants.SAVE_TRANSACTION_DATA_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponse saveTransactionData(@RequestBody TransactionData objTransactionData) {
		APIResponse apiResponse = null;
		LoggerUtil.info(logger, TransactionController.class, "saveTransactionData", "request: " + objTransactionData);
		int rowInserted = 0;
		try {
			rowInserted = objTransactionService.saveTransactionData(objTransactionData);
			if (rowInserted > 0)
				apiResponse = this.setAdminResponse(HttpStatus.CREATED, null);
			else
				apiResponse = this.setAdminResponse(HttpStatus.INTERNAL_SERVER_ERROR, null);
		} catch (TransactionServiceException transactionServiceException) {
			LoggerUtil.error(logger, TransactionController.class, "saveTransactionData",
					transactionServiceException.getLocalizedMessage(), transactionServiceException);
			apiResponse = this.setAdminResponse(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
		return apiResponse;

	}

	/**
	 * This method is used to get aggregate transaction data
	 * 
	 * @return the APIResponse
	 */
	@GetMapping(value = URLConstants.GET_AGGREGATE_TRANSACTION_DATA_URL)
	public APIResponse getTransactionData()  {
		APIResponse apiResponse = null;
		LoggerUtil.info(logger, TransactionController.class, "getTransactionData()",
				"transaction aggegate records request");
		try {
			TransactionAggregateRecords objTransactionAggregateRecords = objTransactionService
					.getAggregateTransactionData();
			if (objTransactionAggregateRecords != null && objTransactionAggregateRecords.getAvgAmt() != null)
				apiResponse = this.setAdminResponse(HttpStatus.OK, objTransactionAggregateRecords);
			else
				apiResponse = this.setAdminResponse(HttpStatus.NOT_FOUND, null);
		} catch (TransactionServiceException transactionServiceException) {
			LoggerUtil.error(logger, TransactionController.class, "getTransactionData()",
					transactionServiceException.getLocalizedMessage(), transactionServiceException);
			apiResponse = this.setAdminResponse(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
		return apiResponse;

	}

}
