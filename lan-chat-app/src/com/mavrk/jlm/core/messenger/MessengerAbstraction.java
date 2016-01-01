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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mavrk
 */
/*
 * MessengerAbstraction.java
 *
 * this abstract class implements those methods of the Messenger
 * which have same implimentation.
 *
 * only the connect method is not implimented in here
 */
public abstract class MessengerAbstraction implements Messenger {

    // server socket object for connction if selected connection type is server
    private ServerSocket serverSocket;
    // a base socket object for both client and server
    private Socket socket;
    // inputstream object for reading reading the data/ message recieved at the socket
    private InputStream inputStream;
    // buffered reader object to provide a wrapper to the inputstream for reading message
    private BufferedReader bufferedReader;
    // print writer object to write message onto the socket
    private PrintWriter printWriter = null;
    // message string object
    private String readMessage = null;

    /*
     * getter and setter for Messenger objects
     *
     * to be used by the classes which extends this Messenger abstraction class
     */
    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /*
     * Messenger Implimentation
     */
    /*
     * send message methos to send message
     */
    public void sendMessage(String message) throws IOException {
        printWriter.println(message);
    }

    /*
     * recieve message to recieve the sent message from the other side
     */
    public String recieveMessage() throws IOException, NullPointerException {
        // using buffered reader to read a line of the message
        readMessage = bufferedReader.readLine();
        // if the read data is null then throw null pointer exception
        if (readMessage == null) {
            throw new NullPointerException();
        }
        // else return the read message string
        return readMessage;
    }

    /*
     * disconnect method to disconnect the socket connection
     */
    public void disconnect() throws IOException {
        // close socket
        socket.close();
        // if server socket is present then close it
        if (serverSocket != null) {
            serverSocket.close();
        }
    }

    /*
     * isConnected method to check the connection status
     */
    public boolean isConnected() throws IOException {
        // return socket connection status
        return socket.isConnected();
    }
}
