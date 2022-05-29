package utils;

import models.Reading;

import java.util.HashMap;
import java.util.List;

/**
 * A utility class that assists to return weather conditions, latest readings, minimum and maximum readings.
 * @author Caroline Daly
 */

public class StationDataConversions {
    public static double beaufortScale;


    /***WEATHER CODE - TRANSLATE TO STRING VALUE OF WEATHER CONDITION (RAIN, CLOUDY, etc.)***/

    /**
     * Returns the latest weather code.
     *
     * @param readings
     * @return int -
     */
    public static int getLatestWeatherCode(List<Reading> readings) {
        Integer latestWeatherCode = null;
        if (readings.size() > 0) {
            for (Reading reading : readings)
                latestWeatherCode = readings.get(readings.size() - 1).code;
        }
        return latestWeatherCode;
    }

    /**
     * Using a java switch expression - evaluates each expression (
     *
     * @param code
     * @return String - defined weather condition
     */
    public static String weatherCondition(int code) {
        switch (code) {
            case 100:
                return "Clear";
            case 200:
                return "Partial Clouds";
            case 300:
                return "Cloudy";
            case 400:
                return "Light Showers";
            case 500:
                return "Heavy Showers";
            case 600:
                return "Rain";
            case 700:
                return "Snow";
            case 800:
                return "Thunder/Struck";
            default:
                return "Unknown Conditions";
        }

    }


    /**
     * Using a hashMap to read a set of numberical (int) codes against a defined set of icons.
     *
     * @param code
     * @return String - UI Icon Output
     */

    public static String weatherIcons(int code) {
        //Create a HashMap object called weatherIcons
        HashMap<Integer, String> weatherIcons = new HashMap<Integer, String>();
        //Add keys and values (Code, Semantic UI Icon)
        weatherIcons.put(100, "sun outline icon");
        weatherIcons.put(200, "cloud sun icon");
        weatherIcons.put(300, "cloud icon");
        weatherIcons.put(400, "cloud sun rain icon");
        weatherIcons.put(500, "cloud showers heavy icon");
        weatherIcons.put(600, "cloud rain icon");
        weatherIcons.put(700, "snowflake icon");
        weatherIcons.put(800, "bolt icon");
        weatherIcons.put(0, "meteor icon");
        return weatherIcons.get(code);
    }

    /***TEMPERATURE METHODS - DETERMINE CELSIUS, FAHRENHEIT, MIN AND MAX TEMPERATURES*/
    /**
     * Taking the list of readings, loops through that list to find the most recent value for temperature.
     *
     * @param readings
     * @return double - most recent temperature in celsius.
     */
    public static double getLatestTempCelsius(List<Reading> readings) {
        // Reading latestReading = null;
        double latestTempCelsius = 0;
        if (readings.size() > 0) {
            latestTempCelsius = readings.get(readings.size() - 1).temperature;
        }
        return latestTempCelsius;
    }

    /**
     * Finds the most recent value for temperature (in celsius) and equates it to Fahrenheit.
     *
     * @param readings
     * @return double - temperature in fahrenheit per the calculation.
     */
    public static double getLatestTempFahrenheit(List<Reading> readings) {
        double latestTempFahrenheit = 0.;
        if (readings.size() > 0) {
            latestTempFahrenheit = ((readings.get(readings.size() - 1).temperature * 9 / 5) + 32);
        }
        return latestTempFahrenheit;
    }

    /**
     * @param readings
     * @return double - minimum temperature of all associated readings.
     */
    public static double getMinTempCelsius(List<Reading> readings) {
        Reading minTempCelsiusReading = null;
        if (readings.size() > 0) {
            minTempCelsiusReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature < minTempCelsiusReading.temperature) {
                    minTempCelsiusReading = reading;
                }
            }
        }
        return minTempCelsiusReading.temperature;
    }

    /**
     * @param readings
     * @return Maximum temperature of all readings
     */
    public static double getMaxTempCelsius(List<Reading> readings) {
        Reading maxTempCelsiusReading = null;
        if (readings.size() > 0) {
            maxTempCelsiusReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature > maxTempCelsiusReading.temperature) {
                    maxTempCelsiusReading = reading;
                }
            }
        }
        return maxTempCelsiusReading.temperature;
    }

    /** PRESSURE Methods */

    /**
     * @param readings
     * @return Most recent pressure readings out of all the associated readings.
     */
    public static double getLatestPressure(List<Reading> readings) {
        double latestPressure = 0;

        if (readings.size() > 0) {
            latestPressure = readings.get(readings.size() - 1).pressure;
        }
        return latestPressure;
    }

    public static double getMinPressure(List<Reading> readings) {
        Reading minPressureReading = null;
        if (readings.size() > 0) {
            minPressureReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure < minPressureReading.pressure) {
                    minPressureReading = reading;
                }
            }
        }
        return minPressureReading.pressure;
    }

    public static double getMaxPressure(List<Reading> readings) {
        Reading maxPressureReading = null;
        if (readings.size() > 0) {
            maxPressureReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure > maxPressureReading.pressure) {
                    maxPressureReading = reading;
                }
            }
        }
        return maxPressureReading.pressure;
    }

    /**
     * WIND - BEAUFORT CONVERSIONS
     */

    public static double getLatestWindSpeed(List<Reading> readings) {
        double latestWindSpeed = 0;

        if (readings.size() > 0) {
            latestWindSpeed = readings.get(readings.size() - 1).windSpeed;
        }
        return latestWindSpeed;
    }

    public static double beaufortScale(double windSpeed) {
        if (windSpeed <= 1) {
            return 0;
            //  beaufortLabel = "Calm";
        } else if (windSpeed > 1 && windSpeed <= 5) {
            return 1;
        } else if (windSpeed > 6 && windSpeed <= 11) {
            return 2;
        } else if (windSpeed > 12 && windSpeed <= 19) {
            return 3;
        } else if (windSpeed > 20 && windSpeed <= 28) {
            return 4;
        } else if (windSpeed > 29 && windSpeed <= 38) {
            return 5;
        } else if (windSpeed > 39 && windSpeed <= 49) {
            return 6;
        } else if (windSpeed > 50 && windSpeed <= 61) {
            return 7;
        } else if (windSpeed > 62 && windSpeed <= 74) {
            return 8;
        } else if (windSpeed > 75 && windSpeed <= 88) {
            return 9;
        } else if (windSpeed > 89 && windSpeed <= 102) {
            return 10;
        } else if (windSpeed > 103 && windSpeed <= 117) {
            return 11;
        } else {
            return 0;
        }
    }

    public static double getMinWindSpeed(List<Reading> readings) {
        Reading minWindSpeedReading = null;
        if (readings.size() > 0) {
            minWindSpeedReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed < minWindSpeedReading.windSpeed) {
                    minWindSpeedReading = reading;
                }
            }
        }
        return minWindSpeedReading.windSpeed;
    }

    public static double getMaxWindSpeed(List<Reading> readings) {
        Reading maxWindSpeedReading = null;
        if (readings.size() > 0) {
            maxWindSpeedReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed > maxWindSpeedReading.windSpeed) {
                    maxWindSpeedReading = reading;
                }
            }
        }
        return maxWindSpeedReading.windSpeed;
    }

//    public static String beaufortLabel(double beaufortScale) {
//        switch (beaufortScale) {
//            case 0:
//                return "Calm";
//            case 1:
//                return "Light Air";
//            case 3:
//                return "Light Breeze";
//            case 4:
//                return "Moderate Breeze";
//            case 5:
//                return "Fresh Breeze";
//            case 6:
//                return "Strong Breeze";
//            case 7:
//                return "Near Gale";
//            case 8:
//                return "Gale";
//            case 9:
//                return "Severe Gale";
//            case 10:
//                return "Strong Storm";
//            case 11:
//                return "Violent Storm";
//            default:
//                return "Find Shelter!";
//        }
//
//    }

    /**
     * WIND - COMPASS DIRECTION
     */
    public static String windCompass(double windDirection) {
        if ((windDirection <= 360 && windDirection >= 348.75) || (windDirection < 11.25 && windDirection >= 0)) {
            return "North";
        } else if (windDirection >= 11.25 && windDirection < 33.75) {
            return "NNE";
        } else if (windDirection >= 33.75 && windDirection < 56.25) {
            return "NE";
        } else if (windDirection >= 56.25 && windDirection < 78.75) {
            return "ENE";
        } else if (windDirection >= 78.75 && windDirection < 101.25) {
            return "East";
        } else if (windDirection >= 101.25 && windDirection < 123.75) {
            return "ESE";
        } else if (windDirection >= 123.75 && windDirection < 146.25) {
            return "SE";
        } else if (windDirection >= 146.25 && windDirection < 168.75) {
            return "SSE";
        } else if (windDirection >= 168.75 && windDirection < 191.25) {
            return "South";
        } else if (windDirection >= 191.25 && windDirection < 213.75) {
            return "SSW";
        } else if (windDirection >= 213.75 && windDirection < 236.25) {
            return "SW";
        } else if (windDirection >= 236.25 && windDirection < 258.75) {
            return "WSW";
        } else if (windDirection >= 258.75 && windDirection < 281.25) {
            return "West";
        } else if (windDirection >= 281.25 && windDirection < 303.75) {
            return "WNW";
        } else if (windDirection >= 303.75 && windDirection < 326.25) {
            return "NW";
        } else if (windDirection >= 326.25 && windDirection < 348.75) {
            return "NNW";
        } else {
            return "Unknown";
        }

    }

}


