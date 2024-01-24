package http.request;

import java.util.Map;

public class Headers {
    private Map<String, String> headers;


    public Headers(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getCookie() {
        String cookieHeader = headers.get("Cookie");
        if (cookieHeader != null) {
            String[] rawCookies = cookieHeader.split("; ");
            for (String rawCookie : rawCookies) {
                String[] keyValue = rawCookie.split("=", 2);
                if (keyValue[0].equals("sid")) {
                    return keyValue[1];
                }
            }
        }
        return "";
    }

}
