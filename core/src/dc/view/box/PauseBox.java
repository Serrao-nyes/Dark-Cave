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
/*    */ 
/*    */ public class PauseBox
/*    */   extends Table
/*    */ {
/* 15 */   private int selectedIndex = 0;
/*    */   
/* 17 */   private List<Image> arrows = new ArrayList<>();
/* 18 */   private List<Label> options = new ArrayList<>();
/*    */   
/*    */   private Table pause;
/*    */   private Skin skin;
/*    */   
/*    */   public PauseBox(Skin skin) {
/* 24 */     super(skin);
/* 25 */     this.skin = skin;
/* 26 */     setBackground("window");
/* 27 */     setPosition(430.0F, 430.0F);
/* 28 */     setSize(160.0F, 100.0F);
/* 29 */     add((Actor)new Label("PAUSA", skin)).center();
/* 30 */     this.pause = new Table();
/* 31 */     row();
/* 32 */     add((Actor)this.pause).pad(10.0F);
/* 33 */     addOption("Riprendi  ");
/* 34 */     addOption("Esci");
/*    */   }
/*    */   
/*    */   public void addOption(String option) {
/* 38 */     Label optionLabel = new Label(option, this.skin);
/* 39 */     this.options.add(optionLabel);
/* 40 */     Image arrow = new Image(this.skin, "selector");
/* 41 */     arrow.setVisible(false);
/* 42 */     this.arrows.add(arrow);
/*    */     
/* 44 */     this.pause.add((Actor)arrow).expand().align(8).padRight(5.0F);
/* 45 */     this.pause.add((Actor)optionLabel).expand().align(8);
/*    */     
/* 47 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   private void calcArrowVisibility() {
/* 51 */     for (int i = 0; i < this.arrows.size(); i++) {
/* 52 */       if (i == this.selectedIndex) {
/* 53 */         ((Image)this.arrows.get(i)).setVisible(true);
/*    */       } else {
/* 55 */         ((Image)this.arrows.get(i)).setVisible(false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void moveUp() {
/* 61 */     this.selectedIndex--;
/* 62 */     if (this.selectedIndex < 0) {
/* 63 */       this.selectedIndex = 0;
/*    */     }
/* 65 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public void moveDown() {
/* 69 */     this.selectedIndex++;
/* 70 */     if (this.selectedIndex >= this.options.size()) {
/* 71 */       this.selectedIndex = this.options.size() - 1;
/*    */     }
/* 73 */     calcArrowVisibility();
/*    */   }
/*    */   
/*    */   public int getSelected() {
/* 77 */     return this.selectedIndex;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 81 */     this.pause.clearChildren();
/* 82 */     this.arrows.clear();
/* 83 */     this.options.clear();
/* 84 */     this.selectedIndex = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\view\box\PauseBox.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */