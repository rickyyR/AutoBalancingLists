package org.rickyyr.ABL;

import java.util.ArrayList;

public class Balancer {

  private ArrayList<List> listHolder;
  private Boolean balanceMode;

  public Balancer() {
    this.listHolder = new ArrayList<>();
    this.listHolder.add(new List());
    this.listHolder.add(new List());
    this.listHolder.add(new List());
    this.balanceMode = false;
  }

  public String listsToString() {
    return "[1]" + this.listHolder.get(0).listToString() + "\n[2]"
      + this.listHolder.get(1).listToString() + "\n[3]"
      + this.listHolder.get(2).listToString();
  }

  public String listsToStringNoNumbers() {
    return this.listHolder.get(0).listToString() + "\n"
      + this.listHolder.get(1).listToString() + "\n"
      + this.listHolder.get(2).listToString();
  }

  public void toggleBalanceMode() {
    if(!this.balanceMode) {
      this.balanceMode = true;
    } else {this.balanceMode = false;};
  }

  public boolean getBalanceMode() {
    return this.balanceMode;
  }

  public void balanceLists() {

    List smallestList = this.listHolder.get(0);
    List biggestList = this.listHolder.get(0);
    int sizeDifference = 0;
    boolean balanced = false;

    while(true) {
      for(List l : this.listHolder) {
        if(l.getList().size() < smallestList.getList().size()) {
          smallestList = l;
        } if(l.getList().size() >= biggestList.getList().size()) {
          biggestList = l;
        }
      }
      sizeDifference = biggestList.getList().size() - smallestList.getList().size();
      if(sizeDifference <= 1) {
        break;
      } else {
        biggestList.transferOneToList(smallestList.getList());
      }
    }
  }

  public List getList(int index) {
    return this.listHolder.get(index);
  }
}
