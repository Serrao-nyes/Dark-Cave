/*    */ package dc.model.item;
/*    */ 
/*    */ import dc.game.DarkCave;
/*    */ import dc.parameters.AlliesParameters;
/*    */ 
/*    */ public class Pozione
/*    */   extends Item {
/*    */   public Pozione(DarkCave game) {
/*  9 */     super(game);
/* 10 */     this.name = "Pozione";
/*    */   }
/*    */ 
/*    */   
/*    */   public void functionality(String name) {
/* 15 */     if (name == "Flik" && 
/* 16 */       AlliesParameters.getWarrior().getCurrentHP() < AlliesParameters.getWarrior().getHP() && !AlliesParameters.getWarrior().isDead()) {
/* 17 */       AlliesParameters.getWarrior().IncreasCurrentHP(1000);
/* 18 */       setCount(getCount() - 1);
/*    */     } 
/*    */     
/* 21 */     if (name == "Pesmerga" && 
/* 22 */       AlliesParameters.getKnight().getCurrentHP() < AlliesParameters.getKnight().getHP() && !AlliesParameters.getKnight().isDead()) {
/* 23 */       AlliesParameters.getKnight().IncreasCurrentHP(1000);
/* 24 */       setCount(getCount() - 1);
/*    */     } 
/*    */     
/* 27 */     if (name == "Ted" && 
/* 28 */       AlliesParameters.getArcher().getCurrentHP() < AlliesParameters.getArcher().getHP() && !AlliesParameters.getArcher().isDead()) {
/* 29 */       AlliesParameters.getArcher().IncreasCurrentHP(1000);
/* 30 */       setCount(getCount() - 1);
/*    */     } 
/*    */     
/* 33 */     if (name == "Lotte" && 
/* 34 */       AlliesParameters.getMage().getCurrentHP() < AlliesParameters.getMage().getHP() && !AlliesParameters.getMage().isDead()) {
/* 35 */       AlliesParameters.getMage().IncreasCurrentHP(1000);
/* 36 */       setCount(getCount() - 1);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getCount() {
/* 43 */     return super.getCount();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCount(int count) {
/* 48 */     super.setCount(count);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 53 */     return super.getName();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\model\item\Pozione.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */