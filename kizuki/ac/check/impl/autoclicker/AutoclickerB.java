package kizuki.ac.check.impl.autoclicker;

import kizuki.ac.check.*;
import kizuki.ac.utils.list.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import java.util.*;
import kizuki.ac.utils.*;
import org.bukkit.*;

public class AutoclickerB extends KizukiCheck
{
    double lastKurtosis;
    double lastVariance;
    double lastAverage;
    EvictingList samples;
    long timestamp;
    
    public AutoclickerB(final PlayerData playerData) {
        super(playerData, CheckType.AUTOCLICKER, "AutoClicker (B)", "AutoClickerB", DevelopmentState.FINAL, true);
        this.lastKurtosis = 0.0;
        this.lastVariance = 0.0;
        this.lastAverage = 0.0;
        this.samples = new EvictingList(50);
        this.timestamp = this.getTime();
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketArmAnimation) {
            if (this.samples.isFull()) {
                final double average = MathUtil.getAverage(this.samples);
                final double kurtosis = MathUtil.getKurtosis(this.samples);
                final double variance = MathUtil.getVariance(this.samples);
                if ((Math.abs(this.lastKurtosis - kurtosis) < 0.01 || Math.abs(this.lastVariance - variance) < 0.01 || Math.abs(average - this.lastAverage) < 0.01) && average < 100.0) {
                    this.flag("a -> " + average + ", b -> " + (Math.abs(this.lastKurtosis - kurtosis) < 0.01) + ", c -> " + (Math.abs(this.lastVariance - variance) < 0.01) + ", d -> " + (Math.abs(average - this.lastAverage) < 0.01));
                }
                this.lastKurtosis = kurtosis;
                this.lastVariance = variance;
                this.lastAverage = average;
                this.samples.clear();
            }
            if (BlockUtils.isInAir(this.getPlayerData().getPlayer()).getType() == Material.AIR) {
                this.samples.add((int)(this.getTime() - this.timestamp));
            }
            this.timestamp = this.getTime();
        }
    }
}
