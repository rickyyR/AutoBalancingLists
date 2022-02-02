package org.rickyyr.ABL;

import java.util.ArrayList;

public class List {

  private ArrayList<Integer> list;

  public List() {
    this.list = new ArrayList<>();
  }

  public void putInList() {
    this.list.add(1);
  }

  public void removeFromList() {
    this.list.remove(this.list.size() - 1);
  }

  public void transferOneToList(ArrayList<Integer> targetList) {
    targetList.add(this.list.get(this.list.size() - 1 ));
    this.list.remove(this.list.size() - 1);
  }

  public ArrayList<Integer> getList() {
    return list;
  }

  public String listToString() {
    StringBuilder stringBuilder = new StringBuilder();
    for(int i : this.list) {
      stringBuilder.append("▇");
    }
    stringBuilder.append(" ").append(this.list.size());

    return stringBuilder.toString();
  }

}
