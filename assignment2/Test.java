class Test { 

    public static void main(String [] args) { 

	MySet<String> words = new MySet<>(6); 
	

	for(int i=0; i < args.length; i++) 
	    words.add(args[i]); 

	// words.add("Hello");
	// words.add("Hey");
	// words.add("Maths");
	// words.add("Java");
	// words.add("Java");

	// words.print();

	String st;
	while((st = words.remove()) != null)
		System.out.println(st);

	// words. remove();

	// words.print();
    }


}