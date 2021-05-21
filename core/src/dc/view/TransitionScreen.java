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
/*    */ public class TransitionScreen
/*    */   extends AbstractScreen
/*    */ {
/*    */   private AbstractScreen currentScreen;
/*    */   private AbstractScreen nextScreen;
/*    */   private DarkCave game;
/* 17 */   private float alpha = 0.0F;
/*    */   
/*    */   private boolean fadeDirection = true;
/*    */   
/*    */   public TransitionScreen(GameScreenManager.STATE current, GameScreenManager.STATE next, DarkCave game) {
/* 22 */     super(game);
/* 23 */     this.currentScreen = (AbstractScreen)game.gsm.gameScreens.get(current);
/* 24 */     this.nextScreen = (AbstractScreen)game.gsm.gameScreens.get(next);
/*    */     
/* 26 */     game.gsm.setScreen(current);
/* 27 */     game.gsm.setScreen(next);
/*    */     
/* 29 */     this.currentScreen.paused = true;
/*    */     
/* 31 */     this.game = game;
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 36 */     super.show();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 41 */     Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 42 */     Gdx.gl.glClear(16384);
/*    */     
/* 44 */     if (this.fadeDirection) {
/* 45 */       this.currentScreen.render(Gdx.graphics.getDeltaTime());
/*    */     } else {
/* 47 */       this.nextScreen.render(Gdx.graphics.getDeltaTime());
/*    */     } 
/*    */     
/* 50 */     Gdx.gl.glEnable(3042);
/* 51 */     Gdx.gl.glBlendFunc(770, 771);
/* 52 */     this.game.shapeRenderer.setColor(0.0F, 0.0F, 0.0F, this.alpha);
/* 53 */     this.game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/* 54 */     this.game.shapeRenderer.rect(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/* 55 */     this.game.shapeRenderer.end();
/* 56 */     Gdx.gl.glDisable(3042);
/*    */     
/* 58 */     if (this.alpha >= 1.0F) {
/* 59 */       this.fadeDirection = false;
/* 60 */       this.nextScreen.paused = false;
/*    */     }
/* 62 */     else if (this.alpha <= 0.0F && !this.fadeDirection) {
/* 63 */       this.game.setScreen(this.nextScreen);
/*    */     } 
/*    */     
/* 66 */     this.alpha = (float)(this.alpha + (this.fadeDirection ? 0.03D : -0.03D));
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
/* 84 */     super.dispose();
/*    */   }
/*    */   
/*    */   public void update(float delta) {}
/*    */   
/*    */   public void screenChange() {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\TransitionScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */