package by.roman.shop.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

// TODO: Сделать интерфейс для этого класса
public class RequestContent {
    public static final String SUCCESS = "success";
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
    private Map<String, Part> requestParts;

    private String contextPath;
    private String realPath;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    private String commandName;

    public RequestContent() {
        requestAttributes = new HashMap<>();
        requestParameters = new HashMap<>();
        sessionAttributes = new HashMap<>();
    }

    public void insertAttributes(HttpServletRequest request) {
        Enumeration<String> sessionAttrNames = request.getSession().getAttributeNames();
        Enumeration<String> attrNames = request.getAttributeNames();

        while (sessionAttrNames.hasMoreElements()) {
            String sessionAttr = sessionAttrNames.nextElement();
            request.getSession().removeAttribute(sessionAttr);
        }

        while (attrNames.hasMoreElements()) {
            String attrName = attrNames.nextElement();
            request.removeAttribute(attrName);
        }

        requestAttributes.forEach(request::setAttribute);
        sessionAttributes.forEach((key, value) -> request.getSession().setAttribute(key, value));
    }

    public HashMap<String, Object> getRequestAttributes() {
        return requestAttributes;
    }

    public HashMap<String, String[]> getRequestParameters() {
        return requestParameters;
    }

    public HashMap<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    public Map<String, Part> getRequestParts() {
        return requestParts;
    }

    public String getContextPath() {
        return contextPath;
    }

    public String getRealPath() {
        return realPath;
    }

    void setRequestParts(Map<String, Part> requestParts) {
        this.requestParts = requestParts;
    }

    void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    void setRealPath(String realPath) {
        this.realPath = realPath;
    }
}