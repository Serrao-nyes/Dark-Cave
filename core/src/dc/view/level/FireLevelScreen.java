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
/*    */ public class FireLevelScreen
/*    */   extends AbstractLevelScreen
/*    */ {
/*    */   private Sprite dragon;
/*    */   
/*    */   public FireLevelScreen(DarkCave game) {
/* 19 */     super(game);
/* 20 */     this.map = this.maploader.load("maps/firelevel/firelevel.tmx");
/* 21 */     this.player = new Player(this.map, game);
/*    */     
/* 23 */     this.dragon = new Sprite(new Texture("Sprite/Boss/Dragon/AttackIdle.png"));
/*    */     
/* 25 */     init();
/*    */     
/* 27 */     this.Layers = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 32 */     super.show();
/*    */     
/* 34 */     Gdx.input.setInputProcessor((InputProcessor)this.control);
/*    */     
/* 36 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.CAVE) {
/* 37 */       this.player.setPosition(895.0F, 392.0F);
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
/*    */     
/* 50 */     if (!this.control.isDragonDead()) {
/* 51 */       this.batch.begin();
/* 52 */       this.batch.draw((TextureRegion)this.dragon, 740.0F, 753.0F, 90.0F, 90.0F);
/* 53 */       this.batch.end();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 59 */     super.screenChange();
/* 60 */     DarkCave.music.cavetheme.play();
/* 61 */     DarkCave.music.cavetheme.setLooping(true);
/* 62 */     if (this.player.doTransictionDoor().equals("CAVE")) {
/* 63 */       this.game.gsm.doTransition(GameScreenManager.STATE.CAVE);
/*    */     }
/*    */     
/* 66 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.COMBAT) {
/* 67 */       DarkCave.music.cavetheme.play();
/* 68 */       DarkCave.music.cavetheme.setLooping(true);
/*    */     } 
/*    */     
/* 71 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.FIRELEVEL);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 76 */     super.dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   public void resize(int width, int height) {
/* 81 */     super.resize(width, height);
/*    */   }
/*    */   
/*    */   public void pause() {}
/*    */   
/*    */   public void resume() {}
/*    */   
/*    */   public void hide() {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\level\FireLevelScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */