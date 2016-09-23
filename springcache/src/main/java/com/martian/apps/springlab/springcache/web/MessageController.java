/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springcache.web;

import com.martian.apps.springlab.springcache.service.MessageCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author b5wang
 */
@RequestMapping("/message")
@Controller
public class MessageController {
    
    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);
    
    @Autowired
    private MessageCacheService msgService;
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public void add(@RequestParam final Integer id,@RequestParam final String msg){
        LOG.info("---> Add message :: id=" + id + ", msg=" + msg);
        msgService.add(id, msg);
    }
    
    @RequestMapping(value="/get", method=RequestMethod.GET)
    public void get(@RequestParam final Integer id){
        LOG.info("--> Get message :: id=" + id);
        String msg = msgService.get(id);
        LOG.info("--> Get message :: msg=" + msg);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.GET)
    public void update(@RequestParam final Integer id,@RequestParam final String msg){
        LOG.info("--> Update message :: id=" + id + ", msg=" + msg);
        msgService.update(id, msg);
    }
    
    @RequestMapping(value="/removeAll", method=RequestMethod.GET)
    public void removeAll(){
        LOG.info("--> Clean cache...");
        msgService.removeAll();
    }
    
}
