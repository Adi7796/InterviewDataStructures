package Design.OOPS.SolidPrinciples.DependencyInversionPrinciple;

public class Macbook {
    private WiredKeyboard keyboard;
    private WiredMouse mouse;

    public Macbook()
    {
        keyboard = new WiredKeyboard();
        mouse = new WiredMouse();
    }

    /*
    Here we have not done interface coding, we have instead hardcoded the concrete classes which would affect any changes
    in the future - suppose tomorrow we want to make the macbook come with wireless mouse and keyboard
    we will need to do a lot changes to this class

    Better approach would be to create interface objects -
    private Keyboard keyboard;
    private Mouse mouse;

    public Macbook(Keyboard keyboard, Mouse mouse)
    {
        this.keyboard = new WiredKeyboard();
        this.mouse = new WiredMouse();
    }
     */
}
