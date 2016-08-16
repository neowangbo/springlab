/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springactivemq.web;

import com.martian.apps.springlab.springactivemq.service.MessageConsumer;
import com.martian.apps.springlab.springactivemq.service.MessageProducer;
import javax.jms.JMSException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping ("/message")
public class MessageController {
    
    private static final Log LOG = LogFactory.getLog(MessageController.class);
    
    @Autowired
    private MessageProducer messageProducer;
    
    //@Autowired
    private MessageConsumer messageConsumer;
    
    
    public MessageController(){
        LOG.info("...init " + this.getClass().getName());
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public void add(@RequestParam final String msg){
        LOG.info("Add message [" + msg + "] into the queue!");
        messageProducer.sendMessage(msg);
    }
    
    
    @RequestMapping(value="/read", method=RequestMethod.GET)
    public void read(){
        try {
            String msg = messageConsumer.receiveMessage();
            LOG.info("Read message [" + msg + "] from the queue!");
        } catch (JMSException ex) {
            LOG.fatal("Error happend during reading msg from QUEUE", ex);
        }
    }
}
