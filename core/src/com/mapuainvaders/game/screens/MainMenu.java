package com.mapuainvaders.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen, InputProcessor {

    private SpriteBatch batch;
    
    private Texture backgroundTexture;
    private Texture instructionsTexture;
    private Texture infoTexture;
    private Texture startTexture;
    private Texture nextTexture;
    private Texture gameStartTexture;
    
    private Texture fxTexture;
    private Texture fxMuteTexture;
    private Texture fxMusicTexture;
    private Texture fxMusicMuteTexture;
    
    private Sprite Background;
    private Sprite Instructions;
    private Sprite Info;
    private Sprite Start;
    private Sprite Next;
    private Sprite gameStart;
    
    private Sprite fxIcon;
    private Sprite fxMuteIcon;
    private Sprite fxMusicIcon;
    private Sprite fxMusicMuteIcon;
    
    private boolean isMainMenu = true;
    private boolean isInstructions = false;
    private boolean isInfo = false;
    
    
    private boolean isNextClicked = false;
    
    private Music MainMenuMusic;
    private Music Select;
    
    public static float backgroundMusicDb = 0.9f;
    public static float winMusicDb = 0.4f;
    public static float gameOverMusicDb = 0.4f;
    
    public static float selectMusicDb = 0.9f;
    public static float shootMusicDb = 0.4f;
    public static float explosionMusicDb = 0.4f;
    public static float alienShootMusicDb = 0.3f;
    public static float powerUpMusicDb = 0.8f;
    public static float playerDamageMusicDb = 7f;
    public static float addLivesMusicDb = 1f;
    public static float bossSpeedUpMusicDb = 0.8f;
    
    private boolean fxMuted = false;
    private boolean musicMuted = false;
    
    @Override
    public void show() {
        batch = new SpriteBatch();

        //background
        backgroundTexture = new Texture("background/MenuBackground.png");
        Background = new Sprite(backgroundTexture);
        
        //instructions
        instructionsTexture = new Texture("background/insBackground.png");
        Instructions = new Sprite(instructionsTexture);
        
        //info
        infoTexture = new Texture("background/infoBackground.png");
        Info = new Sprite(infoTexture);
        
        //start
        startTexture = new Texture("touch/Start.png");
        Start = new Sprite(startTexture);
        Start.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 150);
        
        //next
        nextTexture = new Texture("touch/next.png");
        Next = new Sprite(nextTexture);
        Next.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 310);
        
        //game start
        gameStartTexture = new Texture("touch/gameStart.png");
        gameStart = new Sprite(gameStartTexture);
        gameStart.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 310);
        
        //fx icon
        fxTexture = new Texture("Icon/fxPlay.png");
        fxIcon = new Sprite(fxTexture);
        fxIcon.setSize(fxIcon.getWidth() / 3, fxIcon.getHeight() / 3);
        fxIcon.setCenter(Gdx.graphics.getWidth() / 2f + 570, Gdx.graphics.getHeight() / 2f + 300);
        
        //fx mute icon
        fxMuteTexture = new Texture("Icon/fxMute.png");
        fxMuteIcon = new Sprite(fxMuteTexture);
        fxMuteIcon.setSize(fxMuteIcon.getWidth() / 3, fxMuteIcon.getHeight() / 3);
        fxMuteIcon.setCenter(Gdx.graphics.getWidth() / 2f + 570, Gdx.graphics.getHeight() / 2f + 300);
        
        //fx music icon
        fxMusicTexture = new Texture("Icon/musicPlay.png");
        fxMusicIcon = new Sprite(fxMusicTexture);
        fxMusicIcon.setSize(fxMusicIcon.getWidth() / 2, fxMusicIcon.getHeight() / 2);
        fxMusicIcon.setCenter(Gdx.graphics.getWidth() / 2f + 470, Gdx.graphics.getHeight() / 2f + 300);
        
        fxMusicMuteTexture = new Texture("Icon/musicMute.png");
        fxMusicMuteIcon = new Sprite(fxMusicMuteTexture);
        fxMusicMuteIcon.setSize(fxMusicMuteIcon.getWidth() / 2, fxMusicMuteIcon.getHeight() / 2);
        fxMusicMuteIcon.setCenter(Gdx.graphics.getWidth() / 2f + 470, Gdx.graphics.getHeight() / 2f + 300);
        
        //background music
        MainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/MainMenu.wav"));
        
        if (musicMuted) {
            MainMenuMusic.setVolume(0); // Mute the music
        }
        
        else {
            MainMenuMusic.setVolume(backgroundMusicDb - 0.3f);
        }
        
        MainMenuMusic.setLooping(true);
        MainMenuMusic.play();
        
        Select = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Select.wav"));
        Select.setVolume(selectMusicDb);
        Select.setLooping(false);
        
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        
        if (isMainMenu) {
        	Background.draw(batch);
        	Start.draw(batch);
        	
        	if (!fxMuted) {
        		fxIcon.draw(batch);
        	}
        	else if (fxMuted) {
        		fxMuteIcon.draw(batch);
        	}
        	if (!musicMuted) {
        		fxMusicIcon.draw(batch);
        	}
        	else if (musicMuted) {
        		fxMusicMuteIcon.draw(batch);
        	}
        }
        
        else if (isInstructions) {
        	Instructions.draw(batch);
        	Next.draw(batch);
        }
        
        else if (isInfo) {
        	Info.draw(batch);
        	gameStart.draw(batch);
        }
        
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        MainMenuMusic.dispose(); // Dispose of the music
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	if (Start.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
    		Select.play();
    		isMainMenu = false;
    		isInstructions = true;
    	}
    	
    	else if (!isNextClicked) {
    		if (Next.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
    			Select.play();
    			isNextClicked = true;
    			isInfo = true;
    			isInstructions = false;
    		}
    	}
    	
    	else if (gameStart.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
    		Select.play();
    		MainMenuMusic.stop();
    		dispose();
    		
    		if (musicMuted) {
    			backgroundMusicDb = 0f;
    			winMusicDb = 0f;
    		    gameOverMusicDb = 0f;
    		}
    		else if (!musicMuted) {
    			backgroundMusicDb = 0.9f;
    		    winMusicDb = 0.4f;
    		    gameOverMusicDb = 0.4f;
    		}
    		
    		if (fxMuted) {
    		    selectMusicDb = 0f;
    		    shootMusicDb = 0f;
    		    explosionMusicDb = 0f;
    		    alienShootMusicDb = 0f;
    		    powerUpMusicDb = 0f;
    		    playerDamageMusicDb = 0f;
    		    addLivesMusicDb = 0f;
    		    bossSpeedUpMusicDb = 0f;
    		}
    		if (!fxMuted) {
    			selectMusicDb = 0.9f;
    		    shootMusicDb = 0.4f;
    		    explosionMusicDb = 0.4f;
    		    alienShootMusicDb = 0.3f;
    		    powerUpMusicDb = 0.8f;
    		    playerDamageMusicDb = 4f;
    		    addLivesMusicDb = 1f;
    		    bossSpeedUpMusicDb = 0.8f;
    		}
    		((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
    	}
    	
    	if (isMainMenu) {
    		if (fxIcon.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
    			Select.play();
    			fxMuted = !fxMuted;
    			if (fxMuted) {
    				Select.setVolume(0); // Mute the music
    			} else {
    				Select.setVolume(selectMusicDb - 0.3f);
    			}
    		}
    		
    		else if (fxMusicIcon.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
    			Select.play();
    			musicMuted = !musicMuted;
    			if (musicMuted) {
    				MainMenuMusic.setVolume(0); // Mute the music
    			} else {
    				MainMenuMusic.setVolume(backgroundMusicDb - 0.3f);
    			}
    		}
    	}
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}
}