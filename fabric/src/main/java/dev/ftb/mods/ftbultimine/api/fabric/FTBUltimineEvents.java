package dev.ftb.mods.ftbultimine.api.fabric;

import dev.ftb.mods.ftbultimine.api.blockbreaking.RegisterBlockBreakHandlerEvent;
import dev.ftb.mods.ftbultimine.api.blockselection.RegisterBlockSelectionHandlerEvent;
import dev.ftb.mods.ftbultimine.api.crop.RegisterCropLikeEvent;
import dev.ftb.mods.ftbultimine.api.restriction.RegisterRestrictionHandlerEvent;
import dev.ftb.mods.ftbultimine.api.rightclick.RegisterRightClickHandlerEvent;
import dev.ftb.mods.ftbultimine.api.shape.RegisterShapeEvent;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public class FTBUltimineEvents {
    public static final Event<RegisterRightClickHandlerEvent> REGISTER_RIGHT_CLICK_HANDLER
            = EventFactory.createArrayBacked(RegisterRightClickHandlerEvent.class,
            callbacks -> data -> {
                for (var c : callbacks) {
                    c.accept(data);
                }
            });

    public static final Event<RegisterShapeEvent> REGISTER_SHAPE
            = EventFactory.createArrayBacked(RegisterShapeEvent.class,
            callbacks -> data -> {
                for (var c : callbacks) {
                    c.accept(data);
                }
            });

    public static final Event<RegisterCropLikeEvent> REGISTER_CROP_LIKE
            = EventFactory.createArrayBacked(RegisterCropLikeEvent.class,
            callbacks -> data -> {
                for (var c : callbacks) {
                    c.accept(data);
                }
            });

    public static final Event<RegisterRestrictionHandlerEvent> REGISTER_RESTRICTION_HANDLER
            = EventFactory.createArrayBacked(RegisterRestrictionHandlerEvent.class,
            callbacks -> data -> {
                for (var c : callbacks) {
                    c.accept(data);
                }
            });

    public static final Event<RegisterBlockBreakHandlerEvent> REGISTER_BLOCK_BREAK_HANDLER
            = EventFactory.createArrayBacked(RegisterBlockBreakHandlerEvent.class,
            callbacks -> data -> {
                for (var c : callbacks) {
                    c.accept(data);
                }
            });

    public static final Event<RegisterBlockSelectionHandlerEvent> REGISTER_BLOCK_SELECTION_HANDLER
            = EventFactory.createArrayBacked(RegisterBlockSelectionHandlerEvent.class,
            callbacks -> data -> {
                for (var c : callbacks) {
                    c.accept(data);
                }
            });
}
