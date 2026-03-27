package dev.ftb.mods.ftbultimine.api.rightclick;

import java.util.function.Consumer;

/// Fired on server startup to register custom right-click ultimining handlers. See also: [RightClickHandler].
///
/// Corresponding platform-native events to listen to:
/// * `FTBUltimineEvent.RegisterRightClickHandler` (NeoForge)
/// * `FTBUltimineEvents.REGISTER_RIGHT_CLICK_HANDLER` (Fabric)
@FunctionalInterface
public interface RegisterRightClickHandlerEvent extends Consumer<RegisterRightClickHandlerEvent.Data> {
    record Data(Consumer<RightClickHandler> consumer) {
        /// Register a new handler.
        /// @param handler the right-click handler to be registered
        public void registerHandler(RightClickHandler handler) {
            consumer.accept(handler);
        }
    }
}
