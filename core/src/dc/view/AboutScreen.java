/*     */ package dc.view;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import dc.controller.manager.GameScreenManager;
/*     */ import dc.game.DarkCave;
/*     */ import dc.settings.Constans;
/*     */ 
/*     */ public class AboutScreen
/*     */   extends AbstractScreen
/*     */ {
/*     */   private Table about;
/*     */   private Table story;
/*     */   private Table info;
/*     */   private Texture back;
/*     */   
/*     */   public AboutScreen(DarkCave game) {
/*  22 */     super(game);
/*     */     
/*  24 */     this.back = new Texture("Background/AboutBackground.jpg");
/*     */     
/*  26 */     this.about = new Table();
/*     */     
/*  28 */     this.story = new Table();
/*  29 */     Label msg = new Label("Raggiunta la grotta dove sembra avere origine il male che sta colpendo la citta' vicina, il gruppo di\navventurieri formato dal Guerriero Flik, il Cavaliere Pesmerga, il Ranger Ted e la Maga Lotte, e' pronto\nad affrontare qualunque cosa si celi dietro questa grotta misteriosa", 
/*     */         
/*  31 */         this.skin, "year199x", Color.WHITE);
/*  32 */     msg.setFontScale(1.18F);
/*  33 */     this.story.add((Actor)msg);
/*  34 */     this.story.setVisible(true);
/*     */     
/*  36 */     this.about.add((Actor)this.story).top().left().padBottom(25.0F);
/*     */     
/*  38 */     this.about.row();
/*     */     
/*  40 */     this.info = new Table();
/*  41 */     Label ogg = new Label("Oggetti Ottenibili:\nPozione: Cura di 1000 HP il personaggio selezionato\nEtere: Ripristina 50 PP il personaggio selezionato\nCoda di Fenice: Riporta in vita il personaggio selezionato con il massimo dei sui HP", 
/*     */ 
/*     */         
/*  44 */         this.skin, "year199x", Color.WHITE);
/*  45 */     ogg.setFontScale(1.15F);
/*  46 */     Label pg = new Label("Personaggi:\nFlik:  Guerriero dotato di grande velocità che e' in grado di usare HASTE, per aumentare la propria velocita',\n       e puo' usare l'abilita' INCENTIVO, per aumentare la potenza fisica\n\nPesmerga:  Cavaliere dotato di grande resistenza fisica. Puo' usare l'abilita' ANTISCUDUM, che sferra un\n               colpo di potenza tale da superare meta' della difesa del nemico\n\nTed:  Arciere con una mira infallibile, fa affidamento sul suo arco con il quale puo' usare l'abilita'\n       TIRO CONCENTRATO, infliggendo il doppio del danno al bersaglio\n\nLotte:  Maga molto abile, che da supporto alla squadra con le magie ENERGIA, curando il bersaglio\n         selezionato, e FLARE, magia offensiva in grado di infliggere ingenti danni. Lotte e' anche\n         in grado di usare l'abilita' FOCUS, che le permette  di aumentare la propria potenza magica\n", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  55 */         this.skin, "year199x", Color.WHITE);
/*  56 */     pg.setFontScale(1.15F);
/*     */     
/*  58 */     this.info.add((Actor)ogg).left().expand().padBottom(20.0F);
/*  59 */     this.info.row();
/*  60 */     this.info.add((Actor)pg).left().expand().padTop(10.0F);
/*  61 */     this.info.setVisible(true);
/*     */     
/*  63 */     this.about.add((Actor)this.info).center().left().padTop(30.0F);
/*     */     
/*  65 */     this.about.row();
/*     */     
/*  67 */     Label exit = new Label("PREMI C PER TORNARE AL MENU' PRINCIPALE", this.skin, "year199x", Color.WHITE);
/*  68 */     exit.setFontScale(1.15F);
/*     */     
/*  70 */     this.about.add((Actor)exit).bottom().padTop(30.0F);
/*     */     
/*  72 */     this.about.setSize(Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT);
/*  73 */     this.about.setPosition(0.0F, 30.0F);
/*  74 */     this.about.setVisible(true);
/*     */     
/*  76 */     this.stage.addActor((Actor)this.about);
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/*  81 */     super.show();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float delta) {}
/*     */ 
/*     */   
/*     */   public void render(float delta) {
/*  89 */     super.render(delta);
/*     */     
/*  91 */     this.batch.begin();
/*  92 */     this.batch.draw(this.back, 0.0F, 0.0F, Constans.APP_DESKTOP_WIDTH, Constans.APP_DESKTOP_HEIGHT);
/*  93 */     this.batch.end();
/*     */     
/*  95 */     this.stage.act(delta);
/*  96 */     this.stage.draw();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void screenChange() {
/* 102 */     if (Gdx.input.isKeyJustPressed(31)) {
/* 103 */       this.game.gsm.doTransition(GameScreenManager.STATE.MAIN_MENU);
/*     */     }
/*     */     
/* 106 */     this.game.gsm.setCurrScreen(GameScreenManager.STATE.ABOUT);
/*     */   }
/*     */ 
/*     */   
/*     */   public void pause() {}
/*     */ 
/*     */   
/*     */   public void resume() {}
/*     */ 
/*     */   
/*     */   public void hide() {}
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 120 */     super.dispose();
/* 121 */     this.story.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\AboutScreen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */