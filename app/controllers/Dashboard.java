package controllers;

import java.util.List;

import play.Logger;
import play.mvc.Controller;
import models.Member;
import models.Station;

/**
 * The Dashboard Class acts as an interface between the Member, Reading and Station Models and the associated views.
 * Upon receiving requests from the views, it carries out a number of methods:
 * Renders the dashboard for a given member.
 * Allows a member to add a station to their Dashboard.
 * Allows a member to delete a station from their Dashboard.
 *
 */

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Station> stations = member.stations;
        render("dashboard.html", member, stations);
    }

    public static void addStation(String name, double latitude, double longitude) {
        Member member = Accounts.getLoggedInMember();
        Station station = new Station(name,  latitude, longitude);
        member.stations.add(station);
        Logger.info("Adding a new station called " + name + "and " + latitude + "and " + longitude);
        member.save();
        redirect("/dashboard");

    }

    public static void deleteStation(Long id) {
        Member member = Accounts.getLoggedInMember();
        Station station = Station.findById(id);
        member.stations.remove(station);
        Logger.info("Removing " + station.name);
        member.save();
        station.delete();
        redirect("/dashboard");
    }

}
