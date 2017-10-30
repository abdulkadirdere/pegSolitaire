/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kadir
 */
public class pegSolitaire {

    static int countMoves;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long dur = 0;
        pegSolitaire.countMoves = 0;
        int[][] initialBoard = null;

        System.out.print("Enter number of pegs: ");
        int pegCount = in.nextInt();

        initialBoard = setupGameboard(pegCount);

        System.out.println("Initial board:\n");
        printBoard(initialBoard);
        final long startTime = System.nanoTime(); //start of timer
        possibleMoves(initialBoard);
        final long endTime = System.nanoTime(); //end of timer

        dur = (endTime - startTime); // /1000000000; //for seconds
        System.out.println("Number of Pegs: " + pegCount);
        System.out.println("Duration " + dur); // +" seconds");
        System.out.println("Counter: " + countMoves);
        countMoves = 0;

        if (possibleMoves(initialBoard) == false) {
            System.out.println("No solution"); // if there is no solution
        } else {
            System.out.println("Solution reached\n");
            //printBoard(initialBoard);
        }

    }

    public static boolean possibleMoves(int[][] gameboard) {//, int countMoves) {
        int height = 7;
        int width = 7;
        int[][] newboard = gameboard;

        if (checkResult(gameboard) == true && gameboard[3][3] == 1) { //if we have reached a solution
            return true;
        } else {
            countMoves++;
            for (int row = 0; row < gameboard.length; row++) {
                for (int col = 0; col < gameboard.length; col++) {
                    //move West
                    if (col < width - 2 && gameboard[row][col] == 1 && gameboard[row][col + 2] == 0 && gameboard[row][col + 1] == 1) {
                        // printBoard(newboard);
                        newboard[row][col] = 0;
                        newboard[row][col + 2] = 1;
                        newboard[row][col + 1] = 0;
                        //System.out.println("Iteration right");
                        //countMoves++;
                        if (possibleMoves(newboard) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard);
                            newboard[row][col] = 1;
                            newboard[row][col + 2] = 0;
                            newboard[row][col + 1] = 1;
                        }
                    }
                    //move East
                    if (col > 1 && gameboard[row][col] == 1 && gameboard[row][col - 2] == 0 && gameboard[row][col - 1] == 1) {
                        newboard[row][col] = 0;
                        newboard[row][col - 2] = 1;
                        newboard[row][col - 1] = 0;
                        //countMoves++;
                        //System.out.println("Iteration left");
                        if (possibleMoves(newboard) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard);
                            newboard[row][col] = 1;
                            newboard[row][col - 2] = 0;
                            newboard[row][col - 1] = 1;
                        }
                    }
                    //move North
                    if (row < height - 2 && gameboard[row][col] == 1 && gameboard[row + 2][col] == 0 && gameboard[row + 1][col] == 1) {
                        newboard[row][col] = 0;
                        newboard[row + 2][col] = 1;
                        newboard[row + 1][col] = 0;
                        //System.out.println("Iteration up");
                        //countMoves++;
                        if (possibleMoves(newboard) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard);

                            newboard[row][col] = 1;
                            newboard[row + 2][col] = 0;
                            newboard[row + 1][col] = 1;
                        }
                    }
                    //move South
                    if (row > 1 && gameboard[row][col] == 1 && gameboard[row - 2][col] == 0 && gameboard[row - 1][col] == 1) {
                        newboard[row][col] = 0;
                        newboard[row - 2][col] = 1;
                        newboard[row - 1][col] = 0;
                        //countMoves++;
                        //System.out.println("Iteration down");
                        if (possibleMoves(newboard) == true) {
                            return true;
                        } else {
                            possibleMoves(newboard);

                            newboard[row][col] = 1;
                            newboard[row - 2][col] = 0;
                            newboard[row - 1][col] = 1;
                        }
                    }
                }
            }
        }
        //printBoard(newboard);
        return false;
    }

    public static boolean checkResult(int[][] board) {
        int count = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[x][y] == 1) {
                    count++;
                }
            }
        }
        if (count > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static int[][] setupGameboard(int pegCount) {
        int[][] gameboard = new int[7][7];

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = -1;
            }
        }
        
        gameboard[3][3] = 0; //0 means there is no peg
        gameboard[0][2] = 1; //1 means there is a peg
        gameboard[0][3] = 1;
        gameboard[0][4] = 1;
        gameboard[1][2] = 1;
        gameboard[1][3] = 1;
        gameboard[1][4] = 1;
        gameboard[2][0] = 1;
        gameboard[2][1] = 1;
        gameboard[2][2] = 1;
        gameboard[2][3] = 1;
        gameboard[2][4] = 1;
        gameboard[2][5] = 1;
        gameboard[2][6] = 1;
        gameboard[3][0] = 1;
        gameboard[3][1] = 1;
        gameboard[3][2] = 1;
        gameboard[3][4] = 1;
        gameboard[3][5] = 1;
        gameboard[3][6] = 1;
        gameboard[4][0] = 1;
        gameboard[4][1] = 1;
        gameboard[4][2] = 1;
        gameboard[4][3] = 1;
        gameboard[4][4] = 1;
        gameboard[4][5] = 1;
        gameboard[4][6] = 1;
        gameboard[5][2] = 1;
        gameboard[5][3] = 1;
        gameboard[5][4] = 1;
        gameboard[6][2] = 1;
        gameboard[6][3] = 1;
        gameboard[6][4] = 1;

        switch (pegCount) {
            case 32:
                gameboard[3][3] = 0; //0 means there is no peg
                break;
            case 31:
                gameboard[3][3] = 1;
                gameboard[4][3] = 0;
                gameboard[5][3] = 0;
                break;

            case 30:
                gameboard[3][3] = 1;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[5][3] = 0;
                break;

            case 29:
                gameboard[3][3] = 1;
                gameboard[4][5] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][4] = 0;
                break;

            case 28:
                gameboard[3][3] = 1;
                gameboard[4][5] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                break;

            case 27:
                gameboard[3][3] = 1;
                gameboard[3][4] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[5][3] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                break;

            case 26:
                gameboard[3][3] = 1;
                gameboard[3][4] = 0;
                gameboard[4][5] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 25:
                gameboard[3][3] = 1;
                gameboard[1][4] = 0;
                gameboard[2][4] = 0;
                gameboard[4][5] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 24:
                gameboard[3][3] = 1;
                gameboard[1][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[4][5] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 23:
                gameboard[3][3] = 1;
                gameboard[1][4] = 0;
                gameboard[2][5] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 22:
                gameboard[3][3] = 1;
                gameboard[1][4] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 21:
                gameboard[3][3] = 1;
                gameboard[1][4] = 0;
                gameboard[2][3] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 20:
                gameboard[3][3] = 1;
                gameboard[1][4] = 0;
                gameboard[2][1] = 0;
                gameboard[2][2] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 19:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][1] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 18:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][1] = 0;
                gameboard[2][2] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][2] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 17:
                gameboard[3][3] = 1;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][4] = 0;
                gameboard[2][1] = 0;
                gameboard[2][2] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][2] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 16:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][1] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][2] = 0;
                gameboard[3][6] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 15:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][1] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][6] = 0;
                gameboard[4][2] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 14:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][1] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][5] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 13:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][6] = 0;
                gameboard[4][1] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 12:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][6] = 0;
                gameboard[4][2] = 0;
                gameboard[4][3] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 11:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][3] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 10:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][3] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 9:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][5] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][3] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 8:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][5] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 7:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][5] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][2] = 0;
                gameboard[4][3] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 6:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][1] = 0;
                gameboard[3][5] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][2] = 0;
                gameboard[4][3] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 5:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][2] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][1] = 0;
                gameboard[3][5] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][2] = 0;
                gameboard[4][3] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 4:
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][2] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][1] = 0;
                gameboard[3][3] = 0;
                gameboard[3][4] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][2] = 0;
                gameboard[4][3] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 3:
                gameboard[3][3] = 1;
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][3] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][2] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][1] = 0;
                gameboard[3][4] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][2] = 0;
                gameboard[4][3] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;

            case 2:
                gameboard[0][2] = 0;
                gameboard[0][3] = 0;
                gameboard[0][4] = 0;
                gameboard[1][2] = 0;
                gameboard[1][3] = 0;
                gameboard[1][4] = 0;
                gameboard[2][0] = 0;
                gameboard[2][1] = 0;
                gameboard[2][2] = 0;
                gameboard[2][3] = 0;
                gameboard[2][4] = 0;
                gameboard[2][5] = 0;
                gameboard[2][6] = 0;
                gameboard[3][0] = 0;
                gameboard[3][1] = 0;
                gameboard[3][2] = 0;
                gameboard[3][3] = 0;
                gameboard[3][6] = 0;
                gameboard[4][0] = 0;
                gameboard[4][1] = 0;
                gameboard[4][2] = 0;
                gameboard[4][3] = 0;
                gameboard[4][4] = 0;
                gameboard[4][5] = 0;
                gameboard[4][6] = 0;
                gameboard[5][2] = 0;
                gameboard[5][3] = 0;
                gameboard[5][4] = 0;
                gameboard[6][2] = 0;
                gameboard[6][3] = 0;
                gameboard[6][4] = 0;
                break;
        }

        //printBoard(gameboard);
        return gameboard;
    }

    public static void printBoard(int[][] board) {
        System.out.println(Arrays.deepToString(board).replace("-1", " ").replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
    }
}
