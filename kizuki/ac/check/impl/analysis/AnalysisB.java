package kizuki.ac.check.impl.analysis;

import kizuki.ac.check.*;
import java.util.concurrent.*;
import kizuki.ac.data.*;
import kizuki.ac.api.*;
import kizuki.ac.packet.*;
import kizuki.ac.utils.*;
import kizuki.ac.packet.wrapper.*;

public class AnalysisB extends KizukiCheck
{
    ConcurrentLinkedQueue verbosePattern;
    ConcurrentLinkedQueue iI;
    ConcurrentLinkedQueue Ii;
    ConcurrentLinkedQueue ii;
    ConcurrentLinkedQueue ll;
    ConcurrentLinkedQueue lI;
    int verbosePattern;
    float verbosePattern;
    float iI;
    float Ii;
    float ii;
    float ll;
    float lI;
    float Il;
    int iI;
    int Ii;
    int ii;
    int ll;
    float LL;
    float qq;
    float qw;
    float qe;
    
    public AnalysisB(final PlayerData playerData) {
        super(playerData, CheckType.ANALYSIS, "Analysis (B)", "AnalysisB", DevelopmentState.EXPERIMENTAL, true);
        this.verbosePattern = new ConcurrentLinkedQueue();
        this.iI = new ConcurrentLinkedQueue();
        this.Ii = new ConcurrentLinkedQueue();
        this.ii = new ConcurrentLinkedQueue();
        this.ll = new ConcurrentLinkedQueue();
        this.lI = new ConcurrentLinkedQueue();
        this.verbosePattern = 5;
        this.verbosePattern = 0.0f;
        this.iI = 0.0f;
        this.Ii = -69.0f;
        this.ii = -69.0f;
        this.ll = -69.0f;
        this.lI = -69.0f;
        this.Il = -69.0f;
        this.iI = 0;
        this.Ii = 0;
        this.ii = 0;
        this.ll = 0;
        this.LL = -69.0f;
        this.qq = 0.0f;
        this.qw = 0.0f;
        this.qe = 0.0f;
    }
    
    @Override
    public void handle(final Packet packet) {
        if (packet instanceof CPacketFlying) {
            if (this.getPlayerData().II(3)) {
                return;
            }
            final float deltaYaw = ((CPacketFlying)packet).getDeltaYaw();
            final float deltaPitch = ((CPacketFlying)packet).getDeltaPitch();
            final float abs = Math.abs(this.verbosePattern - deltaYaw);
            final float abs2 = Math.abs(this.iI - deltaPitch);
            if (this.verbosePattern < 10) {
                if (deltaYaw > 0.1 && deltaYaw < 9.0f) {
                    this.verbosePattern.add(Math.abs(this.qq - abs));
                    this.Ii.add(abs);
                    this.ll.add(deltaYaw);
                }
                if (deltaPitch > 0.1 && deltaPitch < 9.0f) {
                    this.iI.add(Math.abs(this.qw - abs2));
                    this.ii.add(abs2);
                    this.lI.add(deltaPitch);
                }
                if (abs2 < 0.15) {
                    ++this.iI;
                }
                if (abs2 > 7.0f) {
                    ++this.Ii;
                }
                if (abs < 0.15) {
                    ++this.ii;
                }
                if (abs > 7.0f) {
                    ++this.ll;
                }
            }
            if (this.Ii.size() >= 500) {
                final float ii = (float)MathUtil.getAverage(this.Ii);
                final float ll = (float)MathUtil.getAverage(this.ll);
                final float li = (float)MathUtil.getAverage(this.verbosePattern);
                final int n6 = (int)this.ll.stream().filter(n -> n < 2.0f).count();
                final int n7 = (int)this.ll.stream().filter(n2 -> n2 > 7.5f).count();
                final int n8 = (int)this.ll.stream().filter(n3 -> n3 > 7.5f).count();
                final int n9 = (int)(this.ll.size() - this.ll.stream().distinct().count());
                final int n10 = (int)(this.Ii.size() - this.Ii.stream().distinct().count());
                this.debug("uA -> " + n10);
                if (n6 > 120 && n7 > 120) {
                    this.flag("t/d (y), l -> " + n6 + ", h ->" + n7);
                }
                if (n8 > 175) {
                    this.flag("u/hacc (y) sah -> " + n8);
                }
                this.debug("accAcc -> " + Math.abs(this.lI - li) + ", acc -> " + Math.abs(this.ii - ii) + ", avg -> " + Math.abs(this.LL - ll));
                this.debug("smp -> " + this.iI + ", smy -> " + this.ii + ", lp -> " + this.Ii + ", ly -> " + this.ll);
                this.debug("---------------------------------------------");
                if (Math.abs(this.LL - ll) < 0.0075 && ii > 3.5) {
                    this.debug("t/r, yAvg -> " + ll + ", diff -> " + Math.abs(this.LL - ll) + ", YAA -> " + ii);
                }
                if (n10 > 450 || n10 < 30) {
                    this.flag("t/uaac, (y) uA -> " + n10 / 500 * 100 + "%");
                }
                if (n9 < 15) {
                    this.flag("t/u, u -> " + n9 / 500 * 100 + "%");
                }
                else if (n9 > 440) {
                    this.flag("t/uu, u -> " + n9 / 500 * 100 + "%");
                }
                this.verbosePattern.clear();
                this.Ii.clear();
                this.ll.clear();
                this.lI = li;
                this.LL = ll;
                this.ii = ii;
                final int n11 = 0;
                this.Ii = n11;
                this.ll = n11;
                this.ii = n11;
                this.iI = n11;
            }
            if (this.ii.size() >= 500) {
                final float ii2 = (float)MathUtil.getAverage(this.ii);
                final float ll2 = (float)MathUtil.getAverage(this.lI);
                final float li2 = (float)MathUtil.getAverage(this.iI);
                final int n12 = (int)this.lI.stream().filter(n4 -> n4 < 1.0f).count();
                final int n13 = (int)this.lI.stream().filter(n5 -> n5 > 5.0f).count();
                if (n12 > 100 && n13 > 100) {
                    this.flag("t/d (p), l -> " + n12 + ", h ->" + n13);
                }
                final int n14 = (int)(this.ii.size() - this.ii.stream().distinct().count());
                this.debug("puA -> " + n14);
                if (n14 > 400 || n14 < 150) {
                    this.flag("(p) uA -> " + n14 / 500 * 100 + "%");
                }
                this.ii.clear();
                this.lI.clear();
                this.iI.clear();
                this.lI = li2;
                this.ll = ll2;
                this.Ii = ii2;
            }
            this.qq = abs;
            this.qw = abs2;
            this.verbosePattern = deltaYaw;
            this.iI = deltaPitch;
            ++this.verbosePattern;
        }
        else if (packet instanceof CPacketUseEntity) {
            this.verbosePattern = 0;
        }
    }
}
