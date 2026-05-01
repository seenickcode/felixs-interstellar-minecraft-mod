package com.example;

import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;

public class IntroScreen extends Screen {

    private static final String[] LINES = {
        "Your world is really mysterious.",
        "There are always possibilities.",
        "They chose you.",
        "Save Earth with your crew.",
        "Your adventure awaits."
    };

    public IntroScreen() {
        super(Text.empty());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        int lineHeight = 13;
        int artW = 300, artH = 160;
        int artX = (this.width - artW) / 2;
        int artY = 20;

        // Background
        context.fill(0, 0, this.width, this.height, 0xFF0A0A1A);

        // Artwork placeholder
        context.fill(artX, artY, artX + artW, artY + artH, 0xFF1A1A3A);
        context.drawCenteredTextWithShadow(this.textRenderer,
            Text.literal("[ artwork goes here ]"),
            this.width / 2, artY + artH / 2 - 4, 0xFF444466);

        // Story text
        int textStartY = artY + artH + 16;
        for (int i = 0; i < LINES.length; i++) {
            context.drawCenteredTextWithShadow(this.textRenderer,
                Text.literal(LINES[i]),
                this.width / 2, textStartY + i * lineHeight, 0xFFCCCCCC);
        }

        // Prompt
        context.drawCenteredTextWithShadow(this.textRenderer,
            Text.literal("Press any key to continue"),
            this.width / 2, this.height - 30, 0xFF888888);
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        this.client.setScreen(null);
        return true;
    }

    @Override
    public boolean mouseClicked(Click click, boolean bl) {
        this.client.setScreen(null);
        return true;
    }

    @Override
    public boolean shouldPause() {
        return true;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
