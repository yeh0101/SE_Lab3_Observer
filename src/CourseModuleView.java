public class CourseModuleView implements Observer{
	private String objName;
	private Subject controller;
	
	public CourseModuleView(String objName) {
		this.objName = objName;
	}
	
	public void update() {
		String newContent = (String)controller.getUpdate(this);
		if(newContent == null) {
			System.out.println(objName + "-> No updates");
		}else {
			System.out.println(objName + "-> Updated with: " + newContent);
		}
	}
	
	public void setSubject(Subject subject) {
		controller = subject;
	}
}
