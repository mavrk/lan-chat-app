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
package com.mavrk.jlm.whiteboard.utils;

import java.awt.Color;

/**
 *
 * @author mavrk
 */

/*
 * this class provides method to calculate the contrast color for the jbutton
 * which is used to select chalk and board colors and set their color to the 
 * selected colors. the calculated contrast color is set to the text within the 
 * jbutton else the text dissapears ( eg. the default text color for the jbutton
 * is black and if the user selects black color the jbutton background color is
 * set to black so the text dissappers
 */
public class ContrastColor {

    public static Color getContrastColor(Color color) {
        // Counting the perceptive luminance - human eye favors green color... 
        double a = 1 - (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue()) / 255;

        if (a < 0.5) {
            return Color.BLACK; // bright colors - black font
        } else {
            return Color.WHITE; // dark colors - white font
        }
    }
}
