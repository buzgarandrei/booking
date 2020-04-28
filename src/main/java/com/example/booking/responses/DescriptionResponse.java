package com.example.booking.responses;

import com.example.booking.utils.Language;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class DescriptionResponse {

    private Long id;
    private Language language;
    private String text;

    public DescriptionResponse() {
    }

    public DescriptionResponse(Long id, Language language, String text) {
        this.id = id;
        this.language = language;
        this.text = text;
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
