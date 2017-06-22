package com.kazachenko.fileparser;

import com.kazachenko.model.Link;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

/**
 * Created by admin on 6/13/2017.
 */

public interface FileParser {
    List<Link> parseLinks(File file);
}
