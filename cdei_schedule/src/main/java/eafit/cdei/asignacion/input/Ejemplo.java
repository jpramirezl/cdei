/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.input;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author jpramire
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               LocalDate mondayDate = LocalDate.parse("2014-10-20");

            String tmpDay = mondayDate.toString("EEEE");
            
            DateTimeFormatter date = DateTimeFormat.forPattern("yyyy-mm-dd");
            DateTimeFormatter time = DateTimeFormat.forPattern("hh:mm:ss");
            
            String day = date.parseDateTime("2015-04-16").dayOfWeek().getAsText();
            System.out.println(tmpDay + "/"+day);
    }
    
}
