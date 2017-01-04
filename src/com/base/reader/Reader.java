package com.base.reader;

import com.base.flashcard.Flashcard;

public class Reader {

	public Flashcard[] questions;
	private int current = 0;
	
	public Reader(Flashcard[] questions){
		this.questions = questions;
	}
	
	public void read(){
		String current_card = questions[current].question;
		
	}
	
}
