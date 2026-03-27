package dev.ftb.mods.ftbultimine.api.crop;

import java.util.function.Consumer;

/// Fired on server startup to register a custom croplike detection handler. This can be used to
/// implement right-click harvesting behaviour for crops that don't behave like vanilla crops (Ultimine registers a
/// builtin handler for all vanilla crops including sweet berries and cocoa beans).
@FunctionalInterface
public interface RegisterCropLikeEvent extends Consumer<RegisterCropLikeEvent.Data> {
    record Data(Consumer<CropLikeHandler> consumer) {
        /**
         * Register a new handler.
         *
         * @param handler the handler to register
         */
        public void registerHandler(CropLikeHandler handler) {
            consumer.accept(handler);
        }
    }
}
