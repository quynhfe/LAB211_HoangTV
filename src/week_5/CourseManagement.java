/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class CourseManagement {

    Validation v = new Validation();
    ArrayList<Course> courseList = new ArrayList();
//    ArrayList<Course> onlineList = new ArrayList<>();
//    ArrayList<Course> offlineList = new ArrayList<>();

    public void menuAll() throws ParseException {
        String[] menu = new String[]{
            "Add online course/ offline course",
            "Update course",
            "Delete course",
            "Print all online course / offline course",
            "Print all course",
            "Search information base on course name",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Information Management");
            switch (choice) {
                case 1: {
                    addCourse();
                    break;
                }
                case 2: {
                    update();
                    break;
                }
                case 3: {
                    String id = v.getValidStringHaveNumber("Enter course id:");
                    delete(id);
                    break;
                }
                case 4: {
                    printByType();
                    break;
                }
                case 5: {
                    printAll(courseList, "Course List");
                    break;
                }
                case 6: {
                    String name = v.getValidString("Enter Name:");
                    search(name);
                    break;
                }

                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

    public void updateOnlineCourse(OnlineCourse course) {
        String platform, instructors, note;
        do {
            platform = v.getValidStringCanHaveEnter("Platform");
            if (platform.trim().isEmpty()) {
                break;
            }
            course.setPlatform(platform);
            break;
        } while (true);
        do {
            instructors = v.getValidStringCanHaveEnter("Instructors");
            if (instructors.trim().isEmpty()) {
                break;
            }
            course.setInstructors(instructors);
            break;
        } while (true);
        do {
            note = v.getValidStringCanHaveEnter("Note");
            if (note.trim().isEmpty()) {
                break;
            }
            course.setNote(note);
            break;
        } while (true);
    }

    public void updateOfflineCourse(OfflineCourse course) throws ParseException {
        String teacherName, campus;
        Date begin, end;
        do {
            teacherName = v.getValidStringCanHaveEnter("Teacher");
            if (teacherName.trim().isEmpty()) {
                break;
            }
            course.setTecherName(teacherName);
            break;
        } while (true);
        do {
            campus = v.getValidStringCanHaveEnter("Campus");
            if (campus.trim().isEmpty()) {
                break;
            }
            course.setCampus(campus);
            break;
        } while (true);
        do {
            begin = v.getValidDateOrNull("Date begin");
            if (campus.trim().isEmpty()) {
                break;
            }
            course.setBegin(begin);
            break;
        } while (true);
        do {
            end = v.getValidDateOrNull("Date end");
            if (campus.trim().isEmpty()) {
                break;
            }
            if (end.after(course.getBegin())) {
                course.setBegin(begin);
                break;
            }
        } while (true);
    }

    public void update() throws ParseException {
        printAll(courseList, "Course List");
        String id;
        Course c = null;
        do {
            id = v.getValidStringHaveNumber("Enter id:");
            c = getCourse(id);
            if (c != null) {
                System.out.println(c.toString());
            } else {
                String choice = v.getYesNo("No data found, do you want to find again? (Y/N):");
                if (choice.equalsIgnoreCase("N")) {
                    return;
                }
            }
        } while (c == null);
        String name;
        do {
            name = v.getInput("Course Name or Enter empty if you don't want to change it.");
            if (name.isEmpty()) {
                break;
            }
            if (!name.equalsIgnoreCase(c.getName())) {
                c.setName(name);
                break;
            } else {
                System.out.println("Course name is existed");
            }
        } while (true);

        int credit = Integer.parseInt(v.getInput("Credit or Enter empty if you don't want to change it."));
        if (credit != -1) {
            c.setCredit(credit);
        }
        if (c instanceof OnlineCourse) {
            OnlineCourse online = (OnlineCourse) c;
            updateOnlineCourse(online);
        }
        if (c instanceof OfflineCourse) {
            OfflineCourse offline = (OfflineCourse) c;
            updateOfflineCourse(offline);
        }

    }

    public void addCourse() throws ParseException {
        boolean isAddOnlineCourse = v.getOption("Online (O) or Offline (F):", new String[]{"O", "F"}).equalsIgnoreCase("o");
        Course course = isAddOnlineCourse ? new OnlineCourse() : new OfflineCourse();

        do {
            course.setId(v.getValidStringHaveNumber("Enter ID"));
        } while (getCourse(course.getId()) != null);
        do {
            course.setName(v.getValidString("Enter name"));
        } while (isNameExisted(courseList, course.getName()));
        course.setCredit(v.getIntLimit("Enter credit", 1, Integer.MAX_VALUE));

        if (course instanceof OnlineCourse) {
            OnlineCourse o = (OnlineCourse) course;
            o.setPlatform(v.getValidString("Enter platform"));
            o.setInstructors(v.getValidString("Enter instructors"));
            o.setNote(v.getValidString("Enter note"));
        } else {
            OfflineCourse o = (OfflineCourse) course;
            o.setTecherName(v.getValidString("Enter teacher name"));
            o.setCampus(v.getValidString("Enter campus"));
            o.setBegin(v.getDateBeforeNow("Date begin"));
            o.setEnd(v.getDateAfterAnotherDate("Date end", o.getBegin()));
        }
        courseList.add(course);
    }

    public Course getCourse(String id) {
        for (Course c : courseList) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public void printByType() {
        String option = v.getOption("Print Online (O) or Offline (F):", new String[]{"O", "F"});
        ArrayList<Course> filteredList = new ArrayList<>();

        for (Course c : courseList) {
            if ((option.equalsIgnoreCase("O") && c instanceof OnlineCourse)
                    || (option.equalsIgnoreCase("F") && c instanceof OfflineCourse)) {
                filteredList.add(c);
            }
        }
        printAll(filteredList, option.equalsIgnoreCase("O") ? "Online Courses" : "Offline Courses");
    }

    public void printAll(ArrayList<Course> c, String title) {
        if (c.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("======== " + title + " ========");
            for (Course item : c) {
                System.out.println(item);
            }
        }
    }

    public Course search(String name) {
        if (courseList.isEmpty()) {
            System.out.println("CourseList is emty");
            return null;
        }
        for (Course c : courseList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        System.out.println("Not found any course");
        return null;
    }

    public void delete(String id) {
        Course c = getCourse(id);
        if (c != null) {
            courseList.remove(c);
        } else {
            System.out.println("Course not existed.");
        }

    }

    public boolean isNameExisted(ArrayList<Course> c, String name) {
        for (Course course : c) {
            if (course.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
