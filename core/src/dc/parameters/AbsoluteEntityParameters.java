/*     */ package dc.parameters;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AbsoluteEntityParameters
/*     */ {
/*     */   private int HP;
/*     */   private int MP;
/*     */   private int PotFisica;
/*     */   private int PotMagica;
/*     */   private int DifFisica;
/*     */   private int DifMagica;
/*     */   private int Speed;
/*     */   private int CurrentHP;
/*     */   private int CurrentMP;
/*     */   private String Name;
/*     */   private int ID;
/*     */   
/*     */   public String getName() {
/*  21 */     return this.Name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  25 */     this.Name = name;
/*     */   }
/*     */   
/*     */   public int getID() {
/*  29 */     return this.ID;
/*     */   }
/*     */   
/*     */   public void setID(int iD) {
/*  33 */     this.ID = iD;
/*     */   }
/*     */   
/*     */   public int getHP() {
/*  37 */     return this.HP;
/*     */   }
/*     */   
/*     */   public void setHP(int hP) {
/*  41 */     this.HP = hP;
/*     */   }
/*     */   
/*     */   public int getMP() {
/*  45 */     return this.MP;
/*     */   }
/*     */   
/*     */   public void setMP(int mP) {
/*  49 */     this.MP = mP;
/*     */   }
/*     */   
/*     */   public int getPotFisica() {
/*  53 */     return this.PotFisica;
/*     */   }
/*     */   
/*     */   public void setPotFisica(int potFisica) {
/*  57 */     this.PotFisica = potFisica;
/*     */   }
/*     */   
/*     */   public int getDifFisica() {
/*  61 */     return this.DifFisica;
/*     */   }
/*     */   
/*     */   public void setDifFisica(int difFisica) {
/*  65 */     this.DifFisica = difFisica;
/*     */   }
/*     */   
/*     */   public int getDifMagica() {
/*  69 */     return this.DifMagica;
/*     */   }
/*     */   
/*     */   public void setDifMagica(int difMagica) {
/*  73 */     this.DifMagica = difMagica;
/*     */   }
/*     */   
/*     */   public int getSpeed() {
/*  77 */     return this.Speed;
/*     */   }
/*     */   
/*     */   public void setSpeed(int speed) {
/*  81 */     this.Speed = speed;
/*     */   }
/*     */   
/*     */   public int getCurrentHP() {
/*  85 */     return this.CurrentHP;
/*     */   }
/*     */   
/*     */   public void setCurrentHP(int curretnHP) {
/*  89 */     this.CurrentHP = curretnHP;
/*     */   }
/*     */   
/*     */   public int getCurrentMP() {
/*  93 */     return this.CurrentMP;
/*     */   }
/*     */   
/*     */   public void setCurrentMP(int currentMP) {
/*  97 */     this.CurrentMP = currentMP;
/*     */   }
/*     */   
/*     */   public int getPotMagica() {
/* 101 */     return this.PotMagica;
/*     */   }
/*     */   
/*     */   public void setPotMagica(int potMagica) {
/* 105 */     this.PotMagica = potMagica;
/*     */   }
/*     */   
/*     */   public void UpdateCurrentHP(CombatEntityParameters A) {
/* 109 */     this.CurrentHP = A.getCurrentHP();
/*     */   }
/*     */   
/*     */   public void UpdateCurrentMP(CombatEntityParameters A) {
/* 113 */     this.CurrentMP = A.getCurrentMP();
/*     */   }
/*     */ 
/*     */   
/*     */   public void IncreasCurrentHP(int value) {
/* 118 */     this.CurrentHP += value;
/* 119 */     if (this.CurrentHP > this.HP) {
/* 120 */       this.CurrentHP = this.HP;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void IncreasCurrentMP(int value) {
/* 128 */     this.CurrentMP += value;
/* 129 */     if (this.CurrentMP > this.MP) {
/* 130 */       this.CurrentMP = this.MP;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void DecreasCurrentHP(int value) {
/* 138 */     this.CurrentHP -= value;
/* 139 */     if (this.CurrentHP < 0) {
/* 140 */       this.CurrentHP = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void DecreasCurrentMP(int value) {
/* 148 */     this.CurrentMP -= value;
/* 149 */     if (this.CurrentMP < 0) {
/* 150 */       this.CurrentMP = 0;
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDead() {
/* 157 */     return (getCurrentHP() == 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\parameters\AbsoluteEntityParameters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */