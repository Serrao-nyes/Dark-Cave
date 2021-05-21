/*    */ package dc.controller;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*    */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExploringCamera
/*    */ {
/* 13 */   private Vector2 position = new Vector2();
/*    */   private Sprite target;
/*    */   
/*    */   public void setTarget(Sprite target) {
/* 17 */     this.target = target;
/*    */   }
/*    */   
/*    */   public void update(float deltaTime) {
/* 21 */     this.position.x = this.target.getX() + this.target.getOriginX();
/* 22 */     this.position.y = this.target.getY() + this.target.getOriginY();
/*    */   }
/*    */   
/*    */   public void applyTo(OrthographicCamera camera) {
/* 26 */     camera.position.x = this.position.x;
/* 27 */     camera.position.y = this.position.y;
/* 28 */     camera.update();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\ExploringCamera.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */