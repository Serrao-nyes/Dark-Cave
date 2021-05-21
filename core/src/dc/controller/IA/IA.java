package dc.controller.IA;

import com.badlogic.gdx.utils.Array;
import dc.parameters.CombatEntityParameters;

public abstract class IA {
  public abstract CombatEntityParameters.Choise SelectAction();
  
  public abstract int SelectTarget(Array<CombatEntityParameters> paramArray);
}


/* Location:              C:\Users\maste\Downloads\Dark Cave 1.1.1.jar!\dc\controller\IA\IA.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */