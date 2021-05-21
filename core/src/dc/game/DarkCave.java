/*    */ package dc.game;
/*    */ 
/*    */ import com.badlogic.gdx.Game;
/*    */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.controller.manager.InventoryManagement;
/*    */ import dc.sound.AssetsMusic;
/*    */ import dc.sound.AssetsSound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DarkCave
/*    */   extends Game
/*    */ {
/*    */   public GameScreenManager gsm;
/*    */   public InventoryManagement im;
/*    */   public static AssetsSound sounds;
/*    */   public static AssetsMusic music;
/*    */   public ShapeRenderer shapeRenderer;
/*    */   
/*    */   public void create() {
/* 23 */     sounds = new AssetsSound();
/* 24 */     music = new AssetsMusic();
/* 25 */     this.im = new InventoryManagement(this);
/* 26 */     this.gsm = new GameScreenManager(this);
/* 27 */     this.shapeRenderer = new ShapeRenderer();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render() {
/* 32 */     super.render();
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 37 */     super.dispose();
/* 38 */     this.gsm.dispose();
/* 39 */     sounds.dispose();
/* 40 */     music.dispose();
/* 41 */     this.shapeRenderer.dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\game\DarkCave.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */