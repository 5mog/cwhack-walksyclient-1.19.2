package net.walksy.client.mixin;

import net.walksy.client.WalksyClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.walksy.client.events.render.GetRainGradientEvent;
import net.minecraft.world.World;

@Mixin(World.class)
public class WorldMixin {
    @Inject(at = @At("RETURN"), method = "getRainGradient(F)F", cancellable = true)
    private void onIsRaining(float delta, CallbackInfoReturnable<Float> cir) {
        WalksyClient.getInstance().emitter.triggerEvent(new GetRainGradientEvent(delta, cir));
    }
}
