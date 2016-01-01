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
package com.mavrk.jlm.core.messenger;

import java.io.IOException;

/**
 *
 * @author mavrk
 */
/*
 * Messenger.java
 *
 * This interface contains all the abstract functions a messenger must have
 */
public interface Messenger {

    /*
     * connect method
     * to connect to a specific ip at port with id portId
     */
    public void connect(String ip, int portId) throws IOException;

    /*
     * sendMessage method
     * to send a string message to the other side
     */
    public void sendMessage(String message) throws IOException;

    /*
     * recieveMessage method
     * to recieve messege sent from the other side
     */
    public String recieveMessage() throws IOException;

    /*
     * disconnect method
     * to disconnect the connection with the other side
     */
    public void disconnect() throws IOException;

    /*
     * isConnected method
     * to check the connection status
     */
    public boolean isConnected() throws IOException;
}
