package example2;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

interface FakeBrokenMixin {
	static Map<FakeBrokenMixin, String> backingMap = Collections
			.synchronizedMap(new WeakHashMap<FakeBrokenMixin, String>());

	default String getName() {
		return backingMap.get(this);
	}

	default void setName(String name) {
		backingMap.put(this, name);
	}
}