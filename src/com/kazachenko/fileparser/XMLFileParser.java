package com.kazachenko.fileparser;

import com.kazachenko.model.Link;
import com.kazachenko.model.Links;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/17/2017.
 */
public class XMLFileParser implements FileParser {

    public List<Link> parseLinks(File file){

        List<Link> links = new ArrayList<>();

        try {
            JAXBContext jc = JAXBContext.newInstance(Links.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Links linksFromXML = (Links) unmarshaller.unmarshal(file);
            links = linksFromXML.getLinks();
        } catch (JAXBException e) {
            System.out.println("ERROR: Incorrect file or syntax.");
            System.exit(0);
        }

        return links;
    }
}
