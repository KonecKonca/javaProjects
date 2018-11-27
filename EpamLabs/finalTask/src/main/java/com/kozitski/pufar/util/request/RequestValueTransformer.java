package com.kozitski.pufar.util.request;

import com.kozitski.pufar.command.RequestValue;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class RequestValueTransformer {

    public static RequestValue transform(HttpServletRequest request){

        HashMap<String, Object> servletContext = new HashMap<>();
        Enumeration<String> servletContextAttributeNames = request.getServletContext().getAttributeNames();
        while (servletContextAttributeNames.hasMoreElements()){
            String attributeName = servletContextAttributeNames.nextElement();
            servletContext.put(attributeName, request.getServletContext().getAttribute(attributeName));
        }

        HashMap<String, Object> servletSession = new HashMap<>();
        Enumeration<String> sessionAttributeNames = request.getSession().getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()){
            String attributeName = sessionAttributeNames.nextElement();
            servletSession.put(attributeName, request.getSession().getAttribute(attributeName));
        }

        HashMap<String, Object> requestAttribute = new HashMap<>();
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            requestAttribute.put(attributeName, request.getAttribute(attributeName));
        }

        // means that parameter will not have duplicate names
        HashMap<String, String> requestParameter = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            requestParameter.put(parameterName, request.getParameter(parameterName));
        }

        return new RequestValue(servletContext, servletSession, requestAttribute, requestParameter);
    }

}
