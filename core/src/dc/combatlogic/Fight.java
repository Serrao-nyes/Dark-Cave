/*     */ package dc.combatlogic;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import dc.controller.IA.EnemiesIA;
/*     */ import dc.controller.IA.IA;
/*     */ import dc.controller.PlayerController;
/*     */ import dc.game.DarkCave;
/*     */ import dc.model.Entity;
/*     */ import dc.parameters.CombatEntityParameters;
/*     */ import dc.view.CombatScreen;
/*     */ 
/*     */ public class Fight
/*     */   implements Runnable
/*     */ {
/*     */   public static Array<CombatEntityParameters> Entities;
/*     */   public static Array<Action> Actions;
/*     */   public static Array<IA> ias;
/*     */   public static EnemiesIA brain;
/*  19 */   private static Fight instance = null;
/*     */   public static int AlliesHP;
/*     */   public static int EnemiesHP;
/*     */   Integer choise;
/*     */   Integer target;
/*     */   Integer magic;
/*     */   public static boolean FightIsOver;
/*     */   
/*     */   public static Fight getInstance() {
/*  28 */     if (instance == null) {
/*  29 */       instance = new Fight();
/*     */     }
/*  31 */     return instance;
/*     */   }
/*     */   
/*     */   public static boolean FightIsOver() {
/*  35 */     if (EnemiesHP <= 0 || AlliesHP <= 0) {
/*  36 */       return true;
/*     */     }
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean GameOver() {
/*  43 */     if (AlliesHP <= 0)
/*     */     {
/*  45 */       return true;
/*     */     }
/*  47 */     return false;
/*     */   }
/*     */   
/*     */   private void SortSpeed(Array<Action> A, Array<CombatEntityParameters> Entities) {
/*  51 */     for (int j = 0; j < A.size - 1; j++) {
/*  52 */       for (int i = 0; i < A.size - 1; i++) {
/*  53 */         if (((CombatEntityParameters)Entities.get(((Action)A.get(i)).getChooser())).getSpeed() < ((CombatEntityParameters)Entities.get(((Action)A.get(i + 1)).getChooser()))
/*  54 */           .getSpeed()) {
/*  55 */           A.swap(i, i + 1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  63 */     synchronized (this) {
/*  64 */       while (!FightIsOver()) {
/*     */         
/*  66 */         if (FightIsOver) {
/*     */           break;
/*     */         }
/*     */         int i;
/*  70 */         for (i = 0; i < 4; i++) {
/*     */           
/*  72 */           Chooser.Choose(i, this.target, this.magic, this.choise, Entities, Actions, CombatScreen.comcontroller);
/*  73 */           if (((CombatEntityParameters)Entities.get(i)).CurrentChoise == CombatEntityParameters.Choise.RUN) {
/*     */             
/*  75 */             if (Calculator.Fuga() > 3 && !PlayerController.isCircoInteracted && 
/*  76 */               !PlayerController.isDragonInteracted && !PlayerController.isRuxollInteracted) {
/*  77 */               FightIsOver = true;
/*  78 */               CombatScreen.comcontroller.endText("Fuga Riuscita");
/*     */               
/*     */               return;
/*     */             } 
/*  82 */             CombatScreen.comcontroller.setMessage("Fuga non riuscita");
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  90 */         for (i = 4; i < CombatScreen.Nenemies + 4; i++) {
/*  91 */           if (!((CombatEntityParameters)Entities.get(i)).isDead()) {
/*  92 */             Action action2 = new Action();
/*  93 */             action2.setChooser(Integer.valueOf(i));
/*  94 */             action2.setChoise(((IA)ias.get(i - 4)).SelectAction());
/*  95 */             ((CombatEntityParameters)Entities.get(i)).CurrentChoise = ((IA)ias.get(i - 4)).SelectAction();
/*  96 */             action2.setTarget(Integer.valueOf(((IA)ias.get(i - 4)).SelectTarget(Entities)));
/*  97 */             Actions.add(action2);
/*     */           } 
/*     */         } 
/* 100 */         SortSpeed(Actions, Entities);
/* 101 */         for (i = 0; i < Actions.size; i++) {
/* 102 */           if (!((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).isDead()) {
/* 103 */             int IpoteticDamage; switch (((Action)Actions.get(i)).getChoise()) {
/*     */               case ATTACK:
/* 105 */                 ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.ATTACKING;
/* 106 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() < 2) {
/* 107 */                   DarkCave.sounds.swordeffect.play();
/*     */                 }
/* 109 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 2) {
/* 110 */                   DarkCave.sounds.arroweffect.play();
/*     */                 }
/* 112 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 3) {
/* 113 */                   DarkCave.sounds.staffeffect.play();
/*     */                 }
/* 115 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 11) {
/* 116 */                   DarkCave.sounds.boeffect.play();
/*     */                 }
/* 118 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() > 3) {
/* 119 */                   DarkCave.sounds.hiteffect.play();
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 128 */                 if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && !FightIsOver() && (
/* 129 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead())
/*     */                 {
/* 131 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 133 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                   }
/*     */                 }
/*     */                 
/* 137 */                 if (((Action)Actions.get(i)).getTarget() != Entities.size - 1 && !FightIsOver() && (
/* 138 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead()) {
/*     */                   
/* 140 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 141 */                     (Action)Actions.get(i)).getTarget() < Entities.size - 1 && !FightIsOver())
/*     */                   {
/* 143 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() + 1));
/*     */                   }
/* 145 */                   if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && (
/* 146 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 148 */                     while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                     {
/* 150 */                       ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                     }
/*     */                   }
/*     */                 } 
/*     */                 
/* 155 */                 ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getTarget())).current = Entity.STATE.HURTING;
/* 156 */                 if (((Action)Actions.get(i)).getTarget() <= 3) {
/* 157 */                   DarkCave.sounds.hiteffect.play();
/* 158 */                   if (Calculator.PhysicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 159 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())) > ((CombatEntityParameters)Entities
/* 160 */                     .get(((Action)Actions.get(i)).getTarget())).getCurrentHP()) {
/* 161 */                     AlliesHP -= ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getCurrentHP();
/*     */                   } else {
/* 163 */                     AlliesHP -= Calculator.PhysicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 164 */                         (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                   }
/*     */                 
/*     */                 }
/* 168 */                 else if (Calculator.PhysicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 169 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())) > ((CombatEntityParameters)Entities
/* 170 */                   .get(((Action)Actions.get(i)).getTarget())).getCurrentHP()) {
/* 171 */                   EnemiesHP -= ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getCurrentHP();
/*     */                 } else {
/* 173 */                   EnemiesHP -= Calculator.PhysicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 174 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                 } 
/*     */                 
/* 177 */                 ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()))
/* 178 */                   .DecreasCurrentHP(Calculator.PhysicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 179 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())));
/* 180 */                 CombatScreen.comcontroller
/* 181 */                   .setMessage(String.valueOf(((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getName()) + " infligge " + 
/* 182 */                     Calculator.PhysicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 183 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())) + 
/* 184 */                     " danni a " + ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getName());
/* 185 */                 CombatScreen.comcontroller.genPara(Entities);
/*     */                 break;
/*     */ 
/*     */ 
/*     */               
/*     */               case ABILITY:
/* 191 */                 IpoteticDamage = ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getCurrentHP();
/* 192 */                 if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && !FightIsOver() && (
/* 193 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead())
/*     */                 {
/* 195 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 197 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                   }
/*     */                 }
/*     */                 
/* 201 */                 if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && !FightIsOver() && (
/* 202 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead())
/*     */                 {
/* 204 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 206 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                   }
/*     */                 }
/*     */                 
/* 210 */                 if (((Action)Actions.get(i)).getTarget() != Entities.size - 1 && !FightIsOver() && (
/* 211 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead()) {
/*     */                   
/* 213 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 214 */                     (Action)Actions.get(i)).getTarget() < Entities.size - 1 && !FightIsOver())
/*     */                   {
/* 216 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() + 1));
/*     */                   }
/* 218 */                   if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && (
/* 219 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 221 */                     while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                     {
/* 223 */                       ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                     }
/*     */                   }
/*     */                 } 
/*     */ 
/*     */                 
/* 229 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 0 || (
/* 230 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 3) {
/* 231 */                   if (((Action)Actions.get(i)).getTarget() == 3 && !FightIsOver()) {
/* 232 */                     while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 233 */                       (Action)Actions.get(i)).getTarget() < 3) {
/* 234 */                       ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                     }
/*     */                   }
/*     */                   
/* 238 */                   if (((Action)Actions.get(i)).getTarget() != 3 && !FightIsOver()) {
/* 239 */                     while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 240 */                       (Action)Actions.get(i)).getTarget() < 3) {
/* 241 */                       ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() + 1));
/*     */                     }
/* 243 */                     if (((Action)Actions.get(i)).getTarget() == 3 && (
/* 244 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver()) {
/* 245 */                       while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 246 */                         (Action)Actions.get(i)).getTarget() < 3) {
/* 247 */                         ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                       }
/*     */                     }
/*     */                   } 
/*     */                 } 
/*     */                 
/* 253 */                 Calculator.Ability(((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID(), 
/* 254 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 255 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/* 256 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 0 || (
/* 257 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 3) {
/* 258 */                   DarkCave.sounds.whitemagiceffect.play();
/*     */                 }
/* 260 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 2) {
/* 261 */                   DarkCave.sounds.arroweffect.play();
/*     */                 }
/* 263 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() == 1) {
/* 264 */                   DarkCave.sounds.swordeffect.play();
/*     */                 }
/* 266 */                 if (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getID() > 3) {
/* 267 */                   DarkCave.sounds.hiteffect.play();
/*     */                 }
/* 269 */                 ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.INTERACTION;
/* 270 */                 if (Calculator.getFinalDamage() != 0) {
/* 271 */                   if (((Action)Actions.get(i)).getTarget() <= 3) {
/* 272 */                     DarkCave.sounds.hiteffect.play();
/* 273 */                     if (Calculator.getFinalDamage() > ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()))
/* 274 */                       .getCurrentHP()) {
/* 275 */                       AlliesHP -= IpoteticDamage;
/*     */                     } else {
/* 277 */                       AlliesHP -= Calculator.getFinalDamage();
/*     */                     }
/*     */                   
/*     */                   }
/* 281 */                   else if (Calculator.getFinalDamage() > ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()))
/* 282 */                     .getCurrentHP()) {
/* 283 */                     EnemiesHP -= IpoteticDamage;
/*     */                   } else {
/* 285 */                     EnemiesHP -= Calculator.getFinalDamage();
/*     */                   } 
/*     */                   
/* 288 */                   ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.ATTACKING;
/* 289 */                   ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getTarget())).current = Entity.STATE.HURTING;
/* 290 */                   CombatScreen.comcontroller
/* 291 */                     .setMessage(String.valueOf(((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getName()) + " infligge " + 
/* 292 */                       Calculator.getFinalDamage() + " danni a " + (
/* 293 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getName());
/*     */                 } 
/*     */ 
/*     */                 
/* 297 */                 CombatScreen.comcontroller.genPara(Entities);
/*     */                 break;
/*     */ 
/*     */               
/*     */               case HASTE:
/* 302 */                 if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && !FightIsOver() && (
/* 303 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead())
/*     */                 {
/* 305 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 307 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                   }
/*     */                 }
/*     */                 
/* 311 */                 if (((Action)Actions.get(i)).getTarget() != Entities.size - 1 && !FightIsOver() && (
/* 312 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead()) {
/*     */                   
/* 314 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 315 */                     (Action)Actions.get(i)).getTarget() < Entities.size - 1 && !FightIsOver())
/*     */                   {
/* 317 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() + 1));
/*     */                   }
/* 319 */                   if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && (
/* 320 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 322 */                     while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                     {
/* 324 */                       ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                     }
/*     */                   }
/*     */                 } 
/*     */                 
/* 329 */                 CombatScreen.comcontroller.setMessage(String.valueOf(((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getName()) + 
/* 330 */                     " usa Haste su " + ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getName());
/* 331 */                 DarkCave.sounds.whitemagiceffect.play();
/* 332 */                 ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.INTERACTION;
/* 333 */                 Calculator.Haste((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 334 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/* 335 */                 CombatScreen.comcontroller.genPara(Entities);
/*     */                 break;
/*     */ 
/*     */               
/*     */               case FLARE:
/* 340 */                 if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && !FightIsOver() && (
/* 341 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead())
/*     */                 {
/* 343 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 345 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                   }
/*     */                 }
/*     */                 
/* 349 */                 if (((Action)Actions.get(i)).getTarget() != Entities.size - 1 && !FightIsOver() && (
/* 350 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead()) {
/*     */                   
/* 352 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 353 */                     (Action)Actions.get(i)).getTarget() < Entities.size - 1 && !FightIsOver())
/*     */                   {
/* 355 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() + 1));
/*     */                   }
/* 357 */                   if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && (
/* 358 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 360 */                     while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                     {
/* 362 */                       ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                     }
/*     */                   }
/*     */                 } 
/*     */                 
/* 367 */                 ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.INTERACTION;
/* 368 */                 ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getTarget())).current = Entity.STATE.HURTING;
/* 369 */                 DarkCave.sounds.blackmagiceffect.play();
/*     */                 
/* 371 */                 if (((Action)Actions.get(i)).getTarget() <= 3) {
/*     */                   
/* 373 */                   if (Calculator.MagicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 374 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())) > ((CombatEntityParameters)Entities
/* 375 */                     .get(((Action)Actions.get(i)).getTarget())).getCurrentHP()) {
/* 376 */                     AlliesHP -= ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getCurrentHP();
/*     */                   } else {
/* 378 */                     AlliesHP -= Calculator.MagicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 379 */                         (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                   }
/*     */                 
/*     */                 }
/* 383 */                 else if (Calculator.MagicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 384 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())) > ((CombatEntityParameters)Entities
/* 385 */                   .get(((Action)Actions.get(i)).getTarget())).getCurrentHP()) {
/* 386 */                   EnemiesHP -= ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getCurrentHP();
/*     */                 } else {
/* 388 */                   EnemiesHP -= Calculator.MagicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 389 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                 } 
/*     */ 
/*     */                 
/* 393 */                 ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()))
/* 394 */                   .DecreasCurrentHP(Calculator.MagicAttack((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 395 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())));
/* 396 */                 CombatScreen.comcontroller.setMessage(String.valueOf(((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getName()) + 
/* 397 */                     " usa Flare su " + ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getName() + 
/* 398 */                     " infliggendo " + Calculator.getFinalDamage() + " danni");
/* 399 */                 CombatScreen.comcontroller.genPara(Entities);
/*     */                 break;
/*     */ 
/*     */               
/*     */               case ENERGIA:
/* 404 */                 if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && !FightIsOver() && (
/* 405 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead())
/*     */                 {
/* 407 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 409 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                   }
/*     */                 }
/*     */                 
/* 413 */                 if (((Action)Actions.get(i)).getTarget() != Entities.size - 1 && !FightIsOver() && (
/* 414 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead()) {
/*     */                   
/* 416 */                   while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && (
/* 417 */                     (Action)Actions.get(i)).getTarget() < Entities.size - 1 && !FightIsOver())
/*     */                   {
/* 419 */                     ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() + 1));
/*     */                   }
/* 421 */                   if (((Action)Actions.get(i)).getTarget() == Entities.size - 1 && (
/* 422 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                   {
/* 424 */                     while (((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).isDead() && !FightIsOver())
/*     */                     {
/* 426 */                       ((Action)Actions.get(i)).setTarget(Integer.valueOf(((Action)Actions.get(i)).getTarget() - 1));
/*     */                     }
/*     */                   }
/*     */                 } 
/* 430 */                 ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.INTERACTION;
/* 431 */                 DarkCave.sounds.whitemagiceffect.play();
/*     */                 
/* 433 */                 if (((Action)Actions.get(i)).getTarget() <= 3) {
/*     */                   
/* 435 */                   if (Calculator.Healing((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 436 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())) + (
/* 437 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getCurrentHP() > ((CombatEntityParameters)Entities
/* 438 */                     .get(((Action)Actions.get(i)).getTarget())).getHP()) {
/* 439 */                     AlliesHP += ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getHP() - 
/* 440 */                       Calculator.Healing((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 441 */                         (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                   } else {
/* 443 */                     AlliesHP += Calculator.Healing((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 444 */                         (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                   }
/*     */                 
/*     */                 }
/* 448 */                 else if (Calculator.Healing((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 449 */                     (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())) + (
/* 450 */                   (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getCurrentHP() > ((CombatEntityParameters)Entities
/* 451 */                   .get(((Action)Actions.get(i)).getTarget())).getHP()) {
/* 452 */                   EnemiesHP += ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getHP() - 
/* 453 */                     Calculator.Healing((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 454 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                 } else {
/* 456 */                   EnemiesHP += Calculator.Healing((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 457 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()));
/*     */                 } 
/*     */ 
/*     */                 
/* 461 */                 ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget()))
/* 462 */                   .IncreasCurrentHP(Calculator.Healing((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser()), 
/* 463 */                       (CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())));
/* 464 */                 CombatScreen.comcontroller.setMessage(String.valueOf(((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).getName()) + 
/* 465 */                     " usa Energia su " + ((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getTarget())).getName() + 
/* 466 */                     " curandone " + Calculator.getBaseRecovery() + " HP");
/* 467 */                 CombatScreen.comcontroller.genPara(Entities);
/*     */                 break;
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             try {
/* 476 */               wait(1500L);
/* 477 */             } catch (InterruptedException e) {
/* 478 */               e.printStackTrace();
/*     */             } 
/*     */           } 
/*     */           
/* 482 */           if (FightIsOver() || FightIsOver) {
/* 483 */             if (!((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).isDead()) {
/* 484 */               ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.IDLE;
/*     */             }
/* 486 */             if (AlliesHP > 0) {
/* 487 */               CombatScreen.comcontroller.endText("Vittoria"); break;
/*     */             } 
/* 489 */             CombatScreen.comcontroller.endText("Game Over");
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/* 494 */           if (!((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).isDead()) {
/* 495 */             ((CombatEntityParameters)Entities.get(i)).CurrentChoise = CombatEntityParameters.Choise.WAITING;
/*     */           }
/* 497 */           if (!((CombatEntityParameters)Entities.get(((Action)Actions.get(i)).getChooser())).isDead()) {
/* 498 */             ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getTarget())).current = Entity.STATE.IDLE;
/* 499 */             ((Entity)CombatScreen.GraphicEntities.get(((Action)Actions.get(i)).getChooser())).current = Entity.STATE.IDLE;
/*     */           } 
/*     */         } 
/* 502 */         Actions.clear();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\combatlogic\Fight.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */