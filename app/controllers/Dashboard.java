package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

import models.Reading;
import models.Station;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends Controller
{

  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();

    List<Station> stations = member.stations;

    render ("dashboard.html", stations);
  }

  public static void addStation (String name) {
    if((name == null) || (name.trim().isEmpty())) {
      flash("error", "Please enter a Station Name");
      redirect("/dashboard");
    } else {
      Logger.info("Adding a new station");
      Member member= Accounts.getLoggedInMember();
      Station station = new Station (name);
      member.stations.add(station);
      member.save();
      redirect ("/dashboard");
    }
  }

}
