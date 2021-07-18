package kizuki.ac.check.impl.packet;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.*;
import kizuki.ac.packet.wrapper.*;

public class PacketE extends KizukiCheck
{
    int verbosePattern;
    boolean iI;
    boolean Ii;
    long verbosePattern;
    int iI;
    
    public PacketE(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Packet (E)", "PacketE", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = -69;
        this.iI = false;
        this.Ii = false;
        this.verbosePattern = -69L;
        this.iI = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CHeldItemSlot) {
            ++this.iI;
            final int face = ((CHeldItemSlot)packet).getFace();
            if (face == this.verbosePattern) {
                this.flag("t/sl");
            }
            if (face < 0 && face != -999 && face != -1) {
                this.flag("t/isl");
            }
            this.verbosePattern = face;
        }
        else if (packet instanceof uy) {
            this.Ii = false;
        }
        else if (packet instanceof ut) {
            this.verbosePattern = System.currentTimeMillis();
        }
        else if (packet instanceof CPacketEntityAction) {
            this.Ii("act");
        }
        else if (packet instanceof CPacketUseEntity) {
            this.Ii("ue");
        }
        else if (packet instanceof CPacketBlockPlace) {
            this.Ii("bp");
        }
        else if (packet instanceof CPacketDig) {
            this.Ii("bd");
        }
        else if (packet instanceof CPacketFlying) {
            this.iI = 0;
        }
    }
    
    void Ii(final String s) {
        if (this.Ii) {
            this.flag("t/" + s);
        }
    }
}
