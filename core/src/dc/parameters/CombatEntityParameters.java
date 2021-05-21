/*    */ package dc.parameters;public class CombatEntityParameters extends AbsoluteEntityParameters {
/*    */   public Choise CurrentChoise;
/*    */   
/*    */   public enum Choise {
/*  5 */     ATTACK,
/*  6 */     DEFEND,
/*  7 */     WAITING,
/*  8 */     ABILITY,
/*  9 */     HASTE,
/* 10 */     FLARE,
/* 11 */     ENERGIA,
/* 12 */     RUN;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CombatEntityParameters(AbsoluteEntityParameters A) {
/* 48 */     this.CurrentChoise = Choise.WAITING;
/*    */     setHP(A.getHP());
/*    */     setMP(A.getMP());
/*    */     setCurrentHP(A.getCurrentHP());
/*    */     setCurrentMP(A.getCurrentMP());
/*    */     setPotFisica(A.getPotFisica());
/*    */     setPotMagica(A.getPotMagica());
/*    */     setDifFisica(A.getDifFisica());
/*    */     setSpeed(A.getSpeed());
/*    */     setName(A.getName());
/*    */     setID(A.getID());
/*    */   }
/*    */   
/*    */   public void increasSpeed(int value) {
/*    */     setSpeed(getSpeed() + value);
/*    */   }
/*    */   
/*    */   public void increasPotFisica(int value) {
/*    */     setPotFisica(getPotFisica() + value);
/*    */   }
/*    */   
/*    */   public void increasPotMagica(int value) {
/*    */     setPotMagica(getPotMagica() + value);
/*    */   }
/*    */   
/*    */   public boolean isDead() {
/*    */     return (getCurrentHP() == 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\parameters\CombatEntityParameters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */