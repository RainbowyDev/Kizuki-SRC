package kizuki.ac.api;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import org.bukkit.*;
import org.jetbrains.annotations.*;

public class KizukiACSetBackEvent extends Event implements Cancellable
{
    private static final HandlerList handlers;
    final Player player;
    Vector velocity;
    Location setbackTo;
    private boolean cancelled;
    
    public KizukiACSetBackEvent(final Player player, final Vector velocity, final Location setbackTo) {
        this.cancelled = false;
        this.player = player;
        this.velocity = velocity;
        this.setbackTo = setbackTo;
    }
    
    @NotNull
    public static HandlerList getHandlerList() {
        return KizukiACSetBackEvent.handlers;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Vector getVelocity() {
        return this.velocity;
    }
    
    public void setVelocity(final Vector velocity) {
        this.velocity = velocity;
    }
    
    public Location getSetbackTo() {
        return this.setbackTo;
    }
    
    public void setSetbackTo(final Location setbackTo) {
        this.setbackTo = setbackTo;
    }
    
    @NotNull
    public HandlerList getHandlers() {
        return KizukiACSetBackEvent.handlers;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }
    
    static {
        handlers = new HandlerList();
    }
}
