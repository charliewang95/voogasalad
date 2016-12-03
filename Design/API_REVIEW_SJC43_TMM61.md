# API_REVIEW_SJC43_TMM61

There were a number of design decisions that we discussed during our meeting. The first discussion was whether or not the game engine or the game player was responsible for de-serializing a game data file into a java object. We ultimately decided that either one would work. In one case, the game engine would instantiate a game and then call a new game player view into action. In the other case, the game player would instantiate an instance of the game engine with a specific game. Both designs seemed to be fine as long as the other parts of the project are in sync with the decision. I intend to handle the de-serialization in the game player portion, and then from the game player, instantiate an instance of the game engine to run a specific game. This will require logic to handle switching between games by creating and destroying game engine instances as needed. 

Another thing we discussed was the HUD aspect of the game player. In terms of being flexible, the HUD should both be able to change in terms of what information needs to be displayed, and how and where that information is displayed. This could be achieved in multiple ways. The first is that all of that is directly controlled in the authoring environment. The game player would simply pull all of that information from files and display it accordingly. This would require less complexity for the game player but more complexity for the authoring environment. Another option is that the authoring environment or game object simply flags any info that should be displayed, but it does not specify how or where it needs to be displayed. This would require the game player part of the project to create a flexible way of displaying this information. The types of information that could be needed would need to be classified, and then some data format would need to be created to capture how those different types of information would be displayed. This would be a greater design challenge for the game player part of the project. The biggest challenge there would be coordinating with the game authoring environment and game engine to figure out some specific set of possible game status information that exists. Another challenge would be figuring out how to make the HUD adaptable to new types of scoring information, if games became more complex. 