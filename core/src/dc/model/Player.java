package dc.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import dc.game.DarkCave;
import dc.settings.Constans;

/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
/*     */ import com.badlogic.gdx.maps.objects.RectangleMapObject;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMap;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*     */ import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;

import dc.game.DarkCave;
/*     */ import dc.parameters.AlliesParameters;
/*     */ 
/*     */ public class Player extends Sprite {
/*     */   public DarkCave game;
/*     */   public static State current;
/*     */   public static State previous;
/*     */   private Texture text;
/*     */   private TextureRegion[] region;
/*     */   private TextureRegion[][] matrix;
/*     */   private float timer;
/*     */   private Animation UpWalk;
/*     */   private Animation DownWalk;
/*     */   private Animation LeftWalk;
/*     */   
/*     */   public enum State {
/*  26 */     UP, DOWN, LEFT, RIGHT, STANDING;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   public static float spdmv = 0.0F;
/*  42 */   public static int walkspeed = 130;
/*     */   
/*     */   public boolean RightWalk = false;
/*     */   
/*     */   public boolean RightStand = false;
/*  47 */   public static TextureRegion region2 = new TextureRegion();
/*     */   
/*     */   public TiledMap map;
/*     */   public MapObjects wall;
/*     */   public MapObjects objects;
/*     */   public MapObjects doors;
/*     */   private Rectangle playerRect;
/*     */   private String object;
/*     */   
/*     */   private void setText(String Leader) {
/*  57 */     this.text = new Texture(Leader);
/*     */   }
/*     */   
/*     */   public void changeLeader() {
/*  61 */     AlliesParameters.getInstance(); if (AlliesParameters.getWarrior().isDead()) {
/*     */       
/*  63 */       setText("Sprite/Party/Pesmerga/PesmergaIdle.png");
/*  64 */       this.text.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
/*  65 */       this.matrix = TextureRegion.split(this.text, this.text.getWidth() / 3, this.text.getHeight() / 3);
/*     */       
/*  67 */       this.region = new TextureRegion[9];
/*     */       
/*  69 */       int index = 0;
/*  70 */       for (int i = 0; i < 3; i++) {
/*     */         
/*  72 */         for (int k = 0; k < 3; k++) {
/*  73 */           this.region[index] = this.matrix[i][k];
/*  74 */           index++;
/*     */         } 
/*     */       } 
/*  77 */       Array<TextureRegion> AnArray = new Array(); int j;
/*  78 */       for (j = 0; j < 3; j++) {
/*  79 */         AnArray.add(this.region[j]);
/*     */       }
/*  81 */       this.DownWalk = new Animation(0.125F, AnArray);
/*  82 */       AnArray.clear();
/*  83 */       for (j = 3; j < 6; j++) {
/*  84 */         AnArray.add(this.region[j]);
/*     */       }
/*  86 */       this.UpWalk = new Animation(0.125F, AnArray);
/*  87 */       AnArray.clear();
/*  88 */       for (j = 6; j < 9; j++) {
/*  89 */         AnArray.add(this.region[j]);
/*     */       }
/*  91 */       this.LeftWalk = new Animation(0.125F, AnArray);
/*  92 */       AnArray.clear();
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  99 */       setText("Sprite/Party/Flik/FlikIdle.png");
/* 100 */       this.text.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
/* 101 */       this.matrix = TextureRegion.split(this.text, this.text.getWidth() / 3, this.text.getHeight() / 3);
/*     */       
/* 103 */       this.region = new TextureRegion[9];
/*     */       
/* 105 */       int index = 0;
/* 106 */       for (int i = 0; i < 3; i++) {
/*     */         
/* 108 */         for (int k = 0; k < 3; k++) {
/* 109 */           this.region[index] = this.matrix[i][k];
/* 110 */           index++;
/*     */         } 
/*     */       } 
/* 113 */       Array<TextureRegion> AnArray = new Array(); int j;
/* 114 */       for (j = 0; j < 3; j++) {
/* 115 */         AnArray.add(this.region[j]);
/*     */       }
/* 117 */       this.DownWalk = new Animation(0.125F, AnArray);
/* 118 */       AnArray.clear();
/* 119 */       for (j = 3; j < 6; j++) {
/* 120 */         AnArray.add(this.region[j]);
/*     */       }
/* 122 */       this.UpWalk = new Animation(0.125F, AnArray);
/* 123 */       AnArray.clear();
/* 124 */       for (j = 6; j < 9; j++) {
/* 125 */         AnArray.add(this.region[j]);
/*     */       }
/* 127 */       this.LeftWalk = new Animation(0.125F, AnArray);
/* 128 */       AnArray.clear();
/*     */     } 
/*     */ 
/*     */     
/* 132 */     AlliesParameters.getInstance(); if (AlliesParameters.getWarrior().isDead()) { AlliesParameters.getInstance(); if (AlliesParameters.getKnight().isDead()) {
/*     */         
/* 134 */         setText("Sprite/Party/Ted/TedIdle.png");
/* 135 */         this.text.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
/* 136 */         this.matrix = TextureRegion.split(this.text, this.text.getWidth() / 3, this.text.getHeight() / 3);
/*     */         
/* 138 */         this.region = new TextureRegion[9];
/*     */         
/* 140 */         int index = 0;
/* 141 */         for (int i = 0; i < 3; i++) {
/*     */           
/* 143 */           for (int k = 0; k < 3; k++) {
/* 144 */             this.region[index] = this.matrix[i][k];
/* 145 */             index++;
/*     */           } 
/*     */         } 
/* 148 */         Array<TextureRegion> AnArray = new Array(); int j;
/* 149 */         for (j = 0; j < 3; j++) {
/* 150 */           AnArray.add(this.region[j]);
/*     */         }
/* 152 */         this.DownWalk = new Animation(0.125F, AnArray);
/* 153 */         AnArray.clear();
/* 154 */         for (j = 3; j < 6; j++) {
/* 155 */           AnArray.add(this.region[j]);
/*     */         }
/* 157 */         this.UpWalk = new Animation(0.125F, AnArray);
/* 158 */         AnArray.clear();
/* 159 */         for (j = 6; j < 9; j++) {
/* 160 */           AnArray.add(this.region[j]);
/*     */         }
/* 162 */         this.LeftWalk = new Animation(0.125F, AnArray);
/* 163 */         AnArray.clear();
/*     */       }  }
/*     */     
/* 166 */     AlliesParameters.getInstance(); if (AlliesParameters.getWarrior().isDead()) { AlliesParameters.getInstance(); if (AlliesParameters.getKnight().isDead()) { AlliesParameters.getInstance(); if (AlliesParameters.getArcher().isDead()) {
/*     */           
/* 168 */           setText("Sprite/Party/Lotte/LotteIdle.png");
/* 169 */           this.text.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
/* 170 */           this.matrix = TextureRegion.split(this.text, this.text.getWidth() / 3, this.text.getHeight() / 3);
/*     */           
/* 172 */           this.region = new TextureRegion[9];
/*     */           
/* 174 */           int index = 0;
/* 175 */           for (int i = 0; i < 3; i++) {
/*     */             
/* 177 */             for (int k = 0; k < 3; k++) {
/* 178 */               this.region[index] = this.matrix[i][k];
/* 179 */               index++;
/*     */             } 
/*     */           } 
/* 182 */           Array<TextureRegion> AnArray = new Array(); int j;
/* 183 */           for (j = 0; j < 3; j++) {
/* 184 */             AnArray.add(this.region[j]);
/*     */           }
/* 186 */           this.DownWalk = new Animation(0.125F, AnArray);
/* 187 */           AnArray.clear();
/* 188 */           for (j = 3; j < 6; j++) {
/* 189 */             AnArray.add(this.region[j]);
/*     */           }
/* 191 */           this.UpWalk = new Animation(0.125F, AnArray);
/* 192 */           AnArray.clear();
/* 193 */           for (j = 6; j < 9; j++) {
/* 194 */             AnArray.add(this.region[j]);
/*     */           }
/* 196 */           this.LeftWalk = new Animation(0.125F, AnArray);
/* 197 */           AnArray.clear();
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   public Player(TiledMap map, DarkCave game) {
/* 203 */     this.game = game;
/*     */     
/* 205 */     this.timer = 0.0F;
/* 206 */     this.text = new Texture("Sprite/Party/Flik/FlikIdle.png");
/* 207 */     this.text.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
/* 208 */     this.matrix = TextureRegion.split(this.text, this.text.getWidth() / 3, this.text.getHeight() / 3);
/*     */     
/* 210 */     this.region = new TextureRegion[9];
/*     */     
/* 212 */     int index = 0;
/* 213 */     for (int i = 0; i < 3; i++) {
/*     */       
/* 215 */       for (int k = 0; k < 3; k++) {
/* 216 */         this.region[index] = this.matrix[i][k];
/* 217 */         index++;
/*     */       } 
/*     */     } 
/*     */     
/* 221 */     current = State.UP;
/* 222 */     previous = State.UP;
/*     */     
/* 224 */     Array<TextureRegion> AnArray = new Array(); int j;
/* 225 */     for (j = 0; j < 3; j++) {
/* 226 */       AnArray.add(this.region[j]);
/*     */     }
/* 228 */     this.DownWalk = new Animation(0.125F, AnArray);
/* 229 */     AnArray.clear();
/* 230 */     for (j = 3; j < 6; j++) {
/* 231 */       AnArray.add(this.region[j]);
/*     */     }
/* 233 */     this.UpWalk = new Animation(0.125F, AnArray);
/* 234 */     AnArray.clear();
/* 235 */     for (j = 6; j < 9; j++) {
/* 236 */       AnArray.add(this.region[j]);
/*     */     }
/* 238 */     this.LeftWalk = new Animation(0.125F, AnArray);
/* 239 */     AnArray.clear();
/*     */     
/* 241 */     setSize(Constans.PLAYER_SCALE_WIDTH, Constans.PLAYER_SCALE_HEIGHT);
/* 242 */     setOrigin(getWidth() / 2.0F, getHeight() / 2.0F);
/*     */     
/* 244 */     this.map = map;
/*     */     
/* 246 */     this.wall = map.getLayers().get("Wall").getObjects();
/* 247 */     this.doors = map.getLayers().get("Door").getObjects();
/* 248 */     this.objects = map.getLayers().get("Object").getObjects();
/*     */     
/* 250 */     this.playerRect = new Rectangle();
/*     */   }
/*     */   public void update(float deltaTime) {
/* 253 */     setRegion(getFrame(deltaTime));
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureRegion getFrame(float deltaTime) {
/* 258 */     if (spdmv == 0.0F) {
/* 259 */       current = State.STANDING;
/*     */     }
/*     */     
/* 262 */     switch (current) {
/*     */       case DOWN:
/* 264 */         this.RightStand = false;
/* 265 */         region2 = (TextureRegion)this.DownWalk.getKeyFrame(this.timer, true);
/*     */         break;
/*     */       
/*     */       case UP:
/* 269 */         this.RightStand = false;
/* 270 */         region2 = (TextureRegion)this.UpWalk.getKeyFrame(this.timer, true);
/*     */         break;
/*     */       
/*     */       case LEFT:
/* 274 */         this.RightStand = false;
/* 275 */         region2 = (TextureRegion)this.LeftWalk.getKeyFrame(this.timer, true);
/*     */         break;
/*     */       
/*     */       case RIGHT:
/* 279 */         this.RightStand = false;
/* 280 */         region2 = (TextureRegion)this.LeftWalk.getKeyFrame(this.timer, true);
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 286 */         if (previous == State.UP) {
/* 287 */           region2 = this.region[4]; break;
/*     */         } 
/* 289 */         if (previous == State.DOWN) {
/* 290 */           region2 = this.region[1]; break;
/*     */         } 
/* 292 */         if (previous == State.LEFT) {
/* 293 */           region2 = this.region[7]; break;
/*     */         } 
/* 295 */         if (previous == State.RIGHT) {
/*     */           
/* 297 */           this.RightStand = true;
/* 298 */           region2 = this.region[7];
/*     */         } 
/*     */         break;
/*     */     } 
/*     */     
/* 303 */     this.timer = (current == previous) ? (this.timer += deltaTime) : 0.0F;
/* 304 */     previous = current;
/* 305 */     return region2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean collision(float oldX, float oldY) {
/* 310 */     this.playerRect.set(getX(), getY(), getWidth(), 5.0F);
/* 311 */     for (RectangleMapObject rectangleObject : this.wall.getByType(RectangleMapObject.class)) {
/* 312 */       Rectangle rectangle = rectangleObject.getRectangle();
/* 313 */       if (this.playerRect.overlaps(rectangle)) {
/* 314 */         setX(oldX);
/* 315 */         setY(oldY);
/* 316 */         return true;
/*     */       } 
/*     */     } 
/* 319 */     return false;
/*     */   }
/*     */   
/*     */   public String doTransictionDoor() {
/* 323 */     this.playerRect.set(getX(), getY(), getWidth(), 5.0F);
/* 324 */     for (int x = 0; x < this.doors.getCount(); x++) {
/* 325 */       if (this.doors.get(x) instanceof RectangleMapObject) {
/* 326 */         Rectangle rectangle = ((RectangleMapObject)this.doors.get(x)).getRectangle();
/* 327 */         if (this.playerRect.overlaps(rectangle)) {
/* 328 */           return this.doors.get(x).getName();
/*     */         }
/*     */       } 
/*     */     } 
/* 332 */     return "";
/*     */   }
/*     */   
/*     */   public boolean isNearObject() {
/* 336 */     this.playerRect.set(getX(), getY(), getWidth(), 5.0F);
/* 337 */     for (int x = 0; x < this.objects.getCount(); x++) {
/* 338 */       if (this.objects.get(x) instanceof RectangleMapObject) {
/* 339 */         Rectangle rectangle = ((RectangleMapObject)this.objects.get(x)).getRectangle();
/* 340 */         if (this.playerRect.overlaps(rectangle)) {
/* 341 */           setObject(this.objects.get(x).getName());
/* 342 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 346 */     return false;
/*     */   }
/*     */   
/*     */   public void take(String object, final int x) {
	map.getLayers().get(object).setVisible(false);
	map.getLayers().get("Object").getObjects().remove(map.getLayers().get("Object").getObjects().get(object));
	game.im.addCount(game.im.getITM(object), x);

	Timer.schedule(new Task() {
		final Dialog dialog = new Dialog("", game.gsm.getPrevScreen().skin) {

			{
				text("Hai raccolto: " + x + " " + getObject());
			}

		}.show(game.gsm.getPrevScreen().stage);

		{
			dialog.setPosition(430, 600);
		}

		@Override
		public void run() {
			dialog.hide();
		}

	}, 2);
}
/*     */   
/*     */   public void openGate(String gate) {
/* 376 */     this.map.getLayers().get(gate).setVisible(false);
/* 377 */     this.map.getLayers().get("Object").getObjects().remove(this.map.getLayers().get("Object").getObjects().get(gate));
/* 378 */     this.map.getLayers().get("Wall").getObjects().remove(this.map.getLayers().get("Wall").getObjects().get(gate));
/*     */   }
/*     */   
/*     */   public void clear(String gate) {
/* 382 */     this.map.getLayers().get("Object").getObjects().remove(this.map.getLayers().get("Object").getObjects().get(gate));
/* 383 */     this.map.getLayers().get("Wall").getObjects().remove(this.map.getLayers().get("Wall").getObjects().get(gate));
/*     */   }
/*     */   
/*     */   public void setObject(String object) {
/* 387 */     this.object = object;
/*     */   }
/*     */   
/*     */   public String getObject() {
/* 391 */     return this.object;
/*     */   }
/*     */   
/*     */   public void setSpawn(float x, float y) {
/* 395 */     setX(x);
/* 396 */     setY(y);
/*     */   }
/*     */   
/*     */   public void setState(State current) {
/* 400 */     Player.current = current;
/*     */   }
/*     */   
/*     */   public float getSpdmv() {
/* 404 */     return spdmv;
/*     */   }
/*     */   
/*     */   public void setSpdmv(float spdmv) {
/* 408 */     Player.spdmv = spdmv;
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\model\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */