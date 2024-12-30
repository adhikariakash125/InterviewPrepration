package Misc.Wayfair.Intv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Package implements Misc.Wayfair.Intv3.interfacePackage.Package {

    private List<Pack> packs;

    public Package() {
        this.packs = new ArrayList<>();
    }

    @Override
    public void addPackage(Pack pack) {
        packs.add(pack);
    }

    @Override
    public void removePackage(int id) {

    }

    @Override
    public int getTotalWeight() {
        return 0;
    }

    @Override
    public Map<String, Integer> getPackages() {
        return Map.of();
    }

    @Override
    public Map<String, Integer> categoryWeight() {
        return Map.of();
    }
}
