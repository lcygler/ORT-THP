package ejemplos.varios;

class Animal {
	public void animalSound() {
		System.out.println("An animal can make a sound.");
	}
}

class Cow extends Animal {
	public void animalSound() {
		System.out.println("A cow says: Moooo");
	}
}

class Cat extends Animal {
	public void animalSound() {
		System.out.println("A cat says: Meeooww");
	}
}

class Animales {
	public static void main(String[] args) {
		Animal myAnimal = new Animal();
		Cow myCow = new Cow();
		Cat myCat = new Cat();

		myAnimal.animalSound();
		myCow.animalSound();
		myCat.animalSound();
	}
}
