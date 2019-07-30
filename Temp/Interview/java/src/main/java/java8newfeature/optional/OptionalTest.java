package java8newfeature.optional;


import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author yangxu
 */
public class OptionalTest {

    public static User defaultUser = new User();


    @Getter
    @Setter
    static class User {
        String username;
        List<String> orders;
    }

    public User getUser() {
        return new User();
    }


    public User noExistReturnNull(User user) {
        // non-null or npe
        Optional<User> o1 = Optional.of(new User());
        // allow null
        Optional<User> o2 = Optional.ofNullable(user);

        // 而不是 return user.isPresent() ? user.get() : null;
        return o2.orElse(null);
    }

    public User noExistReturnDefault(User user) {
        // non-null or npe
        Optional<User> o1 = Optional.of(new User());
        // allow null
        Optional<User> o2 = Optional.ofNullable(user);

        return o2.orElse(defaultUser);

    }


    public User noExistReturnNew(User user) {
        // non-null or npe
        Optional<User> o1 = Optional.of(new User());
        // allow null
        Optional<User> o2 = Optional.ofNullable(user);

        return o2.orElseGet(() -> getUser());
    }

    public User noExistReturnException(User user) throws Exception{
        // non-null or npe
        Optional<User> o1 = Optional.of(new User());
        // allow null
        Optional<User> o2 = Optional.ofNullable(user);

        return o2.orElseThrow(() -> new RuntimeException());
    }


    public void ifExist(User user) {

        Optional<User> o2 = Optional.ofNullable(user);
        o2.ifPresent(System.out::println);
    }

    public List<String> map(User user) {
        Optional<User> o2 = Optional.ofNullable(user);
        return o2.map(u -> u.getOrders()).orElse(Collections.emptyList());

    }

    public String multiplyMap(User user) {
        Optional<User> o2 = Optional.ofNullable(user);
        return o2.map(u -> u.getOrders())
                 .map(l -> l.get(0))
                 .map(s -> s.toLowerCase())
                 .orElse("1");

    }


    public static void main(String[] args) {


    }

}
