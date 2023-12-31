package me.huanmeng.jkook.plugin.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import snw.kookbc.impl.KBCClient;
import snw.kookbc.impl.network.Bucket;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2023/12/31<br>
 * KookBCMixinPluginExample<br>
 *
 * @author huanmeng_qwq
 */
@Mixin(Bucket.class)
public class BucketMixin {
    @Shadow
    @Final
    private AtomicInteger availableTimes;

    @Shadow
    @Final
    private AtomicInteger resetTime;

    @Shadow
    @Final
    private KBCClient client;

    @Shadow
    @Final
    private String name;

    @Inject(method = "check", at = @At("HEAD"))
    public void exampleMixinPlugin$check(CallbackInfo ci) {
        int i = availableTimes.get();
        if (i == Integer.MIN_VALUE) {
            return;
        }
        if (i <= 10) {
            int time = this.resetTime.get();
            client.getCore().getLogger().info("Route '{}' over limit! Current reset time: {}", name, time);
        }
    }
}
