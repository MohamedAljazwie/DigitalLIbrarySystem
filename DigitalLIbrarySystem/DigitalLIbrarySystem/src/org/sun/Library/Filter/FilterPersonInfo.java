package org.sun.Library.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.Message;
import org.sun.Library.Bean.PersonInfo;
import org.sun.Library.Bean.Phone;
import org.sun.Library.Controler.Member.Author;
import org.sun.Library.Controler.Member.Person;
import org.sun.Library.Controler.Member.Publisher;
import org.sun.Library.Controler.Member.Student;
import org.sun.Library.Controler.Types.Role;


public class FilterPersonInfo implements Filter {
    private String errors = "";
    private String url = "Login.jsp";
    private String name;
    private String email;
    private String address;
    private String phone1;
    private String phone2;
    private String nationalID;
    private String userName;
    private String password;
    private String question;
    private String answer;
    private String qulefication1;
    private String qulefication2;
    private String qulefication3;
    private PersonInfo info;
    private PersonInfo infoError;
    private String role;

    Person person;
    Author author;
    Person student;
    Phone phone;
    Student studentError;
    private HttpSession session;
    private FilterConfig _filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {

        session = ((HttpServletRequest) request).getSession(false);
        Role roleAccess = (Role) session.getAttribute("roleAccess");
        if (session == null || session.isNew()) {
            url = "Login.jsp";
            ((HttpServletResponse) response).sendRedirect(url);
        } else {
            if (roleAccess != Role.Admin) {
                url = "Login.jsp";
                ((HttpServletResponse) response).sendRedirect(url);
            } else {
                try {
                    role = (String) session.getAttribute("Role");
                    session.removeAttribute("Role");
                    System.out.println("Role   is  " + role);
                    //    System.out.println("student   is  " + session.getAttribute("student"));
                    //   System.out.println("Info name    is  " + ((PersonInfo)session.getAttribute("info")).getName());

                    switch (role) {
                    case "Publisher":
                        {
                            if (personInfoErrors(request)) {
                                errors = errors.substring(0, errors.length() - 1);

                                url = "addPublisher.jsp?" + errors;
                                errors = "";
                                //   request.getRequestDispatcher(url).forward(request, response);
                                ((HttpServletResponse) response).sendRedirect(url);
                            } else {
                                sendData(request, response, chain);
                            }

                        }
                        break;
                    case "Author":
                        {
                            if (authorError(request)) {
                                errors = errors.substring(0, errors.length() - 1);
                                url = "addAuthor.jsp?" + errors;
                                errors = "";
                                //   request.getRequestDispatcher(url).forward(request, response);
                                ((HttpServletResponse) response).sendRedirect(url);
                            } else {
                                sendData(request, response, chain);
                            }
                        }
                        break;
                    case "Student":
                        {
                            if (studentError(request)) {
                                errors = errors.substring(0, errors.length() - 1);
                                url = "addStudent.jsp?" + errors;
                                errors = "";
                                ((HttpServletResponse) response).sendRedirect(url);
                                // request.getRequestDispatcher(url).include(request, response);

                            } else
                                sendData(request, response, chain);

                        }
                        break;
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    System.out.println(" \n\n You Have An Error IN Check  Method   in Member Class  \n\n" +
                                       "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                                       "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

                }
            }

        }


    }

    private boolean personInfoErrors(ServletRequest request) {
        boolean state = false;
        try {
            info = new PersonInfo();
            infoError = new PersonInfo();
            phone = new Phone();
            name = request.getParameter("name");
            info.setName(name);
            email = request.getParameter("email");
            info.setEmail(email);
            address = request.getParameter("address");
            info.setAddress(address);
            phone1 =request.getParameter("phone1");
            if (phone1 != null && !phone1.equals(""))
            phone.addNumber(phone1);
            phone2 =request.getParameter("phone2");
        if (phone2 != null && !phone2.equals(""))
                phone.addNumber(phone2);

            info.setPhone(phone);

            if (name == null || name.equals("")) {
                errors += "name=error in Name &";
                infoError.setName("error in Write  Name");
                state = true;
            }
            if (email == null || email.equals("")) {
                errors += "email=error in email &";
                infoError.setEmail("error in Write  Email");
                state = true;
            }
            if (phone1 == null || phone1.equals("")) {
                errors += "phone1=error in phone1 &";
                state = true;
            }

            session.setAttribute("info", info);
            session.setAttribute("infoError", infoError);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(" \n\n You Have An Error IN personInfoErrors  Method   in FilterPersonInfo Class  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

        }
        return state;
    }

    private boolean authorError(ServletRequest request) {
        boolean state = false;
        try {
            qulefication1 = request.getParameter("qulefication1");
            qulefication2 = request.getParameter("qulefication2");
            qulefication3 = request.getParameter("qulefication3");
            Author authorError = new Author();
            if (personInfoErrors(request)) {
                authorError.setInfo(infoError);
                state = true;
            }
            author = new Author(info);
            if (qulefication1 != null && !qulefication1.equals(""))
            author.addQulefication(qulefication1);
            if (qulefication2 != null && !qulefication2.equals(""))
                author.addQulefication(qulefication2);
            if (qulefication3 != null &&!qulefication3.equals(""))
                author.addQulefication(qulefication3);
            session.setAttribute("author", author);
            session.setAttribute("authorError", authorError);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(" \n\n You Have An Error IN authorError  Method   in FilterPersonInfo Class  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

        }
        return state;
    }

    private boolean studentError(ServletRequest request) {
        boolean state = false;
        try {
            nationalID = request.getParameter("nationalID");
            userName = request.getParameter("userName");
            password = request.getParameter("password");
            question = request.getParameter("question");
            answer = request.getParameter("answer");

            studentError = new Student();
            Access access = new Access();
            if (personInfoErrors(request)) {
                studentError.setInfo(infoError);
                state = true;
            }
            student = new Student(nationalID, info, question, answer, new Access(userName, password));
            if (nationalID == null || nationalID.equals("")) {
                errors += "nationaID=error in write nationalID &";
                state = true;
            }
            if (userName == null || userName.equals("")) {
                errors += "userName=error in write userName &";
                access.setUserNmae("userName=error in write userName");
                state = true;
            }
            if (password == null || password.equals("")) {
                errors += "password=error in write password &";
                access.setPassword("password=error in write password");
                state = true;
            }
            studentError.setAccess(access);
            if (question == null || question.equals("")) {
                errors += "question=error in write question &";
                studentError.setQuestion("question=error in write question");
                state = true;
            }
            if (answer == null || answer.equals("")) {
                errors += "answer=error in write answer &";
                studentError.setAnswer("answer=error in write answer");
                state = true;
            }
            session.setAttribute("student", student);
            session.setAttribute("studentError", studentError);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(" \n\n You Have An Error IN studentError  Method   in FilterPersonInfo Class  \n\n" +
                               "\n\n  the Message   is     " + e.getMessage() + "\n\n" + e.toString() +
                               "\n\n LocalizedMessage" + e.getLocalizedMessage() + "\n\n Cause" + e.getCause());

        }
        return state;
    }

    private void sendData(ServletRequest request, ServletResponse respnse, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        Role register = Role.valueOf(role);
        Message message = null;
        switch (register) {
        case Author:
            person = author;
            message = new Message(Role.Author.name(), person);
            break;

        case Publisher:
            person = new Publisher(info);
            message = new Message(Role.Publisher.name(), person);
            break;
        case Student:
            person = student;
            message = new Message(Role.Student.name(), person);
            break;
        }
        request.setAttribute("message", message);
        chain.doFilter(request, respnse);
    }
}
