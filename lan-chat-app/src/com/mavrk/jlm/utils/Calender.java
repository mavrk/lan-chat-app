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
package com.mavrk.jlm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author mavrk
 */
/*
 * Calender.java
 * 
 * this class provides a static method to get the current date and time
 */
public class Calender {

    public static String getCurrentDateAndTime() {
        // set the date format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // get calender instance
        Calendar cal = Calendar.getInstance();
        // return the formated date and time
        return dateFormat.format(cal.getTime());
    }
}
