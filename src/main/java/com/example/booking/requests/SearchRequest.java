package com.example.booking.requests;

import com.example.booking.utils.Language;

public class SearchRequest {
    private String cityName;
    private int nrOfAdults;
    private int nrOfKids;
    private Language language;
    private String dateStart;
    private String dateEnd;

    public SearchRequest() {
    }

    public SearchRequest(String cityName, int nrOfAdults, int nrOfKids, Language language, String dateStart, String dateEnd) {
        this.cityName = cityName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfKids = nrOfKids;
        this.language = language;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfKids() {
        return nrOfKids;
    }

    public void setNrOfKids(int nrOfKids) {
        this.nrOfKids = nrOfKids;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
