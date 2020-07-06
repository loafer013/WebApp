package by.roman.shop.content;

import by.roman.shop.page.JSPPage;

import java.util.HashMap;
import java.util.Map;

public class ResponseContent {
    private RouteType routeType;
    private JSPPage page;
    private Map<String, Object> requestParams = new HashMap<>();
    private Map<String, Object> sessionParams = new HashMap<>();
    public ResponseContent(JSPPage page) {
        this.page = page;
        this.routeType = RouteType.FORWARD;
    }

    public ResponseContent(JSPPage page, RouteType routeType) {
        this.page = page;
        this.routeType = routeType;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public JSPPage getPage() {
        return page;
    }

    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    public Map<String, Object> getSessionParams() {
        return sessionParams;
    }
}
