/*    */ package dc.controller.manager;
/*    */ 
/*    */ import dc.game.DarkCave;
/*    */ import dc.model.Player;
/*    */ import dc.model.item.Chiave;
/*    */ import dc.model.item.CodaDiFenice;
/*    */ import dc.model.item.Etere;
/*    */ import dc.model.item.Item;
/*    */ import dc.model.item.Pozione;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ public class InventoryManagement
/*    */ {
/*    */   public DarkCave game;
/*    */   public Player player;
/*    */   public HashMap<ITM, Item> gameItems;
/*    */   
/*    */   public enum ITM
/*    */   {
/* 21 */     POZIONE,
/* 22 */     ETERE,
/* 23 */     CODADIFENICE,
/* 24 */     CHIAVE;
/*    */   }
/*    */   
/*    */   public InventoryManagement(DarkCave game) {
/* 28 */     this.game = game;
/* 29 */     initItem();
/*    */   }
/*    */   
/*    */   private void initItem() {
/* 33 */     this.gameItems = new HashMap<>();
/*    */     
/* 35 */     this.gameItems.put(ITM.POZIONE, new Pozione(this.game));
/* 36 */     this.gameItems.put(ITM.ETERE, new Etere(this.game));
/* 37 */     this.gameItems.put(ITM.CODADIFENICE, new CodaDiFenice(this.game));
/* 38 */     this.gameItems.put(ITM.CHIAVE, new Chiave(this.game));
/*    */   }
/*    */ 
/*    */   
/*    */   public Item getItem(ITM item) {
/* 43 */     return this.gameItems.get(item);
/*    */   }
/*    */   
/*    */   public void getFunction(ITM item, String name) {
/* 47 */     ((Item)this.gameItems.get(item)).functionality(name);
/*    */   }
/*    */   
/*    */   public void addCount(ITM item, int count) {
/* 51 */     ((Item)this.gameItems.get(item)).addCount(count);
/*    */   }
/*    */   
/*    */   public int getCount(ITM item) {
/* 55 */     return ((Item)this.gameItems.get(item)).getCount();
/*    */   }
/*    */   
/*    */   public ITM getITM(String object) {
/* 59 */     if (object.equals("Pozione"))
/* 60 */       object = "POZIONE"; 
/* 61 */     if (object.equals("Etere"))
/* 62 */       object = "ETERE"; 
/* 63 */     if (object.equals("Coda di Fenice"))
/* 64 */       object = "CODADIFENICE"; 
/* 65 */     if (object.equals("Chiave"))
/* 66 */       object = "CHIAVE"; 
/* 67 */     for (ITM i : this.gameItems.keySet()) {
/* 68 */       if (object.equals(i.toString())) {
/* 69 */         return i;
/*    */       }
/*    */     } 
/* 72 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\manager\InventoryManagement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */