package controllers;

import java.util.List;

import models.Reading;

import play.mvc.Controller;
import play.Logger;

/**
 * The Admin Class is used to generate the admin.html view.
 */

public class Admin extends Controller {
    public static void index() {
        Logger.info("Rendering Admin");
        List<Reading> readings = Reading.findAll();
        render ("admin.html", readings);
    }
}