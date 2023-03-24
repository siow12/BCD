package org.example.controller;

import org.example.DB;
import org.example.DBSingleton;
import org.example.Main;
import org.example.cryptography.HasherService;
import org.example.cryptography.KeyPairService;
import org.example.exception.InvalidCredentialException;
import org.example.exception.UserExistException;
import org.example.exception.UserNotFoundException;
import org.example.model.User;

import java.util.Optional;

public class UserController {

    private static final DB<User> userDB = DBSingleton.getDb(User.class);

    public static User register(String userName, String password, String role) throws UserExistException {
        Optional<User> existingUser = userDB.getEntityStore()
                                            .stream()
                                            .filter(u -> u.getUserName().equals(userName))
                                            .findFirst();
        if (existingUser.isPresent()) {
            throw new UserExistException("User exist");
        }
        String passwordHash = HasherService.hashSHA512(password);

        User newUser = User.builder()
                           .userName(userName)
                           .passwordHash(passwordHash)
                           .role(role)
                           .build();

        userDB.getEntityStore().add(newUser);
        userDB.save();

        KeyPairService.create(newUser.getUserName());

        return newUser;
    }

    public static void login(String userName, String password) throws UserNotFoundException, InvalidCredentialException {
        Optional<User> existingUser = userDB.getEntityStore()
                                            .stream()
                                            .filter(u -> u.getUserName().equals(userName))
                                            .findFirst();
        if (existingUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        String passwordHash = HasherService.hashSHA512(password);
        //Compare password
        if(passwordHash.equals(existingUser.get().getPasswordHash())){
            //Set current user
            Main.currentUser = existingUser.get();
        }else{
            throw new InvalidCredentialException("Invalid credential");
        }

    }
}
