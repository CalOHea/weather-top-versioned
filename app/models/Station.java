package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name;
  public double longitude;
  public double latitude;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double longitude, double latitude) {
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public String getStationName() {
    return name;
  }

  public List<Reading> latestReading() {
    List<Reading> latestReadings = null;
    if (readings.size() > 0) {
      latestReadings = readings.subList(readings.size() - 1, readings.size());
    }
    return latestReadings;
  }
}
