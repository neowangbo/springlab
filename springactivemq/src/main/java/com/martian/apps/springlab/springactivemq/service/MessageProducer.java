/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springactivemq.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 *
 * @author b5wang
 */
@Service
public class MessageProducer {

    private static final Log LOG = LogFactory.getLog(MessageProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination destination;

    public MessageProducer() {
        LOG.info("...init " + this.getClass().getName());
    }

    public void sendMessage(final String msg) {
        LOG.info("Producer sends: " + msg);
        
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
        
    }
}
