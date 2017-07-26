package com.joopie.ffconverter.converters.util.spritesheet;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.joopie.ffconverter.converters.util.spritesheet.models.SpritesheetJSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jospi on 23-4-2017.
 */
public class SpritesheetJSONMapper {
    public SpritesheetJSON mapTextureAtlasData(TextureAtlas.TextureAtlasData textureAtlasData) {
        SpritesheetJSON spritesheet = new SpritesheetJSON();

        Map<String, SpritesheetJSON.SpriteFrame> spriteFrames = new HashMap<>();
        for (TextureAtlas.TextureAtlasData.Region region : textureAtlasData.getRegions()) {
            SpritesheetJSON.SpriteFrame spriteFrame = new SpritesheetJSON.SpriteFrame();

            spriteFrame.setName(region.name);

            SpritesheetJSON.Rect frame = new SpritesheetJSON.Rect();
            frame.setX(region.left);
            frame.setY(region.top);
            frame.setW(region.width);
            frame.setH(region.height);
            spriteFrame.setFrame(frame);

            SpritesheetJSON.Rect sourceSize = new SpritesheetJSON.Rect();
            sourceSize.setW(region.originalWidth);
            sourceSize.setH(region.originalHeight);
            spriteFrame.setSourceSize(sourceSize);

            SpritesheetJSON.Rect spriteSourceSize = new SpritesheetJSON.Rect();
            spriteSourceSize.setX((int) region.offsetX);
            spriteSourceSize.setY((int) region.offsetY);
            spriteSourceSize.setW(region.width);
            spriteSourceSize.setH(region.height);
            spriteFrame.setSpriteSourceSize(spriteSourceSize);

            spriteFrame.setRotated(region.rotate);
            if (sourceSize.getW() > spriteSourceSize.getW()
                    && sourceSize.getH() > spriteSourceSize.getH()) {
                spriteFrame.setTrimmed(true);
            }
            else {
                spriteFrame.setTrimmed(false);
            }

            spriteFrames.put(region.name, spriteFrame);
        }

        spritesheet.setFrames(spriteFrames);
        return spritesheet;
    }
}
