package kizuki.ac.check.impl.scaffold;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class ScaffoldA extends KizukiCheck
{
    int verbosePattern;
    int iI;
    
    public ScaffoldA(final PlayerData playerData) {
        super(playerData, CheckType.SCAFFOLD, "Scaffold (A)", "ScaffoldA", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = 0;
        this.iI = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketTickWTF || packet instanceof CPacketFlying) {
            final int ii;
            if (!this.getPlayerData().Il() && (this.verbosePattern > (ii = config.II(this.Ii() + ".allowedInOneTick")) || this.iI > ii)) {
                this.flag("a -> " + this.verbosePattern + ", b -> " + this.iI + ", c -> " + ii);
            }
            final int n = 0;
            this.iI = n;
            this.verbosePattern = n;
        }
        else if (packet instanceof CPacketUseItem) {
            ++this.verbosePattern;
        }
        else if (packet instanceof CPacketBlockPlace) {
            ++this.iI;
        }
    }
}
