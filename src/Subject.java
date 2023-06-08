public interface Subject {

	//methods to add and remove observers
	public void addObserver(Observer obj);
	public void removeObserver(Observer obj);
	
	//method to notify observers of change
	public void notifyObserver();
	//public void notifyObserver(String updateCourseModule);
	
	//method to get updates from subject
	public Object getUpdate(Observer obj);
	
}