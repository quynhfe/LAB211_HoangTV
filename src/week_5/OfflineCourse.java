/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class OfflineCourse extends Course{
      private Date begin, end;
    private String techerName, campus;

    public OfflineCourse() {
        super();
        this.begin = begin;
        this.end = end;
        this.techerName = "";
        this.campus = "";
    }

    public void inputAll(String id, String name, int credit, String teacherName, String campus, Date begin, Date end) {
        super.inputAll(id, name, credit);
        this.begin = begin;
        this.end = end;
        this.techerName = teacherName;
        this.campus = campus;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getTecherName() {
        return techerName;
    }

    public void setTecherName(String techerName) {
        this.techerName = techerName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTeacher Name: " + techerName + "\nCampus: " + campus + "\nBegin: " + begin + "\nEnd: " + end;
    }

}
