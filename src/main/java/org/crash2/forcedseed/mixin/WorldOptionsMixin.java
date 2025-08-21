package org.crash2.forcedseed.mixin;

import net.minecraft.world.level.levelgen.WorldOptions;
import org.crash2.forcedseed.Config;
import org.crash2.forcedseed.FixedSeed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldOptions.class)
public class WorldOptionsMixin {

    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0)
    private static long forceSeed(long seed) {
        long forcedSeed = parseSeed(Config.SEED_STRING.get());
        FixedSeed.LOGGER.info("[FixedSeed] Forcing seed from {} to {}", seed, forcedSeed);
        return forcedSeed;
    }

    private static long parseSeed(String seed) {
        try {
            return Long.parseLong(seed);
        } catch (NumberFormatException e) {
            FixedSeed.LOGGER.warn("[FixedSeed] Seed '{}' is not a number, using hash fallback.", seed);
            return seed.hashCode();
        }
    }
}