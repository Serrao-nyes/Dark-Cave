/*    */ package dc.view.box;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Image;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Label;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/*    */ import com.badlogic.gdx.scenes.scene2d.ui.Table;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class MainMenuTab
/*    */   extends Table {
/* 14 */   private int selectedIndex = 0;
/*    */   
/* 16 */   private List<Image> arrows = new ArrayList<>();
/* 17 */   private List<Label> options = new ArrayList<>();
/*    */   
/*    */   private Skin skin;
/*    */   
/*    */   public MainMenuTab(Skin skin) {
/* 22 */     super(skin);
/* 23 */     this.skin = skin;
/* 24 */     setSize(300.0F, 500.0F);
/* 25 */     addOption("Avvia Partita");
/* 26 */     row();
/* 27 */     addOption("About");
/* 28 */     row();
/* 29 */     addOption("Opzioni");
/* 30 */     row();
/* 31 */     addOption("Esci");
/*    */   }
/*    */   
/*    */   public void addOption(String option) {
/* 35 */     Label optionLabel = new Label(option, this.skin, "year199x", Color.BLACK);
/* 36 */     optionLabel.setFontScale(1.5F);
/* 37 */     this.options.add(optionLabel);
/* 38 */     Image arrow = new Image(this.skin, "selector");
/* 39 */     arrow.setScale(1.2F);
/* 40 */     arrow.setVisible(false);
/* 41 */     this.arrows.add(arrow);
/*    */     
/* 43 */     add((Actor)arrow).left().expand().padLeft(30.0F);
/* 44 */     add((Actor)optionLabel).left().expand().padRight(50.0F);
/*    */     
/* 46 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   private void calcArrowVisibility() {
/* 50 */     for (int i = 0; i < this.arrows.size(); i++) {
/* 51 */       if (i == this.selectedIndex) {
/* 52 */         ((Image)this.arrows.get(i)).setVisible(true);
/*    */       } else {
/* 54 */         ((Image)this.arrows.get(i)).setVisible(false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void moveUp() {
/* 60 */     this.selectedIndex--;
/* 61 */     if (this.selectedIndex < 0) {
/* 62 */       this.selectedIndex = 0;
/*    */     }
/* 64 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public void moveDown() {
/* 68 */     this.selectedIndex++;
/* 69 */     if (this.selectedIndex >= this.options.size()) {
/* 70 */       this.selectedIndex = this.options.size() - 1;
/*    */     }
/* 72 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public int getSelected() {
/* 76 */     return this.selectedIndex;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 80 */     clearChildren();
/* 81 */     this.arrows.clear();
/* 82 */     this.options.clear();
/* 83 */     this.selectedIndex = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\MainMenuTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */