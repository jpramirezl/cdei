/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.input;

import eafit.cdei.asignacion.vo.LevelCourse;
import eafit.cdei.asignacion.vo.Teacher;
import eafit.cdei.asignasion.logic.contract.LoadTeacherPreferences;
import java.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author jpramire
 */
public class ReadTeacherPreferences implements LoadTeacherPreferences {

    public List<Teacher> loadTeacherPreferences() throws Exception {

        try {
            FileInputStream fileInputStream = new FileInputStream("TeacherPreferences.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet worksheet = workbook.getSheet("Preferences");
           
            boolean keepDoing = true;
            for(int i=1;i<worksheet.getLastRowNum()+1;i++)
            {
                
                HSSFRow row1 = worksheet.getRow(i);
                HSSFCell cellA1 = row1.getCell((short) 0);
                String a1Val = cellA1.getNumericCellValue() + "";
                HSSFCell cellB1 = row1.getCell((short) 1);
                String b1Val = cellB1.getStringCellValue();
                HSSFCell cellC1 = row1.getCell((short) 2);
                String c1Val = cellC1.getStringCellValue();
                
                String d1Val ="";

                 HSSFCell cellD1 = row1.getCell((short) 3);
                    
                 if(cellD1!=null) {  
                    d1Val = cellD1.getStringCellValue();   
                } 


                HSSFCell cellE1 = row1.getCell((short) 4);
                double e1Val = cellE1.getNumericCellValue();


                
                if(a1Val==null||a1Val.length()==0||a1Val.equals("0"))
                {
                    keepDoing = false;
                }
                
                Teacher t = new Teacher();
                t.setFullName(b1Val);
                
                t.setMaxCourses((int) e1Val);
                
                String [] preferedCourses = c1Val.split(",");
                
                ArrayList<LevelCourse> preferedCoursed 
                        = new ArrayList<LevelCourse> ();
                
                for (String preferedCoursed1 : preferedCourses) {
                    LevelCourse lc = new LevelCourse();
                    lc.setLevelName(preferedCoursed1);
                    preferedCoursed.add(lc);
                }
                
                String [] preferedTimes = d1Val.split(",");
                ArrayList<String> preferedTime 
                        = new ArrayList<> ();
                
                for (String pf : preferedTimes) {

                    preferedTime.add(pf);
                }
                
                
                t.setListPreferedCourses(preferedCoursed);
                
                System.out.println(t);

            }
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public static void main(String[] args) {
        
        try {
            new ReadTeacherPreferences().loadTeacherPreferences();
        } catch (Exception ex) {
            Logger.getLogger(ReadTeacherPreferences.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
