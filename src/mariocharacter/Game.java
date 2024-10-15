 public class Game {
    private GameObject[] objects; // This is our array of game objects

     public Game() {
            objects = new GameObject[5]; // Create an array with 5 boxes

            // Fill the array with some game objects
            objects[0] = new GameObject(10, 20, 50, 50); // First object
            objects[1] = new GameObject(30, 40, 50, 50); // Second object
            objects[2] = new GameObject(100, 150, 50, 50); // Third object
            objects[3] = new GameObject(200, 250, 50, 50); // Fourth object
            objects[4] = new GameObject(300, 350, 50, 50); // Fifth object

         int[][] playerPosition = new int[1][2];  // 1 player, 2 values (x and y coordinates)
         playerPosition[0][0] = 50;  // Player's starting x-coordinate
         playerPosition[0][1] = 50;  // Player's starting y-coordinate


         ;; }}
