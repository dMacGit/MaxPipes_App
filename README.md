# MaxPipes_App

"*In short this project is my attempt at a clone of the Twitch Tv android app.*"

This is a personal project of mine which I am trying to fill two requirements.
Firstly its my first fully fledged android app (Or attempt), so there is alot of learning, and secondly it is another project
in which I can use the Twitch api again, and muck around with streaming video etc.

This is a work in progress, and currently has a long way to go to be fully usable.

####Currently coded:

- TopStream, and TopGames JSON results are handled.
- GameObject contains all JSON data returned from TopGames results.
- Have fully coded the .m3u8 playlist compatability.
- Is able to load and play/pause live twitch tv streams in default android media-player. *(Currently Dissabled)*
- ListAdapter Implemented with Top Games data. *(Loads Game Image, Name and Total views)*

####Planned:

- ItemSelectionListener on the ListAdapter elements/views *(Half implemented)*
- JSON handler for top streams by game.
- ListAdapter for displaying top streams by game data. *(Display similar to topGames)*
- ItemSelectionListener on the above ListAdapter, which plays the selected stream.
- Customize the player controls. *(Remove the seek-bar, time, forward/rewind buttons)*
- Finish the listview layouts.
