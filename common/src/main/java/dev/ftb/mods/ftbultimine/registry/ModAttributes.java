package dev.ftb.mods.ftbultimine.registry;

import dev.ftb.mods.ftblibrary.platform.registry.XRegistry;
import dev.ftb.mods.ftblibrary.platform.registry.XRegistryRef;
import dev.ftb.mods.ftblibrary.util.Lazy;
import dev.ftb.mods.ftbultimine.api.FTBUltimineAPI;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class ModAttributes {
    public static final XRegistry<Attribute> ATTRIBUTES
            = XRegistry.create(FTBUltimineAPI.MOD_ID, Registries.ATTRIBUTE);

    public static final XRegistryRef<Attribute> MAX_BLOCKS_MODIFIER
            = ATTRIBUTES.register("max_blocks_modifier", () -> new RangedAttribute("ftbultimine.modifier.max_blocks", 0.0, -Double.MAX_VALUE, Double.MAX_VALUE));
    public static final XRegistryRef<Attribute> COOLDOWN_MODIFIER
            = ATTRIBUTES.register("cooldown_modifier", () -> new RangedAttribute("ftbultimine.modifier.cooldown", 0.0, -Double.MAX_VALUE, Double.MAX_VALUE));
    public static final XRegistryRef<Attribute> EXHAUSTION_MODIFIER
            = ATTRIBUTES.register("exhaustion_modifier", () -> new RangedAttribute("ftbultimine.modifier.exhaustion", 0.0, -Double.MAX_VALUE, Double.MAX_VALUE));
    public static final XRegistryRef<Attribute> EXPERIENCE_MODIFIER
            = ATTRIBUTES.register("experience_modifier", () -> new RangedAttribute("ftbultimine.modifier.experience", 0.0, -Double.MAX_VALUE, Double.MAX_VALUE));

    public static void init() {
        ATTRIBUTES.init();
    }

    public static class FixedHolder {
        // This is a bit gross, but registering an Arch RegistrySupplier directly via the NeoForge EntityAttributeModificationEvent
        //   event doesn't work, even though RegistrySupplier<T> implements Holder<T>.  Go figure.
        public static final Lazy<Holder<Attribute>> MAX_BLOCKS_MODIFIER = Lazy.of(() -> holder(ModAttributes.MAX_BLOCKS_MODIFIER));
        public static final Lazy<Holder<Attribute>> COOLDOWN_MODIFIER = Lazy.of(() -> holder(ModAttributes.COOLDOWN_MODIFIER));
        public static final Lazy<Holder<Attribute>> EXHAUSTION_MODIFIER = Lazy.of(() -> holder(ModAttributes.EXHAUSTION_MODIFIER));
        public static final Lazy<Holder<Attribute>> EXPERIENCE_MODIFIER = Lazy.of(() -> holder(ModAttributes.EXPERIENCE_MODIFIER));

        private static Holder<Attribute> holder(XRegistryRef<Attribute> attr) {
            return BuiltInRegistries.ATTRIBUTE.get(attr.identifier()).orElseThrow();
        }
    }
}
