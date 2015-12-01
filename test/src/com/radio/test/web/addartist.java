package com.radio.test.web;

import com.radio.svc.serviceinterface.IArtistServiceProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/17/14
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class addartist extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String artistName = req.getParameter("inputArtistName");
        String artistInfo = req.getParameter("inoutArtistInfo");

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        IArtistServiceProvider artistServiceProvider = (IArtistServiceProvider)context.getBean("artistFacede");
        try{
            //artistServiceProvider.addNewArtist(artistName,artistInfo);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
