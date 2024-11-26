Hsin Yen Tsai
Chih Yu Tsai


Cohesion and Coupling --

The overall structure follows the original Hangman, where the EvilHangman class in charge of the gaming state, EvilHangman class
has a "start" method that make sure the game is going. Several methods exist in this class. askForGuess() method mainly
in charge of prompting the questions to ask for input from the user and take care of the situations when there are incorrect inputs,
inputs that were already typed in and illegal inputs. The dictionaryToList() method is an useful method since it makes words
in the selected dictionary more accessible into a list format. The allLengthInList() we created is use to help with decide the length of the
potential solution. We figured it makes more sense to build it as a Hashset, to make sure that each word length have equal
opportunity of being selected. The printVictory() method is used to help with the final presentation of if EvilHangman is
getting solved.

The EvilSolution class has the constructor that takes in a length and list of words that help with pinning down the possible
lists of words that can be our potential solution. The constructor we have has candidateList that keep track of what's left in
our word bank that can be left as solutions. And the testPattern keep track of the latest so-called partial solution. The most
important function in this class is the getNewCandidateList() method that takes in a guess and make an update on partial solution
and what's left in the wordbank/candidatelist. We have this method mainly do these two things. We think it makes sense to keep a
intermediate Hashmap/dictionary format so that we have a better idea what is the new wordPattern we should have to make the game
harder to solve. The progress() method help with printing out the partial solution so that player can have an idea what the partial
solution looks like. gotSolved() method is used as a reference point to determine if we are done with the game. getFinalWord() is
used to get the last word that is being guessed and as a component to terminate the game. The getWordPattern() method serves as a
getter to get the current state of word pattern.

Most methods in EvilHangman rarely depend on other classes so it's low coupling, and we clearly split the tasks that are related to
solution in the EvilSolution class.

To run the program, users will use the EvilHangmanRunner.Java and will prompt a guess for user.

