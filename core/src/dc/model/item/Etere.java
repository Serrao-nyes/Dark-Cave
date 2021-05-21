/*    */ package dc.model.item;
/*    */ 
/*    */ import dc.game.DarkCave;
/*    */ import dc.parameters.AlliesParameters;
/*    */ 
/*    */ public class Etere
/*    */   extends Item {
/*    */   public Etere(DarkCave game) {
/*  9 */     super(game);
/* 10 */     this.name = "Etere";
/*    */   }
/*    */ 
/*    */   
/*    */   public void functionality(String name) {
/* 15 */     if (name == "Flik" && 
/* 16 */       AlliesParameters.getWarrior().getCurrentMP() < AlliesParameters.getWarrior().getMP() && !AlliesParameters.getWarrior().isDead()) {
/* 17 */       AlliesParameters.getWarrior().IncreasCurrentMP(50);
/* 18 */       setCount(getCount() - 1);
/*    */     } 
/*    */     
/* 21 */     if (name == "Pesmerga" && 
/* 22 */       AlliesParameters.getKnight().getCurrentMP() < AlliesParameters.getKnight().getMP() && !AlliesParameters.getKnight().isDead()) {
/* 23 */       AlliesParameters.getKnight().IncreasCurrentMP(50);
/* 24 */       setCount(getCount() - 1);
/*    */     } 
/*    */     
/* 27 */     if (name == "Ted" && 
/* 28 */       AlliesParameters.getArcher().getCurrentMP() < AlliesParameters.getArcher().getMP() && !AlliesParameters.getArcher().isDead()) {
/* 29 */       AlliesParameters.getArcher().IncreasCurrentMP(50);
/* 30 */       setCount(getCount() - 1);
/*    */     } 
/*    */     
/* 33 */     if (name == "Lotte" && 
/* 34 */       AlliesParameters.getMage().getCurrentMP() < AlliesParameters.getMage().getMP() && !AlliesParameters.getMage().isDead()) {
/* 35 */       AlliesParameters.getMage().IncreasCurrentMP(50);
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


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\model\item\Etere.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */