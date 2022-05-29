package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import java.util.Date;

@Entity
public class Reading extends Model {
    //public String title;
    public int code;
    public double temperature;
    public double windSpeed;
    public double windDirection;
    public double pressure;
    public Date date;

    public Reading(int code, double temperature, double windSpeed, double windDirection, double pressure, Date date) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.date = date;

    }



}
