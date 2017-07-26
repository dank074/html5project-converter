package com.joopie.ffconverter.converters.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joopie.ffconverter.converters.util.spritesheet.models.SpritesheetJSON;

import java.util.List;
import java.util.Map;

/**
 * Created by jospi on 22-4-2017.
 */
public class FurnitureJSON {
    public static class Asset {
        @JsonIgnore
        private String name;
        private String source;

        private Integer x;
        private Integer y;

        private Boolean flipH;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

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

        public Boolean getFlipH() {
            return flipH;
        }

        public void setFlipH(Boolean flipH) {
            this.flipH = flipH;
        }
    }

    public static class Dimensions {
        private Double x;
        private Double y;
        private Double z;

        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }

        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }

        public Double getZ() {
            return z;
        }

        public void setZ(Double z) {
            this.z = z;
        }
    }

    public static class Visualization {
        public static class Layer {
            @JsonIgnore
            private Integer id;
            private Integer alpha;
            private Integer x;
            private Integer y;
            private Double z;
            private String ink;
            private Boolean ignoreMouse;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getAlpha() {
                return alpha;
            }

            public void setAlpha(Integer alpha) {
                this.alpha = alpha;
            }

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

            public Double getZ() {
                return z;
            }

            public void setZ(Double z) {
                this.z = z;
            }

            public String getInk() {
                return ink;
            }

            public void setInk(String ink) {
                this.ink = ink;
            }

            public Boolean isIgnoreMouse() {
                return ignoreMouse;
            }

            public void setIgnoreMouse(Boolean ignoreMouse) {
                this.ignoreMouse = ignoreMouse;
            }
        }

        public static class Direction {
            @JsonIgnore
            private Integer id;

            private Map<Integer, Layer> layers;
            //private List<Layer> layers;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            /*public List<Layer> getLayers() {
                return layers;
            }

            public void setLayers(List<Layer> layers) {
                this.layers = layers;
            }*/

            public Map<Integer, Layer> getLayers() {
                return layers;
            }

            public void setLayers(Map<Integer, Layer> layers) {
                this.layers = layers;
            }
        }

        public static class Color {
            public static class ColorLayer {
                @JsonIgnore
                private Integer id;
                private Integer color;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getColor() {
                    return color;
                }

                public void setColor(Integer color) {
                    this.color = color;
                }
            }

            @JsonIgnore
            private Integer id;

            //private List<ColorLayer> layers;

            private Map<Integer, ColorLayer> layers;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            /*public List<ColorLayer> getLayers() {
                return layers;
            }

            public void setLayers(List<ColorLayer> layers) {
                this.layers = layers;
            }*/

            public Map<Integer, ColorLayer> getLayers() {
                return layers;
            }

            public void setLayers(Map<Integer, ColorLayer> layers) {
                this.layers = layers;
            }
        }

        public static class Animation {
            public static class AnimationLayer {
                @JsonIgnore
                private Integer id;
                private Integer loopCount;
                private Integer frameRepeat;

                private List<Integer> frames;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getLoopCount() {
                    return loopCount;
                }

                public void setLoopCount(Integer loopCount) {
                    this.loopCount = loopCount;
                }

                public Integer getFrameRepeat() {
                    return frameRepeat;
                }

                public void setFrameRepeat(Integer frameRepeat) {
                    this.frameRepeat = frameRepeat;
                }

                public List<Integer> getFrames() {
                    return frames;
                }

                public void setFrames(List<Integer> frames) {
                    this.frames = frames;
                }
            }

            @JsonIgnore
            private int id;

            //private List<AnimationLayer> layers;

            private Map<Integer, AnimationLayer> layers;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            /*public List<AnimationLayer> getLayers() {
                return layers;
            }

            public void setLayers(List<AnimationLayer> layers) {
                this.layers = layers;
            }*/

            public Map<Integer, AnimationLayer> getLayers() {
                return layers;
            }

            public void setLayers(Map<Integer, AnimationLayer> layers) {
                this.layers = layers;
            }
        }

        private Integer layerCount;
        private Integer angle;

        //private List<Layer> layers;
        //private List<Direction> directions;
        //private List<Color> colors;
        //private List<Animation> animations;

        private Map<Integer, Layer> layers;
        private Map<Integer, Direction> directions;
        private Map<Integer, Color> colors;
        private Map<Integer, Animation> animations;

        public Integer getLayerCount() {
            return layerCount;
        }

        public void setLayerCount(Integer layerCount) {
            this.layerCount = layerCount;
        }

        public Integer getAngle() {
            return angle;
        }

        public void setAngle(Integer angle) {
            this.angle = angle;
        }

        /*public List<Layer> getLayers() {
            return layers;
        }

        public void setLayers(List<Layer> layers) {
            this.layers = layers;
        }

        public List<Direction> getDirections() {
            return directions;
        }

        public void setDirections(List<Direction> directions) {
            this.directions = directions;
        }

        public List<Color> getColors() {
            return colors;
        }

        public void setColors(List<Color> colors) {
            this.colors = colors;
        }

        public List<Animation> getAnimations() {
            return animations;
        }

        public void setAnimations(List<Animation> animations) {
            this.animations = animations;
        }*/

        public Map<Integer, Layer> getLayers() {
            return layers;
        }

        public void setLayers(Map<Integer, Layer> layers) {
            this.layers = layers;
        }

        public Map<Integer, Direction> getDirections() {
            return directions;
        }

        public void setDirections(Map<Integer, Direction> directions) {
            this.directions = directions;
        }

        public Map<Integer, Color> getColors() {
            return colors;
        }

        public void setColors(Map<Integer, Color> colors) {
            this.colors = colors;
        }

        public Map<Integer, Animation> getAnimations() {
            return animations;
        }

        public void setAnimations(Map<Integer, Animation> animations) {
            this.animations = animations;
        }
    }

    private String type = "furniture";
    private String name;
    private String visualizationType;
    private String logicType;

    private String spritesheet;

    private Dimensions dimensions;
    private List<Integer> directions;
    //private List<Asset> assets;
    private Map<String, Asset> assets;
    private Visualization visualization;

    public String getType() {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVisualizationType() {
        return visualizationType;
    }

    public void setVisualizationType(String visualizationType) {
        this.visualizationType = visualizationType;
    }

    public String getLogicType() {
        return logicType;
    }

    public void setLogicType(String logicType) {
        this.logicType = logicType;
    }

    public String getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(String spritesheet) {
        this.spritesheet = spritesheet;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public List<Integer> getDirections() {
        return directions;
    }

    public void setDirections(List<Integer> directions) {
        this.directions = directions;
    }

    /*public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }*/

    public Map<String, Asset> getAssets() {
        return assets;
    }

    public void setAssets(Map<String, Asset> assets) {
        this.assets = assets;
    }

    public Visualization getVisualization() {
        return visualization;
    }

    public void setVisualization(Visualization visualization) {
        this.visualization = visualization;
    }
}
