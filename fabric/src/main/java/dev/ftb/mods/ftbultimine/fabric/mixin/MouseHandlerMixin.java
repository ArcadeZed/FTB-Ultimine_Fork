package dev.ftb.mods.ftbultimine.fabric.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.ftb.mods.ftbultimine.client.FTBUltimineClient;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public abstract class MouseHandlerMixin {
    @Inject(method = "onScroll", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isSpectator()Z", ordinal = 0), cancellable = true)
    public void onRawMouseScrolled(long handle, double xOffset, double yOffset, CallbackInfo ci, @Local(name = "scaledXOffset") double amountX, @Local(name = "scaledYOffset") double amountY) {
        if (!ci.isCancelled()) {
            if (FTBUltimineClient.getInstance().onMouseScrolled(amountX, amountY)) {
                ci.cancel();
            }
        }
    }
}
