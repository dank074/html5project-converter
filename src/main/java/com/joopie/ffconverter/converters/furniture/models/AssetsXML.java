package com.joopie.ffconverter.converters.furniture.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by jospi on 22-4-2017.
 */
@XmlRootElement(name = "assets")
public class AssetsXML {
    public static class Asset {
        private String name;
        private String source;

        private Integer x;
        private Integer y;

        private Boolean flipH;

        @XmlAttribute
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        @XmlAttribute
        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        @XmlAttribute
        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        @XmlAttribute
        public Boolean isFlipH() {
            return flipH;
        }

        public void setFlipH(Boolean flipH) {
            this.flipH = flipH;
        }
    }

    private List<Asset> assets;

    @XmlElement(name = "asset")
    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
