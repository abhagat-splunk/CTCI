import java.util.*;
abstract class Animal{
	private int order;
	private String name;
	public void setOrder(int n){
		order = n;
	}
	Animal(String n){
		name = n;
	}
	public int getOrder(){
		return order;
	}

	public String getName(){
		return name;
	}
	public boolean isOlderthan(Animal a){
		return this.order<a.getOrder();
	}

}

class Dog extends Animal{
	Dog(String n){
		super(n);
	}
}


class Cat extends Animal{
	Cat(String n){
		super(n);
	}
}

class AQ{
	LinkedList<Dog> dogs =  new LinkedList<Dog>();
	LinkedList<Cat> cats =  new LinkedList<Cat>();
	private int order = 0;
	public void enqueue(Animal a){
			a.setOrder(order);
			order++;

			if(a instanceof Dog){
				dogs.addLast((Dog) a);
			}
			if(a instanceof Cat){
				cats.addLast((Cat) a);
			}
		}
	public Animal dequeueAny(){
		if(dogs.size()==0){
			return dequeueCats();
		}
		else if(cats.size()==0){
			return dequeueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderthan(cat)){
			return dequeueDogs();
		}
		else{
			return dequeueCats();
		}
	}
	public Dog dequeueDogs(){
		return dogs.poll();
	}

	public Cat dequeueCats(){
		return cats.poll();
	}
}

public class AnimalQueue{
	public static void main(String args[]){
		AQ aq = new AQ();
		aq.enqueue(new Dog("Tommy"));
		aq.enqueue(new Cat("Muffles"));
		aq.enqueue(new Cat("Lol"));
		aq.enqueue(new Dog("Batman"));
		System.out.println(aq.dequeueAny().getName());
	}
}