package db;

import java.util.concurrent.ConcurrentHashMap;

public class Session {
    private static final ConcurrentHashMap<String, String> sessions = new ConcurrentHashMap<>();

    public static void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public static boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}
