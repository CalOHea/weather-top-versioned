package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import utils.StationAnalytics;

@Entity
public class Reading extends Model {
    public int code;
    public double temperature;
    public double windSpeed;
    public int pressure;
    public double windDirection;

    public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

    public String conditions() {
        return StationAnalytics.conditions(code);
    }

    public String conditionsIcon() {
        return StationAnalytics.conditionsIcon(code);
    }

    public double fahrenheit() {
        return StationAnalytics.celsiusToFahrenheit(temperature);
    }

    public int beaufort() {
        return StationAnalytics.windSpeedToBeaufort(windSpeed);
    }

    public String compassDirection() {
        return StationAnalytics.compassDirection(windDirection);
    }

    public double windChill() {
        return StationAnalytics.windChill(windSpeed, temperature);
    }

    public int getCode() {
        return code;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getPressure() {
        return pressure;
    }
}
