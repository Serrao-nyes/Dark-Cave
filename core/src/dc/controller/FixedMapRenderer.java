/*    */ package dc.controller;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.maps.MapLayer;
/*    */ import com.badlogic.gdx.maps.tiled.TiledMap;
/*    */ import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
/*    */ import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
/*    */ 
/*    */ 
/*    */ public class FixedMapRenderer
/*    */   extends OrthogonalTiledMapRenderer
/*    */ {
/*    */   public FixedMapRenderer(TiledMap map) {
/* 14 */     super(fixTilesPixelBleeding(map));
/*    */   }
/*    */ 
/*    */   
/*    */   private static TiledMap fixTilesPixelBleeding(TiledMap tiledMap) {
/* 19 */     for (MapLayer layer : tiledMap.getLayers()) {
/*    */       
/* 21 */       if (!layer.isVisible()) {
/*    */         continue;
/*    */       }
/*    */       
/* 25 */       if (layer instanceof TiledMapTileLayer)
/*    */       {
/* 27 */         fixTilePixelBleeding((TiledMapTileLayer)layer);
/*    */       }
/*    */     } 
/* 30 */     return tiledMap;
/*    */   }
/*    */ 
/*    */   
/*    */   private static void fixTilePixelBleeding(TiledMapTileLayer layer) {
/* 35 */     for (int x = 0; x < layer.getWidth(); x++) {
/*    */       
/* 37 */       for (int y = 0; y < layer.getHeight(); y++) {
/*    */         
/* 39 */         TiledMapTileLayer.Cell cell = layer.getCell(x, y);
/* 40 */         if (cell != null)
/*    */         {
/* 42 */           fixPixelBleeding(cell.getTile().getTextureRegion());
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static void fixPixelBleeding(TextureRegion region) {
/* 50 */     float fix = 0.01F;
/*    */     
/* 52 */     float x = region.getRegionX();
/* 53 */     float y = region.getRegionY();
/* 54 */     float width = region.getRegionWidth();
/* 55 */     float height = region.getRegionHeight();
/* 56 */     float invTexWidth = 1.0F / region.getTexture().getWidth();
/* 57 */     float invTexHeight = 1.0F / region.getTexture().getHeight();
/*    */     
/* 59 */     region.setRegion((
/* 60 */         x + fix) * invTexWidth, (
/* 61 */         y + fix) * invTexHeight, (
/* 62 */         x + width - fix) * invTexWidth, (
/* 63 */         y + height - fix) * invTexHeight);
/*    */   }
/*    */ }


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\FixedMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */