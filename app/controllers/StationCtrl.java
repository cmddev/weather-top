package controllers;

import models.Reading;
import models.Station;

import play.Logger;
import play.mvc.Controller;
import utils.StationDataConversions;

import java.util.Date;


import static utils.StationDataConversions.weatherCondition;
import static utils.StationDataConversions.weatherIcons;
import static utils.StationDataConversions.beaufortScale;
import static utils.StationDataConversions.windCompass;

/**
 * The StationCtrl Class acts as a key component in interfacing between the Models and Views.
 * As the class name suggests it acts as a controller for the components of the station.
 *
 * @author Caroline Daly
 */

public class StationCtrl extends Controller {

    /**
     * deleteReading method allows for a specific reading to be deleted and persisted.
     *
     * @param id, readingid
     * @return none
     */

    //    Delete Reading from a station.
    public static void deletereading(Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info("Removing " + reading.code);

        station.readings.remove(reading);
        station.save();
        reading.delete();

        render("station.html", station);
    }

    /**
     * addNewReading method allows for a reading to be added to a given station and persisted. The addNewReading
     * tracks the system date and time that the new reading is added.
     *
     * @param id
     * @param code
     * @param temperature
     * @param windSpeed
     * @param windDirection
     * @param pressure
     */
    //    Add reading to station list
    public static void addNewReading(Long id, int code, double temperature, double windSpeed, double windDirection, double pressure) {
        //adding system date and time for new readings
        Date date = new Date(System.currentTimeMillis());
        Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure, date);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        Logger.info("adding new station reading " + code + " and " + temperature + " and " + windSpeed + " and " + windDirection + " and " + pressure);
        redirect("/stations/" + id);
    }

    /**
     * A method that loops through the available readings and outputs latest readings as specified to the dashboard of the given station.
     * This interacts with the utilils.StationDataConversions class.
     * @param id
     */
    public static void index(Long id) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);

        //calling static methods  - <class-name>.<method name>
        if (station.readings.size() > 0) {
            //temperature related latest and min/max readings
            station.latestTempCelsius = StationDataConversions.getLatestTempCelsius(station.readings);
            station.latestTempFahrenheit = StationDataConversions.getLatestTempFahrenheit(station.readings);
            station.minTempCelsius = StationDataConversions.getMinTempCelsius(station.readings);
            station.maxTempCelsius = StationDataConversions.getMaxTempCelsius(station.readings);
            //Weather condition latest readings
            station.latestWeatherCondition = weatherCondition(StationDataConversions.getLatestWeatherCode(station.readings));
            station.latestWeatherIcons = weatherIcons(StationDataConversions.getLatestWeatherCode(station.readings));
            //Pressure related latest and min/max readings
            station.latestPressure = StationDataConversions.getLatestPressure(station.readings);
            station.minPressure = StationDataConversions.getMinPressure(station.readings);
            station.maxPressure = StationDataConversions.getMaxPressure(station.readings);
            //Wind related latest and min/max readings
            station.latestWindSpeed = StationDataConversions.getLatestWindSpeed(station.readings);
            station.minWindSpeed = StationDataConversions.getMinWindSpeed(station.readings);
            station.maxWindSpeed = StationDataConversions.getMaxWindSpeed(station.readings);
            station.beaufortScale = beaufortScale(StationDataConversions.getLatestWindSpeed(station.readings));
            station.windCompass = windCompass(StationDataConversions.getLatestWindSpeed(station.readings));
            station.windChill = Math.round((13.12 + 0.6215 * station.latestTempCelsius - 11.37 * Math.pow(station.latestWindSpeed, 0.16) + 0.3965 * station.latestTempCelsius * Math.pow(station.latestWindSpeed, 0.16)));
        }
        render("station.html", station);
    }


}
