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
package com.mavrk.jlm.whiteboard.core.controller;

import com.mavrk.jlm.core.message.Message;
import com.mavrk.jlm.whiteboard.core.boardpanel.WhiteBoardPanel;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author mavrk
 */

/*
 * this class provides method to control(draw and manipulate) the current 
 * white board, according to the recieved control commad
 */
public class CurrentBoardController implements PropertyChangeListener {

    // the white board panel reffernce object
    private WhiteBoardPanel whiteBoardPanel = null;
    // the recieved control message reffernce object
    private Message recievedMessage = null;
    // the message string
    private String messageString = null;
    // the recieved command type
    private int commandType = 0;
    // current and remote chalk size and color 
    private int remoteChalkSize = 0;
    private Color remoteChalkColor = null;
    private int currentChalkSize = 0;
    private Color currentChalkColor = null;

    /*
     * privatising the default constructor there by preventing usage
     */
    private CurrentBoardController() {
    }

    /*
     * constructor with the white board panel and control message references as
     * arguments
     */
    public CurrentBoardController(WhiteBoardPanel whiteBoardPanel, Message recievedMessage) {
        // set the white board panel refernce
        this.whiteBoardPanel = whiteBoardPanel;
        // set the recieved control message refernce
        this.recievedMessage = recievedMessage;
        // set the current class as a listner for the recieved message
        this.recievedMessage.addPropertyChangeListener(this);
        // initilise the current and remote chalk size and color
        // with the white board defaults
        currentChalkColor = whiteBoardPanel.getChalkColor();
        remoteChalkColor = whiteBoardPanel.getChalkColor();
        currentChalkSize = whiteBoardPanel.getChalkSize();
        remoteChalkSize = whiteBoardPanel.getChalkSize();
    }

    /*
     * property change event listner method
     */
    public void propertyChange(PropertyChangeEvent evt) {
        // when ever the recieved message changes 
        //then process the recieved command message
        processRecievedCommand();
    }

    /*
     * method to process the recieved command message
     */
    private void processRecievedCommand() {
        // get the command string
        messageString = recievedMessage.getMessage();
        // get the command type which is the first char in the message string
        commandType = messageString.charAt(0);
        switch (commandType) {
            // if clear command
            case CommandType.CLEAR_BOARD: {
                // clear the white board
                whiteBoardPanel.clearBoard();
            }
            break;
            // if draw command
            case CommandType.DRAW_ONTO_BOARD: {
                // get the current current chalk color and size
                currentChalkColor = whiteBoardPanel.getChalkColor();
                currentChalkSize = whiteBoardPanel.getChalkSize();
                // set the remote chalk color and size to the current white board panel
                whiteBoardPanel.setChalkColor(remoteChalkColor);
                whiteBoardPanel.setChalkSize(remoteChalkSize);
                // draw at the specified location
                // the x and y coordiantes are present at the next two locations of the message string
                whiteBoardPanel.drawOntoBoard(messageString.charAt(1), messageString.charAt(2));
                // reset the white board panel's chalk color and size
                // with the current current chalk color and size
                whiteBoardPanel.setChalkColor(currentChalkColor);
                whiteBoardPanel.setChalkSize(currentChalkSize);
            }
            break;
            // if resize command
            case CommandType.RESIZE_BOARD: {
                // resize the board panel to the specified resolution
                // the width and height are present at the next two locations of the message string
                whiteBoardPanel.resizeBoard(messageString.charAt(1), messageString.charAt(2));
            }
            break;
            // if set board color command
            case CommandType.SET_BOARD_COLOR: {
                // set board color
                whiteBoardPanel.setBoardColor(new Color(messageString.charAt(1), messageString.charAt(2), messageString.charAt(3)));
            }
            break;
            //if set board image command
            case CommandType.SET_BOARD_IMAGE: {
                // ############# NOT YET IMPLIMENTED ###############
            }
            break;
            // if set chalk color command
            case CommandType.SET_CHALK_COLOR: {
                // set remote chalk color
                remoteChalkColor = new Color(messageString.charAt(1), messageString.charAt(2), messageString.charAt(3));
            }
            break;
            // if set chalk size command
            case CommandType.SET_CHALK_SIZE: {
                try {
                    // set the remote chalk size
                    remoteChalkSize = messageString.charAt(1);
                } catch (StringIndexOutOfBoundsException ex) {
                    // try catch to skip runtime error ...                    
                }
            }
            break;
        }
    }

    /*
     * getter and setter for white board panel, control message
     */
    public WhiteBoardPanel getWhiteBoardPanel() {
        return whiteBoardPanel;
    }

    public void setWhiteBoardPanel(WhiteBoardPanel whiteBoardPanel) {
        this.whiteBoardPanel = whiteBoardPanel;
    }

    public Message getControlMessage() {
        return recievedMessage;
    }

    public void setControlMessage(Message controlMessage) {
        this.recievedMessage = controlMessage;
    }
}
