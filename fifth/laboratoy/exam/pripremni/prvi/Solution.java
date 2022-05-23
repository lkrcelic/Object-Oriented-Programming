package fifth.laboratoy.exam.pripremni.prvi;

import java.util.List;
import java.util.function.Predicate;


class Solution {
//	metoda allDigitsMatch vraća predikat koji omogućuje testiranje odgovara li zapis znamenki u listi 
//	znamenkama priloženog decimalnog broja.

//	metoda allDigitsDefined vraća predikat koji omogućuje testiranje jesu li zapisu znamenki u listi 
//	zapisane sve uzastopne znamenke.

//	čitavu klasu Solution zalijepiti u Edgar.

	public static Predicate<List<List<Integer>>> allDigitsMatch(double exemplar) {
		return new Predicate<List<List<Integer>>>() {
			
			@Override
			public boolean test(List<List<Integer>> list) {
				for (List<Integer> innerList : list) {
					if (((int)(exemplar * Math.pow(10, innerList.get(0))) % 10) != innerList.get(1))
                  return false;
				}
				return true;
			}

		};

	}

	public static Predicate<List<List<Integer>>> allDigitsDefined(){
        return new Predicate<List<List<Integer>>>() {

			@Override
			public boolean test(List<List<Integer>> list) {
				int max = 0;
				for(List<Integer> innerList : list) {
					if(innerList.get(0) > max) 
						max = innerList.get(0);
				}
				if(list.size() - 1 == max)
					return true;
				return false;
			}
		};   
    }

}
