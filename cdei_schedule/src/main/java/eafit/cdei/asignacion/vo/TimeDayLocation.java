/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.vo;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;




/**
 *
 * @author jpramire
 */
public class TimeDayLocation {
    private DateTime dow;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    
    
    private String timeStartString;
    private String timeEndString;
    
    private String timeMinuteStartString;
    private String timeMinuteEndString;
    
    private String location;
    
    public TimeDayLocation()
    {
        timeMinuteStartString = "00";
        timeMinuteEndString = "00";
    
    }

    /**
     * @return the dow
     */
    public DateTime getDow() {
        return dow;
    }

    /**
     * @param dow the dow to set
     */
    public void setDow(DateTime dow) {
        this.dow = dow;
    }

    /**
     * @return the timeStart
     */
    public LocalTime getTimeStart() {
        return timeStart;
    }

    /**
     * @param timeStart the timeStart to set
     */
    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    /**
     * @return the timeEnd
     */
    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    /**
     * @param timeEnd the timeEnd to set
     */
    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    /**
     * @return the timeStartString
     */
    public String getTimeStartString() {
        return timeStartString;
    }

    /**
     * @param timeStartString the timeStartString to set
     */
    public void setTimeStartString(String timeStartString) {
        this.timeStartString = timeStartString;
    }

    /**
     * @return the timeEndString
     */
    public String getTimeEndString() {
        return timeEndString;
    }

    /**
     * @param timeEndString the timeEndString to set
     */
    public void setTimeEndString(String timeEndString) {
        this.timeEndString = timeEndString;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return " Day:" + dow.dayOfWeek().getAsText() + " TS:" +
                timeStartString  + getTimeMinuteStartString() + " TE: "+timeEndString + getTimeMinuteEndString();
    }

    /**
     * @return the timeMinuteStartString
     */
    public String getTimeMinuteStartString() {
        return timeMinuteStartString;
    }

    /**
     * @param timeMinuteStartString the timeMinuteStartString to set
     */
    public void setTimeMinuteStartString(String timeMinuteStartString) {
        this.timeMinuteStartString = timeMinuteStartString;
    }

    /**
     * @return the timeMinuteEndString
     */
    public String getTimeMinuteEndString() {
        return timeMinuteEndString;
    }

    /**
     * @param timeMinuteEndString the timeMinuteEndString to set
     */
    public void setTimeMinuteEndString(String timeMinuteEndString) {
        this.timeMinuteEndString = timeMinuteEndString;
    }
    
    
    
    
}
