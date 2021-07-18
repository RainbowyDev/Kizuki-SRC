package kizuki.ac.check.impl.packet;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class PacketA extends KizukiCheck
{
    public PacketA(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Packet (A)", "PacketA", DevelopmentState.EXPERIMENTAL, false);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            this.debug(((CPacketFlying)packet).getTo().getYaw() + "");
            if ((((CPacketFlying)packet).getDeltaYaw() > 1200.0f && ((CPacketFlying)packet).getDeltaYaw() % 360.0f > 15.0f) || (Math.abs(((CPacketFlying)packet).getTo().getPitch()) > 90.0f && !this.getPlayerData().II(5) && this.getPlayerData().iI > 3)) {
                this.flag("dY -> " + ((CPacketFlying)packet).getDeltaYaw());
            }
        }
    }
}
