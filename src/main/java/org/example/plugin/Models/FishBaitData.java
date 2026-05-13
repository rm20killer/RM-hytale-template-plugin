package org.example.plugin.Models;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.AssetRegistry;
import com.hypixel.hytale.assetstore.AssetStore;
import com.hypixel.hytale.assetstore.codec.AssetBuilderCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import org.example.plugin.Registration.HytaleAsset;

//Example from Angler's Almanac
@HytaleAsset(
        path = "AnglersAlmanacBaitData"
)
public class FishBaitData implements JsonAssetWithMap<String, DefaultAssetMap<String, FishBaitData>> {
    public String id;
    public AssetExtraInfo.Data data;
    public String itemId;

    public static final String KEY = "AA_FishBaitData";

    public static final AssetBuilderCodec<String, FishBaitData> CODEC = AssetBuilderCodec.builder(
                    FishBaitData.class,
                    FishBaitData::new,
                    Codec.STRING,
                    (t, id) -> t.id = id,
                    t -> t.id,
                    (t, data) -> t.data = data,
                    t -> t.data
            )
            .appendInherited(new KeyedCodec<>("ItemId", Codec.STRING), (t, v) -> t.itemId = v, t -> t.itemId, (t, p) -> t.itemId = p.itemId).add()
            .build();

    public static final KeyedCodec<FishBaitData> KEYED_CODEC = new KeyedCodec<>(KEY, CODEC);

    private static AssetStore<String, FishBaitData, DefaultAssetMap<String, FishBaitData>> ASSET_STORE;

    public static AssetStore<String, FishBaitData, DefaultAssetMap<String, FishBaitData>> getAssetStore() {
        if (ASSET_STORE == null) {
            ASSET_STORE = AssetRegistry.getAssetStore(FishBaitData.class);
        }
        return ASSET_STORE;
    }


    @Override
    public String getId() {
        return id;
    }



}
