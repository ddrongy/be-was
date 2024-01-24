package db;

import com.google.common.collect.Maps;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.RequestHandler;

import java.util.Collection;
import java.util.Map;

public class Database {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);
    private static final Map<String, User> users = Maps.newHashMap();

    public static void addUser(User user) {
        if (users.containsKey(user.getUserId())) {
            throw new IllegalArgumentException("이미 존재하는 ID");
        }
        users.put(user.getUserId(), user);
        logger.debug(user.toString());
    }

    public static User findUserById(String userId) {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("존재하지 않는 ID");
        }
        return users.get(userId);
    }

    public static Collection<User> findAll() {
        return users.values();
    }

}
