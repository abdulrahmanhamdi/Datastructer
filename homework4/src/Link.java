class Link {
    private char ch;
    private int frequency;
    private Link next;
    public Link(char data, int frequency) {
        this.ch = data;
        this.frequency = frequency;
        this.next = null;
    }
    public int getFrequency() {
        return frequency;
    }
    public Link getNext() {
        return next;
    }
    public void setNext(Link next) {
        this.next = next;
    }
    public void displayLink() {
        System.out.print("{" + ch + ", " + frequency + "} ");
    }
}

