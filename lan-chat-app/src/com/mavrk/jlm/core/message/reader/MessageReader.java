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
package com.mavrk.jlm.core.message.reader;

import com.mavrk.jlm.core.message.Message;
import com.mavrk.jlm.core.message.filters.FilterTypes;
import com.mavrk.jlm.core.messenger.Messenger;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mavrk
 */

/*
 * MessageReader.java
 * 
 * this class impliments a message reader
 */
public class MessageReader {

    // the message object
    private Message message;
    // the messenger reference object
    private Messenger messengerInterface;
    // flag to stop reading
    private boolean stop = false;
    // runnable Reader class object
    private Reader reader = null;
    // thread for reader runnable
    private Thread thread = null;

    /*
     * privatising default constructor inorder to prevent usage
     */
    private MessageReader() {
    }

    /*
     * class constructor with message object and messenger reference object as parameter
     */
    public MessageReader(Message msg, Messenger msngrInterface) {
        // set the message object
        this.message = msg;
        // set the messenger object
        this.messengerInterface = msngrInterface;
        // create reader
        reader = new Reader();
        // create thread for the reader
        thread = new Thread(reader);
    }

    /*
     * method to start reading messages
     */
    public void startReading() {
        // set stop flag as false
        stop = false;
        // start the thread for reader runnable
        thread.start();
    }

    /*
     * method to stop reading messages
     */
    public void stopReading() {
        // set stop flag to true
        stop = true;
    }

    /*
     * Reader Class
     * 
     * this runnable class impliments the run method to read the message 
     * continiously from the messenger
     */
    private class Reader implements Runnable {

        @Override
        public void run() {
            // read till stop equals true
            while (!stop) {
                try {
                    // read the message from messenger and set it to the message object
                    message.setMessage(messengerInterface.recieveMessage());
                } catch (IOException ex) {
                    Logger.getLogger(MessageReader.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    // null pointer exception found when the other side connection is closed
                    // so inform the user through the message
                    message.setMessage((char) FilterTypes.TEXT_FILTER + "INFO: Other side connection closed.");
                    // stop the message reading
                    stop = true;
                }
            }
        }
    }
}
