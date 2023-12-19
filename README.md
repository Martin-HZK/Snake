## Changes/Additions to the game

1. Adding different types of apples
   * Red - normal apple, 1pts
   * Yellow - bonus apple, 3pts
   * Purple - Unknown apple, -6pts or 5pts randomly
2. Adding different sound effect when eating different apples.
3. Adding the game pause/resume function when playing the game.
4. Adding the user selection of the different **themes** and **snake color** with color pane. Every time the user restart game, the game will start with the previous user setting. The user is also allowed to choose default setting.
5. Adding the username input window. Before each round, the user is asked to input its name and it will be further displayed with its playing scores.
6. Adding the score board for the user to view history scores in the score window. The scores will be stored with the user's name. The user can also click to clear the score board.
   Additionally, each round the user will get the level title, including rookie, skilled, expert,master, together with different snake image.

## Design patterns applied

### Observer pattern

#### Design principle

Open-Closed Principle & Dependency Inversion Principle

I apply the observer pattern to the process of updating scores. *ScorePublisher* and *Subscriber* are two interfaces.*PlayScorePublisher* and *ScoreSubscriber* are corresponding implementation of the interface. The subscriber has the *update()* method to update the score to the json file. The publisher has the *addSubscriber()* method to store the subscriber in an arrayList for reference. These publisher is used in the usernameInput&playing window to collect the new scoreSubscriber(i.e. score). <u>When the round finish, the publisher will update the subscriber with the score.</u>

### Factory pattern

#### Design principle

Open-Closed Principle & Dependency Inversion Principle

The factory pattern is used for creating different types of apples. *Apple* interface is included with the *checkApple()* method. We have an abstract class as the *AppleCreator*. Then we will have different apples and different apple creator. In the application we can avoid using the constructor straightly.

### Singleton pattern

#### Design principle

Open-Closed principle & Single Responsibility Principle

I apply the singleton pattern to the PlayScorePublisher. As we will only have 1 Publisher in the game to track all the scoreSubscriber, we set the PlayScorePublisher to static inside the *PlayScorePublisher* class. The *getInstance()* will always return the publisher if not null. If null, instantiate one.


### Strategy pattern

#### Design principle

Open-Closed principle

The strategy pattern is for playing different sound when eating apples. *Strategy* interface wrap a method *playSound()* and 3 class all implements it to create 3 different sounds. We also have a *Context* class with *setStrategy()* and *executeStrategy*. In the playingController, for different apples eaten, we will set different sound-play strategy to play sound.

### Command pattern

#### Design principle

Open-Closed Principle & Dependency Inversion Principle

The command pattern is used for gamePause function. The *Command* interface wrap a *execute()* method and *PauseCommand* & *ResumeCommand* are 2 concrete class. The concrete class take the target borderPane and timer as parameter and execute the timer's play and stop method.

## Tests
#### Function: redappleCreator.createApple()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|red apples are created on the correct x index ||200|200|Passed
| N_2|[Normal]|red apples are created on the correct y index ||200|200|Passed

#### Function: bonusappleCreator.createApple()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|bonus apples are created on the correct x index ||200|200|Passed
| N_2|[Normal]|bonus apples are created on the correct y index ||200|200|Passed

#### Function: unknownappleCreator.createApple()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|unknown apples are created on the correct x index ||200|200|Passed
| N_2|[Normal]|unknown apples are created on the correct y index ||200|200|Passed

#### Function: redApple.checkApple()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|snake start length ||6|6|Passed
| N_2|[Normal]|new red apple created,is eated reset to false ||false|false|Passed
| N_1|[Normal]|snake new length ||7|7|Passed

#### Function: bonusApple.checkApple()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|snake start length ||6|6|Passed
| N_2|[Normal]|new bonus apple created,is eated reset to false ||false|false|Passed
| N_1|[Normal]|snake new length ||7|7|Passed

#### Function: bonusApple.checkApple()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|snake start length ||6|6|Passed
| N_2|[Normal]|new bonus apple created,is eated reset to false ||false|false|Passed
| N_1|[Normal]|snake new length ||7|7|Passed

#### Function: redApple.checkApple()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|snake start length ||6|6|Passed
| N_2|[Normal]|new red apple created,is eated reset to false ||false|false|Passed
| N_1|[Normal]|snake new length ||7|7|Passed


#### Function: updatePlayerScore()
|ID|Type|Description|Inputs|Expected Outcome|Test Outcome|Passed/Failed|
|----|------|---------|----------------|------------|------|----|
| N_1|[Normal]|score in the current round ||20|20|Passed
| N_2|[Normal]|add subscriber with score 30 ||30|30|Passed


