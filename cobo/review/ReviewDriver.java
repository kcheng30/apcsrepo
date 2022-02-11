/* Kevin Cheng
 * APCS
 * HW63 -- Read/Review/Expand
 * 2022-02-10
 * Time spent: 2 hrs
 */

/* Activity 1
 * 1. 
 * a. The method signature is "public static double".
 * b. The method requires a String, otherwise it returns 0.
 * c. The method returns a double between -1 and 1.
 *
 * 2.
 * a. bad - 0
 * b. good - 0
 * c. nasty - -2.5
 *
 * 3.
 * sentimentVal takes one String as a parameter and outputs one double, so only a would work.
 * b is trying to assign a String to be a double and c has two parameters.
 */

/* Activity 2
 * 4.
 * totalSentiment converts the review.txt file into a string, then breaks up that string
 * into individual words, separated by each space. The punctuation is then removed from
 * each word, and put into a list. The sentiment of each word is then summed together
 * into the totalSentiment.
 *
 * 5.
 * The star ratings make sense.
 * The program can be more realistic by including phrases of words that change the
 * total sentiment when the words are used in phrases.
 *
 * 6.
 * The student didn't include a star rating when the sentiment is above 15.
 * To fix that, set an if statement that converts all sentiments above 15 to a star
 * rating of 5.
 */

/* Activity 3
 * 3.
 * The indexOf method gets the position of where the string needs to be cut, and
 * substring gives the cut string. Because substring includes the lower bound, 1 must
 * be added in order to not add the space into the cut string.
 *
 * 5.
 * Static methods belong to the entire class, not just an instance of that class.
 * This means non-static classes can be unique to the instance, but static methods can't.
 *
 * 6.
 * fakeReview can take any positive or negative adjective and replace it for the
 * adjective to create fake positive or negative reviews.
 */

public class ReviewDriver {
	public static void main(String[] args) {
		Review r = new Review();
		/*
		System.out.println("bad" + r.sentimentVal("bad"));
		System.out.println("good" + r.sentimentVal("good"));
		System.out.println("nasty" + r.sentimentVal("nasty"));
		*/
		System.out.println( r.totalSentiment( "SimpleReview.txt" ) );
		System.out.println( r.starRating( "SimpleReview.txt" ) );
	}
}
