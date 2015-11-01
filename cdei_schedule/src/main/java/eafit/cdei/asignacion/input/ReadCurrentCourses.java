/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.input;

import eafit.cdei.asignacion.vo.Course;
import eafit.cdei.asignacion.vo.LevelCourse;
import eafit.cdei.asignacion.vo.Teacher;
import eafit.cdei.asignacion.vo.TimeDayLocation;
import eafit.cdei.asignasion.logic.contract.LoadCourseOffering;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
public class ReadCurrentCourses implements LoadCourseOffering{

    public List<Teacher> loadCurrentOffering() throws Exception {

        try {
            FileInputStream fileInputStream = new FileInputStream("current_classes.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet worksheet = workbook.getSheet("currentOffering");
           
            boolean keepDoing = true;
            for(int i=0;i<worksheet.getLastRowNum()+1;i++)
            {
                
                HSSFRow row1 = worksheet.getRow(i);
                
                
                HSSFCell cellF1 = row1.getCell((short) 5);
                String f1Val = ((int)cellF1.getNumericCellValue())+"";
                

                
                HSSFCell cellW1 = row1.getCell((short) 22);
                String w1Val = cellW1.getStringCellValue() ;
                
                HSSFCell cellX1 = row1.getCell((short) 23);
                String x1Val = cellX1.getStringCellValue();
                
                HSSFCell cellY1 = row1.getCell((short) 24);
                String y1Val = cellY1.getStringCellValue();
                
                
                HSSFCell cellAU1 = row1.getCell((short) 46);
                String au1Val = ((int)cellAU1.getNumericCellValue())+"";

                HSSFCell cellAW1 = row1.getCell((short) 48);
                String aw1Val = cellAW1.getStringCellValue() ;
                
                


                
                if(f1Val==null||f1Val.length()==0||f1Val.equals("0"))
                {
                    keepDoing = false;
                }
                
                Course c = new Course();
                
                c.setHourStart(f1Val);
                c.setHourEnd(au1Val);
                c.setDowList(generateDaysList(aw1Val));
                c.setNameCourse(x1Val);
                c.setCodeCourse(w1Val);
                c.setCodeCourse(y1Val);
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmm");
                if(au1Val.length()==3)
                {
                    au1Val="0" + au1Val;
                }
                
                if(f1Val.length()==3)
                {
                    f1Val="0" + f1Val;
                }
                
                c.setHourEndLocal(LocalTime.parse(au1Val,dtf));
                c.setHourStartLocal(LocalTime.parse(f1Val,dtf));

                
                c.setDateStartLocal(LocalTime.parse(au1Val,dtf));
                c.setDateEndLocal(LocalTime.parse(aw1Val,dtf));
                

                System.out.println(c);

            }
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
        private List generateDaysList(String days) {
        ArrayList<DayOfWeek> dowList
                = new ArrayList<>();
             
            
            for (int i = 0; i < days.length(); i++) {
                String keyDay = days.substring(i,i+1);
                DayOfWeek dof = null;
                switch (keyDay) {
                    case "L":  dof = DayOfWeek.MONDAY;
                             break;
                    case "M":  dof = DayOfWeek.TUESDAY;
                             break;
                    case "W":  dof = DayOfWeek.WEDNESDAY;
                             break;
                    case "J":  dof = DayOfWeek.THURSDAY;
                             break;
                    case "V":  dof = DayOfWeek.FRIDAY;
                             break;
                    case "s":  dof = DayOfWeek.SATURDAY;
                             break;
                    default: dof = DayOfWeek.MONDAY;
                             break;
                }
                
                dowList.add(dof);
                
            }


        return dowList;
    }
    
    
    public static void main(String[] args) {
        
        try {
            new ReadCurrentOffering().loadCurrentOffering()
                    ;
        } catch (Exception ex) {
            Logger.getLogger(ReadTeacherPreferences.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
