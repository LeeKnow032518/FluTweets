package ru.ibs.flutweets.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class FluTweet {
    private final BigDecimal latitude; // shirota
    private final BigDecimal longitude; // dolgota
    private final LocalDateTime date; // date
    private final String text;

    public FluTweet(BigDecimal latitude, BigDecimal longitude, LocalDateTime date, String text) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.text = text;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FluTweet fluTweet = (FluTweet) o;
        return Objects.equals(latitude, fluTweet.latitude) && Objects.equals(longitude, fluTweet.longitude) && Objects.equals(date, fluTweet.date) && Objects.equals(text, fluTweet.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, date, text);
    }

    @Override
    public String toString() {
        return "FluTweet{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
