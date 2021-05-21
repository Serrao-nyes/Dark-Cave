/*    */ package dc.view;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransitionBattleScreen
/*    */   extends AbstractScreen
/*    */ {
/*    */   private AbstractScreen currentScreen;
/*    */   private AbstractScreen nextScreen;
/*    */   private DarkCave game;
/* 17 */   private float alpha = 0.0F;
/*    */   
/*    */   private boolean fadeDirection = true;
/*    */   
/*    */   public TransitionBattleScreen(GameScreenManager.STATE current, GameScreenManager.STATE next, DarkCave game) {
/* 22 */     super(game);
/*    */     
/* 24 */     this.currentScreen = (AbstractScreen)game.gsm.gameScreens.get(current);
/* 25 */     this.nextScreen = (AbstractScreen)game.gsm.gameScreens.get(next);
/*    */     
/* 27 */     this.currentScreen.paused = true;
/*    */     
/* 29 */     this.game = game;
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 34 */     super.show();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 39 */     Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 40 */     Gdx.gl.glClear(16384);
/*    */     
/* 42 */     if (this.fadeDirection) {
/* 43 */       this.currentScreen.render(Gdx.graphics.getDeltaTime());
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 48 */     Gdx.gl.glEnable(3042);
/* 49 */     Gdx.gl.glBlendFunc(770, 771);
/* 50 */     this.game.shapeRenderer.setColor(255.0F, 255.0F, 255.0F, this.alpha);
/* 51 */     this.game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/* 52 */     this.game.shapeRenderer.rect(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/* 53 */     this.game.shapeRenderer.end();
/* 54 */     Gdx.gl.glDisable(3042);
/*    */     
/* 56 */     if (this.alpha >= 1.0F) {
/* 57 */       this.fadeDirection = false;
/*    */     }
/* 59 */     else if (this.alpha <= 0.0F && !this.fadeDirection) {
/* 60 */       this.game.setScreen(this.nextScreen);
/*    */     } 
/*    */     
/* 63 */     this.alpha = (float)(this.alpha + (this.fadeDirection ? 0.03D : -0.03D));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void resize(int width, int height) {}
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
/* 81 */     super.dispose();
/* 82 */     this.game.dispose();
/*    */   }
/*    */   
/*    */   public void update(float delta) {}
/*    */   
/*    */   public void screenChange() {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\TransitionBattleScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */