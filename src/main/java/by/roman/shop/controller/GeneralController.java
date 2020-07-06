package by.roman.shop.controller;

import by.roman.shop.command.Command;
import by.roman.shop.command.CommandFactory;
import by.roman.shop.content.RequestContent;
import by.roman.shop.content.RequestContentBuilder;
import by.roman.shop.content.ResponseContent;
import by.roman.shop.content.RouteType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet(name = "GeneralController", urlPatterns = {"/generalController"})
public class GeneralController extends Controller {
    private String PAGES = "pages/";
    private CommandFactory factory = new CommandFactory();
    private RequestContentBuilder reqBuilder = new RequestContentBuilder();

    protected void executeRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestContent reqContent = reqBuilder.buildContent(req);
        Command command = factory.getCommand(reqContent.getCommandName());
        ResponseContent respContent = command.execute(reqContent);
        if (RouteType.FORWARD.equals(respContent.getRouteType())) {
           fillHttpRequest(req, respContent);
           req.getRequestDispatcher(PAGES + respContent.getPage().getPageName()).forward(req, resp);
        }  else {
            resp.sendRedirect(PAGES + respContent.getPage().getPageName());
        }
    }

    void fillHttpRequest(HttpServletRequest req, ResponseContent respContent) {
        Collections
                .list(req.getAttributeNames())
                .forEach(req::removeAttribute);
        Collections
                .list(req.getSession().getAttributeNames())
                .forEach(name -> req.getSession().removeAttribute(name));

        respContent.getRequestParams().forEach(req::setAttribute);
        respContent.getSessionParams().forEach((n, obj) -> req.getSession().setAttribute(n, obj));
    }
}
