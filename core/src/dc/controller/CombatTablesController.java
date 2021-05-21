package dc.controller;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import dc.parameters.CombatEntityParameters;
import dc.view.CombatScreen;
import dc.view.box.combat.ChoiseTab;
import dc.view.box.combat.MagicTab;
import dc.view.box.combat.ParaTab;
import dc.view.box.combat.TargetTab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class CombatTablesController {
	
	private ChoiseTab choise;
	private TargetTab target;
	private MagicTab magic;
	private ParaTab para;
	
	private Table turn;
	private Label name;
	
	private Table text;
	private Label textmsg;
	
	private Table combatmsg;
	private Label msg;
	
	private int index;
	
	public CombatScreen screen;
	
	private boolean choiseCheck = true;
	private boolean targetCheck = false;
	private boolean magicCheck = false;
	
	private Integer choiseNumber = null;
	private Integer targetNumber = null;
	private Integer magicNumber = null;
	
	public CombatTablesController(CombatScreen screen) {
		this.screen = screen;
		
		//INIZIALIZZAZIONE DEI TAB
		choise = new ChoiseTab(screen.skin);
		target = new TargetTab(screen.skin);
		magic = new MagicTab(screen.skin);
		para = new ParaTab(screen.skin);
		
		turn = new Table(screen.skin);
		name = new Label("", screen.skin);
		name.setFontScale(1.22f);
		
		combatmsg = new Table(screen.skin);
		msg = new Label("", screen.skin);
		msg.setFontScale(1.10f);
		combatmsg.setPosition(230, 640);
		
		text = new Table(screen.skin);
		textmsg = new Label("", screen.skin);
		textmsg.setFontScale(1.15f);
		text.background("window");
		text.setPosition(410, 630);
		text.setSize(200, 90);
		
		//SETTARE I TAB IN INVISIBILE
		target.setVisible(false);
		magic.setVisible(false);
		para.setVisible(false);
		turn.setVisible(false);
		text.setVisible(false);
		combatmsg.setVisible(false);
		
		//AGGIUNGERLI ALLO STAGE
		screen.stage.addActor(para);
		screen.stage.addActor(choise);
		screen.stage.addActor(target);
		screen.stage.addActor(magic);
		screen.stage.addActor(turn);
		screen.stage.addActor(text);
		screen.stage.addActor(combatmsg);
	}
		
	public void reset() { //Reset chiamato ad ogni inizio turno
		choiseNumber = null;
		targetNumber = null;
		magicNumber = null;
		choiseCheck = true;
		targetCheck = false;
		magicCheck = false;
		turn.clear();
		choise.reset();
		text.clearChildren(); //Utilizzato per evitare possibile bug sul messaggio di vittoria
		text.setVisible(false);
	}
	
	public void clearMessage() {
		combatmsg.clearChildren();
		combatmsg.setVisible(false);
	}
	
	public void setMessage(final String message) { //Setta messaggio di combattimento
		msg.setText(message);
		Timer.schedule(new Task() {
			
			{
				combatmsg.add(msg).align(Align.right).right();
				combatmsg.setVisible(true);
			}
			
			@Override
			public void run() {
				clearMessage();
			}

		}, 1.3f);
	}
	
	public void clearText() {
		text.clearChildren();
		text.setVisible(false);
	}
	
	public void endText(String msg) { //Setta messaggio di vittoria o sconfitta
		textmsg.setText(msg);
		text.add(textmsg).center();
		text.setVisible(true);
		turn.clear();
		choise.reset();
	}
	
	public void who(int i) { //Comunica alla classe il personaggio che deve scegliere nel turno
		this.index = i;
		name.clear();
		if(index == 0) {
			name.setText("Azione: Flik");
		}
		if(index == 1) {
			name.setText("Azione: Pesmerga");
		}
		if(index == 2) {
			name.setText("Azione: Ted");
		}
		if(index == 3) {
			name.setText("Azione: Lotte");
		}
		turn.addActor(name);
		turn.setPosition(740, 180);
		turn.setVisible(true);
	}
	
	public void genPara(Array<CombatEntityParameters> Entities) { //Aggiorna parametri di squadra
		para.update(Entities);
	}
	
	public void genChoise() { //Genera le scelte in base al personaggio
		choise.ability(index);
		choise.setVisible(true);
		choiseCheck = true;
	}
	
	public void genTarget(Array<CombatEntityParameters> Entities) { //Genera i target da colpire
		target.init(Entities);
		targetCheck = true;
	}
	
	public void genMagic() { //Genera la magia in base al personaggio
		magic.init(index);
		magicCheck = true;
	}
	
	public void keyDown() {
		keyDownChoise();
		keyDownTarget();
		keyDownMagic();
	}
	
	public void keyDownChoise() {
		if(choiseCheck == true) {
			targetNumber = null;
			if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
				choise.moveUp();
			} else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
				choise.moveDown();
			} else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
				choise.moveRight();
			} else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
				choise.moveLeft();
			} else if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
				setChoise(choise.getSelected() + 1);
				choiseCheck = false;
			}
		}
	}
	
	public void setChoise(Integer n) {
		this.choiseNumber = n;
	}
	
	public Integer getChoise() {
		return choiseNumber;
	}
	
	public void keyDownTarget() {
		if(targetCheck == true) {
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
				target.moveUp();
			} else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
				target.moveDown();
			} else if(Gdx.input.isKeyJustPressed(Input.Keys.C)) {
				setTarget(9);
				target.clear();
				choiseCheck = true;
				targetCheck = false;
			} else if(Gdx.input.isKeyJustPressed(Input.Keys.X)) {
					setTarget(target.getSelected());
			}
		}
	}
	
	public void setTarget(Integer n) {
		this.targetNumber = n;
		target.clear();
	}
	
	public Integer getTarget() {
		return targetNumber;
	}
	
	public void keyDownMagic() {
		if(magicCheck == true) {
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
				magic.moveUp();
			} else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
				magic.moveDown();
			} else if(Gdx.input.isKeyJustPressed(Input.Keys.C)) {
				setMagic(9);
				magic.clear();
				choiseCheck = true;
				magicCheck = false;
			} else if(Gdx.input.isKeyJustPressed(Input.Keys.X)) {
				setMagic(magic.getSelected() + 1);
			}
		}
	}
	
	public void setMagic(Integer n) {
		this.magicNumber = n;
		magic.clear();
	}
	
	public Integer getMagic() {
		return magicNumber;
	}
}

