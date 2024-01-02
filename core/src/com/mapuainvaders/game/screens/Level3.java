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
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;

public class Level3 implements Screen, InputProcessor{

	Animation<TextureRegion> animation;
	float elapsed;
	
	private Music BackgroundMusic;
	private Music PowerUp;
	private Music Shoot;
	private Music AlienShoot;
	private Music Explosion;
	private Music Win;
	private Music GameOver;
	private Music Select;
	private Music playerDamage;
	
    public float backgroundMusicDb = MainMenu.backgroundMusicDb;
    public float winMusicDb = MainMenu.winMusicDb;
    public float gameOverMusicDb = MainMenu.gameOverMusicDb;
    public static float selectMusicDb = MainMenu.selectMusicDb;
    public static float shootMusicDb = MainMenu.shootMusicDb;
    public static float explosionMusicDb = MainMenu.explosionMusicDb;
    public static float playerDamageMusicDb = MainMenu.playerDamageMusicDb;
    public static float alienShootMusicDb = MainMenu.alienShootMusicDb;
    public static float powerUpMusicDb = MainMenu.powerUpMusicDb;
	
	private boolean WinDone = true;
	private boolean GameOverDone = true;
	
	private Texture choiceTexture1;
	private Texture choiceTexture2;
	private Texture choiceTexture3;
	private Texture countTexture;	
	private Texture startTexture;
	private Texture playerTexture;
	private Texture playerDamageTexture;
	private Texture bulletTexture;
	private Texture alienTexture;
	private Texture gameoverTexture;
	private Texture restartTexture;
	private Texture menuTexture;
	private Texture congratulationsTexture;
	private Texture continueTexture;
	private Texture loadingTexture;
	
	private Sprite Choice1;
	private Sprite Choice2;
	private Sprite Choice3;
	private Sprite player;
	private Sprite damagedPlayer;
	private Sprite count;
	private Sprite Start;
	private Sprite bulletMain;
	private Sprite alien1;
	private Sprite alien2;
	private Sprite alien3;
	private Sprite alien4;
	private Sprite alien5;
	private Sprite alien6;
	private Sprite alien7;
	private Sprite alien8;
	private Sprite alien9;
	private Sprite alien10;
	private Sprite gameOver;
	private Sprite restart;
	private Sprite menuReturn;
	private Sprite Congratulations;
	private Sprite Continue;
	private Sprite Loading;
	
	private Sprite bullet1;
	private Sprite bullet2;
	private Sprite bullet3;
	private Sprite bullet4;
	private Sprite bullet5;
	private Sprite bullet6;
	private Sprite bullet7;
	private Sprite bullet8;
	private Sprite bullet9;
	private Sprite bullet10;
	
	private boolean alien1Touched = false;
	private boolean alien2Touched = false;
	private boolean alien3Touched = false;
	private boolean alien4Touched = false;
	private boolean alien5Touched = false;
	private boolean alien6Touched = false;
	private boolean alien7Touched = false;
	private boolean alien8Touched = false;
	private boolean alien9Touched = false;
	private boolean alien10Touched = false;
	
    private boolean alien1DirectionRight = false;
    private boolean alien2DirectionRight = true;
    private boolean alien3DirectionRight = false;
    private boolean alien4DirectionRight = true;
    private boolean alien5DirectionRight = false;
    private boolean alien6DirectionRight = true;
    private boolean alien7DirectionRight = false;
    private boolean alien8DirectionRight = false;
    private boolean alien9DirectionRight = true;
    private boolean alien10DirectionRight = true;
    
    private boolean isPlayerDead = false;
	private boolean damaged = false;
	
	private boolean ContinueClicked = false;
	
	private SpriteBatch batch;
	private Rectangle screenBounds;
	
    public static int PLAYER_SPEED3 = Level2.PLAYER_SPEED;
    public static int BULLET_SPEED3 = Level2.BULLET_SPEED;
    public static float BULLET_DELAY_TIME = Level2.BULLET_DELAY_TIME;
    private static int ALIEN_BULLET_SPEED1 = 750;
    private float alienSpeed = 210f;
	private static int score = 1200;
	public static int livesRemaining2 = Level2.livesRemaining2;
	private float elapsedTime;
	private float elapsedTimeContinue;
	private float bulletDelayTime;
	private float playerDelayTime;
	
	private BitmapFont Score1;
	private BitmapFont Stats;
	
	private boolean isChoiceClicked = false;
	private boolean choice1Clicked = false;
	private boolean choice2Clicked = false;
	private boolean choice3Clicked = false;
	private boolean overlap = false;
	
	boolean screenChanged;
	
	private static float ALIEN_BULLET_DELAY_TIME_1 = 2.5f;
	private static float ALIEN_BULLET_DELAY_TIME_2 = 2.1f;
	private static float ALIEN_BULLET_DELAY_TIME_3 = 2.6f;
	private static float ALIEN_BULLET_DELAY_TIME_4 = 1.5f;
	private static float ALIEN_BULLET_DELAY_TIME_5 = 1.2f;
	private static float ALIEN_BULLET_DELAY_TIME_6 = 2f;
	private static float ALIEN_BULLET_DELAY_TIME_7 = 2.7f;
	private static float ALIEN_BULLET_DELAY_TIME_8 = 1.7f;
	private static float ALIEN_BULLET_DELAY_TIME_9 = 1.1f;
	private static float ALIEN_BULLET_DELAY_TIME_10 = 2.3f;
	
    private float alienBulletDelayTime1;
    private float alienBulletDelayTime2;
    private float alienBulletDelayTime3;
    private float alienBulletDelayTime4;
    private float alienBulletDelayTime5;
    private float alienBulletDelayTime6;
    private float alienBulletDelayTime7;
    private float alienBulletDelayTime8;
    private float alienBulletDelayTime9;
    private float alienBulletDelayTime10;
    
    private Texture alienBulletTexture;
    private ArrayList<Sprite> alienBullets;
    private ArrayList<Sprite> bullets;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		
		//Font
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Mojang-Regular.ttf"));

        // Set the font parameters
        FreeTypeFontGenerator.FreeTypeFontParameter Score = new FreeTypeFontGenerator.FreeTypeFontParameter();
        Score.size = 21;
        Score.color = Color.WHITE;
        
        FreeTypeFontGenerator.FreeTypeFontParameter Health = new FreeTypeFontGenerator.FreeTypeFontParameter();
        Health.size = 21;
        Health.color = Color.WHITE;
        
        Score1 = generator.generateFont(Score);
        Stats = generator.generateFont(Health);
		
        generator.dispose();
        
		//gif background
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("background/Level3.gif").read());
		
		//choice 1
		choiceTexture1 = new Texture("powerup/level3/LivesPlus1.png");
		Choice1 = new Sprite(choiceTexture1);
		Choice1.setCenter(Gdx.graphics.getWidth() - 1000, Gdx.graphics.getHeight() / 2f);
		
		//choice 2
		choiceTexture2 = new Texture("powerup/level3/Playerspeed.png");
		Choice2 = new Sprite(choiceTexture2);
		Choice2.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
		
		//choice 3
		choiceTexture3 = new Texture("powerup/level3/Bulletspeed.png");
		Choice3 = new Sprite(choiceTexture3);
		Choice3.setCenter(Gdx.graphics.getWidth() - 280, Gdx.graphics.getHeight() / 2f);
		
		//count
		countTexture = new Texture(Gdx.files.internal("level/level3.png"));
		count = new Sprite(countTexture);

		//start
		startTexture = new Texture(Gdx.files.internal("level/Start.png"));
		Start = new Sprite(startTexture);
		
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
        
        //bullet
        bulletTexture = new Texture(Gdx.files.internal("weapon/bullet.png"));
        bullets = new ArrayList<Sprite>();
        
        //alien
        alienTexture = new Texture(Gdx.files.internal("character/Alien3.png"));
        
        
        //in x axis, if +, it goes up
        //in y axis, if +, it goes right
        
        //alien1
        alien1 = new Sprite(alienTexture);
        alien1.setSize(alien1.getWidth() * 9 / 2, alien1.getHeight() * 9 / 2);
        alien1.setPosition(Gdx.graphics.getWidth() / 2 - alien1.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 90);
        
        //alien2
        alien2 = new Sprite(alienTexture);
        alien2.setSize(alien2.getWidth() * 9 / 2, alien2.getHeight() * 9 / 2);
        alien2.setPosition(Gdx.graphics.getWidth() / 2 - alien2.getWidth() / 2 + 300, Gdx.graphics.getHeight() / 2 + 100);
        
        //alien3
        alien3 = new Sprite(alienTexture);
        alien3.setSize(alien3.getWidth() * 9 / 2, alien3.getHeight() * 9 / 2);
        alien3.setPosition(Gdx.graphics.getWidth() / 2 - alien3.getWidth() / 2 - 420, Gdx.graphics.getHeight() / 2 + 260);
        
        //alien4
        alien4 = new Sprite(alienTexture);
        alien4.setSize(alien4.getWidth() * 9 / 2, alien4.getHeight() * 9 / 2);
        alien4.setPosition(Gdx.graphics.getWidth() / 2 - alien4.getWidth() / 2 - 250, Gdx.graphics.getHeight() / 2 + 170);
        
        //alien5
        alien5 = new Sprite(alienTexture);
        alien5.setSize(alien5.getWidth() * 9 / 2, alien5.getHeight() * 9 / 2);
        alien5.setPosition(Gdx.graphics.getWidth() / 2 - alien5.getWidth() / 2 + 500, Gdx.graphics.getHeight() / 2 + 200);
        
        //alien6
        alien6 = new Sprite(alienTexture);
        alien6.setSize(alien6.getWidth() * 9 / 2, alien6.getHeight() * 9 / 2);
        alien6.setPosition(Gdx.graphics.getWidth() / 2 - alien6.getWidth() / 2 + 120, Gdx.graphics.getHeight() / 2 + 250);

        //alien7
        alien7 = new Sprite(alienTexture);
        alien7.setSize(alien7.getWidth() * 9 / 2, alien7.getHeight() * 9 / 2);
        alien7.setPosition(Gdx.graphics.getWidth() / 2 - alien7.getWidth() / 2 - 530, Gdx.graphics.getHeight() / 2 + 90);
        
        //alien8
        alien8 = new Sprite(alienTexture);
        alien8.setSize(alien8.getWidth() * 9 / 2, alien8.getHeight() * 9 / 2);
        alien8.setPosition(Gdx.graphics.getWidth() / 2 - alien8.getWidth() / 2 - 90, Gdx.graphics.getHeight() / 2 + 210);
        
        //alien9
        alien9 = new Sprite(alienTexture);
        alien9.setSize(alien9.getWidth() * 9 / 2, alien9.getHeight() * 9 / 2);
        alien9.setPosition(Gdx.graphics.getWidth() / 2 - alien9.getWidth() / 2 + 380, Gdx.graphics.getHeight() / 2 + 260);
        
        //alien10
        alien10 = new Sprite(alienTexture);
        alien10.setSize(alien10.getWidth() * 9 / 2, alien10.getHeight() * 9 / 2);
        alien10.setPosition(Gdx.graphics.getWidth() / 2 - alien10.getWidth() / 2 - 340, Gdx.graphics.getHeight() / 2 + 80);
        
        //alien bullet
        alienBulletTexture = new Texture(Gdx.files.internal("weapon/alienBullet3.png"));
        alienBullets = new ArrayList<Sprite>();
        
        // Load gameover Texture   
        gameoverTexture = new Texture(Gdx.files.internal("text/GameOver.png"));
        gameOver = new Sprite(gameoverTexture);
        gameOver.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
        
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
        
        //congratulations
        congratulationsTexture = new Texture(Gdx.files.internal("text/labTask3.png"));
        Congratulations = new Sprite(congratulationsTexture);
        Congratulations.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 50);
        
        //continue
        continueTexture = new Texture(Gdx.files.internal("touch/Continue.png"));
        Continue = new Sprite(continueTexture);
        Continue.setSize(Continue.getWidth() / 2, Continue.getHeight() / 2);
        Continue.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() - 500);
        
        //loading
        loadingTexture = new Texture(Gdx.files.internal("text/loading.png"));
        Loading = new Sprite(loadingTexture);
        Loading.setSize(Loading.getWidth() * 2, Loading.getHeight() * 2);
        Loading.setCenter(Gdx.graphics.getWidth() / 2 + 10, Gdx.graphics.getHeight() / 2);
        
        //screenbound
        screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
		Gdx.input.setInputProcessor(this);
		screenChanged = false;
		
		//background music
        BackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/Level3.wav"));
        
        BackgroundMusic.setVolume(backgroundMusicDb);
        BackgroundMusic.setLooping(true);
        BackgroundMusic.play();
		
        PowerUp = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Powerup.wav"));
        PowerUp.setVolume(powerUpMusicDb);
        PowerUp.setLooping(false);
        
        Shoot = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/bulletShoot.wav"));
        Shoot.setVolume(shootMusicDb);
        Shoot.setLooping(false);
        
        AlienShoot = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/AlienShoot.wav"));
        AlienShoot.setVolume(alienShootMusicDb);
        AlienShoot.setLooping(false);
        
        Explosion = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Level3Alien.wav"));
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
        
        playerDamage = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/playerDamage.wav"));
        playerDamage.setVolume(playerDamageMusicDb);
        playerDamage.setLooping(false);
	}
	
	@Override
	public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		handleInput(delta);
		update(delta);
		
		batch.begin();
		
		batch.draw(animation.getKeyFrame(elapsed), 0, 0, 1280, 720);
		
		if (!isChoiceClicked) {
			Choice1.draw(batch);
			Choice2.draw(batch);
			Choice3.draw(batch);
		}
		
		if (!ContinueClicked) {
			//text
			Score1.draw(batch, "Score:   " + score, 0, Gdx.graphics.getHeight()- 5);
        	Stats.draw(batch, "Lives:   " + livesRemaining2, Gdx.graphics.getWidth() - 1000, Gdx.graphics.getHeight()- 5);
        	Stats.draw(batch, "Player Speed:   " + PLAYER_SPEED3, Gdx.graphics.getWidth() - 800, Gdx.graphics.getHeight()- 5);
        	Stats.draw(batch, "Bullet Speed:   " + BULLET_SPEED3, Gdx.graphics.getWidth() - 500, Gdx.graphics.getHeight()- 5);
		}
		
		if (isChoiceClicked == true) {
			elapsedTime += delta;
			
			if (elapsedTime <= 1) {
				count.draw(batch);
				player.draw(batch);
			}
			
			else if (elapsedTime <= 2 && elapsedTime >= 1) {
				
				Start.draw(batch);
				player.draw(batch);
			}
			else {
				
				player.draw(batch);
				
				if (!isPlayerDead && elapsedTime >= 2) {
					
					alien1.draw(batch);
					alien2.draw(batch);
					alien3.draw(batch);
					alien4.draw(batch);
					alien5.draw(batch);
					alien6.draw(batch);
					alien7.draw(batch);
					alien8.draw(batch);
					alien9.draw(batch);
					alien10.draw(batch);
					
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
					
					alienBulletDelayTime1 += delta;
					alienBulletDelayTime2 += delta;
					alienBulletDelayTime3 += delta;
					alienBulletDelayTime4 += delta;
					alienBulletDelayTime5 += delta;
					alienBulletDelayTime6 += delta;
					alienBulletDelayTime7 += delta;
					alienBulletDelayTime8 += delta;
					alienBulletDelayTime9 += delta;
					alienBulletDelayTime10 += delta;
					
					//Width = +3
					//Height = -22
					
					// Check if alien1 fired a bullet
					if(alienBulletDelayTime1 >= ALIEN_BULLET_DELAY_TIME_1 && alien1Touched == false) {
						bullet1 = new Sprite(alienBulletTexture);
						bullet1.setPosition(alien1.getX(), Gdx.graphics.getHeight() / 2 + 68);
						bullet1.setSize(bullet1.getWidth() * 4, bullet1.getHeight() * 4);
						alienBullets.add(bullet1);
						alienBulletDelayTime1 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien2 fired a bullet
					if(alienBulletDelayTime2 >= ALIEN_BULLET_DELAY_TIME_2 && alien2Touched == false) {
						bullet2 = new Sprite(alienBulletTexture);
						bullet2.setPosition(alien2.getX(), Gdx.graphics.getHeight() / 2 + 78);
						bullet2.setSize(bullet2.getWidth() * 4, bullet2.getHeight() * 4);
						alienBullets.add(bullet2);
						alienBulletDelayTime2 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien3 fired a bullet
					if(alienBulletDelayTime3 >= ALIEN_BULLET_DELAY_TIME_3 && alien3Touched == false) {
						bullet3 = new Sprite(alienBulletTexture);
						bullet3.setPosition(alien3.getX(), Gdx.graphics.getHeight() / 2 + 238);
						bullet3.setSize(bullet3.getWidth() * 4, bullet3.getHeight() * 4);
						alienBullets.add(bullet3);
						alienBulletDelayTime3 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien4 fired a bullet
					if(alienBulletDelayTime4 >= ALIEN_BULLET_DELAY_TIME_4 && alien4Touched == false) {
						bullet4 = new Sprite(alienBulletTexture);
						bullet4.setPosition(alien4.getX(), Gdx.graphics.getHeight() / 2 + 148);
						bullet4.setSize(bullet4.getWidth() * 4, bullet4.getHeight() * 4);
						alienBullets.add(bullet4);
						alienBulletDelayTime4 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien5 fired a bullet
					if(alienBulletDelayTime5 >= ALIEN_BULLET_DELAY_TIME_5 && alien5Touched == false) {
						bullet5 = new Sprite(alienBulletTexture);
						bullet5.setPosition(alien5.getX(), Gdx.graphics.getHeight() / 2 + 178);
						bullet5.setSize(bullet5.getWidth() * 4, bullet5.getHeight() * 4);
						alienBullets.add(bullet5);
						alienBulletDelayTime5 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien6 fired a bullet
					if(alienBulletDelayTime6 >= ALIEN_BULLET_DELAY_TIME_6 && alien6Touched == false) {
						bullet6 = new Sprite(alienBulletTexture);
						bullet6.setPosition(alien6.getX(), Gdx.graphics.getHeight() / 2 + 228);
						bullet6.setSize(bullet6.getWidth() * 4, bullet6.getHeight() * 4);
						alienBullets.add(bullet6);
						alienBulletDelayTime6 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien7 fired a bullet
					if(alienBulletDelayTime7 >= ALIEN_BULLET_DELAY_TIME_7 && alien7Touched == false) {
						bullet7 = new Sprite(alienBulletTexture);
						bullet7.setPosition(alien7.getX(), Gdx.graphics.getHeight() / 2 + 68);
						bullet7.setSize(bullet7.getWidth() * 4, bullet7.getHeight() * 4);
						alienBullets.add(bullet7);
						alienBulletDelayTime7 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien8 fired a bullet
					if(alienBulletDelayTime8 >= ALIEN_BULLET_DELAY_TIME_8 && alien8Touched == false) {
						bullet8 = new Sprite(alienBulletTexture);
						bullet8.setPosition(alien8.getX(), Gdx.graphics.getHeight() / 2 + 188);
						bullet8.setSize(bullet8.getWidth() * 4, bullet8.getHeight() * 4);
						alienBullets.add(bullet8);
						alienBulletDelayTime8 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien9 fired a bullet
					if(alienBulletDelayTime9 >= ALIEN_BULLET_DELAY_TIME_9 && alien9Touched == false) {
						bullet9 = new Sprite(alienBulletTexture);
						bullet9.setPosition(alien9.getX(), Gdx.graphics.getHeight() / 2 + 238);
						bullet9.setSize(bullet9.getWidth() * 4, bullet9.getHeight() * 4);
						alienBullets.add(bullet9);
						alienBulletDelayTime9 = 0f;
						AlienShoot.play();
					}
					
					// Check if alien10 fired a bullet
					if(alienBulletDelayTime10 >= ALIEN_BULLET_DELAY_TIME_10 && alien10Touched == false) {
						bullet10 = new Sprite(alienBulletTexture);
						bullet10.setPosition(alien10.getX(), Gdx.graphics.getHeight() / 2 + 58);
						bullet10.setSize(bullet10.getWidth() * 4, bullet10.getHeight() * 4);
						alienBullets.add(bullet10);
						alienBulletDelayTime10 = 0f;
						AlienShoot.play();
					}
					
					// Draw bullets
					for (Sprite bulletMain : bullets) {
						bulletMain.draw(batch);
					}
					
					// Draw alien bullets
					for(Sprite bullet : alienBullets) {
						bullet.draw(batch);
					}
				}
			}
		}
		
		if (overlap == true) {
        	gameOver.draw(batch);
        	restart.draw(batch);
        	menuReturn.draw(batch);
        	
        	BackgroundMusic.stop();
        	Shoot.stop();
        	
			if (GameOverDone) {
				GameOver.play();
				GameOverDone = false;
			}
		}
		
		if (score == 1800) {
        	Congratulations.draw(batch);
        	Continue.draw(batch);
        	
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
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level4());
			}
		}
		
		batch.end();
		
	}
	
	private void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT)) {
            if (player.getX() > 0) { // Check if player is not at the left edge of the screen
                player.translateX(-PLAYER_SPEED3);
                damagedPlayer.translateX(-PLAYER_SPEED3);
            }
        }
        else if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT)) {
            if (player.getX() < Gdx.graphics.getWidth() - player.getWidth()) { // Check if player is not at the right edge of the screen
                player.translateX(PLAYER_SPEED3);
                damagedPlayer.translateX(PLAYER_SPEED3);
            }
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.SPACE) || Gdx.input.isButtonPressed(com.badlogic.gdx.Input.Buttons.LEFT)) {
        	if (bulletDelayTime <= 0) {
        		if (elapsedTime >= 2 && !ContinueClicked) {
        			addBullet();
        			bulletDelayTime = BULLET_DELAY_TIME;
        		}
        	}
        }
        
        bulletDelayTime -= delta;
	}
	
	private void update(float delta) {
		
        // Update bullets
        for (int i = 0; i < bullets.size(); i++) {
        	bulletMain = bullets.get(i);
        	bulletMain.translateY(BULLET_SPEED3 * delta);
            if (bulletMain.getY() > screenBounds.getHeight()) {
                bullets.remove(i);
            }
        }
        
        // Update alien bullet positions
        for(int i = 0; i < alienBullets.size(); i++) {
            Sprite bullet = alienBullets.get(i);
            bullet.setY(bullet.getY() - ALIEN_BULLET_SPEED1 * delta);

            // Remove bullet if it goes off screen
            if(bullet.getY() < 0) {
                alienBullets.remove(i);
                i--;
            }
        }
        
        //minus lives every overlap
        for (int i = 0; i < alienBullets.size(); i++) {
        	Sprite bullet = alienBullets.get(i);
        	if (bullet.getBoundingRectangle().overlaps(player.getBoundingRectangle())) {
        		alienBullets.remove(i);
        		livesRemaining2 -= 1;
        		damaged = true;
        		playerDamage.play();
        	}
        }
        
        if (elapsedTime > 2) {
        	alien1.translateX(alien1DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien1.getX() + alien1.getWidth() >= screenBounds.getWidth() || alien1.getX() <= 0) {
        		alien1DirectionRight = !alien1DirectionRight;
        	}
        	
        	alien2.translateX(alien2DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien2.getX() + alien2.getWidth() >= screenBounds.getWidth() || alien2.getX() <= 0) {
        		alien2DirectionRight = !alien2DirectionRight;
        	}
        	
        	alien3.translateX(alien3DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien3.getX() + alien3.getWidth() >= screenBounds.getWidth() || alien3.getX() <= 0) {
        		alien3DirectionRight = !alien3DirectionRight;
        	}
        	
        	alien4.translateX(alien4DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien4.getX() + alien4.getWidth() >= screenBounds.getWidth() || alien4.getX() <= 0) {
        		alien4DirectionRight = !alien4DirectionRight;
        	}
        	
        	alien5.translateX(alien5DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien5.getX() + alien5.getWidth() >= screenBounds.getWidth() || alien5.getX() <= 0) {
        		alien5DirectionRight = !alien5DirectionRight;
        	}
        	
        	alien6.translateX(alien6DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien6.getX() + alien6.getWidth() >= screenBounds.getWidth() || alien6.getX() <= 0) {
        		alien6DirectionRight = !alien6DirectionRight;
        	}
        	
        	alien7.translateX(alien7DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien7.getX() + alien7.getWidth() >= screenBounds.getWidth() || alien7.getX() <= 0) {
        		alien7DirectionRight = !alien7DirectionRight;
        	}
        	
        	alien8.translateX(alien8DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien8.getX() + alien8.getWidth() >= screenBounds.getWidth() || alien8.getX() <= 0) {
        		alien8DirectionRight = !alien8DirectionRight;
        	}
        	
        	alien9.translateX(alien9DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien9.getX() + alien9.getWidth() >= screenBounds.getWidth() || alien9.getX() <= 0) {
        		alien9DirectionRight = !alien9DirectionRight;
        	}
        	
        	alien10.translateX(alien10DirectionRight ? alienSpeed * delta : -alienSpeed * delta);
        	if (alien10.getX() + alien10.getWidth() >= screenBounds.getWidth() || alien10.getX() <= 0) {
        		alien10DirectionRight = !alien10DirectionRight;
        	}
        }
        
        for (int i = 0; i < bullets.size(); i++) {
        	Sprite bulletMain = bullets.get(i);
        	
        	//alien1
        	if (bulletMain.getBoundingRectangle().overlaps(alien1.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien1Touched = true;
        		score += 60;
        		alien1.setPosition(Gdx.graphics.getWidth() / 2 - alien1.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien2
        	else if (bulletMain.getBoundingRectangle().overlaps(alien2.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien2Touched = true;
        		score += 60;
        		alien2.setPosition(Gdx.graphics.getWidth() / 2 - alien2.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien3
        	else if (bulletMain.getBoundingRectangle().overlaps(alien3.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien3Touched = true;
        		score += 60;
        		alien3.setPosition(Gdx.graphics.getWidth() / 2 - alien3.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien4
        	else if (bulletMain.getBoundingRectangle().overlaps(alien4.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien4Touched = true;
        		score += 60;
        		alien4.setPosition(Gdx.graphics.getWidth() / 2 - alien4.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien5
        	else if (bulletMain.getBoundingRectangle().overlaps(alien5.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien5Touched = true;
        		score += 60;
        		alien5.setPosition(Gdx.graphics.getWidth() / 2 - alien5.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien6
        	else if (bulletMain.getBoundingRectangle().overlaps(alien6.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien6Touched = true;
        		score += 60;
        		alien6.setPosition(Gdx.graphics.getWidth() / 2 - alien6.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien7
        	else if (bulletMain.getBoundingRectangle().overlaps(alien7.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien7Touched = true;
        		score += 60;
        		alien7.setPosition(Gdx.graphics.getWidth() / 2 - alien7.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien8
        	else if (bulletMain.getBoundingRectangle().overlaps(alien8.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien8Touched = true;
        		score += 60;
        		alien8.setPosition(Gdx.graphics.getWidth() / 2 - alien8.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien9
        	else if (bulletMain.getBoundingRectangle().overlaps(alien9.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien9Touched = true;
        		score += 60;
        		alien9.setPosition(Gdx.graphics.getWidth() / 2 - alien9.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        	//alien10
        	else if (bulletMain.getBoundingRectangle().overlaps(alien10.getBoundingRectangle())) {
        		Explosion.play();
        		bullets.remove(i);
        		alien10Touched = true;
        		score += 60;
        		alien10.setPosition(Gdx.graphics.getWidth() / 2 - alien10.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 500);
        	}
        }
        
        if (livesRemaining2 == 0) {
        	overlap = true;
        	isPlayerDead = true;
        }
        
        
        
        if(overlap == true || score == 1800) {
        	alienBullets.clear();
        	bullets.clear();
        	bulletTexture.dispose();
        	alienTexture.dispose();
        	alienBulletTexture.dispose();
        }
	}
	
	private void addBullet() {
		bulletMain = new Sprite(bulletTexture);
		bulletMain.setPosition(player.getX() + player.getWidth() / 3 - bulletMain.getWidth() / 2, player.getY() + player.getHeight());
		bulletMain.setSize(bulletMain.getWidth() * 5, bulletMain.getHeight() * 5);
        bullets.add(bulletMain);
        Shoot.play();
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
	
	@Override
	public void dispose() {
		batch.dispose();
		Score1.dispose();
		Stats.dispose();
		bulletTexture.dispose();
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
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (!isChoiceClicked) {
			if (!choice1Clicked && Choice1.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
				PowerUp.play();
				livesRemaining2 += 1;
				choice1Clicked = true;
				isChoiceClicked = true;
				choiceTexture1.dispose();
				choiceTexture2.dispose();
				choiceTexture3.dispose();
			}
			else if (!choice2Clicked && Choice2.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
				PowerUp.play();
				PLAYER_SPEED3 += 3;
				choice2Clicked = true;
				isChoiceClicked = true;
				choiceTexture1.dispose();
				choiceTexture2.dispose();
				choiceTexture3.dispose();
			}
			else if (!choice3Clicked && Choice3.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
				PowerUp.play();
				BULLET_SPEED3 += 350;
				BULLET_DELAY_TIME -= 0.05f;
				choice3Clicked = true;
				isChoiceClicked = true;
				choiceTexture1.dispose();
				choiceTexture2.dispose();
				choiceTexture3.dispose();
			}
		}
		
		else if (livesRemaining2 == 0) {
		    if (restart.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY) && !screenChanged) {
		    	GameOver.stop();
		    	Select.play();
		        score = 1200;
		        livesRemaining2 = Level2.livesRemaining2;
		        PLAYER_SPEED3 = Level2.PLAYER_SPEED;
		        BULLET_SPEED3 = Level2.BULLET_SPEED;
		        BULLET_DELAY_TIME = Level2.BULLET_DELAY_TIME;
		        dispose();
		        ((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
		    }
		    
		    else if (menuReturn.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY) && !screenChanged) {
		    	GameOver.stop();
		    	Select.play();
		        score = 1200;
		        livesRemaining2 = Level2.livesRemaining2;
		        PLAYER_SPEED3 = Level2.PLAYER_SPEED;
		        BULLET_SPEED3 = Level2.BULLET_SPEED;
		        BULLET_DELAY_TIME = Level2.BULLET_DELAY_TIME;
		        dispose();
		        ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
		    }
		}
		
		else if (score == 1800) {
		    if (Continue.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY) && !screenChanged) {
		    	Win.stop();
		    	Select.play();
		        Level4.livesRemaining2 = livesRemaining2;
		        Level4.PLAYER_SPEED4 = PLAYER_SPEED3;
		        Level4.BULLET_SPEED4 = BULLET_SPEED3;
		        Level4.BULLET_DELAY_TIME = BULLET_DELAY_TIME;
		        
		        score = 1200;
		        livesRemaining2 = Level2.livesRemaining2;
		        PLAYER_SPEED3 = Level2.PLAYER_SPEED;
		        BULLET_SPEED3 = Level2.BULLET_SPEED;
		        BULLET_DELAY_TIME = Level2.BULLET_DELAY_TIME;
		        
		        ContinueClicked = true;
		    }
		}
		return true;
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

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}