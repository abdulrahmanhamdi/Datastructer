
class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(char data, int frequency) {
        Link newLink = new Link(data, frequency);
        Link previous = null;
        Link current = first;

        while (current != null && frequency > current.getFrequency()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            newLink.setNext(first);
            first = newLink;
        } else {
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    public Link remove() {
        Link temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList() {
        System.out.print("Bağlı Liste: ");
        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }

        System.out.println();
    }
}
