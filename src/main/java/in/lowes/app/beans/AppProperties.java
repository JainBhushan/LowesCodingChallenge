package in.lowes.app.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * This class is used to read all configuration from properties file
 * 
 * @author bhujain
 *
 */
@Component
@ConfigurationProperties
public class AppProperties {

	/**
	 * The createdResponse
	 */
	@Value("${api.response.created}")
	private String createdResponse;

	/**
	 * The notFound
	 */
	@Value("${api.response.record.not.found}")
	private String notFoundResponse;
	/**
	 * The internalServerError
	 */
	@Value("${api.response.internal.server.error}")
	private String internalServerErrorResponse;

	@Value("${api.response.record.found}")
	private String recordFound;

	/**
	 * @return the notFoundResponse
	 */
	public String getNotFoundResponse() {
		return notFoundResponse;
	}

	/**
	 * @param notFoundResponse
	 *            the notFoundResponse to set
	 */
	public void setNotFoundResponse(String notFoundResponse) {
		this.notFoundResponse = notFoundResponse;
	}

	/**
	 * @return the internalServerErrorResponse
	 */
	public String getInternalServerErrorResponse() {
		return internalServerErrorResponse;
	}

	/**
	 * @param internalServerErrorResponse
	 *            the internalServerErrorResponse to set
	 */
	public void setInternalServerErrorResponse(String internalServerErrorResponse) {
		this.internalServerErrorResponse = internalServerErrorResponse;
	}

	/**
	 * @return the createdResponse
	 */
	public String getCreatedResponse() {
		return createdResponse;
	}

	/**
	 * @param createdResponse
	 *            the createdResponse to set
	 */
	public void setCreatedResponse(String createdResponse) {
		this.createdResponse = createdResponse;
	}

	/**
	 * @return the recordFound
	 */
	public String getRecordFound() {
		return recordFound;
	}

	/**
	 * @param recordFound
	 *            the recordFound to set
	 */
	public void setRecordFound(String recordFound) {
		this.recordFound = recordFound;
	}

}
