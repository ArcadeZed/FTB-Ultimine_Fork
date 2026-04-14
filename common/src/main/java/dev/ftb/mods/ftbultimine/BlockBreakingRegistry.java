package dev.ftb.mods.ftbultimine;

import dev.ftb.mods.ftbultimine.api.blockbreaking.BlockBreakHandler;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public enum BlockBreakingRegistry {
    INSTANCE;

    private final Collection<BlockBreakHandler> handlers = new CopyOnWriteArrayList<>();

    public static BlockBreakingRegistry getInstance() {
        return INSTANCE;
    }

    public void registerHandler(BlockBreakHandler handler) {
        handlers.add(handler);
    }

    public Collection<BlockBreakHandler> getHandlers() {
        return Collections.unmodifiableCollection(handlers);
    }

    public void clear() {
        handlers.clear();
    }
}
