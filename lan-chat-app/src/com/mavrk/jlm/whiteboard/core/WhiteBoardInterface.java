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
package com.mavrk.jlm.whiteboard.core;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author mavrk
 */

/*
 * this interface provides the methods that must be implimented for the whiteboard
 */
public interface WhiteBoardInterface {

    /*
     * method to draw onto the white board at location (x,y)
     */
    public void drawOntoBoard(int x, int y);

    /*
     * method to resize the board
     */
    public void resizeBoard(int width, int height);

    /*
     * method to clear the contents of the board
     */
    public void clearBoard();

    /*
     * method to set an image onto the board
     */
    public void setBoardImage(BufferedImage boardImage);

    /*
     * method to set the chalk color
     */
    public void setChalkColor(Color chalkColor);

    /*
     * method to set the chalk size
     */
    public void setChalkSize(int chalkSize);

    /*
     * method to set the board color
     */
    public void setBoardColor(Color boardColor);
}
