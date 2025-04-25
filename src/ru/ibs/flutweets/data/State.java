package ru.ibs.flutweets.data;

import java.math.BigDecimal;
import java.util.Objects;

public class State {
    private final BigDecimal latitude; // shirota
    private final BigDecimal longitude; // dolgota
    private final String name;

    public State(BigDecimal latitude, BigDecimal longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(latitude, state.latitude) && Objects.equals(longitude, state.longitude) && Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, name);
    }

    @Override
    public String toString() {
        return "State{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                '}';
    }
}
