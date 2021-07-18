package kizuki.ac.check.impl.scaffold;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class ScaffoldC extends KizukiCheck
{
    CPacketBlockPlace verbosePattern;
    int verbosePattern;
    
    public ScaffoldC(final PlayerData playerData) {
        super(playerData, CheckType.SCAFFOLD, "Scaffold (C)", "ScaffoldC", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = null;
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketBlockPlace) {
            this.verbosePattern = (CPacketBlockPlace)packet;
        }
        else if (packet instanceof CPacketFlying) {
            if (this.verbosePattern != null) {
                if (((CPacketFlying)packet).getDeltaXZ() > 0.13 && ((CPacketFlying)packet).getTo().getPitch() > Math.abs(88) && ((CPacketFlying)packet).isGround() && this.verbosePattern.getFace() != 15 && this.verbosePattern.getFace() != 1) {
                    if (this.verbosePattern++ > 2) {
                        this.flag("p -> " + ((CPacketFlying)packet).getTo().getPitch());
                    }
                }
                else {
                    this.verbosePattern = 0;
                }
            }
            this.verbosePattern = null;
        }
    }
}
