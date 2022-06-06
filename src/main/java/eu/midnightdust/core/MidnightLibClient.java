package eu.midnightdust.core;

import eu.midnightdust.core.config.MidnightLibConfig;
import eu.midnightdust.hats.web.HatLoader;
import eu.midnightdust.hats.witch.WitchHatFeatureRenderer;
import eu.midnightdust.lib.config.AutoModMenu;
import eu.midnightdust.lib.config.MidnightConfig;
import eu.midnightdust.lib.util.MidnightColorUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class MidnightLibClient implements ClientModInitializer {

    public static final String MOD_ID = "midnightlib";

    @Override
    public void onInitializeClient() {
        MidnightConfig.init("midnightlib", MidnightLibConfig.class);
        AutoModMenu.hideFromModMenu("puzzle");

        EntityModelLayerRegistry.registerModelLayer(WitchHatFeatureRenderer.WITCH_HAT_MODEL_LAYER, WitchHatFeatureRenderer::getTexturedModelData);
        if (MidnightLibConfig.special_hats) HatLoader.init();
        ClientTickEvents.END_CLIENT_TICK.register(
                client -> MidnightColorUtil.tick()
        );
    }
}
