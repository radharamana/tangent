package co.za.tangent.web.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * Utility class for HTTP headers creation.
 */
public final class HeaderUtil {
	
	
    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);

    private HeaderUtil() {
    }

    public static HttpHeaders createAlert(String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-StdApp-alert", message);
        headers.add("X-StdApp-params", param);
        return headers;
    }

        
    public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
        return createAlert("A new " + entityName + " is created with identifier " + param, param);
    }

    public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
        return createAlert("A " + entityName + " is updated with identifier " + param, param);
    }

    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
        return createAlert("A " + entityName + " is deleted with identifier " + param, param);
    }
    
    public static HttpHeaders createExceptionAlert(String entityName, Exception e){
    	return createFailureAlert(entityName, e.getClass().getSimpleName(), e.getMessage()+". Coins returned.");
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        log.error("Entity processing failed, {}", defaultMessage);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-StdApp-error", defaultMessage);
        headers.add("X-StdApp-params", entityName);
        return headers;
    }
    
    public static String splitCamelCase(String s) {
    	   return s.replaceAll(
    	      String.format("%s|%s|%s",
    	         "(?<=[A-Z])(?=[A-Z][a-z])",
    	         "(?<=[^A-Z])(?=[A-Z])",
    	         "(?<=[A-Za-z])(?=[^A-Za-z])"
    	      ),
    	      " "
    	   );
    	}
}