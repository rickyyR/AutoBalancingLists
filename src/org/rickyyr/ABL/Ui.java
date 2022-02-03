package org.rickyyr.ABL;

import java.util.Scanner;

public class Ui {

  private Scanner scanner;
  private Balancer balancer;

  public Ui() {
    this.scanner = new Scanner(System.in);
    this.balancer = new Balancer();
  };

  public void runUI() {
    while(true) {
      this.clearScreen();
      System.out.println(this.balancer.listsToStringNoNumbers() + "\n[1] Put in list " +
        "\n[2] Remove from list " +
        "\n[3] Balance lists" +
        "\n[4] Toggle Balance Mode (" + this.balancer.getBalanceMode() + ")" +
        "\n[5] Set max difference (" + this.balancer.getMaxDifference() + ")" +
        "\n[6] EXIT");
      String usrInput = scanner.nextLine();
      if(usrInput.equals("1")) {
        this.putInListMode();
      } else if(usrInput.equals("2")) {
          this.removeFromListMode();
      } else if(usrInput.equals("3")) {
          this.balancer.balanceLists();
      } else if(usrInput.equals("4")) {
          this.balancer.toggleBalanceMode();
      } else if(usrInput.equals("5")) {
          this.setMaxDifferenceMode();
      } else if(usrInput.equals("6")) {
          break;
      } else {this.printSelectionError();}
    }
  }

  private void putInListMode() {
    while (true) {
      this.clearScreen();
      System.out.println("PUT IN LIST" + "\n" + this.balancer.listsToString() + "\n[4] MENU");
      String usrIn = this.scanner.nextLine();
      if(usrIn.equals("1")) {
        this.balancer.getList(0).putInList();
      } else if(usrIn.equals("2")) {
        this.balancer.getList(1).putInList();
      } else if(usrIn.equals("3")) {
        this.balancer.getList(2).putInList();
      } else if(usrIn.equals("4")){
          break;
      } else {this.printSelectionError();}

      if(this.balancer.getBalanceMode()) {
        this.balancer.balanceLists();
      }
    }
  }

  private void removeFromListMode() {
    while (true) {
      this.clearScreen();
      System.out.println("REMOVE FROM LIST" + "\n" + this.balancer.listsToString() + "\n[4] MENU");
      String usrIn = this.scanner.nextLine();
      if(usrIn.equals("1")) {
        this.balancer.getList(0).removeFromList();
      } else if(usrIn.equals("2")) {
        this.balancer.getList(1).removeFromList();
      } else if(usrIn.equals("3")) {
        this.balancer.getList(2).removeFromList();
      } else if(usrIn.equals("4")){
        break;
      } else {this.printSelectionError();}

      if(this.balancer.getBalanceMode()) {
        this.balancer.balanceLists();
      }
    }
  }

  private void setMaxDifferenceMode() {
    try {
      System.out.print("New max difference: ");
      String input = this.scanner.nextLine();
      int newMaxDifference = Integer.parseInt(input);
      if(newMaxDifference >= 1) {
        this.balancer.setMaxDifference(newMaxDifference);
        this.balancer.balanceLists();
      } else {
        System.out.println("Please input a positive number >= 1");
        this.setMaxDifferenceMode();
      }
    } catch(NumberFormatException e){
      System.out.println("ERROR, please input a number");
      this.setMaxDifferenceMode();
    }
  }

  private void printSelectionError() {
    System.out.println("ERROR: Invalid selection");
  }

  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
