package Practice;

import java.util.Map;
import java.util.HashMap;


// Map 자료형을 활용해 무지개 색상 출력. 
public class MapExample {
    public static void main(String[] args) {
        // Create HashMap.
        Map<Integer, String> rainbowColors = new HashMap<Integer, String>();

        // Put Key-Value into the `rainbowColors` HashMap.
        rainbowColors.put(0, "Red");
        rainbowColors.put(1, "Orange");
        rainbowColors.put(2, "Yellow");
        rainbowColors.put(3, "Green");
        rainbowColors.put(4, "Blue");
        rainbowColors.put(5, "Indigo");
        rainbowColors.put(6, "Violet");

        System.out.printf("Rainbow Colors Hash Map : %s\n", rainbowColors);

        System.out.println("[Rainbow Colors]");
        for (int i = 0; i < rainbowColors.size(); i++) {
            System.out.print(rainbowColors.get(i));
            if (i < rainbowColors.size() - 1) {
                System.out.print(" - ");
            }
        }
    }
}
