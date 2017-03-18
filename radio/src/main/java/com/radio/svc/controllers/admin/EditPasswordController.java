package com.radio.svc.controllers.admin;

import com.radio.svc.serviceinterface.IUserServiceProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 7/12/14
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditPasswordController extends AbstractController {

    private IUserServiceProvider userServiceProvider;

    public IUserServiceProvider getUserServiceProvider() {
        return userServiceProvider;
    }

    public void setUserServiceProvider(IUserServiceProvider userServiceProvider) {
        this.userServiceProvider = userServiceProvider;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView model = new ModelAndView("/admin/profileadmin");
        model.addObject("controller", "editpassword");

        String oldPassword = httpServletRequest.getParameter("oldpassword");
        String newPassword = httpServletRequest.getParameter("newpassword");
        String newPasswordConformed = httpServletRequest.getParameter("confirmnewpassword");

        try{
            userServiceProvider.editPassword( ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername(), oldPassword, newPassword, newPasswordConformed );
            model.addObject("msg", "success");
        }catch ( Exception e){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
