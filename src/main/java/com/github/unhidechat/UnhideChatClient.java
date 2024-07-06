package com.github.unhidechat;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnhideChatClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("unhidechat");

	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing keybindings");
		ChatHandler.initializeKeyBindings();
		ChatHandler.registerKeyBindings();
	}
}