package com.reed.demo2.service;

import com.reed.demo2.model.Users;
import com.reed.demo2.repository.RestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService {

    @Autowired
    private RestRepository rr ;


    public Users getuser( int id) {
        return rr.findById(id).orElse(null);
    }

    public Users getbyusername( String username) {
        List<Users> usr_List = rr.findAll();
        Users result = null;
        for(int i=0; i<usr_List.size(); i++){
            if(usr_List.get(i).getUsername().equalsIgnoreCase(username)){
                result = usr_List.get(i);
            }
        }
        return result;
    }


    public List<Users> getusers (){
        return rr.findAll();
    }


    public Users new_user( Users user){
        return rr.save(user);
    }


    public List<Users> new_users( List<Users> users){
        return rr.saveAll(users);
    }


    public String deleteuser ( int id){
        rr.deleteById(id);
        return "User " +id+ " Deleted succcessfully";
    }


    public String deleteusers ( List<Users> users){
        rr.deleteInBatch(users);
        return String.valueOf(users.size())+"users deleted successfully";
    }

    public Users updateUsers(Users user) {
        Users Euser = rr.findById(user.getId()).orElse(null);
        Euser.setFirstname(user.getFirstname());
        Euser.setLastname(user.getLastname());
        Euser.setEmail(user.getEmail());
        Euser.setUsername(user.getUsername());
        Euser.setPassword(user.getPassword());

        return rr.save(Euser);
    }

}
