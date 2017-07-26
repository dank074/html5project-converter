package com.joopie.ffconverter.converters.furniture;

import com.joopie.ffconverter.converters.furniture.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jospi on 22-4-2017.
 */
public class FurnitureJSONMapper {

    public static final int VISUALIZATION_DEFAULT_SIZE = 64;

    public FurnitureJSON mapXML(AssetsXML assetsXML, IndexXML indexXML, LogicXML logicXML, VisualizationXML visualizationXML) {
        FurnitureJSON result = new FurnitureJSON();
        this.mapAssetsXML(assetsXML, result);
        this.mapIndexXML(indexXML, result);
        this.mapLogicXML(logicXML, result);
        this.mapVisualizationXML(visualizationXML, result);
        return result;
    }

    private void mapAssetsXML(AssetsXML assetsXML, FurnitureJSON output) {
        Map<String, FurnitureJSON.Asset> assets = new HashMap<String, FurnitureJSON.Asset>();
        for (AssetsXML.Asset assetXML : assetsXML.getAssets()) {
            FurnitureJSON.Asset asset = new FurnitureJSON.Asset();
            asset.setName(assetXML.getName());
            asset.setSource(assetXML.getSource());
            asset.setX(assetXML.getX());
            asset.setY(assetXML.getY());
            asset.setFlipH(assetXML.isFlipH());

            assets.put(assetXML.getName(), asset);
        }

        output.setAssets(assets);
    }

    private void mapIndexXML(IndexXML indexXML, FurnitureJSON output) {
        output.setName(indexXML.getType());
        output.setLogicType(indexXML.getLogic());
        output.setVisualizationType(indexXML.getVisualization());
    }

    private void mapLogicXML(LogicXML logicXML, FurnitureJSON output) {
        FurnitureJSON.Dimensions dimensions = new FurnitureJSON.Dimensions();
        dimensions.setX(logicXML.getModel().getDimensions().getX());
        dimensions.setY(logicXML.getModel().getDimensions().getY());
        dimensions.setZ(logicXML.getModel().getDimensions().getZ());
        output.setDimensions(dimensions);

        List<Integer> directions = new ArrayList<Integer>();
        for (LogicXML.Model.Direction directionXML : logicXML.getModel().getDirections()) {
            directions.add(directionXML.getId());
        }
        output.setDirections(directions);
    }

    private VisualizationXML.Visualization getCorrectVisualizationXML(VisualizationXML visualizationXML) {
        for (VisualizationXML.Visualization visXML : visualizationXML.getVisualizations()) {
            if (visXML.getSize() == VISUALIZATION_DEFAULT_SIZE) {
                return visXML;
            }
        }

        throw new RuntimeException("Invalid visualization data");
    }

    private Map<Integer, FurnitureJSON.Visualization.Layer> mapVisualizationLayerXML(List<VisualizationXML.Visualization.Layer> layersXML) {
        Map<Integer, FurnitureJSON.Visualization.Layer> layers = new HashMap<Integer, FurnitureJSON.Visualization.Layer>();
        for (VisualizationXML.Visualization.Layer layerXML : layersXML) {
            FurnitureJSON.Visualization.Layer layer = new FurnitureJSON.Visualization.Layer();
            layer.setId(layerXML.getId());
            layer.setAlpha(layerXML.getAlpha());
            layer.setInk(layerXML.getInk());
            layer.setX(layerXML.getX());
            layer.setY(layerXML.getY());
            layer.setZ(layerXML.getZ());
            layer.setIgnoreMouse(layerXML.isIgnoreMouse());
            layers.put(layerXML.getId(), layer);
        }

        return layers;
    }

    private void mapVisualizationLayerXML(VisualizationXML.Visualization visXML, FurnitureJSON.Visualization output) {
        if (visXML.getLayers() != null && !visXML.getLayers().isEmpty()) {
            Map<Integer, FurnitureJSON.Visualization.Layer> layers = this.mapVisualizationLayerXML(visXML.getLayers());

            output.setLayers(layers);
        }
    }

    private void mapVisualizationDirectionXML(VisualizationXML.Visualization visXML, FurnitureJSON.Visualization output) {
        if (visXML.getDirections() != null && !visXML.getDirections().isEmpty()) {
            Map<Integer, FurnitureJSON.Visualization.Direction> directions = new HashMap<Integer, FurnitureJSON.Visualization.Direction>();
            for (VisualizationXML.Visualization.Direction directionXML : visXML.getDirections()) {
                if (directionXML.getLayers() != null && !directionXML.getLayers().isEmpty()) {
                    FurnitureJSON.Visualization.Direction direction = new FurnitureJSON.Visualization.Direction();
                    direction.setId(directionXML.getId());

                    Map<Integer, FurnitureJSON.Visualization.Layer> layers = this.mapVisualizationLayerXML(directionXML.getLayers());

                    direction.setLayers(layers);
                    directions.put(directionXML.getId(), direction);
                }
            }

            if (!directions.isEmpty()) {
                output.setDirections(directions);
            }
        }
    }

    private Map<Integer, FurnitureJSON.Visualization.Color.ColorLayer> mapVisualizationColorLayerXML(VisualizationXML.Visualization.Color colorXML) {
        Map<Integer, FurnitureJSON.Visualization.Color.ColorLayer> colorLayers = new HashMap<Integer, FurnitureJSON.Visualization.Color.ColorLayer>();
        for (VisualizationXML.Visualization.Color.ColorLayer colorLayerXML : colorXML.getLayers()) {
            FurnitureJSON.Visualization.Color.ColorLayer colorLayer = new FurnitureJSON.Visualization.Color.ColorLayer();
            colorLayer.setId(colorLayerXML.getId());
            colorLayer.setColor(Integer.parseInt(colorLayerXML.getColor(), 16));

            colorLayers.put(colorLayerXML.getId(), colorLayer);
        }

        return colorLayers;
    }

    private void mapVisualizationColorXML(VisualizationXML.Visualization visXML, FurnitureJSON.Visualization output) {
        if (visXML.getColors() != null && !visXML.getColors().isEmpty()) {
            Map<Integer, FurnitureJSON.Visualization.Color> colors = new HashMap<Integer, FurnitureJSON.Visualization.Color>();
            for (VisualizationXML.Visualization.Color colorXML : visXML.getColors()) {
                if (colorXML.getLayers() != null && !colorXML.getLayers().isEmpty()) {
                    FurnitureJSON.Visualization.Color color = new FurnitureJSON.Visualization.Color();
                    color.setId(colorXML.getId());

                    Map<Integer, FurnitureJSON.Visualization.Color.ColorLayer> colorLayers = this.mapVisualizationColorLayerXML(colorXML);

                    color.setLayers(colorLayers);
                    colors.put(colorXML.getId(), color);
                }
            }

            if (!colors.isEmpty()) {
                output.setColors(colors);
            }
        }
    }

    private Map<Integer, FurnitureJSON.Visualization.Animation.AnimationLayer> mapVisualizationAnimationLayerXML(VisualizationXML.Visualization.Animation animationXML) {
        Map<Integer, FurnitureJSON.Visualization.Animation.AnimationLayer> animationLayers = new HashMap<Integer, FurnitureJSON.Visualization.Animation.AnimationLayer>();
        for (VisualizationXML.Visualization.Animation.AnimationLayer animationLayerXML : animationXML.getLayers()) {
            FurnitureJSON.Visualization.Animation.AnimationLayer animationLayer = new FurnitureJSON.Visualization.Animation.AnimationLayer();
            animationLayer.setId(animationLayerXML.getId());
            animationLayer.setFrameRepeat(animationLayerXML.getFrameRepeat());
            animationLayer.setLoopCount(animationLayerXML.getLoopCount());

            if (animationLayerXML.getFrames() != null && !animationLayerXML.getFrames().isEmpty()) {
                List<Integer> frames = new ArrayList<Integer>();
                for (VisualizationXML.Visualization.Animation.AnimationLayer.Frame frameXML : animationLayerXML.getFrames()) {
                    frames.add(frameXML.getId());
                }

                animationLayer.setFrames(frames);
                animationLayers.put(animationLayerXML.getId(), animationLayer);
            }
        }

        return animationLayers;
    }

    private void mapVisualizationAnimationXML(VisualizationXML.Visualization visXML, FurnitureJSON.Visualization output) {
        if (visXML.getAnimations() != null && !visXML.getAnimations().isEmpty()) {
            Map<Integer, FurnitureJSON.Visualization.Animation> animations = new HashMap<Integer, FurnitureJSON.Visualization.Animation>();
            for (VisualizationXML.Visualization.Animation animationXML : visXML.getAnimations()) {
                if (animationXML.getLayers() != null && !animationXML.getLayers().isEmpty()) {
                    FurnitureJSON.Visualization.Animation animation = new FurnitureJSON.Visualization.Animation();
                    animation.setId(animationXML.getId());

                    Map<Integer, FurnitureJSON.Visualization.Animation.AnimationLayer> animationLayers = this.mapVisualizationAnimationLayerXML(animationXML);

                    animation.setLayers(animationLayers);
                    animations.put(animationXML.getId(), animation);
                }
            }

            if (!animations.isEmpty()) {
                output.setAnimations(animations);
            }
        }
    }

    public void mapVisualizationXML(VisualizationXML visualizationXML, FurnitureJSON output) {
        VisualizationXML.Visualization visXML = this.getCorrectVisualizationXML(visualizationXML);

        FurnitureJSON.Visualization visualization = new FurnitureJSON.Visualization();
        visualization.setAngle(visXML.getAngle());
        visualization.setLayerCount(visXML.getLayerCount());

        this.mapVisualizationLayerXML(visXML, visualization);
        this.mapVisualizationDirectionXML(visXML, visualization);
        this.mapVisualizationColorXML(visXML, visualization);
        this.mapVisualizationAnimationXML(visXML, visualization);

        output.setVisualization(visualization);
    }
}
