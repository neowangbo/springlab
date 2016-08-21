/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springmvc.web;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;


@Controller
public class HelloWorldController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);
    
    /**
     * @return URL of resource under webapp 
     */
    @RequestMapping(path="/helloWorld", method=RequestMethod.GET)
    public String helloWorld(){
        LOGGER.info("Hello World! - (1)");
        return "/jsp/helloWorld.jsp";
    }
    
    /**
     * @param request, HttpServletRequest Servlet API object
     * @param response, HttpServletResponse Servlet API object
     * @param session, HttpSession Servlet API object, may not be thread-safe
     * @param nativeWebRequest, NativeWebRequest or WebRequest
     * 
     */
    @RequestMapping(path="/helloWorld2", method=RequestMethod.POST)
    public String helloWorld(
            HttpServletRequest request, 
            HttpServletResponse response, 
            HttpSession session, 
            NativeWebRequest nativeWebRequest){
        LOGGER.info("Hello World! - (2)");
        
        Iterator<String> paramNames = nativeWebRequest.getParameterNames();
        
        return "/jsp/helloWorld.jsp";
    }
    
}
