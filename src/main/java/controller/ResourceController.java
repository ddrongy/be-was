package controller;

import http.request.Request;
import http.response.Response;

import static http.MimeType.getContentTypeByExtension;

public class ResourceController extends Controller {
    @Override
    public void doGet(Request request, Response response) {
        String contentType = getContentTypeByExtension(request.getFilePath());
        response.addHeader("Content-Type", contentType);
        response.ok(request.getFilePath());
    }

    @Override
    public void doGetAuthenticated(Request request, Response response) {
        String contentType = getContentTypeByExtension(request.getFilePath());
        response.addHeader("Content-Type", contentType);
        response.addHeader("Set-Cookie", "sid=" + request.getHeader().getCookie() + "; Path=/;");
        response.ok(request.getFilePath());
    }
}
