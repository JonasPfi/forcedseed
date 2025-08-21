package org.crash2.forcedseed.mixin;

import net.minecraft.world.level.levelgen.WorldOptions;
import org.crash2.forcedseed.Config;
import org.crash2.forcedseed.ForcedSeed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldOptions.class)
public class WorldOptionsMixin {

    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0)
    private static long forceSeed(long seed) {
        long forcedSeed = parseSeed(Config.SEED_STRING.get());
        ForcedSeed.LOGGER.info("[ForcedSeed] Forcing seed from {} to {}", seed, forcedSeed);
        return forcedSeed;
    }

    private static long parseSeed(String seed) {
        try {
            return Long.parseLong(seed);
        } catch (NumberFormatException e) {
            ForcedSeed.LOGGER.warn("[ForcedSeed] Seed '{}' is not a number, using hash fallback.", seed);
            return seed.hashCode();
        }
    }
}