package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.R.attr.text;
import static android.R.attr.type;

/**
 * This class is the main view class of the project.<br> In this class, user interaction and file manipulation is performed.
 * All files are in the form of "json" files that are stored in Emulator accessible from Android Device monitor:
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data => data -> ca.ualberta.cs.lonelytwitter -> files ->file.sav
 * </pre>
 * <code>begin
 * some pseudo code <br>
 * end.</code>
 * The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant.
 * <ul>
 *	   <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ul>
 * <ol>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ol>
 *
 * @author kassenov
 * @version 1.0
 * @see Tweet@since 0.5
 */

public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are saved there. The format of the file is JSON.
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */
	private enum TweetListOrdering{DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING}
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<Tweet> adapter;

	private ArrayList<Tweet> tweetList;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		//Tweet tweet2 = new Tweet(new Date(), "My second tweet");

		saveButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = null;
				text = trimExtraSpaces(text);

				try {
					tweet = new NormalTweet(text);
				} catch (TweetTooLongException e) {
					e.printStackTrace();
				}
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();
				saveInFile();


			}
		});
		clearButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				//tweetList.clear();
				deleteFile(FILENAME);


				tweetList.clear();
				adapter.notifyDataSetChanged();



			}
		});
	}

	/**
	 * When the app starts, load oldTweetList from file and restore data.
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Loads Tweets from specified file.
	 *
	 * @throws TweetTooLongException if the text is too long.
	 * @exception FileNotFoundException if the file is not created first.
	 *
	 */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			//taken from stack overflow bby, idk what or how it works, but it is magical pony dust that i dont understand whatsoever.
			//http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			//2017-01-24-18:19
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Trims extra spaces using regular expression.
	 * @param inputString string that needs to be cleared of extra spaces.
	 * @return resulting String
     */

	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+"," ");
		return inputString;
	}

	/**
	 * This method sorts items in the tweet list and refreshes the adapter.
	 * @param ordering ordering to be used.
     */
	private void sortTweetListItems(TweetListOrdering ordering){

	}
	/**
	 * Saves tweets to a specified file in JSON format.
	 * @throws #FileNotFoundException if file doesn't exist.
	 *
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			//fos.write(new String(date.toString() + " | " + text)
					//.getBytes());

			Gson gson = new Gson();
			gson.toJson(tweetList,out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Handle exception later
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Handle exception later
			throw new RuntimeException();
		}
	}
}