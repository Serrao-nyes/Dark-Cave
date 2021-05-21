/*     */ package dc.parameters;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnemiesParameteres
/*     */ {
/*   8 */   private static EnemiesParameteres instance = null;
/*     */   
/*     */   public static EnemiesParameteres getInstance() {
/*  11 */     if (instance == null) {
/*  12 */       instance = new EnemiesParameteres();
/*     */     }
/*  14 */     return instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public CombatEntityParameters CreateEntityParamters(int ID) {
/*     */     AbsoluteEntityParameters A;
/*     */     CombatEntityParameters K;
/*  21 */     switch (ID) {
/*     */       case 4:
/*  23 */         A = new Dog();
/*  24 */         K = new CombatEntityParameters(A);
/*  25 */         return K;
/*     */       case 10:
/*  27 */         A = new Circolaro();
/*  28 */         K = new CombatEntityParameters(A);
/*  29 */         return K;
/*     */       case 5:
/*  31 */         A = new Plant();
/*  32 */         K = new CombatEntityParameters(A);
/*  33 */         return K;
/*     */       case 6:
/*  35 */         A = new Bat();
/*  36 */         K = new CombatEntityParameters(A);
/*  37 */         return K;
/*     */       case 7:
/*  39 */         A = new Lizard();
/*  40 */         K = new CombatEntityParameters(A);
/*  41 */         return K;
/*     */       case 8:
/*  43 */         A = new Demon();
/*  44 */         K = new CombatEntityParameters(A);
/*  45 */         return K;
/*     */       case 9:
/*  47 */         A = new Dragon();
/*  48 */         K = new CombatEntityParameters(A);
/*  49 */         return K;
/*     */       case 11:
/*  51 */         A = new FinalBoss();
/*  52 */         K = new CombatEntityParameters(A);
/*  53 */         return K;
/*     */     } 
/*  55 */     return null;
/*     */   }
/*     */   
/*     */   public static class Dog
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Dog() {
/*  62 */       setHP(1800);
/*  63 */       setMP(75);
/*  64 */       setPotFisica(32);
/*  65 */       setDifFisica(1);
/*  66 */       setPotMagica(1);
/*  67 */       setDifMagica(180);
/*  68 */       setSpeed(32);
/*  69 */       setID(4);
/*  70 */       setName("HellHound");
/*  71 */       setCurrentHP(getHP());
/*  72 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Circolaro
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Circolaro() {
/*  80 */       setHP(50000);
/*  81 */       setMP(75);
/*  82 */       setPotFisica(34);
/*  83 */       setDifFisica(55);
/*  84 */       setPotMagica(1);
/*  85 */       setDifMagica(12);
/*  86 */       setSpeed(16);
/*  87 */       setID(10);
/*  88 */       setName("Circolaro");
/*  89 */       setCurrentHP(getHP());
/*  90 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FinalBoss
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public FinalBoss() {
/*  98 */       setHP(45000);
/*  99 */       setMP(480);
/* 100 */       setPotFisica(43);
/* 101 */       setDifFisica(50);
/* 102 */       setPotMagica(37);
/* 103 */       setDifMagica(40);
/* 104 */       setSpeed(23);
/* 105 */       setID(11);
/* 106 */       setName("Ruxoll");
/* 107 */       setCurrentHP(getHP());
/* 108 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Plant
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Plant() {
/* 116 */       setHP(6000);
/* 117 */       setMP(480);
/* 118 */       setPotFisica(35);
/* 119 */       setDifFisica(1);
/* 120 */       setPotMagica(30);
/* 121 */       setDifMagica(1);
/* 122 */       setSpeed(23);
/* 123 */       setID(5);
/* 124 */       setName("Madragola");
/* 125 */       setCurrentHP(getHP());
/* 126 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Bat
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Bat() {
/* 134 */       setHP(2800);
/* 135 */       setMP(400);
/* 136 */       setPotFisica(1);
/* 137 */       setDifFisica(1);
/* 138 */       setPotMagica(38);
/* 139 */       setDifMagica(102);
/* 140 */       setSpeed(24);
/* 141 */       setID(6);
/* 142 */       setName("Kobold");
/* 143 */       setCurrentHP(getHP());
/* 144 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Lizard
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Lizard() {
/* 152 */       setHP(900);
/* 153 */       setMP(95);
/* 154 */       setPotFisica(26);
/* 155 */       setDifFisica(1);
/* 156 */       setPotMagica(1);
/* 157 */       setDifMagica(180);
/* 158 */       setSpeed(29);
/* 159 */       setID(7);
/* 160 */       setName("Yowie");
/* 161 */       setCurrentHP(getHP());
/* 162 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Demon
/*     */     extends AbsoluteEntityParameters
/*     */   {
/*     */     public Demon() {
/* 170 */       setHP(4880);
/* 171 */       setMP(300);
/* 172 */       setPotFisica(1);
/* 173 */       setDifFisica(1);
/* 174 */       setPotMagica(25);
/* 175 */       setDifMagica(180);
/* 176 */       setSpeed(24);
/* 177 */       setID(8);
/* 178 */       setName("Demon");
/* 179 */       setCurrentHP(getHP());
/* 180 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Dragon
/*     */     extends AbsoluteEntityParameters {
/*     */     public Dragon() {
/* 187 */       setHP(40700);
/* 188 */       setMP(29);
/* 189 */       setPotFisica(36);
/* 190 */       setDifFisica(40);
/* 191 */       setPotMagica(21);
/* 192 */       setDifMagica(40);
/* 193 */       setSpeed(30);
/* 194 */       setID(9);
/* 195 */       setName("Dragon");
/* 196 */       setCurrentHP(getHP());
/* 197 */       setCurrentMP(getMP());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\parameters\EnemiesParameteres.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */