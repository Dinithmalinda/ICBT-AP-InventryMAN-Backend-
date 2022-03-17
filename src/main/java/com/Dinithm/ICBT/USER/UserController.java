package com.Dinithm.ICBT.USER;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;

@Configuration
@RestController
public class UserController {

    private final UsersRepository usersRepository;

@Autowired
public UserController(UsersRepository usersRepository){
    this.usersRepository=usersRepository;}

    @RequestMapping(
            value = "api/signup/user",
            method = RequestMethod.POST)
    public List<Users> SetUser(@RequestBody Map<String, Object> payload)
            throws Exception {
        LocalDate lt = LocalDate.now();
        System.out.println(payload);System.out.println(lt);

        Users newuser=new Users( payload.get("name").toString(),
                payload.get("email").toString(),payload.get("mobile").toString() ,
                payload.get("password").toString(),"CUSTOMER", lt);

        List<Users> user=usersRepository.findByName(newuser.getName());
        newuser.setName("invalied username"); if(!user.isEmpty()) return List.of( newuser );
        user=usersRepository.findByMobile(newuser.getMobile());
        newuser.setName("invalied mobile"); if(!user.isEmpty()) return List.of( newuser );
        newuser.setName(payload.get("name").toString());
        usersRepository.save(newuser);
        newuser.setName("OK");
        return List.of( newuser );
    }

    @RequestMapping(
            value = "api/getuserbyname/user",
            method = RequestMethod.POST)
    public List<Users> GetUserByname(@RequestBody Map<String, Object> payload)
            throws Exception {
        String bb=payload.get("name").toString();
        List<Users> user=usersRepository.findByName(bb);
        return user;
    }

    @RequestMapping(
            value = "api/getuserbymobile/user",
            method = RequestMethod.POST)
    public List<Users> GetUserBymobile(@RequestBody Map<String, Object> payload)
            throws Exception {
        String bb=payload.get("mobile").toString();
        List<Users> user=usersRepository.findByMobile(bb);
        return user;
    }

    @RequestMapping(
            value = "api/verify/user",
            method = RequestMethod.POST)
    public List<Users> verifyUser(@RequestBody Map<String, Object> payload)
            throws Exception {

        String dd=decodeuserdata(payload.get("userId").toString());
        String mobile[]=dd.split(":");
       // System.out.println(mobile[2]);

        List<Users> user=usersRepository.findByMobile(mobile[2]);
        Users users;
        if(!user.isEmpty()) users=new Users("ok","ok","ok",payload.get("userId").toString(),"ok",LocalDate.now());
        else users=new Users("ERROR","ERROR","ERROR","ERROR","ERROR",LocalDate.now());
        return List.of(users);
    }




    @RequestMapping(
            value = "api/login/user",
            method = RequestMethod.POST)
    public List<Users> UserLogin(@RequestBody Map<String, Object> payload)
            throws Exception {
        String bb = payload.get("mobile").toString();
        List<Users> user = usersRepository.findByMobile(bb);
        Users localUser=new Users();
        try{
        localUser = user.get(0);
        }catch (Exception e){}
;        if(user.isEmpty()|| !(localUser.getPassword().equals(payload.get("password").toString())))
              { localUser.setPassword("invalied password");localUser.setName("invalied");
            return List.of(localUser);}
        String originalInput = ":"+localUser.getName()+":";originalInput +=localUser.getMobile()+":";originalInput +=localUser.getEmail()+":";
        originalInput +=localUser.getPassword() +":";originalInput +=localUser.getUserid().toString() +":";
        Base64 base64 = new Base64();
        String encodedString = new String(base64.encode(originalInput.getBytes()));
        localUser.setPassword(encodedString );
        return List.of(localUser);
    }

    @RequestMapping(
            value = "api/getalluser/user",
            method = RequestMethod.POST)
    public List<Users> GetAllUser(@RequestBody Map<String, Object> payload)
            throws Exception {
        List<Users> user=usersRepository.findAll();
        return user;
    }
    @RequestMapping(
            value = "api/deleteuserbymobile/user",
            method = RequestMethod.POST)
    public List<Users> DeleteUserBymobile(@RequestBody Map<String, Object> payload)
            throws Exception {
        String bb=payload.get("mobile").toString();
        List<Users> user=usersRepository.deleteByMobile(bb);
        return user;
    }

    private String decodeuserdata(String input){
        Base64 base64 = new Base64();
        String decodedString = new String(base64.decode(input.getBytes()));


        return decodedString;
    }

}


