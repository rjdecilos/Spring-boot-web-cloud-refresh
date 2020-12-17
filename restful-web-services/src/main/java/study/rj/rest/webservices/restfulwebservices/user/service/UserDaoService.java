package study.rj.rest.webservices.restfulwebservices.user.service;

import org.springframework.stereotype.Component;
import study.rj.rest.webservices.restfulwebservices.user.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
        usersCount = 3;
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null)
            user.setId(++usersCount);

        users.add(user);

        return user;
    }

    public User findOne(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    public User deleteById (int id) {
        User deletedUser = users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
        users = users.stream()
                .filter(user -> user.getId() != id)
                .collect(Collectors.toList());

        return deletedUser;
    }
}
