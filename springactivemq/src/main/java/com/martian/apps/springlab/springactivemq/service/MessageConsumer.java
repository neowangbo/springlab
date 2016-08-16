/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springactivemq.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author b5wang
 */
//@Service
public class MessageConsumer {

    private static final Log LOG = LogFactory.getLog(MessageConsumer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination destination;

    public MessageConsumer() {
        LOG.info("...init " + this.getClass().getName());
    }

    public String receiveMessage() throws JMSException {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        LOG.info("Consumer receive: " + textMessage);
        return textMessage.getText();
    }
}
