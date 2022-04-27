// Team BrainForked (Gloria Lee, Jack Chen, Kevin)
// APCS pd8
// L09: Some Folks Call It A Charades
// 2022-04-26t
// time spent: 1.5 h

/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	private String _clue;

	private String _answer;

	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String answer, String clue)
	{
		_answer = answer;
		_clue = clue;
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return _clue;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return _answer;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String clue)
	{
		_clue = clue;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String answer)
	{
		_answer = answer;
	}

	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		return _answer + ": "+ _clue;
	}

	public static void main(String[] args){
		Celebrity a = new Celebrity("Biden", "current president");
		System.out.println(a);
		a.setAnswer("Trump");
		a.setClue("the previous president");
		System.out.println(a);
	}

}