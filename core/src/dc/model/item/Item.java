/*    */ package dc.model.item;
/*    */ 
/*    */ import dc.game.DarkCave;
/*    */ 
/*    */ public abstract class Item
/*    */ {
/*    */   protected DarkCave game;
/*    */   protected String name;
/*  9 */   protected int count = 0;
/*    */   
/*    */   public Item(DarkCave game) {
/* 12 */     this.game = game;
/*    */   }
/*    */   
/*    */   public abstract void functionality(String paramString);
/*    */   
/*    */   public int getCount() {
/* 18 */     return this.count;
/*    */   }
/*    */   
/*    */   public void addCount(int add) {
/* 22 */     this.count += add;
/*    */   }
/*    */   
/*    */   public void setCount(int count) {
/* 26 */     this.count = count;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 30 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\model\item\Item.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */