package com.accenture.ltt.lambdaexp.sample;

public class DrawableTest {
	
	//method to draw a shape by calling Drawable draw method
	void drawShape(Drawable drawable) {
		drawable.draw();
	}
	
	public static void main(String[] args) {
		
		DrawableTest drawableTest = new DrawableTest();
		
		//Circle implementation of Drawable interface
		Drawable circle = () -> {
			System.out.println("Drawing circle");
		};
		//Rectangle implementation of Drawable interface
		Drawable rectangle = () -> {
			System.out.println("Drawing rectangle");
		};
		//Traingle implementation of Drawable interface
		Drawable traingle = () -> {
			System.out.println("Drawing traingle");
		};
		
		//need circle implementation so passing circle reference in drawShape method
		drawableTest.drawShape(circle);
		
		//need rectangle implementation so passing rectangle reference in drawShape method
		drawableTest.drawShape(rectangle);
		
		//need traingle implementation so passing traingle reference in drawShape method
		drawableTest.drawShape(traingle);
	}

}
