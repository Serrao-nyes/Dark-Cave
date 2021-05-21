/*    */ package dc.controller.box;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.InputAdapter;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.view.box.PauseBox;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PauseBoxController
/*    */   extends InputAdapter
/*    */ {
/*    */   private PauseBox box;
/*    */   private DarkCave game;
/*    */   
/*    */   public PauseBoxController(PauseBox box, DarkCave game) {
/* 19 */     this.box = box;
/* 20 */     this.game = game;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean keyDown(int keycode) {
/* 25 */     if (keycode == 21 && this.box.isVisible()) {
/* 26 */       this.box.moveUp();
/* 27 */     } else if (keycode == 22 && this.box.isVisible()) {
/* 28 */       this.box.moveDown();
/* 29 */     } else if (keycode == 52 && this.box.isVisible()) {
/* 30 */       if (this.box.getSelected() == 0) {
/* 31 */         Gdx.input.setInputProcessor(null);
/* 32 */         this.box.setVisible(false);
/* 33 */         (this.game.gsm.getPrevScreen()).paused = false;
/*    */       }
/* 35 */       else if (this.box.getSelected() == 1) {
/* 36 */         this.box.setVisible(false);
/* 37 */         this.game.gsm.doTransition(GameScreenManager.STATE.MAIN_MENU);
/* 38 */         DarkCave.music.cavetheme.stop();
/* 39 */         DarkCave.music.hubtheme.stop();
/*    */       } 
/*    */     } 
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\box\PauseBoxController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */