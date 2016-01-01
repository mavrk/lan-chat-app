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
package com.mavrk.jlm.gui.components;

import com.mavrk.jlm.core.message.Message;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author mavrk
 */
/*
 * ChatTextArea.java
 * 
 * this class provides the chat text area implimentation to display the chat messages
 */
public class ChatTextArea extends JTextArea implements PropertyChangeListener {

    // message object
    private Message message = null;

    // getter for message object
    public Message getMessage() {
        return message;
    }

    // setter for message object
    public void setMessage(Message message) {
        // set the reference message
        this.message = message;
        // add the chat text area as alistner to the message object
        // listining to message text change
        this.message.addPropertyChangeListener(this);
    }

    /*
     * method called on message text change to append the text message 
     * to the chat text area
     */
    public void propertyChange(PropertyChangeEvent evt) {
        this.append("\n" + this.message.getMessage());
    }

    /*
     * constructo fo the ChatTextArea class
     */
    public ChatTextArea() {
        // call super class default constructor
        super();
        // set auto scroll to the chat text area
        // so as to always display the last added message
        DefaultCaret caret = (DefaultCaret) this.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }
}
