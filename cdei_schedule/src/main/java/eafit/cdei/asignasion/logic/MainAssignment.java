/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignasion.logic;

import eafit.cdei.asignacion.input.ReadCurrentOffering;
import eafit.cdei.asignacion.input.ReadTeacherAvailability;
import eafit.cdei.asignacion.input.ReadTeacherPreferences;
import eafit.cdei.asignasion.logic.contract.LoadCourseOffering;
import eafit.cdei.asignasion.logic.contract.LoadTeacherPreferences;

/**
 *
 * @author jpramire
 */
public class MainAssignment {
    
    
    public void generateAssignation()
    {
        LoadCourseOffering lco = new ReadCurrentOffering();
        ReadTeacherAvailability lta = new ReadTeacherAvailability();
        LoadTeacherPreferences ltp = new ReadTeacherPreferences();
    
        
        
    
    }
    
}
