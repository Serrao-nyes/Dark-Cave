/*    */ package dc.sound;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.audio.Music;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import dc.settings.Constans;
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
/*    */ 
/*    */ public class AssetsMusic
/*    */   implements Disposable
/*    */ {
/* 22 */   public final Music maintheme = Gdx.audio.newMusic(Gdx.files.internal("Music/maintheme.mp3"));
/* 23 */   public final Music battletheme = Gdx.audio.newMusic(Gdx.files.internal("Music/battletheme.mp3"));
/* 24 */   public final Music cavetheme = Gdx.audio.newMusic(Gdx.files.internal("Music/cavetheme.mp3"));
/* 25 */   public final Music hubtheme = Gdx.audio.newMusic(Gdx.files.internal("Music/hubtheme.mp3"));
/* 26 */   public final Music gameover = Gdx.audio.newMusic(Gdx.files.internal("Music/gameover.mp3"));
/* 27 */   public final Music victorytheme = Gdx.audio.newMusic(Gdx.files.internal("Music/victorytheme.mp3"));
/* 28 */   public final Music circolarotheme = Gdx.audio.newMusic(Gdx.files.internal("Music/circolarotheme.mp3"));
/* 29 */   public final Music dragontheme = Gdx.audio.newMusic(Gdx.files.internal("Music/dragontheme.mp3"));
/* 30 */   public final Music finalvictorytheme = Gdx.audio.newMusic(Gdx.files.internal("Music/finalvictorytheme.mp3"));
/* 31 */   public final Music finalbosstheme = Gdx.audio.newMusic(Gdx.files.internal("Music/finalbosstheme.mp3"));
/*    */ 
/*    */   
/*    */   public void updateVolume() {
/* 35 */     this.maintheme.setVolume(Constans.MUSICVOLUME);
/* 36 */     this.battletheme.setVolume(Constans.MUSICVOLUME);
/* 37 */     this.cavetheme.setVolume(Constans.MUSICVOLUME);
/* 38 */     this.hubtheme.setVolume(Constans.MUSICVOLUME);
/* 39 */     this.gameover.setVolume(Constans.MUSICVOLUME);
/* 40 */     this.victorytheme.setVolume(Constans.MUSICVOLUME);
/* 41 */     this.circolarotheme.setVolume(Constans.MUSICVOLUME);
/* 42 */     this.finalvictorytheme.setVolume(Constans.MUSICVOLUME);
/* 43 */     this.finalbosstheme.setVolume(Constans.MUSICVOLUME);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 48 */     this.maintheme.dispose();
/* 49 */     this.battletheme.dispose();
/* 50 */     this.cavetheme.dispose();
/* 51 */     this.hubtheme.dispose();
/* 52 */     this.gameover.dispose();
/* 53 */     this.victorytheme.dispose();
/* 54 */     this.circolarotheme.dispose();
/* 55 */     this.finalvictorytheme.dispose();
/* 56 */     this.finalbosstheme.dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\sound\AssetsMusic.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */