/*    */ package dc.combatlogic;
/*    */ 
/*    */ import dc.parameters.CombatEntityParameters;
/*    */ 
/*    */ 
/*    */ public class Action
/*    */ {
/*    */   private int Chooser;
/*    */   private int Target;
/*    */   private CombatEntityParameters.Choise Choise;
/*    */   
/*    */   public int getChooser() {
/* 13 */     return this.Chooser;
/*    */   }
/*    */   public void setChooser(Integer chooser) {
/* 16 */     this.Chooser = chooser.intValue();
/*    */   }
/*    */   public int getTarget() {
/* 19 */     return this.Target;
/*    */   }
/*    */   public void setTarget(Integer target) {
/* 22 */     this.Target = target.intValue();
/*    */   }
/*    */   public CombatEntityParameters.Choise getChoise() {
/* 25 */     return this.Choise;
/*    */   }
/*    */   public void setChoise(CombatEntityParameters.Choise choise) {
/* 28 */     this.Choise = choise;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\combatlogic\Action.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */