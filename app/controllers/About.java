package controllers;

import play.*;
import play.mvc.*;

/**
 * The About Class is used to generate the about.html view.
 */

public class About extends Controller {
    public static void index() {
        Logger.info("Rendering about");
        render("about.html");
    }
}
