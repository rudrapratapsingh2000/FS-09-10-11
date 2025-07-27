package com.UserManagementApplication.Service;

import com.UserManagementApplication.model.UserManagementModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserManagementService {

    private static List<UserManagementModel> users = new ArrayList<>();
    static {
        users.add(new UserManagementModel(1001,"Rudra","rudra1001","Noida","346943164"));
        users.add(new UserManagementModel(1002,"Adil","adil1002","Noida","112456789"));
        users.add(new UserManagementModel(1003,"Anup","anup1003","Bangloare","54544664569"));
        users.add(new UserManagementModel(1004,"Prashant","prashant1004","Delhi","1234567890"));
        users.add(new UserManagementModel(1005,"Ajay","ajay1005","Pune","1234567890"));
    }

    public String addUser(UserManagementModel user){
        users.add(user);
        return "New User Added Successfully";
    }

    public UserManagementModel getUser(int num){
        Predicate<?super UserManagementModel> predicate=user ->user.getUser_id()==num;
        UserManagementModel user=users.stream().filter(predicate).findFirst().get();
        return user;
    }
    public List<UserManagementModel> getAllUser(){
        return users;
    }

    public String deleteUser(int number){
        Predicate<? super UserManagementModel> predicate=user ->user.getUser_id()==number;
        users.removeIf(predicate);
        return "User Deleted Successfully";
    }

    public String updateUserInfo(int number, UserManagementModel newuser){
        UserManagementModel user=getUser(number);
        user.setName(newuser.getName());
        user.setUser_name(newuser.getUser_name());
        user.setAddress(newuser.getAddress());
        user.setPhone_number(newuser.getPhone_number());
        return "User Updated Successfully";
    }
}
