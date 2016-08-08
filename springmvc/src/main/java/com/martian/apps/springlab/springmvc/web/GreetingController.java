/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springmvc.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {
    
    private static final Log LOG = LogFactory.getLog(GreetingController.class);
    
    public GreetingController(){
        LOG.info("...init " + this.getClass().getName());
    }
    
    
    @RequestMapping(value="/sayHelloTo", method=RequestMethod.GET)
    public void sayHelloTo(@RequestParam String name){
        LOG.info("Say Hello to " + name + "!");
    }
    
}
