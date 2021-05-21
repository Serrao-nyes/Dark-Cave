/*    */ package dc.view.box;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Image;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class OptionBox
/*    */   extends Table
/*    */ {
/* 14 */   private int selectedIndex = 0;
/*    */   
/* 16 */   private List<Image> arrows = new ArrayList<>();
/* 17 */   private List<Label> options = new ArrayList<>();
/*    */   
/*    */   private Skin skin;
/*    */   
/*    */   public OptionBox(Skin skin) {
/* 22 */     super(skin);
/* 23 */     this.skin = skin;
/* 24 */     setBackground("window");
/* 25 */     setSize(350.0F, 500.0F);
/*    */   }
/*    */   
/*    */   public void addOption(String option) {
/* 29 */     Label optionLabel = new Label(option, this.skin);
/* 30 */     this.options.add(optionLabel);
/* 31 */     Image arrow = new Image(this.skin, "selector");
/* 32 */     arrow.setVisible(false);
/* 33 */     this.arrows.add(arrow);
/*    */     
/* 35 */     add((Actor)arrow).left().padLeft(10.0F);
/* 36 */     add((Actor)optionLabel).left().expand().padLeft(20.0F);
/*    */     
/* 38 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   private void calcArrowVisibility() {
/* 42 */     for (int i = 0; i < this.arrows.size(); i++) {
/* 43 */       if (i == this.selectedIndex) {
/* 44 */         ((Image)this.arrows.get(i)).setVisible(true);
/*    */       } else {
/* 46 */         ((Image)this.arrows.get(i)).setVisible(false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void moveUp() {
/* 52 */     this.selectedIndex--;
/* 53 */     if (this.selectedIndex < 0) {
/* 54 */       this.selectedIndex = 0;
/*    */     }
/* 56 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public void moveDown() {
/* 60 */     this.selectedIndex++;
/* 61 */     if (this.selectedIndex >= this.options.size()) {
/* 62 */       this.selectedIndex = this.options.size() - 1;
/*    */     }
/* 64 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public int getSelected() {
/* 68 */     return this.selectedIndex;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 72 */     clearChildren();
/* 73 */     setVisible(false);
/* 74 */     this.arrows.clear();
/* 75 */     this.options.clear();
/* 76 */     this.selectedIndex = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\OptionBox.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */