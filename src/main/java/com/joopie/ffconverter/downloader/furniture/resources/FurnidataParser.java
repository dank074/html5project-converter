package com.joopie.ffconverter.downloader.furniture.resources;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.net.URL;

/**
 * Azure Camera Server - Furni Sprite Extractor
 * Written by Scott Stamp (scottstamp851, scott@hypermine.com)
 */

public class FurnidataParser {
    public static Furnidata getFurnidata() throws JAXBException, IOException {
        return getFurnidata(new URL("https://www.habbo.com/gamedata/furnidata_xml/1"));
    }

    public static Furnidata getFurnidata(URL sourceURL) throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Furnidata.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource src = new StreamSource(sourceURL.openStream());
        return ((Furnidata) unmarshaller.unmarshal(src));
    }

}
