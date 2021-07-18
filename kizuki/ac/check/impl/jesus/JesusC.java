package kizuki.ac.check.impl.jesus;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import org.bukkit.*;
import org.bukkit.util.*;

public class JesusC extends KizukiCheck
{
    int verbosePattern;
    
    public JesusC(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Jesus (C)", "JesusC", DevelopmentState.FINAL, false);
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying && this.getPlayerData().sinceLiquidTicks == 0 && this.getPlayerData().sneaking > 3) {
            final double n = this.getPlayerData().getPlayer().getVelocity().getY() + 0.0784000015258789;
            if (n > 0.0) {
                return;
            }
            final double abs;
            if ((abs = Math.abs(n - ((CPacketFlying)packet).getDeltaY())) > 0.8 && !this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) && !this.getPlayerData().iI() && this.getPlayerData().sinceVehicleTicks > 3 && this.verbosePattern++ > 3) {
                this.flag(String.format("a -> %s, b -> %s, c -> %s", abs, n, Math.abs(((CPacketFlying)packet).getDeltaY())));
                this.setback(new Vector(0.0, -0.2, 0.0), ((CPacketFlying)packet).getFrom());
            }
        }
    }
}
