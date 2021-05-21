/*     */ package dc.view.box.combat;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Image;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import dc.parameters.CombatEntityParameters;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class TargetTab
/*     */   extends Table
/*     */ {
/*  17 */   private int selectedIndex = 0;
/*     */   
/*  19 */   private List<Image> arrows = new ArrayList<>();
/*  20 */   private List<Label> options = new ArrayList<>();
/*     */   
/*     */   private Skin skin;
/*     */ 
/*     */   
/*     */   public TargetTab(Skin skin) {
/*  26 */     super(skin);
/*  27 */     this.skin = skin;
/*  28 */     setBackground("window");
/*  29 */     setSize(180.0F, 210.0F);
/*  30 */     setPosition(545.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void init(Array<CombatEntityParameters> Entities) {
/*  34 */     for (int i = 0; i < Entities.size; i++) {
/*  35 */       if (((CombatEntityParameters)Entities.get(i)).isDead()) {
/*  36 */         if (i == Entities.size - 1) {
/*     */ 
/*     */           
/*  39 */           if (!((CombatEntityParameters)Entities.get(i - 1)).isDead()) {
/*  40 */             addOption(((CombatEntityParameters)Entities.get(i - 1)).getName());
/*     */           
/*     */           }
/*     */           else {
/*     */             
/*  45 */             addOption(((CombatEntityParameters)Entities.get(i - 2)).getName());
/*     */           
/*     */           }
/*     */         
/*     */         }
/*  50 */         else if (!((CombatEntityParameters)Entities.get(i + 1)).isDead()) {
/*  51 */           addOption(((CombatEntityParameters)Entities.get(i + 1)).getName());
/*     */         } else {
/*  53 */           addOption(((CombatEntityParameters)Entities.get(i + 2)).getName());
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/*  59 */         addOption(((CombatEntityParameters)Entities.get(i)).getName());
/*     */       } 
/*     */       
/*  62 */       row();
/*     */     } 
/*     */     
/*  65 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public void addOption(String option) {
/*  69 */     Label optionLabel = new Label(option, this.skin);
/*  70 */     this.options.add(optionLabel);
/*  71 */     Image arrow = new Image(this.skin, "selector");
/*  72 */     arrow.setVisible(false);
/*  73 */     this.arrows.add(arrow);
/*     */     
/*  75 */     add((Actor)arrow).left().align(8).expand().padLeft(20.0F);
/*  76 */     add((Actor)optionLabel).left().align(8).expand().padRight(30.0F);
/*     */     
/*  78 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   private void calcArrowVisibility() {
/*  82 */     for (int i = 0; i < this.arrows.size(); i++) {
/*  83 */       if (i == this.selectedIndex) {
/*  84 */         ((Image)this.arrows.get(i)).setVisible(true);
/*     */       } else {
/*  86 */         ((Image)this.arrows.get(i)).setVisible(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void moveUp() {
/*  92 */     this.selectedIndex--;
/*  93 */     if (this.selectedIndex < 0) {
/*  94 */       this.selectedIndex = 0;
/*     */     }
/*  96 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public void moveDown() {
/* 100 */     this.selectedIndex++;
/* 101 */     if (this.selectedIndex >= this.options.size()) {
/* 102 */       this.selectedIndex = this.options.size() - 1;
/*     */     }
/* 104 */     calcArrowVisibility();
/*     */   }
/*     */   
/*     */   public int getSelected() {
/* 108 */     return this.selectedIndex;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 112 */     clearChildren();
/* 113 */     setVisible(false);
/* 114 */     this.arrows.clear();
/* 115 */     this.options.clear();
/* 116 */     this.selectedIndex = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\combat\TargetTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */