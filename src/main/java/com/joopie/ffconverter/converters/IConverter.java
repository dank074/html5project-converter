package com.joopie.ffconverter.converters;

import com.joopie.ffconverter.HabboAssetSWF;

import java.io.File;

/**
 * Created by jospi on 22-4-2017.
 */
public interface IConverter {
    void fromHabboAsset(HabboAssetSWF habboAssetSWF, File outputFolder) throws Exception;
}
