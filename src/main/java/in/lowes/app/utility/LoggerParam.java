package in.lowes.app.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class represent logging parameters
 * 
 * @author bhujain
 *
 */
public class LoggerParam {

	/** The Logger */
	private static final Logger logger = LoggerFactory.getLogger(LoggerParam.class);

	/**
	 * The methodName
	 */
	private String methodName;
	/**
	 * The className
	 */
	private String className;
	/**
	 * The text
	 */
	private String text;
	/**
	 * The errorText
	 */
	private String errorText;

	/**
	 * @param msLoggerParamBuilder
	 */
	public LoggerParam(LoggerParamBuilder loggerParamBuilder) {
		this.methodName = loggerParamBuilder.methodName;
		this.className = loggerParamBuilder.className;
		this.text = loggerParamBuilder.text;
		this.errorText = loggerParamBuilder.errorText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(this);
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the errorText
	 */
	public String getErrorText() {
		return errorText;
	}

	/**
	 * @author bhujain
	 *
	 */
	public static class LoggerParamBuilder {

		/**
		 * The methodName
		 */
		private String methodName;
		/**
		 * The className
		 */
		private String className;
		/**
		 * The text
		 */
		private String text = "NA";
		/**
		 * The errorText
		 */
		private String errorText = "NA";

		/**
		 * @param methodName
		 * @param className
		 */
		public LoggerParamBuilder(String methodName, String className) {
			this.methodName = methodName;
			this.className = className;
		}

		/**
		 * @param errorText
		 * @return
		 */
		public LoggerParamBuilder setErrorMessage(String errorText) {
			this.errorText = errorText == null ? this.errorText : errorText;
			return this;
		}

		/**
		 * @param text
		 * @return
		 */
		public LoggerParamBuilder setText(String text) {
			this.text = text == null ? this.text : text;
			return this;
		}

		/**
		 * @return the object of LoggerParam
		 */
		public LoggerParam build() {
			return new LoggerParam(this);
		}
	}

}
