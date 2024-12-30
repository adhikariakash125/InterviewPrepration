package Misc.Wayfair.Intv3.interfacePackage;

import Misc.Wayfair.Intv3.Pack;

import java.util.Map;

public interface Package {
    void addPackage(Pack pack);
    void removePackage(int id);
    int getTotalWeight();
    Map<String, Integer> getPackages();
    Map<String, Integer> categoryWeight();
}