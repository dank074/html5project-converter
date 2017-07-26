package com.joopie.ffconverter.converters.furniture.models;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by jospi on 22-4-2017.
 */
@XmlRootElement(name = "visualizationData")
public class VisualizationXML {
    public static class Visualization {
        public static class Layer {
            private Integer id;
            private Integer alpha;
            private Integer x;
            private Integer y;
            private Double z;
            private String ink;
            private Boolean ignoreMouse;

            @XmlAttribute
            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            @XmlAttribute
            public Integer getAlpha() {
                return alpha;
            }

            public void setAlpha(Integer alpha) {
                this.alpha = alpha;
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
            public Double getZ() {
                return z;
            }

            public void setZ(Double z) {
                this.z = z;
            }

            @XmlAttribute
            public String getInk() {
                return ink;
            }

            public void setInk(String ink) {
                this.ink = ink;
            }

            @XmlAttribute
            public Boolean isIgnoreMouse() {
                return ignoreMouse;
            }

            public void setIgnoreMouse(Boolean ignoreMouse) {
                this.ignoreMouse = ignoreMouse;
            }
        }

        public static class Direction {
            private Integer id;

            private List<Layer> layers;

            @XmlAttribute
            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            @XmlElement(name = "layer")
            public List<Layer> getLayers() {
                return layers;
            }

            public void setLayers(List<Layer> layers) {
                this.layers = layers;
            }
        }

        public static class Color {
            public static class ColorLayer {
                private Integer id;
                private String color;

                @XmlAttribute
                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                @XmlAttribute
                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }
            }

            private Integer id;

            private List<ColorLayer> layers;

            @XmlAttribute
            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            @XmlElement(name = "colorLayer")
            public List<ColorLayer> getLayers() {
                return layers;
            }

            public void setLayers(List<ColorLayer> layers) {
                this.layers = layers;
            }
        }

        public static class Animation {
            public static class AnimationLayer {
                public static class Frame {
                    private Integer id;

                    @XmlAttribute
                    public Integer getId() {
                        return id;
                    }

                    public void setId(Integer id) {
                        this.id = id;
                    }
                }

                private Integer id;
                private Integer loopCount;
                private Integer frameRepeat;

                private List<Frame> frames;
                private List<Integer> frameNumbers;

                @XmlAttribute
                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                @XmlAttribute
                public Integer getLoopCount() {
                    return loopCount;
                }

                public void setLoopCount(Integer loopCount) {
                    this.loopCount = loopCount;
                }

                @XmlAttribute
                public Integer getFrameRepeat() {
                    return frameRepeat;
                }

                public void setFrameRepeat(Integer frameRepeat) {
                    this.frameRepeat = frameRepeat;
                }

                @XmlElement(name = "frame")
                @XmlElementWrapper(name = "frameSequence")
                public List<Frame> getFrames() {
                    return frames;
                }

                public void setFrames(List<Frame> frames) {
                    this.frames = frames;
                }

                @XmlElement(name= "frames")
                public List<Integer> getFrameNumbers() {
                    return frameNumbers;
                }

                public void setFrameNumbers(List<Integer> frameNumbers) {
                    this.frameNumbers = frameNumbers;
                }
            }

            private int id;

            private List<AnimationLayer> layers;

            @XmlAttribute
            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            @XmlElement(name = "animationLayer")
            public List<AnimationLayer> getLayers() {
                return layers;
            }

            public void setLayers(List<AnimationLayer> layers) {
                this.layers = layers;
            }
        }

        private Integer size;
        private Integer layerCount;
        private Integer angle;

        private List<Layer> layers;
        private List<Direction> directions;
        private List<Color> colors;
        private List<Animation> animations;

        @XmlAttribute
        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        @XmlAttribute
        public Integer getLayerCount() {
            return layerCount;
        }

        public void setLayerCount(Integer layerCount) {
            this.layerCount = layerCount;
        }

        @XmlAttribute
        public Integer getAngle() {
            return angle;
        }

        public void setAngle(Integer angle) {
            this.angle = angle;
        }

        @XmlElement(name = "layer")
        @XmlElementWrapper(name = "layers")
        public List<Layer> getLayers() {
            return layers;
        }

        public void setLayers(List<Layer> layers) {
            this.layers = layers;
        }

        @XmlElement(name = "direction")
        @XmlElementWrapper(name = "directions")
        public List<Direction> getDirections() {
            return directions;
        }

        public void setDirections(List<Direction> directions) {
            this.directions = directions;
        }

        @XmlElement(name = "color")
        @XmlElementWrapper(name = "colors")
        public List<Color> getColors() {
            return colors;
        }

        public void setColors(List<Color> colors) {
            this.colors = colors;
        }

        @XmlElement(name = "animation")
        @XmlElementWrapper(name = "animations")
        public List<Animation> getAnimations() {
            return animations;
        }

        public void setAnimations(List<Animation> animations) {
            this.animations = animations;
        }
    }

    private String type;

    private List<Visualization> visualizations;

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "visualization")
    @XmlElementWrapper(name = "graphics")
    public List<Visualization> getVisualizations() {
        return visualizations;
    }

    public void setVisualizations(List<Visualization> visualizations) {
        this.visualizations = visualizations;
    }
}
