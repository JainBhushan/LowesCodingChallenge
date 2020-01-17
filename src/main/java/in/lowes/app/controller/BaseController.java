package in.lowes.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import in.lowes.app.beans.APIResponse;
import in.lowes.app.beans.AppProperties;
import in.lowes.app.constants.HttpStatusConstants;
import in.lowes.app.utility.LoggerUtil;

/**
 * 
 * This is the base controller
 * 
 * @author bhujain
 *
 */
@Component
public class BaseController {

	/** The Logger */
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * The appProperties
	 */
	@Autowired
	private AppProperties appProperties;

	/**
	 * Return API response based on status
	 * 
	 * @param status
	 * @param data
	 * @return the APIResponse
	 */
	protected APIResponse setAdminResponse(HttpStatus httpStatus, Object data) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setResponseCode(httpStatus.value());
		setAPIResponseDesc(httpStatus, apiResponse);
		apiResponse.setData(data);
		LoggerUtil.info(logger, BaseController.class, "setAdminResponse()", "final Response: " + apiResponse);
		return apiResponse;
	}

	/**
	 * @param httpStatus
	 * @param apiResponse
	 * @return
	 */
	private APIResponse setAPIResponseDesc(final HttpStatus httpStatus, APIResponse apiResponse) {
		switch (httpStatus.name()) {
		case HttpStatusConstants.CREATED:
			apiResponse.setResponseDesc(appProperties.getCreatedResponse());
			break;
		case HttpStatusConstants.NOT_FOUND:
			apiResponse.setResponseDesc(appProperties.getNotFoundResponse());
			break;
		case HttpStatusConstants.INTERNAL_SERVER_ERROR:
			apiResponse.setResponseDesc(appProperties.getInternalServerErrorResponse());
			break;
		case HttpStatusConstants.OK:
			apiResponse.setResponseDesc(appProperties.getRecordFound());
			break;
		default:
			break;
		}
		return apiResponse;
	}

}
