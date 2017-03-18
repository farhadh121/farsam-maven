package com.radio.svc.controllers.admin;

import com.radio.svc.exceptions.FileNotExistsException;
import com.radio.svc.exceptions.RecordLabelNotExistsException;
import com.radio.svc.serviceinterface.IRecordLabelServiceProvider;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 5/26/14
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteRecordLabelController extends AbstractController {

    IRecordLabelServiceProvider recordLabelServiceProvider;

    public IRecordLabelServiceProvider getRecordLabelServiceProvider() {
        return recordLabelServiceProvider;
    }

    public void setRecordLabelServiceProvider(IRecordLabelServiceProvider recordLabelServiceProvider) {
        this.recordLabelServiceProvider = recordLabelServiceProvider;
    }

    //////////////////////////////////////////////////////

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("/admin/recordlabeladmin");
        model.addObject("controller", "deleterecordlabel");

        String recordLabelName = request.getParameter("recordlabelname");

        try{
            recordLabelServiceProvider.deleteRecordLabel(recordLabelName);
            model.addObject("msg", "success");
        }catch ( RecordLabelNotExistsException e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }catch ( FileNotExistsException e ){
            model.addObject("msg", "failed");
            model.addObject("msgbody", e.getMessage());
        }

        return model;

    }
}
