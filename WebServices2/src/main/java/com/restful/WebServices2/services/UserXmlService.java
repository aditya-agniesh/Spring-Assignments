package com.restful.WebServices2.services;

import com.restful.WebServices2.model.UsersXml;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserXmlService {
    private static List<UsersXml> usersXmlList =new ArrayList<>();
    private static int count=0;

    static {
        usersXmlList.add(new UsersXml(++count,"Aditya Agniesh","aditya@ttn.com"));
    }

    public List<UsersXml> getAllUser(){
        return usersXmlList;
    }

    public UsersXml addUser(UsersXml usersXml){
        usersXml.setId(++count);
        usersXmlList.add(usersXml);
        return usersXml;
    }
}
