package application;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.enums.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

  // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static void clearScreen() {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }

  public static ChessPosition readChessPosition(Scanner sc) {
    try {
      String s = sc.nextLine();
      char column = s.charAt(0);
      int row = Integer.parseInt(s.substring(1));
      return new ChessPosition(column, row);
    } catch (RuntimeException e) {
      throw new InputMismatchException(
        "Error reading ChessPosition. Valid values are from a1 to h8"
      );
    }
  }

  public static void printBoard(ChessPiece[][] pieces) {
    for (int i = 0; i < pieces.length; i++) {
      String pieceLine = "";
      for (int j = 0; j < pieces.length; j++) {
        pieceLine += printPiece(pieces[i][j], false) + " ";
      }
      System.out.println((8 - i) + " " + pieceLine);
    }
    System.out.println("  a b c d e f g h");
  }

  public static void printBoard(
    ChessPiece[][] pieces,
    boolean[][] possibleMoves
  ) {
    String validMoves = "Valid Moves ";
    for (int i = 0; i < pieces.length; i++) {
      String pieceLine = "";
      for (int j = 0; j < pieces.length; j++) {
        pieceLine += printPiece(pieces[i][j], possibleMoves[i][j]) + " ";
      }
      System.out.println((8 - i) + " " + pieceLine);
    }
    System.out.println("  a b c d e f g h");

    System.out.println(validMoves);
  }

  private static String printPiece(ChessPiece piece, boolean background) {
    String message = "";

    if (background) {
      message += ANSI_RED_BACKGROUND;
    }

    if (piece == null) {
      message += "-";
    } else {
      if (piece.getColor() == Color.WHITE) {
        message += ANSI_WHITE + piece.toString() + ANSI_RESET;
      } else {
        message += ANSI_YELLOW + piece.toString() + ANSI_RESET;
      }
    }

    if (background) {
      message += ANSI_RESET;
    }

    return message;
  }
}
