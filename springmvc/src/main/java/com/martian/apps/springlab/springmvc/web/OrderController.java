/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springmvc.web;

import com.martian.apps.springlab.springmvc.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author b5wang
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    
    /**
     * URL template pattern
     */
    @RequestMapping(path="/{orderId}/get", method=RequestMethod.GET)
    public String getOrder(@PathVariable("orderId") String orderId, Model model){
        LOGGER.info("Get order by id {}", orderId);
        Order order = new Order();
        order.setId(orderId);
        model.addAttribute("order", order);
        return "/jsp/viewOrder.jsp";
    }
    
    /**
     * Narrow request by request parameters
     */
    @RequestMapping(path="/{orderId}/get", method=RequestMethod.GET, params="myParam=myValue")
    public String getOrder2(@PathVariable("orderId") String orderId, Model model){
        LOGGER.info("Get order 2 by id {}", orderId);
        Order order = new Order();
        order.setId(orderId);
        model.addAttribute("order", order);
        return "/jsp/viewOrder.jsp";
    }
    
    /**
     * Narrow request by header values
     */
    @RequestMapping(path="/{orderId}/get", method=RequestMethod.GET, headers="myHeader=myValue")
    public String getOrder3(@PathVariable("orderId") String orderId, Model model){
        LOGGER.info("Get order 3 by id {}", orderId);
        Order order = new Order();
        order.setId(orderId);
        model.addAttribute("order", order);
        return "/jsp/viewOrder.jsp";
    }
    
    @RequestMapping(path="/{orderId}/{memberId}/get", method=RequestMethod.GET)
    public String getOrder(@PathVariable("orderId") String orderId, @PathVariable("memberId") String memberId, Model model){
        LOGGER.info("Get order by id {}, memberId {}", orderId, memberId);
        Order order = new Order();
        order.setId(orderId);
        model.addAttribute("order", order);
        return "/jsp/viewOrder.jsp";
    }
    
    
}
