package com.autosavejs.AutoSave.service;

import com.autosavejs.AutoSave.entity.UserText;
import com.autosavejs.AutoSave.repository.UserTextRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserTextService {

    @Autowired
    UserTextRepository userTextRepository;

    public void saveText(UserText userText){
        log.info(userText.toString());
        userTextRepository.save(userText);
    }

    public UserText getTextById(String userId){
        if(userTextRepository.findById(userId).isPresent()){
            return userTextRepository.findById(userId).get();
        }
        return null;
    }
}
