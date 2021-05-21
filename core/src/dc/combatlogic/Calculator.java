/*     */ package dc.combatlogic;
/*     */ 
/*     */ import dc.parameters.CombatEntityParameters;
/*     */ import dc.view.CombatScreen;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Calculator
/*     */ {
/*  12 */   private static Calculator instance = null; private static int FinalDamage; private static int BaseRecovery;
/*     */   public static Calculator getInstance() {
/*  14 */     if (instance == null)
/*     */     {
/*  16 */       instance = new Calculator();
/*     */     }
/*  18 */     return instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getFinalDamage() {
/*  23 */     return FinalDamage;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getBaseRecovery() {
/*  28 */     return BaseRecovery;
/*     */   }
/*     */   
/*     */   public static int PhysicAttack(CombatEntityParameters Attacker, CombatEntityParameters Defender) {
/*  32 */     FinalDamage = 0;
/*  33 */     int Basedamage = (int)((Math.pow(Attacker.getPotFisica(), 3.0D) / 32.0D + 32.0D) * 16.0D / 16.0D);
/*     */     
/*  35 */     int DefNum = (int)((Defender.getDifFisica() - 280.4F) * (Defender.getDifFisica() - 280.4F) / 110.0F + 16.0F);
/*     */     
/*  37 */     int Basedamage2 = Basedamage * DefNum / 730;
/*  38 */     FinalDamage = Basedamage2 * (730 - (Defender.getDifFisica() * 51 - Defender.getDifFisica() * Defender.getDifFisica() / 11) / 10) / 730;
/*  39 */     if (Defender.CurrentChoise == CombatEntityParameters.Choise.DEFEND)
/*     */     {
/*  41 */       FinalDamage /= 2;
/*     */     }
/*     */        CombatScreen.comcontroller.setMessage(Attacker.getName() + " infligge "+ FinalDamage +"a" + Defender.getName());
/*  44 */     return FinalDamage;
/*     */   }
/*     */   
/*     */   public static int Healing(CombatEntityParameters Healer, CombatEntityParameters Healed) {
/*  48 */     BaseRecovery = 0;
/*  49 */     if (Healer.getCurrentMP() < 10) {
/*     */       
/*  51 */       CombatScreen.comcontroller.setMessage(String.valueOf(Healer.getName()) + " fallisce perchè non ha abbastanza MP");
/*  52 */       return 0;
/*     */     } 
/*  54 */     Healer.DecreasCurrentMP(10);
/*     */     
/*  56 */     BaseRecovery = 40 * (Healer.getPotMagica() + 40) / 2;
/*     */     CombatScreen.comcontroller.setMessage(Healer.getName() +"cura "+ BaseRecovery + Healed.getName());
/*  58 */     return BaseRecovery;
/*     */   }
/*     */   
/*     */   public static int MagicAttack(CombatEntityParameters Attacker, CombatEntityParameters Defender) {
/*  62 */     FinalDamage = 0;
/*  63 */     if (Attacker.getCurrentMP() < 8) {
/*     */       
/*  65 */       CombatScreen.comcontroller.setMessage(String.valueOf(Attacker.getName()) + " fallisce perchÃ¨ non ha abbastanza MP");
/*  66 */       return 0;
/*     */     } 
/*  68 */     Attacker.DecreasCurrentMP(8);
/*  69 */     int Basedamage = (24 * Attacker.getPotMagica() * Attacker.getPotMagica() / 6 + 24) / 4;
/*  70 */     int MDefNum = (int)((Defender.getDifMagica() - 280.4D) * (Defender.getDifMagica() - 280.4D) / 110.0D + 16.0D);
/*  71 */     int Basedamage2 = Basedamage * MDefNum / 730;
/*  72 */     FinalDamage = Basedamage2 * (730 - (Defender.getDifMagica() * 51 - Defender.getDifMagica() * Defender.getDifMagica() / 11) / 10) / 730;
/*     */     CombatScreen.comcontroller.setMessage(Attacker.getName() + " infligge "+ FinalDamage +"a" + Defender.getName());
/*  74 */     return FinalDamage; }
			public static void Ability(int ID, CombatEntityParameters Attacker, CombatEntityParameters Defender) { int i;
/*     */     int Basedamage;
/*     */     int incentivo;
/*     */     int DefNum;
/*     */     int Basedamage2;
/*  79 */     switch (ID) {
/*     */       
/*     */       case 0:
/*  82 */         FinalDamage = 0;
/*  83 */         if (Attacker.getCurrentMP() < 10) {
/*     */           
/*  85 */           CombatScreen.comcontroller.setMessage(Attacker.getName() + " fallisce perchè non ha abbastanza MP");
/*     */           return;
/*     */         } 
/*  88 */         Attacker.DecreasCurrentMP(10);
/*  89 */         CombatScreen.comcontroller.setMessage(Attacker.getName() + " Incentiva " + Defender.getName());
/*  90 */         i = Defender.getPotFisica() * 10 / 100;
/*  91 */         Defender.increasPotFisica(i);
/*     */         return;
/*     */       
/*     */       case 1:
/*  95 */         FinalDamage = 0;
/*  96 */         if (Attacker.getCurrentMP() < 20) {
/*     */           
/*  98 */           CombatScreen.comcontroller.setMessage(Attacker.getName() + " fallisce perchè non ha abbastanza MP");
/*     */           return;
/*     */         } 
/* 101 */         Attacker.DecreasCurrentMP(20);
/* 102 */         Basedamage = (int)((Math.pow(Attacker.getPotFisica(), 3.0D) / 32.0D + 32.0D) * 16.0D / 16.0D);
/* 103 */         DefNum = (int)(((Defender.getDifFisica() / 2) - 280.4F) * ((Defender.getDifFisica() / 2) - 280.4F) / 110.0F + 16.0F);
/* 104 */         Basedamage2 = Basedamage * DefNum / 730;
/* 105 */         FinalDamage = Basedamage2 * (730 - (Defender.getDifFisica() / 2 * 51 - Defender.getDifFisica() / 2 * Defender.getDifFisica() / 2 / 11) / 10) / 730;
/* 106 */         Defender.DecreasCurrentHP(FinalDamage);
					CombatScreen.comcontroller.setMessage(Attacker.getName() + " infligge "+ FinalDamage +"a" + Defender.getName());
/*     */         return;
/*     */ 
/*     */       
/*     */       case 2:
/* 111 */         FinalDamage = 0;
/* 112 */         if (Attacker.getCurrentMP() < 40) {
/*     */           
/* 114 */           CombatScreen.comcontroller.setMessage(Attacker.getName() + " fallisce perchÃ¨ non ha abbastanza MP");
/*     */           return;
/*     */         } 
/* 117 */         Attacker.DecreasCurrentMP(40);
/* 118 */         Basedamage = (int)((Math.pow(Attacker.getPotFisica(), 3.0D) / 32.0D + 32.0D) * 16.0D / 16.0D);
/*     */         
/* 120 */         DefNum = (int)((Defender.getDifFisica() - 280.4F) * (Defender.getDifFisica() - 280.4F) / 110.0F + 16.0F);
/*     */         
/* 122 */         Basedamage2 = Basedamage * DefNum / 730;
/* 123 */         FinalDamage = Basedamage2 * (730 - (Defender.getDifFisica() * 51 - Defender.getDifFisica() * Defender.getDifFisica() / 11) / 10) / 730;
/* 124 */         if (Defender.CurrentChoise == CombatEntityParameters.Choise.DEFEND)
/*     */         {
/* 126 */           FinalDamage /= 2;
/*     */         }
/* 128 */         FinalDamage *= 2;
					Defender.DecreasCurrentHP(FinalDamage);
					CombatScreen.comcontroller.setMessage(Attacker.getName() + " infligge "+ FinalDamage +"a" + Defender.getName());
/*     */         return;
/*     */ 
/*     */       
/*     */       case 3:
/* 133 */         FinalDamage = 0;
/* 134 */         if (Attacker.getCurrentMP() < 10) {
/*     */           
/* 136 */           CombatScreen.comcontroller.setMessage(Attacker.getName() + " fallisce perchÃ¨ non ha abbastanza MP");
/*     */           return;
/*     */         } 
/* 139 */         Attacker.DecreasCurrentMP(10);
/*     */         
/* 141 */         incentivo = Defender.getPotMagica() * 5 / 100;
/* 142 */         CombatScreen.comcontroller.setMessage(Attacker.getName() + " da piu' concentrazione a " + Defender.getName());
/* 143 */         Defender.increasSpeed(incentivo);
/*     */         return;
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void Haste(CombatEntityParameters Attacker, CombatEntityParameters Defender) {
/* 152 */     if (Attacker.getCurrentMP() < 20) {
/*     */       
/* 154 */       CombatScreen.comcontroller.setMessage(Attacker.getName() + " fallisce perchÃ¨ non ha abbastanza MP");
/*     */       return;
/*     */     } 
/* 157 */     Attacker.DecreasCurrentMP(20);
/* 158 */     int incentivo = Defender.getSpeed() * 5 / 100;
/* 159 */     Defender.increasSpeed(incentivo);
			CombatScreen.comcontroller.setMessage(Attacker.getName() + " velocizza "+ Defender.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int Fuga() {
/* 166 */     Random rand = new Random();
/* 167 */     int Fuga = rand.nextInt(6) + 1;
/* 168 */     return Fuga;
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\combatlogic\Calculator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */