/*     */ package dc.parameters;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AlliesParameters
/*     */ {
/*     */   private static Warrior Flik;
/*     */   private static Knight Pesmerga;
/*     */   private static Archer Ted;
/*     */   private static Mage Lotte;
/*  12 */   private static AlliesParameters instance = null;
/*     */   
/*     */   public static AlliesParameters getInstance() {
/*  15 */     if (instance == null) {
/*  16 */       instance = new AlliesParameters();
/*     */     }
/*  18 */     return instance;
/*     */   }
/*     */   
/*     */   public void init() {
/*  22 */     Flik = new Warrior();
/*  23 */     Pesmerga = new Knight();
/*  24 */     Ted = new Archer();
/*  25 */     Lotte = new Mage();
/*     */   }
/*     */   
/*     */   public static Warrior getWarrior() {
/*  29 */     return Flik;
/*     */   }
/*     */   
/*     */   public static Knight getKnight() {
/*  33 */     return Pesmerga;
/*     */   }
/*     */   
/*     */   public static Archer getArcher() {
/*  37 */     return Ted;
/*     */   }
/*     */   
/*     */   public static Mage getMage() {
/*  41 */     return Lotte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CombatEntityParameters CreateEntityParamters(int ID) {
/*     */     CombatEntityParameters K;
/*  48 */     switch (ID) {
/*     */       case 0:
/*  50 */         K = new CombatEntityParameters(Flik);
/*  51 */         return K;
/*     */       
/*     */       case 1:
/*  54 */         K = new CombatEntityParameters(Pesmerga);
/*  55 */         return K;
/*     */       
/*     */       case 2:
/*  58 */         K = new CombatEntityParameters(Ted);
/*  59 */         return K;
/*     */       
/*     */       case 3:
/*  62 */         K = new CombatEntityParameters(Lotte);
/*  63 */         return K;
/*     */     } 
/*     */     
/*  66 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public class Warrior
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Warrior() {
/*  74 */       setHP(4264);
/*  75 */       setMP(132);
/*  76 */       setPotFisica(42);
/*  77 */       setDifFisica(24);
/*  78 */       setPotMagica(5);
/*  79 */       setDifMagica(7);
/*  80 */       setSpeed(36);
/*  81 */       setID(0);
/*  82 */       setName("Flik");
/*  83 */       setCurrentHP(getHP());
/*  84 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public class Knight
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Knight() {
/*  92 */       setHP(4433);
/*  93 */       setMP(93);
/*  94 */       setPotFisica(48);
/*  95 */       setDifFisica(33);
/*  96 */       setPotMagica(5);
/*  97 */       setDifMagica(11);
/*  98 */       setSpeed(13);
/*  99 */       setID(1);
/* 100 */       setName("Pesmerga");
/* 101 */       setCurrentHP(getHP());
/* 102 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public class Archer
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Archer() {
/* 110 */       setHP(3588);
/* 111 */       setMP(190);
/* 112 */       setPotFisica(41);
/* 113 */       setDifFisica(26);
/* 114 */       setPotMagica(29);
/* 115 */       setDifMagica(5);
/* 116 */       setSpeed(25);
/* 117 */       setID(2);
/* 118 */       setName("Ted");
/* 119 */       setCurrentHP(getHP());
/* 120 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public class Mage
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Mage() {
/* 128 */       setHP(1875);
/* 129 */       setMP(244);
/* 130 */       setPotFisica(9);
/* 131 */       setDifFisica(11);
/* 132 */       setPotMagica(44);
/* 133 */       setDifMagica(48);
/* 134 */       setSpeed(30);
/* 135 */       setID(3);
/* 136 */       setName("Lotte");
/* 137 */       setCurrentHP(getHP());
/* 138 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void resetParameters() {
/* 143 */     Flik.setCurrentHP(Flik.getHP());
/* 144 */     Flik.setCurrentMP(Flik.getMP());
/* 145 */     Pesmerga.setCurrentHP(Pesmerga.getHP());
/* 146 */     Pesmerga.setCurrentMP(Pesmerga.getMP());
/* 147 */     Ted.setCurrentHP(Ted.getHP());
/* 148 */     Ted.setCurrentMP(Ted.getMP());
/* 149 */     Lotte.setCurrentHP(Lotte.getHP());
/* 150 */     Lotte.setCurrentMP(Lotte.getMP());
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\parameters\AlliesParameters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */