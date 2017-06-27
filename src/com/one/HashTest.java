package com.one;

import com.one.Unit;

import java.util.Arrays;

/**
 * Created by TangXW on 2017/6/23.
 */
public class HashTest {
    private short ashort;
    private char achar;
    private byte abyte;
    private boolean abool;
    private long along;
    private float afloat;
    private double adouble;
    private Unit aObject;
    private int[] ints;
    private Unit[] units;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof HashTest)){
            return false;
        }
        HashTest hashTest = (HashTest)obj;
        return hashTest.ashort ==  ashort
                && hashTest.achar == achar
                && hashTest.abyte == abyte
                && hashTest.abool == abool
                && hashTest.along == along
                && Float.floatToIntBits(hashTest.afloat) ==
                    Float.floatToIntBits(afloat)
                && Double.doubleToLongBits(hashTest.adouble) ==
                    Double.doubleToLongBits(adouble)
                && hashTest.aObject.equals(aObject)
                && equalsInts(hashTest.ints)
                && equalsUnits(hashTest.units);
    }

    // 比较int数组
    private boolean equalsInts(int[] aints){
        return Arrays.equals(ints, aints);
    }
    // 比较unit数组
    private boolean equalsUnits(Unit[] aUnits){
        return Arrays.equals(units, aUnits);
    }

    @Override
    public int hashCode() {
        int result = 17;  // 随意赋一个初始值
        result = 31 * result + (int) ashort;
        result = 31 * result + (int) achar;
        result = 31 * result + (int) abyte;
        result = 31 * result + (abool ? 0 : 1);
        result = 31 * result + (int) (along ^ (along >>> 32));
        result = 31 * result + Float.floatToIntBits(afloat);
        long tolong = Double.doubleToLongBits(adouble);
        result = 31 * result + (int) (tolong ^ (tolong >>> 32));
        result = 31 * result + aObject.hashCode();
        result = 31 * result + intsHashCode(ints);
        result = 31 * result + unitsHashCode(units);
        return result;
    }

    private int intsHashCode(int[] aints) {
        int result = 17;
        for (int i = 0; i < aints.length; i++)
            result = 31 * result + aints[i];
        return result;
    }
    private int unitsHashCode(Unit[] aUnits) {
        int result = 17;
        for (int i = 0; i < aUnits.length; i++)
            result = 31 * result + aUnits[i].hashCode();
        return result;
    }

}
