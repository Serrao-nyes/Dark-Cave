/*     */ package dc.view.box;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Image;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import dc.controller.manager.InventoryManagement;
/*     */ import dc.game.DarkCave;
/*     */ import dc.parameters.AlliesParameters;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class InventoryTab
/*     */   extends Table
/*     */ {
/*  17 */   private int selectedIndex = 0;
/*     */   
/*     */   private Skin skin;
/*     */   
/*     */   private Table inv;
/*     */   private Table exit;
/*     */   private Table party;
/*  24 */   private List<Image> arrows = new ArrayList<>();
/*  25 */   private List<Label> options = new ArrayList<>();
/*     */   
/*  27 */   private int Pozioni = 0;
/*  28 */   private int Etere = 0;
/*  29 */   private int CodaDiFenice = 0;
/*  30 */   private int Chiavi = 0;
/*     */   
/*     */   public InventoryTab(Skin skin) {
/*  33 */     super(skin);
/*  34 */     this.skin = skin;
/*  35 */     setBackground("window");
/*  36 */     setPosition(530.0F, 250.0F);
/*  37 */     setSize(480.0F, 450.0F);
/*  38 */     add((Actor)new Label("INVENTARIO", skin)).top().padBottom(30.0F);
/*  39 */     row();
/*  40 */     this.inv = new Table();
/*  41 */     add((Actor)this.inv).center();
/*  42 */     row();
/*  43 */     this.party = new Table();
/*  44 */     add((Actor)this.party).center().left().padTop(20.0F);
/*  45 */     row();
/*  46 */     this.exit = new Table();
/*  47 */     add((Actor)this.exit).center().padTop(20.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void inventory() {
/*  52 */     this.inv.add((Actor)new Label("Pozioni: " + this.Pozioni, this.skin)).expand().left();
/*  53 */     addOption("Usa");
/*  54 */     this.inv.row();
/*  55 */     this.inv.add((Actor)new Label("Etere: " + this.Etere, this.skin)).expand().left();
/*  56 */     addOption("Usa");
/*  57 */     this.inv.row();
/*  58 */     this.inv.add((Actor)new Label("Coda Di Fenice: " + this.CodaDiFenice + "   ", this.skin)).expand().left();
/*  59 */     addOption("Usa");
/*  60 */     this.inv.row();
/*  61 */     this.inv.add((Actor)new Label("Chiavi: " + this.Chiavi, this.skin)).expand().left();
/*     */   }
/*     */   
/*     */   public void party() {
/*  65 */     this.party.add((Actor)new Label("Flik:", this.skin)).left().expand().padRight(20.0F);
/*  66 */     this.party.add((Actor)new Label("HP: " + AlliesParameters.getWarrior().getCurrentHP() + " / " + AlliesParameters.getWarrior().getHP(), this.skin)).center();
/*  67 */     this.party.add((Actor)new Label("PP: " + AlliesParameters.getWarrior().getCurrentMP() + " / " + AlliesParameters.getWarrior().getMP(), this.skin)).center().padLeft(20.0F);
/*  68 */     this.party.row();
/*  69 */     this.party.add((Actor)new Label("Pesmerga:", this.skin)).left().expand().padRight(20.0F);
/*  70 */     this.party.add((Actor)new Label("HP: " + AlliesParameters.getKnight().getCurrentHP() + " / " + AlliesParameters.getKnight().getHP(), this.skin)).center();
/*  71 */     this.party.add((Actor)new Label("PP: " + AlliesParameters.getKnight().getCurrentMP() + " / " + AlliesParameters.getKnight().getMP(), this.skin)).center().padLeft(20.0F);
/*  72 */     this.party.row();
/*  73 */     this.party.add((Actor)new Label("Ted:", this.skin)).left().expand().padRight(20.0F);
/*  74 */     this.party.add((Actor)new Label("HP: " + AlliesParameters.getArcher().getCurrentHP() + " / " + AlliesParameters.getArcher().getHP(), this.skin)).center();
/*  75 */     this.party.add((Actor)new Label("PP: " + AlliesParameters.getArcher().getCurrentMP() + " / " + AlliesParameters.getArcher().getMP(), this.skin)).center().padLeft(20.0F);
/*  76 */     this.party.row();
/*  77 */     this.party.add((Actor)new Label("Lotte:", this.skin)).left().expand().padRight(20.0F);
/*  78 */     this.party.add((Actor)new Label("PP: " + AlliesParameters.getMage().getCurrentHP() + " / " + AlliesParameters.getMage().getHP(), this.skin)).center();
/*  79 */     this.party.add((Actor)new Label("PP: " + AlliesParameters.getMage().getCurrentMP() + " / " + AlliesParameters.getMage().getMP(), this.skin)).center().padLeft(20.0F);
/*  80 */     this.party.row();
/*     */   }
/*     */   
/*     */   public void addOption(String option) {
/*  84 */     Label optionLabel = new Label(option, this.skin);
/*  85 */     this.options.add(optionLabel);
/*  86 */     Image arrow = new Image(this.skin, "selector");
/*  87 */     arrow.setVisible(false);
/*  88 */     this.arrows.add(arrow);
/*     */     
/*  90 */     this.inv.add((Actor)arrow).expand().right().expandX().space(2.0F);
/*  91 */     this.inv.add((Actor)optionLabel).expand().right();
/*  92 */     this.inv.row();
/*     */     
/*  94 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void update(DarkCave game) {
/*  98 */     this.Pozioni = game.im.getCount(InventoryManagement.ITM.POZIONE);
/*  99 */     this.Etere = game.im.getCount(InventoryManagement.ITM.ETERE);
/* 100 */     this.CodaDiFenice = game.im.getCount(InventoryManagement.ITM.CODADIFENICE);
/* 101 */     this.Chiavi = game.im.getCount(InventoryManagement.ITM.CHIAVE);
/* 102 */     inventory();
/* 103 */     party();
/* 104 */     Label exitLabel = new Label("Chiudi", this.skin);
/* 105 */     this.options.add(exitLabel);
/* 106 */     Image exitarrow = new Image(this.skin, "selector");
/* 107 */     exitarrow.setVisible(false);
/* 108 */     this.arrows.add(exitarrow);
/*     */     
/* 110 */     this.exit.add((Actor)exitarrow).center().padRight(5.0F);
/* 111 */     this.exit.add((Actor)exitLabel).center();
/*     */   }
/*     */   
/*     */   private void calcArrowVisibility() {
/* 115 */     for (int i = 0; i < this.arrows.size(); i++) {
/* 116 */       if (i == this.selectedIndex) {
/* 117 */         ((Image)this.arrows.get(i)).setVisible(true);
/*     */       } else {
/* 119 */         ((Image)this.arrows.get(i)).setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void moveUp() {
/* 125 */     this.selectedIndex--;
/* 126 */     if (this.selectedIndex < 0) {
/* 127 */       this.selectedIndex = 0;
/*     */     }
/* 129 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void moveDown() {
/* 133 */     this.selectedIndex++;
/* 134 */     if (this.selectedIndex >= this.options.size()) {
/* 135 */       this.selectedIndex = this.options.size() - 1;
/*     */     }
/* 137 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public int getSelected() {
/* 141 */     return this.selectedIndex;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 145 */     this.inv.clear();
/* 146 */     this.party.clear();
/* 147 */     this.exit.clear();
/* 148 */     this.arrows.clear();
/* 149 */     this.options.clear();
/* 150 */     this.selectedIndex = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\InventoryTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */