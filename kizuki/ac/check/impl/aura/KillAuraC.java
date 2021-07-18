package kizuki.ac.check.impl.aura;

import kizuki.ac.check.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.packet.wrapper.*;
import com.comphenix.protocol.wrappers.*;

public class KillAuraC extends KizukiCheck
{
    int useTicks;
    int releaseItem;
    int release;
    int ii;
    private int ll;
    private int lI;
    
    public KillAuraC(final PlayerData playerData) {
        super(playerData, CheckType.KILLAURA, "KillAura (C)", "KillAuraC", DevelopmentState.FINAL, false);
        this.useTicks = 0;
        this.releaseItem = 0;
        this.release = 0;
        this.ii = 0;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.getPlayerData().isBlocking()) {
                ++this.ll;
                this.lI = 0;
            }
            else {
                ++this.lI;
                if (this.lI > 1) {
                    this.ii = 0;
                    this.ll = 0;
                }
            }
        }
        else if (packet instanceof CPacketDig) {
            if (((CPacketDig)packet).getDigType() == EnumWrappers$PlayerDigType.RELEASE_USE_ITEM && this.getPlayerData().hitTicks < 3) {
                ++this.releaseItem;
            }
            if (((CPacketDig)packet).getDigType() == EnumWrappers$PlayerDigType.RELEASE_USE_ITEM) {
                ++this.release;
            }
            this.debug("sw " + this.releaseItem);
        }
        else if (packet instanceof CPacketTickWTF) {
            if (this.release > 7) {
                this.flag("bl -> " + this.release);
            }
            this.release = 0;
        }
        else if (packet instanceof CPacketUseEntity && ((CPacketUseEntity)packet).getAction() == EnumWrappers$EntityUseAction.ATTACK) {
            ++this.useTicks;
            this.debug("hit " + this.useTicks);
            if (this.ll >= 6) {
                if (this.ii++ > 1) {
                    this.flag("b -> " + this.ll);
                }
                else if (this.ii == 1) {
                    this.getPlayerData().shuffleHotbar();
                }
            }
            if (this.useTicks >= 10) {
                if (this.releaseItem > 7) {
                    this.flag("b -> " + this.releaseItem + ", c -> " + this.useTicks);
                }
                this.debug("lol");
                final int n = 0;
                this.useTicks = n;
                this.releaseItem = n;
            }
        }
    }
}
