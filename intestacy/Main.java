package edu.lab03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int stops, number;

        CBusRoute bus = new CBusRoute(4);
        CBusRoute tram = new CBusRoute(129);

        bus.addBusStop("Petla", 750, 3.5f);
        bus.addBusStop("Wiadukt");
        bus.addBusStop("Rondo", 1200, 6f, "Nowa Huta", "Krowodrza", "Kleparz");
        bus.addBusStop("Politechnika", 500, 5f);
        bus.addBusStop("Zajezdnia", "Bronowice", "Centrum");

        tram.addBusStop("Dworzec Glowny", 500, 2.5f);
        tram.addBusStop("Galeria Centrum", 600, 3f);
        tram.addBusStop("Politechnika", 1200, 6f, "AGH", "UJ", "Akademia Rolnicza");
        tram.addBusStop("Cmentarz Rakowicki", 400, 2f);
        tram.addBusStop("Wilenska", 400, 2f, "Kurdwanow", "Prokocim");
        tram.addBusStop("Zajezdnia");

        System.out.println(bus);
        System.out.println(tram);

        Scanner input = new Scanner(System.in);
        System.out.print("Proszę podać numer pojazdu: ");
        number = input.nextInt();

        CBusRoute vehicle = new CBusRoute(number);

        System.out.print("Proszę podać liczbę przystanków: ");
        stops = input.nextInt();
        input.nextLine();

        if (stops > 0) {
            int nextMeters = 0;
            float nextMinutes = 0;
            String name, stopExists, changesExist;
            String[] changes = {};

            for (int i = 0; i < stops; i++) {
                System.out.print("Podaj nazwę Przystanku " + (i+1) + ":");
                name = input.nextLine();

                System.out.print("Czy istnieje następny przystanek? (T/N)");
                stopExists = input.next();

                if(stopExists.equalsIgnoreCase("T") || stopExists.equalsIgnoreCase("TAK")) {
                    System.out.print("Podaj odległość następnego przystanku [m]:");
                    nextMeters  = input.nextInt();

                    System.out.print("Podaj czas dojazdu [min]:");
                    nextMinutes = input.nextFloat();

                    input.nextLine();
                }

                System.out.print("Czy są przesiadki? (T/N)");
                changesExist = input.next();

                if(changesExist.equalsIgnoreCase("T") || changesExist.equalsIgnoreCase("TAK")) {
                    System.out.print("Podaj nazwy przesiadek:");
                    input.nextLine();
                    changes = input.nextLine().split("[\\s,]+");
                } else input.nextLine();

                if(changesExist.equalsIgnoreCase("T") || changesExist.equalsIgnoreCase("TAK") && stopExists.equalsIgnoreCase("T") || stopExists.equalsIgnoreCase("TAK")) {
                    vehicle.addBusStop(name, nextMeters, nextMinutes, changes);
                } else if (changesExist.equalsIgnoreCase("T") || changesExist.equalsIgnoreCase("TAK")) {
                    vehicle.addBusStop(name, changes);
                } else if (stopExists.equalsIgnoreCase("T") || stopExists.equalsIgnoreCase("TAK")) {
                    vehicle.addBusStop(name, nextMeters, nextMinutes);
                } else {
                    vehicle.addBusStop(name);
                }

                System.out.println("Dodano przystanek o nazwie: " + name + ", przesiadki: " + ((changes.length > 0 && changesExist.equalsIgnoreCase("T") || changesExist.equalsIgnoreCase("TAK")) ? Arrays.toString(changes) : "-brak-") + ((stopExists.equalsIgnoreCase("T") || stopExists.equalsIgnoreCase("TAK")) ? ", następny przystanek: " + nextMeters + " m, " + nextMinutes + " minut." : ""));
            }

            System.out.println(vehicle);
        } else {
            System.out.println("Utworzono obiekt bez przystanków.");
        }

    }
}
