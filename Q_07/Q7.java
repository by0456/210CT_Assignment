
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Q7 {

    public static DoubleList doubleLinkedList;
    //use ArrayList to stored the double linked list
    public static ArrayList<DoubleList> arrayList;
    public String num;

    public static void main(String[] args) throws FileNotFoundException {

        //This code is for input the paragraph
        //String s = "zzzzz aen Read a paragraph containing words from an input file. AB AC AD ATD ATB ATA Cheung Chi Kin Then create a doubly-linked list containing the distinct words read, where the words of the same length are placed in the sami list, in alphabetical order.";
        System.out.println("The paragraph : ");

        //This code is for input the paragraph from the file
        //If you want to testing by other file, please change the file name and file path
        arrayList = new ArrayList<DoubleList>(getMaxList(readFile("C:\\Users\\user\\Desktop\\testQ7.txt")));
        System.out.println(readFile("C:\\Users\\user\\Desktop\\testQ7.txt"));
        createList(readFile("C:\\Users\\user\\Desktop\\testQ7.txt"));

        System.out.println("----- Result : -----");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());

        }
    }

    //This mothed is use for read the file
    private static String readFile(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    //This method is use for get the number of the list which is store the the same length words
    public static int getMaxList(String text) {
        int maxSize = 0, count = 0;
        String[] words = text.split("[\\p{Punct}\\s]+");
        for (int w = 0; w < words.length; w++) {
            if (words[w].length() > maxSize) {
                maxSize = words[w].length();
            }
        }
        for (int u = 1; u <= maxSize; u++) {
            for (int test = 0; test < words.length; test++) {
                if (words[test].length() == u) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void createList(String text) {
        //These variables stored the number char of the word, it will use for compare
        char[] charOfWords, charOfNode, charOfNodeHead;
        //The variable stored max length of the word
        int maxLength = 0;
        String[] words = text.split("[\\p{Punct}\\s]+");
        System.out.println(" ");
        for (int wMaxLength = 0; wMaxLength < words.length; wMaxLength++) {
            if (words[wMaxLength].length() > maxLength) {
                maxLength = words[wMaxLength].length();
            }
        }

        
        for (int u = 1; u <= maxLength; u++) {
            doubleLinkedList = new DoubleList();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == u) {
                    if (doubleLinkedList.head != null) {
                        charOfWords = words[i].toCharArray();
                        Node node = doubleLinkedList.head;
                        Node last = node;
                        boolean t = true;
                        boolean f = true;
                        //This while loop is use for compare the char of the word, that will make the same length word ina alphabetical
                        while (node != null) {
                            if (!t) {
                                break;
                            }
                            //If the word has already in the list, that will skip this word
                            if (doubleLinkedList.search(words[i])) {
                                f = false;
                                break;
                            }
                            charOfNode = node.data.toString().toCharArray();
                            charOfNodeHead = doubleLinkedList.head.data.toString().toCharArray();
                            for (int b = 0; b < words[i].length(); b++) {
                                if (node == doubleLinkedList.head) {
                                    if (Character.toLowerCase(charOfWords[b]) < Character.toLowerCase(charOfNodeHead[b])) {
                                        t = false;
                                        break;
                                    }
                                }
                                if (Character.toLowerCase(charOfWords[b]) > Character.toLowerCase(charOfNode[b])) {
                                    last = node;
                                    break;
                                } else if (Character.toLowerCase(charOfWords[b]) < Character.toLowerCase(charOfNode[b])) {
                                    break;
                                }
                            }
                            node = node.next;
                        }
                        if (f) {
                            if (last.prev == null && t == false) {
                                doubleLinkedList.addToHead(words[i]);
                                //t = true;
                            } else if (last.next == null) {
                                doubleLinkedList.addToEnd(words[i]);
                            } else {
                                doubleLinkedList.addToAfter(last, words[i]);
                            }
                        }
                    } else {
                        doubleLinkedList.addToHead(words[i]);
                    }
                }
            }
            if (doubleLinkedList.head != null) {
                //add to Array List
                arrayList.add(doubleLinkedList);
            }
        }
    }
}
