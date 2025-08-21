package org.crash2.forcedseed;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FixedSeed.MOD_ID)
public class FixedSeed {
    public static final String MOD_ID = "fixedseed";
    public static final Logger LOGGER = LogManager.getLogger();

    public FixedSeed() {
        LOGGER.info("FixedSeed Mod loaded! Version 1.0.0");

        // Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // (Optional) Register event listeners if you add GUI tweaks later
        if (FMLEnvironment.dist.isClient()) {
            IEventBus bus = MinecraftForge.EVENT_BUS;
            // bus.register(ClientHooks.class); // Example if you add GUI events
        }
    }
}
