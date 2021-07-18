package kizuki.ac.packet;

import java.util.concurrent.*;
import kizuki.ac.event.*;
import kizuki.ac.check.*;
import com.comphenix.protocol.events.*;
import kizuki.ac.utils.*;
import kizuki.ac.*;
import com.comphenix.protocol.*;

public class PacketManager
{
    private static final ProtocolManager manager;
    public static ConcurrentHashMap II;
    final ConcurrentHashMap iI;
    
    public PacketManager() {
        this.iI = new ConcurrentHashMap();
        this.init();
        this.II();
    }
    
    public static void II(final Packet packet) {
        BukkitEventListener2.II(packet);
    }
    
    private void init() {
        PacketManager.manager.addPacketListener((PacketListener)new tj(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.USE_ENTITY }));
        PacketManager.manager.addPacketListener((PacketListener)new yw(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.FLYING, PacketType$Play$Client.POSITION, PacketType$Play$Client.POSITION_LOOK, PacketType$Play$Client.LOOK }));
        PacketManager.manager.addPacketListener((PacketListener)new yi(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.STEER_VEHICLE }));
        PacketManager.manager.addPacketListener((PacketListener)new yo(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.ENTITY_ACTION }));
        PacketManager.manager.addPacketListener((PacketListener)new yp(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.TRANSACTION }));
        PacketManager.manager.addPacketListener((PacketListener)new ya(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Server.TRANSACTION }));
        PacketManager.manager.addPacketListener((PacketListener)new ys(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.ABILITIES }));
        PacketManager.manager.addPacketListener((PacketListener)new yd(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Server.ABILITIES }));
        PacketManager.manager.addPacketListener((PacketListener)new yf(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.SPECTATE }));
        PacketManager.manager.addPacketListener((PacketListener)new tk(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.ARM_ANIMATION }));
        PacketManager.manager.addPacketListener((PacketListener)new tl(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.BLOCK_DIG }));
        PacketManager.manager.addPacketListener((PacketListener)new tz(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Server.ENTITY_VELOCITY }));
        PacketManager.manager.addPacketListener((PacketListener)new tx(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Server.CLOSE_WINDOW }));
        PacketManager.manager.addPacketListener((PacketListener)new tc(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Server.OPEN_WINDOW }));
        PacketManager.manager.addPacketListener((PacketListener)new tv(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.CLOSE_WINDOW }));
        PacketManager.manager.addPacketListener((PacketListener)new tb(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.WINDOW_CLICK }));
        PacketManager.manager.addPacketListener((PacketListener)new tn(this, Checkable.plugin, ListenerPriority.MONITOR, new PacketType[] { PacketType$Play$Server.POSITION }));
        if (BukkitEventListener2.II().equals(ServerVersions.Ii)) {
            PacketManager.manager.addPacketListener((PacketListener)new tm(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.TELEPORT_ACCEPT }));
        }
        PacketManager.manager.addPacketListener((PacketListener)new yq(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.BLOCK_PLACE }));
        PacketManager.manager.addPacketListener((PacketListener)new ye(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.USE_ITEM }));
        PacketManager.manager.addPacketListener((PacketListener)new yr(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.HELD_ITEM_SLOT }));
        try {
            PacketManager.manager.addPacketListener((PacketListener)new yt(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Server.REL_ENTITY_MOVE, PacketType$Play$Server.REL_ENTITY_MOVE_LOOK, PacketType$Play$Server.ENTITY_LOOK }));
        }
        catch (NoSuchFieldError noSuchFieldError) {
            Checkable.logger.warning("Skipped REL_ENTITY_MOVE_LOOK");
        }
        PacketManager.manager.addPacketListener((PacketListener)new yy(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Server.ENTITY_TELEPORT }));
        PacketManager.manager.addPacketListener((PacketListener)new yu(this, Checkable.plugin, ListenerPriority.HIGHEST, new PacketType[] { PacketType$Play$Client.SETTINGS }));
    }
    
    public void II() {
    }
    
    static {
        manager = ProtocolLibrary.getProtocolManager();
        PacketManager.II = new ConcurrentHashMap();
    }
}
