package com.kazachenko.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by admin on 6/19/2017.
 */

@XmlRootElement(name = "Links")
@XmlAccessorType(XmlAccessType.FIELD)
public class Links {
    @XmlElement(name = "Link")
    private List<Link> links;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

