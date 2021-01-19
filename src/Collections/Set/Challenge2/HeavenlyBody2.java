package Collections.Set.Challenge2;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody2 {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody2> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody2(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody2 moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody2> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(obj instanceof HeavenlyBody2) {
           HeavenlyBody2 theObj = (HeavenlyBody2) obj;
            if(this.name.equals(theObj.getName())){
                return this.bodyType.equals(theObj.getBodyType());
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return this.name + " " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
