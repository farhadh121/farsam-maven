package com.radio.svc.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 6/22/14
 * Time: 7:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate( final String hex ){
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

}
