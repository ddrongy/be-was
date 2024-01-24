package controller.user;

import controller.Controller;
import db.Database;
import db.Session;
import http.request.Request;
import http.response.Response;
import model.User;

import java.util.Map;
import java.util.UUID;

import static util.Parser.parseQueryString;

public class LoginController extends Controller {
    @Override
    public void doPost(Request request, Response response) {
        try{
            Map<String, String> queryParams = parseQueryString(request.getBody());
            validate(queryParams);
            String userId = queryParams.get("userId");
            String password = queryParams.get("password");
            User user = Database.findUserById(userId);

            user.checkPassword(password);

            String sessionId = UUID.randomUUID().toString();
            response.addHeader("Set-Cookie", "sid=" + sessionId + "; Path=/;");
            // TO-DO: max-age, 세션 지속시간 + refresh session
            Session.addSession(sessionId, user.getUserId());

            response.redirect("/index.html");
        }
        catch (IllegalArgumentException e) {
            response.redirect("/user/login_failed.html");
        }
    }

    private void validate(Map<String, String> params){
        if (!params.containsKey("userId") ||
            !params.containsKey("password")) {
            throw new IllegalArgumentException("Missing required parameters.");
        }
    }
}