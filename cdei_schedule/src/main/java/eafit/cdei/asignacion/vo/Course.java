/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.vo;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.Interval;
/**
 *
 * @author jpramire
 */
public class Course {
    
    private LocalTime hourStartLocal;
    private LocalTime hourEndLocal;

    private LocalTime dateStartLocal;
    private LocalTime dateEndLocal;
    
    private String hourStart;
    private String hourEnd;
    
    private String days;
    private String codeCourse;
    private String nameCourse;
    private String group;
    private String level;
    
    private String location;
    
    private String courseType;
    private int hoursPerWeek;
    
    private List<Interval> meetTimeIntervals;
    private List<DayOfWeek> dowList;
    
    public Course ()
    {

        dowList = new ArrayList<>();
    }
    
    //4 Regular
    //6 Horas
    //10 Horas Intensivo
    private void calculateHoursPerWeek()
    {
        long minutes = ChronoUnit.MINUTES.between(hourStartLocal, hourEndLocal);
        long hours = ChronoUnit.HOURS.between(hourStartLocal, hourEndLocal);
        long duration = ChronoUnit.MINUTES.between(hourStartLocal, hourEndLocal);
        

        
        setHoursPerWeek((int)Duration.ofMinutes(duration*dowList.size()).toHours());
        
        if(hoursPerWeek==10)
        {
            courseType = "Intensivo";
        }else if(hoursPerWeek==6){
            courseType = "Semi-intensivo";
        }else
        {
            courseType = "Regular";    
        }
    }
    
    private String getLevel()
    {
        try {
            String [] temp = nameCourse.split(" ");
            level = romanToDecimal ( temp[1] );
        } catch (Exception e) {   
        }
        return level;
    }
    

    /**
     * @return the hourStartLocal
     */
    public LocalTime getHourStartLocal() {
        return hourStartLocal;
    }

    /**
     * @param hourStartLocal the hourStartLocal to set
     */
    public void setHourStartLocal(LocalTime hourStartLocal) {
        this.hourStartLocal = hourStartLocal;
    }

    /**
     * @return the hourEndLocal
     */
    public LocalTime getHourEndLocal() {
        return hourEndLocal;
    }

    /**
     * @param hourEndLocal the hourEndLocal to set
     */
    public void setHourEndLocal(LocalTime hourEndLocal) {
        this.hourEndLocal = hourEndLocal;
    }




    /**
     * @return the hourStart
     */
    public String getHourStart() {
        return hourStart;
    }

    /**
     * @param hourStart the hourStart to set
     */
    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    /**
     * @return the hourEnd
     */
    public String getHourEnd() {
        return hourEnd;
    }

    /**
     * @param hourEnd the hourEnd to set
     */
    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    /**
     * @return the days
     */
    public String getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * @return the codeCourse
     */
    public String getCodeCourse() {
        return codeCourse;
    }

    /**
     * @param codeCourse the codeCourse to set
     */
    public void setCodeCourse(String codeCourse) {
        this.codeCourse = codeCourse;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
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

    /**
     * @return the nameCourse
     */
    public String getNameCourse() {
        return nameCourse;
    }

    /**
     * @param nameCourse the nameCourse to set
     */
    public void setNameCourse(String nameCourse) {
        
        this.nameCourse = nameCourse;
    }

    /**
     * @return the courseType
     */
    public String getCourseType() {
        return courseType;
    }

    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    /**
     * @return the dowList
     */
    public List<DayOfWeek> getDowList() {
        return dowList;
    }

    /**
     * @param dowList the dowList to set
     */
    public void setDowList(List<DayOfWeek> dowList) {
        this.dowList = dowList;
    }

    @Override
    public String toString() {
        return "Nombre:"+ nameCourse +" hours per week:" +getHoursPerWeek() + " days:"+getDowList()
          + " level:" +  getLevel()    + " hours:" + hourStart + "-" +hourEnd + " type:"+courseType 
                + " dateStart " + " dateStart" ; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the hoursPerWeek
     */
    public int getHoursPerWeek() {
        if(hoursPerWeek==0)
        {
            calculateHoursPerWeek();
        }
        return hoursPerWeek;
    }

    /**
     * @param hoursPerWeek the hoursPerWeek to set
     */
    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
    
    /*
    public List<Interval> getMeetTimeIntervals()
    {
        if (meetTimeIntervals == null)
        {
            List<String> days = new ArrayList<String>();
            for (int x = 0; x<= 5; x++)
            {
                switch (x) {
                    case 0: {
                        if (this.getMonday() != null && this.getMonday().equals(1))
                        {
                            days.add("Monday");
                        }
                        break;
                    }
                    case 1: {
                        if (this.getTuesday() != null && this.getTuesday().equals(1))
                        {
                            days.add("Tuesday");
                        }
                        break;
                    }
                    case 2: {
                        if (this.getWednesday() != null && this.getWednesday().equals(1))
                        {
                            days.add("Wednesday");
                        }
                        break;
                    }
                    case 3: {
                        if (this.getThursday() != null && this.getThursday().equals(1))
                        {
                            days.add("Thursday");
                        }
                        break;
                    }
                    case 4: {
                        if (this.getFriday() != null && this.getFriday().equals(1))
                        {
                            days.add("Friday");
                        }
                        break;
                    }
                    case 5: {
                        if (this.getSaturday() != null && this.getSaturday().equals(1))
                        {
                            days.add("Saturday");
                        }
                        break;
                    }
                }
            }
            //meetTimeIntervals = IntervalGenerator.getIntervals(days, getStartTimeVal(), getStopTimeVal());
        }
        return meetTimeIntervals;
    }*/
    
    
     public String romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = CheckRoman(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = CheckRoman(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = CheckRoman(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = CheckRoman(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = CheckRoman(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = CheckRoman(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = CheckRoman(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal+"";
    }
     
     
    public int CheckRoman(int TotalDecimal, int LastRomanLetter, int LastDecimal) 
    {
        if (LastRomanLetter > TotalDecimal) {
            return LastDecimal - TotalDecimal;
        } else {
            return LastDecimal + TotalDecimal;
        }
    }


    /**
     * @param meetTimeIntervals the meetTimeIntervals to set
     */
    public void setMeetTimeIntervals(List<Interval> meetTimeIntervals) {
        this.meetTimeIntervals = meetTimeIntervals;
    }

    /**
     * @return the dateStartLocal
     */
    public LocalTime getDateStartLocal() {
        return dateStartLocal;
    }

    /**
     * @param dateStartLocal the dateStartLocal to set
     */
    public void setDateStartLocal(LocalTime dateStartLocal) {
        this.dateStartLocal = dateStartLocal;
    }

    /**
     * @return the dateEndLocal
     */
    public LocalTime getDateEndLocal() {
        return dateEndLocal;
    }

    /**
     * @param dateEndLocal the dateEndLocal to set
     */
    public void setDateEndLocal(LocalTime dateEndLocal) {
        this.dateEndLocal = dateEndLocal;
    }
    
    
}
