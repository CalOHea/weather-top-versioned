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
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station (String name) {
        this.name = name;
    }

    public String getStationName() {
        return name;
    }

    /*
    public static Reading latestReading(List<Reading> readings) {

         Reading latestReading = readings.get(readings.size()-1);
         return latestReading;
    }
     */
    public List<Reading> latestReading() {
        List<Reading> latestReadings = null;
        if (readings.size() > 0) {
            latestReadings = readings.subList(readings.size()  - 1, readings.size());
        }
        return latestReadings;
    }
}
