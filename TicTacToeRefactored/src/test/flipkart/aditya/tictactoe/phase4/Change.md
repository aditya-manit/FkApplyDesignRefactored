
To write a Connect-Four game, let's start from Tic-Tac-Toe's "Graphics Version". Do the following changes on "GameMain.java" in Phase2:
Change constants ROWS to 6 and COLS to 7. Run the program. You shall see a 6×7 grid. Try clicking on the cells, "cross" and "nought" shall be displayed alternately.
Modify the mouseClicked() event-handler to position the seed at the "bottom" row of the column clicked, instead of on the the cell clicked. You need to check that there is empty cell on that column.
``~~`if (colSelected >= 0 && colSelected < COLS) {
   // Look for an empty cell starting from the bottom row
   for (int row = ROWS -1; row >= 0; row--) {
      if (board[row][colSelected] == Seed.EMPTY) {
         board[row][colSelected] = currentPlayer; // Make a move
         updateGame(currentPlayer, row, colSelected); // update state
         // Switch player
         currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
         break;
      }
   }
}`~~``
Modify the hasWon() method to check for 4-in-a-line (along row, column, diagonal or opposite-diagonal).
**`public boolean hasWon(Seed theSeed, int rowSelected, int colSelected) {
   // Check for 4-in-a-line on the rowSelected
   int count = 0;
   for (int col = 0; col < COLS; ++col) {
      if (board[rowSelected][col] == theSeed) {
         ++count;
         if (count == 4) return true;  // found
      } else {
         count = 0; // reset and count again if not consecutive
      }
   }
   // Check column and diagonals
   ......
   return false;  // no 4-in-a-line found
}`**
That's all!