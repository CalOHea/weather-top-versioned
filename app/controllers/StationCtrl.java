package controllers;

import java.util.List;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

public class StationCtrl extends Controller {

  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
    render("station.html", station);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, double windDirection, int pressure) {
    if (code == 0) {
      flash("error", "Please select a Code from the dropdown");
      redirect("/stations/" + id);
    } else {
      Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
      Station station = Station.findById(id);
      station.readings.add(reading);
      station.save();
      redirect("/stations/" + id);
    }
  }

  public static void deleteReading(Long id, Long readingId) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingId);
    Logger.info("Removing Reading");

    station.readings.remove(reading);
    station.save();
    reading.delete();

    render("station.html", station);
  }
}
