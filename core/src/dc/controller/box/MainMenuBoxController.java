/*    */ package dc.controller.box;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.InputAdapter;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.view.box.MainMenuTab;
/*    */ 
/*    */ 
/*    */ public class MainMenuBoxController
/*    */   extends InputAdapter
/*    */ {
/*    */   private MainMenuTab box;
/*    */   private DarkCave game;
/*    */   
/*    */   public MainMenuBoxController(MainMenuTab box, DarkCave game) {
/* 17 */     this.box = box;
/* 18 */     this.game = game;
/*    */   }
/*    */   
/*    */   public void keyDown() {
/* 22 */     if (Gdx.input.isKeyJustPressed(19)) {
/* 23 */       this.box.moveUp();
/* 24 */     } else if (Gdx.input.isKeyJustPressed(20)) {
/* 25 */       this.box.moveDown();
/* 26 */     } else if (Gdx.input.isKeyJustPressed(52)) {
/* 27 */       if (this.box.getSelected() == 0) {
/*    */         
/* 29 */         this.game.gsm.doTransition(GameScreenManager.STATE.HUB);
/* 30 */         DarkCave.music.maintheme.stop();
/*    */       }
/* 32 */       else if (this.box.getSelected() == 1) {
/*    */         
/* 34 */         this.game.gsm.doTransition(GameScreenManager.STATE.ABOUT);
/*    */       }
/* 36 */       else if (this.box.getSelected() == 2) {
/*    */         
/* 38 */         this.game.gsm.doTransition(GameScreenManager.STATE.SETTINGS);
/*    */       }
/* 40 */       else if (this.box.getSelected() == 3) {
/*    */         
/* 42 */         DarkCave.music.maintheme.stop();
/* 43 */         Gdx.app.exit();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\box\MainMenuBoxController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */