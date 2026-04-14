package dev.ftb.mods.ftbultimine;

import dev.ftb.mods.ftbultimine.api.blockselection.BlockSelectionHandler;
import dev.ftb.mods.ftbultimine.api.blockselection.RegisterBlockSelectionHandlerEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public enum BlockSelectionRegistry {
    INSTANCE;

    private final Collection<BlockSelectionHandler> handlers = new CopyOnWriteArrayList<>();

    public static BlockSelectionRegistry getInstance() {
        return INSTANCE;
    }

    public void registerHandler(BlockSelectionHandler handler) {
        handlers.add(handler);
    }

    public Collection<BlockSelectionHandler> getHandlers() {
        return Collections.unmodifiableCollection(handlers);
    }

    public void clear() {
        handlers.clear();
    }
}
