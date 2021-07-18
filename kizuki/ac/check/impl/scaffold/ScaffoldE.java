package kizuki.ac.check.impl.scaffold;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;

public class ScaffoldE extends KizukiCheck
{
    CPacketFlying verbosePattern;
    boolean iI;
    int verbosePattern;
    private int iI;
    private float verbosePattern;
    private boolean Ii;
    
    public ScaffoldE(final PlayerData playerData) {
        super(playerData, CheckType.SCAFFOLD, "Scaffold (E)", "ScaffoldE", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = null;
        this.iI = false;
        this.verbosePattern = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketArmAnimation) {
            this.iI = true;
        }
        else if (packet instanceof CPacketBlockPlace) {
            if (this.verbosePattern != null && this.verbosePattern.isGround() && this.iI && this.verbosePattern.getDeltaXZ() > 0.06) {
                if (((CPacketBlockPlace)packet).getBlockPosition() == null) {
                    return;
                }
                if (((CPacketBlockPlace)packet).getBlockPosition().getY() >= this.getPlayerData().getPlayer().getLocation().getBlockY()) {
                    this.debug("broke the check");
                }
                else {
                    ++this.verbosePattern;
                    this.iI = false;
                }
            }
            this.verbosePattern = null;
        }
        else if (packet instanceof CPacketFlying) {
            this.verbosePattern = (CPacketFlying)packet;
            ++this.iI;
            if (Math.abs(this.verbosePattern.getDeltaX()) > 0.15 && Math.abs(this.verbosePattern.getDeltaZ()) > 0.15) {
                this.Ii = true;
            }
            if (this.iI >= 15) {
                this.debug("places " + this.verbosePattern);
                if (this.verbosePattern > config.II(this.Ii() + ".blocks") * (this.Ii ? 3 : 1) && this.getPlayerData().getPlayer().getItemInHand().getType().isBlock()) {
                    this.flag("a -> " + this.verbosePattern);
                }
                this.Ii = false;
                final int ii = 0;
                this.iI = ii;
                this.verbosePattern = (float)ii;
            }
        }
    }
}
