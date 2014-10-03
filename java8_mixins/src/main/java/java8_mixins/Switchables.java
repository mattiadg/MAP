package java8_mixins;
import java.util.HashMap;
import java.util.Map;

public final class Switchables {
 
    private static final Map<SwitchableMixin, SwitchableDeviceState> SWITCH_STATES = new HashMap<>();
 
    public static boolean isActivated(SwitchableMixin device) {
        SwitchableDeviceState state = SWITCH_STATES.get(device);
        return state != null && state.activated;
    }
 
    public static void setActivated(SwitchableMixin device, boolean activated) {
        SwitchableDeviceState state = SWITCH_STATES.get(device);
        if (state == null) {
            state = new SwitchableDeviceState();
            SWITCH_STATES.put(device, state);
        }
        state.activated = activated;
    }
 
    private static class SwitchableDeviceState {
        private boolean activated;
    }
 
}