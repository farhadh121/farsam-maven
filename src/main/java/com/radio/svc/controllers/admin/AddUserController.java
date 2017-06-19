package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 6/22/14
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddUserController extends AbstractController {

    private IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView( "/admin/useradmin" );
        model.addObject( "controller", "adduser" );

        String userEmail;
        String password;
        String bornDate;
        String firstName;
        String lastName;

        List<String> userRoles = new LinkedList<String>();

        userEmail = request.getParameter("email");
        password = request.getParameter("password");
        firstName = request.getParameter("firstname");
        lastName = request.getParameter("lastname");
        bornDate = request.getParameter("borndate");

        int count = 0;
        while( true ){

            String roleTemp = request.getParameter("userrole"+count);
            if( roleTemp != null ){
                userRoles.add( roleTemp );
                count++;
            }
            else{
                break;
            }
        }

        try{
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = formatter.parse(bornDate);
            userServiceProvider.addUser( userEmail, password, firstName, lastName, date, userRoles );
            model.addObject("msg", "success");

        }catch (Exception e){
            //e.printStackTrace();
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;
    }
}
