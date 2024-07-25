package model;

public class StudentInfoBean {
    private String studentNo;
    private String name;
    private String year;

    public StudentInfoBean(String studentNo, String name, String year) {
        this.studentNo = studentNo;
        this.name = name;
        this.year = year;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
