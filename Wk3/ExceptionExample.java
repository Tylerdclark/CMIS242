public class ExceptionExample {
    public static void main(String[] args) {

    }
    public File getFile() {
        try{
            choser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            response = chooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                file.getIntArray();
            }
        } catch (notIntException) {
            System.out.println("Needs to be ints");
        }
    }
}