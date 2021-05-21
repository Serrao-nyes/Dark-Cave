package dc.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import dc.settings.Constans;

public class Enemies {

	private Enemies() {
	}

	private static Enemies instance = null;

	public static Enemies getInstance() {
		if (instance == null) {
			instance = new Enemies();
		}
		return instance;
	}

	public Entity CreateEntity(int ID, Entity E) {
		switch (ID) {
		case 4:
			E = new HellHound();
			return E;
		case 5:
			E = new Creeper();
			return E;
		case 6:
			E = new Kobold();
			return E;
		case 7:
			E = new Lizard();
			return E;
		case 8:
			E = new Demon();
			return E;
		case 9:
			E = new Dragon();
			return E;
		case 10:
			E = new Circolaro();
			return E;
		case 11:
			E = new Ruxoll();
			return E;

		}
		return null;
	}

	public static class HellHound extends Entity {

		private TextureRegion idle;
		private TextureRegion hurt;
		private TextureRegion region;

		public HellHound() {
			ID = 4;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			idle = new TextureRegion(new Texture(Constans.HELLHOUND));
			hurt = new TextureRegion(new Texture(Constans.HELLHOUND1));
			region = new TextureRegion();
			this.setSize(Constans.PLAYER_SCALE_WIDTH, Constans.PLAYER_SCALE_HEIGHT);
			this.setOrigin(44, 44);
		}

		@Override
		public TextureRegion getFrame(float deltaTime) {
			switch (current) {
			case IDLE:
			default: {
				region = idle;
				break;
			}
			case DYING: {
				region = hurt;
				break;
			}
			case HURTING: {
				region = hurt;
				break;
			}
			}
			return region;
		}

		@Override
		public void update(float deltaTime) {
			this.setRegion(getFrame(deltaTime));

		}

	}

	public static class Kobold extends Entity {

		private TextureRegion idle;
		private TextureRegion hurt;
		private TextureRegion region;

		public Kobold() {
			ID = 6;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			idle = new TextureRegion(new Texture(Constans.KOBOLD));
			hurt = new TextureRegion(new Texture(Constans.KOBOLD1));
			region = new TextureRegion();
			this.setSize(Constans.PLAYER_SCALE_WIDTH, Constans.PLAYER_SCALE_HEIGHT);
			this.setOrigin(44, 44);
		}

		@Override
		public TextureRegion getFrame(float deltaTime) {
			switch (current) {
			case IDLE:
			default: {
				region = idle;
				break;
			}
			case DYING: {
				region = hurt;
				break;
			}
			case HURTING: {
				region = hurt;
				break;
			}
			}
			return region;
		}

		@Override
		public void update(float deltaTime) {
			this.setRegion(getFrame(deltaTime));

		}

	}

	public static class Demon extends Entity {

		private TextureRegion idle;
		private TextureRegion hurt;
		private TextureRegion region;

		public Demon() {
			ID = 8;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			idle = new TextureRegion(new Texture(Constans.DEMON));
			hurt = new TextureRegion(new Texture(Constans.DEMON1));
			region = new TextureRegion();
			this.setSize(Constans.PLAYER_SCALE_WIDTH, Constans.PLAYER_SCALE_HEIGHT);
			this.setOrigin(44, 44);
		}

		@Override
		public TextureRegion getFrame(float deltaTime) {
			switch (current) {
			case IDLE:
			default: {
				region = idle;
				break;
			}
			case DYING: {
				region = hurt;
				break;
			}
			case HURTING: {
				region = hurt;
				break;
			}
			}
			return region;
		}

		@Override
		public void update(float deltaTime) {
			this.setRegion(getFrame(deltaTime));

		}

	}

	public static class Lizard extends Entity {
		private TextureRegion idle;
		private TextureRegion hurt;
		private TextureRegion region;

		public Lizard() {
			ID = 7;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			idle = new TextureRegion(new Texture(Constans.VIPERMAN));
			hurt = new TextureRegion(new Texture(Constans.VIPERMAN1));
			region = new TextureRegion();
			this.setSize(Constans.PLAYER_SCALE_WIDTH, Constans.PLAYER_SCALE_HEIGHT);
			this.setOrigin(44, 44);
		}

		@Override
		public TextureRegion getFrame(float deltaTime) {
			switch (current) {
			case IDLE:
			default: {
				region = idle;
				break;
			}
			case DYING: {
				region = hurt;
				break;
			}
			case HURTING: {
				region = hurt;
				break;
			}
			}
			return region;
		}

		@Override
		public void update(float deltaTime) {
			this.setRegion(getFrame(deltaTime));

		}

	}

	public static class Creeper extends Entity {

		private TextureRegion idle;
		private TextureRegion hurt;
		private TextureRegion region;

		public Creeper() {
			ID = 5;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			idle = new TextureRegion(new Texture(Constans.CREEPER));
			hurt = new TextureRegion(new Texture(Constans.CREEPER1));
			region = new TextureRegion();
			this.setSize(Constans.PLAYER_SCALE_WIDTH, Constans.PLAYER_SCALE_HEIGHT);
			this.setOrigin(44, 44);
		}

		@Override
		public TextureRegion getFrame(float deltaTime) {
			switch (current) {
			case IDLE:
			default: {
				region = idle;
				break;
			}
			case DYING: {
				region = hurt;
				break;
			}
			case HURTING: {
				region = hurt;
				break;
			}
			}
			return region;
		}

		@Override
		public void update(float deltaTime) {
			this.setRegion(getFrame(deltaTime));

		}

		public int getID() {
			return ID;
		}

	}

	public class Dragon extends Entity {

		private TextureRegion Idle;
		private TextureRegion Attack;
		private TextureRegion Attack2;
		private TextureRegion hurting;
		private TextureRegion region;
		private TextureRegion[] AttackRegion;
		private float timer;
		public Animation Attacking;

		public Dragon() {
			ID = 9;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			timer = 0;
			Idle = new TextureRegion(new Texture(Constans.DRAGONATTACKIDLE));
			Attack = new TextureRegion(new Texture(Constans.DRAGONATTACK1));
			Attack2 = new TextureRegion(new Texture(Constans.DRAGONATTACK2));
			hurting = new TextureRegion(new Texture(Constans.DRAGONHURTING));
			region = new TextureRegion();
			AttackRegion = new TextureRegion[2];
			AttackRegion[0] = Attack;
			AttackRegion[1] = Attack2;

			Attacking = new Animation(Constans.ATTACKANIMATIONTIME, AttackRegion);

			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);

		}

		@Override
		public void update(float deltaTime) {

			this.setRegion(getFrame(deltaTime));

		}

		@Override
		public TextureRegion getFrame(float deltaTime) {

			switch (current) {
			case IDLE:
			default:
				region = Idle;
				break;
			case ATTACKING: {
				region = (TextureRegion) Attacking.getKeyFrame(timer, false);
				// System.out.println(timer);
				break;
			}
			case DYING: {
				region = hurting;
				break;
			}
			case HURTING: {
				region = hurting;
				break;
			}

			}

			timer = current == previous ? timer += deltaTime : 0;
			previous = current;
			return region;
		}

		public int getID() {
			return ID;
		}
	}

	public class Circolaro extends Entity {

		private TextureRegion Idle;
		private TextureRegion Attack;
		private TextureRegion Attack2;
		private TextureRegion hurting;
		private TextureRegion region;
		private TextureRegion[] AttackRegion;
		private TextureRegion[] DyingRegion;
		private float timer;
		public Animation Dying;
		public Animation Attacking;

		public Circolaro() {
			ID = 10;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			timer = 0;
			Idle = new TextureRegion(new Texture(Constans.CIRCOLAROATTACKIDLE));
			Attack= new TextureRegion(new Texture(Constans.CIRCOLAROATTACK1));
			Attack2= new TextureRegion(new Texture(Constans.CIRCOLAROATTACK2));
			hurting = new TextureRegion(new Texture(Constans.CIRCOLAROHURTING));
			region = new TextureRegion();
			AttackRegion = new TextureRegion[2];
			AttackRegion[0] = Attack;
			AttackRegion[1] = Attack2;
			Attacking = new Animation(Constans.ATTACKANIMATIONTIME, AttackRegion);

			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);

		}

		@Override
		public void update(float deltaTime) {

			this.setRegion(getFrame(deltaTime));

		}

		@Override
		public TextureRegion getFrame(float deltaTime) {

			switch (current) {
			case IDLE:
			default:
				region = Idle;
				break;
			case ATTACKING: {
				region = (TextureRegion) Attacking.getKeyFrame(timer, false);
				// System.out.println(timer);
				break;
			}
			case DYING: {
				region = hurting;
				break;
			}
			case HURTING: {
				region = hurting;
				break;
			}

			}

			timer = current == previous ? timer += deltaTime : 0;
			previous = current;
			return region;
		}

	}

	public class Ruxoll extends Entity {

		private TextureRegion Idle;
		private TextureRegion Attack;
		private TextureRegion Attack2;
		private TextureRegion Attack3;
		private TextureRegion Dying2;
		private TextureRegion Dying3;
		private TextureRegion Hurting;
		private TextureRegion Interaction;
		private TextureRegion Interaction2;
		private TextureRegion Interaction3;
		private TextureRegion region;
		private TextureRegion[] AttackRegion;
		private TextureRegion[] DyingRegion;
		private float timer;
		public Animation Dying;
		public Animation Attacking;
		public Animation InteractionAnimation;
		private TextureRegion[] InteractionRegion;

		public Ruxoll() {
			ID = 11;
			current = STATE.IDLE;
			previous = STATE.IDLE;
			timer = 0;
			Idle = new TextureRegion(new Texture(Constans.RUXOLLATTACKIDLE));
			Attack = new TextureRegion(new Texture(Constans.RUXOLLATTACK1));
			Attack2 = new TextureRegion(new Texture(Constans.RUXOLLATTACK2));
			Attack3 = new TextureRegion(new Texture(Constans.RUXOLLATTACK3));
			Interaction= new TextureRegion(new Texture (Constans.RUXOLLINTERACTION1));
			Interaction2 = new TextureRegion(new Texture(Constans.RUXOLLINTERACTION2));
			Interaction3= new TextureRegion(new Texture(Constans.RUXOLLINTERACTION3));
			Dying2 = new TextureRegion(new Texture(Constans.RUXOLLDYING1));
			Dying3 = new TextureRegion(new Texture(Constans.RUXOLLDYING2));
			Hurting = new TextureRegion(new Texture(Constans.RUXOLLHURTING));
			region = new TextureRegion();
			AttackRegion = new TextureRegion[2];
			AttackRegion[0] = Attack;
			AttackRegion[1] = Attack2;
			DyingRegion = new TextureRegion[3];
			DyingRegion[0] = Idle;
			DyingRegion[1] = Dying2;
			DyingRegion[2] = Dying3;
			InteractionRegion= new TextureRegion[3];
			InteractionRegion[0]=Interaction;
			InteractionRegion[1]=Interaction2;
			InteractionRegion[2]=Interaction3;
			Dying = new Animation(Constans.DYINGANIMATIONTIME, DyingRegion);
			Attacking = new Animation(Constans.ATTACKANIMATIONTIME, AttackRegion);
			InteractionAnimation= new Animation(Constans.INTERACTIONANIMATIONTIME,InteractionRegion);
			this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);

		}

		@Override
		public void update(float deltaTime) {

			this.setRegion(getFrame(deltaTime));

		}

		@Override
		public TextureRegion getFrame(float deltaTime) {

			switch (current) {
			case IDLE:
			default:
				region = Idle;
				break;
			case ATTACKING: {
				region = (TextureRegion) Attacking.getKeyFrame(timer, false);
				// System.out.println(timer);
				break;
			}
			case HURTING: {
				region = Hurting;
				break;
			}
			case DYING: {
				region = (TextureRegion) Dying.getKeyFrame(timer, false);
				break;
			}

			}

			timer = current == previous ? timer += deltaTime : 0;
			previous = current;
			return region;
		}

	}

}
