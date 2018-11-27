package com.kozitski.pufar.command;

import java.util.Map;

public class RequestValue {

    private Map<String, Object> servletContext;
    private Map<String, Object> servletSession;
    private Map<String, Object> requestAttribute;
    private Map<String, String> requestParameter;

    public RequestValue() {
    }
    public RequestValue(Map<String, Object> servletContext, Map<String, Object> servletSession,
                        Map<String, Object> requestAttribute, Map<String, String> requestParameter) {
        this.servletContext = servletContext;
        this.servletSession = servletSession;
        this.requestAttribute = requestAttribute;
        this.requestParameter = requestParameter;
    }

    public Object servletContextPut(String key, Object value) {
        return servletContext.put(key, value);
    }
    public Object servletSessionPut(String key, Object value) {
        return servletSession.put(key, value);
    }
    public Object requestAttributePut(String key, Object value) {
        return requestAttribute.put(key, value);
    }
    public Object requestParameterPut(String key, String value) {
        return requestParameter.put(key, value);
    }

    public Object servletContextGet(String key) {
        return servletContext.get(key);
    }
    public Object servletSessionGet(String key) {
        return servletSession.get(key);
    }
    public Object requestAttributeGet(String key) {
        return requestAttribute.get(key);
    }
    public String requestParameterGet(String key) {
        return requestParameter.get(key);
    }

}
