package webserver;

import controller.Controller;
import controller.ResourceController;
import controller.user.CreateController;
import controller.user.LoginController;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private static Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/user/create", new CreateController());
        controllers.put("/user/login", new LoginController());
    }

    public Controller findController(String url) {
        return controllers.keySet().stream()
                .filter(key -> key.equals(url))
                .findFirst()
                .map(controllers::get)
                .orElse(new ResourceController());
    }
}
