/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eafit.cdei.asignacion.input;


import eafit.cdei.asignacion.vo.Teacher;
import eafit.cdei.asignacion.vo.TimeDayLocation;
import eafit.cdei.asignasion.logic.contract.LoadTeacherAvalibility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalTime;


/**
 *
 * @author jpramire
 */
public class ReadTeacherAvailability implements LoadTeacherAvalibility {

    @Override
    public List<Teacher> loadTeacherAvailability () throws Exception {

        try {
            FileInputStream fileInputStream = new FileInputStream("googleDoc.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet worksheet = workbook.getSheet("Form Responses 1");

            boolean keepDoing = true;
            for (int i = 1; i < worksheet.getLastRowNum() + 1; i++) {

                HSSFRow row1 = worksheet.getRow(i);

                HSSFCell cellB1 = row1.getCell((short) 1);
                String b1Val = cellB1.getStringCellValue() + "";

                HSSFCell cellG1 = row1.getCell((short) 6);
                String g1Val = cellG1.getStringCellValue() + "";

                HSSFCell cellH1 = row1.getCell((short) 7);
                String h1Val = cellH1.getStringCellValue() + "";

                HSSFCell cellJ1 = row1.getCell((short) 8);
                String j1Val = cellJ1.getStringCellValue() + "";
                
                HSSFCell cellK1 = row1.getCell((short) 9);
                String k1Val = cellK1.getStringCellValue() + "";

                HSSFCell cellI1 = row1.getCell((short) 10);
                String i1Val = cellI1.getStringCellValue() + "";

                HSSFCell cellL1 = row1.getCell((short) 11);
                String l1Val = cellL1.getStringCellValue() + "";

                HSSFCell cellM1 = row1.getCell((short) 12);
                String m1Val = cellM1.getStringCellValue() + "";

                HSSFCell cellN1 = row1.getCell((short) 13);
                String n1Val = cellN1.getStringCellValue() + "";

                HSSFCell cellO1 = row1.getCell((short) 14);
                String o1Val = cellO1.getStringCellValue() + "";

                HSSFCell cellP1 = row1.getCell((short) 15);
                String p1Val = cellP1.getStringCellValue() + "";

                HSSFCell cellQ1 = row1.getCell((short) 16);
                String q1Val = cellQ1.getStringCellValue() + "";

                HSSFCell cellR1 = row1.getCell((short) 17);
                String r1Val = cellR1.getStringCellValue() + "";

                HSSFCell cellS1 = row1.getCell((short) 18);
                String s1Val = cellS1.getStringCellValue() + "";

                HSSFCell cellT1 = row1.getCell((short) 19);
                String t1Val = cellT1.getStringCellValue() + "";

                HSSFCell cellU1 = row1.getCell((short) 20);
                String u1Val = cellU1.getStringCellValue() + "";

                HSSFCell cellV1 = row1.getCell((short) 21);
                String v1Val = cellV1.getStringCellValue() + "";

                HSSFCell cellW1 = row1.getCell((short) 22);
                String w1Val = cellW1.getStringCellValue() + "";

                HSSFCell cellX1 = row1.getCell((short) 23);
                String x1Val = cellX1.getStringCellValue() + "";

                HSSFCell cellY1 = row1.getCell((short) 24);
                String y1Val = cellY1.getStringCellValue() + "";

                HSSFCell cellZ1 = row1.getCell((short) 25);
                String z1Val = cellZ1.getStringCellValue() + "";

                HSSFCell cellAA1 = row1.getCell((short) 26);
                String aa1Val = cellAA1.getStringCellValue() + "";

                HSSFCell cellAB1 = row1.getCell((short) 27);
                String ab1Val = cellAB1.getStringCellValue() + "";

                if (b1Val.length() == 0) {
                    keepDoing = false;
                } else {
                    Teacher t = new Teacher();
                    t.setFullName(b1Val);

                    t.addCourseAvaliability(generateMTF(getAnswer(g1Val), "06", "08"));
                    t.addCourseAvaliability(generateMTF(getAnswer(h1Val), "08", "10"));
                    t.addCourseAvaliability(generateMTF(getAnswer(i1Val), "10", "12"));
                    t.addCourseAvaliability(generateMTF(getAnswer(j1Val), "12", "14"));
                    t.addCourseAvaliability(generateMTF(getAnswer(k1Val), "14", "16"));

                    t.addCourseAvaliability(generateMWF(getAnswer(l1Val), "06", "08"));
                    t.addCourseAvaliability(generateMWF(getAnswer(n1Val), "08", "10"));
                    t.addCourseAvaliability(generateMWF(getAnswer(m1Val), "10", "12"));
                    t.addCourseAvaliability(generateMWF(getAnswer(o1Val), "12", "14"));
                    t.addCourseAvaliability(generateMWF(getAnswer(p1Val), "14", "16"));

                    t.addCourseAvaliability(generateMTT(getAnswer(q1Val), "18","15", "20","45"));
                    t.addCourseAvaliability(generateMTW(getAnswer(r1Val), "18","30", "20","30"));
                    
                    t.addCourseAvaliability(generateTTT(getAnswer(s1Val), "10","12"));
                    t.addCourseAvaliability(generateTTT(getAnswer(t1Val), "12","14"));
                    t.addCourseAvaliability(generateTTT(getAnswer(u1Val), "14","16"));
                    t.addCourseAvaliability(generateTTT(getAnswer(v1Val), "18","30", "20","30"));
                    
                    
                    t.addCourseAvaliability(generateTTT(getAnswer(w1Val), "06","09"));
                    t.addCourseAvaliability(generateTTT(getAnswer(x1Val), "09","12"));
                    
                    t.addCourseAvaliability(generateWF(getAnswer(y1Val), "06","09"));
                    
                    t.addCourseAvaliability(generateWF(getAnswer(z1Val), "07","00","08","30"));
                    
                    t.addCourseAvaliability(generateTTT(getAnswer(aa1Val), "12","00", "13","30"));
                    t.addCourseAvaliability(generateTTT(getAnswer(ab1Val), "07","00", "08","30"));
                    
                    System.out.println(t);
                }
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getAnswer(String val) {
        String[] valArr = val.split(",");
        if (valArr.length < 2) {
            return null;
        } else {
            return valArr[1].trim();
        }

    }

    private List<TimeDayLocation> generateMTF(String location, String startH, String endH) {
        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {
            TimeDayLocation tdlM = new TimeDayLocation();
            TimeDayLocation tdlT = new TimeDayLocation();
            TimeDayLocation tdlW = new TimeDayLocation();
            TimeDayLocation tdlTH = new TimeDayLocation();
            TimeDayLocation tdlF = new TimeDayLocation();


            
            DateTime now = new DateTime();
            tdlM.setDow(now.withDayOfWeek(DateTimeConstants.MONDAY));
            tdlT.setDow(now.withDayOfWeek(DateTimeConstants.TUESDAY));
            tdlW.setDow(now.withDayOfWeek(DateTimeConstants.WEDNESDAY));

            tdlTH.setDow(now.withDayOfWeek(DateTimeConstants.THURSDAY));
            tdlF.setDow(now.withDayOfWeek(DateTimeConstants.FRIDAY));

            avaliability.add(tdlM);
            avaliability.add(tdlT);
            avaliability.add(tdlW);
            avaliability.add(tdlTH);
            avaliability.add(tdlF);
 
            
            repeatTime(avaliability,startH,endH);

        }

        return avaliability;

    }

    private List<TimeDayLocation> generateMWF(String location, String startH, String endH) {
        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {
            TimeDayLocation tdlM = new TimeDayLocation();
            TimeDayLocation tdlW = new TimeDayLocation();
            TimeDayLocation tdlF = new TimeDayLocation();
            
            DateTime now = new DateTime();
            tdlM.setDow(now.withDayOfWeek(DateTimeConstants.MONDAY));
            tdlW.setDow(now.withDayOfWeek(DateTimeConstants.WEDNESDAY));
            tdlF.setDow(now.withDayOfWeek(DateTimeConstants.FRIDAY));

            avaliability.add(tdlM);
            avaliability.add(tdlW);
            avaliability.add(tdlF);
   
            
            repeatTime(avaliability,startH,endH);

        }

        return avaliability;
    }
    
    private List<TimeDayLocation> generateWF(String location, String startH, String endH) {
        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {

            TimeDayLocation tdlW = new TimeDayLocation();
            TimeDayLocation tdlF = new TimeDayLocation();

            
            DateTime now = new DateTime();
            tdlW.setDow(now.withDayOfWeek(DateTimeConstants.WEDNESDAY));
            tdlF.setDow(now.withDayOfWeek(DateTimeConstants.FRIDAY));


            avaliability.add(tdlW);
            avaliability.add(tdlF);
   
            
            repeatTime(avaliability,startH,endH);

        }

        return avaliability;
    }
    
        private List<TimeDayLocation> generateWF(String location, String startH, String startMinute, String endH, String endMinute) {
        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {

            TimeDayLocation tdlW = new TimeDayLocation();
            TimeDayLocation tdlF = new TimeDayLocation();

            DateTime now = new DateTime();
            tdlW.setDow(now.withDayOfWeek(DateTimeConstants.WEDNESDAY));
            tdlF.setDow(now.withDayOfWeek(DateTimeConstants.FRIDAY));


            avaliability.add(tdlW);
            avaliability.add(tdlF);
   
            
            repeatTime(avaliability,startH,startMinute,endH,endMinute);

        }

        return avaliability;
    }

    public void repeatTime(ArrayList<TimeDayLocation> avaliability, String startH, String endH) {
        for (TimeDayLocation tdl : avaliability) {

            tdl.setTimeStartString(startH);
            tdl.setTimeStart(new LocalTime(Integer.parseInt(startH), 0));
            tdl.setTimeEndString(endH);
            tdl.setTimeEnd(new LocalTime(Integer.parseInt(endH), 0));

        }

    }
    
    public void repeatTime(ArrayList<TimeDayLocation> avaliability,  String startH, String startMinute, String endH, String endMinute) {
        for (TimeDayLocation tdl : avaliability) {

            tdl.setTimeStartString(startH);
            tdl.setTimeMinuteStartString(startMinute);
            tdl.setTimeStart(new LocalTime(Integer.parseInt(startH), Integer.parseInt(startMinute)));
            tdl.setTimeEndString(endH);
            tdl.setTimeMinuteEndString(endMinute);
            tdl.setTimeEnd(new LocalTime(Integer.parseInt(endH), Integer.parseInt(endMinute)));

        }

    }

    private List<TimeDayLocation> generateMTT(String location, String startH, String startMinute, String endH, String endMinute) {
        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {
            TimeDayLocation tdlM = new TimeDayLocation();
            TimeDayLocation tdlT = new TimeDayLocation();
            TimeDayLocation tdlW = new TimeDayLocation();
            TimeDayLocation tdlTH = new TimeDayLocation();


            DateTime now = new DateTime();

            tdlM.setDow(now.withDayOfWeek(DateTimeConstants.MONDAY));
            tdlT.setDow(now.withDayOfWeek(DateTimeConstants.TUESDAY));
            tdlW.setDow(now.withDayOfWeek(DateTimeConstants.WEDNESDAY));
            tdlTH.setDow(now.withDayOfWeek(DateTimeConstants.THURSDAY));

            avaliability.add(tdlM);
            avaliability.add(tdlT);
            avaliability.add(tdlW);
            avaliability.add(tdlTH);

 
            
            repeatTime(avaliability,startH,startMinute,endH,endMinute);

        }

        return avaliability;
    }

    private List<TimeDayLocation> generateMTW(String location, String startH, String startMinute, String endH, String endMinute)  {
        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {
            TimeDayLocation tdlM = new TimeDayLocation();
            TimeDayLocation tdlT = new TimeDayLocation();
            TimeDayLocation tdlW = new TimeDayLocation();



            DateTime now = new DateTime();

            tdlM.setDow(now.withDayOfWeek(DateTimeConstants.MONDAY));
            tdlT.setDow(now.withDayOfWeek(DateTimeConstants.TUESDAY));
            tdlW.setDow(now.withDayOfWeek(DateTimeConstants.WEDNESDAY));

  

            avaliability.add(tdlM);
            avaliability.add(tdlT);
            avaliability.add(tdlW);
 
            repeatTime(avaliability,startH,startMinute,endH,endMinute);

        }

        return avaliability;
    }
    
    

    private List<TimeDayLocation> generateTTT(String location, String startH, String startMinute, String endH, String endMinute)  {

        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {

            TimeDayLocation tdlT = new TimeDayLocation();
            TimeDayLocation tdlTH = new TimeDayLocation();

            DateTime now = new DateTime();
            tdlT.setDow(now.withDayOfWeek(DateTimeConstants.TUESDAY));
            tdlTH.setDow(now.withDayOfWeek(DateTimeConstants.THURSDAY));


            avaliability.add(tdlT);
            avaliability.add(tdlTH);
 
            repeatTime(avaliability,startH,startMinute,endH,endMinute);

        }

        return avaliability;
    }
    
        private List<TimeDayLocation> generateTTT(String location, String startH,String endH)  {

        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        if (location != null) {

            TimeDayLocation tdlT = new TimeDayLocation();

            TimeDayLocation tdlTH = new TimeDayLocation();

            DateTime now = new DateTime();
            tdlT.setDow(now.withDayOfWeek(DateTimeConstants.TUESDAY));
            tdlTH.setDow(now.withDayOfWeek(DateTimeConstants.THURSDAY));


            avaliability.add(tdlT);
            avaliability.add(tdlTH);

 
            repeatTime(avaliability,startH,endH);

        }

        return avaliability;
    }
    
    
    private List<TimeDayLocation> generateWTF(String location, String startH, String endH) {
        ArrayList<TimeDayLocation> avaliability
                = new ArrayList<>();

        return avaliability;
    }

    public static void main(String[] args) {

        try {
            new ReadTeacherAvailability().loadTeacherAvailability ();
        } catch (Exception ex) {
            Logger.getLogger(ReadTeacherPreferences.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
