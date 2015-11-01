/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignasion.logic.contract;

import eafit.cdei.asignacion.vo.Teacher;
import java.util.List;

/**
 *
 * @author jpramire
 */
public interface LoadTeacherPreferences {
    
   public List<Teacher> loadTeacherPreferences() throws Exception ;
    
}
