package dev.ftb.mods.ftbultimine.fabric.mixin;

import dev.ftb.mods.ftbultimine.FTBUltimine;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.PersistentEntitySectionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PersistentEntitySectionManager.class)
public abstract class PersistentEntitySectionManagerMixin<T extends EntityAccess> {
    @Inject(method = "addEntity", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/core/SectionPos;asLong(Lnet/minecraft/core/BlockPos;)J"),
            cancellable = true)
    private void addEntity(T entityAccess, boolean bl, CallbackInfoReturnable<Boolean> cir) {
        if (entityAccess instanceof Entity e && FTBUltimine.getInstance().handleItemAndOrbJoining(e, e.level())) {
            cir.setReturnValue(false);
        }
    }
}
