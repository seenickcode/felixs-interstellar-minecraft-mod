package com.example;

import com.example.ExampleSounds;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IntroScreen extends Screen {

    private static final int IMG_WIDTH  = 1024;
    private static final int IMG_HEIGHT = 479;

    private static final String[][] SCREEN_LINES = {
        { "Your world is really mysterious.", "There are always possibilities." },
        { "They chose you.", "Save Earth with your crew." },
        { "Your adventure awaits." }
    };

    private static final Identifier[] TEXTURES = {
        Identifier.of("modid", "textures/gui/intro.png"),
        Identifier.of("modid", "textures/gui/intro2.png"),
        Identifier.of("modid", "textures/gui/intro3.png")
    };

    private final int screenIndex;

    public IntroScreen() {
        this(0);
    }

    private IntroScreen(int screenIndex) {
        super(Text.empty());
        this.screenIndex = screenIndex;
    }

    @Override
    public void init() {
        super.init();
        if (screenIndex == 0) {
            this.client.getSoundManager().play(
                PositionedSoundInstance.ambient(ExampleSounds.INTRO_MUSIC, 1.0f, 1.0f)
            );
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        String[] lines = SCREEN_LINES[screenIndex];
        int lineHeight = 13;
        int textBlockH = lines.length * lineHeight;
        int reservedH = 16 + textBlockH + 40;
        int maxArtW = Math.min(this.width - 40, 600);
        int maxArtH = this.height - 20 - reservedH;

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

        context.fill(0, 0, this.width, this.height, 0xFF0A0A1A);

        context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURES[screenIndex],
            artX, artY, 0f, 0f, artW, artH, artW, artH);

        int textStartY = artY + artH + 16;
        for (int i = 0; i < lines.length; i++) {
            context.drawCenteredTextWithShadow(this.textRenderer,
                Text.literal(lines[i]),
                this.width / 2, textStartY + i * lineHeight, 0xFFCCCCCC);
        }

        context.drawCenteredTextWithShadow(this.textRenderer,
            Text.literal("Press any key to continue"),
            this.width / 2, this.height - 30, 0xFF888888);
    }

    private void advance() {
        int next = screenIndex + 1;
        if (next < SCREEN_LINES.length) {
            this.client.setScreen(new IntroScreen(next));
        } else {
            this.client.setScreen(null);
        }
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        advance();
        return true;
    }

    @Override
    public boolean mouseClicked(Click click, boolean bl) {
        advance();
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
