package controllers;

import play.*;
import play.mvc.*;

/**
 * The ContactUs Class is used to generate the contactus.html view.
 * @author Caroline Daly
 */

public class ContactUs extends Controller {
    public static void index() {
        Logger.info("Rendering ContactUs");
        render("contactus.html");
    }
}
