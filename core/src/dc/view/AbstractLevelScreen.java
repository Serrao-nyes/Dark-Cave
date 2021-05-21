/*     */ package dc.view;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMap;
/*     */ import com.badlogic.gdx.maps.tiled.TmxMapLoader;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import dc.controller.ExploringCamera;
/*     */ import dc.controller.FixedMapRenderer;
/*     */ import dc.controller.PlayerController;
/*     */ import dc.controller.box.InventoryBoxController;
/*     */ import dc.controller.box.PauseBoxController;
/*     */ import dc.game.DarkCave;
/*     */ import dc.model.Player;
/*     */ import dc.settings.Constans;
/*     */ import dc.view.box.InventoryTab;
/*     */ import dc.view.box.PauseBox;
/*     */ 
/*     */ public abstract class AbstractLevelScreen extends AbstractScreen {
/*     */   protected Player player;
/*     */   protected OrthographicCamera camera;
/*     */   protected ExploringCamera exploring;
/*     */   protected PlayerController control;
/*     */   protected TmxMapLoader maploader;
/*     */   protected TiledMap map;
/*     */   protected FixedMapRenderer renderer;
/*     */   protected InventoryTab inventory;
/*     */   protected PauseBox pausa;
/*     */   protected Table pausaTable;
/*     */   protected InventoryBoxController invcontroller;
/*     */   protected PauseBoxController pcontroller;
/*  36 */   protected int[] Layers = null;
/*  37 */   protected int[] MasterLayers = null;
/*     */ 
/*     */   
/*     */   public AbstractLevelScreen(DarkCave game) {
/*  41 */     super(game);
/*  42 */     this.maploader = new TmxMapLoader();
/*  43 */     this.camera = new OrthographicCamera(340.0F, 260.0F);
/*  44 */     this.exploring = new ExploringCamera();
/*     */     
/*  46 */     this.inventory = new InventoryTab(this.skin);
/*  47 */     this.invcontroller = new InventoryBoxController(this.inventory, game, this.skin);
/*  48 */     this.inventory.setVisible(false);
/*     */     
/*  50 */     this.pausa = new PauseBox(this.skin);
/*  51 */     this.pcontroller = new PauseBoxController(this.pausa, game);
/*  52 */     this.pausa.setVisible(false);
/*     */     
/*  54 */     this.stage.addActor((Actor)this.inventory);
/*  55 */     this.stage.addActor((Actor)this.pausa);
/*     */     
/*  57 */     this.Layers = new int[0];
/*  58 */     this.MasterLayers = new int[0];
/*     */   }
/*     */   
/*     */   public void show() {
/*  62 */     super.show();
/*  63 */     DarkCave.music.maintheme.stop();
/*     */   }
/*     */   public void init() {
/*  66 */     this.control = new PlayerController(this.player);
/*  67 */     this.exploring.setTarget((Sprite)this.player);
/*  68 */     this.renderer = new FixedMapRenderer(this.map);
/*     */   }
/*     */   
/*     */   public void update(float delta) {
/*  72 */     if (!this.inv) {
/*  73 */       this.player.update(delta);
/*  74 */       this.control.keyDown(delta);
/*     */     } 
/*  76 */     this.exploring.update(delta);
/*  77 */     this.player.changeLeader();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(float delta) {
/*  82 */     if (this.paused) {
/*  83 */       if (Gdx.input.isKeyJustPressed(131)) {
/*  84 */         Gdx.input.setInputProcessor(null);
/*  85 */         this.pausa.setVisible(false);
/*  86 */         this.paused = false;
/*     */       } 
/*     */     } else {
/*     */       
/*  90 */       super.render(delta);
/*  91 */       this.exploring.applyTo(this.camera);
/*  92 */       this.batch.setProjectionMatrix(this.camera.combined);
/*  93 */       this.renderer.setView(this.camera);
/*     */     } 
/*  95 */     this.renderer.render(this.Layers);
/*  96 */     renderChar();
/*  97 */     this.renderer.render(this.MasterLayers);
/*  98 */     this.stage.act(delta);
/*  99 */     this.stage.draw();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderChar() {
/* 104 */     this.batch.begin();
/*     */     
/* 106 */     if (this.player.RightWalk || this.player.RightStand) {
/*     */       
/* 108 */       this.batch.draw((TextureRegion)this.player, this.player.getX() + Constans.PLAYER_SCALE_WIDTH, this.player.getY(), -this.player.getWidth(), this.player.getHeight() + 1.0F);
/*     */     } else {
/*     */       
/* 111 */       this.batch.draw((TextureRegion)this.player, this.player.getX(), this.player.getY(), this.player.getWidth(), this.player.getHeight() + 1.0F);
/*     */     } 
/* 113 */     this.batch.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public void screenChange() {
/* 118 */     if (Gdx.input.isKeyJustPressed(131)) {
/* 119 */       pausa();
/*     */     }
/*     */     
/* 122 */     if (this.inv) {
/* 123 */       if (Gdx.input.isKeyJustPressed(61)) {
/* 124 */         inventory();
/*     */       }
/* 126 */     } else if (Gdx.input.isKeyJustPressed(61)) {
/* 127 */       inventory();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void inventory() {
/* 133 */     if (this.inv) {
/* 134 */       Gdx.input.setInputProcessor(null);
/* 135 */       this.inventory.setVisible(false);
/* 136 */       this.inventory.clear();
/* 137 */       this.inv = false;
/*     */     } else {
/*     */       
/* 140 */       Gdx.input.setInputProcessor((InputProcessor)this.invcontroller);
/* 141 */       this.inventory.update(this.game);
/* 142 */       this.inventory.setVisible(true);
/* 143 */       this.inv = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void pausa() {
/* 148 */     this.paused = true;
/* 149 */     Gdx.input.setInputProcessor((InputProcessor)this.pcontroller);
/* 150 */     this.pausa.setVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resize(int width, int height) {
/* 155 */     super.resize(width, height);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 160 */     super.dispose();
/* 161 */     this.map.dispose();
/* 162 */     this.renderer.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\AbstractLevelScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */