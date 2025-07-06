package Design.LLD.PackageInstaller;

public class InstallCommand implements Command{

    private String packageName;

    public InstallCommand(String packageName){
        this.packageName = packageName;
    }

    @Override
    public void executeCommand() {
        PackageManager.getPackageManagerInstance().installPackage(packageName);
    }
}
