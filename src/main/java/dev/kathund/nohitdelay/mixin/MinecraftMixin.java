package dev.kathund.nohitdelay.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
  @Shadow
  private int attackCooldown;

  @Inject(method = "doAttack", at = @At("HEAD"))
  private void doAttack(CallbackInfo ci) {
    this.attackCooldown = 0;
  }
}
