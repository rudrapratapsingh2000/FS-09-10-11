package com.UserManagementApplication.controller;

import com.UserManagementApplication.Service.UserManagementService;
import com.UserManagementApplication.model.UserManagementModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/userapp")
public class UserManagementController {

    public final UserManagementService userManagementService;

public UserManagementController(UserManagementService userManagementService){
    this.userManagementService=userManagementService;
}

@PostMapping("/adduser")
    public String addUser(@RequestBody UserManagementModel user){
return userManagementService.addUser(user);
}
@GetMapping("/finduser/number/{number}")
    public UserManagementModel getuser(@PathVariable int number){
    return userManagementService.getUser(number);
}

//    @GetMapping("/finduser")
//    public UserManagementModel getuser(@RequestBody Map jsonMap){
//    int number=jsonMap.get("number").toString()==null?null:Integer.parseInt(jsonMap.get("number").toString());
//        return userManagementService.getUser(number);
//    }

@GetMapping("/findalluser")
    public List<UserManagementModel> getAllUser(){
    return userManagementService.getAllUser();
}

@DeleteMapping("/deleteuser/number/{number}")
    public String deleteUser(@PathVariable int number){
    return userManagementService.deleteUser(number);
}

@PutMapping("/updateuser/number/{number}")
    public String updateUser(@PathVariable int number, @RequestBody UserManagementModel user){
    return userManagementService.updateUserInfo(number,user);
}
}
