import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class Huffman {
    private int[] frequencyTable;
    private HuffmanNode root;

    public Huffman() {
        frequencyTable = new int[256];
        root = null;
    }

    public void buildFrequencyTable(String data) {
        for (char c : data.toCharArray()) {
            int asciiValue = (int) c;
            frequencyTable[asciiValue]++;
        }
    }

    public void buildHuffmanTree() {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < frequencyTable.length; i++) {
            if (frequencyTable[i] > 0) {
                priorityQueue.add(new HuffmanNode((char) i, frequencyTable[i]));
            }
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode parent = new HuffmanNode(left, right);
            priorityQueue.add(parent);
        }

        root = priorityQueue.poll();

    }

    private void buildHuffmanCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node.isLeaf()) {
            huffmanCodes.put(node.getData(), code);
            return;
        }

        buildHuffmanCodes(node.getLeft(), code + "0", huffmanCodes);
        buildHuffmanCodes(node.getRight(), code + "1", huffmanCodes);
    }   public Map<Character, String> getHuffmanCodes() {
        Map<Character, String> huffmanCodes = new HashMap<>();
        if (root != null) {
            buildHuffmanCodes(root, "", huffmanCodes);
        }
        return huffmanCodes;
    }
    public void displayFrequencyTable() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Karakter Frekans Tablosu");
        for (int i = 0; i < frequencyTable.length; i++) {
            if (frequencyTable[i] > 1) {
                char character = (char) i;
                System.out.println(character + ": " + frequencyTable[i]);
            }
        }
    }


    public void displayHuffmanCoding() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Karakterin Huffman Kodları");
        Map<Character, String> huffmanCodes = getHuffmanCodes();
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public String Encoding(String data) {
        buildFrequencyTable(data);
        buildHuffmanTree();
        Map<Character, String> huffmanCodes = getHuffmanCodes();

        StringBuilder encodedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            int asciiValue = (int) c;
            encodedData.append(huffmanCodes.get((char) asciiValue));
        }

        return encodedData.toString();
    }}