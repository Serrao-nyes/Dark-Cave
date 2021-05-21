package dc.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import dc.controller.manager.GameScreenManager.STATE;
import dc.controller.manager.InventoryManagement.ITM;
import dc.game.DarkCave;
import dc.model.Player;
import dc.model.Player.State;

import com.badlogic.gdx.Input.Keys;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerController
/*     */   extends InputAdapter
/*     */ {
/*     */   private Player player;
/*     */   private boolean isDragonDead = false;
/*     */   private boolean isCircoDead = false;
/*     */   public static boolean isDragonInteracted = false;
/*     */   public static boolean isCircoInteracted = false;
/*     */   public static boolean isRuxollInteracted = false;
/*     */   private double random;
/*  27 */   private int steps = 0;
/*     */   
/*     */   public PlayerController(Player player) {
/*  30 */     this.player = player;
/*     */   }
/*     */   
/*     */   public void Incontri() {
/*  34 */     this.random = Math.random();
/*  35 */     this.steps++;
/*  36 */     if (this.random > 0.6D && this.steps > 200) {
/*  37 */       player.game.gsm.doTransitionBattle(STATE.COMBAT);
/*  38 */       DarkCave.sounds.battleeffect.play();
/*  39 */       this.steps = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void keyDown(float deltaTime) {
/*  44 */     this.player.setSpdmv(0.0F);
/*  45 */     this.player.RightWalk = false;
/*  46 */     if (Gdx.input.isKeyPressed(19)) {
/*     */       
/*  48 */       this.player.setState(Player.State.UP);
/*  49 */       this.player.setSpdmv(walk() * deltaTime);
/*  50 */       movement(0.0F, this.player.getSpdmv());
/*     */     }
/*  52 */     else if (Gdx.input.isKeyPressed(20)) {
/*     */       
/*  54 */       this.player.setState(Player.State.DOWN);
/*  55 */       this.player.setSpdmv(walk() * deltaTime);
/*  56 */       movement(0.0F, -this.player.getSpdmv());
/*     */     }
/*  58 */     else if (Gdx.input.isKeyPressed(21)) {
/*     */       
/*  60 */       this.player.setState(Player.State.LEFT);
/*  61 */       this.player.setSpdmv(walk() * deltaTime);
/*  62 */       movement(-this.player.getSpdmv(), 0.0F);
/*     */     }
/*  64 */     else if (Gdx.input.isKeyPressed(22)) {
/*     */       
/*  66 */       this.player.setState(Player.State.RIGHT);
/*  67 */       this.player.setSpdmv(walk() * deltaTime);
/*  68 */       movement(this.player.getSpdmv(), 0.0F);
/*  69 */       this.player.RightWalk = true;
/*     */     } 
/*     */     
/*  72 */     if (this.player.isNearObject() && 
/*  73 */       Gdx.input.isKeyJustPressed(52)) {
/*  74 */       if (this.player.getObject().equals("Pozione")) {
/*  75 */         this.player.take(this.player.getObject(), 5);
/*  76 */       } else if (this.player.getObject().equals("Etere")) {
/*  77 */         this.player.take(this.player.getObject(), 3);
/*  78 */       } else if (this.player.getObject().equals("Gate")) {
/*     */         
/*  80 */         if(player.game.im.getCount(ITM.CHIAVE) >= 2)
/*  81 */         { this.player.openGate("Gate"); }
/*     */      	else
			Timer.schedule(new Task()
    {
		final Dialog dialog = new Dialog("", player.game.gsm.getPrevScreen().skin) {
			
			{
				text("La porta e' chiusa\nCi sono due serrature...\nEsploriamo i dintorni").center();
			}
			
		}.show(player.game.gsm.getPrevScreen().stage);
		
		{
			dialog.setPosition(430, 570);
			dialog.setSize(210, 150);
		}			
		
		@Override
		public void run() {
			dialog.hide();
		}
		
    }, 5);
/* 104 */       } else if (this.player.getObject().equals("Dragon")) {
/* 105 */         this.player.clear("Dragon");
/* 106 */        	player.game.gsm.doTransitionBattle(STATE.COMBAT);
/* 107 */         DarkCave.sounds.battleeffect.play();
/* 108 */         isDragonInteracted = true;
/* 109 */         this.isDragonDead = true;
/*     */       }
/* 111 */       else if (this.player.getObject().equals("Circo")) {
/* 112 */         this.player.clear("Circo");
/* 113 */         player.game.gsm.doTransitionBattle(STATE.COMBAT);
/* 114 */         DarkCave.sounds.battleeffect.play();
/* 115 */         isCircoInteracted = true;
/* 116 */         this.isCircoDead = true;
/*     */       }
/* 118 */       else if (this.player.getObject().equals("Ruxoll")) {
/* 119 */         this.player.clear("Ruxoll");
/* 120 */        player.game.gsm.doTransitionBattle(STATE.COMBAT);
/* 121 */         DarkCave.sounds.battleeffect.play();
/* 122 */         isRuxollInteracted = true;
/*     */       } else {
/*     */         
/* 125 */         this.player.take(this.player.getObject(), 1);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void movement(float x, float y) {
/* 131 */     float oldX = this.player.getX(), oldY = this.player.getY();
/* 132 */     this.player.translate(x, y);
/* 133 */     if (!this.player.collision(oldX, oldY) && 
/* 134 */       this.player.game.gsm.getPrevState() != STATE.HUB && this.player.game.gsm.getPrevState() != STATE.FINALE) {
/* 135 */       Incontri();
/*     */     }
/*     */   }
/*     */   
/*     */   private int walk() {
/* 140 */     if (Gdx.input.isKeyPressed(31)) {
/* 141 */       return Player.walkspeed * 2;
/*     */     }
/* 143 */     return Player.walkspeed;
/*     */   }
/*     */   
/*     */   public boolean isDragonDead() {
/* 147 */     return this.isDragonDead;
/*     */   }
/*     */   
/*     */   public boolean isCircoDead() {
/* 151 */     return this.isCircoDead;
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\PlayerController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */