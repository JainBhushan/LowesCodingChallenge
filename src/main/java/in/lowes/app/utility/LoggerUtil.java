package in.lowes.app.utility;

import org.slf4j.Logger;

/**
 * This class contain all logger related method's
 * 
 * @author bhujain
 *
 */
public class LoggerUtil {

	/**
	 * The constructor
	 */
	private LoggerUtil() {

	}

	/**
	 * @param log
	 * @param className
	 * @param methodName
	 * @param message
	 */
	public static void debug(final Logger log, final Class<?> className, final String methodName,
			final String message) {
		validateLogger(log, className);
		LoggerParam LoggerParam = new LoggerParam.LoggerParamBuilder(methodName, className.getName()).setText(message)
				.build();
		log.debug(LoggerParam.toString());

	}

	/**
	 * @param logger
	 * @param className
	 */
	private static void validateLogger(final Logger logger, final Class<?> className) {
		if (logger == null || className == null) {
			throw new IllegalArgumentException("Logger or className can't be null");
		}
	}

	/**
	 * @param log
	 * @param className
	 * @param methodName
	 * @param message
	 */
	public static void warn(final Logger log, final Class<?> className, final String methodName, final String message) {
		validateLogger(log, className);
		if (log.isWarnEnabled()) {
			LoggerParam LoggerParam = new LoggerParam.LoggerParamBuilder(methodName, className.getName())
					.setText(message).build();
			log.warn(LoggerParam.toString());
		}
	}

	/**
	 * @param log
	 * @param className
	 * @param methodName
	 * @param message
	 */
	public static void error(final Logger log, final Class<?> className, final String methodName,
			final String message) {
		validateLogger(log, className);
		if (log.isErrorEnabled()) {
			LoggerParam LoggerParam = new LoggerParam.LoggerParamBuilder(methodName, className.getName())
					.setErrorMessage(message).build();
			log.error(LoggerParam.toString());
		}
	}

	/**
	 * @param log
	 * @param className
	 * @param methodName
	 * @param message
	 * @param throwable
	 */
	public static void error(final Logger log, final Class<?> className, final String methodName, final String message,
			final Throwable throwable) {
		validateLogger(log, className);
		if (log.isErrorEnabled()) {

			LoggerParam LoggerParam = new LoggerParam.LoggerParamBuilder(methodName, className.getName())
					.setErrorMessage(message).build();
			log.error(LoggerParam.toString(), throwable);
		}
	}

	/**
	 * @param log
	 * @param className
	 * @param methodName
	 * @param message
	 */
	public static void info(final Logger log, final Class<?> className, final String methodName, final String message) {
		validateLogger(log, className);
		if (log.isInfoEnabled()) {

			LoggerParam LoggerParam = new LoggerParam.LoggerParamBuilder(methodName, className.getName())
					.setText(message).build();
			log.info(LoggerParam.toString());
		}
	}

}
