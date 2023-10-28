# Colourful-Tetris
Tetris with an extra game mode - colourful

The well-known Tetris game in a simple and quick-to-play format.

Controls:

During the game, the tetrominoes are controlled by the arrow keys or wasd.
Up: rotate the tetromino 90 degrees clockwise
Right: shifts the tetromino one square to the right
Left: shifts the tetromino one square to the left
Down: shifts the tetromino one square downwards ( to speed up dropping )
The game can be paused by either the space bar or the 'p' key.

Settings:

In the settings the slider can be used to determine the base speed of the game. This is set at a maximum of 10, meaning that the player can reach the maximum faster by levelling up.
Although this makes the game more challenging from the start, it does not affect the scoring system. It is purely intended for personal challenge and engagement.

Another option in the settings is the mode, under which the modified colourful mode can be enabled (explained below). This also allows the player to enable the difficulty 'nightmare mode' (explained below).


Colourful mode:

In colourful mode, the player plays tetris like usual, but the tetrominoes are generated with their individual blocks in random colours. This allows for a fun twist to the game.
To gain bonus points, the player can put together 'combos' of 3,  6, 10 blocks of the same colour next to each in a row, or the whole row in one colour. To make this easier for the player, 
with a probability of 3/10, sometimes stars generate and drop, instead of tetrominoes. The function of a star is changing the colour of the block to its own colour.
For example, if a red star is dropped onto a blue block, that blue block will change into red and the star will disappear. 
Stars can only be dropped onto blocks, they cannot be pushed sideways into blocks, meaning that block which are covered from the top by another block cannot be colour changed even if they are open from the side or bottom.

Nightmare difficulty:

Nightmare difficulty is only available under the colourful mode as it implements the colourful mechanic to make the game extra challenging to play.
In nightmare difficulty, the player receives bonuses for combos just as in colourful mode. However, to complete a row and remove it, the row has to be constructed entirely from blocks of the same colour.
This means that a row which is made of blocks which are of different colour will not be removed and counted to the score. 
To make this more possible, the probability of stars generating is increased to 6/10. This way the player can drop stars onto a full row to 'complete' it by making the colour of all the blocks the same.


Levels:

Level increases every 10 lines (rows removed), this increases the speed by 1 (up to a maximum speed of 10) and adds a score multiplier.
The score added every time a row or rows are removed, is multiplied by (level + 1) since the player starts at level 0. 
The combo bonuses received in colourful mode are also multiplied by the level before added to the score count.


Scoring:

Basic mode:

1 row: 40 points

2 rows: 100 points

3 rows: 300 points

4 rows: 1200 points


Colourful mode combos:


3 of the same colour: + 100 points

6 of the same colour: + 300 points

10 of the same colour: + 500 points

Entire row of the same colour: + 800 points
