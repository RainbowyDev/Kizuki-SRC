package kizuki.ac.check.impl.move;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import org.bukkit.*;
import kizuki.ac.utils.*;
import kizuki.ac.packet.wrapper.*;
import com.comphenix.protocol.wrappers.*;

public class MoveB extends KizukiCheck
{
    boolean iI;
    int verbosePattern;
    float verbosePattern;
    private double verbosePattern;
    private double iI;
    
    public MoveB(final PlayerData playerData) {
        super(playerData, CheckType.MOVEMENT, "Move (B)", "MoveB", DevelopmentState.FINAL, false);
        this.iI = false;
        this.verbosePattern = 3;
        this.verbosePattern = 0.0f;
        this.verbosePattern = -1.0;
        this.iI = -1.0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            final CPacketFlying cPacketFlying = (CPacketFlying)packet;
            final boolean world = cPacketFlying.getWorld();
            final boolean full = cPacketFlying.getTo().isFull();
            final double verbosePattern = cPacketFlying.getTo().getX() - cPacketFlying.getFrom().getX();
            final double ii = cPacketFlying.getTo().getZ() - cPacketFlying.getFrom().getZ();
            if (!this.getPlayerData().iI() && !this.getPlayerData().isGlidingOrLevitating((CPacketFlying)packet) && !this.getPlayerData().ll() && !full && !this.getPlayerData().II() && this.verbosePattern > 2 && this.getPlayerData().sinceVehicleTicks > 3 && this.getPlayerData().sinceHalfBlockTicks > 5 && this.getPlayerData().sinceClimbableTicks > 5 && !this.getPlayerData().getPlayer().getGameMode().equals((Object)GameMode.SPECTATOR) && (this.getPlayerData().sneaking > 2 || (this.getPlayerData().groundTicks == 1 && this.getPlayerData().sprinting > 2))) {
                final double n = MathUtil.Ii(verbosePattern - this.verbosePattern * 0.91, ii - this.iI * 0.91) / ((this.getPlayerData().sinceSprintTicks < 2) ? 1.3 : 1.0) - ((this.getPlayerData().sprinting || this.getPlayerData().sinceSprintTicks < 2) ? 0.026 : 0.02);
                if (n > 0.0075 && cPacketFlying.getDeltaXZ() > 0.15 && !this.getPlayerData().getPlayer().isFlying() && !world && !this.iI) {
                    final float verbosePattern2 = this.verbosePattern;
                    this.verbosePattern = verbosePattern2 + 1.0f;
                    if (verbosePattern2 > 1.0f) {
                        this.flag("a -> " + n + ", b -> " + cPacketFlying.getDeltaXZ());
                    }
                }
                else {
                    this.verbosePattern = Math.max(0.0f, this.verbosePattern - 0.5f);
                }
            }
            this.verbosePattern = verbosePattern;
            this.iI = ii;
            ++this.verbosePattern;
            this.iI = world;
        }
        else if (packet instanceof CPacketUseEntity && ((CPacketUseEntity)packet).getAction().equals((Object)EnumWrappers$EntityUseAction.ATTACK)) {
            this.verbosePattern = 0;
        }
    }
}
