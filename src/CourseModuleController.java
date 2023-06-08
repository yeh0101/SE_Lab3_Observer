import java.util.ArrayList;

// reference source: https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java

/* CourseModuleController(observable object) notifies CourseModuleView(observer)
 * when there are changes(edition) in its state, i.e.CourseModuleChanged() return true
 * Whenever new content edited to CourseModuleController, CourseModuleView(observer)
 * will be notified, and then display on the interface
*/

public class CourseModuleController implements Subject {
	private ArrayList<Observer> observers = new ArrayList<>();
	private String updateCourseModule;
	private boolean courseModuleChanged;
	private final Object MUTEX = new Object();//
	
	public CourseModuleController() {
		this.observers = new ArrayList<>();
	}
	
	//methods to add observers
	public void addObserver(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized(MUTEX) {
			if(!observers.contains(obj)) observers.add(obj);
		}
	}
	
	//methods to remove observers
	public void removeObserver(Observer obj) {
		synchronized(MUTEX) {
			observers.remove(obj);
		}
	}
	
	//method to notify observers of change
	//boolean is used to track the change in CourseModuleController
	//and used in notifying CourseModuleView
	//for(data_type variable : array_name)
	//synchronized(): used to make sure any observer added after content
	//updated is not notified
	public void notifyObserver() {
		ArrayList<Observer> observersLocal = null;
		synchronized(MUTEX) {
			if(!courseModuleChanged) return;
			observersLocal = new ArrayList<>(observers);
			courseModuleChanged = false;
		}//if courseModule is changed, then CourseModuleController
		//notifies CourseModuleView(observers) it by calling
		//observers' update method
		for(Observer obj : observersLocal) {
			obj.update();
		}
	}
	
	//method to get updates from subject
	public Object getUpdate(Observer obj) {
		return updateCourseModule;
	}
	
	//method for users to update the content for the course module
	public void CourseModuleChanged(String newContent) {
		System.out.println("Content which is updated in the course module: " + newContent);
		updateCourseModule = newContent;
		courseModuleChanged = true;
		notifyObserver();
	}

}
