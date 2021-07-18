package kizuki.ac.utils.gui;

import java.util.concurrent.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import kizuki.ac.*;
import org.bukkit.inventory.*;

public class ChestGUI
{
    private final int II;
    private final String II;
    private ConcurrentHashMap II;
    private ArrayList II;
    
    public ChestGUI(final int ii, final String ii2) {
        if (ii2.equals("Chest")) {
            throw new IllegalArgumentException("ChestGui cant be named \"Chest\"");
        }
        if (ii < 1) {
            throw new IllegalArgumentException("Rows cant be lower than 1");
        }
        this.II = ii;
        this.II = ii2;
        this.II = new ConcurrentHashMap();
        this.II = new ArrayList();
    }
    
    public ConcurrentHashMap II() {
        return this.II;
    }
    
    public void II(final ChestButton chestButton) {
        this.II(chestButton.II());
    }
    
    public void iI(final ChestButton chestButton) {
        this.II.remove(chestButton);
    }
    
    public void Ii(final ChestButton chestButton) {
        final int ii = chestButton.II();
        if (!this.II.containsKey(ii)) {
            throw new IllegalArgumentException("Item is null");
        }
        final Iterator<ChestButton> iterator = this.II().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().II() == ii) {
                return;
            }
        }
        this.II.add(chestButton);
    }
    
    public void II(final int n, final ItemStack itemStack, final ChestButton chestButton) {
        this.II(n);
        this.II(n, itemStack);
        chestButton.II(n - 1);
        this.Ii(chestButton);
    }
    
    public void II(final Player player) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 9 * this.II, Il.translateColorCodes(this.II));
        for (final Map.Entry<Integer, V> entry : this.II.entrySet()) {
            inventory.setItem((int)entry.getKey(), (ItemStack)entry.getValue());
        }
        player.openInventory(inventory);
        iI.II(this);
    }
    
    public void II() {
        this.II = new ConcurrentHashMap();
        this.II = new ArrayList();
    }
    
    public ItemStack II(int n) {
        --n;
        for (final ChestButton chestButton : this.II()) {
            if (chestButton.II() == n) {
                this.II.remove(chestButton);
                break;
            }
        }
        return this.II.remove(n);
    }
    
    public void II(int n, final ItemStack itemStack) {
        --n;
        if (this.II.containsKey(n)) {
            throw new IllegalArgumentException("This slot is already bound! Remove item first");
        }
        this.II.put(n, itemStack);
    }
    
    public void II(int n, int n2, final ItemStack itemStack) {
        --n;
        if (--n2 > 9 || n > 6) {
            throw new IllegalArgumentException("Slot or rows are higher than possible value");
        }
        this.II.put(n * 9 + n2, itemStack);
    }
    
    public int II() {
        return this.II;
    }
    
    public String II() {
        return this.II;
    }
    
    public ArrayList II() {
        return this.II;
    }
}
