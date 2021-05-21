/*     */ package dc.controller.IA;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import dc.parameters.CombatEntityParameters;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnemiesIA
/*     */ {
/*  14 */   private static EnemiesIA instance = null;
/*     */   
/*     */   public static EnemiesIA getIstance() {
/*  17 */     if (instance == null) {
/*  18 */       instance = new EnemiesIA();
/*     */     }
/*  20 */     return instance; } public IA CreateIA(int ID) { IA dog; IA ia; IA ia1; IA ia2; IA ia3;
/*     */     IA ia4;
/*     */     IA ia5;
/*     */     IA ia6;
/*  24 */     switch (ID) {
/*     */       case 4:
/*  26 */         dog = new AttackIA();
/*  27 */         return dog;
/*     */       case 10:
/*  29 */         ia = new AttackIA();
/*  30 */         return ia;
/*     */       case 5:
/*  32 */         ia1 = new MixedIA();
/*  33 */         return ia1;
/*     */       case 6:
/*  35 */         ia2 = new MagicIA();
/*  36 */         return ia2;
/*     */       case 7:
/*  38 */         ia3 = new AttackIA();
/*  39 */         return ia3;
/*     */       case 8:
/*  41 */         ia4 = new MagicIA();
/*  42 */         return ia4;
/*     */       case 9:
/*  44 */         ia5 = new AttackIA();
/*  45 */         return ia5;
/*     */       case 11:
/*  47 */         ia6 = new MixedIA();
/*  48 */         return ia6;
/*     */     } 
/*  50 */     return null; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class AttackIA
/*     */     extends IA
/*     */   {
/*     */     public CombatEntityParameters.Choise SelectAction() {
/*  60 */       return CombatEntityParameters.Choise.ATTACK;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int SelectTarget(Array<CombatEntityParameters> Entities) {
/*  66 */       if (!((CombatEntityParameters)Entities.get(0)).isDead()) {
/*  67 */         return 0;
/*     */       }
/*  69 */       if (!((CombatEntityParameters)Entities.get(1)).isDead()) {
/*  70 */         return 1;
/*     */       }
/*  72 */       if (!((CombatEntityParameters)Entities.get(2)).isDead()) {
/*  73 */         return 2;
/*     */       }
/*     */       
/*  76 */       return 3;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class MagicIA
/*     */     extends IA
/*     */   {
/*     */     public CombatEntityParameters.Choise SelectAction() {
/*  88 */       return CombatEntityParameters.Choise.FLARE;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int SelectTarget(Array<CombatEntityParameters> Entities) {
/*  94 */       if (!((CombatEntityParameters)Entities.get(0)).isDead()) {
/*  95 */         return 0;
/*     */       }
/*  97 */       if (!((CombatEntityParameters)Entities.get(1)).isDead()) {
/*  98 */         return 1;
/*     */       }
/* 100 */       if (!((CombatEntityParameters)Entities.get(2)).isDead()) {
/* 101 */         return 2;
/*     */       }
/*     */       
/* 104 */       return 3;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class MixedIA
/*     */     extends IA
/*     */   {
/*     */     public CombatEntityParameters.Choise SelectAction() {
/* 117 */       Random rand = new Random();
/* 118 */       int Scelta = rand.nextInt(2) + 1;
/* 119 */       if (Scelta == 1) {
/* 120 */         return CombatEntityParameters.Choise.ATTACK;
/*     */       }
/* 122 */       if (Scelta == 2) {
/* 123 */         return CombatEntityParameters.Choise.FLARE;
/*     */       }
/* 125 */       return CombatEntityParameters.Choise.FLARE;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int SelectTarget(Array<CombatEntityParameters> Entities) {
/* 131 */       if (!((CombatEntityParameters)Entities.get(0)).isDead()) {
/* 132 */         return 0;
/*     */       }
/* 134 */       if (!((CombatEntityParameters)Entities.get(1)).isDead()) {
/* 135 */         return 1;
/*     */       }
/* 137 */       if (!((CombatEntityParameters)Entities.get(2)).isDead()) {
/* 138 */         return 2;
/*     */       }
/*     */       
/* 141 */       return 3;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\IA\EnemiesIA.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */