
public class HuffmanNode implements Comparable<HuffmanNode> {
    private char ch;
    private int frequency;
    private HuffmanNode leftchild;
    private HuffmanNode rightchild;
    public HuffmanNode(char data, int frequency) {
        this.ch = data;
        this.frequency = frequency;
        this.leftchild = null;
        this.rightchild = null;
    }

    public HuffmanNode(HuffmanNode left, HuffmanNode right) {
        this.ch = '\0';
        this.frequency = left.getFrequency() + right.getFrequency();
        this.leftchild = left;
        this.rightchild = right;
    }

    public char getData() {
        return ch;
    }

    public int getFrequency() {
        return frequency;
    }

    public HuffmanNode getLeft() {
        return leftchild;
    }

    public HuffmanNode getRight() {
        return rightchild;
    }

    public boolean isLeaf() {
        return leftchild == null && rightchild == null;
    }

    // @Override
    public int compareTo(HuffmanNode o) {
        return this.frequency - o.frequency;
    }
}