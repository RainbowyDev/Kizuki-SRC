package kizuki.ac.check.impl.hand;

import kizuki.ac.check.*;
import org.bukkit.block.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import com.comphenix.protocol.wrappers.*;
import kizuki.ac.packet.wrapper.*;

public class HandA extends KizukiCheck
{
    double angle;
    boolean sent;
    int id;
    Block block;
    
    public HandA(final PlayerData playerData) {
        super(playerData, CheckType.HAND, "Hand (A)", "HandA", DevelopmentState.EXPERIMENTAL, false);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketDig) {
            final CPacketDig cPacketDig = (CPacketDig)packet;
            if (cPacketDig.getDigType().equals((Object)EnumWrappers$PlayerDigType.START_DESTROY_BLOCK)) {
                this.angle = 0.0;
                this.sent = true;
                this.block = this.getPlayerData().getPlayer().getWorld().getBlockAt(cPacketDig.getBlockPosition().getX(), cPacketDig.getBlockPosition().getY(), cPacketDig.getBlockPosition().getZ());
                this.id = this.block.getType().getId();
            }
            else if (cPacketDig.getDigType().equals((Object)EnumWrappers$PlayerDigType.ABORT_DESTROY_BLOCK)) {
                this.sent = false;
            }
            else if (cPacketDig.getDigType().equals((Object)EnumWrappers$PlayerDigType.STOP_DESTROY_BLOCK)) {
                if (this.angle < 0.9) {
                    this.flag("d -> " + this.angle);
                }
                this.sent = false;
            }
        }
        else if (packet instanceof CPacketArmAnimation) {}
    }
}
