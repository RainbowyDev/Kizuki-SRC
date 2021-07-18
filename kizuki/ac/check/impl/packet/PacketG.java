package kizuki.ac.check.impl.packet;

import kizuki.ac.check.*;
import java.util.concurrent.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.*;
import kizuki.ac.packet.wrapper.*;

public class PacketG extends KizukiCheck
{
    private final ConcurrentLinkedQueue verbosePattern;
    private int verbosePattern;
    private int iI;
    private long verbosePattern;
    
    public PacketG(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Packet (G)", "PacketG", DevelopmentState.FINAL, false);
        this.verbosePattern = 0;
        this.iI = 0;
        this.verbosePattern = 0L;
        this.verbosePattern = new ConcurrentLinkedQueue();
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof ug) {
            this.verbosePattern.add(((ug)packet).getId());
        }
        else if (packet instanceof CPacketTransaction) {
            try {
                if (this.verbosePattern.contains(((CPacketTransaction)packet).getId())) {
                    if (Math.abs(System.currentTimeMillis() - this.verbosePattern) < 20L) {
                        this.getPlayerData().LL = true;
                        this.getPlayerData().iI = (double)this.getTime();
                    }
                    else {
                        this.getPlayerData().LL = false;
                        this.iI = 0;
                    }
                    this.verbosePattern.remove(((CPacketTransaction)packet).getId());
                    this.verbosePattern = System.currentTimeMillis();
                    this.debug("l ->" + this.getPlayerData().LL);
                }
                else if (this.verbosePattern++ > 1 && config.II(this.Ii() + ".shouldflag")) {
                    this.flag("t -> " + this.verbosePattern);
                }
            }
            catch (Exception ex) {}
        }
    }
}
