package com.base.flashcard;

public class Flashcard {

	public String question, answer;
	public String[] tags;
	
	public Flashcard(String question, String answer, String[] tags){
		this.question = question;
		this.answer = answer;
		this.tags = tags;
	}
	
	public void add_tags(String[] tags){
		for(int i = 0; i < tags.length; i++){
			this.tags[this.tags.length + 1] = tags[i];
		}
	}
	
	public void remove_tag(String remove){
		for(int i = 0; i < tags.length; i++){
			if(tags[i].equals(remove)) tags[i] = "";
		}
	}
	
}
