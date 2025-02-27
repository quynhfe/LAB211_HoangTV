/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

/**
 *
 * @author ADMIN
 */
public abstract class Course {
        protected String id, name;
    protected int credit;

    public Course() {
        this.id = "";
        this.name = "";
        this.credit = 0;
    }
    

    public void inputAll(String id, String name, int credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course ID:" + id + "\nCourse name: " + name + "\nCredits: " + credit;
    }
}
