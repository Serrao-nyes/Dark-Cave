/*    */ package dc.view;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.parameters.AlliesParameters;
/*    */ import dc.settings.Constans;
/*    */ 
/*    */ 
/*    */ public class GameOverScreen
/*    */   extends AbstractScreen
/*    */ {
/*    */   private Texture back;
/*    */   private Table end;
/*    */   
/*    */   public GameOverScreen(DarkCave game) {
/* 22 */     super(game);
/* 23 */     this.back = new Texture("Background/GameOver.png");
/*    */     
/* 25 */     this.end = new Table();
/* 26 */     Label msg = new Label("PREMERE X PER RITORNARE NEL MENU' PRINCIPALE", this.skin, "year199x", Color.WHITE);
/* 27 */     this.end.add((Actor)msg).center();
/* 28 */     this.end.setVisible(true);
/* 29 */     this.end.setPosition((Constans.APP_DESKTOP_WIDTH / 2), 200.0F);
/*    */     
/* 31 */     this.stage.addActor((Actor)this.end);
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 36 */     super.show();
/* 37 */     DarkCave.music.gameover.play();
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(float delta) {}
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 45 */     super.render(delta);
/* 46 */     this.batch.begin();
/* 47 */     this.batch.draw(this.back, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT);
/* 48 */     this.batch.end();
/*    */     
/* 50 */     this.stage.act(delta);
/* 51 */     this.stage.draw();
/*    */   }
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 56 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.GAMEOVER);
/*    */     
/* 58 */     if (Gdx.input.isKeyJustPressed(52)) {
/* 59 */       DarkCave.music.gameover.stop();
/* 60 */       resetGame();
/*    */     } 
/*    */   }
/*    */   private void resetGame() {
/* 64 */     AlliesParameters.resetParameters();
/* 65 */     this.game.dispose();
/* 66 */     this.game.create();
/*    */   }
/*    */ 
/*    */   
/*    */   public void pause() {}
/*    */ 
/*    */   
/*    */   public void resume() {}
/*    */ 
/*    */   
/*    */   public void hide() {}
/*    */   
/*    */   public void dispose() {
/* 79 */     super.dispose();
/* 80 */     this.end.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\GameOverScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */