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

public class Level5 implements Screen, InputProcessor{

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
	private Music bossSpeedUpMusic;
	private Music playerDamage;
	private Music addLives;

    public float backgroundMusicDb = MainMenu.backgroundMusicDb;
    public float winMusicDb = MainMenu.winMusicDb;
    public float gameOverMusicDb = MainMenu.gameOverMusicDb;
    public static float selectMusicDb = MainMenu.selectMusicDb;
    public static float shootMusicDb = MainMenu.shootMusicDb;
    public static float explosionMusicDb = MainMenu.explosionMusicDb;
    public static float playerDamageMusicDb = MainMenu.playerDamageMusicDb;
    public static float alienShootMusicDb = MainMenu.alienShootMusicDb;
    public static float powerUpMusicDb = MainMenu.powerUpMusicDb;
    public static float addLivesMusicDb = MainMenu.addLivesMusicDb;
    public static float bossSpeedUpMusicDb = MainMenu.bossSpeedUpMusicDb;
	
	private boolean WinDone = true;
	private boolean GameOverDone = true;
	
	private Texture choiceTexture1;
	private Texture choiceTexture2;
	private Texture countTexture;	
	private Texture startTexture;
	private Texture playerTexture;
	private Texture playerDamageTexture;
	private Texture playerHealTexture;
	private Texture bulletTexture;
	private Texture bossTexture;
	private Texture emmyTexture;
	private Texture bossShootTexture;
	private Texture ipTexture;
	private Texture incTexture;
	private Texture fTexture;
	private Texture unoTexture;
	private Texture livesPlus3Texture;
	
	private Texture bossHealthTexture;
	
	private Sprite bossHealthBar20;
	private Sprite bossHealthBar19;
	private Sprite bossHealthBar18;
	private Sprite bossHealthBar17;
	private Sprite bossHealthBar16;
	private Sprite bossHealthBar15;
	private Sprite bossHealthBar14;
	private Sprite bossHealthBar13;
	private Sprite bossHealthBar12;
	private Sprite bossHealthBar11;
	private Sprite bossHealthBar10;
	private Sprite bossHealthBar9;
	private Sprite bossHealthBar8;
	private Sprite bossHealthBar7;
	private Sprite bossHealthBar6;
	private Sprite bossHealthBar5;
	private Sprite bossHealthBar4;
	private Sprite bossHealthBar3;
	private Sprite bossHealthBar2;
	private Sprite bossHealthBar1;
	private Sprite bossHealthBar0;
	
	private TextureRegion health20;
	private TextureRegion health19;
	private TextureRegion health18;
	private TextureRegion health17;
	private TextureRegion health16;
	private TextureRegion health15;
	private TextureRegion health14;
	private TextureRegion health13;
	private TextureRegion health12;
	private TextureRegion health11;
	private TextureRegion health10;
	private TextureRegion health9;
	private TextureRegion health8;
	private TextureRegion health7;
	private TextureRegion health6;
	private TextureRegion health5;
	private TextureRegion health4;
	private TextureRegion health3;
	private TextureRegion health2;
	private TextureRegion health1;
	private TextureRegion health0;
	
	private Texture gameoverTexture;
	private Texture restartTexture;
	private Texture menuTexture;
	private Texture congratulationsTexture;
	private Texture continueTexture;
	private Texture continueOutroTexture;
	private Texture loadingTexture;
	
	private Sprite Choice1;
	private Sprite Choice2;
	private Sprite player;
	private Sprite damagedPlayer;
	private Sprite healedPlayer;
	private Sprite boss;
	private Sprite bossShoot;
	
	private ArrayList<Sprite> ipBullet;
	private ArrayList<Sprite> incBullet;
	private ArrayList<Sprite> fBullet;
	private ArrayList<Sprite> UnoBullet;
	private Sprite bulletIP;
	private Sprite bulletINC;
	private Sprite bulletF;
	private Sprite bulletUno;
	private Sprite livesPlus3;
	
	private Sprite count;
	private Sprite Start;
	private Sprite Emmy;
	private Sprite bulletMain;
	private Sprite bulletDouble1;
	private Sprite bulletDouble2;
	private Sprite gameOver;
	private Sprite restart;
	private Sprite menuReturn;
	private Sprite Congratulations;
	private Sprite Continue;
	private Sprite ContinueOutro;
	private Sprite Loading;
	
	private SpriteBatch batch;
	private Rectangle screenBounds;
	
    public static int PLAYER_SPEED5 = Level4.PLAYER_SPEED4;
    public static int BULLET_SPEED5 = Level4.BULLET_SPEED4;
    public static float BULLET_DELAY_TIME = Level4.BULLET_DELAY_TIME;
    private static int BOSS_BULLET_SPEED_IP = 750;
    private static int EMMY_BULLET_SPEED_UNO = 150;
    
    private static float BOSS_BULLET_DELAY_TIME = 0.6f;
    private static float EMMY_BULLET_DELAY_TIME = 1f;
    
    private static int IP_COUNT = 10;
    private static int UNO_COUNT = 1;
    
	private static int score = 3000;
	public static int livesRemaining2 = Level4.livesRemaining2;
	private float elapsedTime;
	private float elapsedTimeContinue;
	private float bulletDelayTime;
	
	private int bossHealth = 1000;
	private float emmySpeed = 300f;
	
	private float bossBulletDelayTime;
	private float emmyBulletDelayTime;
	private float playerDelayTime;
	
	private BitmapFont Score1;
	private BitmapFont Stats;
	
	private boolean bossNormal = false;
	
	private boolean isChoiceClicked = false;
	private boolean choice1Clicked = false;
	private boolean choice2Clicked = false;
	private boolean overlap = false;
	private boolean damaged = false;
	private boolean healed = false;
	
	private boolean isPlayerDead = false;
	private boolean isBossDead = false;
	private boolean bossDirectionRight = true;
	private boolean emmyDirectionRight = false;
	
	private boolean singleBullet = true;
	private boolean doubleBullet = false;
	
	private boolean ContinueClicked = false;
	
	boolean screenChanged;
    
    private ArrayList<Sprite> bullets;
    private ArrayList<Sprite> bullets2;
	
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
        
		// background
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("background/Level5.gif").read());
		
		//choice 1
		choiceTexture1 = new Texture("powerup/level5/LivesPlus5.png");
		Choice1 = new Sprite(choiceTexture1);
		Choice1.setCenter(Gdx.graphics.getWidth() / 2f - 210, Gdx.graphics.getHeight() / 2f);
		
		//choice 2
		choiceTexture2 = new Texture("powerup/level5/doubleBullets.png");
		Choice2 = new Sprite(choiceTexture2);
		Choice2.setCenter(Gdx.graphics.getWidth() / 2f + 210, Gdx.graphics.getHeight() / 2f);
		
		//count
		countTexture = new Texture(Gdx.files.internal("level/finalBoss.png"));
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
        
        //healed player
        playerHealTexture = new Texture(Gdx.files.internal("character/PlayerHeal.png"));
        healedPlayer = new Sprite(playerHealTexture);
        healedPlayer.setPosition(player.getX(), player.getY());
        healedPlayer.setSize(healedPlayer.getWidth() * 4, healedPlayer.getHeight() * 4);
        
        //bullet
        bulletTexture = new Texture(Gdx.files.internal("weapon/bullet.png"));
        bullets = new ArrayList<Sprite>();
        bullets2 = new ArrayList<Sprite>();
        
        //boss
        bossTexture = new Texture(Gdx.files.internal("character/bossNormal1.png"));
        boss = new Sprite(bossTexture);
		boss.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f + 120);
        boss.setSize(boss.getWidth() * 3 / 2, boss.getHeight() * 3 / 2);
        
        //boss shoot
        bossShootTexture = new Texture(Gdx.files.internal("character/bossShoot1.png"));
        bossShoot = new Sprite(bossShootTexture);
        bossShoot.setPosition(boss.getX(), boss.getY());
        bossShoot.setSize(bossShoot.getWidth() * 3 / 2, bossShoot.getHeight() * 3 / 2);
        
        
        //boss bullet IP
        ipTexture = new Texture(Gdx.files.internal("weapon/IP.png"));
        ipBullet = new ArrayList<Sprite>();
        
        //boss bullet INC
        incTexture = new Texture(Gdx.files.internal("weapon/INC.png"));
        incBullet = new ArrayList<Sprite>();
        
        //boss bullet F
        fTexture = new Texture(Gdx.files.internal("weapon/5.png"));
        fBullet = new ArrayList<Sprite>();
        
        //Emmy UNO
        unoTexture = new Texture(Gdx.files.internal("Buff/UNO.png"));
        UnoBullet = new ArrayList<Sprite>();
        
        //Lives plus 3
        livesPlus3Texture = new Texture(Gdx.files.internal("Buff/LivesPlus2.png"));
        livesPlus3 = new Sprite(livesPlus3Texture);
        livesPlus3.setSize(livesPlus3.getWidth(), livesPlus3.getHeight());
        livesPlus3.setPosition(Gdx.graphics.getWidth() / 2 - livesPlus3.getWidth() / 2 + 11, 50);
        
        //bossHealth
        bossHealthTexture = new Texture(Gdx.files.internal("bosshealth/healthBarAll1.png"));
        
        health20 = new TextureRegion(bossHealthTexture, 0, 0, 322, 8);
        bossHealthBar20 = new Sprite(health20);
        bossHealthBar20.setSize(bossHealthBar20.getWidth() * 7 / 2, bossHealthBar20.getHeight() * 4);
        bossHealthBar20.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health19 = new TextureRegion(bossHealthTexture, 0, 8, 322, 8);
        bossHealthBar19 = new Sprite(health19);
        bossHealthBar19.setSize(bossHealthBar19.getWidth() * 7 / 2, bossHealthBar19.getHeight() * 4);
        bossHealthBar19.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health18 = new TextureRegion(bossHealthTexture, 0, 16, 322, 8);
        bossHealthBar18 = new Sprite(health18);
        bossHealthBar18.setSize(bossHealthBar18.getWidth() * 7 / 2, bossHealthBar18.getHeight() * 4);
        bossHealthBar18.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health17 = new TextureRegion(bossHealthTexture, 0, 24, 322, 8);
        bossHealthBar17 = new Sprite(health17);
        bossHealthBar17.setSize(bossHealthBar17.getWidth() * 7 / 2, bossHealthBar17.getHeight() * 4);
        bossHealthBar17.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health16 = new TextureRegion(bossHealthTexture, 0, 32, 322, 8);
        bossHealthBar16 = new Sprite(health16);
        bossHealthBar16.setSize(bossHealthBar16.getWidth() * 7 / 2, bossHealthBar16.getHeight() * 4);
        bossHealthBar16.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health15 = new TextureRegion(bossHealthTexture, 0, 40, 322, 8);
        bossHealthBar15 = new Sprite(health15);
        bossHealthBar15.setSize(bossHealthBar15.getWidth() * 7 / 2, bossHealthBar15.getHeight() * 4);
        bossHealthBar15.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health14 = new TextureRegion(bossHealthTexture, 0, 48, 322, 8);
        bossHealthBar14 = new Sprite(health14);
        bossHealthBar14.setSize(bossHealthBar14.getWidth() * 7 / 2, bossHealthBar14.getHeight() * 4);
        bossHealthBar14.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health13 = new TextureRegion(bossHealthTexture, 0, 56, 322, 8);
        bossHealthBar13 = new Sprite(health13);
        bossHealthBar13.setSize(bossHealthBar13.getWidth() * 7 / 2, bossHealthBar13.getHeight() * 4);
        bossHealthBar13.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health12 = new TextureRegion(bossHealthTexture, 0, 64, 322, 8);
        bossHealthBar12 = new Sprite(health12);
        bossHealthBar12.setSize(bossHealthBar12.getWidth() * 7 / 2, bossHealthBar12.getHeight() * 4);
        bossHealthBar12.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health11 = new TextureRegion(bossHealthTexture, 0, 72, 322, 8);
        bossHealthBar11 = new Sprite(health11);
        bossHealthBar11.setSize(bossHealthBar11.getWidth() * 7 / 2, bossHealthBar11.getHeight() * 4);
        bossHealthBar11.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health10 = new TextureRegion(bossHealthTexture, 0, 80, 322, 8);
        bossHealthBar10 = new Sprite(health10);
        bossHealthBar10.setSize(bossHealthBar10.getWidth() * 7 / 2, bossHealthBar10.getHeight() * 4);
        bossHealthBar10.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health9 = new TextureRegion(bossHealthTexture, 0, 88, 322, 8);
        bossHealthBar9 = new Sprite(health9);
        bossHealthBar9.setSize(bossHealthBar9.getWidth() * 7 / 2, bossHealthBar9.getHeight() * 4);
        bossHealthBar9.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health8 = new TextureRegion(bossHealthTexture, 0, 96, 322, 8);
        bossHealthBar8 = new Sprite(health8);
        bossHealthBar8.setSize(bossHealthBar8.getWidth() * 7 / 2, bossHealthBar8.getHeight() * 4);
        bossHealthBar8.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health7 = new TextureRegion(bossHealthTexture, 0, 104, 322, 8);
        bossHealthBar7 = new Sprite(health7);
        bossHealthBar7.setSize(bossHealthBar7.getWidth() * 7 / 2, bossHealthBar7.getHeight() * 4);
        bossHealthBar7.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health6 = new TextureRegion(bossHealthTexture, 0, 112, 322, 8);
        bossHealthBar6 = new Sprite(health6);
        bossHealthBar6.setSize(bossHealthBar6.getWidth() * 7 / 2, bossHealthBar6.getHeight() * 4);
        bossHealthBar6.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health5 = new TextureRegion(bossHealthTexture, 0, 120, 322, 8);
        bossHealthBar5 = new Sprite(health5);
        bossHealthBar5.setSize(bossHealthBar5.getWidth() * 7 / 2, bossHealthBar5.getHeight() * 4);
        bossHealthBar5.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health4 = new TextureRegion(bossHealthTexture, 0, 128, 322, 8);
        bossHealthBar4 = new Sprite(health4);
        bossHealthBar4.setSize(bossHealthBar4.getWidth() * 7 / 2, bossHealthBar4.getHeight() * 4);
        bossHealthBar4.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health3 = new TextureRegion(bossHealthTexture, 0, 136, 322, 8);
        bossHealthBar3 = new Sprite(health3);
        bossHealthBar3.setSize(bossHealthBar3.getWidth() * 7 / 2, bossHealthBar3.getHeight() * 4);
        bossHealthBar3.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health2 = new TextureRegion(bossHealthTexture, 0, 144, 322, 8);
        bossHealthBar2 = new Sprite(health2);
        bossHealthBar2.setSize(bossHealthBar2.getWidth() * 7 / 2, bossHealthBar2.getHeight() * 4);
        bossHealthBar2.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health1 = new TextureRegion(bossHealthTexture, 0, 152, 322, 8);
        bossHealthBar1 = new Sprite(health1);
        bossHealthBar1.setSize(bossHealthBar1.getWidth() * 7 / 2, bossHealthBar1.getHeight() * 4);
        bossHealthBar1.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        health0 = new TextureRegion(bossHealthTexture, 0, 160, 322, 8);
        bossHealthBar0 = new Sprite(health0);
        bossHealthBar0.setSize(bossHealthBar0.getWidth() * 7 / 2, bossHealthBar0.getHeight() * 4);
        bossHealthBar0.setCenter(Gdx.graphics.getWidth() / 2f + 10, Gdx.graphics.getHeight() / 2f + 290);
        
        //maam emmy
        emmyTexture = new Texture(Gdx.files.internal("character/Emmy.png"));
        Emmy = new Sprite(emmyTexture);
        Emmy.setPosition(boss.getX() - 600, boss.getY() + 85);
        
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
        congratulationsTexture = new Texture(Gdx.files.internal("text/labTask5.png"));
        Congratulations = new Sprite(congratulationsTexture);
        Congratulations.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 50);
        
        //continue
        continueTexture = new Texture(Gdx.files.internal("touch/Continue.png"));
        Continue = new Sprite(continueTexture);
        Continue.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() - 500);
        
        continueOutroTexture = new Texture(Gdx.files.internal("touch/ContinueOutro.png"));
        ContinueOutro = new Sprite(continueOutroTexture);
        ContinueOutro.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2 - 100);
        
        loadingTexture = new Texture(Gdx.files.internal("text/loading.png"));
        Loading = new Sprite(loadingTexture);
        Loading.setCenter(Gdx.graphics.getWidth() / 2 + 10, Gdx.graphics.getHeight() / 2 - 200);
        
        //screenbound
        screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
		Gdx.input.setInputProcessor(this);
		screenChanged = false;
		
		//background music
        BackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/bossSpeedUpMusic.wav"));
        BackgroundMusic.setVolume(backgroundMusicDb - 0.2f);
        BackgroundMusic.setLooping(true);
        BackgroundMusic.play();
		
        PowerUp = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Powerup.wav"));
        PowerUp.setVolume(powerUpMusicDb);
        PowerUp.setLooping(false);
        
        Shoot = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/bulletShoot.wav"));
        Shoot.setVolume(shootMusicDb);
        Shoot.setLooping(false);
        
        AlienShoot = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/BossShoot.wav"));
        AlienShoot.setVolume(alienShootMusicDb);
        AlienShoot.setLooping(false);
        
        Explosion = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Level1Alien.wav"));
        Explosion.setVolume(explosionMusicDb);
        Explosion.setLooping(false);
        
    	Win = Gdx.audio.newMusic(Gdx.files.internal("Music/Ending.wav"));
    	Win.setVolume(winMusicDb);
    	Win.setLooping(false);
        
        GameOver = Gdx.audio.newMusic(Gdx.files.internal("Music/GameOver.wav"));
        GameOver.setVolume(gameOverMusicDb);
        GameOver.setLooping(false);
        
        Select = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/Select.wav"));
        Select.setVolume(selectMusicDb);
        Select.setLooping(false);
        
        bossSpeedUpMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/Level5.wav"));
        bossSpeedUpMusic.setVolume(bossSpeedUpMusicDb);
        bossSpeedUpMusic.setLooping(true);
        
        playerDamage = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/playerDamage.wav"));
        playerDamage.setVolume(playerDamageMusicDb);
        playerDamage.setLooping(false);
        
        addLives = Gdx.audio.newMusic(Gdx.files.internal("Music/Sound/addLives.wav"));
        addLives.setVolume(addLivesMusicDb);
        addLives.setLooping(false);
	}
	
	@Override
	public void render(float delta) {
		handleInput(delta);
		update(delta);
		
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		batch.draw(animation.getKeyFrame(elapsed), 0, 0, 1280, 720);
		
		if (!isChoiceClicked) {
			Choice1.draw(batch);
			Choice2.draw(batch);
		}
		
		if (!ContinueClicked) {
			//text
			Score1.draw(batch, "Score:   " + score, 0, Gdx.graphics.getHeight()- 5);
        	Stats.draw(batch, "Lives:   " + livesRemaining2, Gdx.graphics.getWidth() - 1000, Gdx.graphics.getHeight()- 5);
        	Stats.draw(batch, "Player Speed:   " + PLAYER_SPEED5, Gdx.graphics.getWidth() - 800, Gdx.graphics.getHeight()- 5);
        	Stats.draw(batch, "Bullet Speed:   " + BULLET_SPEED5, Gdx.graphics.getWidth() - 500, Gdx.graphics.getHeight()- 5);
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
				if(!isPlayerDead && elapsedTime > 2) {
					
					player.draw(batch);
					Emmy.draw(batch);
					
					
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

					
					if (healed) {
						livesPlus3.draw(batch);
						
					    playerDelayTime += delta;
					    
					    
					    if (playerDelayTime <= 0.6) {
					        if (playerDelayTime % 0.2 <= 0.1) {
					            healedPlayer.draw(batch);
					        } else {
					            player.draw(batch);
					        }
					    } else {
					        playerDelayTime = 0;
					        healed = false;
					    }
					}
					
					for (Sprite emmyBulletUno : UnoBullet) {
						emmyBulletUno.draw(batch);
					}
					
					bossShoot.setPosition(boss.getX(), boss.getY());
					
					if (!bossNormal) {
						bossShoot.draw(batch);
					}
					
					else if (bossNormal == true) {
						boss.draw(batch);
					}
					// Draw bullets
					if(singleBullet == true) {
						for (Sprite bulletMain : bullets) {
							bulletMain.draw(batch);
						}
					}
					
					if (doubleBullet == true) {
						for (Sprite bulletMain : bullets) {
							bulletMain.draw(batch);
						}
						for (Sprite bulletMain : bullets2) {
							bulletMain.draw(batch);
						}
					}
					
					if (!isBossDead) {
						if (bossHealth <= 1000 && bossHealth >= 951) {
							bossHealthBar20.draw(batch);
						}
						else if (bossHealth <= 950 && bossHealth >= 901) {
							bossHealthBar19.draw(batch);
						}
						else if (bossHealth <= 900 && bossHealth >= 851) {
							bossHealthBar18.draw(batch);
						}
						else if (bossHealth <= 850 && bossHealth >= 801) {
							bossHealthBar17.draw(batch);
						}
						else if (bossHealth <= 800 && bossHealth >= 751) {
							bossHealthBar16.draw(batch);
						}
						else if (bossHealth <= 750 && bossHealth >= 701) {
							bossHealthBar15.draw(batch);
						}
						else if (bossHealth <= 700 && bossHealth >= 651) {
							bossHealthBar14.draw(batch);
						}
						else if (bossHealth <= 650 && bossHealth >= 601) {
							bossHealthBar13.draw(batch);
						}
						else if (bossHealth <= 600 && bossHealth >= 551) {
							bossHealthBar12.draw(batch);
						}
						else if (bossHealth <= 550 && bossHealth >= 501) {
							bossHealthBar11.draw(batch);
						}
						else if (bossHealth <= 500 && bossHealth >= 451) {
							bossHealthBar10.draw(batch);
						}
						else if (bossHealth <= 450 && bossHealth >= 401) {
							bossHealthBar9.draw(batch);
						}
						else if (bossHealth <= 400 && bossHealth >= 351) {
							bossHealthBar8.draw(batch);
						}
						else if (bossHealth <= 350 && bossHealth >= 301) {
							bossHealthBar7.draw(batch);
						}
						else if (bossHealth <= 300 && bossHealth >= 251) {
							bossHealthBar6.draw(batch);
						}
						else if (bossHealth <= 250 && bossHealth >= 201) {
							bossHealthBar5.draw(batch);
							BOSS_BULLET_DELAY_TIME = 0.4f;
							
							BackgroundMusic.stop();
							bossSpeedUpMusic.play();
						}
						else if (bossHealth <= 200 && bossHealth >= 151) {
							bossHealthBar4.draw(batch);
						}
						else if (bossHealth <= 150 && bossHealth >= 101) {
							bossHealthBar3.draw(batch);
						}
						else if (bossHealth <= 100 && bossHealth >= 51) {
							bossHealthBar2.draw(batch);
						}
						else if (bossHealth <= 50 && bossHealth >= 1) {
							bossHealthBar1.draw(batch);
						}
						else if (bossHealth <= 0) {
							bossHealthBar0.draw(batch);
						}
						
						bossBulletDelayTime += delta;
						emmyBulletDelayTime += delta;
						
						if (IP_COUNT >= 10) {
							bossNormal = true;
							bossBulletDelayTime -= 1.2;
							IP_COUNT = 0;
							
						}
						
						if (bossBulletDelayTime >= BOSS_BULLET_DELAY_TIME && IP_COUNT <= 10) {
							bossNormal = false;
							
							bulletIP = new Sprite(ipTexture);
							bulletIP.setPosition(boss.getX() + 55, boss.getY() - 15);
							bulletIP.setSize(bulletIP.getWidth() *3, bulletIP.getHeight() *3);
							ipBullet.add(bulletIP);
							
							bulletINC = new Sprite(incTexture);
							bulletINC.setPosition(boss.getX() + 55, boss.getY() - 15);
							bulletINC.setSize(bulletINC.getWidth() *2, bulletINC.getHeight() *2);
							incBullet.add(bulletINC);
							
							bulletF = new Sprite(fTexture);
							bulletF.setPosition(boss.getX() + 55, boss.getY() - 15);
							bulletF.setSize(bulletF.getWidth() *2, bulletF.getHeight() *2);
							fBullet.add(bulletF);
							bossBulletDelayTime = 0f;
							
							AlienShoot.play();
							
							IP_COUNT += 1;
						}
						
						if (UNO_COUNT >= 1) {
							emmyBulletDelayTime -= 10;
							UNO_COUNT = 0;
						}
						
						if (emmyBulletDelayTime >= EMMY_BULLET_DELAY_TIME && UNO_COUNT <= 1) {
							
							bulletUno = new Sprite(unoTexture);
							bulletUno.setPosition(Emmy.getX(), Emmy.getY());
							bulletUno.setSize(bulletUno.getWidth() *2, bulletUno.getHeight() *2);
							UnoBullet.add(bulletUno);
							emmyBulletDelayTime = 0f;
							
							UNO_COUNT += 1;
						}
						
						for (Sprite bossBulletF : ipBullet) {
							bossBulletF.draw(batch);
						}
						for (Sprite bossBulletINC : incBullet) {
							bossBulletINC.draw(batch);
						}
						for (Sprite bossBulletF : fBullet) {
							bossBulletF.draw(batch);
						}
					}
				}
			}
		}
		
		if (overlap == true) {
        	gameOver.draw(batch);
        	restart.draw(batch);
        	menuReturn.draw(batch);
        	
        	BackgroundMusic.stop();
        	bossSpeedUpMusic.stop();
        	Shoot.stop();
        	
        	if (GameOverDone) {
        		GameOver.play();
        		GameOverDone = false;
        	}
		}
		
		if (isBossDead == true) {
        	Congratulations.draw(batch);
        	ContinueOutro.draw(batch);
        	
        	bossSpeedUpMusic.stop();
        	Shoot.stop();
        	
        	if (WinDone) {
        		Win.play();
        		WinDone = false;
        	}
		}
		
		if (ContinueClicked) {
			
			elapsedTimeContinue += delta;
			
			Loading.draw(batch);
			
			if (elapsedTimeContinue >= 2) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Outro());
			}
		}
		
		batch.end();
	}
	
	private void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT)) {
            if (player.getX() > 0) { // Check if player is not at the left edge of the screen
                player.translateX(-PLAYER_SPEED5);
                damagedPlayer.translateX(-PLAYER_SPEED5);
                healedPlayer.translateX(-PLAYER_SPEED5);
                livesPlus3.translateX(-PLAYER_SPEED5);
            }
        }
        else if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D) || Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT)) {
            if (player.getX() < Gdx.graphics.getWidth() - player.getWidth()) { // Check if player is not at the right edge of the screen
                player.translateX(PLAYER_SPEED5);
                damagedPlayer.translateX(PLAYER_SPEED5);
                healedPlayer.translateX(PLAYER_SPEED5);
                livesPlus3.translateX(PLAYER_SPEED5);
            }
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.SPACE) || Gdx.input.isButtonPressed(com.badlogic.gdx.Input.Buttons.LEFT)) {
        	if (bulletDelayTime <= 0) {
        		if (singleBullet == true && elapsedTime >= 2  && !ContinueClicked) {
        			addBullet();
        			bulletDelayTime = BULLET_DELAY_TIME;
        		}
        		
        		if(doubleBullet == true && elapsedTime >= 2  && !ContinueClicked) {
        			doubleBullet1();
        			
        			bulletDelayTime = BULLET_DELAY_TIME;
        		}
        	}
        }
        
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.K)) {
        	boss.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f + 120);
        }
        
        bulletDelayTime -= delta;
	}
	
	
	private void update(float delta) {
		
		int desiredYMovement = 150;
		float bossSpeed = 150;

		float yMovementPerFrame = desiredYMovement / (bossSpeed * delta);

		boss.translateX(bossDirectionRight ? bossSpeed * delta : -bossSpeed * delta);
		if (boss.getX() + boss.getWidth() >= screenBounds.getWidth()) {
		    bossDirectionRight = !bossDirectionRight;
		    boss.translateY(-yMovementPerFrame);
		}
		if (boss.getX() <= 0) {
		    bossDirectionRight = !bossDirectionRight;
		    boss.translateY(yMovementPerFrame);
		}
		
		// move maam emmy
		Emmy.translateX(emmyDirectionRight ? emmySpeed * delta : -emmySpeed * delta);
		if(Emmy.getX() + Emmy.getWidth() >= screenBounds.getWidth() + 200) {
			emmyDirectionRight = !emmyDirectionRight;
		}
		else if (Emmy.getX() <= - 200) {
			emmyDirectionRight = !emmyDirectionRight;
		}
		
        // Update bullets
		if (singleBullet == true) { 
			//screenbounds
			for (int i = 0; i < bullets.size(); i++) {
				bulletMain = bullets.get(i);
				bulletMain.translateY(BULLET_SPEED5 * delta);
				if (bulletMain.getY() > screenBounds.getHeight()) {
					bullets.remove(i);
				}
			}
			
			//damage the boss
			for (int i = 0; i < bullets.size(); i++) {
				Sprite bulletMain = bullets.get(i);
				if(bulletMain.getBoundingRectangle().overlaps(boss.getBoundingRectangle()) ||
						bulletMain.getBoundingRectangle().overlaps(bossShoot.getBoundingRectangle())) {
					Explosion.play();
					bullets.remove(i);
					bossHealth -= 4;
				}
			}
		}
		
		if (doubleBullet == true) {
			for (int i = 0; i < bullets.size(); i++) {
				bulletMain = bullets.get(i);
				bulletMain.translateY(BULLET_SPEED5 * delta);
				if (bulletMain.getY() > screenBounds.getHeight()) {
					bullets.remove(i);
					
				}
			}
			for (int i = 0; i < bullets2.size(); i++) {
				bulletMain = bullets2.get(i);
				bulletMain.translateY(BULLET_SPEED5 * delta);
				if (bulletMain.getY() > screenBounds.getHeight()) {
					bullets2.remove(i);
				}
			}
			
			//damage the boss
			for (int i = 0; i < bullets.size(); i++) {
				Sprite bulletMain = bullets.get(i);
				if(bulletMain.getBoundingRectangle().overlaps(boss.getBoundingRectangle()) ||
						bulletMain.getBoundingRectangle().overlaps(bossShoot.getBoundingRectangle())) {
					bullets.remove(i);
					bossHealth -= 4;
					Explosion.play();
				}
			}
			
			for (int i = 0; i < bullets2.size(); i++) {
				Sprite bulletMain = bullets2.get(i);
				if(bulletMain.getBoundingRectangle().overlaps(boss.getBoundingRectangle()) ||
						bulletMain.getBoundingRectangle().overlaps(bossShoot.getBoundingRectangle())) {
					bullets2.remove(i);
					bossHealth -= 4;
					Explosion.play();
				}
			}
		}
		
		for (int i = 0; i < ipBullet.size(); i++) {
			Sprite bossBulletIP = ipBullet.get(i);
			bossBulletIP.setY(bossBulletIP.getY() - BOSS_BULLET_SPEED_IP * delta);

			if (bossBulletIP.getY() < -150) {
				ipBullet.remove(i);
			}
		}
		
		for (int j = 0; j < incBullet.size(); j++) {
			Sprite bossBulletINC = incBullet.get(j);
			bossBulletINC.setX(bossBulletINC.getX() - BOSS_BULLET_SPEED_IP * delta);
			bossBulletINC.setY(bossBulletINC.getY() - BOSS_BULLET_SPEED_IP * delta);
			
			if (bossBulletINC.getX() < -150 || bossBulletINC.getY() < -150) {
				incBullet.remove(j);
			}
		}
		
		for (int k = 0; k < fBullet.size(); k++) {
			Sprite bossBulletF = fBullet.get(k);
			bossBulletF.setX(bossBulletF.getX() + BOSS_BULLET_SPEED_IP * delta);
		    bossBulletF.setY(bossBulletF.getY() - BOSS_BULLET_SPEED_IP * delta);
			
			if (bossBulletF.getX() < -150 || bossBulletF.getY() < -150) {
				fBullet.remove(k);
			}
		}

		// plus health bullet
		for (int j = 0; j < UnoBullet.size(); j++) {
			Sprite emmyBulletUno = UnoBullet.get(j);
			emmyBulletUno.setY(emmyBulletUno.getY() - EMMY_BULLET_SPEED_UNO * delta);
			
			if (emmyBulletUno.getY() < -150) {
				UnoBullet.remove(j);
			}
		}
        
        //minus lives every overlap
        for (int i = 0; i < ipBullet.size(); i++) {
        	Sprite bulletIP = ipBullet.get(i);
        	if (bulletIP.getBoundingRectangle().overlaps(player.getBoundingRectangle())) {
        		ipBullet.remove(i);
        		livesRemaining2 -= 1;
        		playerDamage.play();
        		damaged = true;
        	}
        }
		
        for (int i = 0; i < incBullet.size(); i++) {
        	Sprite bulletINC = incBullet.get(i);
        	if (bulletINC.getBoundingRectangle().overlaps(player.getBoundingRectangle())) {
        		incBullet.remove(i);
        		livesRemaining2 -= 1;
        		playerDamage.play();
        		damaged = true;
        	}
        }
		
        for (int i = 0; i < fBullet.size(); i++) {
        	Sprite bulletF = fBullet.get(i);
        	if (bulletF.getBoundingRectangle().overlaps(player.getBoundingRectangle())) {
        		fBullet.remove(i);
        		livesRemaining2 -= 1;
        		playerDamage.play();
        		damaged = true;
        	}
        }
        
        
        for (int i = 0; i < UnoBullet.size(); i++) {
        	Sprite bulletUno = UnoBullet.get(i);
        	if (bulletUno.getBoundingRectangle().overlaps(player.getBoundingRectangle())) {
        		UnoBullet.remove(i);
        		livesRemaining2 += 2;
        		addLives.play();
        		healed = true;
        	}
        }
		
        if (bossHealth <= 0) {
        	bossHealth = 0;
        	score = 5000;
        	BOSS_BULLET_DELAY_TIME = 0.6f;
        	isBossDead = true;
        	Shoot.stop();
        	Explosion.stop();
        }
        
        if (livesRemaining2 <= 0) {
        	BOSS_BULLET_DELAY_TIME = 0.6f;
        	overlap = true;
        	isPlayerDead = true;
        	Explosion.stop();
        	Shoot.stop();
        	livesRemaining2 = 0;
        }
        
        if(isBossDead == true || score == 5000 || overlap == true) {
        	bossTexture.dispose();
        	bossShootTexture.dispose();
        	emmyTexture.dispose();
        	bulletTexture.dispose();
        	bullets.clear();
        	bullets2.clear();
        	UnoBullet.clear();
        	
        	boss.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f + 800);
        	Emmy.setCenter(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f + 800);
        }
	}
	
	private void addBullet() {
		bulletMain = new Sprite(bulletTexture);
		bulletMain.setPosition(player.getX() + player.getWidth() / 3 - bulletMain.getWidth() / 2, player.getY() + player.getHeight());
		bulletMain.setSize(bulletMain.getWidth() * 5, bulletMain.getHeight() * 5);
        bullets.add(bulletMain);
        Shoot.play();
	}
	
	private void doubleBullet1() {
		bulletDouble1 = new Sprite(bulletTexture);
		bulletDouble2 = new Sprite(bulletTexture);
		
		
		bulletDouble1.setPosition(player.getX() + player.getWidth() / 3 - bulletDouble1.getWidth() / 2 - 16, player.getY() + player.getHeight());
		bulletDouble1.setSize(bulletDouble1.getWidth() * 5, bulletDouble1.getHeight() * 5);
        
		bulletDouble2.setPosition(player.getX() + player.getWidth() / 3 - bulletDouble2.getWidth() / 2 + 16, player.getY() + player.getHeight());
		bulletDouble2.setSize(bulletDouble2.getWidth() * 5, bulletDouble2.getHeight() * 5);
		
		bullets.add(bulletDouble1);
		bullets2.add(bulletDouble2);
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
		unoTexture.dispose();
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
				livesRemaining2 += 5;
				choice1Clicked = true;
				isChoiceClicked = true;
				choiceTexture1.dispose();
				choiceTexture2.dispose();
			}
			else if (!choice2Clicked && Choice2.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
				PowerUp.play();
				singleBullet = false;
				doubleBullet = true;
				
				choice2Clicked = true;
				isChoiceClicked = true;
				choiceTexture1.dispose();
				choiceTexture2.dispose();
			}
		}
		
		else if (livesRemaining2 == 0) {
		    if (restart.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY) && !screenChanged) {
		    	GameOver.stop();
		    	Select.play();
		        score = 3000;
		        livesRemaining2 = Level2.livesRemaining2;
		        PLAYER_SPEED5 = Level2.PLAYER_SPEED;
		        BULLET_SPEED5 = Level2.BULLET_SPEED;
		        BULLET_DELAY_TIME = Level2.BULLET_DELAY_TIME;
		        dispose();
		        ((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
		    }
		    
		    else if (menuReturn.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY) && !screenChanged) {
		    	GameOver.stop();
		    	Select.play();
		        score = 3000;
		        livesRemaining2 = Level2.livesRemaining2;
		        PLAYER_SPEED5 = Level2.PLAYER_SPEED;
		        BULLET_SPEED5 = Level2.BULLET_SPEED;
		        BULLET_DELAY_TIME = Level2.BULLET_DELAY_TIME;
		        dispose();
		        ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
		    }
		}
		
		else if (isBossDead == true) {
		    if (ContinueOutro.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY) && !screenChanged) {
		    	Win.stop();
		    	Select.play();
		        score = 3000;
		        livesRemaining2 = Level2.livesRemaining2;
		        PLAYER_SPEED5 = Level2.PLAYER_SPEED;
		        BULLET_SPEED5 = Level2.BULLET_SPEED;
		        BULLET_DELAY_TIME = Level2.BULLET_DELAY_TIME;
		        
		        ContinueClicked = true;
		    }
		}
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

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}