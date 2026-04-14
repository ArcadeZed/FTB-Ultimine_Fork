package dev.ftb.mods.ftbultimine.api.restriction;

import java.util.function.Consumer;

/// Listen to this event to register custom restriction handlers; this can be used to impose limits on when ultimining
/// is possible. E.g. require player to be holding a specific item or have a particular bauble equipped.
///
/// Corresponding platform-native events to listen to:
/// * `FTBUltimineEvent.RegisterRestrictionHandler` (NeoForge)
/// * `FTBUltimineEvents.REGISTER_RESTRICTION_HANDLER` (Fabric)
@FunctionalInterface
public interface RegisterRestrictionHandlerEvent extends Consumer<RegisterRestrictionHandlerEvent.Data> {
    record Data(Consumer<RestrictionHandler> consumer) {
        /// Register a new handler.
        ///
        /// @param handler the handler to register
        public void register(RestrictionHandler handler) {
            consumer.accept(handler);
        }
    }
}
