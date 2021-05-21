/*     */ package dc.view;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import dc.controller.box.SettingsController;
/*     */ import dc.controller.manager.GameScreenManager;
/*     */ import dc.game.DarkCave;
/*     */ import dc.settings.Constans;
/*     */ import dc.view.box.OptionBox;
/*     */ 
/*     */ public class SettingsScreen
/*     */   extends AbstractScreen {
/*     */   private Texture back;
/*     */   private Table settings;
/*     */   private Table exit;
/*     */   private OptionBox volume;
/*     */   private SettingsController controller;
/*     */   
/*     */   public SettingsScreen(DarkCave game) {
/*  25 */     super(game);
/*     */     
/*  27 */     this.back = new Texture("Background/MainMenu.png");
/*     */     
/*  29 */     this.settings = new Table();
/*  30 */     Label text = new Label("Volume Musica: ", this.skin, "year199x", Color.BLACK);
/*  31 */     text.setFontScale(1.15F);
/*  32 */     this.settings.add((Actor)text);
/*     */     
/*  34 */     this.settings.setVisible(true);
/*  35 */     this.settings.setPosition(210.0F, 500.0F);
/*     */     
/*  37 */     this.volume = new OptionBox(this.skin);
/*  38 */     this.volume.addOption("0");
/*  39 */     this.volume.addOption("1");
/*  40 */     this.volume.addOption("2");
/*  41 */     this.volume.addOption("3");
/*  42 */     this.volume.addOption("4");
/*  43 */     this.volume.addOption("5");
/*  44 */     this.volume.addOption("6");
/*  45 */     this.volume.addOption("7");
/*  46 */     this.volume.addOption("8");
/*  47 */     this.volume.addOption("9");
/*  48 */     this.volume.addOption("10");
/*     */     
/*  50 */     this.volume.setSize(480.0F, 60.0F);
/*  51 */     this.volume.setVisible(true);
/*  52 */     this.volume.setPosition(300.0F, 467.0F);
/*     */     
/*  54 */     this.stage.addActor((Actor)this.settings);
/*  55 */     this.stage.addActor((Actor)this.volume);
/*     */     
/*  57 */     this.controller = new SettingsController(this.volume, game);
/*     */     
/*  59 */     this.exit = new Table();
/*  60 */     Label msg = new Label("PREMERE C PER RITORNARE NEL MENU' PRINCIPALE", this.skin, "year199x", Color.BLACK);
/*  61 */     msg.setFontScale(1.15F);
/*  62 */     this.exit.add((Actor)msg).center();
/*  63 */     this.exit.setVisible(true);
/*  64 */     this.exit.setPosition((Constans.APP_DESKTOP_WIDTH / 2), 200.0F);
/*     */     
/*  66 */     this.stage.addActor((Actor)this.exit);
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/*  71 */     super.show();
/*  72 */     Gdx.input.setInputProcessor((InputProcessor)this.controller);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float delta) {}
/*     */ 
/*     */   
/*     */   public void render(float delta) {
/*  80 */     super.render(delta);
/*  81 */     this.batch.begin();
/*  82 */     this.batch.draw(this.back, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT);
/*  83 */     this.batch.end();
/*     */     
/*  85 */     this.stage.act(delta);
/*  86 */     this.stage.draw();
/*     */   }
/*     */ 
/*     */   
/*     */   public void screenChange() {
/*  91 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.SETTINGS);
/*     */   }
/*     */ 
/*     */   
/*     */   public void pause() {}
/*     */ 
/*     */   
/*     */   public void resume() {}
/*     */ 
/*     */   
/*     */   public void hide() {}
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 105 */     super.dispose();
/* 106 */     this.settings.clear();
/* 107 */     this.exit.clear();
/* 108 */     this.volume.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\SettingsScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */