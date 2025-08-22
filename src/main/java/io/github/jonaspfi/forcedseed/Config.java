package io.github.jonaspfi.forcedseed;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.ConfigValue<String> SEED_STRING;

    static {
        BUILDER.push("forcedseed");

        SEED_STRING = BUILDER
                .comment("The seed that should always be applied.")
                .define("seedString", "123456789");

        BUILDER.pop();
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
