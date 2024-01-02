package com.mapuainvaders.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;

public class Level1 implements Screen, InputProcessor {

	private Music BackgroundMusic;
	private Music Shoot;
	private Music Explosion;
	private Music Win;
	private Music GameOver;
	private Music Select;
	
    public float backgroundMusicDb = MainMenu.backgroundMusicDb;
    public float winMusicDb = MainMenu.winMusicDb;
    public float gameOverMusicDb = MainMenu.gameOverMusicDb;
    public float selectMusicDb = MainMenu.selectMusicDb;
    public float shootMusicDb = MainMenu.shootMusicDb;
    public float explosionMusicDb = MainMenu.explosionMusicDb;

	private boolean WinDone = true;
	private boolean GameOverDone = true;
	private boolean ContinueClicked = false;
	private boolean isCountdownFinished = false;
	private boolean isCountdownFinished2 = false;
	private boolean alienDirectionRight = true;
    private boolean damaged = false;
    private boolean overlap = false;
	
    public static int PLAYER_SPEED = 10;
    public static int BULLET_SPEED = 500;
    public static float BULLET_DELAY_TIME = 0.5f;
    public static int score = 0;
    public static int livesRemaining = 1;
    private float alienSpeed = 60f;
    
    private float elapsedTime;
    private float elapsedTimeContinue;
    private float bulletDelayTime;
    private float playerDelayTime;
    
    private Texture backgroundTexture;
    private Texture countTexture;
    private Texture gameoverTexture;
    private Texture congratulationsTexture;
    private Texture restartTexture;
    private Texture menuTexture;
    private Texture continueTexture;
    private Texture startTexture;
    private Texture loadingTexture;
    private Texture playerTexture;
    private Texture playerDamageTexture;
    private Texture bulletTexture;
    private Texture alienTexture;
    
    private Sprite background;
    private Sprite count;
    private Sprite gameOver;
    private Sprite Congratulations;
    private Sprite restart;
    private Sprite menuReturn;
    private Sprite Continue;
    private Sprite Loading;
    private Sprite Start;
    private Sprite player;
    private Sprite damagedPlayer;
    
    private SpriteBatch batch;
    private ArrayList<Sprite> bullets;
    private ArrayList<Sprite> aliens;
    private Rectangle screenBounds;

    private BitmapFont Score1;
    
