/*     */ package dc.combatlogic;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import dc.controller.CombatTablesController;
/*     */ import dc.parameters.CombatEntityParameters;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Chooser
/*     */ {
/*     */   public static void delay() {
/*  13 */     Timer.schedule(new Timer.Task()
/*     */         {
/*     */           
/*     */           public void run() {}
/*  17 */         },  5.0F);
/*     */   }
/*     */   
/*     */   public static void heavyDelay() {
/*  21 */     Timer.schedule(new Timer.Task()
/*     */         {
/*     */           
/*     */           public void run() {}
/*  25 */         },  50.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean Choose(int i, Integer target, Integer magic, Integer choise, Array<CombatEntityParameters> Entities, Array<Action> Actions, CombatTablesController controller) {
/*  31 */     if (!((CombatEntityParameters)Entities.get(i)).isDead()) {
/*     */       Action action, action2;
/*  33 */       heavyDelay();
/*  34 */       controller.reset();
/*  35 */       controller.who(i);
/*  36 */       controller.genPara(Entities);
/*  37 */       controller.genChoise();
/*  38 */       while (choise == null) {
/*  39 */         choise = controller.getChoise();
/*  40 */         delay();
/*     */       } 
/*  42 */       switch (choise.intValue()) {
/*     */         case 1:
/*  44 */           ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.ATTACK;
/*  45 */           action = new Action();
/*  46 */           action.setChooser(Integer.valueOf(i));
/*  47 */           action.setChoise(((CombatEntityParameters)Entities.get(i)).CurrentChoise);
/*  48 */           controller.genTarget(Entities);
/*  49 */           while (target == null) {
/*  50 */             target = controller.getTarget();
/*  51 */             delay();
/*     */           } 
/*  53 */           if (target.intValue() == 9) {
/*  54 */             return Choose(i, null, null, null, Entities, Actions, controller);
/*     */           }
/*  56 */           action.setTarget(target);
/*     */           
/*  58 */           Actions.add(action);
/*     */           
/*  60 */           controller.reset();
/*  61 */           return true;
/*     */         
/*     */         case 2:
/*  64 */           ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.DEFEND;
/*     */           
/*  66 */           controller.reset();
/*  67 */           return true;
/*     */         
/*     */         case 3:
/*  70 */           if (((CombatEntityParameters)Entities.get(i)).getID() == 2) {
/*  71 */             ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.ABILITY;
/*  72 */             Action action1 = new Action();
/*  73 */             action1.setChooser(Integer.valueOf(i));
/*  74 */             action1.setChoise(((CombatEntityParameters)Entities.get(i)).CurrentChoise);
/*  75 */             controller.genTarget(Entities);
/*  76 */             while (target == null) {
/*  77 */               target = controller.getTarget();
/*  78 */               delay();
/*     */             } 
/*     */             
/*  81 */             if (target.intValue() == 9)
/*     */             {
/*  83 */               return Choose(i, null, null, null, Entities, Actions, controller);
/*     */             }
/*  85 */             action1.setTarget(target);
/*     */             
/*  87 */             Actions.add(action1);
/*     */             break;
/*     */           } 
/*  90 */           ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.ABILITY;
/*  91 */           action2 = new Action();
/*  92 */           action2.setChooser(Integer.valueOf(i));
/*  93 */           action2.setChoise(((CombatEntityParameters)Entities.get(i)).CurrentChoise);
/*  94 */           controller.genTarget(Entities);
/*  95 */           while (target == null) {
/*  96 */             target = controller.getTarget();
/*  97 */             delay();
/*     */           } 
/*     */           
/* 100 */           if (target.intValue() == 9)
/*     */           {
/* 102 */             return Choose(i, null, null, null, Entities, Actions, controller);
/*     */           }
/* 104 */           action2.setTarget(target);
/*     */           
/* 106 */           Actions.add(action2);
/*     */           
/* 108 */           controller.reset();
/* 109 */           return true;
/*     */ 
/*     */ 
/*     */         
/*     */         case 4:
/* 114 */           if (((CombatEntityParameters)Entities.get(i)).getID() == 0) {
/* 115 */             Action action4 = new Action();
/* 116 */             action4.setChooser(Integer.valueOf(i));
/*     */             
/* 118 */             controller.genMagic();
/* 119 */             while (magic == null) {
/* 120 */               magic = controller.getMagic();
/* 121 */               delay();
/*     */             } 
/*     */             
/* 124 */             if (magic.intValue() == 9)
/*     */             {
/* 126 */               return Choose(i, null, null, null, Entities, Actions, controller);
/*     */             }
/* 128 */             if (magic.intValue() == 1) {
/* 129 */               ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.HASTE;
/*     */             }
/* 131 */             action4.setChoise(((CombatEntityParameters)Entities.get(i)).CurrentChoise);
/*     */             
/* 133 */             controller.genTarget(Entities);
/* 134 */             while (target == null) {
/* 135 */               target = controller.getTarget();
/* 136 */               delay();
/*     */             } 
/*     */             
/* 139 */             if (target.intValue() == 9)
/*     */             {
/* 141 */               return Choose(i, null, null, null, Entities, Actions, controller);
/*     */             }
/* 143 */             action4.setTarget(target);
/* 144 */             Actions.add(action4);
/*     */             
/* 146 */             controller.reset(); break;
/*     */           } 
/* 148 */           if (((CombatEntityParameters)Entities.get(i)).getID() == 1)
/*     */           {
/* 150 */             return Choose(i, null, null, null, Entities, Actions, controller); } 
/* 151 */           if (((CombatEntityParameters)Entities.get(i)).getID() == 2)
/*     */           {
/* 153 */             return Choose(i, null, null, null, Entities, Actions, controller); } 
/* 154 */           if (((CombatEntityParameters)Entities.get(i)).getID() == 3) {
/* 155 */             Action action4 = new Action();
/* 156 */             action4.setChooser(Integer.valueOf(i));
/*     */             
/* 158 */             controller.genMagic();
/* 159 */             while (magic == null) {
/* 160 */               magic = controller.getMagic();
/* 161 */               delay();
/*     */             } 
/*     */             
/* 164 */             if (magic.intValue() == 9)
/*     */             {
/* 166 */               return Choose(i, null, null, null, Entities, Actions, controller);
/*     */             }
/* 168 */             if (magic.intValue() == 1) {
/* 169 */               ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.FLARE;
/*     */             }
/* 171 */             if (magic.intValue() == 2) {
/* 172 */               ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.ENERGIA;
/*     */             }
/* 174 */             action4.setChoise(((CombatEntityParameters)Entities.get(i)).CurrentChoise);
/*     */             
/* 176 */             controller.genTarget(Entities);
/* 177 */             while (target == null) {
/* 178 */               target = controller.getTarget();
/* 179 */               delay();
/*     */             } 
/*     */             
/* 182 */             if (target.intValue() == 9)
/*     */             {
/* 184 */               return Choose(i, null, null, null, Entities, Actions, controller);
/*     */             }
/* 186 */             action4.setTarget(target);
/* 187 */             Actions.add(action4);
/*     */             
/* 189 */             controller.reset();
/*     */           } 
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 5:
/* 197 */           ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.RUN;
/*     */           
/* 199 */           controller.reset();
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 205 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\combatlogic\Chooser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */