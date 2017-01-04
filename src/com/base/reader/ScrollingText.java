package com.base.reader;

public class ScrollingText {

	// FIX THIS TO JAVA SPECIFICS

	// takes in an array of text and the frame count before displaying another
	// character
	public String[] textBits;
	public float timePerCharacter = 2f;

	// counters for showing string to load
	private int counter = 0;
	private int stringIndex = 0;
	// the final text that will go on the screen, updated by ScrollText()
	private String finalText = "";
	// default message for prompting at end of text
	private String continuePrompt = " PRESS SPACE TO CONTINUE ";

	public ScrollingText() {
		for (int i = 0; i < textBits.length; i++) {
			textBits[i] += continuePrompt;
		}
	}

	// returns a char array to plug text into
	public char[] TextToScroll(String s) {
		// makes an array of chars to individually add the text
		char[] characters = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			// sets the array of characters to contain each individual char from
			// string
			char temp = s.charAt(i);
			characters[i] = temp;
		}
		return characters;
	}

	// scrolls the text
	/*
	 * public void ScrollText(char[] text) { if (Time.frameCount %
	 * timePerCharacter == 0 && counter != text.length) { //adds next char to
	 * the text to be displayed finalText += text[counter]; counter++; //updates
	 * text //textToDisplay.text = finalText; } }
	 */

	// Update is called once per frame
	/*
	 * void Update () { //allows for text skipping //Implement text skipping :
	 * When text is at final index, and space is pressed - string index ++
	 * char[] textBit = TextToScroll(textBits[stringIndex]); //scrolls text
	 * ScrollText(textBit); if(counter >= textBit.Length &&
	 * Input.GetKey(KeyCode.Space)) { //resets text and counter, loads next
	 * string finalText = ""; counter = 0; stringIndex++; } }
	 */
}
