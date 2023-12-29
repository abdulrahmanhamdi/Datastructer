
public class Main {
    public static void main(String[] args) {
        String directory = "C:\\Users\\abdul\\IdeaProjects\\homework4\\src\\";
        String fileName1 = "Dataset-0.txt";
        String fileName2 = "EncodeDataset.txt";
        FileManangement file = new FileManangement(directory, fileName1);
        String dataset = file.readFile();
        System.out.println("Dosyadaki veri :" + dataset);
        Huffman huffman=new Huffman();
        String encodedDataset = huffman.Encoding(dataset);
        huffman.displayFrequencyTable();
        huffman.buildHuffmanTree();
        huffman.displayHuffmanCoding();

        System.out.println("Metnin Huffman coding çıktısı: " + encodedDataset);






    }
}
