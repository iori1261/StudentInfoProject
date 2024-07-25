package model;

import java.util.ArrayList;
import java.util.List;

public class StudentRecordBean {
    private List<StudentInfoBean> students = new ArrayList<>();

    public void addStudent(StudentInfoBean student) {
        students.add(student);
    }

    public List<StudentInfoBean> getStudents() {
        return students;
    }
}
