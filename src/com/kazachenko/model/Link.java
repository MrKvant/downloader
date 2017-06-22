package com.kazachenko.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by admin on 6/13/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Link {

    private String url;

    private String savingName;

    public Link() {
    }

    public Link(String url, String savingName) {
        this.url = url;
        this.savingName = savingName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSavingName() {
        return savingName;
    }

    public void setSavingName(String savingName) {
        this.savingName = savingName;
    }
}
