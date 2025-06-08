package ru.netology.springBoot.rest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static final List<User> users = List.of(
            new User("sega", "1234", List.of(Authorities.READ, Authorities.WRITE)),
            new User("mega", "1234", List.of(Authorities.READ))
    );


    public List<Authorities> getUserAuthorities(String user, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(user) && u.getPassword().equals(password))
                .findFirst()
                .map(User::getAuthorities)
                .orElse(new ArrayList<>());
    }

    private static class User {
        private final String username;
        private final String password;
        private final List<Authorities> authorities;

        public User(String username, String password, List<Authorities> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public List<Authorities> getAuthorities() {
            return authorities;
        }
    }
}

//localhost:8080/authorize?user=sega&password=1234