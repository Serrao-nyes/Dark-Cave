/*    */ package dc.view;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.InputProcessor;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*    */ import dc.controller.box.MainMenuBoxController;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.settings.Constans;
/*    */ import dc.view.box.MainMenuTab;
/*    */ 
/*    */ public class MainMenuScreen
/*    */   extends AbstractScreen {
/*    */   private MainMenuTab tab;
/*    */   private MainMenuBoxController controller;
/*    */   private Table titolo;
/*    */   private Texture back;
/*    */   
/*    */   public MainMenuScreen(DarkCave game) {
/* 24 */     super(game);
/*    */     
/* 26 */     this.back = new Texture("Background/MainMenu.png");
/*    */     
/* 28 */     this.tab = new MainMenuTab(this.skin);
/* 29 */     this.tab.setPosition(30.0F, 140.0F);
/* 30 */     this.controller = new MainMenuBoxController(this.tab, game);
/*    */     
/* 32 */     titolo();
/*    */     
/* 34 */     this.stage.addActor((Actor)this.tab);
/* 35 */     this.stage.addActor((Actor)this.titolo);
/*    */   }
/*    */   
/*    */   private void titolo() {
/* 39 */     this.titolo = new Table();
/* 40 */     Label t1 = new Label("DARK", this.skin, "giygas", Color.BLACK);
/* 41 */     t1.setFontScale(3.0F);
/* 42 */     Label t2 = new Label("CAVE", this.skin, "giygas", Color.BLACK);
/* 43 */     t2.setFontScale(3.0F);
/* 44 */     this.titolo.add((Actor)t1);
/* 45 */     this.titolo.row();
/* 46 */     this.titolo.add((Actor)t2);
/* 47 */     this.titolo.setPosition(730.0F, 460.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 52 */     Gdx.input.setInputProcessor((InputProcessor)this.controller);
/* 53 */     DarkCave.music.gameover.stop();
/* 54 */     DarkCave.music.victorytheme.stop();
/* 55 */     DarkCave.music.maintheme.play();
/* 56 */     super.show();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(float delta) {}
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 65 */     if (!this.paused) {
/* 66 */       super.render(delta);
/*    */     }
/* 68 */     this.controller.keyDown();
/* 69 */     Gdx.gl.glClearColor(5.0F, 0.0F, 0.0F, 1.0F);
/* 70 */     Gdx.gl.glClear(16384);
/*    */     
/* 72 */     this.batch.begin();
/* 73 */     this.batch.draw(this.back, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT);
/* 74 */     this.batch.end();
/*    */     
/* 76 */     this.stage.act(delta);
/* 77 */     this.stage.draw();
/*    */   }
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 82 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.MAIN_MENU);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 87 */     super.dispose();
/*    */   }
/*    */   
/*    */   public void pause() {}
/*    */   
/*    */   public void resume() {}
/*    */   
/*    */   public void hide() {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\MainMenuScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */