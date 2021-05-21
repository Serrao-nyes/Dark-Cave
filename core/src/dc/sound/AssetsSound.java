/*    */ package dc.sound;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.audio.Sound;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AssetsSound
/*    */   implements Disposable
/*    */ {
/* 20 */   public final Sound swordeffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/swordeffect.mp3"));
/* 21 */   public final Sound arroweffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/arroweffect.mp3"));
/* 22 */   public final Sound battleeffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/battleeffect.mp3"));
/* 23 */   public final Sound hiteffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/hiteffect.ogg"));
/* 24 */   public final Sound boeffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/boeffect.mp3"));
/* 25 */   public final Sound staffeffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/staffeffect.mp3"));
/* 26 */   public final Sound blackmagiceffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/blackmagiceffect.ogg"));
/* 27 */   public final Sound whitemagiceffect = Gdx.audio.newSound(Gdx.files.internal("Sounds/whitemagiceffect.mp3"));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 33 */     this.swordeffect.dispose();
/* 34 */     this.arroweffect.dispose();
/* 35 */     this.battleeffect.dispose();
/* 36 */     this.hiteffect.dispose();
/* 37 */     this.boeffect.dispose();
/* 38 */     this.staffeffect.dispose();
/* 39 */     this.blackmagiceffect.dispose();
/* 40 */     this.whitemagiceffect.dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\sound\AssetsSound.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */