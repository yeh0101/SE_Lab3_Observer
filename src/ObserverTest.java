public class ObserverTest {
	
	public static void main(String[] args) {	
		
		//create an observable Subject(CourseModuleController)
		CourseModuleController courseModuleController = new CourseModuleController();
		
		//create observers(CourseModuleView)
		Observer courseModuleView1 = new CourseModuleView("CourseModuleView1");
		Observer courseModuleView2 = new CourseModuleView("CourseModuleView2");
		Observer courseModuleView3 = new CourseModuleView("CourseModuleView3");
		
		//add observers to the Subject
		courseModuleController.addObserver(courseModuleView1);
		courseModuleController.addObserver(courseModuleView2);
		courseModuleController.addObserver(courseModuleView3);
		
		//attach observers to the Subject
		courseModuleView1.setSubject(courseModuleController);
		courseModuleView2.setSubject(courseModuleController);
		courseModuleView3.setSubject(courseModuleController);
		
		//test1: no updates
		System.out.println("--test1: CourseModule not changed--");
		courseModuleView1.update();
		
		//test2: updated with "New content"
		System.out.println("\n--test2: CourseModule changed and 3 observers(CourseModuleViews) are notified--");
		courseModuleController.CourseModuleChanged("New content");
	}
}
