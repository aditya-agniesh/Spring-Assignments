package com.restful.WebServices2.controller;

import com.restful.WebServices2.model.Users;
import com.restful.WebServices2.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "Handles all operations related to Users")
public class UserController {

    private UserService userService;

    UserController(UserService userService){
        this.userService=userService;
    }

    @Operation(
            summary = "Get All Users",
            description = "Fetches the details of users "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/showAll")
    public ResponseEntity<List<Users>> getAllUser(){
        List<Users> list=userService.getUser();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @Operation(
            summary = "Create User",
            description = "Saves a new user into the system"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Users users){
        userService.save(users);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }


    @Operation(
            summary = "Delete User",
            description = "Delete the specific with user Id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User Not Found")
    })

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean isDeleted=userService.delete(id);
        if(isDeleted){
            return  new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }


    @Operation(
            summary = "Update user",
            description = "Update user with user id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id,
                             @RequestBody Users users){
        Users user=userService.updateUser(users,id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
