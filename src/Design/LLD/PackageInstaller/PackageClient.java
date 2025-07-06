package Design.LLD.PackageInstaller;

public class PackageClient {
    public static void main(String[] args) {

        PackageManager packageManager = PackageManager.getPackageManagerInstance();

        packageManager.addPackage(new Package("Package1"));
        packageManager.addPackage(new Package("Package2"));
        packageManager.addPackage(new Package("Package3"));
        packageManager.addPackage(new Package("Package4"));
        packageManager.addPackage(new Package("Package5"));
        packageManager.addPackage(new Package("Package6"));

        packageManager.addDependency("Package1", "Package2");
        packageManager.addDependency("Package1", "Package3");
        packageManager.addDependency("Package3", "Package4");
        packageManager.addDependency("Package3", "Package5");
        packageManager.addDependency("Package3", "Package6");

        Command installCommand = new InstallCommand("Package1");
        installCommand.executeCommand();
        System.out.println("-------");

        Command installCommand2 = new InstallCommand("Package5");
        installCommand2.executeCommand();
        System.out.println("-------");

        packageManager.addDependency("Package6", "Package1");
        Command installCommand3 = new InstallCommand("Package1");
        installCommand3.executeCommand();
        System.out.println("-------");
    }
}
