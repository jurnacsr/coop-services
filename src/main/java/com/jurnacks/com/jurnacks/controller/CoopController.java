package com.jurnacks.com.jurnacks.controller;

import com.jurnacks.com.jurnacks.com.jurnacks.repository.ConfigRepository;
import com.jurnacks.com.jurnacks.persistence.ConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Stephen Jurnack on 5/11/2016.
 */

@RestController
public class CoopController {

    @Autowired
    ConfigRepository configRepository;

    @RequestMapping("/")
    public ResponseEntity index() {
        return new ResponseEntity("Hello World!", HttpStatus.OK);
    }

    @RequestMapping(value = "/config/{name}")
    public ResponseEntity getConfig(@PathVariable String name) {
        ConfigEntity ce = configRepository.findOne(name);

        if (ce == null) {
            return new ResponseEntity("Config object {"+name+"} not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ce, HttpStatus.OK);
    }

    @RequestMapping(value = "/config/", method = RequestMethod.POST)
    public ResponseEntity saveConfig(@RequestBody ConfigEntity newEntity) {
        configRepository.save(newEntity);
        return new ResponseEntity(newEntity, HttpStatus.OK);
    }
}
