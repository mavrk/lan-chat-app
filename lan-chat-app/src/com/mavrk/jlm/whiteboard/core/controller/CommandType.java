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

/**
 *
 * @author mavrk
 */
/*
 * this final class provides the constants for the command message types.
 * for every method defined in the white board interface, there is a command type
 */
public final class CommandType {

    public static final int DRAW_ONTO_BOARD = 30000;
    public static final int RESIZE_BOARD = 30001;
    public static final int CLEAR_BOARD = 30002;
    public static final int SET_BOARD_IMAGE = 30003;
    public static final int SET_CHALK_COLOR = 30004;
    public static final int SET_CHALK_SIZE = 30005;
    public static final int SET_BOARD_COLOR = 30006;
}
