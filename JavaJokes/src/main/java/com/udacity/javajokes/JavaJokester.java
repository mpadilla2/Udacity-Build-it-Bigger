package com.udacity.javajokes;

import java.util.ArrayList;
import java.util.Random;

// Reference: Udacity lesson 4.02 used a simple string to return one "joke". Expanded this example to allow multiple jokes.
public class JavaJokester {

    // Reference: https://developer.android.com/reference/java/util/Random
    private final Random randomGen;
    private final ArrayList<String> mJokes;

    // Reference: Jokes are from - https://academictips.org/funny-jokes/42-funny-one-liners/
    public JavaJokester(){
        this.mJokes = new ArrayList<>();
        this.randomGen = new Random();
        this.mJokes.add("A computer once beat me at chess, but it was no match for me at kick boxing.");
        this.mJokes.add("What did one ocean say to the other ocean? Nothing, they just waved.");
        this.mJokes.add("For Sale: Parachute. Only used once, never opened.");
        this.mJokes.add("What is faster Hot or cold? Hot, because you can catch a cold.");
        this.mJokes.add("Why did the scientist install a knocker on his door? He wanted to win the No-bell prize!");
        this.mJokes.add("Why did the bee get married? Because he found his honey.");
        this.mJokes.add("What do you call a boomerang that doesn’t come back? A stick.");
        this.mJokes.add("I just let my mind wander, and it didn’t come back.");
    }

    public String getJoke() {
        return mJokes.get(randomGen.nextInt(mJokes.size()));
    }
}
