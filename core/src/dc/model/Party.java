package dc.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import dc.model.Entity;
import dc.settings.Constans;
/*     */ 
/*     */ public class Party
/*     */ {
/*  15 */   private static Party instance = null;
/*     */   
/*     */   public static Party getInstance() {
/*  18 */     if (instance == null) {
/*  19 */       instance = new Party();
/*     */     }
/*  21 */     return instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public Entity CreateEntity(int ID, Entity entity) {
/*  26 */     switch (ID) {
/*     */       case 0:
/*  28 */         entity = new Flik();
/*  29 */         return entity;
/*     */       case 1:
/*  31 */         entity = new Pesmerga();
/*  32 */         return entity;
/*     */       case 2:
/*  34 */         entity = new Ted();
/*  35 */         return entity;
/*     */       case 3:
/*  37 */         entity = new Lotte();
/*  38 */         return entity;
/*     */     } 
/*  40 */     return null;
/*     */   }
/*     */   
/*     */   public class Flik
/*     */     extends Entity
/*     */   {
/*  46 */     private final int ID = 0;
/*     */     private TextureRegion Idle;
/*     */     private TextureRegion Attack;
/*     */     private TextureRegion Attack2;
/*     */     private TextureRegion Dying2;
/*     */     private TextureRegion Dying3;
/*     */     private TextureRegion Hurting;
/*     */     private TextureRegion Interaction;
/*     */     private TextureRegion Interaction2;
/*     */     private TextureRegion region;
/*     */     private TextureRegion[] AttackRegion;
/*     */     private TextureRegion[] DyingRegion;
/*     */     private TextureRegion[] InteractionRegion;
/*     */     private float timer;
/*     */     private Animation Dying;
/*     */     private Animation Attacking;
/*     */     private Animation InteractionAnimation;
/*     */     
/*     */     public Flik() {
/*  65 */       this.current = Entity.STATE.IDLE;
/*  66 */       this.previous = Entity.STATE.IDLE;
/*  67 */       this.timer = 0.0F;
/*  68 */       this.Idle = new TextureRegion(new Texture("Sprite/Party/Flik/AttackIdle.png"));
/*  69 */       this.Attack = new TextureRegion(new Texture("Sprite/Party/Flik/attack.png"));
/*  70 */       this.Attack2 = new TextureRegion(new Texture("Sprite/Party/Flik/attack2.png"));
/*  71 */       this.Dying2 = new TextureRegion(new Texture("Sprite/Party/Flik/dying2.png"));
/*  72 */       this.Dying3 = new TextureRegion(new Texture("Sprite/Party/Flik/dying3.png"));
/*  73 */       this.Hurting = new TextureRegion(new Texture("Sprite/Party/Flik/hurting.png"));
/*  74 */       this.Interaction = new TextureRegion(new Texture("Sprite/Party/Flik/interaction.png"));
/*  75 */       this.Interaction2 = new TextureRegion(new Texture("Sprite/Party/Flik/interaction2.png"));
/*     */       
/*  77 */       this.region = new TextureRegion();
/*  78 */       this.AttackRegion = new TextureRegion[2];
/*  79 */       this.AttackRegion[0] = this.Attack;
/*  80 */       this.AttackRegion[1] = this.Attack2;
/*  81 */       this.DyingRegion = new TextureRegion[3];
/*  82 */       this.DyingRegion[0] = this.Idle;
/*  83 */       this.DyingRegion[1] = this.Dying2;
/*  84 */       this.DyingRegion[2] = this.Dying3;
/*  85 */       this.InteractionRegion = new TextureRegion[2];
/*  86 */       this.InteractionRegion[0] = this.Interaction;
/*  87 */       this.InteractionRegion[1] = this.Interaction2;
/*     */       
/*  89 */       this.Dying = new Animation(0.7F, (Object[])this.DyingRegion);
/*  90 */       this.Attacking = new Animation(0.15F, (Object[])this.AttackRegion);
/*  91 */       this.InteractionAnimation = new Animation(0.15F, (Object[])this.InteractionRegion);
/*     */       
/*  93 */       setOrigin(getWidth() / 2.0F, getHeight() / 2.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(float deltaTime) {
/* 100 */       setRegion(getFrame(deltaTime));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TextureRegion getFrame(float deltaTime) {
/* 107 */       switch (this.current) {
/*     */         
/*     */         default:
/* 110 */           this.region = this.Idle;
/*     */           break;
/*     */         case ATTACKING:
/* 113 */           this.region = (TextureRegion)this.Attacking.getKeyFrame(this.timer, false);
/*     */           break;
/*     */ 
/*     */         
/*     */         case DYING:
/* 118 */           this.region = (TextureRegion)this.Dying.getKeyFrame(this.timer, false);
/*     */           break;
/*     */         
/*     */         case HURTING:
/* 122 */           this.region = this.Hurting;
/*     */           break;
/*     */         
/*     */         case INTERACTION:
/* 126 */           this.region = (TextureRegion)this.InteractionAnimation.getKeyFrame(this.timer, false);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 131 */       this.timer = (this.current == this.previous) ? (this.timer += deltaTime) : 0.0F;
/* 132 */       this.previous = this.current;
/* 133 */       return this.region;
/*     */     }
/*     */     
/*     */     public int getID() {
/* 137 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Pesmerga
/*     */     extends Entity {
/* 143 */     private final int ID = 0;
/*     */     private TextureRegion Idle;
/*     */     private TextureRegion Attack;
/*     */     private TextureRegion Attack2;
/*     */     private TextureRegion Dying2;
/*     */     private TextureRegion Dying3;
/*     */     private TextureRegion Hurting;
/*     */     private TextureRegion Interaction;
/*     */     private TextureRegion Interaction2;
/*     */     private TextureRegion region;
/*     */     private TextureRegion[] AttackRegion;
/*     */     private TextureRegion[] DyingRegion;
/*     */     private TextureRegion[] InteractionRegion;
/*     */     private float timer;
/*     */     private Animation Dying;
/*     */     private Animation Attacking;
/*     */     private Animation InteractionAnimation;
/*     */     
/*     */     public Pesmerga() {
/* 162 */       this.current = Entity.STATE.IDLE;
/* 163 */       this.previous = Entity.STATE.IDLE;
/* 164 */       this.timer = 0.0F;
/* 165 */       this.Idle = new TextureRegion(new Texture("Sprite/Party/Pesmerga/AttackIdle.png"));
/* 166 */       this.Attack = new TextureRegion(new Texture("Sprite/Party/Pesmerga/attack.png"));
/* 167 */       this.Attack2 = new TextureRegion(new Texture("Sprite/Party/Pesmerga/attack2.png"));
/* 168 */       this.Dying2 = new TextureRegion(new Texture("Sprite/Party/Pesmerga/dying2.png"));
/* 169 */       this.Dying3 = new TextureRegion(new Texture("Sprite/Party/Pesmerga/dying3.png"));
/* 170 */       this.Hurting = new TextureRegion(new Texture("Sprite/Party/Pesmerga/hurting.png"));
/* 171 */       this.Interaction = new TextureRegion(new Texture("Sprite/Party/Pesmerga/interaction.png"));
/* 172 */       this.Interaction2 = new TextureRegion(new Texture("Sprite/Party/Pesmerga/interaction2.png"));
/*     */       
/* 174 */       this.region = new TextureRegion();
/* 175 */       this.AttackRegion = new TextureRegion[2];
/* 176 */       this.AttackRegion[0] = this.Attack;
/* 177 */       this.AttackRegion[1] = this.Attack2;
/* 178 */       this.DyingRegion = new TextureRegion[3];
/* 179 */       this.DyingRegion[0] = this.Idle;
/* 180 */       this.DyingRegion[1] = this.Dying2;
/* 181 */       this.DyingRegion[2] = this.Dying3;
/* 182 */       this.InteractionRegion = new TextureRegion[2];
/* 183 */       this.InteractionRegion[0] = this.Interaction;
/* 184 */       this.InteractionRegion[1] = this.Interaction2;
/*     */       
/* 186 */       this.Dying = new Animation(0.7F, (Object[])this.DyingRegion);
/* 187 */       this.Attacking = new Animation(0.15F, (Object[])this.AttackRegion);
/* 188 */       this.InteractionAnimation = new Animation(0.15F, (Object[])this.InteractionRegion);
/*     */       
/* 190 */       setOrigin(getWidth() / 2.0F, getHeight() / 2.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(float deltaTime) {
/* 197 */       setRegion(getFrame(deltaTime));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TextureRegion getFrame(float deltaTime) {
/* 204 */       switch (this.current) {
/*     */         
/*     */         default:
/* 207 */           this.region = this.Idle;
/*     */           break;
/*     */         case ATTACKING:
/* 210 */           this.region = (TextureRegion)this.Attacking.getKeyFrame(this.timer, false);
/*     */           break;
/*     */ 
/*     */         
/*     */         case DYING:
/* 215 */           this.region = (TextureRegion)this.Dying.getKeyFrame(this.timer, false);
/*     */           break;
/*     */         
/*     */         case HURTING:
/* 219 */           this.region = this.Hurting;
/*     */           break;
/*     */         
/*     */         case INTERACTION:
/* 223 */           this.region = (TextureRegion)this.InteractionAnimation.getKeyFrame(this.timer, false);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 228 */       this.timer = (this.current == this.previous) ? (this.timer += deltaTime) : 0.0F;
/* 229 */       this.previous = this.current;
/* 230 */       return this.region;
/*     */     }
/*     */     
/*     */     public int getID() {
/* 234 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Ted
/*     */     extends Entity {
/* 240 */     private final int ID = 0;
/*     */     private TextureRegion Idle;
/*     */     private TextureRegion Attack;
/*     */     private TextureRegion Attack2;
/*     */     private TextureRegion Dying2;
/*     */     private TextureRegion Dying3;
/*     */     private TextureRegion Hurting;
/*     */     private TextureRegion Interaction;
/*     */     private TextureRegion Interaction2;
/*     */     private TextureRegion Interaction3;
/*     */     private TextureRegion region;
/*     */     private TextureRegion[] AttackRegion;
/*     */     private TextureRegion[] DyingRegion;
/*     */     private TextureRegion[] InteractionRegion;
/*     */     private float timer;
/*     */     private Animation Dying;
/*     */     private Animation Attacking;
/*     */     private Animation InteractionAnimation;
/*     */     
/*     */     public Ted() {
/* 260 */       this.current = Entity.STATE.IDLE;
/* 261 */       this.previous = Entity.STATE.IDLE;
/* 262 */       this.timer = 0.0F;
/* 263 */       this.Idle = new TextureRegion(new Texture("Sprite/Party/Ted/AttackIdle.png"));
/* 264 */       this.Attack = new TextureRegion(new Texture("Sprite/Party/Ted/attack.png"));
/* 265 */       this.Attack2 = new TextureRegion(new Texture("Sprite/Party/Ted/attack2.png"));
/* 266 */       this.Dying2 = new TextureRegion(new Texture("Sprite/Party/Ted/dying2.png"));
/* 267 */       this.Dying3 = new TextureRegion(new Texture("Sprite/Party/Ted/dying3.png"));
/* 268 */       this.Hurting = new TextureRegion(new Texture("Sprite/Party/Ted/hurting.png"));
/* 269 */       this.Interaction = new TextureRegion(new Texture("Sprite/Party/Ted/interaction.png"));
/* 270 */       this.Interaction2 = new TextureRegion(new Texture("Sprite/Party/Ted/interaction2.png"));
/* 271 */       this.Interaction3 = new TextureRegion(new Texture("Sprite/Party/Ted/interaction3.png"));
/* 272 */       this.region = new TextureRegion();
/* 273 */       this.AttackRegion = new TextureRegion[2];
/* 274 */       this.AttackRegion[0] = this.Attack;
/* 275 */       this.AttackRegion[1] = this.Attack2;
/* 276 */       this.DyingRegion = new TextureRegion[3];
/* 277 */       this.DyingRegion[0] = this.Idle;
/* 278 */       this.DyingRegion[1] = this.Dying2;
/* 279 */       this.DyingRegion[2] = this.Dying3;
/* 280 */       this.InteractionRegion = new TextureRegion[3];
/* 281 */       this.InteractionRegion[0] = this.Interaction;
/* 282 */       this.InteractionRegion[1] = this.Interaction2;
/* 283 */       this.InteractionRegion[2] = this.Interaction3;
/* 284 */       this.Dying = new Animation(0.7F, (Object[])this.DyingRegion);
/* 285 */       this.Attacking = new Animation(0.15F, (Object[])this.AttackRegion);
/* 286 */       this.InteractionAnimation = new Animation(0.15F, (Object[])this.InteractionRegion);
/*     */       
/* 288 */       setOrigin(getWidth() / 2.0F, getHeight() / 2.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(float deltaTime) {
/* 295 */       setRegion(getFrame(deltaTime));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TextureRegion getFrame(float deltaTime) {
/* 302 */       switch (this.current) {
/*     */         
/*     */         default:
/* 305 */           this.region = this.Idle;
/*     */           break;
/*     */         case ATTACKING:
/* 308 */           this.region = (TextureRegion)this.Attacking.getKeyFrame(this.timer, false);
/*     */           break;
/*     */ 
/*     */         
/*     */         case DYING:
/* 313 */           this.region = (TextureRegion)this.Dying.getKeyFrame(this.timer, false);
/*     */           break;
/*     */         
/*     */         case HURTING:
/* 317 */           this.region = this.Hurting;
/*     */           break;
/*     */         
/*     */         case INTERACTION:
/* 321 */           this.region = (TextureRegion)this.InteractionAnimation.getKeyFrame(this.timer, false);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 326 */       this.timer = (this.current == this.previous) ? (this.timer += deltaTime) : 0.0F;
/* 327 */       this.previous = this.current;
/* 328 */       return this.region;
/*     */     }
/*     */     
/*     */     public int getID() {
/* 332 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Lotte
/*     */     extends Entity {
/* 338 */     private final int ID = 0;
/*     */     
/*     */     private TextureRegion Idle;
/*     */     private TextureRegion Attack;
/*     */     private TextureRegion Attack2;
/*     */     private TextureRegion Dying2;
/*     */     private TextureRegion Dying3;
/*     */     private TextureRegion Hurting;
/*     */     private TextureRegion Interaction;
/*     */     private TextureRegion Interaction2;
/*     */     private TextureRegion Interaction3;
/*     */     private TextureRegion region;
/*     */     private TextureRegion[] AttackRegion;
/*     */     private TextureRegion[] DyingRegion;
/*     */     private TextureRegion[] InteractionRegion;
/*     */     private float timer;
/*     */     private Animation Dying;
/*     */     private Animation Attacking;
/*     */     private Animation InteractionAnimation;
/*     */     
/*     */     public Lotte() {
/* 359 */       this.current = Entity.STATE.IDLE;
/* 360 */       this.previous = Entity.STATE.IDLE;
/* 361 */       this.timer = 0.0F;
/* 362 */       this.Idle = new TextureRegion(new Texture("Sprite/Party/Lotte/AttackIdle.png"));
/* 363 */       this.Attack = new TextureRegion(new Texture("Sprite/Party/Lotte/attack.png"));
/* 364 */       this.Attack2 = new TextureRegion(new Texture("Sprite/Party/Lotte/attack2.png"));
/* 365 */       this.Dying2 = new TextureRegion(new Texture("Sprite/Party/Lotte/dying2.png"));
/* 366 */       this.Dying3 = new TextureRegion(new Texture("Sprite/Party/Lotte/dying3.png"));
/* 367 */       this.Hurting = new TextureRegion(new Texture("Sprite/Party/Lotte/hurting.png"));
/* 368 */       this.Interaction = new TextureRegion(new Texture("Sprite/Party/Lotte/interaction.png"));
/* 369 */       this.Interaction2 = new TextureRegion(new Texture("Sprite/Party/Lotte/interaction2.png"));
/*     */       
/* 371 */       this.region = new TextureRegion();
/* 372 */       this.AttackRegion = new TextureRegion[2];
/* 373 */       this.AttackRegion[0] = this.Attack;
/* 374 */       this.AttackRegion[1] = this.Attack2;
/* 375 */       this.DyingRegion = new TextureRegion[3];
/* 376 */       this.DyingRegion[0] = this.Idle;
/* 377 */       this.DyingRegion[1] = this.Dying3;
/* 378 */       this.DyingRegion[2] = this.Dying2;
/* 379 */       this.InteractionRegion = new TextureRegion[2];
/* 380 */       this.InteractionRegion[0] = this.Interaction;
/* 381 */       this.InteractionRegion[1] = this.Interaction2;
/*     */       
/* 383 */       this.Dying = new Animation(0.7F, (Object[])this.DyingRegion);
/* 384 */       this.Attacking = new Animation(0.15F, (Object[])this.AttackRegion);
/* 385 */       this.InteractionAnimation = new Animation(0.15F, (Object[])this.InteractionRegion);
/*     */       
/* 387 */       setOrigin(getWidth() / 2.0F, getHeight() / 2.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(float deltaTime) {
/* 394 */       setRegion(getFrame(deltaTime));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TextureRegion getFrame(float deltaTime) {
/* 401 */       switch (this.current) {
/*     */         
/*     */         default:
/* 404 */           this.region = this.Idle;
/*     */           break;
/*     */         case ATTACKING:
/* 407 */           this.region = (TextureRegion)this.Attacking.getKeyFrame(this.timer, false);
/*     */           break;
/*     */ 
/*     */         
/*     */         case DYING:
/* 412 */           this.region = (TextureRegion)this.Dying.getKeyFrame(this.timer, false);
/*     */           break;
/*     */         
/*     */         case HURTING:
/* 416 */           this.region = this.Hurting;
/*     */           break;
/*     */         
/*     */         case INTERACTION:
/* 420 */           this.region = (TextureRegion)this.InteractionAnimation.getKeyFrame(this.timer, false);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 425 */       this.timer = (this.current == this.previous) ? (this.timer += deltaTime) : 0.0F;
/* 426 */       this.previous = this.current;
/* 427 */       return this.region;
/*     */     }
/*     */     
/*     */     public int getID() {
/* 431 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\model\Party.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */