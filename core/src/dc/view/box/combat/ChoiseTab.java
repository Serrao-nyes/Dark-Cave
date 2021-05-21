/*     */ package dc.view.box.combat;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Image;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class ChoiseTab
/*     */   extends Table
/*     */ {
/*     */   private Label ability;
/*  16 */   private int selectedIndex = 0;
/*     */   
/*  18 */   private List<Image> arrows = new ArrayList<>();
/*  19 */   private List<Label> options = new ArrayList<>();
/*     */   
/*     */   private Skin skin;
/*     */   
/*     */   public ChoiseTab(Skin skin) {
/*  24 */     super(skin);
/*  25 */     this.skin = skin;
/*  26 */     setBackground("window");
/*  27 */     setPosition(725.0F, 0.0F);
/*  28 */     setSize(300.0F, 210.0F);
/*     */     
/*  30 */     Table left = new Table();
/*  31 */     Table right = new Table();
/*  32 */     addOption(left, "Attacco");
/*  33 */     addOption(left, "Difesa");
/*  34 */     addOptionAbility(left, "");
/*  35 */     add((Actor)left).center().left().padRight(10.0F);
/*  36 */     addOption(right, "Magia");
/*  37 */     addOption(right, "Fuga");
/*  38 */     add((Actor)right).center().right().padLeft(10.0F);
/*  39 */     setVisible(false);
/*     */   }
/*     */   
/*     */   public void ability(int i) {
/*  43 */     if (i == 0)
/*  44 */       this.ability.setText("Incentivo 10PP"); 
/*  45 */     if (i == 1)
/*  46 */       this.ability.setText("Antiscudum 20PP"); 
/*  47 */     if (i == 2)
/*  48 */       this.ability.setText("Tiro Potente 40PP"); 
/*  49 */     if (i == 3)
/*  50 */       this.ability.setText("Focus 10PP"); 
/*     */   }
/*     */   
/*     */   public void addOption(Table section, String option) {
/*  54 */     Label optionLabel = new Label(option, this.skin);
/*  55 */     optionLabel.setFontScale(1.22F);
/*  56 */     this.options.add(optionLabel);
/*  57 */     Image arrow = new Image(this.skin, "selector");
/*  58 */     arrow.setScale(1.0F);
/*  59 */     arrow.setVisible(false);
/*  60 */     this.arrows.add(arrow);
/*     */     
/*  62 */     section.add((Actor)arrow).expand().align(8).padRight(5.0F);
/*  63 */     section.add((Actor)optionLabel).expand().align(8);
/*     */     
/*  65 */     section.row();
/*     */     
/*  67 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void addOptionAbility(Table section, String option) {
/*  71 */     this.ability = new Label(option, this.skin);
/*  72 */     this.ability.setFontScale(1.22F);
/*  73 */     this.options.add(this.ability);
/*  74 */     Image arrow = new Image(this.skin, "selector");
/*  75 */     arrow.setScale(1.0F);
/*  76 */     arrow.setVisible(false);
/*  77 */     this.arrows.add(arrow);
/*     */     
/*  79 */     section.add((Actor)arrow).expand().align(8).padRight(5.0F);
/*  80 */     section.add((Actor)this.ability).expand().align(8);
/*     */     
/*  82 */     section.row();
/*     */     
/*  84 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   private void calcArrowVisibility() {
/*  88 */     for (int i = 0; i < this.arrows.size(); i++) {
/*  89 */       if (i == this.selectedIndex) {
/*  90 */         ((Image)this.arrows.get(i)).setVisible(true);
/*     */       } else {
/*  92 */         ((Image)this.arrows.get(i)).setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void moveUp() {
/*  98 */     this.selectedIndex--;
/*  99 */     if (this.selectedIndex < 0) {
/* 100 */       this.selectedIndex = 0;
/*     */     }
/* 102 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void moveDown() {
/* 106 */     this.selectedIndex++;
/* 107 */     if (this.selectedIndex >= this.options.size()) {
/* 108 */       this.selectedIndex = this.options.size() - 1;
/*     */     }
/* 110 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void moveRight() {
/* 114 */     int prev = this.selectedIndex;
/* 115 */     this.selectedIndex += 3;
/* 116 */     if (this.selectedIndex >= this.options.size()) {
/* 117 */       this.selectedIndex = prev;
/*     */     }
/* 119 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void moveLeft() {
/* 123 */     int prev = this.selectedIndex;
/* 124 */     this.selectedIndex -= 3;
/* 125 */     if (this.selectedIndex < 0) {
/* 126 */       this.selectedIndex = prev;
/*     */     }
/* 128 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public int getSelected() {
/* 132 */     return this.selectedIndex;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 136 */     setVisible(false);
/* 137 */     this.selectedIndex = 0;
/* 138 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 142 */     clearChildren();
/* 143 */     this.arrows.clear();
/* 144 */     this.options.clear();
/* 145 */     this.selectedIndex = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\combat\ChoiseTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */