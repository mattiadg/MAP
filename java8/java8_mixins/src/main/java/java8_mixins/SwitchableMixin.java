package java8_mixins;
public interface SwitchableMixin {
	default boolean isActivated() {
		return Switchables.isActivated(this);
	}

	default void setActivated(boolean activated) {
		Switchables.setActivated(this, activated);
	}
}