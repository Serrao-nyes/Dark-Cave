/*    */ package dc.view;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.Screen;
/*    */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*    */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*    */ import com.badlogic.gdx.utils.viewport.ScreenViewport;
/*    */ import com.badlogic.gdx.utils.viewport.Viewport;
/*    */ import dc.game.DarkCave;
/*    */ 
/*    */ 
/*    */ public abstract class AbstractScreen
/*    */   implements Screen
/*    */ {
/*    */   protected DarkCave game;
/*    */   protected SpriteBatch batch;
/*    */   public Stage stage;
/*    */   public Skin skin;
/*    */   protected Viewport gamePort;
/*    */   public boolean paused = false;
/*    */   public boolean inv = false;
/*    */   
/*    */   public AbstractScreen(DarkCave game) {
/* 25 */     this.game = game;
/* 26 */     this.batch = new SpriteBatch();
/* 27 */     this.gamePort = (Viewport)new ScreenViewport();
/* 28 */     this.stage = new Stage();
/* 29 */     this.skin = new Skin(Gdx.files.internal("UI/terra-mother-ui.json"));
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void update(float paramFloat);
/*    */   
/*    */   public void render(float delta) {
/* 36 */     update(delta);
/*    */     
/* 38 */     Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
/* 39 */     Gdx.gl.glClear(16384);
/*    */     
/* 41 */     screenChange();
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void screenChange();
/*    */   
/*    */   public void resize(int width, int height) {
/* 48 */     this.stage.getViewport().update(width, height, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 53 */     this.stage.dispose();
/* 54 */     this.batch.dispose();
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 59 */     this.paused = false;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\AbstractScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */