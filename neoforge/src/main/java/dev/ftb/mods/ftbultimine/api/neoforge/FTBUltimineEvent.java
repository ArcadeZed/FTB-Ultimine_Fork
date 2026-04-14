package dev.ftb.mods.ftbultimine.api.neoforge;

import dev.ftb.mods.ftblibrary.api.neoforge.BaseEventWithData;
import dev.ftb.mods.ftbultimine.api.blockbreaking.RegisterBlockBreakHandlerEvent;
import dev.ftb.mods.ftbultimine.api.blockselection.RegisterBlockSelectionHandlerEvent;
import dev.ftb.mods.ftbultimine.api.crop.RegisterCropLikeEvent;
import dev.ftb.mods.ftbultimine.api.restriction.RegisterRestrictionHandlerEvent;
import dev.ftb.mods.ftbultimine.api.rightclick.RegisterRightClickHandlerEvent;
import dev.ftb.mods.ftbultimine.api.shape.RegisterShapeEvent;

public class FTBUltimineEvent {
    public static class RegisterRightClickHandler extends BaseEventWithData<RegisterRightClickHandlerEvent.Data> {
        public RegisterRightClickHandler(RegisterRightClickHandlerEvent.Data data) {
            super(data);
        }
    }

    public static class RegisterShape extends BaseEventWithData<RegisterShapeEvent.Data> {
        public RegisterShape(RegisterShapeEvent.Data data) {
            super(data);
        }
    }

    public static class RegisterCropLike extends BaseEventWithData<RegisterCropLikeEvent.Data> {
        public RegisterCropLike(RegisterCropLikeEvent.Data data) {
            super(data);
        }
    }

    public static class RegisterRestrictionHandler extends BaseEventWithData<RegisterRestrictionHandlerEvent.Data> {
        public RegisterRestrictionHandler(RegisterRestrictionHandlerEvent.Data data) {
            super(data);
        }
    }

    public static class RegisterBlockBreakHandler extends BaseEventWithData<RegisterBlockBreakHandlerEvent.Data> {
        public RegisterBlockBreakHandler(RegisterBlockBreakHandlerEvent.Data data) {
            super(data);
        }
    }

    public static class RegisterBlockSelectionHandler extends BaseEventWithData<RegisterBlockSelectionHandlerEvent.Data> {
        public RegisterBlockSelectionHandler(RegisterBlockSelectionHandlerEvent.Data data) {
            super(data);
        }
    }
}
