/*    */ package dc.controller.box;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.InputAdapter;
/*    */ import com.badlogic.gdx.InputProcessor;
/*    */ import dc.game.DarkCave;
/*    */ import dc.view.box.InventoryTab;
/*    */ import dc.view.box.OptionBox;
/*    */ 
/*    */ public class OptionBoxController
/*    */   extends InputAdapter
/*    */ {
/*    */   private OptionBox box;
/*    */   private InventoryTab inv;
/*    */   private InventoryBoxController invcontroller;
/*    */   private DarkCave game;
/*    */   
/*    */   public OptionBoxController(OptionBox box, InventoryBoxController invcontroller, InventoryTab inv, DarkCave game) {
/* 19 */     this.box = box;
/* 20 */     this.inv = inv;
/* 21 */     this.invcontroller = invcontroller;
/* 22 */     this.game = game;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean keyDown(int keycode) {
/* 27 */     if (keycode == 19 && this.box.isVisible()) {
/* 28 */       this.box.moveUp();
/* 29 */     } else if (keycode == 20 && this.box.isVisible()) {
/* 30 */       this.box.moveDown();
/* 31 */     } else if (keycode == 52 && this.box.isVisible()) {
/* 32 */       if (this.box.getSelected() == 0) {
/* 33 */         this.game.im.getFunction(this.invcontroller.getSelectedItem(), "Flik");
/* 34 */         this.box.clear();
/* 35 */         this.inv.clear();
/* 36 */         this.inv.update(this.game);
/* 37 */         Gdx.input.setInputProcessor((InputProcessor)this.invcontroller);
/* 38 */       } else if (this.box.getSelected() == 1) {
/* 39 */         this.game.im.getFunction(this.invcontroller.getSelectedItem(), "Pesmerga");
/* 40 */         this.box.clear();
/* 41 */         this.inv.clear();
/* 42 */         this.inv.update(this.game);
/* 43 */         Gdx.input.setInputProcessor((InputProcessor)this.invcontroller);
/* 44 */       } else if (this.box.getSelected() == 2) {
/* 45 */         this.game.im.getFunction(this.invcontroller.getSelectedItem(), "Ted");
/* 46 */         this.box.clear();
/* 47 */         this.inv.clear();
/* 48 */         this.inv.update(this.game);
/* 49 */         Gdx.input.setInputProcessor((InputProcessor)this.invcontroller);
/* 50 */       } else if (this.box.getSelected() == 3) {
/* 51 */         this.game.im.getFunction(this.invcontroller.getSelectedItem(), "Lotte");
/* 52 */         this.box.clear();
/* 53 */         this.inv.clear();
/* 54 */         this.inv.update(this.game);
/* 55 */         Gdx.input.setInputProcessor((InputProcessor)this.invcontroller);
/*    */       }
/*    */     
/* 58 */     } else if (keycode == 31 && this.box.isVisible()) {
/*    */       
/* 60 */       this.box.clear();
/* 61 */       this.inv.clear();
/* 62 */       this.inv.update(this.game);
/* 63 */       Gdx.input.setInputProcessor((InputProcessor)this.invcontroller);
/*    */     } 
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\box\OptionBoxController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */