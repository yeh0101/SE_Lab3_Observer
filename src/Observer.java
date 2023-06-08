public interface Observer {
	
	//method to update the observer, used by subject
	//used by Subject to notify of any change
	public void update();
	//public void update(String updateCourseModule);
	
	//attach with subject to observe
	//attach the Subject to the observer
	//CourseModuleView is subjected to CourseModuleController
	public void setSubject(Subject subject);
}