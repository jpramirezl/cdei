/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.vo;

import eafit.cdei.util.IntervalGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 *
 * @author jpramire
 */
public class Teacher {
    private List<LevelCourse> listCoursesPreference = null;
    private List<TimeDayLocation> listAvaliability = null;
    private Map<String,TimeDayLocation> mapCoursesAvaliability = null;
    
    private int maxCourses;
    private List<String> preferedTime;

    private String fullName;
    
    private List<Interval> meetTimeIntervals;
       
            
    public Teacher()
    {
        listCoursesPreference = new ArrayList<>();
        listAvaliability = new ArrayList<>();
        fullName = ""; 
        mapCoursesAvaliability= new HashMap<>();
        preferedTime  = new ArrayList<>();
    }
    
    public void addCourseAvaliability(List<TimeDayLocation> pt)
    {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("YY-MM-DDH:mm:ss");
        LocalDate mondayDate = LocalDate.parse("2014-10-20");
        

        meetTimeIntervals = new ArrayList<>();
        
        for (TimeDayLocation tdl : pt) {
            String key = tdl.getDow().dayOfWeek().getAsText()+tdl.getTimeStartString()+tdl.getTimeEndString();
            if(!mapCoursesAvaliability.containsKey(key))
            {
                getMapCoursesAvaliability().put(key, tdl);
                getListAvaliability().add(tdl);
                
                for (int x = 0; x<= 6; x++)
                {    
                    LocalDate tmpStartDate = mondayDate.plusDays(x);
                    String tmpDay = tmpStartDate.toString("EEEE");
                    if (tmpStartDate.dayOfWeek().equals(tdl.getDow().dayOfWeek()))
                    {
                        DateTime tmpStartDateTime = DateTime.parse(tmpStartDate.toString("YY-MM-DD") + tdl.getTimeStart().toString("H:mm:ss"), fmt);
                        DateTime tmpStopDateTime = DateTime.parse(tmpStartDate.toString("YY-MM-DD") + tdl.getTimeEnd().toString("H:mm:ss"), fmt);
                        meetTimeIntervals.add(new Interval(tmpStartDateTime, tmpStopDateTime));
                    }
                }
            }
        }
    }

    /**
     * @return the listCourses
     */
    public List<LevelCourse> getListPreferedCourses() {
        return getListCoursesPreference();
    }

    /**
     * @param listCourses the listCourses to set
     */
    public void setListPreferedCourses(List<LevelCourse> listCourses) {
        this.setListCoursesPreference(listCourses);
    }

    /**
     * @return the listAvaliability
     */
    public List<TimeDayLocation> getListAvaliability() {
        return listAvaliability;
    }

    /**
     * @param listAvaliability the listAvaliability to set
     */
    public void setListAvaliability(List<TimeDayLocation> listAvaliability) {
        this.listAvaliability = listAvaliability;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return this.getFullName() + " preferedCourses:" + getListCoursesPreference().toString() 
                + " availability " +getListAvaliability().toString() + " MaxCour:" +
                maxCourses + " PrefeTime: " +preferedTime.toString() ;
    }

    /**
     * @return the listCoursesPreference
     */
    public List<LevelCourse> getListCoursesPreference() {
        return listCoursesPreference;
    }

    /**
     * @param listCoursesPreference the listCoursesPreference to set
     */
    public void setListCoursesPreference(List<LevelCourse> listCoursesPreference) {
        this.listCoursesPreference = listCoursesPreference;
    }

    /**
     * @return the mapCoursesAvaliability
     */
    public Map<String,TimeDayLocation> getMapCoursesAvaliability() {
        return mapCoursesAvaliability;
    }

    /**
     * @param mapCoursesAvaliability the mapCoursesAvaliability to set
     */
    public void setMapCoursesAvaliability(Map<String,TimeDayLocation> mapCoursesAvaliability) {
        this.mapCoursesAvaliability = mapCoursesAvaliability;
    }

    /**
     * @return the maxCourses
     */
    public int getMaxCourses() {
        return maxCourses;
    }

    /**
     * @param maxCourses the maxCourses to set
     */
    public void setMaxCourses(int maxCourses) {
        this.maxCourses = maxCourses;
    }

    /**
     * @return the preferedTimelocation
     */
    public List<String> getPreferedTime() {
        return preferedTime;
    }

    /**
     * @param preferedTimelocation the preferedTimelocation to set
     */
    public void setPreferedTime(List<String> preferedTime) {
        this.preferedTime = preferedTime;
    }
    
    
    
    
    
    
}
