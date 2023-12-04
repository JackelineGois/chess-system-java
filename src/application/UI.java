package application;

import chess.ChessPiece;

public class UI {

  public static void printBoard(ChessPiece[][] pieces) {
    for (int i = 0; i < pieces.length; i++) {
      String pieceLine = "";
      for (int j = 0; j < pieces.length; j++) {
        pieceLine += printPiece(pieces[i][j]) + " ";
      }
      System.out.println((8 - i) + " " + pieceLine);
    }
    System.out.println("  a b c d e f g h");
  }

  private static String printPiece(ChessPiece piece) {
    if (piece == null) {
      return "-";
    } else {
      return "piece";
    }
  }
}
