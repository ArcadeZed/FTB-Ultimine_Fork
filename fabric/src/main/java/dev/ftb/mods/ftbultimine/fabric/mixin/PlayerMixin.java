package dev.ftb.mods.ftbultimine.fabric.mixin;

import dev.ftb.mods.ftbultimine.FTBUltimine;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void preTick(CallbackInfo ci) {
        if ((Object) this instanceof Player player) {
            FTBUltimine.getInstance().playerTick(player);
        }
    }
}
