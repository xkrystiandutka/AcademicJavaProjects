package edu.lab03;

import java.util.ArrayList;
import java.util.List;

public class CBusRoute {
    private Integer number;
    private static String company;
    private List<CBusStop> route;
    {
        route = new ArrayList<>();
    }

    static {
        company = "MPK Krakow";
    }

    public CBusRoute(Integer number) {
        this.number = number;
    }

    public void addBusStop(String name) {
        route.add(new CBusStop(name));
    }

    public void addBusStop(String name, String ...changes) {
        route.add(new CBusStop(name, changes));
    }

    public void addBusStop(String name, int nextMeters, float nextMinutes) {
        route.add(new CBusStopNext(name, nextMeters, nextMinutes));
    }

    public void addBusStop(String name, int nextMeters, float nextMinutes, String ...changes) {
        route.add(new CBusStopNext(name, nextMeters, nextMinutes, changes));
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(" POJAZD NR. " + this.number + ". Przewoznik: " + company + ". Trasa:\n");
        for (CBusStop bs : route) {
            info.append(bs.toString());
            if(!(bs instanceof CBusStopNext)) info.append("\n");
        }
        return info.toString();
    }
}
