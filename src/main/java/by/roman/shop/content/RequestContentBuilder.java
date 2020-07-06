package by.roman.shop.content;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestContentBuilder {
        public void apdateRequestContent(HttpServletRequest request, ResponseContent responseContent){

        }

    public RequestContent buildContent(HttpServletRequest request) throws IOException, ServletException {
        RequestContent requestContent = new RequestContent();

        Enumeration<String> attrNames = request.getAttributeNames();
        Enumeration<String> paramNames = request.getParameterNames();
        Enumeration<String> sessionAttrNames = request.getSession().getAttributeNames();

        while (attrNames.hasMoreElements()) {
            String attrName = attrNames.nextElement();
            requestContent.getRequestAttributes().put(attrName, request.getAttribute(attrName));
        }

        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            requestContent.getRequestParameters().put(paramName, request.getParameterValues(paramName));

            if (paramName.equalsIgnoreCase("command")) {
                requestContent.setCommandName(request.getParameterValues(paramName)[0]);
            }
        }

        while (sessionAttrNames.hasMoreElements()) {
            String sessionAttr = sessionAttrNames.nextElement();
            requestContent.getSessionAttributes().put(sessionAttr, request.getSession().getAttribute(sessionAttr));
        }

        if (ServletFileUpload.isMultipartContent(request)) {
            Map<String, Part> partMap = request.getParts().stream().collect(Collectors.toMap(Part::getName, x -> x));
            requestContent.setRequestParts(partMap);
        }

        requestContent.setContextPath(request.getContextPath());
        requestContent.setRealPath(request.getServletContext().getRealPath(""));

        return requestContent;
    }
}
