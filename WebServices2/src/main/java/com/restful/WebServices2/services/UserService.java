package com.restful.WebServices2.services;

import com.restful.WebServices2.model.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<Users> usersList=new ArrayList<>();
    private static int count=0;

    static {
        usersList.add(new Users(++count,"Aditya Agniesh","aditya@ttn.com"));
        usersList.add(new Users(++count,"Rohit","Rohit@ttn.com"));
        usersList.add(new Users(++count,"Amit","amit@ttn.com"));
    }

    public List<Users> getUser(){
        return usersList;
    }

    public Users save(Users users){
        users.setId(++count);
        usersList.add(users);
        return users;
    }

    public boolean delete(int id){
        Users users=usersList.stream()
                .filter(user->user.getId()==id)
                .findFirst().orElse(null);

        return usersList.remove(users);
    }

    public Users updateUser(Users updateUser, int id){
        Users users=usersList.stream()
                .filter(user->user.getId()==id)
                .findFirst().orElse(null);

        users.setName(updateUser.getName());
        users.setEmail(updateUser.getEmail());

        return users;
    }


}
