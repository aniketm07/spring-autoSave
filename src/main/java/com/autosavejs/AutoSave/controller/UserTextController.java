package com.autosavejs.AutoSave.controller;

import com.autosavejs.AutoSave.entity.UserText;
import com.autosavejs.AutoSave.service.UserTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserTextController {
    @Autowired
    UserTextService userTextService;


    @PostMapping("/save-profile")
    public void saveUser(@RequestBody UserText userText){
        userTextService.saveText(userText);
    }

    @GetMapping("/get-profile/{userId}")
    public UserText getProfile(@PathVariable("userId") String userId){
        return userTextService.getTextById(userId);
    }
}
