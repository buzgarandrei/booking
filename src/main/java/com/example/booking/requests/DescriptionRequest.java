package com.example.booking.requests;

import com.example.booking.utils.Language;

public class DescriptionRequest {

    private Long id;
    private Language language;
    private String text;

    public DescriptionRequest(Long id, Language language, String text) {
        this.id = id;
        this.language = language;
        this.text = text;
    }

    public DescriptionRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
