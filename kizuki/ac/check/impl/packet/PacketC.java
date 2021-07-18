package kizuki.ac.check.impl.packet;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class PacketC extends KizukiCheck
{
    int verbosePattern;
    
    public PacketC(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Packet (C)", "PacketC", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (!(packet instanceof CPacketSteerVehicle)) {
            return;
        }
        if (this.getPlayerData().getPlayer().getVehicle() == null && !((CPacketSteerVehicle)packet).isGround()) {
            if (this.verbosePattern++ > 10) {
                this.flag();
            }
        }
        else {
            this.verbosePattern = 0;
        }
    }
}
