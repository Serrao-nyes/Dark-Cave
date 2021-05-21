/*    */ package dc.view.box.combat;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Image;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class MagicTab
/*    */   extends Table
/*    */ {
/* 14 */   private int selectedIndex = 0;
/*    */   
/* 16 */   private List<Image> arrows = new ArrayList<>();
/* 17 */   private List<Label> options = new ArrayList<>();
/*    */   
/*    */   private Skin skin;
/*    */ 
/*    */   
/*    */   public MagicTab(Skin skin) {
/* 23 */     super(skin);
/* 24 */     this.skin = skin;
/* 25 */     setBackground("window");
/* 26 */     setSize(180.0F, 210.0F);
/* 27 */     setPosition(525.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(int i) {
/* 32 */     if (i == 0) {
/* 33 */       addOption("Haste 20PP");
/*    */     }
/* 35 */     if (i == 3) {
/* 36 */       addOption("Flare 8PP");
/* 37 */       row();
/* 38 */       addOption("Energia 10PP");
/*    */     } 
/* 40 */     setVisible(true);
/*    */   }
/*    */   
/*    */   public void addOption(String option) {
/* 44 */     Label optionLabel = new Label(option, this.skin);
/* 45 */     this.options.add(optionLabel);
/* 46 */     Image arrow = new Image(this.skin, "selector");
/* 47 */     arrow.setVisible(false);
/* 48 */     this.arrows.add(arrow);
/*    */     
/* 50 */     add((Actor)arrow).left().align(8).expand().padLeft(20.0F);
/* 51 */     add((Actor)optionLabel).left().align(8).expand().padRight(30.0F);
/*    */     
/* 53 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   private void calcArrowVisibility() {
/* 57 */     for (int i = 0; i < this.arrows.size(); i++) {
/* 58 */       if (i == this.selectedIndex) {
/* 59 */         ((Image)this.arrows.get(i)).setVisible(true);
/*    */       } else {
/* 61 */         ((Image)this.arrows.get(i)).setVisible(false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void moveUp() {
/* 67 */     this.selectedIndex--;
/* 68 */     if (this.selectedIndex < 0) {
/* 69 */       this.selectedIndex = 0;
/*    */     }
/* 71 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public void moveDown() {
/* 75 */     this.selectedIndex++;
/* 76 */     if (this.selectedIndex >= this.options.size()) {
/* 77 */       this.selectedIndex = this.options.size() - 1;
/*    */     }
/* 79 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public int getSelected() {
/* 83 */     return this.selectedIndex;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 87 */     clearChildren();
/* 88 */     setVisible(false);
/* 89 */     this.arrows.clear();
/* 90 */     this.options.clear();
/* 91 */     this.selectedIndex = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\combat\MagicTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */