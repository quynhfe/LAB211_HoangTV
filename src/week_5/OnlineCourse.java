/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

/**
 *
 * @author ADMIN
 */
public class OnlineCourse extends Course{
       private String platform, instructors, note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }
    
    public void inputAll( String id, String name, int credit,String platform, String instructors, String note) {
        super.inputAll(id, name, credit);
        this.platform = platform;
        this.instructors = instructors;
        this.note = note;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nPlatform: " + platform + "\nInstructors: " + instructors + "\nNote: " + note;
    }
}
