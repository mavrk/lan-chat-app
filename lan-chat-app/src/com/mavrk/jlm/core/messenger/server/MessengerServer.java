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
package com.mavrk.jlm.core.messenger.server;

import com.mavrk.jlm.core.messenger.MessengerAbstraction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 *
 * @author mavrk
 */
/*
 * MessengerServer.java
 *
 * this class extends from the MessengerAbstraction abstract class
 * and provides the implimentation for the connect method for the server type
 */
public class MessengerServer extends MessengerAbstraction {

    /*
     * connect method as defined in the MessengerInterface
     * used to start the server connection
     */
    public void connect(String ip, int portId) throws IOException {
        // starting the server at port
        this.setServerSocket(new ServerSocket(portId));
        // creating the socket
        this.setSocket(this.getServerSocket().accept());
        // set the inputstream
        this.setInputStream(this.getSocket().getInputStream());
        // set the buffered reader using the input stream; for reading data
        this.setBufferedReader(new BufferedReader(new InputStreamReader(this.getInputStream())));
        // set the print writer; for writing data
        this.setPrintWriter(new PrintWriter(this.getSocket().getOutputStream(), true));
    }
}
