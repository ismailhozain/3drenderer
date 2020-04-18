public class Main {

    public static void main(String[] args) {
        Display display = new Display(800, 600, "Rendering Mechana");
        while(true){
            display.SwapBuffers();
        }
    }
}


