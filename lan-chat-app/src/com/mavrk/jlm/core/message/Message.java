/*
 This file is part of JLM v0.2

 JLM is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 JLM is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with JLM.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mavrk.jlm.core.message;

import com.mavrk.jlm.core.messenger.Messenger;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mavrk
 */

/*
 * Message.java
 * 
 * this class impliments a message object
 */
public class Message {

    // textual message
    private String message = null;
    // messenger associated with this message
    private Messenger messenger = null;

    //---------------------- GETTERS AND SETTERS -------------------------------
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        // set the message content
        this.message = message;
        // firing the property change
        // in-order to be listened by the property change listner components
        this.propertyChangeSupport.firePropertyChange(messageProperty, 0, 1);
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    /*
     * sendMessage Method
     * to send the current message using the messenger
     */
    public void sendMessage(String newMessage) {
        try {
            // send the message content using the messenger
            messenger.sendMessage(newMessage);
        } catch (IOException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // --------------------- Property Change Listner ---------------------------
    // message property name
    private String messageProperty = "MESSAGE_CHANGED";
    // property change support object
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /*
     * addPropertyChangeListener Method
     * used by listners for this message for adding themself as a listner for this message
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /*
     * removePropertyChangeListener Method
     * used by listners for this message for removing themself as a listner for this message
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    // ------------------- MessegeProperty Getter and Setter -------------------
    public String getMessegeProperty() {
        return messageProperty;
    }

    public void setMessegeProperty(String messageProperty) {
        this.messageProperty = messageProperty;
    }
}
