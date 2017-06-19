package com.radio.svc.controllers.common;

import com.radio.svc.serviceinterface.IUserServiceProvider;
import static java.lang.Integer.parseInt;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by farhad on 8/5/14.
 */
public class RegisterationController extends AbstractController {


    private IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView( "/radio/register" );
        model.addObject( "controller", "adduser" );

        String userEmail;
        String password;
        String bornDate;
        String firstName;
        String lastName;

        userEmail = request.getParameter("email");
        password = request.getParameter("password");
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        bornDate = request.getParameter("dob");

        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int ageToYear = year - parseInt(bornDate);
            String finalDob = String.valueOf(ageToYear) + "-01-01";
            Date date = formatter.parse(finalDob);
            userServiceProvider.addUser( userEmail, password, firstName, lastName, date );
            model.addObject("msg", "success");
            //TODO: Redirect the successfull registeration to main page.
            //model.setViewName("");

        }catch (Exception e){
            e.printStackTrace();
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;
    }
}
