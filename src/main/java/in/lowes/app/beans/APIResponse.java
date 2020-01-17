package in.lowes.app.beans;

import java.io.Serializable;

/**
 * This class is used to all api responses
 * 
 * @author bhujain
 *
 */
public class APIResponse implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The responseCode
	 */
	private Integer responseCode;
	/**
	 * The responseDesc
	 */
	private String responseDesc;
	/**
	 * The data
	 */
	private Object data;

	/**
	 * @return responseCode
	 */
	public Integer getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode
	 */
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return responseDesc
	 */
	public String getResponseDesc() {
		return responseDesc;
	}

	/**
	 * @param responseDesc
	 */
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "APIResponse [responseCode=" + responseCode + ", responseDesc=" + responseDesc + ", data=" + data + "]";
	}

}
