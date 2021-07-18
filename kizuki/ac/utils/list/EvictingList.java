package kizuki.ac.utils.list;

import java.util.*;

public final class EvictingList extends LinkedList
{
    private final int size;
    private final boolean inverted;
    
    public EvictingList(final int size) {
        this.size = size;
        this.inverted = false;
    }
    
    public EvictingList(final int size, final boolean inverted) {
        this.size = size;
        this.inverted = inverted;
    }
    
    @Override
    public boolean add(final Object o) {
        if (super.size() >= this.size) {
            if (this.inverted) {
                super.removeFirst();
            }
            else {
                super.clear();
            }
        }
        return super.add(o);
    }
    
    public boolean isFull() {
        return this.size() >= this.size;
    }
}