    @Override
    public void show() {
        batch = new SpriteBatch();

        // Create a new FreeTypeFontGenerator with your TTF file
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Mojang-Regular.ttf"));

        // Set the font parameters
        FreeTypeFontGenerator.FreeTypeFontParameter Score = new FreeTypeFontGenerator.FreeTypeFontParameter();
        Score.size = 21;
        Score.color = Color.WHITE;
        
        // Generate the font and assign it to the BitmapFont variable
        Score1 = generator.generateFont(Score);

        // Dispose the generator after generating the font
        generator.dispose();
        
        //player
        playerTexture = new Texture(Gdx.files.internal("character/Player.png"));
        player = new Sprite(playerTexture);
        player.setPosition(Gdx.graphics.getWidth() / 2 - player.getWidth() / 2, 0);
        player.setSize(player.getWidth() * 4, player.getHeight() * 4);
        
        //damaged player
        playerDamageTexture = new Texture(Gdx.files.internal("character/PlayerDamage.png"));
        damagedPlayer = new Sprite(playerDamageTexture);
        damagedPlayer.setPosition(player.getX(), player.getY());
        damagedPlayer.setSize(damagedPlayer.getWidth() * 4, damagedPlayer.getHeight() * 4);
        
        bulletTexture = new Texture(Gdx.files.internal("weapon/bullet.png"));
        bullets = new ArrayList<Sprite>();
        screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        alienTexture = new Texture(Gdx.files.internal("character/Alien.png"));
        aliens = new ArrayList<Sprite>();
        
        int numRows = 5;
        int numCols = 9;
        int xPadding = 16;
        int yPadding = 12;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Sprite alien = new Sprite(alienTexture);
                alien.setSize(alien.getWidth() * 4, alien.getHeight() * 4);
                float xPos = Gdx.graphics.getWidth() / 2 - ((numCols * (alien.getWidth() + xPadding)) / 2) + xPadding + j * (alien.getWidth() + xPadding);
                float yPos = (Gdx.graphics.getHeight() / 2) + yPadding + (i * (alien.getHeight() + yPadding)) + 100;
                alien.setPosition(xPos, yPos);
                aliens.add(alien);
            }
        }
        
        // Create a Texture object from the background image file
        backgroundTexture = new Texture(Gdx.files.internal("background/Level1.png"));
        background = new Sprite(backgroundTexture);
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        // Load countdown texture
        countTexture = new Texture(Gdx.files.internal("level/level1.png"));
        count = new Sprite(countTexture);
        
        startTexture = new Texture(Gdx.files.internal("level/Start.png"));
        Start = new Sprite(startTexture);
        
        // Load gameover Texture   
        gameoverTexture = new Texture(Gdx.files.internal("text/GameOver.png"));
        gameOver = new Sprite(gameoverTexture);
        gameOver.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
        
        // Load congratulations
        congratulationsTexture = new Texture(Gdx.files.internal("text/labTask1.png"));
        Congratulations = new Sprite(congratulationsTexture);
        Congratulations.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 50);
        
        //restart texture
        restartTexture = new Texture(Gdx.files.internal("touch/Restart.png"));
        restart = new Sprite(restartTexture);
        restart.setSize(restart.getWidth() / 2, restart.getHeight() / 2);
        restart.setCenter(Gdx.graphics.getWidth() / 2 - 180, Gdx.graphics.getHeight() / 2 - 80);
        
        //mainmenu texture
        menuTexture = new Texture(Gdx.files.internal("touch/MenuReturn.png"));
        menuReturn = new Sprite(menuTexture);
        menuReturn.setSize(menuReturn.getWidth() / 2, menuReturn.getHeight() / 2);
        menuReturn.setCenter(Gdx.graphics.getWidth() / 2 + 180, Gdx.graphics.getHeight() / 2 - 80);
        
        continueTexture = new Texture(Gdx.files.internal("touch/Continue.png"));
        Continue = new Sprite(continueTexture);
        Continue.setSize(Continue.getWidth() / 2, Continue.getHeight() / 2);
        Continue.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() - 500);
        
        //loading
        loadingTexture = new Texture(Gdx.files.internal("text/loading.png"));
        Loading = new Sprite(loadingTexture);
        Loading.setSize(Loading.getWidth() * 2, Loading.getHeight() * 2);
        Loading.setCenter(Gdx.graphics.getWidth() / 2 + 10, Gdx.graphics.getHeight() / 2);
        
        Gdx.input.setInputProcessor(this);
        
        //background music
        BackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/Level1.wav"));
        
        BackgroundMusic.setVolume(backgroundMusicDb);
        BackgroundMusic.setLooping(true);
        BackgroundMusic.play();
        
        Shoot = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/bulletShoot.wav"));
        Shoot.setVolume(shootMusicDb);
        Shoot.setLooping(false);
        
        Explosion = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Level1Alien.wav"));
        Explosion.setVolume(explosionMusicDb);
        Explosion.setLooping(false);
        
    	Win = Gdx.audio.newMusic(Gdx.files.internal("Music/Win.wav"));
    	Win.setVolume(winMusicDb);
    	Win.setLooping(false);
        
        GameOver = Gdx.audio.newMusic(Gdx.files.internal("Music/GameOver.wav"));
        GameOver.setVolume(gameOverMusicDb);
        GameOver.setLooping(false);
        
        Select = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Select.wav"));
        Select.setVolume(selectMusicDb);
        Select.setLooping(false);
    }

    @Override
    public void render(float delta) {
        handleInput(delta);
        update(delta);
        draw();
        batch.begin();

        if (!ContinueClicked) {
        	// Draw the text with the BitmapFont variable at the top-left corner of the screen
        	Score1.draw(batch, "Score:   " + score, 0, Gdx.graphics.getHeight()- 5);
        }
        
        
        if (damaged) {
		    playerDelayTime += delta;
		    
		    if (playerDelayTime <= 0.6) {
		        if (playerDelayTime % 0.2 <= 0.1) {
		            damagedPlayer.draw(batch);
		        } else {
		            player.draw(batch);
		        }
		    } else {
		        damaged = false;
		        playerDelayTime = 0;
		    }
		}
        
        if (score == 900) {
        	BackgroundMusic.stop();
        	
        	if (WinDone) {
        		Win.play();
        		WinDone = false;
        	}
        }
        
        if (ContinueClicked) {
			
			elapsedTimeContinue += delta;
			
			Loading.draw(batch);
			
			if (elapsedTimeContinue >= 2) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level2());
			}
		}
        
        else if (livesRemaining == 0) {
        	
        	BackgroundMusic.stop();
        	Shoot.stop();
        	
        	if (GameOverDone) {
        		GameOver.play();
        		GameOverDone = false;
        	}
        }
        batch.end();
    }
    
    private void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT)) {
            if (player.getX() > 0) { // Check if player is not at the left edge of the screen
                player.translateX(-PLAYER_SPEED);
                damagedPlayer.translateX(-PLAYER_SPEED);
            }
        } else if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT)) {
            if (player.getX() < Gdx.graphics.getWidth() - player.getWidth()) { // Check if player is not at the right edge of the screen
                player.translateX(PLAYER_SPEED);
                damagedPlayer.translateX(PLAYER_SPEED);
            }
        }

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.SPACE) || Gdx.input.isButtonPressed(com.badlogic.gdx.Input.Buttons.LEFT)) {
        	if (overlap == true || score == 900) {
        		bulletDelayTime = 1;
        	}
        	else if (bulletDelayTime <= 0  && !ContinueClicked) {
        		if (isCountdownFinished == true) {
        			addBullet();
        		}
                bulletDelayTime = BULLET_DELAY_TIME;
            }
        }
        bulletDelayTime -= delta;
    }

    private void update(float delta) {
        // Pause game until countdown sprite disappears off the screen
        if (!isCountdownFinished) {
            elapsedTime += delta;
            if (elapsedTime >= 1) {
            	isCountdownFinished2 = true;
            }
            if (elapsedTime >= 2) {
            	isCountdownFinished = true;
            }
            
            return;
        }

     // Move the aliens to the right until they reach the edge of the screen
        for (int i = 0; i < aliens.size(); i++) {
            Sprite alien = aliens.get(i);
            alien.translateX(alienDirectionRight ? alienSpeed * delta: -alienSpeed * delta);
            if (alien.getX() + alien.getWidth() >= screenBounds.getWidth() || alien.getX() <= 0) {
                alienDirectionRight = !alienDirectionRight;
                for (Sprite a : aliens) {
                    a.translateY(-alien.getHeight());
                    alienSpeed += 0.3; // Increase alien speed slightly each time they move down
                }
            }
        }

        // Update bullets
        for (int i = 0; i < bullets.size(); i++) {
            Sprite bullet = bullets.get(i);
            bullet.translateY(BULLET_SPEED * delta);
            if (bullet.getY() > screenBounds.getHeight()) {
                bullets.remove(i);
            }
        }

        // Check for collisions between bullets and aliens
        for (int i = 0; i < bullets.size(); i++) {
            Sprite bullet = bullets.get(i);
            for (int j = 0; j < aliens.size(); j++) {
                Sprite alien = aliens.get(j);
                if (bullet.getBoundingRectangle().overlaps(alien.getBoundingRectangle())) {
                    bullets.remove(i);
                    aliens.remove(j);
                    Explosion.play();
                    score += 20;
                    break;
                }
            }
        }
        
        for (int i = 0; i < aliens.size(); i++) {
            Sprite alien = aliens.get(i);
            if (player.getBoundingRectangle().overlaps(alien.getBoundingRectangle())) {
                aliens.clear();
                livesRemaining -= 1;
                damaged = true;
                overlap = true;
                break;
            }
        }
    }


    private void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Draw countdown sprite if it's still visible
        if (!isCountdownFinished2) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            background.draw(batch);
            player.draw(batch);
            count.draw(batch);
            batch.end();
            return;
        }
        
        if (!isCountdownFinished) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            background.draw(batch);
            player.draw(batch);
            Start.draw(batch);
            batch.end();
            return;
        }
        
        // Draw background
        batch.begin();
        background.draw(batch);
        batch.end();
        
        batch.begin();
        player.draw(batch);
        for (Sprite bullet : bullets) {
            bullet.draw(batch);
        }
        
        for (Sprite alien : aliens) {
            alien.draw(batch);
        }
        
        batch.end();
        
        if(overlap == true) {
        	batch.begin();
        	gameOver.draw(batch);
        	restart.draw(batch);
        	menuReturn.draw(batch);
        	batch.end();
        	
        	BackgroundMusic.stop();
        }
        
        if (score == 900) {
        	batch.begin();
        	Congratulations.draw(batch);
        	Continue.draw(batch);
        	aliens.clear();
        	batch.end();
        }
    }

    private void addBullet() {
        Sprite bullet = new Sprite(bulletTexture);
        bullet.setPosition(player.getX() + player.getWidth() / 3 - bullet.getWidth() / 2, player.getY() + player.getHeight());
        bullet.setSize(bullet.getWidth() * 5, bullet.getHeight() * 5);
        bullets.add(bullet);
        Shoot.play();
    }
    
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
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
		
		if (livesRemaining == 0) {
		    if (restart.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
		        Select.play();
		        GameOver.stop();
		        livesRemaining = 1;
		        score = 0;
		        dispose();
		        // Set the new screen to the Level1 screen
		        ((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
		    }
		    
		    if (menuReturn.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
		    	Select.play();
		    	GameOver.stop();
		        dispose();
		        // Set the new screen to the MainMenu screen
		        ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
		    }
		}
		
		if (score == 900) {
		    if (Continue.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
		    	Select.play();
		    	Win.stop();
		    	ContinueClicked = true;
		        score = 0;
		        Level2.livesRemaining2 = livesRemaining + 2;
		    }
		}
	    return true;
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
	@Override
	public void dispose() {
		batch.dispose();
		playerTexture.dispose();
		bulletTexture.dispose();
		gameoverTexture.dispose();
		restartTexture.dispose();
		menuTexture.dispose();
		Score1.dispose();
	}
}