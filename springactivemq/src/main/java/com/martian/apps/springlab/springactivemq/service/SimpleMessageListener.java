/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springactivemq.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author b5wang
 */
public class SimpleMessageListener implements MessageListener {

    private static final Log LOG = LogFactory.getLog(SimpleMessageListener.class);

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                LOG.info(" --- Listen from QUEUE, and got: " + ((TextMessage) message).getText());
            } catch (JMSException ex) {
                LOG.error("Error during read message", ex);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }

}
