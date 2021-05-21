/*    */ package dc.model;
/*    */ import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ 
/*    */ public class Entity extends Sprite {
/*    */   public int ID;
/*    */   public STATE current;
/*    */   public STATE previous;
/*    */   
/*    */   public enum STATE {
/* 10 */     IDLE,
/* 11 */     ATTACKING,
/* 12 */     DYING,
/* 13 */     HURTING,
/* 14 */     INTERACTION;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TextureRegion getFrame(float deltaTime) {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */   public void update(float deltaTime) {}
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\model\Entity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */