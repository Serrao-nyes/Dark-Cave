/*     */ package dc.view;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.PauseableThread;
/*     */ import dc.combatlogic.Fight;
/*     */ import dc.controller.CombatTablesController;
/*     */ import dc.controller.IA.EnemiesIA;
/*     */ import dc.controller.IA.IA;
/*     */ import dc.controller.PlayerController;
/*     */ import dc.controller.manager.GameScreenManager;
/*     */ import dc.game.DarkCave;
/*     */ import dc.model.Enemies;
/*     */ import dc.model.Entity;
/*     */ import dc.model.Party;
/*     */ import dc.parameters.AlliesParameters;
/*     */ import dc.parameters.CombatEntityParameters;
/*     */ import dc.parameters.EnemiesParameteres;
/*     */ import dc.settings.Constans;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CombatScreen
/*     */   extends AbstractScreen
/*     */ {
/*     */   private TextureRegion text;
/*     */   public static Array<Entity> GraphicEntities;
/*     */   private Party party;
/*     */   private Enemies enemies;
/*     */   private AlliesParameters alliesparameters;
/*     */   private EnemiesParameteres enemiesparameters;
/*     */   private static PauseableThread FightThread;
/*     */   private static Fight fight;
/*     */   public static int Nenemies;
/*     */   private SpriteBatch batchy;
/*     */   public static CombatTablesController comcontroller;
/*     */   
/*     */   public CombatScreen(DarkCave game) {
/*  42 */     super(game);
/*  43 */     this.text = new TextureRegion(new Texture("Background/CaveBackground.png"));
/*  44 */     this.party = Party.getInstance();
/*  45 */     this.enemies = Enemies.getInstance();
/*  46 */     this.alliesparameters = AlliesParameters.getInstance();
/*  47 */     this.alliesparameters.init();
/*  48 */     this.enemiesparameters = EnemiesParameteres.getInstance();
/*  49 */     GraphicEntities = new Array();
/*  50 */     fight = Fight.getInstance();
/*  51 */     FightThread = new PauseableThread((Runnable)fight);
/*     */     
/*  53 */     comcontroller = new CombatTablesController(this);
/*     */   }
/*     */   
/*     */   private void Init() {
/*  57 */     if (PlayerController.isDragonInteracted) {
/*  58 */       GraphicEntities.clear();
/*  59 */       Fight.AlliesHP = 0;
/*  60 */       Fight.EnemiesHP = 0;
/*  61 */       Fight.FightIsOver = false;
/*  62 */       Fight.Entities = new Array();
/*  63 */       Fight.Actions = new Array();
/*  64 */       Fight.ias = new Array();
/*  65 */       Fight.brain = EnemiesIA.getIstance();
/*     */       
/*  67 */       for (int j = 0; j < 4; j++) {
/*  68 */         GraphicEntities.add(this.party.CreateEntity(j, new Entity()));
/*  69 */         Fight.Entities.add(this.alliesparameters.CreateEntityParamters(j));
/*  70 */         Fight.AlliesHP += ((CombatEntityParameters)Fight.Entities.get(j)).getCurrentHP();
/*     */       } 
/*  72 */       Nenemies = 1;
/*  73 */       GraphicEntities.add(this.enemies.CreateEntity(9, new Entity()));
/*  74 */       IA ia = Fight.brain.CreateIA(9);
/*  75 */       Fight.ias.add(ia);
/*  76 */       Fight.Entities.add(this.enemiesparameters.CreateEntityParamters(9));
/*  77 */       Fight.EnemiesHP += ((CombatEntityParameters)Fight.Entities.get(Fight.Entities.size - 1)).getCurrentHP();
/*     */       
/*     */       return;
/*     */     } 
/*  81 */     if (PlayerController.isCircoInteracted) {
/*  82 */       GraphicEntities.clear();
/*  83 */       Fight.AlliesHP = 0;
/*  84 */       Fight.EnemiesHP = 0;
/*  85 */       Fight.FightIsOver = false;
/*  86 */       Fight.Entities = new Array();
/*  87 */       Fight.Actions = new Array();
/*  88 */       Fight.ias = new Array();
/*  89 */       Fight.brain = EnemiesIA.getIstance();
/*     */       
/*  91 */       for (int j = 0; j < 4; j++) {
/*  92 */         GraphicEntities.add(this.party.CreateEntity(j, new Entity()));
/*  93 */         Fight.Entities.add(this.alliesparameters.CreateEntityParamters(j));
/*  94 */         Fight.AlliesHP += ((CombatEntityParameters)Fight.Entities.get(j)).getCurrentHP();
/*     */       } 
/*  96 */       Nenemies = 1;
/*  97 */       GraphicEntities.add(this.enemies.CreateEntity(10, new Entity()));
/*  98 */       IA ia = Fight.brain.CreateIA(10);
/*  99 */       Fight.ias.add(ia);
/* 100 */       Fight.Entities.add(this.enemiesparameters.CreateEntityParamters(10));
/* 101 */       Fight.EnemiesHP += ((CombatEntityParameters)Fight.Entities.get(Fight.Entities.size - 1)).getCurrentHP();
/*     */       
/*     */       return;
/*     */     } 
/* 105 */     if (PlayerController.isRuxollInteracted) {
/* 106 */       GraphicEntities.clear();
/* 107 */       Fight.AlliesHP = 0;
/* 108 */       Fight.EnemiesHP = 0;
/* 109 */       Fight.FightIsOver = false;
/* 110 */       Fight.Entities = new Array();
/* 111 */       Fight.Actions = new Array();
/* 112 */       Fight.ias = new Array();
/* 113 */       Fight.brain = EnemiesIA.getIstance();
/*     */       
/* 115 */       for (int j = 0; j < 4; j++) {
/* 116 */         GraphicEntities.add(this.party.CreateEntity(j, new Entity()));
/* 117 */         Fight.Entities.add(this.alliesparameters.CreateEntityParamters(j));
/* 118 */         Fight.AlliesHP += ((CombatEntityParameters)Fight.Entities.get(j)).getCurrentHP();
/*     */       } 
/* 120 */       Nenemies = 1;
/* 121 */       GraphicEntities.add(this.enemies.CreateEntity(11, new Entity()));
/* 122 */       IA ia = Fight.brain.CreateIA(11);
/* 123 */       Fight.ias.add(ia);
/* 124 */       Fight.Entities.add(this.enemiesparameters.CreateEntityParamters(11));
/* 125 */       Fight.EnemiesHP += ((CombatEntityParameters)Fight.Entities.get(Fight.Entities.size - 1)).getCurrentHP();
/*     */       
/*     */       return;
/*     */     } 
/* 129 */     GraphicEntities.clear();
/* 130 */     Fight.AlliesHP = 0;
/* 131 */     Fight.EnemiesHP = 0;
/* 132 */     Fight.FightIsOver = false;
/* 133 */     Fight.Entities = new Array();
/* 134 */     Fight.Actions = new Array();
/* 135 */     Fight.ias = new Array();
/* 136 */     Fight.brain = EnemiesIA.getIstance();
/*     */     int i;
/* 138 */     for (i = 0; i < 4; i++) {
/* 139 */       GraphicEntities.add(this.party.CreateEntity(i, new Entity()));
/* 140 */       Fight.Entities.add(this.alliesparameters.CreateEntityParamters(i));
/* 141 */       Fight.AlliesHP += ((CombatEntityParameters)Fight.Entities.get(i)).getCurrentHP();
/*     */     } 
/* 143 */     Nenemies = (int)(Math.random() * 3.0D) + 1;
/*     */     
/* 145 */     for (i = 4; i < Nenemies + 4; i++) {
/* 146 */       int rand = (int)(Math.random() * 5.0D) + 4;
/*     */       
/* 148 */       GraphicEntities.add(this.enemies.CreateEntity(rand, new Entity()));
/* 149 */       IA ia = Fight.brain.CreateIA(rand);
/* 150 */       Fight.ias.add(ia);
/* 151 */       Fight.Entities.add(this.enemiesparameters.CreateEntityParamters(rand));
/* 152 */       Fight.EnemiesHP += ((CombatEntityParameters)Fight.Entities.get(i)).getCurrentHP();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pause() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize(int width, int height) {
/* 163 */     super.resize(width, height);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 168 */     super.dispose();
/* 169 */     FightThread.stopThread();
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/* 174 */     DarkCave.music.cavetheme.stop();
/* 175 */     if (PlayerController.isCircoInteracted) {
/* 176 */       DarkCave.music.circolarotheme.play();
/* 177 */       DarkCave.music.circolarotheme.setLooping(true);
/* 178 */     } else if (PlayerController.isRuxollInteracted) {
/* 179 */       DarkCave.music.finalbosstheme.play();
/* 180 */       DarkCave.music.finalbosstheme.setLooping(true);
/* 181 */     } else if (PlayerController.isDragonInteracted) {
/* 182 */       DarkCave.music.dragontheme.play();
/* 183 */       DarkCave.music.dragontheme.setLooping(true);
/* 184 */     } else if (!PlayerController.isCircoInteracted && !PlayerController.isRuxollInteracted) {
/* 185 */       DarkCave.music.battletheme.play();
/* 186 */       DarkCave.music.battletheme.setLooping(true);
/*     */     } 
/* 188 */     Init();
/* 189 */     if (FightThread.isPaused()) {
/* 190 */       FightThread.onResume();
/*     */     } else {
/* 192 */       FightThread.start();
/* 193 */     }  super.show();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(float delta) {
/* 198 */     super.render(delta);
/* 199 */     if (PlayerController.isDragonInteracted) {
/* 200 */       int j = 10;
/* 201 */       this.batchy = new SpriteBatch();
/*     */       
/* 203 */       this.batchy.begin();
/* 204 */       this.batchy.draw(this.text, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT); int k;
/* 205 */       for (k = 0; k < 2; k++) {
/* 206 */         if (GraphicEntities.get(k) != null) {
/* 207 */           this.batchy.draw((TextureRegion)GraphicEntities.get(k), 550.0F, j, 100.0F, 200.0F);
/*     */         }
/* 209 */         j += 180;
/*     */       } 
/* 211 */       j = 190;
/* 212 */       for (k = 2; k < 4; k++) {
/* 213 */         if (GraphicEntities.get(k) != null) {
/* 214 */           this.batchy.draw((TextureRegion)GraphicEntities.get(k), 750.0F, j, 100.0F, 200.0F);
/*     */         }
/* 216 */         j += 180;
/*     */       } 
/* 218 */       if (GraphicEntities.get(GraphicEntities.size - 1) != null) {
/* 219 */         this.batchy.draw((TextureRegion)GraphicEntities.get(GraphicEntities.size - 1), 50.0F, 100.0F, 500.0F, 500.0F);
/*     */       }
/* 221 */       this.batchy.end();
/* 222 */       this.batchy.dispose();
/* 223 */       this.stage.act(delta);
/* 224 */       this.stage.draw();
/*     */       
/*     */       return;
/*     */     } 
/* 228 */     if (PlayerController.isCircoInteracted) {
/* 229 */       int j = 10;
/* 230 */       this.batchy = new SpriteBatch();
/*     */       
/* 232 */       this.batchy.begin();
/* 233 */       this.batchy.draw(this.text, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT); int k;
/* 234 */       for (k = 0; k < 2; k++) {
/* 235 */         if (GraphicEntities.get(k) != null) {
/* 236 */           this.batchy.draw((TextureRegion)GraphicEntities.get(k), 550.0F, j, 100.0F, 200.0F);
/*     */         }
/* 238 */         j += 180;
/*     */       } 
/* 240 */       j = 190;
/* 241 */       for (k = 2; k < 4; k++) {
/* 242 */         if (GraphicEntities.get(k) != null) {
/* 243 */           this.batchy.draw((TextureRegion)GraphicEntities.get(k), 750.0F, j, 100.0F, 200.0F);
/*     */         }
/* 245 */         j += 180;
/*     */       } 
/* 247 */       if (GraphicEntities.get(GraphicEntities.size - 1) != null) {
/* 248 */         this.batchy.draw((TextureRegion)GraphicEntities.get(GraphicEntities.size - 1), 50.0F, 200.0F, 300.0F, 300.0F);
/*     */       }
/* 250 */       this.batchy.end();
/* 251 */       this.batchy.dispose();
/* 252 */       this.stage.act(delta);
/* 253 */       this.stage.draw();
/*     */       
/*     */       return;
/*     */     } 
/* 257 */     if (PlayerController.isRuxollInteracted) {
/* 258 */       int j = 10;
/* 259 */       this.batchy = new SpriteBatch();
/*     */       
/* 261 */       this.batchy.begin();
/* 262 */       this.batchy.draw(this.text, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT); int k;
/* 263 */       for (k = 0; k < 2; k++) {
/* 264 */         if (GraphicEntities.get(k) != null) {
/* 265 */           this.batchy.draw((TextureRegion)GraphicEntities.get(k), 550.0F, j, 100.0F, 200.0F);
/*     */         }
/* 267 */         j += 180;
/*     */       } 
/* 269 */       j = 190;
/* 270 */       for (k = 2; k < 4; k++) {
/* 271 */         if (GraphicEntities.get(k) != null) {
/* 272 */           this.batchy.draw((TextureRegion)GraphicEntities.get(k), 750.0F, j, 100.0F, 200.0F);
/*     */         }
/* 274 */         j += 180;
/*     */       } 
/* 276 */       if (GraphicEntities.get(GraphicEntities.size - 1) != null) {
/* 277 */         this.batchy.draw((TextureRegion)GraphicEntities.get(GraphicEntities.size - 1), 100.0F, 300.0F, -100.0F, 200.0F);
/*     */       }
/* 279 */       this.batchy.end();
/* 280 */       this.batchy.dispose();
/* 281 */       this.stage.act(delta);
/* 282 */       this.stage.draw();
/*     */       
/*     */       return;
/*     */     } 
/* 286 */     int Y = 10;
/* 287 */     this.batchy = new SpriteBatch();
/*     */     
/* 289 */     this.batchy.begin();
/* 290 */     this.batchy.draw(this.text, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT); int i;
/* 291 */     for (i = 0; i < 2; i++) {
/* 292 */       if (GraphicEntities.get(i) != null) {
/* 293 */         this.batchy.draw((TextureRegion)GraphicEntities.get(i), 550.0F, Y, 100.0F, 200.0F);
/*     */       }
/* 295 */       Y += 180;
/*     */     } 
/* 297 */     Y = 190;
/* 298 */     for (i = 2; i < 4; i++) {
/* 299 */       if (GraphicEntities.get(i) != null) {
/* 300 */         this.batchy.draw((TextureRegion)GraphicEntities.get(i), 750.0F, Y, 100.0F, 200.0F);
/*     */       }
/* 302 */       Y += 180;
/*     */     } 
/* 304 */     Y = 400;
/* 305 */     for (i = 4; i < GraphicEntities.size - 1; i++) {
/* 306 */       if (GraphicEntities.get(i) != null) {
/* 307 */         this.batchy.draw((TextureRegion)GraphicEntities.get(i), 200.0F, Y, 100.0F, 200.0F);
/* 308 */         Y -= 200;
/*     */       } 
/*     */     } 
/* 311 */     if (GraphicEntities.get(GraphicEntities.size - 1) != null) {
/* 312 */       this.batchy.draw((TextureRegion)GraphicEntities.get(GraphicEntities.size - 1), 30.0F, 200.0F, 100.0F, 200.0F);
/*     */     }
/* 314 */     this.batchy.end();
/* 315 */     this.batchy.dispose();
/* 316 */     this.stage.act(delta);
/* 317 */     this.stage.draw();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resume() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(float delta) {
/* 332 */     comcontroller.keyDown();
/*     */     
/* 334 */     if (Fight.FightIsOver() || Fight.FightIsOver) {
/* 335 */       FightThread.onPause();
/*     */ 
/*     */       
/* 338 */       if (Fight.AlliesHP <= 0) {
/* 339 */         DarkCave.music.finalbosstheme.stop();
/* 340 */         DarkCave.music.battletheme.stop();
/* 341 */         DarkCave.music.circolarotheme.stop();
/* 342 */         DarkCave.music.dragontheme.stop();
/* 343 */         if (Gdx.input.isKeyJustPressed(52)) {
/* 344 */           this.game.gsm.doTransition(GameScreenManager.STATE.GAMEOVER);
/* 345 */           if (PlayerController.isDragonInteracted) {
/* 346 */             PlayerController.isDragonInteracted = false;
/*     */           }
/* 348 */           if (PlayerController.isCircoInteracted) {
/* 349 */             PlayerController.isCircoInteracted = false;
/*     */           }
/* 351 */           if (PlayerController.isDragonInteracted) {
/* 352 */             PlayerController.isDragonInteracted = false;
/*     */           }
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 358 */         DarkCave.music.dragontheme.stop();
/* 359 */         DarkCave.music.circolarotheme.stop();
/* 360 */         DarkCave.music.finalbosstheme.stop();
/* 361 */         DarkCave.music.battletheme.stop();
/* 362 */         DarkCave.music.victorytheme.play();
/* 363 */         if (Gdx.input.isKeyJustPressed(52)) {
/* 364 */           DarkCave.music.victorytheme.stop();
/* 365 */           if (PlayerController.isRuxollInteracted) {
/* 366 */             this.game.gsm.doTransition(GameScreenManager.STATE.VICTORY);
/*     */           } else {
/* 368 */             AlliesParameters.getWarrior().UpdateCurrentHP((CombatEntityParameters)Fight.Entities.get(0));
/* 369 */             AlliesParameters.getWarrior().UpdateCurrentMP((CombatEntityParameters)Fight.Entities.get(0));
/* 370 */             AlliesParameters.getKnight().UpdateCurrentHP((CombatEntityParameters)Fight.Entities.get(1));
/* 371 */             AlliesParameters.getKnight().UpdateCurrentMP((CombatEntityParameters)Fight.Entities.get(1));
/* 372 */             AlliesParameters.getArcher().UpdateCurrentHP((CombatEntityParameters)Fight.Entities.get(2));
/* 373 */             AlliesParameters.getArcher().UpdateCurrentMP((CombatEntityParameters)Fight.Entities.get(2));
/* 374 */             AlliesParameters.getMage().UpdateCurrentHP((CombatEntityParameters)Fight.Entities.get(3));
/* 375 */             AlliesParameters.getMage().UpdateCurrentMP((CombatEntityParameters)Fight.Entities.get(3));
/* 376 */             this.game.gsm.doTransition(this.game.gsm.getPrevState());
/* 377 */             if (PlayerController.isDragonInteracted) {
/* 378 */               PlayerController.isDragonInteracted = false;
/*     */             }
/* 380 */             if (PlayerController.isCircoInteracted) {
/* 381 */               PlayerController.isCircoInteracted = false;
/*     */             }
/* 383 */             if (PlayerController.isDragonInteracted)
/* 384 */               PlayerController.isDragonInteracted = false; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     int i;
/* 390 */     for (i = 0; i < Fight.Entities.size; i++) {
/* 391 */       if (((CombatEntityParameters)Fight.Entities.get(i)).isDead())
/*     */       {
/* 393 */         ((Entity)GraphicEntities.get(i)).current = Entity.STATE.DYING;
/*     */       }
/*     */     } 
/*     */     
/* 397 */     for (i = 0; i < GraphicEntities.size; i++) {
/* 398 */       if (GraphicEntities.get(i) != null)
/*     */       {
/* 400 */         ((Entity)GraphicEntities.get(i)).update(delta);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void screenChange() {}
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\CombatScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */