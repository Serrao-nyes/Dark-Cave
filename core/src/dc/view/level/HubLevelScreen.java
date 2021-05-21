/*    */ package dc.view.level;
/*    */ 
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.model.Player;
/*    */ import dc.view.AbstractLevelScreen;
/*    */ 
/*    */ public class HubLevelScreen
/*    */   extends AbstractLevelScreen
/*    */ {
/*    */   public HubLevelScreen(DarkCave game) {
/* 12 */     super(game);
/* 13 */     this.map = this.maploader.load("maps/hub/hub.tmx");
/*    */     
/* 15 */     this.player = new Player(this.map, game);
/* 16 */     this.player.setSpawn(585.0F, 260.0F);
/*    */     
/* 18 */     init();
/*    */     
/* 20 */     this.Layers = new int[] { 0, 1, 2, 3, 4, 5, 6 };
/* 21 */     this.MasterLayers = new int[] { 7 };
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 26 */     super.show();
/*    */     
/* 28 */     if (this.game.gsm.getPrevState() == GameScreenManager.STATE.CAVE) {
/* 29 */       this.player.setPosition(580.0F, 680.0F);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(float delta) {
/* 36 */     super.update(delta);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 41 */     super.render(delta);
/*    */   }
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 46 */     super.screenChange();
/*    */     
/* 48 */     DarkCave.music.hubtheme.play();
/* 49 */     DarkCave.music.hubtheme.setLooping(true);
/*    */     
/* 51 */     if (this.player.doTransictionDoor().equals("CAVE")) {
/* 52 */       this.game.gsm.doTransition(GameScreenManager.STATE.CAVE);
/* 53 */       DarkCave.music.hubtheme.stop();
/*    */     } 
/*    */     
/* 56 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.HUB);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 61 */     super.dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   public void resize(int width, int height) {
/* 66 */     super.resize(width, height);
/*    */   }
/*    */   
/*    */   public void pause() {}
/*    */   
/*    */   public void resume() {}
/*    */   
/*    */   public void hide() {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\level\HubLevelScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */