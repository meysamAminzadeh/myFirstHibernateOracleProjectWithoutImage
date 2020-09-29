package controller;

import model.BL.DBOperations.TBL_Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus on 5/17/2020.
 */
public class Register extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name =request.getParameter("name");
        String familly= request.getParameter("familly");


        TBL_Person tbl_person= new TBL_Person();
       // tbl_person.insert(name,familly);
      // tbl_person.saveOrUpdate(name,familly);
      // tbl_person.delete(1);
        // tbl_person.select(name,familly);
       // tbl_person.update(name,familly);
//       tbl_person.deleteWithoutId(4);
        tbl_person.updateJustName(name,6);
        response.sendRedirect("welcome.jsp");



    }
}
