/*    */ package dc.view;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*    */ import dc.controller.manager.GameScreenManager;
/*    */ import dc.game.DarkCave;
/*    */ import dc.settings.Constans;
/*    */ 
/*    */ public class StartScreen
/*    */   extends AbstractScreen
/*    */ {
/*    */   private Table start;
/*    */   
/*    */   public StartScreen(DarkCave game) {
/* 17 */     super(game);
/* 18 */     this.start = new Table();
/* 19 */     Label msg = new Label("X : Seleziona/Azione\nC : Corri/Indietro/Annulla\nFRECCE DIREZIONALI : Cammina/Naviga nei menu'\nTAB:Apri Inventario\nESC:Pausa\nPREMERE X PER CONTINUARE", 
/* 20 */         this.skin);
/* 21 */     this.start.add((Actor)msg).center();
/* 22 */     this.start.setVisible(true);
/* 23 */     this.start.setPosition((Constans.APP_DESKTOP_WIDTH / 2), (Constans.APP_DESKTOP_HEIGHT / 2));
/*    */     
/* 25 */     this.stage.addActor((Actor)this.start);
/*    */   }
/*    */ 
/*    */   
/*    */   public void show() {
/* 30 */     super.show();
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(float delta) {}
/*    */ 
/*    */   
/*    */   public void render(float delta) {
/* 38 */     super.render(delta);
/* 39 */     this.stage.act(delta);
/* 40 */     this.stage.draw();
/*    */   }
/*    */ 
/*    */   
/*    */   public void screenChange() {
/* 45 */     if (Gdx.input.isKeyJustPressed(52)) {
/* 46 */       this.game.gsm.doTransition(GameScreenManager.STATE.MAIN_MENU);
/*    */     }
/* 48 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.START);
/*    */   }
/*    */ 
/*    */   
/*    */   public void pause() {}
/*    */ 
/*    */   
/*    */   public void resume() {}
/*    */ 
/*    */   
/*    */   public void hide() {}
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 62 */     super.dispose();
/* 63 */     this.start.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\StartScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */