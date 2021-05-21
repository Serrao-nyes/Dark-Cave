/*    */ package dc.controller.box;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.InputAdapter;
/*    */ import com.badlogic.gdx.InputProcessor;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*    */ import dc.controller.manager.InventoryManagement;
/*    */ import dc.game.DarkCave;
/*    */ import dc.view.box.InventoryTab;
/*    */ import dc.view.box.OptionBox;
/*    */ 
/*    */ public class InventoryBoxController
/*    */   extends InputAdapter
/*    */ {
/*    */   private InventoryTab box;
/*    */   private OptionBox option;
/*    */   private OptionBoxController ocotnroller;
/*    */   private DarkCave game;
/* 20 */   private InventoryManagement.ITM item = null;
/*    */   
/*    */   public InventoryBoxController(InventoryTab box, DarkCave game, Skin skin) {
/* 23 */     this.box = box;
/* 24 */     this.game = game;
/* 25 */     this.option = new OptionBox(skin);
/* 26 */     this.ocotnroller = new OptionBoxController(this.option, this, box, game);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean keyDown(int keycode) {
/* 31 */     if (keycode == 19 && this.box.isVisible()) {
/* 32 */       this.box.moveUp();
/* 33 */     } else if (keycode == 20 && this.box.isVisible()) {
/* 34 */       this.box.moveDown();
/* 35 */     } else if (keycode == 52 && this.box.isVisible()) {
/*    */       
/* 37 */       if (this.box.getSelected() == 0) {
/* 38 */         if (this.game.im.getCount(InventoryManagement.ITM.POZIONE) > 0) {
/* 39 */           this.item = InventoryManagement.ITM.POZIONE;
/* 40 */           Gdx.input.setInputProcessor((InputProcessor)this.ocotnroller);
/* 41 */           usage();
/*    */         }
/*    */       
/* 44 */       } else if (this.box.getSelected() == 1) {
/* 45 */         if (this.game.im.getCount(InventoryManagement.ITM.ETERE) > 0) {
/* 46 */           this.item = InventoryManagement.ITM.ETERE;
/* 47 */           Gdx.input.setInputProcessor((InputProcessor)this.ocotnroller);
/* 48 */           usage();
/*    */         }
/*    */       
/* 51 */       } else if (this.box.getSelected() == 2) {
/* 52 */         if (this.game.im.getCount(InventoryManagement.ITM.CODADIFENICE) > 0) {
/* 53 */           this.item = InventoryManagement.ITM.CODADIFENICE;
/* 54 */           Gdx.input.setInputProcessor((InputProcessor)this.ocotnroller);
/* 55 */           usage();
/*    */         }
/*    */       
/* 58 */       } else if (this.box.getSelected() == 3) {
/* 59 */         this.box.setVisible(false);
/* 60 */         this.box.clear();
/* 61 */         (this.game.gsm.getPrevScreen()).inv = false;
/*    */       }
/*    */     
/* 64 */     } else if (keycode == 31 && this.box.isVisible()) {
/* 65 */       this.box.setVisible(false);
/* 66 */       this.box.clear();
/* 67 */       (this.game.gsm.getPrevScreen()).inv = false;
/*    */     } 
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public void usage() {
/* 73 */     this.option.addOption("Flik");
/* 74 */     this.option.row();
/* 75 */     this.option.addOption("Pesmerga");
/* 76 */     this.option.row();
/* 77 */     this.option.addOption("Ted");
/* 78 */     this.option.row();
/* 79 */     this.option.addOption("Lotte");
/* 80 */     this.option.setSize(150.0F, 150.0F);
/* 81 */     this.option.setPosition(300.0F, 300.0F);
/* 82 */     this.option.setVisible(true);
/* 83 */     (this.game.gsm.getPrevScreen()).stage.addActor((Actor)this.option);
/*    */   }
/*    */   
/*    */   public InventoryManagement.ITM getSelectedItem() {
/* 87 */     return this.item;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\box\InventoryBoxController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */