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
import com.mavrk.jlm.core.message.filters.FilterTypes;
import com.mavrk.jlm.whiteboard.core.WhiteBoardInterface;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author mavrk
 */

/*
 * this class provides methods for sending control commands to the 
 * remote white board.
 */
public class RemoteBoardController implements WhiteBoardInterface {

    // the control message object
    private Message controlMessage = null;

    /*
     * constructo with control message object as argument
     */
    public RemoteBoardController(Message message) {
        this.controlMessage = message;
    }

    /*
     * method to send draw command
     */
    public void drawOntoBoard(int x, int y) {
        controlMessage.sendMessage(""
                + (char) FilterTypes.CONTROL_FILTER
                + (char) CommandType.DRAW_ONTO_BOARD
                + (char) x
                + (char) y);
    }

    /*
     * method to send resize board command
     */
    public void resizeBoard(int width, int height) {
        controlMessage.sendMessage(""
                + (char) FilterTypes.CONTROL_FILTER
                + (char) CommandType.RESIZE_BOARD
                + (char) width
                + (char) height);
    }

    /*
     * method to send clear board command
     */
    public void clearBoard() {
        controlMessage.sendMessage(""
                + (char) FilterTypes.CONTROL_FILTER
                + (char) CommandType.CLEAR_BOARD);
    }

    /*
     * method to send board image command ####### NOT YET IMPLIMENTED ######
     */
    public void setBoardImage(BufferedImage boardImage) {
        /*int[] rgbArray = new int[boardImage.getWidth()*boardImage.getHeight()];
         boardImage.getRGB(0, 0, boardImage.getWidth(), boardImage.getHeight(), rgbArray, 0, boardImage.getWidth());
        
         controlMessage.sendMessage(""
         + (char) FilterTypes.CONTROL_FILTER
         + (char) CommandType.SET_BOARD_IMAGE
         + boardImage.);*/
    }

    /*
     * method to send set chalk color command
     */
    public void setChalkColor(Color chalkColor) {
        controlMessage.sendMessage(""
                + (char) FilterTypes.CONTROL_FILTER
                + (char) CommandType.SET_CHALK_COLOR
                + (char) chalkColor.getRed()
                + (char) chalkColor.getGreen()
                + (char) chalkColor.getBlue());
    }

    /*
     * method to send set chalk size command
     */
    public void setChalkSize(int chalkSize) {
        controlMessage.sendMessage(""
                + (char) FilterTypes.CONTROL_FILTER
                + (char) CommandType.SET_CHALK_SIZE
                + (char) chalkSize);
    }

    /*
     * method to send set board color command
     */
    public void setBoardColor(Color boardColor) {
        controlMessage.sendMessage(""
                + (char) FilterTypes.CONTROL_FILTER
                + (char) CommandType.SET_BOARD_COLOR
                + (char) boardColor.getRed()
                + (char) boardColor.getGreen()
                + (char) boardColor.getBlue());
    }

    // getter and setter for control message
    public Message getControlMessage() {
        return controlMessage;
    }

    public void setControlMessage(Message controlMessage) {
        this.controlMessage = controlMessage;
    }
}
