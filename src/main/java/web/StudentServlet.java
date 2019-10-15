package web;

import dao.BookDao;
import dao.StudentDao;
import models.Book;
import models.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;
    private BookDao bookDao;

    public void init() {
        studentDao = new StudentDao();
        bookDao = new BookDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                case "/books":
                    listOfBooks(request, response);
                    break;
                case "/new_book":
                    insertBook(request, response);
                    break;
                default:
                    listOfStudents(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listOfBooks(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listOfBooks = bookDao.getAllBooks();
        request.setAttribute("listOfBooks", listOfBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("books-list.jsp");
        dispatcher.forward(request, response);
    }

    private void listOfStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> listOfStudents = studentDao.getAllStudents();
        request.setAttribute("listOfStudents", listOfStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDao.getStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);

    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        Student newStudent = new Student(name, email, age);
        studentDao.saveStudent(newStudent);
        response.sendRedirect("list");
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Book newBook = new Book(author, title);
        bookDao.saveBook(newBook);
        response.sendRedirect("books");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        Student student = new Student(id, name, email, age);
        studentDao.updateStudent(student);
        response.sendRedirect("list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDao.deleteStudent(id);
        response.sendRedirect("list");
    }
}