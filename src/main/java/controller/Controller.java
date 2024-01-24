package controller;

import db.Session;
import http.request.HttpMethod;
import http.request.Request;
import http.response.Response;

public abstract class Controller {

    public void service(Request request, Response response) {
        if (request.getMethod() == HttpMethod.GET) {
            if (isAuthenticated(request)) {
                doGetAuthenticated(request, response);
            } else {
                doGet(request, response);
            }
        } else if (request.getMethod() == HttpMethod.POST) {
            if (isAuthenticated(request)) {
                doPostAuthenticated(request, response);
            } else {
                doPost(request, response);
            }
        }
    }

    private boolean isAuthenticated(Request request) {
        String sessionId = getSessionIdFromHeader(request);
        return sessionId != null && Session.isValidSession(sessionId);
    }

    private String getSessionIdFromHeader(Request request) {
        return request.getHeader().getCookie();
    }

    public void doGet(Request request, Response response) {
    }

    public void doPost(Request request, Response response) {
    }

    public void doGetAuthenticated(Request request, Response response) {
    }

    public void doPostAuthenticated(Request request, Response response) {
    }
}
