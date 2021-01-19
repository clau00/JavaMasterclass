package Collections.Set.Challenge2;

import Collections.Set.HeavenlyBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HeavenlyBodyMain {
    private static Map<String, HeavenlyBody2> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody2> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody2 temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody2 tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets:");
        for(HeavenlyBody2 planet : planets){
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody2 body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody2 moon : body.getSatellites()){
            System.out.println("\t" + moon.getName());
        }

        Set<HeavenlyBody2> moons = new HashSet<>();
        for(HeavenlyBody2 planet : planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons:");
        for (HeavenlyBody2 moon : moons){
            System.out.println("\t" + moon.getName());
        }

        HeavenlyBody2 pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);

        for(HeavenlyBody2 planet : planets){
            System.out.println(planet);
//            System.out.println(planet.getName() + " : " + planet.getOrbitalPeriod());
        }

        HeavenlyBody2 earth1 = new Planet("Earth", 365);
        HeavenlyBody2 earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
    }

}
