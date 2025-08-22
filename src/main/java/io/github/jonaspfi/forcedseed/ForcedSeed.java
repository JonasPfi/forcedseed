package io.github.jonaspfi.forcedseed;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ForcedSeed.MOD_ID)
public class ForcedSeed {
    public static final String MOD_ID = "forcedseed";
    public static final Logger LOGGER = LogManager.getLogger();

    public ForcedSeed() {
        LOGGER.info("ForcedSeed Mod loaded!");
        // Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}