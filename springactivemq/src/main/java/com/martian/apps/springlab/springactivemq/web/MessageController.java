/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springactivemq.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/message")
public class MessageController {
    
    private static final Log LOG = LogFactory.getLog(MessageController.class);
    
    
    public MessageController(){
        LOG.info("...init " + this.getClass().getName());
    }
    
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public void add(@RequestParam String msg){
        LOG.info("Add a message [" + msg + "] into QUEUE.");
    }
    
}
