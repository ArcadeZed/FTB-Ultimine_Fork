package dev.ftb.mods.ftbultimine.api.shape;

import java.util.function.Consumer;

/// Listen to this event (fired on common startup) to register custom ultimining shapes.
///
/// Corresponding platform-native events to listen to:
/// * `FTBUltimineEvent.RegisterShape` (NeoForge)
/// * `FTBUltimineEvents.REGISTER_SHAPE` (Fabric)
@FunctionalInterface
public interface RegisterShapeEvent extends Consumer<RegisterShapeEvent.Data> {
    record Data(Consumer<Shape> consumer) {
        /// Register a new shape.
        ///
        /// @param shape the shape to register
        public void register(Shape shape) {
            consumer.accept(shape);
        }
    }
}
