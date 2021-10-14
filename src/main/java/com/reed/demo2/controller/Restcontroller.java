package com.reed.demo2.controller;

import com.reed.demo2.model.Users;

import com.reed.demo2.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

public class Restcontroller {

    @Autowired
    private RestService rs ;

    @RequestMapping(method = RequestMethod.GET, path = "/getuser/{id}")
    private Users getuser(@PathVariable int id) {
        return rs.getuser(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getbyusername/{username}")
    private Users getbyusername(@PathVariable String username){return rs.getbyusername(username);}

    @RequestMapping(method = RequestMethod.GET, path = "/getusers")
    private List<Users> getusers (){
        return rs.getusers();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/new_user")
    private Users new_user(@RequestBody Users user){
        return rs.new_user(user);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/new_users")
    private List<Users> new_users(@RequestBody List<Users> users){
        return rs.new_users(users);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteuser/{id}")
    private String deleteuser (@PathVariable int id){
        rs.deleteuser(id);
        return "User " +id+ " Deleted succcessfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteusers")
    private String deleteusers (@RequestBody List<Users> users){
        rs.deleteusers(users);
        return String.valueOf(users.size())+"users deleted successfully";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/updateuser")
    private Users updateuser (@RequestBody Users user){

        return rs.updateUsers(user);
    }

}
