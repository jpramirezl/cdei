/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.vo;

/**
 *
 * @author jpramire
 */
public class LevelCourse {
    
    private String levelName;

    @Override
    public String toString() {
        return levelName; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    /**
     * @return the levelName
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * @param levelName the levelName to set
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
