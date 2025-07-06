package Design.LLD.PackageInstaller;

import java.util.*;

public class PackageManager {

    private static PackageManager packageManager;
    private Set<String> installedPackages = new HashSet<>();
    private List<String> installedOrder = new ArrayList<>();
    private Map<String, List<String>> dependencyGraph = new HashMap<>();

    private PackageManager(){}

    public static PackageManager getPackageManagerInstance(){
        if(packageManager == null){
            packageManager = new PackageManager();
        }
        return packageManager;
    }

    public void addPackage(Package packageObj)
    {
        String packageName = packageObj.getPackageName();
        dependencyGraph.putIfAbsent(packageName, new ArrayList<>());
    }

    public void addDependency(String packageName1, String packageName2)
    {
        dependencyGraph.get(packageName1).add(packageName2);
    }

    public void installPackage(String packageName)
    {
        installedOrder.clear();
        Set<String> visited = new HashSet<>();
        Set<String> pathRecStack = new HashSet<>();

        System.out.println("Installing package : " + packageName + " .... ");

        if(isCyclePresent(packageName, visited, pathRecStack))
        {
            System.out.println("Could not install the packages as cycle found");
        }
        else{
            System.out.println("Successfully installed packages in the order : ");
            for(String pkg : installedOrder)
            {
                System.out.println(pkg);
            }
        }
    }

    private boolean isCyclePresent(String pkg, Set<String> visited, Set<String> pathRecStack)
    {

        visited.add(pkg);
        pathRecStack.add(pkg);

        for(String neighbour : dependencyGraph.get(pkg))
        {
            if(!visited.contains(neighbour))
            {
                if(isCyclePresent(neighbour, visited, pathRecStack)) return true;
            }
            else if(pathRecStack.contains(neighbour))
                return true;
        }

        installedOrder.add(pkg);
        installedPackages.add(pkg);
        pathRecStack.remove(pkg);
        return false;
    }
}
