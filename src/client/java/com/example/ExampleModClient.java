package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPlayConnectionEvents.JOIN.register((handler, sender, client) ->
			client.execute(() -> client.setScreen(new IntroScreen()))
		);
	}
}