package com.base.flashcard;
import javax.swing.*;
import java.util.ArrayList;
public class Flashcard {

	public String question, answer;
	public String[] tags;
	public static ArrayList<Flashcard> cardList = new ArrayList<Flashcard>();
    int totalIndices = 0;
    public int index;
	
	public Flashcard(String question, String answer, String[] tags){
		this.question = question;
		this.answer = answer;
		this.tags = tags;
        this.index = totalIndices;
        totalIndices++;
		cardList.add(this);
	}

	public static Flashcard currentCard(int val){
        return cardList.get(val);
    }

    /**
     * Takes the index of the object the method is invoked on and returns the object in the next index of the
     * arraylist, if no more new elements are left then the first element of the array is returned
     *
     * @return The next flashcard object in an arraylist
     */
	public Flashcard nextCard(){
        if(this.index + 1 >= cardList.size()){
            JOptionPane.showMessageDialog(null, "No more new flashcards in this list, returning to beginning");
            return cardList.get(0);
        }else{
            return cardList.get(this.index + 1);
        }
    }
	
	public void remove_tag(String remove){
		for(int i = 0; i < tags.length; i++){
			if(tags[i].equals(remove)) tags[i] = "";
		}
	}
	
}
