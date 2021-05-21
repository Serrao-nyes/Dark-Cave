/*    */ package dc.view.level;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.InputProcessor;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.model.Player;
/*    */ import dc.view.AbstractLevelScreen;
/*    */ 
/*    */ public class FinaleLevelScreen
/*    */   extends AbstractLevelScreen
/*    */ {
/*    */   private Sprite ruxoll;
/*    */   
/*    */   public FinaleLevelScreen(DarkCave game) {
/* 19 */     super(game);
/* 20 */     this.map = this.maploader.load("maps/finale/finale.tmx");
/* 21 */     this.player = new Player(this.map, game);
/*    */     
/* 23 */     this.ruxoll = new Sprite(new Texture("Sprite/Boss/Ruxoll/ruxoll.png"));
/*    */     
/* 25 */     init();
/*    */     
/* 27 */     this.Layers = new int[] { 0, 1 };
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 32 */     super.show();
/*    */     
/* 34 */     Gdx.input.setInputProcessor((InputProcessor)this.control);
/*    */     
/* 36 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.CAVE) {
/* 37 */       this.player.setPosition(400.0F, 50.0F);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(float delta) {
/* 43 */     super.update(delta);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 48 */     super.render(delta);
/* 49 */     this.batch.begin();
/* 50 */     this.batch.draw((TextureRegion)this.ruxoll, 397.0F, 530.0F, 20.0F, 35.0F);
/* 51 */     this.batch.end();
/*    */   }
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 56 */     super.screenChange();
/*    */     
/* 58 */     if (this.player.doTransictionDoor().equals("CAVE")) {
/* 59 */       this.game.gsm.doTransition(GameScreenManager.STATE.CAVE);
/*    */     }
/*    */     
/* 62 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.FINALE);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 67 */     super.dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   public void resize(int width, int height) {
/* 72 */     super.resize(width, height);
/*    */   }
/*    */   
/*    */   public void pause() {}
/*    */   
/*    */   public void resume() {}
/*    */   
/*    */   public void hide() {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\level\FinaleLevelScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */