package view;

public class SamuraiWeaponView extends OrderImageView {
	
	private int SCALE;
	private int WIDTH = 60*SCALE;
	private int BODY_X = WIDTH/2-10*SCALE;
	private int BODY_Y = 60*SCALE;
	
	private int height_fix = 0;
	private int width_fix = 0;
	//zOrder
	public int number;
	public int frontZOrder;
	public int backZOrder;
	public int[] frontRotatePivot;
	public int[] backRotatePivot;
	public int[] frontLayout;
	public int[] backLayout;
	public int[] frontAngle;
	public int[] backAngle;
	public int[] armAngle;//move时拿武器的arm 0: front right 1: back left

	/*
	 * frontAngle[] / backAngel[]:
	 * weapon: move1 occupy2
	 * leftArm: move2 occupy2
	 * rightArm: move2 occupy2
	 * 
	*/
	public SamuraiWeaponView(int number, int scale) {
		super(Images.WEAPON[number/100][number%100/10][number%10]);
		
		this.SCALE = scale;
		this.WIDTH = 60*SCALE;
		this.BODY_X = WIDTH/2-10*SCALE;
		this.BODY_Y = 60*SCALE;
		this.setFitWidth(Images.WEAPON[number/100][number%100/10][number%10].getWidth()/6*SCALE);
		this.setSmooth(true);
		this.setPreserveRatio(true);	
		this.number = number;
		this.setInit();		
	}

	private void setInit(){
		switch(number){
			//spear
			case 00:
				this.setFitWidth(6*SCALE);
				break;
			case 11:
				this.setFitWidth(7*SCALE);
				break;
			case 12:
				this.setFitWidth(6*SCALE);
				break;
			case 13:
				this.setFitWidth(17*SCALE);
				width_fix = 4*SCALE;
				break;
			case 14:
				this.setFitWidth(9*SCALE);
				break;
			case 15:
				this.setFitWidth(21*SCALE);
				height_fix = -11*SCALE;
				break;
			case 16:
				this.setFitWidth(18*SCALE);
				height_fix = -10*SCALE;
				break;
			case 23:
				this.setFitWidth(8*SCALE);
				break;
			case 25:
				this.setFitWidth(7*SCALE);
				break;
			case 26:
				this.setFitWidth(16*SCALE);
				height_fix = -14*SCALE;
				break;
			case 33:
				this.setFitWidth(9*SCALE);
				height_fix = 7*SCALE;
				break;
			case 34:
				this.setFitWidth(15*SCALE);
				break;
			case 35:
				this.setFitWidth(8*SCALE);
				height_fix = 5*SCALE;
				break;
			case 36:
				this.setFitWidth(16*SCALE);
				height_fix = 8*SCALE;
				break;
				
			//sword
			case 100:
				this.setFitWidth(14*SCALE);
				break;
			case 111:
				this.setFitWidth(12*SCALE);
				break;
			case 112:
				this.setFitWidth(8*SCALE);
				height_fix = -10*SCALE;
				break;
			case 113:
				this.setFitWidth(14*SCALE);
				break;
			case 114:
				this.setFitWidth(10*SCALE);
				height_fix = -3*SCALE;
				break;
			case 115:
				this.setFitWidth(18*SCALE);
				height_fix = -5*SCALE;
				break;
			case 116:
				this.setFitWidth(24*SCALE);
				height_fix = -5*SCALE;
				break;
			case 124:
				this.setFitWidth(14*SCALE);
				height_fix = -11*SCALE;
				break;
			case 125:
				this.setFitWidth(20*SCALE);
				height_fix = -9*SCALE;
				break;
			case 126:
				this.setFitWidth(16*SCALE);
				height_fix = -11*SCALE;
				break;
			case 132:
				this.setFitWidth(10*SCALE);
				height_fix = 26*SCALE;
				break;
			case 133:
				this.setFitWidth(7*SCALE);
				height_fix = 27*SCALE;
				break;
			case 134:
				this.setFitWidth(11*SCALE);
				height_fix = 27*SCALE;
				break;
			case 135:
				this.setFitWidth(12*SCALE);
				height_fix = 27*SCALE;
				break;
			case 136:
				this.setFitWidth(8*SCALE);
				height_fix = 29*SCALE;
				break;
			
			//battleax
			case 200:
				this.setFitWidth(18*SCALE);
				width_fix = 5*SCALE;
				break;
			case 211:
				this.setFitWidth(23*SCALE);
				width_fix = 5*SCALE;
				height_fix = 2*SCALE;
				break;
			case 212:
				this.setFitWidth(18*SCALE);
				width_fix = 5*SCALE;
				break;
			case 213:
				this.setFitWidth(31*SCALE);
				width_fix = 11*SCALE;
				height_fix = -29*SCALE;
				break;
			case 214:
				this.setFitWidth(32*SCALE);
				width_fix = 14*SCALE;
				height_fix = -27*SCALE;
				break;
			case 215:
				this.setFitWidth(37*SCALE);
				width_fix = 18*SCALE;
				height_fix = -31*SCALE;
				break;
			case 216:
				this.setFitWidth(25*SCALE);
				width_fix = 5*SCALE;
				height_fix = -27*SCALE;
				break;
			case 225:
				this.setFitWidth(38*SCALE);
				width_fix = 19*SCALE;
				height_fix = -5*SCALE;
				break;
			case 226:
				this.setFitWidth(36*SCALE);
				width_fix = 18*SCALE;
				height_fix = -16*SCALE;
				break;
			case 233:
				this.setFitWidth(27*SCALE);
				width_fix = 8*SCALE;
				break;
			case 234:
				this.setFitWidth(34*SCALE);
				width_fix = 17*SCALE;
				height_fix = -2*SCALE;
				break;
			case 235:
				this.setFitWidth(28*SCALE);
				width_fix = 12*SCALE;
				height_fix = -14*SCALE;
				break;
			case 236:
				this.setFitWidth(36*SCALE);
				width_fix = 16*SCALE;
				height_fix = -2*SCALE;
				break;
				
			//shuriken
			case 300:
				this.setFitWidth(20*SCALE);
				break;
			case 311:
				this.setFitWidth(8*SCALE);
				height_fix = -16*SCALE;
				break;
			case 312:
				this.setFitWidth(30*SCALE);
				height_fix = -6*SCALE;
				break;
			case 313:
				this.setFitWidth(6*SCALE);
				height_fix = -16*SCALE;
				break;
			case 314:
				this.setFitWidth(10*SCALE);
				height_fix = -17*SCALE;
				break;
			case 315:
				this.setFitWidth(8*SCALE);
				height_fix = -16*SCALE;
				break;
			case 316:
				this.setFitWidth(4*SCALE);
				height_fix = -8*SCALE;
				break;
			case 323:
				this.setFitWidth(20*SCALE);
				break;
			case 324:
				this.setFitWidth(24*SCALE);
				height_fix = -4*SCALE;
				break;
			case 325:
				this.setFitWidth(27*SCALE);
				height_fix = -5*SCALE;
				break;
			case 326:
				this.setFitWidth(28*SCALE);
				height_fix = -4*SCALE;
				break;
				
			//bow and arrow
			case 400:
				this.setFitWidth(18*SCALE);
				this.setFitHeight(62*SCALE);
				break;
			case 411:
				this.setFitWidth(18*SCALE);
				this.setFitHeight(66*SCALE);
				break;
			case 412:
				this.setFitWidth(18*SCALE);
				this.setFitHeight(62*SCALE);
				break;
			case 413:
				this.setFitWidth(15*SCALE);
				this.setFitHeight(67*SCALE);
				width_fix = 5*SCALE;
				break;
			case 414:
				this.setFitWidth(20*SCALE);
				this.setFitHeight(66*SCALE);
				width_fix = 6*SCALE;
				break;
			case 415:
				this.setFitWidth(28*SCALE);
				this.setFitHeight(66*SCALE);
				width_fix = 1*SCALE;
				break;
			case 416:
				this.setFitWidth(24*SCALE);
				this.setFitHeight(73*SCALE);
				width_fix = 7*SCALE;
				break;
			case 422:
				this.setFitWidth(59*SCALE);
				this.setFitHeight(69*SCALE);
				width_fix = -15*SCALE;
				break;
			case 423:
				this.setFitWidth(87*SCALE);
				this.setFitHeight(71*SCALE);
				width_fix = -47*SCALE;
				break;
			case 424:
				this.setFitWidth(68*SCALE);
				this.setFitHeight(76*SCALE);
				width_fix = -32*SCALE;
				break;
			case 425:
				this.setFitWidth(65*SCALE);
				this.setFitHeight(74*SCALE);
				width_fix = -23*SCALE;
				break;
			case 426:
				this.setFitWidth(81*SCALE);
				this.setFitHeight(76*SCALE);
				width_fix = -39*SCALE;
				break;
				
			//arrow
			case 500:
				this.setFitWidth(50*SCALE);
				break;
			case 511:
				this.setFitWidth(49*SCALE);
				break;
			case 512:
				this.setFitWidth(50*SCALE);
				break;
			case 513:
				this.setFitWidth(52*SCALE);
				break;
			case 514:
				this.setFitWidth(51*SCALE);
				break;
			case 515:
				this.setFitWidth(51*SCALE);
				break;
			case 516:
				this.setFitWidth(51*SCALE);
				break;
		}
		
		
		int centerX;
		int offsetX;
		int offsetXOther;
		
		switch(number/100){
		case 0:
			centerX = 3*SCALE;
			offsetX = centerX-this.fitWidthProperty().intValue()/2-width_fix;
			offsetXOther = centerX-this.fitWidthProperty().intValue()/2+width_fix;
			
			frontZOrder = 5;
			backZOrder = 15+6;
			
			frontLayout = new int[]{BODY_X+30*SCALE+offsetX, BODY_Y-45*SCALE+height_fix};
			backLayout = new int[]{BODY_X-14*SCALE+offsetXOther, BODY_Y-45*SCALE+height_fix};
			frontRotatePivot = new int[]{-8*SCALE-offsetX, 52*SCALE-height_fix};
			backRotatePivot = new int[]{-13*SCALE-offsetX, 52*SCALE-height_fix};
			//
			//front left: -20 # 50      right: -15 # 50
			//back  left: -85 # 50     right: 30 # 50
			armAngle = new int[]{-25, -75};
			frontAngle = new int[]{0, 90, 50,
					-40, 25, 0, -30,
					-25, -25, 15, -15};
			backAngle = new int[]{0, 90, 50,
					-75, -75, -35, -85,
					-25, 35, 0, 40};
			break;
		case 1:
			centerX = 7*SCALE;
			offsetX = offsetXOther = centerX-this.fitWidthProperty().intValue()/2-width_fix;
			frontZOrder = 17+6;
			backZOrder = 9;

			frontLayout = new int[]{BODY_X+30*SCALE+offsetX, BODY_Y-54*SCALE+height_fix};
			backLayout = new int[]{BODY_X-22*SCALE+offsetXOther, BODY_Y-52*SCALE+height_fix};
			frontRotatePivot = new int[]{-8*SCALE-offsetX, 59*SCALE-height_fix};
			backRotatePivot = new int[]{-11*SCALE-offsetXOther, 59*SCALE-height_fix};
			//
			//front right: -15 # 40
			//back left: -65 # 40
			armAngle = new int[]{-25, -75};
			frontAngle = new int[]{30, 95, 50,
					-40, 25, 0, 25,
					-25, -25, 35, -5};
			backAngle = new int[]{30, 95, 50,
					-75, -75, -10, -55,
					-25, 35, 0, -25};
			break;
		case 2:
			centerX = 5*SCALE;
			offsetX = centerX-width_fix;
			offsetXOther = 18*SCALE-this.fitWidthProperty().intValue()+width_fix-centerX;
			frontZOrder = 17+6;
			backZOrder = 9;
			
			frontLayout = new int[]{BODY_X+28*SCALE+offsetX, BODY_Y-48*SCALE+height_fix};
			backLayout = new int[]{BODY_X-25*SCALE+offsetXOther, BODY_Y-35*SCALE+height_fix};
			frontRotatePivot = new int[]{-8*SCALE-offsetX, 54*SCALE-height_fix};
			backRotatePivot = new int[]{-10*SCALE-offsetX, 42*SCALE-height_fix};
			//
			//front right: -50 # 30
			//back left: -60 # 30
			armAngle = new int[]{-30, -40};
			frontAngle = new int[]{50, 10, 80,
					-40, 25, 0, 25,
					-30, -30, -70, 0};
			backAngle = new int[]{50, 10, 80,
					-40, -40, -80, -10,
					-25, 35, 0, -25};
			break;
		case 3:
			centerX = 10*SCALE;
			offsetX = offsetXOther = centerX-this.fitWidthProperty().intValue()/2-width_fix;
			frontZOrder = 17+6;
			backZOrder = 9;
			
			frontLayout = new int[]{BODY_X+23*SCALE+offsetX, BODY_Y+9*SCALE+height_fix};
			backLayout = new int[]{BODY_X-18*SCALE+offsetXOther, BODY_Y+13*SCALE+height_fix};
			frontRotatePivot = new int[]{this.fitWidthProperty().intValue()/2, this.fitWidthProperty().intValue()/2};
			backRotatePivot = new int[]{this.fitWidthProperty().intValue()/2, this.fitWidthProperty().intValue()/2};
			//
			//front right: -50 # 30
			//back left: -60 # 30
			armAngle = new int[]{-10, -50};
			frontAngle = new int[]{0, 10, 720,
					-40, 25, 0, 25,
					-10, -10, 10, -30};
			backAngle = new int[]{0, 10, 720,
					-50, -50, -30, -70,
					-25, 35, 0, -25};
			break;
		case 4:
			centerX = 18*SCALE;
			int centerY = 31*SCALE;
			int offsetY = centerY-this.fitHeightProperty().intValue()/2;
			offsetXOther = this.fitWidthProperty().intValue()+width_fix-centerX;
			frontZOrder = 5;
			backZOrder = 15+6;
			
			frontLayout = new int[]{BODY_X+15*SCALE+width_fix, BODY_Y-19*SCALE+offsetY};
			backLayout = new int[]{BODY_X-15*SCALE-offsetXOther, BODY_Y-14*SCALE+offsetY};
			frontRotatePivot = new int[]{-6*SCALE-width_fix, 23*SCALE-offsetY};
			backRotatePivot = new int[]{-1*SCALE-width_fix, 33*SCALE-offsetY};
			//front right: -20 # 0
			//back left: -75 # 0
			armAngle = new int[]{-20, -75};
			frontAngle = new int[]{0, -25, -25,
					0, 0, 0, -130,
					-20, -20, -45, -45};
			backAngle = new int[]{0, -25, -25,
					-75, -75, -100, -100,
					0, 0, 0, 60};
			break;
		case 5:
			frontZOrder = 5;
			backZOrder = 15+6;
			
			frontLayout = new int[]{BODY_X-28*SCALE, BODY_Y+24*SCALE};
			backLayout = new int[]{BODY_X-0*SCALE, BODY_Y+18*SCALE};
			frontRotatePivot = new int[]{-5*SCALE, -58*SCALE};
			backRotatePivot = new int[]{13*SCALE, -60*SCALE};

			frontAngle = new int[]{0, -25, -25};
			backAngle = new int[]{0, -25, -25};
			break;
		}
		
		
		//300 shuriken
		switch(number){
		case 311:
		case 313:
		case 314:
		case 315:
		case 316:
			centerX = 10*SCALE;
			offsetX = offsetXOther = centerX-this.fitWidthProperty().intValue()/2-width_fix;
			
			frontLayout = new int[]{BODY_X+21*SCALE+offsetX, BODY_Y+9*SCALE+height_fix};
			backLayout = new int[]{BODY_X-16*SCALE+offsetXOther, BODY_Y+13*SCALE+height_fix};
			frontRotatePivot = new int[]{this.fitWidthProperty().intValue()/2, 26*SCALE};
			backRotatePivot = new int[]{this.fitWidthProperty().intValue()/2, 26*SCALE};
			frontAngle = new int[]{30, 10, 120,
					-40, 25, 0, 25,
					-10, -10, 10, -30};
			backAngle = new int[]{30, 10, 120,
					-50, -50, -30, -70,
					-25, 35, 0, -25};
		}
		/*
		 * frontAngle[] / backAngel[]:
		 * weapon: move1 occupy2
		 * leftArm: move2 occupy2
		 * rightArm: move2 occupy2
		 * 
		*/

	}
	
}
