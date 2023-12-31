package net.walksy.client.mixin.render;

import net.walksy.client.WalksyClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.walksy.client.events.render.BossBarHudRenderEvent;
import net.walksy.client.events.render.BossBarHudSkyEffectsEvent;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.util.math.MatrixStack;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(BossBarHud.class)
public class BossBarHudMixin {
    @Inject(at = @At("HEAD"), method="render(Lnet/minecraft/client/util/math/MatrixStack;)V", cancellable = true)
    public void onRender(MatrixStack matrices, CallbackInfo ci) {
        WalksyClient.getInstance().emitter.triggerEvent(new BossBarHudRenderEvent(ci));
    }

    // Notice how these both have the same event trigger?  I mean... functionality wise, they are the same thing lets be honest.... figured rather than triggering different events for the same thing might as well keep it as one thing
    @Inject(at = @At("RETURN"), method="shouldDarkenSky()Z", cancellable = true)
    public void onShouldDarkenSky(CallbackInfoReturnable<Boolean> cir) {
        WalksyClient.getInstance().emitter.triggerEvent(new BossBarHudSkyEffectsEvent(cir));
    }

    @Inject(at = @At("RETURN"), method="shouldThickenFog()Z", cancellable = true)
    public void onShouldThickenFog(CallbackInfoReturnable<Boolean> cir) {
        WalksyClient.getInstance().emitter.triggerEvent(new BossBarHudSkyEffectsEvent(cir));
    }
}
