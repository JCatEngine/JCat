package JCat.Event;

public interface EventListener<T extends Event> {

	void onResponce(T event);
}
