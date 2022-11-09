public class SaPPuZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaPPuZSplashScreen obj = new SaPPuZSplashScreen(5000);
		
		obj.showSplashWindow();

		SaPPuZModel model=new SaPPuZModel();
		SaPPuZView view=new SaPPuZView();
		SaPPuZController controller=new SaPPuZController(model, view);
		controller.initController();

//	System.out.print(testmodel.getList());
//		System.out.print(testmodel.getCol());
//		System.out.print(testmodel.getRow());

	
	}

}