/*    */ package dc.view.level;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.InputProcessor;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.model.Player;
/*    */ import dc.view.AbstractLevelScreen;
/*    */ 
/*    */ public class CaveLevelScreen
/*    */   extends AbstractLevelScreen
/*    */ {
/*    */   public CaveLevelScreen(DarkCave game) {
/* 14 */     super(game);
/* 15 */     this.map = this.maploader.load("maps/cave/cave.tmx");
/* 16 */     this.player = new Player(this.map, game);
/*    */     
/* 18 */     init();
/*    */     
/* 20 */     this.Layers = new int[] { 0, 1, 2, 3, 4 };
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 25 */     super.show();
/*    */     
/* 27 */     Gdx.input.setInputProcessor((InputProcessor)this.control);
/*    */     
/* 29 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.HUB) {
/* 30 */       this.player.setPosition(578.0F, 360.0F);
/*    */     }
/* 32 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.FIRELEVEL) {
/* 33 */       this.player.setPosition(220.0F, 736.0F);
/*    */     }
/*    */     
/* 36 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.WATERLEVEL) {
/* 37 */       this.player.setPosition(895.0F, 690.0F);
/*    */     }
/*    */     
/* 40 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.FINALE) {
/* 41 */       this.player.setPosition(585.0F, 930.0F);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(float delta) {
/* 47 */     super.update(delta);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 52 */     super.render(delta);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 60 */     super.screenChange();
/*    */     
/* 62 */     DarkCave.music.cavetheme.play();
/* 63 */     DarkCave.music.cavetheme.setLooping(true);
/*    */     
/* 65 */     if (this.player.doTransictionDoor().equals("HUB")) {
/* 66 */       this.game.gsm.doTransition(GameScreenManager.STATE.HUB);
/* 67 */       DarkCave.music.cavetheme.stop();
/*    */     } 
/*    */     
/* 70 */     if (this.player.doTransictionDoor().equals("FIRELEVEL")) {
/* 71 */       this.game.gsm.doTransition(GameScreenManager.STATE.FIRELEVEL);
/*    */     }
/*    */     
/* 74 */     if (this.player.doTransictionDoor().equals("WATERLEVEL")) {
/* 75 */       this.game.gsm.doTransition(GameScreenManager.STATE.WATERLEVEL);
/*    */     }
/*    */     
/* 78 */     if (this.player.doTransictionDoor().equals("FINALE")) {
/* 79 */       this.game.gsm.doTransition(GameScreenManager.STATE.FINALE);
/*    */     }
/*    */     
/* 82 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.COMBAT) {
/* 83 */       DarkCave.music.cavetheme.play();
/* 84 */       DarkCave.music.cavetheme.setLooping(true);
/*    */     } 
/* 86 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.CAVE);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 91 */     super.dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   public void resize(int width, int height) {
/* 96 */     super.resize(width, height);
/*    */   }
/*    */   
/*    */   public void pause() {}
/*    */   
/*    */   public void resume() {}
/*    */   
/*    */   public void hide() {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\level\CaveLevelScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */