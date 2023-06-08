import java.util.ArrayList;
import java.util.Iterator;

public class CourseModuleStorage {
	ArrayList<String> courseModule = new ArrayList<>();
	
	public CourseModuleStorage() {
		this.courseModule = new ArrayList<>();
	}
	
	public void addCourseModule() {
		courseModule.add("Math");
		courseModule.add("Electrical Engineering");
		courseModule.add("Electronics");
		courseModule.add("Database");
		courseModule.add("Software Engineering");
	}
	
	//create an iterator for the ArrayList courseModule
	//iterate through the arraylist and print them out
	public void courseModuleIterator() {
		Iterator<String> it = courseModule.iterator();
		while(it.hasNext()) {
			System.out.println(it.next() + " ");
		}
	}

}
