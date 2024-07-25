package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.StudentInfoBean;
import model.StudentRecordBean;

@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNo = request.getParameter("studentNo");
        String name = request.getParameter("name");
        String year = request.getParameter("year");

        if (studentNo == null || name == null || year == null || studentNo.isEmpty() || name.isEmpty() || year.isEmpty()) {
            response.sendRedirect("/StudentInfoProject/errorinfo_input.html");
            return;
        }

        HttpSession session = request.getSession();
        StudentRecordBean record = (StudentRecordBean) session.getAttribute("studentRecord");
        if (record == null) {
            record = new StudentRecordBean();
        }

        // 学生番号の重複チェック
        for (StudentInfoBean student : record.getStudents()) {
            if (student.getStudentNo().equals(studentNo)) {
                response.sendRedirect("/StudentInfoProject/errorinfo_input.html");
                return;
            }
        }

        StudentInfoBean student = new StudentInfoBean(studentNo, name, year);
        record.addStudent(student);
        session.setAttribute("studentRecord", record);

        request.setAttribute("studentCount", record.getStudents().size());
        request.getRequestDispatcher("/WEB-INF/jsp/studentinfo_check.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("view".equals(action)) {
            HttpSession session = request.getSession();
            StudentRecordBean record = (StudentRecordBean) session.getAttribute("studentRecord");
            if (record == null) {
                record = new StudentRecordBean();
            }
            request.setAttribute("studentRecords", record.getStudents());
            request.getRequestDispatcher("/WEB-INF/jsp/studentinfo_output.jsp").forward(request, response);
        } else {
            response.sendRedirect("/StudentInfoProject/studentinfo_input.html");
        }
    }
}
