package com.mapuainvaders.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Outro implements Screen, InputProcessor {

    private SpriteBatch batch;
    
    private Music Background;
    public float backgroundMusicDb = MainMenu.backgroundMusicDb;

    private TextureRegion currentFrame;
    private BitmapFont Space;
    private boolean skip = false;
    
    private Animation<TextureRegion> gif1;
    private Animation<TextureRegion> gif2;
    private Animation<TextureRegion> gif3;
    private Animation<TextureRegion> gif4;
    private Animation<TextureRegion> gif5;
    private Animation<TextureRegion> gif6;
    private float elapsed;
    private int currentState;

    private static final int STATE_GIF1 = 0;
    private static final int STATE_GIF2 = 1;
    private static final int STATE_GIF3 = 2;
    private static final int STATE_GIF4 = 3;
    private static final int STATE_GIF5 = 4;
    private static final int STATE_GIF6 = 5;

    @Override
    public void show() {
        batch = new SpriteBatch();

        //text
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Mojang-Regular.ttf"));
        
        FreeTypeFontGenerator.FreeTypeFontParameter Skip = new FreeTypeFontGenerator.FreeTypeFontParameter();
        Skip.size = 21;
        Skip.color = Color.WHITE;
        
        Space = generator.generateFont(Skip);
        
        generator.dispose();
        
        // Load gif animations
        gif1 = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("outro/gif0.gif").read());
        gif2 = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("outro/gif1.gif").read());
        gif3 = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("outro/gif2.gif").read());
        gif4 = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("outro/gif3.gif").read());
        gif5 = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("outro/gif4.gif").read());
        gif6 = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("outro/gif5.gif").read());

        currentState = STATE_GIF1;
        
        Background = Gdx.audio.newMusic(Gdx.files.internal("Music/End.wav"));
        Background.setLooping(false);
        Background.setVolume(backgroundMusicDb + 3f);
    }

    @Override
    public void render(float delta) {
    	handleInput(delta);
        elapsed += delta;
        
        switch (currentState) {
        case STATE_GIF1:
            currentFrame = gif1.getKeyFrame(elapsed);
            if (gif1.isAnimationFinished(elapsed)) {
                currentState = STATE_GIF2;
                elapsed = 0f; // Reset elapsed time for the next gif
                Background.play();
            }
            break;
        case STATE_GIF2:
            currentFrame = gif2.getKeyFrame(elapsed);
            if (gif2.isAnimationFinished(elapsed)) {
                currentState = STATE_GIF3;
                elapsed = 0f; // Reset elapsed time for the next gif
                skip = true;
            }
            break;
        case STATE_GIF3:
            currentFrame = gif3.getKeyFrame(elapsed);
            if (gif3.isAnimationFinished(elapsed)) {
            	currentState = STATE_GIF4;
                elapsed = 0f; // Reset elapsed time for the next gif
            }
            break;
        case STATE_GIF4:
        	currentFrame = gif4.getKeyFrame(elapsed);
        	if (gif4.isAnimationFinished(elapsed)) {
        		currentState = STATE_GIF5;
                elapsed = 0f; // Reset elapsed time for the next gif
        	}
        	break;
        case STATE_GIF5:
        	currentFrame = gif5.getKeyFrame(elapsed);
        	if (gif5.isAnimationFinished(elapsed)) {
        		currentState = STATE_GIF6;
        		elapsed = 0f; // Reset elapsed time for the next gif
        		skip = false;
        	}
        	break;
        case STATE_GIF6:
        	currentFrame = gif6.getKeyFrame(elapsed);
        	if (gif6.isAnimationFinished(elapsed)) {
        		((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu()); // set new screen to MainMenu
        	}
        	break;
        default:
            currentFrame = null;
            break;
    }
        batch.begin();
        batch.draw(currentFrame, 0, 0, 1280, 720); // Draw the current frame
        
        if (skip) {
        Space.draw(batch, "SPACE to Skip", Gdx.graphics.getWidth() - 170, 28);
        }
        
        batch.end();
    }

    private void handleInput(float delta) {
    	
    	if (skip) {
    		if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.SPACE)) {
    			Background.stop();
    			currentFrame = null;
    			((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
    		}
    	}
    }
    
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        Background.dispose();
        // Dispose any other disposable resources if necessary
    }

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}
}