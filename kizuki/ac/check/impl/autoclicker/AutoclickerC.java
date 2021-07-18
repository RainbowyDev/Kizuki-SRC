package kizuki.ac.check.impl.autoclicker;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import org.bukkit.*;
import java.util.*;
import kizuki.ac.utils.*;
import kizuki.ac.packet.wrapper.*;

public class AutoclickerC extends KizukiCheck
{
    int flying;
    long lastFlying;
    double buffer;
    ArrayList samples;
    
    public AutoclickerC(final PlayerData playerData) {
        super(playerData, CheckType.AUTOCLICKER, "AutoClicker (C)", "AutoClickerC", DevelopmentState.EXPERIMENTAL, true);
        this.samples = new ArrayList();
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketArmAnimation) {
            if (BlockUtils.isInAir(this.getPlayerData().getPlayer(), 5).getType() != Material.AIR) {
                return;
            }
            final double n = (double)(this.flying - this.lastFlying + 1L);
            if (n < 10.0) {
                final int n2 = 70;
                final double n3 = 0.05;
                this.samples.add(n);
                if (this.samples.size() > n2) {
                    this.samples.remove(0);
                }
                final double n4 = (Collections.min((Collection<? extends Double>)this.samples) + Collections.max((Collection<? extends Double>)this.samples)) / 2.0 - MathUtil.getAverage(this.samples);
                this.debug(n4 + " " + this.getPlayerData().II);
                if (Math.abs(n4) <= n3 && this.samples.size() == n2 && this.getPlayerData().II > 9.0f) {
                    this.buffer = Math.min(12.0, this.buffer + 1.0);
                    if (this.buffer > 6.0) {
                        this.flag("a -> " + n4 + ", b -> " + MathUtil.getAverage2(this.samples));
                    }
                }
                else {
                    this.buffer = 0.0;
                }
            }
            this.lastFlying = this.flying;
        }
        else if (packet instanceof CPacketFlying) {
            ++this.flying;
        }
    }
}
