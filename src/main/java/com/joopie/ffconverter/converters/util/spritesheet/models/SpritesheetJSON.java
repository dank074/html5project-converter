package com.joopie.ffconverter.converters.util.spritesheet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

/**
 * Created by jospi on 23-4-2017.
 */
public class SpritesheetJSON {
    public static class Rect {
        private Integer x;
        private Integer y;
        private Integer w;
        private Integer h;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        public Integer getW() {
            return w;
        }

        public void setW(Integer w) {
            this.w = w;
        }

        public Integer getH() {
            return h;
        }

        public void setH(Integer h) {
            this.h = h;
        }
    }

    public static class Metadata {
        private String app;
        private String format;
        private String image;
        private String scale;
        private Rect size;
        private String version;

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getScale() {
            return scale;
        }

        public void setScale(String scale) {
            this.scale = scale;
        }

        public Rect getSize() {
            return size;
        }

        public void setSize(Rect size) {
            this.size = size;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class SpriteFrame {
        @JsonIgnore
        private String name;

        private Rect frame;
        private Rect sourceSize;
        private Rect spriteSourceSize;

        private Boolean rotated;
        private Boolean trimmed;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Rect getFrame() {
            return frame;
        }

        public void setFrame(Rect frame) {
            this.frame = frame;
        }

        public Rect getSourceSize() {
            return sourceSize;
        }

        public void setSourceSize(Rect sourceSize) {
            this.sourceSize = sourceSize;
        }

        public Rect getSpriteSourceSize() {
            return spriteSourceSize;
        }

        public void setSpriteSourceSize(Rect spriteSourceSize) {
            this.spriteSourceSize = spriteSourceSize;
        }

        public boolean isRotated() {
            return rotated;
        }

        public void setRotated(boolean rotated) {
            this.rotated = rotated;
        }

        public boolean isTrimmed() {
            return trimmed;
        }

        public void setTrimmed(boolean trimmed) {
            this.trimmed = trimmed;
        }
    }

    private Metadata meta;
    private Map<String, SpriteFrame> frames;

    public Metadata getMeta() {
        return meta;
    }

    public void setMeta(Metadata meta) {
        this.meta = meta;
    }

    public Map<String, SpriteFrame> getFrames() {
        return frames;
    }

    public void setFrames(Map<String, SpriteFrame> frames) {
        this.frames = frames;
    }
}