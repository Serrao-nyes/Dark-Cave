/*    */ package dc.controller.box;
/*    */ 
/*    */ import com.badlogic.gdx.InputAdapter;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.settings.Constans;
/*    */ import dc.view.box.OptionBox;
/*    */ 
/*    */ 
/*    */ public class SettingsController
/*    */   extends InputAdapter
/*    */ {
/*    */   private OptionBox box;
/*    */   private DarkCave game;
/*    */   
/*    */   public SettingsController(OptionBox box, DarkCave game) {
/* 17 */     this.box = box;
/* 18 */     this.game = game;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean keyDown(int keycode) {
/* 23 */     if (keycode == 21) {
/* 24 */       this.box.moveUp();
/* 25 */     } else if (keycode == 22) {
/* 26 */       this.box.moveDown();
/* 27 */     } else if (keycode == 31) {
/* 28 */       this.game.gsm.doTransition(GameScreenManager.STATE.MAIN_MENU);
/* 29 */     } else if (keycode == 52) {
/* 30 */       if (this.box.getSelected() == 0) {
/*    */         
/* 32 */         Constans.MUSICVOLUME = 0.0F;
/* 33 */         DarkCave.music.updateVolume();
/*    */       }
/* 35 */       else if (this.box.getSelected() == 1) {
/*    */         
/* 37 */         Constans.MUSICVOLUME = 0.1F;
/* 38 */         DarkCave.music.updateVolume();
/*    */       }
/* 40 */       else if (this.box.getSelected() == 2) {
/*    */         
/* 42 */         Constans.MUSICVOLUME = 0.2F;
/* 43 */         DarkCave.music.updateVolume();
/*    */       }
/* 45 */       else if (this.box.getSelected() == 3) {
/*    */         
/* 47 */         Constans.MUSICVOLUME = 0.3F;
/* 48 */         DarkCave.music.updateVolume();
/*    */       }
/* 50 */       else if (this.box.getSelected() == 4) {
/*    */         
/* 52 */         Constans.MUSICVOLUME = 0.4F;
/* 53 */         DarkCave.music.updateVolume();
/*    */       }
/* 55 */       else if (this.box.getSelected() == 5) {
/*    */         
/* 57 */         Constans.MUSICVOLUME = 0.5F;
/* 58 */         DarkCave.music.updateVolume();
/*    */       }
/* 60 */       else if (this.box.getSelected() == 6) {
/*    */         
/* 62 */         Constans.MUSICVOLUME = 0.6F;
/* 63 */         DarkCave.music.updateVolume();
/*    */       }
/* 65 */       else if (this.box.getSelected() == 7) {
/*    */         
/* 67 */         Constans.MUSICVOLUME = 0.7F;
/* 68 */         DarkCave.music.updateVolume();
/*    */       }
/* 70 */       else if (this.box.getSelected() == 8) {
/*    */         
/* 72 */         Constans.MUSICVOLUME = 0.8F;
/* 73 */         DarkCave.music.updateVolume();
/*    */       }
/* 75 */       else if (this.box.getSelected() == 9) {
/*    */         
/* 77 */         Constans.MUSICVOLUME = 0.9F;
/* 78 */         DarkCave.music.updateVolume();
/*    */       }
/* 80 */       else if (this.box.getSelected() == 10) {
/*    */         
/* 82 */         Constans.MUSICVOLUME = 1.0F;
/* 83 */         DarkCave.music.updateVolume();
/*    */       } 
/*    */     } 
/* 86 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\box\SettingsController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */