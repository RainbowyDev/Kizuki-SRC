package kizuki.ac.api;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public class KizukiACFlagEvent extends Event implements Cancellable
{
    private static final HandlerList handlers;
    private final Player player;
    private final KizukiACCheckAPI checkAPI;
    private String verbose;
    private float multiplier;
    private boolean cancelled;
    
    public KizukiACFlagEvent(final Player player, final KizukiACCheckAPI checkAPI, final String verbose, final Float n) {
        this.player = player;
        this.checkAPI = checkAPI;
        this.verbose = verbose;
        this.multiplier = n;
    }
    
    public KizukiACFlagEvent(final Player player, final KizukiACCheckAPI checkAPI) {
        this.player = player;
        this.checkAPI = checkAPI;
        this.verbose = "";
        this.multiplier = 1.0f;
    }
    
    public KizukiACFlagEvent(final Player player, final KizukiACCheckAPI checkAPI, final String verbose) {
        this.player = player;
        this.checkAPI = checkAPI;
        this.verbose = verbose;
        this.multiplier = 1.0f;
    }
    
    @NotNull
    public static HandlerList getHandlerList() {
        return KizukiACFlagEvent.handlers;
    }
    
    @NotNull
    public HandlerList getHandlers() {
        return KizukiACFlagEvent.handlers;
    }
    
    public String getVerbose() {
        return this.verbose;
    }
    
    public void setVerbose(final String verbose) {
        this.verbose = verbose;
    }
    
    public float getMultiplier() {
        return this.multiplier;
    }
    
    public void setMultiplier(final float multiplier) {
        this.multiplier = multiplier;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public KizukiACCheckAPI getCheckAPI() {
        return this.checkAPI;
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
