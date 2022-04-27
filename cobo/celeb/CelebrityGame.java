// Team BrainForked (Gloria Lee, Jack Chen, Kevin)
// APCS pd8
// L09: Some Folks Call It A Charades
// 2022-04-26t
// time spent: 1.5 h
import java.util.ArrayList;

/**
 * The framework for the Celebrity Game project
 *
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	private Celebrity gameCelebrity;

	 private CelebrityFrame gameWindow;

	private ArrayList<Celebrity> celebGameList;

	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame()
	{
		celebGameList = new ArrayList<Celebrity>();
		gameWindow = new CelebrityFrame(this);
	}

	/**
	 * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
	 */
	public void prepareGame()
	{
		celebGameList = new ArrayList<Celebrity>();
    gameWindow.replaceScreen("START");
	}

	/**
	 * Determines if the supplied guess is correct.
	 *
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 *         spaces.
	 */
	public boolean processGuess(String guess)
	{
		String clue = guess.trim();
		if(clue.equalsIgnoreCase(gameCelebrity.getAnswer())){
			celebGameList.remove(celebGameList.size()-1);
			if(celebGameList.size()==0){
				gameCelebrity = new Celebrity("","");
			}else{
				gameCelebrity = celebGameList.get(celebGameList.size()-1);
			}
			return true;
		}
		return false;
	}

	/**
	 * Asserts that the list is initialized and contains at least one Celebrity.
	 * Sets the current celebrity as the first item in the list. Opens the game
	 * play screen.
	 */
	public void play()
	{
		if (celebGameList != null && celebGameList.size() > 0) {
			this.gameCelebrity = celebGameList.get(0); 
			gameWindow.replaceScreen("GAME"); 
		}
	}

	/**
	 * Adds a Celebrity of specified type to the game list
	 *
	 * @param name
	 *            The name of the celebrity
	 * @param guess
	 *            The clue(s) for the celebrity
	 * @param type
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String guess, String type)
	{
		Celebrity currentCelebrity;
		if (type.equals("Literature")) {
			currentCelebrity = new LiteratureCelebrity(name, guess);
		}
		else if (type.equals("VideoGame")) {
			currentCelebrity = new VideoGameCelebrity(name, guess); 
		}
		else {
			currentCelebrity = new Celebrity(name, guess);
		}
		this.celebGameList.add(currentCelebrity); 
		
		// if(validateClue(guess, type)&& validateCelebrity(name)){
		// 	Celebrity newCeleb = new Celebrity(name, guess);
		// 	celebGameList.add(newCeleb);
		// }
		
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
		return name.trim().length()>=4;
	}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity
	 * @return If the clue is valid.
	 */
	public boolean validateClue(String clue, String type)
	{
		boolean validClue = false; 
		if (clue.trim().length()>=10) {
			validClue = true; 
			if (type.equalsIgnoreCase("literature")) {
				String temp[] = clue.split(","); 
				if (temp.length > 1) {
					validClue = true;
				}
				else {
					validClue = false;
				}
			}
			if (type.equalsIgnoreCase("videogame")) {
				String temp[] = clue.split(","); 
				if (temp.length > 1) {
					validClue = true;
				}
				else {
					validClue = false;
				}
			}
		}
			return validClue; 
			// return clue.trim().length()>=10;

	}

	/**
	 * Accessor method for the current size of the list of celebrities
	 *
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize()
	{
		return celebGameList.size();
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 *
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
		return gameCelebrity.getClue();
	}

	/**
	 * Accessor method for the games answer to maintain low coupling between
	 * classes
	 *
	 * @return The String answer from the current celebrity.
	 */
	public String sendAnswer()
	{
		return gameCelebrity.getAnswer();
	}
}