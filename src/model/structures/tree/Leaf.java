package model.structures.tree;

public class Leaf {
  
  private Integer value;

  public Leaf(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
