package db;

import model.UserSession;

import java.util.concurrent.ConcurrentHashMap;

public class Session {
    private static final ConcurrentHashMap<String, String> sessions = new ConcurrentHashMap<>();

    public static void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public static String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}
