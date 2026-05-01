package com.example;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IntroScreen extends Screen {

    private static final String[] LINES = {
        "Your world is really mysterious.",
        "There are always possibilities.",
        "They chose you.",
        "Save Earth with your crew.",
        "Your adventure awaits."
    };

    // Must match the actual file at:
    //   src/main/resources/assets/modid/textures/gui/intro.png
    private static final Identifier INTRO_TEXTURE =
        Identifier.of("modid", "textures/gui/intro.png");

    // Actual pixel dimensions of intro.png – adjust if your image differs
    private static final int IMG_WIDTH  = 1024;
    private static final int IMG_HEIGHT = 479;

    public IntroScreen() {
        super(Text.empty());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        int lineHeight = 13;
        int textBlockH = LINES.length * lineHeight;
        int reservedH = 16 + textBlockH + 40;
        int maxArtW = Math.min(this.width - 40, 600);
        int maxArtH = this.height - 20 - reservedH;
        // Scale both dimensions together to preserve aspect ratio
        int artW, artH;
        int naturalH = (int)((float) maxArtW * IMG_HEIGHT / IMG_WIDTH);
        if (naturalH <= maxArtH) {
            artW = maxArtW;
            artH = naturalH;
        } else {
            artH = maxArtH;
            artW = (int)((float) artH * IMG_WIDTH / IMG_HEIGHT);
        }
        int artX = (this.width - artW) / 2;
        int artY = 20;

        // Dark background fill
        context.fill(0, 0, this.width, this.height, 0xFF0A0A1A);

        // Passing artW/artH as both display size and texture reference size forces
        // UV to span 0→1 across the full image, which scales it to fill the rect.
        context.drawTexture(RenderPipelines.GUI_TEXTURED, INTRO_TEXTURE, artX, artY, 0f, 0f, artW, artH, artW, artH);

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
