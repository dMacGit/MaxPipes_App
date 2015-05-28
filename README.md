# MaxPipes_App

"*In short this project is my attempt at a clone of the Twitch Tv android app.*"

This is a personal project of mine which I am trying to fill two requirements.
Firstly its my first fully fledged android app (Or attempt), so there is alot of learning, and secondly it is another project
in which I can use the Twitch api again, and muck around with streaming video etc.

This is a work in progress, and currently has a long way to go to be fully usable.

####Current State:

- TopStream, streamByGame, and TopGames JSON results are handled.
- GameObject and StreamObject classes hold required data from ther respective JSON calls.
- Have fully coded the .m3u8 playlist compatability.
- Is able to load and play/pause live twitch tv streams in default android media-player.
- ListAdapter(s) Implemented which hold  Top Games and Stream data. *(Loads Game/Stream Image, Name and Total views)*

####Planned:

- Add back button compatibility, and handle closing/backing out of player.
- Customize the player controls. *(Remove the seek-bar, time, forward/rewind buttons)*
- Finish the listview layouts.
