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

/**
 *
 * @author mavrk
 */

/*
 * FilterTypes.java
 * 
 * this final class provides text filter types
 */
public final class FilterTypes {

    // text filter for chat messages
    public static final int TEXT_FILTER = 40000;
    // control filter for whiteboard control messages
    public static final int CONTROL_FILTER = 40001;
    // message type value location index 
    //- index where the type value is present in the recieved string message
    public static final int TYPE_LOC_INDEX = 0;
}
