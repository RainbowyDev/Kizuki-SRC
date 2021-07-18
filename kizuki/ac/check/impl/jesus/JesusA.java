package kizuki.ac.check.impl.jesus;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import org.bukkit.*;
import org.bukkit.util.*;

public class JesusA extends KizukiCheck
{
    public JesusA(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Jesus (A)", "JesusA", DevelopmentState.FINAL, false);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying && (((CPacketFlying)packet).getTo().isInLiquid() || this.getPlayerData().sinceLiquidTicks < 3)) {
            final double deltaY = ((CPacketFlying)packet).getDeltaY();
            if (((deltaY > 0.4 && this.getPlayerData().sneaking > 3) || (deltaY > 0.5 && this.getPlayerData().sneaking != 0)) && !this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) && !this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) && !this.getPlayerData().iI() && !this.getPlayerData().ll() && !this.getPlayerData().II()) {
                this.flag("a -> " + deltaY);
                this.setback(new Vector(0.0, -0.2, 0.0), ((CPacketFlying)packet).getFrom());
            }
        }
    }
}
