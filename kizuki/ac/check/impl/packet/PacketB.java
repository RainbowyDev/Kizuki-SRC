package kizuki.ac.check.impl.packet;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.*;
import kizuki.ac.packet.wrapper.*;

public class PacketB extends KizukiCheck
{
    long verbosePattern;
    long iI;
    float verbosePattern;
    boolean iI;
    static final /* synthetic */ boolean Ii;
    
    public PacketB(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Packet (B)", "PacketB", DevelopmentState.EXPERIMENTAL, true);
        this.verbosePattern = -69L;
        this.iI = -69L;
        this.verbosePattern = 0.0f;
        this.iI = false;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketArmAnimation) {
            this.iI = true;
        }
        else if (packet instanceof CPacketFlying) {
            this.iI = System.currentTimeMillis();
        }
        else if (packet instanceof CPacketUseEntity || packet instanceof CPacketBlockPlace || packet instanceof ut || packet instanceof CPacketUseItem || packet instanceof CPacketDig || packet instanceof CHeldItemSlot) {
            this.debug(packet.II().getPacketType().name() + " " + (System.currentTimeMillis() - this.iI) + " " + this.verbosePattern);
            final int n;
            if (this.iI != -69L && (n = (int)(System.currentTimeMillis() - this.iI)) < 5 && !this.getPlayerData().Il()) {
                final float verbosePattern = this.verbosePattern;
                this.verbosePattern = verbosePattern + 1.0f;
                if (verbosePattern > 2.0f) {
                    if (!PacketB.Ii && packet.II() == null) {
                        throw new AssertionError();
                    }
                    this.flag("d -> " + n + ", t/" + packet.II().getPacketType().name());
                }
            }
            else {
                this.verbosePattern = Math.max(this.verbosePattern - 0.6f, 0.0f);
            }
            this.iI = false;
        }
    }
    
    static {
        Ii = !PacketB.class.desiredAssertionStatus();
    }
}
