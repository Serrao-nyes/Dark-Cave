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
/*    */ public class VictoryScreen
/*    */   extends AbstractScreen
/*    */ {
/*    */   private Texture back;
/*    */   private Table end;
/*    */   
/*    */   public VictoryScreen(DarkCave game) {
/* 21 */     super(game);
/*    */     
/* 23 */     this.back = new Texture("Background/Victory.jpg");
/*    */     
/* 25 */     this.end = new Table();
/* 26 */     Label msg = new Label("PREMERE X PER RITORNARE NEL MENU' PRINCIPALE", this.skin, "year199x", Color.WHITE);
/* 27 */     this.end.add((Actor)msg).center();
/* 28 */     this.end.setVisible(true);
/* 29 */     this.end.setPosition((Constans.APP_DESKTOP_WIDTH / 2), 200.0F);
/*    */     
/* 31 */     this.stage.addActor((Actor)this.end);
/*    */   }
/*    */   private void resetGame() {
/* 34 */     AlliesParameters.resetParameters();
/* 35 */     this.game.dispose();
/* 36 */     this.game.create();
/*    */   }
/*    */   
/*    */   public void show() {
/* 40 */     super.show();
/* 41 */     DarkCave.music.victorytheme.stop();
/* 42 */     DarkCave.music.finalvictorytheme.play();
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(float delta) {}
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 50 */     super.render(delta);
/* 51 */     this.batch.begin();
/* 52 */     this.batch.draw(this.back, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT);
/* 53 */     this.batch.end();
/*    */     
/* 55 */     this.stage.act(delta);
/* 56 */     this.stage.draw();
/*    */   }
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 61 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.VICTORY);
/*    */     
/* 63 */     if (Gdx.input.isKeyJustPressed(52)) {
/* 64 */       DarkCave.music.finalvictorytheme.stop();
/* 65 */       resetGame();
/*    */     } 
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
/*    */   
/*    */   public void dispose() {
/* 80 */     super.dispose();
/* 81 */     this.end.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\VictoryScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */