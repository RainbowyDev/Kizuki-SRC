package kizuki.ac.echeck.impl.packet;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import kizuki.ac.*;
import org.bukkit.*;

public class PacketF extends KizukiCheck
{
    public PacketF(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Packet (F)", "PacketF", DevelopmentState.FINAL, false);
    }
    
    @Override
    public void handle(final Packet packet) {
        if (!this.getPlayerData().Il()) {
            if (packet instanceof CPacketAbilities && !packet.getPlayer().getAllowFlight()) {
                this.flag("ca");
            }
            else if (packet instanceof yv && packet.getPlayer().getGameMode() != GameMode.SPECTATOR) {
                this.flag("cs");
            }
        }
    }
}
