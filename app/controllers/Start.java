package controllers;

import play.Logger;
import play.mvc.Controller;

/**
 * The Start Class is used to generate the start.html view.
 */

public class Start extends Controller {
    public static void index() {
        Logger.info("Rendering Start");
        render("start.html");
    }
}
