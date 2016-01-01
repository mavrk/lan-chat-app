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
package com.mavrk.jlm.core.message.filters;

import com.mavrk.jlm.core.message.Message;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author mavrk
 */

/*
 * MessageFilter.java
 * 
 * this class impliments message filter used to filter messages according to 
 * the filter types
 */
public class MessageFilter implements PropertyChangeListener {

    // the raw message
    private Message rawMessage = null;
    // the filtered message 
    private Message filteredMessage = null;
    // filter type variable
    private int filterType = 0;

    /*
     * class constructor with input message and the filter type
     */
    public MessageFilter(Message inputMessage, int filterType) {
        // set the filter type
        this.setFilterType(filterType);
        // set the input raw message
        this.setInputMessage(inputMessage);
    }

    /*
     * getter and setter for filter types
     */
    public int getFilterType() {
        return filterType;
    }

    public final void setFilterType(int filterType) {
        this.filterType = filterType;
    }

    /*
     * Getter for the filter message
     * 
     * Note:- NO need for filtered message setter
     */
    public Message getFilteredMessage() {
        return filteredMessage;
    }

    /*
     * method to set the input message as the raw message
     */
    public final void setInputMessage(Message inputMessage) {
        // set the input message as the raw message
        rawMessage = inputMessage;
        // add this filter as a listner to the raw message object
        rawMessage.addPropertyChangeListener(this);
        // create the filtered message
        filteredMessage = new Message();
        // assign the filterd message messenger with the raw message messenger
        filteredMessage.setMessenger(rawMessage.getMessenger());
    }

    /*
     * method invoked on property change event
     * - ie raw message message content changed event
     */
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            // if the message content type is equal to the assigned filter type then
            if (rawMessage.getMessage().charAt(FilterTypes.TYPE_LOC_INDEX) == (char) filterType) {
                // set the filtered message content
                // - remove the content filter type value
                filteredMessage.setMessage(rawMessage.getMessage().substring(1));
            }
        } catch (StringIndexOutOfBoundsException ex) {
            // runtime error skipping` ...                
        }
    }
}
