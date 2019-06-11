package com.joshchappelle.creeperx;

import com.joshchappelle.creeperx.cookie.Cookie;
import net.fabricmc.api.ModInitializer;

public class Mod implements ModInitializer {

	@Override
	public void onInitialize() {
		Cookie.init();
	}

}
