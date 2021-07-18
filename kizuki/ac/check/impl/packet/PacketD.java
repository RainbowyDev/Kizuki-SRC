package kizuki.ac.check.impl.packet;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.*;

public class PacketD extends KizukiCheck
{
    int verbosePattern;
    short verbosePattern;
    long verbosePattern;
    private long iI;
    
    public PacketD(final PlayerData playerData) {
        super(playerData, CheckType.PACKET, "Packet (D)", "PacketD", DevelopmentState.EXPERIMENTAL, false);
        this.verbosePattern = 0;
        this.verbosePattern = 0;
        this.verbosePattern = 0L;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof ut) {
            this.debug(((ut)packet).getId() + "");
            final int n = (int)(this.getTime() - this.verbosePattern);
            if (n > 5 && this.iI == n) {
                this.flag("a/b a -> " + n);
            }
            if (n > 5 && n < 30) {
                if (this.verbosePattern++ > 2) {
                    this.flag("a/c a -> " + n);
                }
            }
            else {
                this.verbosePattern = 0;
            }
            if (this.verbosePattern > 1 && this.verbosePattern == ((ut)packet).getId()) {
                this.flag("a/a a -> " + this.verbosePattern);
            }
            this.verbosePattern = ((ut)packet).getId();
            this.iI = n;
            this.verbosePattern = this.getTime();
        }
    }
}
