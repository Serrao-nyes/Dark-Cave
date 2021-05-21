/*     */ package dc.view.box.combat;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Image;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*     */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import dc.parameters.CombatEntityParameters;
/*     */ 
/*     */ public class ParaTab
/*     */   extends Table {
/*     */   private Skin skin;
/*     */   private Label name;
/*     */   private Label fhp;
/*     */   private Label fpp;
/*     */   private Label php;
/*     */   private Label ppp;
/*     */   private Label thp;
/*     */   private Label tpp;
/*     */   private Label lhp;
/*     */   private Label lpp;
/*     */   
/*     */   public ParaTab(Skin skin) {
/*  26 */     super(skin);
/*  27 */     this.skin = skin;
/*  28 */     setPosition(20.0F, 10.0F);
/*  29 */     setSize(300.0F, 210.0F);
/*  30 */     setVisible(true);
/*  31 */     init();
/*     */   }
/*     */   
/*     */   public void init() {
/*  35 */     for (int i = 0; i < 4; i++) {
/*  36 */       if (i == 0) {
/*  37 */         this.name = new Label("Flik", this.skin);
/*  38 */         Image hp = new Image(this.skin, "label-hp");
/*  39 */         this.fhp = new Label("", this.skin, "year199x", Color.WHITE);
/*  40 */         Image pp = new Image(this.skin, "label-pp");
/*  41 */         this.fpp = new Label("", this.skin, "year199x", Color.WHITE);
/*  42 */         add((Actor)this.name).left().expand();
/*  43 */         add((Actor)hp).center();
/*  44 */         add((Actor)this.fhp).center().padRight(30.0F).expand();
/*  45 */         add((Actor)pp).center();
/*  46 */         add((Actor)this.fpp).center().padRight(45.0F);
/*  47 */         row();
/*  48 */         padTop(20.0F);
/*     */       } 
/*  50 */       if (i == 1) {
/*  51 */         this.name = new Label("Pesmerga", this.skin);
/*  52 */         Image hp = new Image(this.skin, "label-hp");
/*  53 */         this.php = new Label("", this.skin, "year199x", Color.WHITE);
/*  54 */         Image pp = new Image(this.skin, "label-pp");
/*  55 */         this.ppp = new Label("", this.skin, "year199x", Color.WHITE);
/*  56 */         add((Actor)this.name).left().expand();
/*  57 */         add((Actor)hp).center();
/*  58 */         add((Actor)this.php).center().padRight(30.0F).expand();
/*  59 */         add((Actor)pp).center();
/*  60 */         add((Actor)this.ppp).center().padRight(45.0F);
/*  61 */         row();
/*  62 */         padTop(20.0F);
/*     */       } 
/*  64 */       if (i == 2) {
/*  65 */         this.name = new Label("Ted", this.skin);
/*  66 */         Image hp = new Image(this.skin, "label-hp");
/*  67 */         this.thp = new Label("", this.skin, "year199x", Color.WHITE);
/*  68 */         Image pp = new Image(this.skin, "label-pp");
/*  69 */         this.tpp = new Label("", this.skin, "year199x", Color.WHITE);
/*  70 */         add((Actor)this.name).left().expand();
/*  71 */         add((Actor)hp).center();
/*  72 */         add((Actor)this.thp).center().padRight(30.0F).expand();
/*  73 */         add((Actor)pp).center();
/*  74 */         add((Actor)this.tpp).center().padRight(45.0F);
/*  75 */         row();
/*  76 */         padTop(20.0F);
/*     */       } 
/*  78 */       if (i == 3) {
/*  79 */         this.name = new Label("Lotte", this.skin);
/*  80 */         Image hp = new Image(this.skin, "label-hp");
/*  81 */         this.lhp = new Label("", this.skin, "year199x", Color.WHITE);
/*  82 */         Image pp = new Image(this.skin, "label-pp");
/*  83 */         this.lpp = new Label("", this.skin, "year199x", Color.WHITE);
/*  84 */         add((Actor)this.name).left().expand();
/*  85 */         add((Actor)hp).center();
/*  86 */         add((Actor)this.lhp).center().padRight(30.0F).expand();
/*  87 */         add((Actor)pp).center();
/*  88 */         add((Actor)this.lpp).center().padRight(45.0F);
/*  89 */         row();
/*  90 */         padTop(20.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(Array<CombatEntityParameters> Entities) {
/*  97 */     for (int i = 0; i < 4; i++) {
/*  98 */       if (i == 0) {
/*  99 */         this.fhp.setText(((CombatEntityParameters)Entities.get(i)).getCurrentHP());
/* 100 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() < ((CombatEntityParameters)Entities.get(i)).getHP() / 2)
/* 101 */           this.fhp.setColor(Color.YELLOW); 
/* 102 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() == 0) {
/* 103 */           this.fhp.setColor(Color.RED);
/*     */         } else {
/* 105 */           this.fhp.setColor(Color.WHITE);
/* 106 */         }  this.fpp.setText(((CombatEntityParameters)Entities.get(i)).getCurrentMP());
/* 107 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() < ((CombatEntityParameters)Entities.get(i)).getMP() / 2)
/* 108 */           this.fpp.setColor(Color.YELLOW); 
/* 109 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() == 0) {
/* 110 */           this.fpp.setColor(Color.RED);
/*     */         } else {
/* 112 */           this.fpp.setColor(Color.WHITE);
/*     */         } 
/* 114 */       }  if (i == 1) {
/* 115 */         this.php.setText(((CombatEntityParameters)Entities.get(i)).getCurrentHP());
/* 116 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() < ((CombatEntityParameters)Entities.get(i)).getHP() / 2)
/* 117 */           this.php.setColor(Color.YELLOW); 
/* 118 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() == 0) {
/* 119 */           this.php.setColor(Color.RED);
/*     */         } else {
/* 121 */           this.php.setColor(Color.WHITE);
/* 122 */         }  this.ppp.setText(((CombatEntityParameters)Entities.get(i)).getCurrentMP());
/* 123 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() < ((CombatEntityParameters)Entities.get(i)).getMP() / 2)
/* 124 */           this.ppp.setColor(Color.YELLOW); 
/* 125 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() == 0) {
/* 126 */           this.ppp.setColor(Color.RED);
/*     */         } else {
/* 128 */           this.ppp.setColor(Color.WHITE);
/*     */         } 
/* 130 */       }  if (i == 2) {
/* 131 */         this.thp.setText(((CombatEntityParameters)Entities.get(i)).getCurrentHP());
/* 132 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() < ((CombatEntityParameters)Entities.get(i)).getHP() / 2)
/* 133 */           this.thp.setColor(Color.YELLOW); 
/* 134 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() == 0) {
/* 135 */           this.thp.setColor(Color.RED);
/*     */         } else {
/* 137 */           this.thp.setColor(Color.WHITE);
/* 138 */         }  this.tpp.setText(((CombatEntityParameters)Entities.get(i)).getCurrentMP());
/* 139 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() < ((CombatEntityParameters)Entities.get(i)).getMP() / 2)
/* 140 */           this.tpp.setColor(Color.YELLOW); 
/* 141 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() == 0) {
/* 142 */           this.tpp.setColor(Color.RED);
/*     */         } else {
/* 144 */           this.tpp.setColor(Color.WHITE);
/*     */         } 
/* 146 */       }  if (i == 3) {
/* 147 */         this.lhp.setText(((CombatEntityParameters)Entities.get(i)).getCurrentHP());
/* 148 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() < ((CombatEntityParameters)Entities.get(i)).getHP() / 2)
/* 149 */           this.lhp.setColor(Color.YELLOW); 
/* 150 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentHP() == 0) {
/* 151 */           this.lhp.setColor(Color.RED);
/*     */         } else {
/* 153 */           this.lhp.setColor(Color.WHITE);
/* 154 */         }  this.lpp.setText(((CombatEntityParameters)Entities.get(i)).getCurrentMP());
/* 155 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() < ((CombatEntityParameters)Entities.get(i)).getMP() / 2)
/* 156 */           this.lpp.setColor(Color.YELLOW); 
/* 157 */         if (((CombatEntityParameters)Entities.get(i)).getCurrentMP() == 0) {
/* 158 */           this.lpp.setColor(Color.RED);
/*     */         } else {
/* 160 */           this.lpp.setColor(Color.WHITE);
/*     */         } 
/*     */       } 
/* 163 */     }  setVisible(true);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 167 */     clearChildren();
/*     */   }
/*     */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\combat\ParaTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */